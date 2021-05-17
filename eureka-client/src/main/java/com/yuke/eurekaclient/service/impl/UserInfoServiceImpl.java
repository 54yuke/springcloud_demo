package com.yuke.eurekaclient.service.impl;

import com.yuke.eurekaclient.config.RedisUtils;
import com.yuke.eurekaclient.entity.UserInfo;
import com.yuke.eurekaclient.mapper.UserInfoMapper;
import com.yuke.eurekaclient.service.UserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class UserInfoServiceImpl implements UserInfoService {
    public static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RedisUtils redisUtils;
    @Override
    public UserInfo selectByPrimaryKey(Integer id) {
        UserInfo userInfo = null;
        //查询缓存中是否存在
        boolean hasKey = redisUtils.exists(id.toString());
        String str = "";
        if(hasKey){
            //获取缓存
            Object object =  redisUtils.get(id.toString());
            log.info("从缓存获取的数据"+ object);
            userInfo = (UserInfo) object;
        }else{
            //从数据库中获取信息
            log.info("从数据库中获取数据");
            userInfo= userInfoMapper.selectByPrimaryKey(id);
            //数据插入缓存（set中的参数含义：key值，user对象，缓存存在时间10（long类型），时间单位）
            redisUtils.set(id.toString(),userInfo,10L, TimeUnit.MINUTES);
            log.info("数据插入缓存" + userInfo.toString());
        }




        return userInfo;
    }
}
