package com.mosh.forum.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mosh.forum.client.InteractionClient;
import com.mosh.forum.entity.Label;
import com.mosh.forum.entity.Question;
import com.mosh.forum.entity.QuestionLabel;
import com.mosh.forum.entity.query.QuestionQuery;
import com.mosh.forum.entity.vo.QuestionVo;
import com.mosh.forum.mapper.LabelMapper;
import com.mosh.forum.mapper.QuestionLabelMapper;
import com.mosh.forum.mapper.QuestionMapper;
import com.mosh.forum.service.QuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.cache.decorators.WeakCache;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 论坛 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements QuestionService {

    @Resource
    QuestionMapper questionMapper;

    @Resource
    QuestionLabelMapper questionLabelMapper;

    @Resource
    LabelMapper labelMapper;

    @Resource
    InteractionClient interactionClient;

    @Override
    public Map<String, Object> getQuestionByPage(Integer current, Integer limit, QuestionQuery query) {
        Page<Question> page = new Page<>(current, limit);
        List<Question> rows = questionMapper.getQuestionByQuery(page, query);
        HashMap<String, Object> map = new HashMap<>();
        map.put("rows", rows);
        map.put("total", page.getTotal());
        return map;
    }

    @Override
    public void addQuestion(QuestionVo questionVo) {
        Question question = new Question();
        BeanUtils.copyProperties(questionVo, question);
        question.setIsDeleted(0);
        question.setStatus("Normal");
        String qid = question.getId();
        if (!StringUtils.isEmpty(qid)) {
            questionMapper.updateById(question);
            questionLabelMapper.delete(new QueryWrapper<QuestionLabel>().eq("question_id", qid));
            for (Label label : questionVo.getLabels()) {
                QuestionLabel questionLabel = new QuestionLabel();
                questionLabel.setQuestionId(qid);
                questionLabel.setLabelId(label.getId());
                questionLabelMapper.insert(questionLabel);
            }
        } else {
            questionMapper.insert(question);
            qid = question.getId();
            for (Label label : questionVo.getLabels()) {
                QuestionLabel questionLabel = new QuestionLabel();
                questionLabel.setQuestionId(qid);
                questionLabel.setLabelId(label.getId());
                questionLabelMapper.insert(questionLabel);
            }
        }


    }

    @Override
    public QuestionVo getQuestionById(String id) {
        Question question = questionMapper.selectById(id);
        QuestionVo questionVo = new QuestionVo();
        BeanUtils.copyProperties(question, questionVo);

        List<QuestionLabel> questionLabels = questionLabelMapper.selectList(new QueryWrapper<QuestionLabel>().eq("question_id", question.getId()));
        List<String> list = new ArrayList<>();
        for (QuestionLabel questionLabel : questionLabels) {
            list.add(questionLabel.getLabelId());
        }

        if (!list.isEmpty()) {
            List<Label> labels = labelMapper.selectList(new QueryWrapper<Label>().in("id", list));
            questionVo.setLabels(labels);
        }

        return questionVo;
    }

    @Override
    public void deleteQuestionById(String questionId) {
        interactionClient.deleteInteraction(questionId);
        questionLabelMapper.delete(new QueryWrapper<QuestionLabel>().eq("question_id", questionId));
        questionMapper.deleteById(questionId);
    }

    @Override
    public Map<String, Object> getQuestionCollectedPageByMemberId(Integer current, Integer limit, String memberId) {
        List<String> questionIds = interactionClient.getCollectedByMemberId(memberId);
        if (questionIds == null || questionIds.isEmpty()) {
            return null;
        }

        Page<Question> page = new Page<>(current, limit);
        questionMapper.selectPage(page, new QueryWrapper<Question>().in("id", questionIds));
        Map<String, Object> map = new HashMap<>();
        map.put("rows", page.getRecords());
        map.put("total", page.getTotal());
        return map;
    }
}
