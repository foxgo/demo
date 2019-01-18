package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.Config;
import com.foxgo.admin.service.ConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 配置 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("/config")
@Api("ConfigController相关的api")
public class ConfigController extends BaseController {

    @Autowired
    private ConfigService configService;

    @GetMapping("/list")
    @ApiOperation(value = "查询配置项列表", notes = "查询配置项列表")
    @RequiresPermissions("sys:config:list")
    public Result<IPage<Config>> list(CommonQuery params){
        return success(configService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询配置项", notes = "查询配置项")
    public Result<Config> detail(@PathVariable int id){
        return success(configService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增配置项", notes = "新增配置项")
    public Result<Boolean> create(@RequestBody Config config){
        return success(configService.save(config));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改配置项", notes = "修改配置项")
    public Result<Boolean> update(@RequestBody Config config){
        return success(configService.updateById(config));
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除配置项", notes = "删除配置项")
    public Result<Boolean> delete(@RequestParam int id){
        return success(configService.removeById(id));
    }

}
