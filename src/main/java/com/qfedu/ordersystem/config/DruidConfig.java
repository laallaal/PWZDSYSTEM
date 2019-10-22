package com.qfedu.ordersystem.config;


import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.Servlet;

@Configuration   //配置文件
public class DruidConfig {

    //注册Druid的过滤器 实现SQL的监控  FilterRegistrationBean过滤器注册对象 实现过滤器的注册


    //注册Servlet 实现可视化页面的访问
    @Bean
    public ServletRegistrationBean createSR() {

        ServletRegistrationBean<Servlet> servletRegistrationBean = new ServletRegistrationBean<>();

        //设置Servlet对象
        servletRegistrationBean.setServlet(new StatViewServlet());

        //设置触发路径
        servletRegistrationBean.addUrlMappings("/druid/*");


        return servletRegistrationBean;
    }


    @Bean  //创建对象 调用方法
    public FilterRegistrationBean createFR() {

        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();

        //设置过滤器
        filterRegistrationBean.setFilter(new WebStatFilter());

        //设置过滤路径
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;

    }




}
