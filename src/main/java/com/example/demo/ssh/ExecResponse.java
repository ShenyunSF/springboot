package com.example.demo.ssh;

/**
 * created by zhenzhong on 2020/7/18
 */
public class ExecResponse
{
    private Integer returnCode;

    private String returnMsg;

    public ExecResponse()
    {
    }

    public ExecResponse(Integer returnCode, String returnMsg)
    {
        this.returnCode = returnCode;
        this.returnMsg  = returnMsg;
    }

    public ExecResponse(Integer returnCode)
    {
        this.returnCode = returnCode;
    }

    public Integer getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(Integer returnCode)
    {
        this.returnCode = returnCode;
    }

    public String getReturnMsg()
    {
        return returnMsg;
    }

    public void setReturnMsg(String returnMsg)
    {
        this.returnMsg = returnMsg;
    }
}
