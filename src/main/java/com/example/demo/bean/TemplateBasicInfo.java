package com.example.demo.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * created by zhenzhong on 2019/12/5
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TemplateBasicInfo
{
    @JsonProperty("templateId")
    private String templateId;

    @JsonProperty("templateName")
    private String templateName;

    @JsonProperty("scopeName")
    private String scopeName;

    @JsonProperty("type")
    private String type;

    @JsonProperty("serviceName")
    private String serviceName;

    @JsonProperty("status")
    private String status;

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getTemplateId()
    {
        return templateId;
    }

    public void setTemplateId(String templateId)
    {
        this.templateId = templateId;
    }

    public String getTemplateName()
    {
        return templateName;
    }

    public void setTemplateName(String templateName)
    {
        this.templateName = templateName;
    }

    public String getScopeName()
    {
        return scopeName;
    }

    public void setScopeName(String scopeName)
    {
        this.scopeName = scopeName;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getServiceName()
    {
        return serviceName;
    }

    public void setServiceName(String serviceName)
    {
        this.serviceName = serviceName;
    }
}
