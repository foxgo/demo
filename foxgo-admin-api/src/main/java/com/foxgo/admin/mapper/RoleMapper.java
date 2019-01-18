package com.foxgo.admin.mapper;

import com.foxgo.admin.entity.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author foxgo
 * @since 2018-12-26
 */
public interface RoleMapper extends BaseMapper<Role> {

    List<String> listUserRoles(Integer id);

}
