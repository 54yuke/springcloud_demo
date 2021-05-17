package com.yuke.eurekafeignclient.config;

import org.springframework.stereotype.Component;

/**
 * @program: springcloud_demo
 * @description: HiHystrix
 * @author: Mr.yu
 * @create: 2021-05-11 19:08
 **/
@Component
public class HiHystrix implements EurekaClientFeign {
    @Override
    public String sayHiFromClientEureka(String name) {
        return "Hi " + name + "sorry,error";
    }
}
