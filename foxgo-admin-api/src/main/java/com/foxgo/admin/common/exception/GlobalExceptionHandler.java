package com.foxgo.admin.common.exception;

import com.foxgo.admin.common.util.Result;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import javax.servlet.http.HttpServletRequest;

import com.foxgo.admin.common.constant.ResultCodeEnum;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(DuplicateKeyException.class)
    public Object handlerDuplicateKeyException(DuplicateKeyException e, HttpServletRequest request){
        logger.error(e.getMessage(), e);
        return Result.fail(String.format("重复键 %s",e.getCause().getMessage()));
    }

    @ExceptionHandler(AuthorizationException.class)
    public Object AuthorizationExceptionException(AuthorizationException e, HttpServletRequest request){
        logger.error(e.getMessage(), e);
        return Result.fail(String.format("无权限 %s",e.getCause().getMessage()));
    }

    @ExceptionHandler(Exception.class)
    public Object handlerException(Exception e,HttpServletRequest request){
        logger.error(e.getMessage(), e);
        return Result.fail(ResultCodeEnum.SERVICE_ERROR);
    }

}
