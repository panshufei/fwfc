package com.bosy.fwfc.service;

import com.bosy.fwfc.bean.User;
import com.bosy.fwfc.dao.UserMapper;
import com.bosy.fwfc.util.Md5;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

@Service
public class LoginService {

    @Autowired
    UserMapper userMapper;
    public Map<String,Object> login(HttpServletRequest request ,HttpServletResponse response){
        String userName = request.getParameter("user_name");
        String userPassword = request.getParameter("user_password");
        boolean rememberMe = Boolean.parseBoolean(request.getParameter("rememberMe"));
        User user = userMapper.selectByUserName(userName);
        Map<String,Object> mapLogin = new HashMap<>();
        if(user != null){
            try {
                if(user.getUserPassword().equals(Md5.md5(userPassword))){
                    if (rememberMe){
                        // UUID值
                        String uuidString = UUID.randomUUID().toString();
                        String cookieValue = userName+":"+userPassword+":"+uuidString;
                        String cookieInfo = Base64.encodeBase64String(cookieValue.getBytes());
                        Cookie cookie = new Cookie("remember", cookieInfo);
                        cookie.setHttpOnly(true);
                        cookie.setMaxAge(60 * 60 * 24);
                        response.addCookie(cookie);
                    }
                    mapLogin.put("firm_code",user.getFirmCode());
                    mapLogin.put("loginStatus",1);
                    return mapLogin;
                }else {
                    mapLogin.put("loginStatus",-1);
                    return mapLogin;
                }
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
                mapLogin.put("loginStatus",-2);
                return mapLogin;
            }
        }else {
            mapLogin.put("loginStatus",-2);
            return mapLogin;
        }
    }

    public void loginOut(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        if(null != session.getAttribute("user")){
            session.removeAttribute("user");
        }
        Cookie[] cookies = request.getCookies();
        if(null!=cookies) {
            for(Cookie cookie : cookies){
                if("remember".equals(cookie.getName())){
                    cookie.setValue(null);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
    }
}
