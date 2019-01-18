package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.entity.Role;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Set;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author foxgo
 * @since 2018-12-26
 */
public interface RoleService extends IService<Role> {

    /**
     * 获取用户的权限list
     * @param userId
     * @return
     */
    Set<String> listUserRoles(Integer userId);


    /**
     * 获取用户的角色标识列表
     * @param userId
     * @return
     */
    String[] listUserRoleSigns(Integer userId);



    IPage<Role> list(CommonQuery params);

}
