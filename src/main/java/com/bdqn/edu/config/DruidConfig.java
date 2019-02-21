package com.bdqn.edu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * Druid 数据源 配置
 * </p>
 *
 * @author Li
 * @since 2019-02-20
 */
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet() {
        // 创建 Servlet 实体
        ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        // 设置初始化参数
        Map<String, String> initParameters = new HashMap<String, String>();
        // 设置 IP 黑名单，如果 allow 与 deny 同时存在 deny 优先
        initParameters.put("deny", "192.168.1.1");
        // 设置监控台管理员用户
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "123123");
        // 是否可以重置数据
        initParameters.put("resetEnable", "false");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter() {
        // 创建 Filter 实体
        FilterRegistrationBean filterRegistrationBean
                = new FilterRegistrationBean(new WebStatFilter());
        // 设置过滤路径
        filterRegistrationBean.addUrlPatterns("/*");
        // 忽略过滤
        filterRegistrationBean
                .addInitParameter("exclusions"
                        , "*.js,*.html,*.css,*.ico,*.png,*.jpg,*.gif,/druid/*");
        return filterRegistrationBean;
    }

}
