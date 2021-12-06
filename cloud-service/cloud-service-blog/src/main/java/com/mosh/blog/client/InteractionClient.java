package com.mosh.blog.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Description
 * 博客互动关系客户端
 *
 * @author mosh
 * @date 2021/11/24 15:28
 */
@FeignClient(name = "cloud-service-interaction")
@Component
public interface InteractionClient {

    /**
     * 根据博客id删除该博客所有互动关系
     *
     * @param blogId 博客id
     * @return 删除的互动条数
     */
    @DeleteMapping("/interaction/blog/feign/{blogId}")
    Integer deleteInteraction(@PathVariable("blogId") String blogId);

    /**
     * 根据用户id获取其收藏的所有博客id
     *
     * @param memberId 用户id
     * @return 博客id列表
     */
    @GetMapping("/interaction/blog/feign/collected/{memberId}")
    List<String> getCollectedByMemberId(@PathVariable("memberId") String memberId);
}
