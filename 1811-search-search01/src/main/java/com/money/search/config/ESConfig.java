package com.money.search.config;

import lombok.Getter;
import lombok.Setter;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;

/**
 * @Auther: wangjunwei
 * @Description: 连接到es集群
 * @Date: Created in 19:47 2019/3/20
 */
@Configuration
@Setter
@Getter
public class ESConfig {
    @Value("${cluster.nodes}")
    private String nodes;
    @Value("${cluster.name}")
    private String name;

    @Bean
    public TransportClient initialize() {
        //准备一个setting配置对象，集群名称可以定义elasticsearch
        Settings settings = Settings.builder().put("cluster.name", name).build();
        //创建连接对象
        TransportClient client = new PreBuiltTransportClient(settings);
        //解析nodes数据
        String[] hostAndPort = nodes.split(",");
        try {
            for (String node : hostAndPort) {
                String host = node.split(":")[0];
                String port = node.split(":")[1];
                //指定ip，端口，按照需要的连接，add节点信息，准备3个节点
                InetSocketTransportAddress address =
                        new InetSocketTransportAddress(InetAddress.getByName(host),
                                Integer.parseInt(port));
                client.addTransportAddress(address);
            }
            return client;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
