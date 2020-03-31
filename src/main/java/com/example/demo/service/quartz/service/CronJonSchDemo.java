package com.example.demo.service.quartz.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by zhenzhong on 2019/12/10
 */
@Component
public class CronJonSchDemo
{
    @Scheduled(cron = "0,15,20 * * * * ?")
    public void cronJobSch()
    {
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        final Date             date             = new Date();
        final String           format           = simpleDateFormat.format(date);
        System.out.println("Java cron job expression:: " + format);
    }
}
