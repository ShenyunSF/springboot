package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * created by zhenzhong on 2019/12/5
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alert
{
    @JsonProperty("pluginName")
    private String pluginName;

    @JsonProperty("metricName")
    private String metricName;

    @JsonProperty("metricUnit")
    private String metricUnit;

    @JsonProperty("lowerLimitValue")
    private String instance;

    public String getInstance()
    {
        return instance;
    }

    public void setInstance(String instance)
    {
        this.instance = instance;
    }

    @JsonProperty("alertConfig")
    private AlertConfig alertConfig;

    public String getPluginName()
    {
        return pluginName;
    }

    public void setPluginName(String pluginName)
    {
        this.pluginName = pluginName;
    }

    public String getMetricName()
    {
        return metricName;
    }

    public void setMetricName(String metricName)
    {
        this.metricName = metricName;
    }

    public String getMetricUnit()
    {
        return metricUnit;
    }

    public void setMetricUnit(String metricUnit)
    {
        this.metricUnit = metricUnit;
    }


    public AlertConfig getAlertConfig()
    {
        return alertConfig;
    }

    public void setAlertConfig(AlertConfig alertConfig)
    {
        this.alertConfig = alertConfig;
    }
}
