package com.sy.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sy.model.SysUser;
import com.sy.service.SysUserService;
import com.sy.utils.JsonData;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: luhailiang
 * @Date: 2018/8/9 13:04
 * @Description:
 */
@Controller
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;


    @ApiOperation(value = "创建用户", notes = "根据SysUser对象创建用户")
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public JsonData saveUser(SysUser user) {
        sysUserService.saveUser(user);
        return JsonData.success(user, "新增成功");
    }

    @ApiOperation(value = "更新用户", notes = "根据SysUserPrimaryKey更新用户")
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    @ResponseBody
    public JsonData updateUser(SysUser user) {
        sysUserService.updateUser(user);
        return JsonData.success(user, "更新成功");
    }

    @ApiOperation(value = "删除用户", notes = "根据userId删除用户")
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonData deleteUser(@PathVariable(value = "userId") int userId) {
        sysUserService.deleteUser(userId);
        return JsonData.success(userId, "删除成功");
    }


    @ApiOperation(value = "查询所有用户", notes = "查询所有用户及用户所在部门")
    @RequestMapping(value = "/userList", method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAllUser(@RequestParam(required = false, defaultValue = "1") Integer startPage,
                               @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        PageHelper.startPage(startPage, pageSize);
        List<SysUser> users = new ArrayList<>();
        users = sysUserService.getAllUser();
        PageInfo<SysUser> pageInfo = new PageInfo<>(users);
        return JsonData.success(pageInfo, "查询成功");
    }

    @ApiOperation(value = "返回hello页面", notes = "返回hello页面")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        SysUser user = sysUserService.selectUser(111);
        modelMap.addAttribute("user", user);
        return "hello";
    }


}
