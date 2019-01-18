package com.foxgo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.page.PageUtil;
import com.foxgo.admin.common.util.StringUtil;
import com.foxgo.admin.entity.User;
import com.foxgo.admin.mapper.UserMapper;
import com.foxgo.admin.service.UserService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User getUserLogin(String username) {
       return this.getOne(new QueryWrapper<User>().lambda().eq(User::getUserName,username));
    }

    @Override
    public IPage<User> list(CommonQuery params) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        if(StringUtil.isNotBlank(params.getName())){
            queryWrapper.lambda().likeRight(User::getUserName,params.getName());
        }
        return page(PageUtil.buildPage(params),queryWrapper);
    }
}
