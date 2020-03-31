package com.example.demo.springevenshandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStartedEvent;
import org.springframework.stereotype.Component;

/**
 * created by zhenzhong on 2019/9/17
 */
@Component
public class CStartEventHandler implements ApplicationListener<ContextStartedEvent>
{
    @Override
    public void onApplicationEvent(ContextStartedEvent event)
    {
        System.out.println("ContextStartedEvent Received");
    }
}
