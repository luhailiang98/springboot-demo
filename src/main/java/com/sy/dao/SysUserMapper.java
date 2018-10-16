package com.sy.dao;

import com.sy.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SysUserMapper {


    int insertSelective(SysUser user);

    int updateByPrimaryKeySelective(SysUser user);

    int deleteByPrimaryKey(Integer userId);

    SysUser selectByPrimaryKey(Integer userId);

    List<SysUser> getAllUser();

}