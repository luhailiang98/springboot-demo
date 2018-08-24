package com.sy.dao;

import com.sy.model.SysUser;
import java.util.List;

public interface SysUserMapper  {


  int insertSelective(SysUser user);

  int updateByPrimaryKeySelective(SysUser user);

  int deleteByPrimaryKey(Integer userId);

  SysUser selectByPrimaryKey(Integer userId);
}