package com.foxgo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.page.PageUtil;
import com.foxgo.admin.common.util.StringUtil;
import com.foxgo.admin.entity.Role;
import com.foxgo.admin.mapper.RoleMapper;
import com.foxgo.admin.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-12-26
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public Set<String> listUserRoles(Integer userId) {
        List<String> roles = baseMapper.listUserRoles(userId);
        Set<String> roleSet = new HashSet<>();
        for (String role : roles) {
            if (StringUtil.isNotBlank(role)) {
                roleSet.addAll(Arrays.asList(role.trim().split(",")));
            }
        }
        return roleSet;
    }

    @Override
    public String[] listUserRoleSigns(Integer userId) {
        List<String> roles = baseMapper.listUserRoles(userId);
        return roles.toArray(new String[roles.size()]);
    }



    @Override
    public IPage<Role> list(CommonQuery params) {
        QueryWrapper<Role> queryWrapper=new QueryWrapper<>();
        if (StringUtil.isNotBlank(params.getName())) {
            queryWrapper.lambda().likeRight(Role::getRoleName, params.getName());
        }
        return page(PageUtil.buildPage(params), queryWrapper);
    }
}
