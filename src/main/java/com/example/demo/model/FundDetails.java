package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * created by zhenzhong on 2020/6/23
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FundDetails
{
//{"fundcode":"161030","name":"富国中证体育产业指数分级","jzrq":"2020-06-22","dwjz":"1.0890","gsz":"1.1249","gszzl":"3.30",
// "gztime":"2020-06-23 15:00"}
   @JsonProperty("fundcode")
    private int fundCode;

    @JsonProperty("name")
    private String name;

    @JsonProperty("jzrq")
    private String stopDate;

    @JsonProperty("dwjz")
    private int lastDayPerPureValue;

    @JsonProperty("gsz")
    private int assumeTodayPerPureValue;

    @JsonProperty("gszzl")
    private int assumeGrowPercentage;

    @JsonProperty("gztime")
    private int recodeTime;

    public int getFundCode()
    {
        return fundCode;
    }

    public void setFundCode(int fundCode)
    {
        this.fundCode = fundCode;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getStopDate()
    {
        return stopDate;
    }

    public void setStopDate(String stopDate)
    {
        this.stopDate = stopDate;
    }

    public int getLastDayPerPureValue()
    {
        return lastDayPerPureValue;
    }

    public void setLastDayPerPureValue(int lastDayPerPureValue)
    {
        this.lastDayPerPureValue = lastDayPerPureValue;
    }

    public int getAssumeTodayPerPureValue()
    {
        return assumeTodayPerPureValue;
    }

    public void setAssumeTodayPerPureValue(int assumeTodayPerPureValue)
    {
        this.assumeTodayPerPureValue = assumeTodayPerPureValue;
    }

    public int getAssumeGrowPercentage()
    {
        return assumeGrowPercentage;
    }

    public void setAssumeGrowPercentage(int assumeGrowPercentage)
    {
        this.assumeGrowPercentage = assumeGrowPercentage;
    }

    public int getRecodeTime()
    {
        return recodeTime;
    }

    public void setRecodeTime(int recodeTime)
    {
        this.recodeTime = recodeTime;
    }
}
