package com.mosh.statistics.scheduler;

import com.mosh.statistics.service.DailyService;
import com.mosh.statistics.utils.DateUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * Description
 *
 * @author mosh
 * @date 2021/11/11 18:44
 */
@Component
public class CollectDataScheduler {

    @Resource
    DailyService dailyService;

    @Scheduled(cron = "0 0 1 * * ?")
    public void collectData() {
        dailyService.registerCount(DateUtil.formatDate(DateUtil.addDays(new Date(), -1)));

    }

}
