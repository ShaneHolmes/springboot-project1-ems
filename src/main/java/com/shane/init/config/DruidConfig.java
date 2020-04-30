package com.shane.init.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ShaneHolmes
 * @date 2020/4/29 - 22:22
 * 功能描述：Druid配置类
 */
@Configuration
public class DruidConfig {
    /**
     * 给容器中添加阿里druid的数据源：DruidDataSource
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     * 配置Druid数据源的监控
     */
    //1.配置一个管理后台的Servlet：处理/druid/*请求
    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        //配置初始化参数
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("loginUsername","shane");
        initParameters.put("loginPassword","123456");
        servletRegistrationBean.setInitParameters(initParameters);
        return servletRegistrationBean;
    }
    //1.配置一个监控的filter
    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> initParameters = new HashMap<>();
        initParameters.put("exclusions","*.js,*.css,/druid/*,/login,/login.html");
        filterRegistrationBean.setInitParameters(initParameters);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterRegistrationBean;
    }
}

