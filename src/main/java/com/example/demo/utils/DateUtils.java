package com.example.demo.utils;

import org.thymeleaf.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * created by zhenzhong on 2020/3/24
 */
public class DateUtils
{
    public static String getFormatTime(String format)
    {
        String           time;
        SimpleDateFormat simpleDateFormat;
        if (StringUtils.isEmpty(format))
        {
            simpleDateFormat = new SimpleDateFormat("yyyyMMdd hh:MM:SS");
            time             = simpleDateFormat.format(new Date());
        }
        else
        {
            simpleDateFormat = new SimpleDateFormat(format);
            time             = simpleDateFormat.format(format);
        }
        return time;
    }
}
