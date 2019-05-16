package com.money.web.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.money.common.pojo.PageBean;
import com.money.web.service.SearchService;

/**
 * @Auther: wangjunwei
 * @Description: es搜索web曾
 * @Date: Created in 22:06 2019/3/30
 */
@Controller
@RequestMapping("es")
public class SearchController {
    @Autowired
    private SearchService searchService;

    /**
     * @param type  1
     * @param query 2
     * @return : java.lang.String
     * @Author: wangjunwei
     * @Date: Created in 22:20 2019/3/30
     * @Description: ajax获取提示信息
     */
    @RequestMapping("getTip")
    @ResponseBody
    public String getTip(String type, String query) {
    	System.out.println(query);
        try {
            String tip = searchService.getTip(type, query);
            System.out.println(tip);
            return tip;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * @param page  1
     * @param type  2
     * @param query 3
     * @param model 4
     * @return : java.lang.String
     * @Author: wangjunwei
     * @Date: Created in 23:05 2019/3/30
     * @Description: es搜索商品数据
     */
    @RequestMapping("queryProduct")
    public String queryToPage(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "product") String type,
                              String query, Model model) {
        System.out.println(type+"========");
        try {
            PageBean pageBean = searchService.queryToPage(page, type, query);
            model.addAttribute("pageBean", pageBean);
            model.addAttribute("query", query);
            model.addAttribute("type", type);
            model.addAttribute("page", page);
            return "search";
        } catch (Exception e) {
            e.printStackTrace();
            return "index";
        }
    }
}
