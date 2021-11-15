package com.mosh.edu.service;

import com.mosh.edu.entity.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mosh.edu.entity.vo.client.ChapterClientVo;
import com.mosh.edu.entity.vo.course.chapter.ChapterVo;
import com.mosh.utils.exception.SaveException;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> getChapterVideo(String courseId);

    void addChapter(ChapterVo chapterVo) throws SaveException;

    void updateChapter(ChapterVo chapterVo);

    ChapterVo getChapter(String id);

    void deleteByCourseId(String courseId);

    List<ChapterClientVo> getClientChapterVideo(String courseId);
}
