package com.foxgo.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.entity.User;
import com.foxgo.admin.entity.vo.UserOnline;
import com.foxgo.admin.entity.vo.UserVO;
import org.apache.shiro.session.Session;

import java.util.Collection;
import java.util.List;

public interface SessionService {
    IPage<UserOnline> list();

    List<UserVO> listOnlineUser();

    Collection<Session> sessionList();

    boolean forceLogout(String sessionId);
}
