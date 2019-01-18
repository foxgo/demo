package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.Role;
import com.foxgo.admin.service.RoleService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 角色 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-12-26
 */
@RestController
@RequestMapping("//role")
public class RoleController extends BaseController {
    @Autowired
    private RoleService roleService;

    @GetMapping("/list")
    @ApiOperation(value = "查询角色列表", notes = "查询角色列表")
    @RequiresPermissions("sys:role:list")
    public Result<IPage<Role>> list(CommonQuery params){
        return success(roleService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询角色", notes = "查询角色")
    public Result<Role> detail(@PathVariable int id){
        return success(roleService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增角色", notes = "新增角色")
    public Result<Boolean> create(@RequestBody Role role){
        return success(roleService.save(role));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改角色", notes = "修改角色")
    public Result<Boolean> update(@RequestBody Role role){
        return success(roleService.updateById(role));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除角色", notes = "删除角色")
    public Result<Boolean> delete(@RequestParam int id){
        return success(roleService.removeById(id));
    }

}
