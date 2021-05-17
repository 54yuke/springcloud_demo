package com.yuke.eurekafeignclient.api;

import com.yuke.eurekafeignclient.service.HiService;
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
    HiService hiService;
    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
    public String test(String name){

        return hiService.sayHi(name);
    }
}
