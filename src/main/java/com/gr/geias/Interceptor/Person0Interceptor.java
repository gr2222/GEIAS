package com.gr.geias.Interceptor;

import com.gr.geias.entity.PersonInfo;
import com.gr.geias.enums.EnableStatusEnums;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-12 15:37
 */
@Component
public class Person0Interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        if (person.getEnableStatus() == EnableStatusEnums.schoolmaster.getState()) {
            return true;
        }
        if (person.getEnableStatus() == EnableStatusEnums.PREXY.getState()) {
            Object person0List = request.getSession().getAttribute("person0List");
            if (person0List==null){
                return false;
            }
            List<PersonInfo> list =  (List<PersonInfo>)person0List;
            String personIdStr = request.getParameter("personId");
            if (personIdStr==null){
                return false;
            }
            int personId = Integer.parseInt(personIdStr);
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getPersonId().equals(personId)){
                    return true;
                }
            }

        }
        return false;
    }
}
