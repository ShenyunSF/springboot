package com.example.demo.bean;

/**
 * created by zhenzhong on 2019/12/5
 */
public class BaseResponse
{
    private String returnMessage;

    private int returnCode;

    private Object data;

    public String getReturnMessage()
    {
        return returnMessage;
    }

    public void setReturnMessage(String returnMessage)
    {
        this.returnMessage = returnMessage;
    }

    public int getReturnCode()
    {
        return returnCode;
    }

    public void setReturnCode(int returnCode)
    {
        this.returnCode = returnCode;
    }

    public Object getData()
    {
        return data;
    }

    public void setData(Object data)
    {
        this.data = data;
    }
}
