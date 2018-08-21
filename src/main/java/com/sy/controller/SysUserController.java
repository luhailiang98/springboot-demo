package com.sy.controller;

import com.sy.model.SysUser;
import com.sy.service.SysUserService;
import com.sy.utils.JsonData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: luhailiang
 * @Date: 2018/8/9 13:04
 * @Description:
 */
@RestController
@RequestMapping(value = "/user")
public class SysUserController {

  @Autowired
  private SysUserService sysUserService;


  @ApiOperation(value = "创建用户", notes = "根据User对象创建用户")
  @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
  public JsonData saveUser(SysUser user) {
    sysUserService.saveUser(user);
    return JsonData.success(user, "新增成功");
  }
}
