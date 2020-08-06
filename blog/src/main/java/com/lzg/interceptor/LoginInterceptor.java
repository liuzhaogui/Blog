package com.lzg.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @PACKAGE_NAME: com.lzg.interceptor
 * @NAME: LoginInterceptor
 * @USER: 86185
 * @DATE: 2020/7/31
 * @TIME: 11:46
 * @YEAR: 2020
 * @MONTH: 07
 * @MONTH_NAME_SHORT: 7月
 * @MONTH_NAME_FULL: 七月
 * @DAY: 31
 * @DAY_NAME_SHORT: 周五
 * @DAY_NAME_FULL: 星期五
 * @HOUR: 11
 * @MINUTE: 46
 * @PROJECT_NAME: blog
 **/
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        /**
         * 拦截所有admin下的页面，如果为未登录则重定向到登录页面
         */
        if (request.getSession().getAttribute("user") == null){
            response.sendRedirect("/admin");
            return false;
        }
        return true;
    }
}
