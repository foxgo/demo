package com.foxgo.admin.mapper;

import com.foxgo.admin.entity.Menu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 菜单 Mapper 接口
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> listUserPerms(Integer id);

}
