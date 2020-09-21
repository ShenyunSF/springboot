package com.example.demo.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * created by zhenzhong on 2020/9/9
 */
public class FastJsonUser
{
    @JSONField(name="fast_key")
    private String key;

    @JSONField(name="fast_value")
    private String value;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public String getValue()
    {
        return value;
    }

    public void setValue(String value)
    {
        this.value = value;
    }
}
