package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface UserService extends IService<User> {


    /**
     * 依据登录帐号获取用户信息
     * @param username
     * @return
     */
    User getUserLogin(String username);


    /**
     *
     * @param params
     * @return
     */
    IPage<User> list(CommonQuery params);

}
