package com.bosy.fwfc.service;

import com.bosy.fwfc.bean.Dealer;
import com.bosy.fwfc.bean.DealerExample;
import com.bosy.fwfc.bean.User;
import com.bosy.fwfc.dao.DealerMapper;
import com.bosy.fwfc.dao.UserMapper;
import com.bosy.fwfc.util.Md5;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

@Service
public class DealerService {

    @Autowired
    DealerMapper dealerMapper;
    public  List<Dealer> selectByExampleForOffsetPage(DealerExample dealerExample, int offset, int limit) {
        PageHelper.offsetPage(offset,limit);
         return dealerMapper.selectByExample(dealerExample);
    }

    public  long countByExample(DealerExample dealerExample) {
        return dealerMapper.countByExample(dealerExample);
    }
}
