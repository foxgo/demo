package com.foxgo.admin.controller;

import com.foxgo.admin.common.security.shiro.ShiroUtil;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.vo.UserLoginVO;
import com.foxgo.admin.entity.vo.UserVO;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * @author JohnnyLiu
 */
@RestController
@RequestMapping("/home")
public class HomeController extends BaseController {


    @PostMapping("/login")
    public Result<UserVO> login(@RequestBody UserLoginVO userLoginVO) {
        Subject currentUser = ShiroUtil.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userLoginVO.getUsername(), userLoginVO.getPassword());
        token.setRememberMe(userLoginVO.isRememberMe());
        try {
            currentUser.login(token);
        } catch (UnknownAccountException uae) {
            logger.info("There is no user with username of " + token.getPrincipal());
        } catch (IncorrectCredentialsException ice) {
            logger.info("Password for account " + token.getPrincipal() + " was incorrect!");
        } catch (LockedAccountException lae) {
            logger.info("The account for username " + token.getPrincipal() + " is locked.  " + "Please contact your administrator to unlock it.");
        }
        catch (AuthenticationException ae) {
            //unexpected condition?  error?
        }
        if (currentUser.isAuthenticated()) {
            return success((UserVO)currentUser.getPrincipal());
        }
        token.clear();
        return fail("error");
    }

    @GetMapping("/getUserByToken")
    public Result<UserVO> getUserInfo(@RequestParam String token) {
//        UserVO userVO = new UserVO();
//        userVO.setName("Super Admin");
//        userVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
//        userVO.setIntroduction("我是超级管理员");
//        userVO.setToken("admin");
//        userVO.setRoles(new String[]{"admin"});
        return success(CurrentUser());
    }

    @GetMapping("/login")
    public Result login() {
        return fail("Unauthorized");
    }

    @PostMapping("/logout")
    public Result logout() {
        ShiroUtil.logout();
        return success("logout");
    }

}
