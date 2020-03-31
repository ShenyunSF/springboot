package com.example.demo.controller;


import com.example.demo.bean.BaseResponse;
import com.example.demo.mapper.UserMapper;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * created by zhenzhong on 2019/11/23
 */
@RequestMapping("/test")
@RestController
public class UserController
{
    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAll()
    {
        final List<User> users = userMapper.selectAll();
        return users;
    }

    @RequestMapping(value = "/user/getone", method = RequestMethod.GET)
    @ResponseBody
    public String getUserBy(Integer id)
    {
        User user = userMapper.selectByPrimaryKey(id);
        return user.getGender();
    }

    @RequestMapping(value = "/user/insert", method = RequestMethod.GET)
    @ResponseBody
    public BaseResponse getUserBy(User user)
    {
        BaseResponse baseResponse = new BaseResponse();
        try
        {
            userMapper.insert(user);
        }
        catch (Exception e)
        {
            baseResponse.setReturnCode(-1);
            baseResponse.setReturnMessage(e.getCause().getMessage());
            return baseResponse;
        }
        baseResponse.setReturnCode(0);
        baseResponse.setReturnMessage("OK");
        return baseResponse;
    }

    //只需要加上下面这段即可，注意不能忘记注解
    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request)
    {

        //转换日期
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor为自定义日期编辑器
    }

}
