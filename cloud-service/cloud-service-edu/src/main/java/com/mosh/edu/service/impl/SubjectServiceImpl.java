package com.mosh.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.edu.entity.Subject;
import com.mosh.edu.entity.excel.ExcelSubject;
import com.mosh.edu.entity.vo.subject.SubjectVo;
import com.mosh.edu.listener.ExcelSubjectListener;
import com.mosh.edu.mapper.SubjectMapper;
import com.mosh.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.util.*;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-10-15
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Resource
    SubjectMapper subjectMapper;

    public void batchImportByExcel(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), ExcelSubject.class, new ExcelSubjectListener(this)).sheet("Sheet1").doRead();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Collection<SubjectVo> nestedList() {
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        queryWrapper.orderByAsc("sort", "id");
        List<Subject> oneSubjects = subjectMapper.selectList(queryWrapper);

        QueryWrapper<Subject> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.ne("parent_id", 0);
        queryWrapper2.orderByAsc("sort", "id");
        List<Subject> twoSubjects = subjectMapper.selectList(queryWrapper2);


        Map<String, SubjectVo> map = new HashMap<>();

        for (Subject oneSubject : oneSubjects) {
            map.put(oneSubject.getId(), oneSubject.simplify());
        }

        try {
            for (Subject twoSubject : twoSubjects) {
                map.get(twoSubject.getParentId()).addChildren(twoSubject.simplify());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return map.values();
    }
}
