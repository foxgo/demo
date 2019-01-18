package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.Dept;
import com.foxgo.admin.service.DeptService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 部门 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("/dept")
@Api("DeptController 相关的api")
public class DeptController extends BaseController {

    @Autowired
    private DeptService deptService;

    @GetMapping("/list")
    @ApiOperation(value = "查询部门列表", notes = "查询部门列表")
    public Result<IPage<Dept>> list(CommonQuery params){
        return success(deptService.page(new Page<>(1,20),null));
    }


    @PostMapping("/create")
    @ApiOperation(value = "新增部门", notes = "新增部门")
    public Result<Boolean> create(@RequestBody Dept dept){
        return success(deptService.save(dept));
    }

}
