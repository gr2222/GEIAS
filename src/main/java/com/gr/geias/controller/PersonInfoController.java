package com.gr.geias.controller;


import com.gr.geias.entity.PersonInfo;
import com.gr.geias.entity.Specialty;
import com.gr.geias.enums.EnableStatusEnums;
import com.gr.geias.service.PersonInfoService;
import com.gr.geias.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
@RestController
@RequestMapping("/personinfo")
public class PersonInfoController {
    @Autowired
    PersonInfoService personInfoService;
    @Autowired
    SpecialtyService specialtyService;

    /**
     * 登录 权限 无权限者即可接入
     *
     * @param username
     * @param password
     * @param request
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestParam(value = "username") String username,
                                     @RequestParam(value = "password") String password,
                                     HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(3);
        if (username == null || username.equals("") || password == null || password.equals("")) {
            map.put("success", false);
            map.put("errMsg", "用户名或者密码为空");
        } else {
            PersonInfo login = personInfoService.login(username, password);
            if (login != null) {
                request.getSession().setAttribute("person", login);
                if (login.getEnableStatus() == EnableStatusEnums.PREXY.getState()) {
                    List<Specialty> specialtyList = specialtyService.getSpecialty(login.getCollegeId());
                    List<PersonInfo> person0 = personInfoService.getPersonByCollegeId(login.getCollegeId());
                    request.getSession().setAttribute("person0List", person0);
                    request.getSession().setAttribute("specialtyList", specialtyList);
                }
                map.put("success", true);
            } else {
                map.put("success", false);
                map.put("errMsg", "用户名或者密码错误");
            }
        }
        return map;
    }

    @RequestMapping(value = "/getuser")
    public Map<String, Object> getUser(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>(2);
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        map.put("success", true);
        map.put("person", person);
        return map;
    }

    @RequestMapping(value = "/updateuser")
    public Map<String, Object> updateUser(HttpServletRequest request,
                                          @RequestParam("personname") String personname,
                                          @RequestParam("username") String username,
                                          @RequestParam("password") String password) {
        Map<String, Object> map = new HashMap<>(2);
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        person.setUsername(username);
        person.setPassword(password);
        person.setPersonName(personname);
        Boolean aBoolean = personInfoService.updatePerson(person);
        if (aBoolean) {
            map.put("success", true);
            return map;
        } else {
            map.put("success", false);
            map.put("errMsg", "修改出错");
            return map;
        }
    }
}
