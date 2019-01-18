package com.foxgo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.page.PageUtil;
import com.foxgo.admin.common.util.StringUtil;
import com.foxgo.admin.entity.Log;
import com.foxgo.admin.mapper.LogMapper;
import com.foxgo.admin.service.LogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 日志 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements LogService {

    @Override
    public IPage<Log> list(CommonQuery params) {
        QueryWrapper<Log> queryWrapper=new QueryWrapper<>();
        if(StringUtil.isNotBlank(params.getName())){
            queryWrapper.lambda().likeRight(Log::getUserName,params.getName());
        }
        return page(PageUtil.buildPage(params),queryWrapper);
    }
}
