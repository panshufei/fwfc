package com.bosy.fwfc.controller;

import com.bosy.fwfc.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class LoginController {

    @Autowired
    LoginService loginService;
    @RequestMapping("/login")
    public String login(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (Boolean.parseBoolean((String) session.getAttribute("WithoutLogin"))){
            return "redirect:/index";
        }else{
            return "/login";
        }
    }

    /**
     * 登录验证，存session与cookie
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "/loginCheck" ,method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> loginCheck(HttpServletRequest request, HttpServletResponse response) {
        Map mapLogin=loginService.login(request,response);
        Map<String,Object> map=new HashMap<>();
        if((int)mapLogin.get("loginStatus")==1){
            String userName = request.getParameter("user_name");
            //使用request对象的getSession()获取session，如果session不存在则创建一个
            HttpSession session = request.getSession();
            //将数据存储到session中
            session.setAttribute("user", userName);
            session.setAttribute("firm_code", mapLogin.get("firm_code"));
            map.put("status",1);
        }else if((int)mapLogin.get("loginStatus")==-1){
            map.put("status",-1);
            System.out.println(-1);
        }else {
            map.put("status",-2);
        }
        return map;
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request,HttpServletResponse response){
         loginService.loginOut(request,response);
         return "redirect:/login";
    }
}
