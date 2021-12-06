package com.mosh.edu.controller.front;

import com.mosh.edu.service.SubjectService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 *
 * @author mosh
 * @date 2021/12/5 14:55
 */
@RestController
@RequestMapping("/edu/subject/front")
public class SubjectFrontController {

    @Autowired
    SubjectService subjectService;

    /**
     * 获取树型结构的分类数据
     * @return 树型结构的分类数据
     */
    @GetMapping
    public ResponseEntity nestedList() {
        return ResponseEntity.success().data("items", subjectService.nestedList());
    }
}
