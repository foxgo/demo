package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.Menu;
import com.foxgo.admin.service.MenuService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 菜单 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("//menu")
public class MenuController extends BaseController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/list")
    @ApiOperation(value = "查询菜单列表", notes = "查询菜单列表")
    // @RequiresPermissions("sys:menu:list")
    public Result<IPage<Menu>> list(CommonQuery params){
        return success(menuService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询菜单", notes = "查询菜单")
    public Result<Menu> detail(@PathVariable int id){
        return success(menuService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增菜单", notes = "新增菜单")
    public Result<Boolean> create(@RequestBody Menu menu){
        return success(menuService.save(menu));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改菜单", notes = "修改菜单")
    public Result<Boolean> update(@RequestBody Menu menu){
        return success(menuService.updateById(menu));
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除菜单", notes = "删除菜单")
    public Result<Boolean> delete(@RequestParam int id){
        return success(menuService.removeById(id));
    }

}
