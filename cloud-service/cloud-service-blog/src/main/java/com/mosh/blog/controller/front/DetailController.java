package com.mosh.blog.controller.front;


import com.mosh.blog.entity.Detail;
import com.mosh.blog.entity.vo.DetailVo;
import com.mosh.blog.service.DetailService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 博客 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-15
 */
@RestController
@RequestMapping("/blog/detail/front")
public class DetailController {

    @Resource
    DetailService detailService;

    @GetMapping("vo/{blogId}")
    public ResponseEntity getDetailVoByBlogId(@PathVariable("blogId") String blogId) {
        DetailVo detailVo = detailService.getDetailByBlogId(blogId);
        return ResponseEntity.success().data("detail", detailVo);
    }

    @GetMapping("{id}")
    public ResponseEntity getDetail(@PathVariable("id") String id) {
        Detail detail = detailService.getById(id);
        return ResponseEntity.success().data("detail", detail);
    }

    @PostMapping
    public ResponseEntity addDetail(@RequestBody Detail detail) {
        String id = detailService.addDetail(detail);
        return ResponseEntity.success().data("detailId", id);
    }

    @PostMapping("draft/page/{current}/{limit}")
    public ResponseEntity getDraftListByPage(@PathVariable("current") Integer current,
                                             @PathVariable("limit") Integer limit,
                                             @RequestBody Detail detail) {
        return ResponseEntity.success().data(detailService.getDraftListByPage(current, limit, detail));
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteDetailById(@PathVariable("id") String id) {
        detailService.removeById(id);
        return ResponseEntity.success();
    }
}

