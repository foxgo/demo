package com.foxgo.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.foxgo.admin.common.page.CommonQuery;
import com.foxgo.admin.common.page.PageUtil;
import com.foxgo.admin.common.util.StringUtil;
import com.foxgo.admin.entity.Menu;
import com.foxgo.admin.mapper.MenuMapper;
import com.foxgo.admin.service.MenuService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <p>
 * 菜单 服务实现类
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {



    @Override
    public Set<String> listPerms(Integer userId) {
        List<String> perms = baseMapper.listUserPerms(userId);
        Set<String> permsSet = new HashSet<>();
        for (String perm : perms) {
            if (StringUtil.isNotBlank(perm)) {
                permsSet.addAll(Arrays.asList(perm.trim().split(",")));
            }
        }
        return permsSet;
    }

    @Override
    public IPage<Menu> list(CommonQuery params) {
        QueryWrapper<Menu> queryWrapper=new QueryWrapper<>();
        if(StringUtil.isNotBlank(params.getName())){
            queryWrapper.lambda().likeRight(Menu::getMenuName,params.getName());
        }
        return page(PageUtil.buildPage(params),queryWrapper);
    }
}
