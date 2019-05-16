package com.money.search.controller;

import com.money.common.pojo.Categroy;
import com.money.common.pojo.Com;
import com.money.common.pojo.PageBean;
import com.money.common.pojo.Product;
import com.money.common.util.OUtil;
import com.money.search.util.ConstantUtils;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: wangjunwei
 * @Description: 商品es增删改
 * @Date: Created in 10:42 2019/3/26
 */
@RestController
@RequestMapping("es")
public class SearchController {
    @Autowired
    private TransportClient client;

    /**
     * @param page  1
     * @param query 2
     * @return : java.util.List<com.money.common.pojo.Product>
     * @Author: wangjunwei
     * @Date: Created in 14:19 2019/3/26
     * @Description: 分页搜索商品数据
     */
    @RequestMapping("queryProduct")
    public PageBean queryToPage(@RequestParam(defaultValue = "1") Integer page,
                                @RequestParam(defaultValue = "product") String type,
                                String query) {
        List<Product> products = new ArrayList<>();
        int start = (page - 1) * 5;
        if (query==""){
            SearchResponse response =
                    client.prepareSearch(ConstantUtils.INDEX).setTypes(ConstantUtils.TYPE).setQuery(QueryBuilders.matchAllQuery()).setFrom(start).setSize(5).get();
            SearchHits hits = response.getHits();
            long totalHits = hits.getTotalHits();
            for (SearchHit hit : hits) {
                try {
                    products.add(OUtil.mapper.readValue(hit.getSourceAsString(), Product.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            PageBean pageBean = new PageBean((int) totalHits, 5, products);
            return pageBean;
        }
        if (page <= 0) {
            page = 1;
        }
        String condition = null;
        String queryType = null;
        if ("product".equals(type)) {
            queryType = "productName";
            condition = query;
        }
        if ("categroy".equals(type)) {
            try {
                type = "name";
                condition = queryByCategroy(type, query);
                if (!StringUtils.isNotEmpty(condition)) {
                    return null;
                }
                queryType = "productCategoryId";
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        if ("com".equals(type)) {
            try {
                type = "comName";
                condition = queryByCom(type, query);
                if (!StringUtils.isNotEmpty(condition)) {
                    return null;
                }
                queryType = "productComId";
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        if (StringUtils.isNotEmpty(condition)) {
            SearchResponse response =
                    client.prepareSearch(ConstantUtils.INDEX).setQuery(QueryBuilders.matchQuery(
                            queryType,
                            condition)).setFrom(start).setSize(5).get();
            long totalHits =
                    client.prepareSearch(ConstantUtils.INDEX).setQuery(QueryBuilders.matchQuery(queryType
                            , condition)).get().getHits().getTotalHits();
            SearchHits hits = response.getHits();
            for (SearchHit hit : hits) {
                try {
                    products.add(OUtil.mapper.readValue(hit.getSourceAsString(), Product.class));
                } catch (IOException e) {
                    e.printStackTrace();
                    return null;
                }
            }
            if (products.size() > 0) {
                PageBean pageBean = new PageBean((int) totalHits, 5, products);
                return pageBean;
            } else {
                return null;
            }
        }
        return null;
    }

    public String queryByCategroy(String type, String query) throws IOException {
        System.out.println(type + "=============" + query);
        SearchResponse response =
                client.prepareSearch(ConstantUtils.INDEX).setTypes(ConstantUtils.CONDITION_CATEGORY_TYPE).setQuery(QueryBuilders.termQuery(type,
                        query)).get();
        System.out.println(response.toString());
        SearchHits hits = response.getHits();
        Categroy categroy = null;
        for (SearchHit hit : hits) {
            categroy = OUtil.mapper.readValue(hit.getSourceAsString(), Categroy.class);
        }
        if (categroy != null) {
            System.out.println(categroy.getName());
            return String.valueOf(categroy.getId());
        }
        return null;
    }

    public String queryByCom(String type, String query) throws IOException {
        SearchResponse response =
                client.prepareSearch(ConstantUtils.INDEX).setQuery(QueryBuilders.termQuery(type,
                        query)).get();
        SearchHits hits = response.getHits();
        Com com = null;
        for (SearchHit hit : hits) {
            com = OUtil.mapper.readValue(hit.getSourceAsString(), Com.class);
        }
        if (com != null) {
            return String.valueOf(com.getComId());
        }
        return null;
    }


    /**
     * @param type  1
     * @param query 2
     * @return : java.util.List<java.lang.String>
     * @Author: wangjunwei
     * @Date: Created in 22:11 2019/3/30
     * @Description: es搜索 查询提示
     */
    @RequestMapping("ajaxSearch")
    public List<String> ajaxSearch(String type, String query) throws IOException {
        List<String> list = new ArrayList<>();
        String path =
                "com.money.common.pojo." + type.substring(0, 1).toUpperCase() + type.substring(1);
        Object obj = null;
        try {
            obj = Class.forName(path).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SearchResponse response =
                client.prepareSearch(ConstantUtils.INDEX).setTypes(type).setQuery(QueryBuilders.queryStringQuery(query)).setFrom(0).setSize(5).get();
        SearchHits hits = response.getHits();
        if (obj instanceof Product) {
            for (SearchHit hit : hits) {
                Product product = OUtil.mapper.readValue(hit.getSourceAsString(), Product.class);
                list.add(product.getProductName());
            }
            return list;
        } else if (obj instanceof Categroy) {
            for (SearchHit hit : hits) {
                Categroy categroy = OUtil.mapper.readValue(hit.getSourceAsString(), Categroy.class);
                list.add(categroy.getName());
            }
            return list;
        } else if (obj instanceof Com) {
            for (SearchHit hit : hits) {
                Com com = OUtil.mapper.readValue(hit.getSourceAsString(), Com.class);
                list.add(com.getComName());
            }
            return list;
        }
        return null;
    }
}
