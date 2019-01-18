package com.foxgo.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.foxgo.admin.common.util.Result;
import com.foxgo.admin.entity.vo.UserOnline;
import com.foxgo.admin.service.SessionService;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/session")
public class SessionController extends BaseController{

    @Autowired
    SessionService sessionService;


    @RequestMapping("/list")
    public Result<IPage<UserOnline>> list() {
        return success(sessionService.list());
    }


    @RequestMapping("/forceLogout/{sessionId}")
    public Result forceLogout(@PathVariable String sessionId) {
        try {
            sessionService.forceLogout(sessionId);
            return success("success");
        } catch (Exception e) {
            e.printStackTrace();
            return fail(e.getMessage());
        }
    }

    @RequestMapping("/sessionList")
    public Collection<Session> sessionList() {
        return sessionService.sessionList();
    }
}
