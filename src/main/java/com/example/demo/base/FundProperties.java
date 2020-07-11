package com.example.demo.base;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * created by zhenzhong on 2020/6/23
 */
@Configuration
public class FundProperties
{
    @Value("${fund.url}")
    private String fundUrl;

    @Value("${fund.list.url}")
    private String fundListUrl;

    @Value("${fund.detail.url}")
    private String fundDetailUrl;

    public String getFundDetailUrl()
    {
        return fundDetailUrl;
    }

    public void setFundDetailUrl(String fundDetailUrl)
    {
        this.fundDetailUrl = fundDetailUrl;
    }

    public String getFundListUrl()
    {
        return fundListUrl;
    }

    public void setFundListUrl(String fundListUrl)
    {
        this.fundListUrl = fundListUrl;
    }

    @Value("${fund.id.list}")
    private ArrayList<Integer> fundIdList;

    public String getFundUrl()
    {
        return fundUrl;
    }

    public void setFundUrl(String fundUrl)
    {
        this.fundUrl = fundUrl;
    }

    public ArrayList<Integer> getFundIdList()
    {
        return fundIdList;
    }

    public void setFundIdList(ArrayList<Integer> fundIdList)
    {
        this.fundIdList = fundIdList;
    }
}
