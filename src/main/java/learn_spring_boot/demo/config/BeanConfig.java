package learn_spring_boot.demo.config;

import learn_spring_boot.demo.entity.InitConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @description:
 * @author: siyuan_wu
 * @date: 2020/4/27 14:58
 **/
@SpringBootConfiguration
public class BeanConfig {
    @Value("${test.config.1}")
    private String config1;
    @Value("${test.config.2}")
    private String config2;
    @Value("${test.config.3}")
    private String config3;
    @Value("${test.config.name}")
    private String name;

    @Bean
    public InitConfig initConfig(){
        return InitConfig.options()
                .setConfig1(config1)
                .setConfig2(config2)
                .setConfig3(config3)
                .setName(name)
                .build();
    }

}
