package com.foxgo.admin.service.impl;

import com.foxgo.admin.entity.UserRole;
import com.foxgo.admin.mapper.UserRoleMapper;
import com.foxgo.admin.service.UserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色关系 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements UserRoleService {

}
