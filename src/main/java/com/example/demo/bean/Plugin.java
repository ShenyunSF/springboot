package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * created by zhenzhong on 2019/12/5
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Plugin
{
    @JsonProperty("pluginName")
    private String pluginName;

    @JsonProperty("instance")
    private boolean instance;

    public boolean isInstance()
    {
        return instance;
    }

    public void setInstance(boolean instance)
    {
        this.instance = instance;
    }

    @JsonProperty("id")
    private int id;

    @JsonProperty("metrics")
    private List<String> metrics;

    @JsonProperty("runtime")
    private String runtime;

    public String getPluginName()
    {
        return pluginName;
    }

    public void setPluginName(String pluginName)
    {
        this.pluginName = pluginName;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public List<String> getMetrics()
    {
        return metrics;
    }

    public void setMetrics(List<String> metrics)
    {
        this.metrics = metrics;
    }

    public String getRuntime()
    {
        return runtime;
    }

    public void setRuntime(String runtime)
    {
        this.runtime = runtime;
    }
}
