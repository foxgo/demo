package com.foxgo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.page.PageUtil;
import com.foxgo.admin.entity.Config;
import com.foxgo.admin.mapper.ConfigMapper;
import com.foxgo.admin.service.ConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxgo.admin.common.util.StringUtil;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 配置 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class ConfigServiceImpl extends ServiceImpl<ConfigMapper, Config> implements ConfigService {

    @Override
    public IPage<Config> list(CommonQuery params) {
        QueryWrapper<Config> queryWrapper=new QueryWrapper<>();
        if(StringUtil.isNotBlank(params.getName())){
            queryWrapper.lambda().likeRight(Config::getItemKey,params.getName());
        }
        return page(PageUtil.buildPage(params),queryWrapper);
    }
}
