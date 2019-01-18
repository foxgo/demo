package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.Log;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 日志 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface LogService extends IService<Log> {

    IPage<Log> list(CommonQuery params);
}
