package com.foxgo.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.foxgo.admin.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 角色与菜单关系
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@TableName("sys_role_menu")
@ApiModel(value="RoleMenu对象", description="角色与菜单关系")
public class RoleMenu extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色ID")
    private Integer roleId;

    @ApiModelProperty(value = "菜单ID")
    private Integer menuId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
        "roleId=" + roleId +
        ", menuId=" + menuId +
        "}";
    }
}
