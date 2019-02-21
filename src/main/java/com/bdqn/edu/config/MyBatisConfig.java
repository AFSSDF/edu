package com.bdqn.edu.config;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <p>
 * MyBatis 配置
 * </p>
 *
 * @author Li
 * @since 2019-02-20
 */
@MapperScan(value = "com.bdqn.edu.mapper")
@Configuration
public class MyBatisConfig {

    /**
     * 下划线与驼峰命名的自动转化
     * @return
     */
    @Bean
    public ConfigurationCustomizer configurationCustomizer(){
        return new ConfigurationCustomizer() {
            @Override
            public void customize(org.apache.ibatis.session.Configuration configuration) {
                configuration.setMapUnderscoreToCamelCase(true);
            }
        };
    }
}
