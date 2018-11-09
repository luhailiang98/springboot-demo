package com.sy.service.Impl;

import com.github.pagehelper.Page;
import com.google.common.base.Preconditions;
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

    @Override
    public void updateUser(SysUser user) {
        SysUser sysUser = SysUser.builder().userId(user.getUserId()).departmentId(user.getDepartmentId())
                .userName(user.getUserName()).userPwd(user.getUserPwd())
                .userPosition(user.getUserPosition()).userPhone(user.getUserPhone())
                .userEmail(user.getUserEmail()).userDisplayOrder(user.getUserDisplayOrder())
                .userNote(user.getUserNote()).build();
        sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

    @Override
    public void deleteUser(int userId) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        Preconditions.checkNotNull(user, "需删除的用户不存在");
        sysUserMapper.deleteByPrimaryKey(userId);
    }

    @Override
    public SysUser selectUser(int userId) {
        SysUser user = sysUserMapper.selectByPrimaryKey(userId);
        return user;
    }

    @Override
    public Page<SysUser> getAllUser() {
        return sysUserMapper.getAllUser();
    }
}
