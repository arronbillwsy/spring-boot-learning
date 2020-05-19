package learn_spring_boot.demo.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZkConfig {

    @Value("${zk.url}")
    private String url;
    @Value("${zk.timeout}")
    private int timeout;
    @Value("${zk.retry}")
    private int retry;

//    @Bean
//    public CuratorFramework curatorFramework() {
//        RetryPolicy retryPolicy = new ExponentialBackoffRetry(timeout, retry);
//        CuratorFramework client = CuratorFrameworkFactory.newClient(url, retryPolicy);
//        client.start();
//        return client;
//    }
}
