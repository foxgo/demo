package com.foxgo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.page.PageUtil;
import com.foxgo.admin.common.util.StringUtil;
import com.foxgo.admin.entity.File;
import com.foxgo.admin.mapper.FileMapper;
import com.foxgo.admin.service.FileService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文件 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class FileServiceImpl extends ServiceImpl<FileMapper, File> implements FileService {

    @Override
    public IPage<File> list(CommonQuery params) {
        QueryWrapper<File> queryWrapper=new QueryWrapper<>();
        if(StringUtil.isNotBlank(params.getName())){
            queryWrapper.lambda().likeRight(File::getType,params.getName());
        }
        return page(PageUtil.buildPage(params),queryWrapper);
    }
}
