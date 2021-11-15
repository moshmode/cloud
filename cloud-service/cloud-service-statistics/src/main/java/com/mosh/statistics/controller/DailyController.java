package com.mosh.statistics.controller;


import com.mosh.statistics.service.DailyService;
import com.mosh.utils.response.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 网站统计日数据 前端控制器
 * </p>
 *
 * @author mosh
 * @since 2021-11-11
 */
@RestController
@RequestMapping("/statistics/daily")
public class DailyController {
    @Resource
    private DailyService dailyService;

    //统计某一天注册人数,生成统计数据
    @GetMapping("register/{day}")
    public ResponseEntity registerCount(@PathVariable("day") String day) {
        dailyService.registerCount(day);
        return ResponseEntity.success();
    }

    //图表显示，返回两部分数据，日期json数组，数量json数组
    @GetMapping("data/{type}/{begin}/{end}")
    public ResponseEntity getData(@PathVariable String type,@PathVariable String begin,
                      @PathVariable String end) {
        Map<String,Object> map = dailyService.getShowData(type,begin,end);
        return ResponseEntity.success().data(map);
    }
}

