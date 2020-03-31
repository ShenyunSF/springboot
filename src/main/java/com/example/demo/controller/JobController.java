package com.example.demo.controller;

import com.example.demo.task.DynamicTask;
import com.example.demo.task.ExecutorConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ScheduledFuture;

/**
 * created by zhenzhong on 2019/12/10
 */
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController
{
    @Autowired
    private DynamicTask task;

    @RequestMapping("/task")
    public void test() throws Exception
    {
        // 开启定时任务，对象注解Scope是多利的。
        task.startCron();

    }

    @RequestMapping("/stop")
    public void stop() throws Exception
    {
        // 提前测试用来测试线程1进行对比是否关闭。
        ScheduledFuture scheduledFuture = ExecutorConfig.map.get("http-nio-8081-exec-1");
        scheduledFuture.cancel(true);
        // 查看任务是否在正常执行之前结束,正常true
        boolean cancelled = scheduledFuture.isCancelled();
        while (!cancelled)
        {
            scheduledFuture.cancel(true);
        }
    }

}
