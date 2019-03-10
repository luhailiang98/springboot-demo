package com.sy.controller;

import com.github.pagehelper.Page;
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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public JsonData getAllUser(
            @RequestParam(required = false, name = "pageSize") Integer pageSize,
            @RequestParam(required = false, name = "startIndex") Integer startIndex) {
        PageHelper.startPage(startIndex + 1, pageSize);
        Page<SysUser> userPage = sysUserService.getAllUser();
        PageInfo<SysUser> pageInfo = new PageInfo<>(userPage);
        return JsonData.success(pageInfo, "查询成功");
    }

    @RequestMapping(value = "/userListEasyUi", method = RequestMethod.GET)
    @ResponseBody
    public JsonData getAllUserForEasyui() {
        List<SysUser> sysUser = sysUserService.getAllUserForEasyUi();
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("rows", sysUser);
        resultMap.put("total", sysUser.size());
        return JsonData.success(resultMap, "查询用户成功");
    }

    @ApiOperation(value = "返回hello页面", notes = "返回hello页面")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(ModelMap modelMap) {
        SysUser user = sysUserService.selectUser(111);
        modelMap.addAttribute("user", user);
        return "hello";
    }

    @RequestMapping(value = "/easyUi", method = RequestMethod.GET)
    public String easyUi() {
        return "easyUiTable";
    }
}
