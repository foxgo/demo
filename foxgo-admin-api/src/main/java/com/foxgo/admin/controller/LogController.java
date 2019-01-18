package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.Log;
import com.foxgo.admin.service.LogService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 日志 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("/log")
public class LogController extends BaseController {
    @Autowired
    private LogService logService;

    @GetMapping("/list")
    @ApiOperation(value = "查询日志列表", notes = "查询日志列表")
    @RequiresPermissions("sys:log:list")
    public Result<IPage<Log>> list(CommonQuery params){
        return success(logService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询日志", notes = "查询日志")
    public Result<Log> detail(@PathVariable int id){
        return success(logService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增日志", notes = "新增日志")
    public Result<Boolean> create(@RequestBody Log log){
        return success(logService.save(log));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改日志", notes = "修改日志")
    public Result<Boolean> update(@RequestBody Log log){
        return success(logService.updateById(log));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除日志", notes = "删除日志")
    public Result<Boolean> delete(@RequestParam int id){
        return success(logService.removeById(id));
    }

}
