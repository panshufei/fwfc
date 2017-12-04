package com.bosy.fwfc.Interceptor;

import com.bosy.fwfc.bean.User;
import com.bosy.fwfc.dao.UserMapper;
import com.bosy.fwfc.util.Md5;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserMapper userMapper;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookies = request.getCookies();
        if(cookies != null){
            for (Cookie c : cookies) {
                if ("remember".equals(c.getName()) && c.getValue()!= null){
                    String cookieValue = new String(Base64.decodeBase64(c.getValue()),"utf-8");
                    String[] bytes = cookieValue.split(":");
                    User user = userMapper.selectByUserName(bytes[0]);
                    if(null != user){
                        if(user.getUserPassword().equals(Md5.md5(bytes[1]))){
                            HttpSession session=request.getSession();
                            session.setAttribute("WithoutLogin","true");
                            break;
                        }
                    }
                }
            }
        }
        return true;
    }
}
