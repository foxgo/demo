package com.foxgo.admin.common.security.shiro;

import com.foxgo.admin.entity.User;
import com.foxgo.admin.entity.vo.UserVO;
import com.foxgo.admin.service.MenuService;
import com.foxgo.admin.service.RoleService;
import com.foxgo.admin.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Set;


/**
 * @author JohnnyLiu
 */
public class UserRealm extends AuthorizingRealm {

	@Autowired
    UserService userService;
	@Autowired
    MenuService menuService;
    @Autowired
    RoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
        Integer userId = ShiroUtil.getUserId();
        Set<String> perms = menuService.listPerms(userId);
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(perms);
        //Set<String> roles = roleService.listUserRoles(userId);
        //info.setRoles(roles);
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        // String password = new String((char[]) token.getCredentials());
        User user = userService.getUserLogin(username);
        // 账号不存在
        if (user == null) {
            throw new UnknownAccountException("账号或密码不正确");
        }
        // 账号锁定
        if (user.getState()==0) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        //这里的参数要给个唯一的盐;
        ByteSource credentialsSalt = ByteSource.Util.bytes(username);

        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(getUserVO(user), user.getPwd(),credentialsSalt, getName());
        return info;
    }


    private UserVO getUserVO(User user){
        UserVO userVO =new UserVO();
        userVO.setId(user.getId());
        userVO.setAvatar(user.getAvatar());
        userVO.setName(user.getRealName());
        userVO.setIntroduction(user.getRealName());
        userVO.setToken(user.getUserName());
        String[] roles = roleService.listUserRoleSigns(user.getId());
        userVO.setRoles(roles);
        return userVO;
    }

}
