package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 字典 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface DictService extends IService<Dict> {

    IPage<Dict> list(CommonQuery params);

}
