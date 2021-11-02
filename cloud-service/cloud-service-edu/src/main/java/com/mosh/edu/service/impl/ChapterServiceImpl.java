package com.mosh.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mosh.edu.entity.Chapter;
import com.mosh.edu.entity.Course;
import com.mosh.edu.entity.CourseDescription;
import com.mosh.edu.entity.Video;
import com.mosh.edu.entity.vo.course.chapter.ChapterVo;
import com.mosh.edu.entity.vo.course.video.VideoVo;
import com.mosh.edu.mapper.ChapterMapper;
import com.mosh.edu.mapper.VideoMapper;
import com.mosh.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mosh.utils.exception.SaveException;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Resource
    ChapterMapper chapterMapper;

    @Resource
    VideoMapper videoMapper;

    @Override
    public List<ChapterVo> getChapterVideo(String courseId) {
        ArrayList<ChapterVo> list = new ArrayList<>();

        QueryWrapper<Chapter> chapterWrapper = new QueryWrapper<>();
        chapterWrapper.eq("course_id", courseId);
        List<Chapter> chapters = chapterMapper.selectList(chapterWrapper);

        QueryWrapper<Video> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id", courseId);
        List<Video> videos = videoMapper.selectList(videoWrapper);

        for (Chapter chapter : chapters) {
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            for (Video video : videos) {
                if (video.getChapterId().equals(chapter.getId())) {
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    chapterVo.getChildren().add(videoVo);
                }
            }
            list.add(chapterVo);
        }

        return list;
    }

    @Override
    public void addChapter(ChapterVo chapterVo) throws SaveException {
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterVo, chapter);


        if (chapterMapper.insert(chapter) == 0) {
            throw new SaveException();
        }

    }

    @Override
    public void updateChapter(ChapterVo chapterVo) {
        Chapter chapter = new Chapter();
        BeanUtils.copyProperties(chapterVo, chapter);

        chapterMapper.updateById(chapter);
    }

    @Override
    public ChapterVo getChapter(String id) {
        ChapterVo chapterVo = new ChapterVo();
        BeanUtils.copyProperties(chapterMapper.selectById(id), chapterVo);
        return chapterVo;
    }

    @Override
    public void deleteByCourseId(String courseId) {
        QueryWrapper<Chapter> wrapper = new QueryWrapper<>();
        wrapper.eq("course_id", courseId);
        chapterMapper.delete(wrapper);
    }

}
