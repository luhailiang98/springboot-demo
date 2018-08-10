package com.sy.service.Impl;

import com.sy.dao.SysUserMapper;
import com.sy.model.SysUser;
import com.sy.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: luhailiang
 * @Date: 2018/8/8 22:33
 * @Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

  @Autowired
  private SysUserMapper sysUserMapper;

  @Override
  public void saveUser(SysUser user) {
    SysUser sysUser = SysUser.builder().departmentId(user.getDepartmentId())
        .userName(user.getUserName()).userPwd(user.getUserPwd())
        .userPosition(user.getUserPosition()).userPhone(user.getUserPhone())
        .userEmail(user.getUserEmail()).userDisplayOrder(user.getUserDisplayOrder())
        .userNote(user.getUserNote()).build();
    sysUserMapper.insertSelective(sysUser);
  }
}
