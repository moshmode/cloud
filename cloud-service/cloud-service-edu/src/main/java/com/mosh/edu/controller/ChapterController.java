package com.mosh.edu.controller;


import com.mosh.edu.entity.vo.course.chapter.ChapterVo;
import com.mosh.edu.service.ChapterService;
import com.mosh.utils.exception.SaveException;
import com.mosh.utils.response.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-10-25
 */
@CrossOrigin
@RestController
@RequestMapping("/edu/chapter")
public class ChapterController {

    @Resource
    ChapterService chapterService;

    @GetMapping("all/{id}")
    public ResponseEntity getChapterVideo(@PathVariable("id") String courseId) {
        List<ChapterVo> list = chapterService.getChapterVideo(courseId);
        return ResponseEntity.success().data("chapterList", list);
    }

    @GetMapping("{id}")
    public ResponseEntity getChapter(@PathVariable("id") String id) {
        ChapterVo chapterVo = chapterService.getChapter(id);
        return ResponseEntity.success().data("chapterVo", chapterVo);
    }

    @PostMapping
    public ResponseEntity addChapter(@RequestBody ChapterVo chapterVo) throws SaveException {
        chapterService.addChapter(chapterVo);
        return ResponseEntity.success();
    }

    @PutMapping
    public ResponseEntity updateChapter(@RequestBody ChapterVo chapterVo) {
        chapterService.updateChapter(chapterVo);
        return ResponseEntity.success();
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteChapter(@PathVariable("id") String id) {
        chapterService.removeById(id);
        return ResponseEntity.success();
    }
}

