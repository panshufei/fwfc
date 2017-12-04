package com.bosy.fwfc.controller;

import com.bosy.fwfc.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class IndexController {


    @RequestMapping("/index")
    public String index(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (Boolean.parseBoolean((String) session.getAttribute("IntoIndex"))){
            return "/index";
        }else{
            return "redirect:/login";
        }
    }

    @Autowired
    IndexService indexService;
    @RequestMapping(value = "/modifyPassword",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> modifyPassword(HttpServletRequest request){
        Map<String,Object> map = new HashMap<>();
        int modifyFlag = indexService.modifyPassword(request);
        if(modifyFlag == 1){
            map.put("modifyFlag",1);
            return map;
        }else if(modifyFlag == -1){
            map.put("modifyFlag",-1);
            return map;
        }else {
            map.put("modifyFlag",-2);
            return map;
        }
    }
}
