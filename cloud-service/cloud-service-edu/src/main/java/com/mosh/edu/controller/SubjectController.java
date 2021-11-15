package com.mosh.edu.controller;


import com.mosh.edu.entity.vo.subject.SubjectVo;
import com.mosh.edu.service.SubjectService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-10-15
 */
@RestController
@RequestMapping("/edu/subject")
public class SubjectController {

    @Autowired
    SubjectService subjectService;

    @PostMapping("addSubject")
    public ResponseEntity addSubject(MultipartFile file) {

        subjectService.batchImportByExcel(file);
        return ResponseEntity.success();
    }

    @GetMapping("")
    public ResponseEntity nestedList(){
        Collection<SubjectVo> subjectNestedVoList = subjectService.nestedList();
        return ResponseEntity.success().data("items", subjectNestedVoList);
    }
}

