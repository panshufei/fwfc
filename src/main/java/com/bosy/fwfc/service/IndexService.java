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
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class IndexService {

    @Autowired
    UserMapper userMapper;
    public int modifyPassword(HttpServletRequest request ) {
        String oldPassword = request.getParameter("old_password");
        String newPassword = request.getParameter("new_password");
        HttpSession session = request.getSession();
        String userName = (String) session.getAttribute("user");
        User user = userMapper.selectByUserName(userName);
        if (user != null) {
            try {
                if (user.getUserPassword().equals(Md5.md5(oldPassword))) {
                    user.setUserPassword(Md5.md5(newPassword));
                    if (userMapper.updateByPassword(user) != 0) {
                        //新密码修改成功
                        return 1;
                    }else {
                        //新密码修改失败
                        return -1;
                    }
                } else {
                    //旧密码输入错误
                    return -2;
                }
            } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
                e.printStackTrace();
                //旧密码输入错误
                return -2;
            }
        } else {
            //旧密码输入错误
            return -2;
        }
    }

}
