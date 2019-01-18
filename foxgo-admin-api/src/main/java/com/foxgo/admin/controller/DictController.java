package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.Dict;
import com.foxgo.admin.service.DictService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.foxgo.admin.controller.BaseController;

/**
 * <p>
 * 字典 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("/dict")
public class DictController extends BaseController {

    @Autowired
    private DictService dictService;

    @GetMapping("/list")
    @ApiOperation(value = "查询字典列表", notes = "查询字典列表")
    @RequiresPermissions("sys:dict:list")
    public Result<IPage<Dict>> list(CommonQuery params){
        return success(dictService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询字典", notes = "查询字典")
    public Result<Dict> detail(@PathVariable int id){
        return success(dictService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增字典", notes = "新增字典")
    public Result<Boolean> create(@RequestBody Dict Dict){
        return success(dictService.save(Dict));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改字典", notes = "修改字典")
    public Result<Boolean> update(@RequestBody Dict Dict){
        return success(dictService.updateById(Dict));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除字典", notes = "删除字典")
    public Result<Boolean> delete(@RequestParam int id){
        return success(dictService.removeById(id));
    }
}
