package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.User;
import com.foxgo.admin.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("//user")
public class UserController extends BaseController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    @ApiOperation(value = "查询用户列表", notes = "查询用户列表")
    @RequiresPermissions("sys:user:list")
    public Result<IPage<User>> list(CommonQuery params){
        return success(userService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询用户", notes = "查询用户")
    public Result<User> detail(@PathVariable int id){
        return success(userService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增用户", notes = "新增用户")
    public Result<Boolean> create(@RequestBody User user){
        return success(userService.save(user));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改用户", notes = "修改用户")
    public Result<Boolean> update(@RequestBody User user){
        return success(userService.updateById(user));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除用户", notes = "删除用户")
    public Result<Boolean> delete(@RequestParam int id){
        return success(userService.removeById(id));
    }

}
