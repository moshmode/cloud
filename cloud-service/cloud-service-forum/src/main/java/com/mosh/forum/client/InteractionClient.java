package com.mosh.forum.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Description
 * 问题互动关系客户端
 *
 * @author mosh
 * @date 2021/11/24 15:28
 */
@FeignClient(name = "cloud-service-interaction")
@Component
public interface InteractionClient {

    /**
     * 根据问题id删除该问题所有互动关系
     *
     * @param questionId 问题id
     * @return 删除的互动条数
     */
    @DeleteMapping("/interaction/question/feign/{questionId}")
    Integer deleteInteraction(@PathVariable("questionId") String questionId);

    /**
     * 根据用户id获取其收藏的所有问题id
     *
     * @param memberId 用户id
     * @return 问题id列表
     */
    @GetMapping("/interaction/question/feign/collected/{memberId}")
    List<String> getCollectedByMemberId(@PathVariable("memberId") String memberId);
}
