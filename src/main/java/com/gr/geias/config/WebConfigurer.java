package com.gr.geias.config;

import com.gr.geias.Interceptor.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-11 11:51
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
    @Autowired
    LoginInterceptor loginInterceptor;
    @Autowired
    AdminInterceptor adminInterceptor;
    @Autowired
    SuperAdminInterceptor superAdminInterceptor;
    @Autowired
    SpecialtyIntercepetor specialtyIntercepetor;
    @Autowired
    ClassGradeInterceptor classGradeInterceptor;
    @Autowired
    Person0Interceptor person0Interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/page/login", "/page/error", "/page/getinfo","/page/faseLogin")
                .excludePathPatterns("/personinfo/login", "/info/**","/personinfo/faseLogin")
                .excludePathPatterns("/html/**", "/fonts/**", "/images/**", "/js/**", "/lib/**", "/css/**");

        registry.addInterceptor(adminInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/page/index", "/page/echarts1", "/page/memberlist", "/page/echarts4", "/page/echarts2", "/page/error", "/page/login", "/page/getinfo", "/page/welcome", "/page/personedit", "/page/toexcal","/page/faseLogin")
                .excludePathPatterns("/init/getinit", "/init/getleve"
                        , "/employmentinformation/getemploymentinfo"
                        , "/employmentinformation/getcountbyemploymentway"
                        , "/employmentinformation/getcountbyunitkind"
                        , "/employmentinformation/getcountbyarea"
                        , "/personinfo/login"
                        ,"/personinfo/faseLogin"
                        , "/info/**"
                        , "/welcome/**"
                        , "/personinfo/getuser"
                        , "/personinfo/updateuser"
                        , "/employmentinformation/download"
                        ,"/personinfo/addFase")
                .excludePathPatterns("/html/**", "/fonts/**", "/images/**", "/js/**", "/lib/**", "/css/**");
        registry.addInterceptor(superAdminInterceptor).addPathPatterns("/page/organizationlist", "/page/collegeadd", "/page/collegeedit", "/page/person_1_list", "/page/person1add", "/page/person_1_edit")
                .addPathPatterns("/organizationcontroller/delcollege"
                        , "/organizationcontroller/getcollegelist"
                        , "/organizationcontroller/getcollegeadmin"
                        , "/organizationcontroller/addcollege"
                        , "/organizationcontroller/updatecollege"
                        , "/organizationcontroller/delperson_1"
                        , "/organizationcontroller/getperson_1"
                        , "/organizationcontroller/updateperson_1"
                        , "/organizationcontroller/addperson_1");

        registry.addInterceptor(specialtyIntercepetor).addPathPatterns("/organizationcontroller/updatespecialty", "/organizationcontroller/delspecialty");
        registry.addInterceptor(classGradeInterceptor).addPathPatterns("/organizationcontroller/getclassgrade", "/organizationcontroller/addclassgrade", "/organizationcontroller/updateclassgrade", "/organizationcontroller/delclassgrade");
        registry.addInterceptor(person0Interceptor).addPathPatterns("/organizationcontroller/getpersonById", "/organizationcontroller/updateperson_0", "/organizationcontroller/delperson_0");
    }
}
