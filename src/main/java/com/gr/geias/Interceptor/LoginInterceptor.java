package com.gr.geias.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-11 11:38
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 拦截登录，没用登录的一律返回登录页
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object person = request.getSession().getAttribute("person");
        if (person!=null){
            return true;
        }else {
            response.sendRedirect("/page/login");
            return false;
        }
    }
}
