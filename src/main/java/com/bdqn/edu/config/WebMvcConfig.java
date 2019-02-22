package com.bdqn.edu.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p>
 * Web MVC 配置
 * </p>
 *
 * @author Li
 * @since 2019-02-21
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 加入时间转化格式
     *
     * @param registry
     */
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addFormatter(new DateFormatter("yyyy-MM-dd"));
    }
}
