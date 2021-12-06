package com.mosh.interaction.controller.front;


import com.mosh.interaction.entity.ViewInteraction;
import com.mosh.interaction.service.ViewInteractionService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 关注 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-12-03
 */
@RestController
@RequestMapping("/interaction/view/front")
public class ViewInteractionController {

    @Resource
    ViewInteractionService viewInteractionService;

    /**
     * 分页获取用户所关注的用户
     *
     * @param current      当前页
     * @param limit        页大小
     * @param fromMemberId 用户id
     * @return 所关注的用户分页列表和总数
     */
    @GetMapping("{current}/{limit}/{fromMemberId}")
    public ResponseEntity getViewByPage(@PathVariable("current") Integer current,
                                        @PathVariable("limit") Integer limit,
                                        @PathVariable("fromMemberId") String fromMemberId) {
        return ResponseEntity.success().data(viewInteractionService.getViewByPage(current, limit, fromMemberId));
    }

    @DeleteMapping("{memberId}/{fromMemberId}")
    public ResponseEntity cancelView(@PathVariable("memberId") String memberId,
                                     @PathVariable("fromMemberId") String fromMemberId) {
        viewInteractionService.cancelView(memberId, fromMemberId);
        return ResponseEntity.success();
    }

    @PostMapping
    public ResponseEntity addView(@RequestBody ViewInteraction viewInteraction) {
        viewInteractionService.save(viewInteraction);
        return ResponseEntity.success();
    }

    @GetMapping("{memberId}/{fromMemberId}")
    public ResponseEntity getView(@PathVariable("memberId") String memberId,
                                  @PathVariable("fromMemberId") String fromMemberId) {
        return ResponseEntity.success().data("view", viewInteractionService.getView(memberId, fromMemberId));
    }


}

