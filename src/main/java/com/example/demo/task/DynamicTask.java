package com.example.demo.task;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.ScheduledFuture;

/**
 * created by zhenzhong on 2020/3/25
 */
@Component
@Scope("prototype")
public class DynamicTask
{
    @Autowired
    private UserMapper UserMapper;

    @Autowired
    private ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private ScheduledFuture future;

    private String cron;

    public void startCron()
    {
        cron = "0 0/2 * * * ?";
        System.out.println(Thread.currentThread().getName());
        String name = Thread.currentThread().getName();
        future = threadPoolTaskScheduler.schedule(new myTask(name), new CronTrigger(cron));
        ExecutorConfig.map.put(name, future);
    }

    public void stop()
    {
        if (future != null)
        {
            future.cancel(true);
        }
    }

    private class myTask implements Runnable
    {
        private String name;

        myTask(String name)
        {
            this.name = name;
        }

        @Override
        public void run()
        {
            final List<User> users = UserMapper.selectAll();
            for (User user : users)
            {
                if ("delete".equals(user.getStatus()))
                {
                    UserMapper.deleteByPrimaryKey(user.getId());
                }
            }
        }
    }
}
