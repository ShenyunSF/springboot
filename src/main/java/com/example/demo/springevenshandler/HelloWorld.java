package com.example.demo.springevenshandler;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

/**
 * created by zhenzhong on 2019/9/17
 */
@SpringBootApplication
public class HelloWorld
{
    private String message;

    public String getMessage()
    {
        return "new message";
    }

    public void setMessage(String message)
    {
        this.message = message;
    }
}
