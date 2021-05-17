package com.yuke.eurekafeignclient.config;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by fangzhipeng on 2017/6/21.
 */
@FeignClient(value = "eureka-client",configuration = FeignConfig.class,fallback = HiHystrix.class)
public interface EurekaClientFeign {
    @RequestMapping(value = "/hi" , method = RequestMethod.GET)
    String sayHiFromClientEureka(@RequestParam(value = "name") String name);
}
