package com.yuke.eurekaclient.api;

import com.yuke.eurekaclient.entity.UserInfo;
import com.yuke.eurekaclient.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: springcloud_demo
 * @description: Test
 * @author: Mr.yu
 * @create: 2021-05-10 21:03
 **/
@RestController
public class HelloWorldController {
    @Autowired
    private UserInfoService userInfoService;
    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
    public String test(String name){
        return "My name is "+name+" ,I from port:";
    }

    @RequestMapping(value = "/selectByPrimaryKey" , method = RequestMethod.GET)
    public UserInfo selectByPrimaryKey(Integer id){
        UserInfo userInfo= userInfoService.selectByPrimaryKey(id);
        return  userInfo;
    }


}
