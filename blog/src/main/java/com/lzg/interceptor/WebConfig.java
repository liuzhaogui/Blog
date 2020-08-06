package com.lzg.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @PACKAGE_NAME: com.lzg.interceptor
 * @NAME: WebConfig
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 11:51
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 11
 * @MINUTE: 51
 * @PROJECT_NAME: blog
 **/
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    /**
     *  .addPathPatterns 需要拦截页面
     *  /admin/**  为 admin 下的所有页面
     *  .excludePathPatterns 排除掉的页面  可有多个
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login");
    }
}
