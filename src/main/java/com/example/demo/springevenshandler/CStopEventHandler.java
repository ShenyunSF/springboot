package com.example.demo.springevenshandler;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextStoppedEvent;
import org.springframework.stereotype.Component;

/**
 * created by zhenzhong on 2019/9/17
 */
@Component
public class CStopEventHandler implements ApplicationListener<ContextStoppedEvent>
{
    @Override
    public void onApplicationEvent(ContextStoppedEvent event)
    {
        System.out.println("ContextStopEvent Received");
    }
}
