package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.Config;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 配置 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface ConfigService extends IService<Config> {


    /**
     * @param params
     * @return
     */
    IPage<Config> list(CommonQuery params);
}
