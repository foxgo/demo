package com.foxgo.admin.controller;

import com.foxgo.admin.common.security.shiro.ShiroUtil;
import com.foxgo.admin.common.util.IResultCode;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.User;
import com.foxgo.admin.entity.vo.UserVO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseController {

    protected  final Logger logger = LoggerFactory.getLogger(this.getClass());

    protected <T> Result<T> success(T data) {
        return Result.success(data);
    }

    protected Result fail(String msg) {
        return Result.fail(msg);
    }

    protected Result fail(IResultCode resultCode) {
        return Result.fail(resultCode);
    }


    protected UserVO CurrentUser(){
        Subject currentUser = ShiroUtil.getSubject();
        if (currentUser.isAuthenticated()) {
            return (UserVO)currentUser.getPrincipal();
        }
        else {
            throw new AuthenticationException();
        }
    }

}
