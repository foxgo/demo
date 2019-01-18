package com.foxgo.admin.common.util;

import com.foxgo.admin.common.security.shiro.ShiroUtil;
import com.foxgo.admin.entity.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void encryptPassword() {
        User  user=new User();
        user.setUserName("admin");
        user.setPwd("123456");
        ShiroUtil.encryptPassword(user);
        assertEquals("admin",user.getUserName());
    }
}