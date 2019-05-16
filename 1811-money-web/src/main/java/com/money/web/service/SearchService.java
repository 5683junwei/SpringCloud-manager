package com.money.web.service;

import com.money.common.config.HttpClientService;
import com.money.common.pojo.PageBean;
import com.money.common.pojo.Product;
import com.money.common.util.OUtil;
import com.money.common.vo.SysResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Auther: wangjunwei
 * @Description: es搜索service曾
 * @Date: Created in 22:07 2019/3/30
 */
@Service
public class SearchService {
    @Autowired
    private HttpClientService clientService;

    /**
     * @param type  1
     * @param query 2
     * @return : java.lang.String
     * @Author: wangjunwei
     * @Date: Created in 22:13 2019/3/30
     * @Description: httpclient请求 es搜索提示
     */
    public String getTip(String type, String query) throws Exception {
        //String url = "http://localhost:9000/api-n/es/ajaxSearch?type=" + type + "&query=" + query;
        String url = "http://manage.money.com/api-n/es/ajaxSearch?type=" + type + "&query=" + query;
        System.out.println(url);
        String jsonData = clientService.doGet(url);
        return jsonData;
    }

    /**
     * @param page  1
     * @param type  2
     * @param query 3
     * @return : java.util.List<com.money.common.pojo.Product>
     * @Author: wangjunwei
     * @Date: Created in 22:54 2019/3/30
     * @Description: http请求es服务获取分页查询数据
     */
    public PageBean queryToPage(Integer page, String type, String query) throws Exception {
        //String url =
        //        "http://localhost:9000/api-n/es/queryProduct?page=" + page + "&type=" + type + "&query" +
        //                "=" + query;
        String url =
                "http://manage.money.com/api-n/es/queryProduct?page=" + page + "&type=" + type + "&query" +
                        "=" + query;
        String jsonData = clientService.doGet(url);
        PageBean pageBean = OUtil.mapper.readValue(jsonData, PageBean.class);
        return pageBean;
    }
}
