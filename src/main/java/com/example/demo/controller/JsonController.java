package com.example.demo.controller;

import com.example.demo.model.FastJsonUser;
import com.example.demo.model.JacksonUser;
import com.example.demo.utils.JacksonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * created by zhenzhong on 2020/9/9
 */
@RestController
@RequestMapping("/json")
public class JsonController
{

    @GetMapping("/jackson")
    public JacksonUser getJacksonUser(){
        final JacksonUser jacksonUser = new JacksonUser();
        jacksonUser.setKey("key");
        jacksonUser.setValue("value");
        return jacksonUser;
    }

    @GetMapping("/jackson/string")
    public String getJacksonUserStr() throws Exception
    {
        final JacksonUser jacksonUser = new JacksonUser();
        jacksonUser.setKey("key");
        jacksonUser.setValue("value");
        return JacksonUtils.obj2json(jacksonUser);
    }

    @GetMapping("/fast")
    public FastJsonUser getFastUser(){
        final FastJsonUser fastJsonUser = new FastJsonUser();
        fastJsonUser.setKey("key");
        fastJsonUser.setValue("value");
        return fastJsonUser;
    }
}
