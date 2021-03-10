package com.lzydmc.bookstore.config;

import com.lzydmc.bookstore.filter.LoginFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//查看登入控制器

@Configuration
public class LoginFilterConfig {
    @Bean
    public LoginFilter loginFilter() {
        return new LoginFilter();
    }

    @Bean(name = "loginFilterConf")
    public FilterRegistrationBean loginFilterConfig() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(loginFilter());
        filterRegistrationBean.addUrlPatterns("/info/*");
        filterRegistrationBean.addUrlPatterns("/comment/*");
        filterRegistrationBean.setName("loginFilterConf");
        return filterRegistrationBean;
    }
}
