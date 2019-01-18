package com.foxgo.admin.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.File;
import com.foxgo.admin.service.FileService;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 文件 前端控制器
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@RestController
@RequestMapping("//file")
public class FileController extends BaseController {

    @Autowired
    private FileService fileService;

    @GetMapping("/list")
    @ApiOperation(value = "查询文件列表", notes = "查询文件列表")
    @RequiresPermissions("sys:file:list")
    public Result<IPage<File>> list(CommonQuery params){
        return success(fileService.list(params));
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "查询文件", notes = "查询文件")
    public Result<File> detail(@PathVariable int id){
        return success(fileService.getById(id));
    }

    @PostMapping("/create")
    @ApiOperation(value = "新增文件", notes = "新增文件")
    public Result<Boolean> create(@RequestBody File file){
        return success(fileService.save(file));
    }


    @PostMapping("/update")
    @ApiOperation(value = "修改文件", notes = "修改文件")
    public Result<Boolean> update(@RequestBody File file){
        return success(fileService.updateById(file));
    }

    @DeleteMapping("/delete")
    @ApiOperation(value = "删除文件", notes = "删除文件")
    public Result<Boolean> delete(@RequestParam int id){
        return success(fileService.removeById(id));
    }

}
