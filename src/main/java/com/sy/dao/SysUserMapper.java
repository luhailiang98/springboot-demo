package com.sy.dao;

import com.github.pagehelper.Page;
import com.sy.model.SysUser;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface SysUserMapper {


    int insertSelective(SysUser user);

    int updateByPrimaryKeySelective(SysUser user);

    int deleteByPrimaryKey(Integer userId);

    SysUser selectByPrimaryKey(Integer userId);

    Page<SysUser> getAllUser();

}