package com.sy.service;

import com.github.pagehelper.Page;
import com.sy.model.SysUser;

import java.util.List;


/**
 * @Auther: luhailiang
 * @Date: 2018/8/8 22:33
 * @Description:
 */
public interface SysUserService {

    public void saveUser(SysUser user);

    public void updateUser(SysUser user);

    public void deleteUser(int userId);

    public SysUser selectUser(int userId);

    Page<SysUser> getAllUser();

    List<SysUser> getAllUserForEasyUi();
}
