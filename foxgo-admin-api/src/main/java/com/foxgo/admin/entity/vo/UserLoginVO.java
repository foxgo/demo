package com.foxgo.admin.entity.vo;

public class UserLoginVO {

    private String username;

    private String password;

    private boolean rememberMe;

    private String authenticationCode;

    public UserLoginVO() {
    }


    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }

    public boolean isRememberMe() {
        return this.rememberMe;
    }

    public String getAuthenticationCode() {
        return this.authenticationCode;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRememberMe(boolean rememberMe) {
        this.rememberMe = rememberMe;
    }

    public void setAuthenticationCode(String authenticationCode) {
        this.authenticationCode = authenticationCode;
    }


    @Override
    public String toString() {
        return "UserLoginVO(username=" + this.username + ", password=" + this.password + ", rememberMe=" + this.rememberMe + ", authenticationCode=" + this.authenticationCode + ")";
    }
}
