package com.example.demo.utils.objectinstanceof;

/**
 * created by zhenzhong on 2020/1/16
 */
public class ApiResult
{
    /**
     * 错误码，对应{@link ErrorCode}，表示一种错误类型
     * 如果是成功，则code为200
     */
    private int code;

    /**
     * 对错误的具体解释
     */
    private String message;

    /**
     * 返回的结果包装在value中，value可以是单个对象
     */
    private Object value;
    //忽略getter和setter，以及构造函数


    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public Object getValue()
    {
        return value;
    }
}
