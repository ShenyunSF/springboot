package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

/**
 * created by zhenzhong on 2019/12/5
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Template extends TemplateBasicInfo implements Serializable
{

    @JsonProperty("plugins")
    List<Plugin> plugins;

    @JsonProperty("alerts")
    List<Alert> alerts;

    public List<Plugin> getPlugins()
    {
        return plugins;
    }

    public void setPlugins(List<Plugin> plugins)
    {
        this.plugins = plugins;
    }

    public List<Alert> getAlerts()
    {
        return alerts;
    }

    public void setAlerts(List<Alert> alerts)
    {
        this.alerts = alerts;
    }
}
