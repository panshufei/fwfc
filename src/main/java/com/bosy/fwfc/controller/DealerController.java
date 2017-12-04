package com.bosy.fwfc.controller;

import com.bosy.fwfc.bean.Dealer;
import com.bosy.fwfc.bean.DealerExample;
import com.bosy.fwfc.service.DealerService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Controller
public class DealerController {

    @Autowired
    DealerService dealerService;

    @RequestMapping("/dealer")
    public String dealer(HttpServletRequest request) {
        HttpSession session=request.getSession();
        if (Boolean.parseBoolean((String) session.getAttribute("IntoIndex"))){
            return "/dealer";
        }else{
            return "redirect:/login";
        }
    }

    @RequestMapping(value = "/dealerList",method = RequestMethod.GET)
    @ResponseBody
    public Object dealerList(
            @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
            @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
            @RequestParam(required = false, defaultValue = "", value = "search") String search,
            @RequestParam(required = false, value =  "sort") String sort,
            @RequestParam(required = false, value =  "order") String order){
        DealerExample dealerExample = new DealerExample();
        if (!StringUtils.isBlank(sort) && !StringUtils.isBlank(order)) {
            dealerExample.setOrderByClause(sort + " " + order);
        }
        if (StringUtils.isNotBlank(search)) {
            dealerExample.or().andDealerNameLike("%" + search + "%");
        }
        List<Dealer> rows = dealerService.selectByExampleForOffsetPage(dealerExample, offset, limit);
        long total = dealerService.countByExample(dealerExample);
        Map<String, Object> result = new HashMap<>();
        result.put("rows", rows);
        result.put("total", total);
        return result;
    }
}
