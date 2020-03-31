package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * created by zhenzhong on 2019/12/5
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertConfig
{
    @JsonProperty("lowerLimitValue")
    private String lowerLimitValue;

    @JsonProperty("upperLimitValue")
    private String upperLimitValue;

    @JsonProperty("logic")
    private String logic;

    public String getLogic()
    {
        return logic;
    }

    public void setLogic(String logic)
    {
        this.logic = logic;
    }

    @JsonProperty("expr")
    private String expr;

    @JsonProperty("timeUnit")
    private String timeUnit;

    @JsonProperty("level")
    private String level;

    @JsonProperty("alertName")
    private String alertName;

    @JsonProperty("status")
    private String status;

    @JsonProperty("startTime")
    private String startTime;

    @JsonProperty("endTime")
    private String endTime;

    @JsonProperty("duration")
    private int duration;

    public String getLowerLimitValue()
    {
        return lowerLimitValue;
    }

    public void setLowerLimitValue(String lowerLimitValue)
    {
        this.lowerLimitValue = lowerLimitValue;
    }

    public String getUpperLimitValue()
    {
        return upperLimitValue;
    }

    public void setUpperLimitValue(String upperLimitValue)
    {
        this.upperLimitValue = upperLimitValue;
    }

    public String getExpr()
    {
        return expr;
    }

    public void setExpr(String expr)
    {
        this.expr = expr;
    }

    public String getTimeUnit()
    {
        return timeUnit;
    }

    public void setTimeUnit(String timeUnit)
    {
        this.timeUnit = timeUnit;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getAlertName()
    {
        return alertName;
    }

    public void setAlertName(String alertName)
    {
        this.alertName = alertName;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStartTime()
    {
        return startTime;
    }

    public void setStartTime(String startTime)
    {
        this.startTime = startTime;
    }

    public String getEndTime()
    {
        return endTime;
    }

    public void setEndTime(String endTime)
    {
        this.endTime = endTime;
    }

    public int getDuration()
    {
        return duration;
    }

    public void setDuration(int duration)
    {
        this.duration = duration;
    }
}
