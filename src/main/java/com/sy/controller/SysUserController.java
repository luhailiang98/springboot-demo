package com.sy.controller;

import com.sy.model.SysUser;
import com.sy.service.SysUserService;
import com.sy.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auther: luhailiang
 * @Date: 2018/8/9 13:04
 * @Description:
 */
@Controller
@RequestMapping(value = "/user")
public class SysUserController {

  @Autowired
  private SysUserService sysUserService;


  @RequestMapping(value = "/saveUser")
  @ResponseBody
  public JsonData saveUser(SysUser user) {
    sysUserService.saveUser(user);
    return JsonData.success(user,"新增成功");
  }
}
