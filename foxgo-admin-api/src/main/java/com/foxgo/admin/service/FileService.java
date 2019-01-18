package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.File;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 文件 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface FileService extends IService<File> {

    IPage<File> list(CommonQuery params);

}
