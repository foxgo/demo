package com.foxgo.admin.common.security.shiro;

import com.foxgo.admin.entity.User;
import com.foxgo.admin.entity.vo.UserVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.security.Principal;
import java.util.Collection;
import java.util.List;

@Configuration
public class ShiroUtil {

    public static String getAlgorithmName() {
        return algorithmName;
    }

    public static int getHashIterations() {
        return hashIterations;
    }

    public static void encryptPassword(User user) {
        //user.setSalt(randomNumberGenerator.nextBytes().toHex());
        String newPassword = new SimpleHash(
                algorithmName,
                user.getPwd(),
                ByteSource.Util.bytes(user.getUserName()),
                hashIterations
        ).toString();
        user.setPwd(newPassword);
    }


    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static UserVO getUser() {
        Object object = getSubject().getPrincipal();
        return (UserVO) object;
    }

    public static Integer getUserId() {
        return getUser().getId();
    }

    public static void logout() {
        getSubject().logout();
    }



    @Value("${shiro.password.algorithmName}")
    private static final String algorithmName = "SHA-256";
    @Value("${shiro.password.hashIterations}")
    private static final int hashIterations = 8;





}
