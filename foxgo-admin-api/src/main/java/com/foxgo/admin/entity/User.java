package com.foxgo.admin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.foxgo.admin.entity.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author foxgo
 * @since 2018-11-08
 */
@TableName("sys_user")
@ApiModel(value="User对象", description="用户")
public class User extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "姓名")
    private String realName;

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String pwd;

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "头像")
    private String avatar;

    @ApiModelProperty(value = "状态  0：禁用   1：正常")
    private Integer state;

    @ApiModelProperty(value = "部门ID")
    private Integer deptId;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getState() {
        return state;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    @Override
    public String toString() {
        return "User{" +
        "realName=" + realName +
        ", userName=" + userName +
        ", pwd=" + pwd +
        ", phone=" + phone +
        ", email=" + email +
        ", avatar=" + avatar +
        ", state=" + state +
        ", deptId=" + deptId +
        "}";
    }
}
