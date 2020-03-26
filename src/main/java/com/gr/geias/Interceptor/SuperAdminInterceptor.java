package com.gr.geias.Interceptor;

import com.gr.geias.entity.PersonInfo;
import com.gr.geias.enums.EnableStatusEnums;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-11 14:29
 */
@Component
public class SuperAdminInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        PersonInfo person = (PersonInfo)request.getSession().getAttribute("person");
        if (person.getEnableStatus()== EnableStatusEnums.schoolmaster.getState()){
                return true;
        }
        response.sendRedirect("/page/error");
        return false;
    }
}
