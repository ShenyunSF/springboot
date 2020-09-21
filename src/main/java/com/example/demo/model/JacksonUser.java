package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.extern.slf4j.Slf4j;

/**
 * created by zhenzhong on 2020/9/9
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class JacksonUser
{
    @JsonProperty("key_test")
    private String key;

    @JsonProperty("value_test")
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
