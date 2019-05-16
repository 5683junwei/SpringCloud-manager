package com.money.common.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Auther: wangjunwei
 * @Description: redis集群配置
 * @Date: Created in 15:29 2019/3/12
 */
@Configuration
public class JedisClusterConfig {
    @Value("${spring.redis.cluster.nodes:null}")
    private String nodes;
    @Value("${spring.redis.config.maxTotal:0}")
    private Integer maxTotal;
    @Value("${spring.redis.config.maxIdle:0}")
    private Integer maxIdle;
    @Value("${spring.redis.config.minIdle:0}")
    private Integer minIdle;

    /**
     * @return : redis.clients.jedis.JedisCluster
     * @Author: wangjunwei
     * @Date: Created in 15:30 2019/3/12
     * @Description: 初始化方法 返回jediscluster对象
     */
    @Bean
    public JedisCluster init() {
        try {
            //创建集合
            Set<HostAndPort> set = new HashSet<>();
            //根据获取到的节点信息 将ip地址和端口号进行切分
            String[] hostAndPort = nodes.split(",");
            for (String node : hostAndPort) {
                String host = node.split(":")[0];
                int port = Integer.parseInt(node.split(":")[1]);
                //将截取完成的ip地址和端口号存放到set集合中
                set.add(new HostAndPort(host, port));
            }
            //创建连接池
            GenericObjectPoolConfig config = new GenericObjectPoolConfig();
            //设置连接池的属性信息
            config.setMaxTotal(maxTotal);
            config.setMaxIdle(maxIdle);
            config.setMinIdle(minIdle);
            //返回JedisCluster集群对象 存放 redis集群主节点信息 和 连接池配置信息
            return new JedisCluster(set, config);
        } catch (Exception e) {
            return null;
        }
    }
}
