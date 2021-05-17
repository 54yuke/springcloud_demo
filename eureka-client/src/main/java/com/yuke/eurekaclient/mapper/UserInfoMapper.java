package com.yuke.eurekaclient.mapper;


import com.yuke.eurekaclient.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface UserInfoMapper {
    UserInfo selectByPrimaryKey(Integer id);
}