package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 菜单 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface MenuService extends IService<Menu> {

    /**
     * 获取用户的权限list
     * @param userId
     * @return
     */
    Set<String> listPerms(Integer userId);


    IPage<Menu> list(CommonQuery params);

}
