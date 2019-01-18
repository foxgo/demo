package com.foxgo.admin.entity.vo;

import java.io.Serializable;

public class UserVO implements Serializable {

    private Integer id;

    private String token;

    private String introduction;

    private String avatar;

    private String name;

    private String[] roles;

    public UserVO() {
    }

    public Integer getId() {
        return this.id;
    }

    public String getToken() {
        return this.token;
    }

    public String getIntroduction() {
        return this.introduction;
    }

    public String getAvatar() {
        return this.avatar;
    }

    public String getName() {
        return this.name;
    }

    public String[] getRoles() {
        return this.roles;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setRoles(String[] roles) {
        this.roles = roles;
    }


    @Override
    public String toString() {
        return "UserVO(id="+this.id+", token=" + this.token + ", introduction=" + this.introduction + ", avatar=" + this.avatar + ", name=" + this.name + ")";
    }
}
