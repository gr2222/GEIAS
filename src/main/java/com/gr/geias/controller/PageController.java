package com.gr.geias.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-06 14:12
 */
@Controller
@RequestMapping("/page")
public class PageController {
    /**
     * 进入首页界面 权限 0，1，2
     *
     * @return
     */
    @RequestMapping("/index")
    public String index() {
        return "/html/index.html";
    }

    /**
     * 进入图表 界面 权限 0，1，2
     *
     * @return
     */
    @RequestMapping("/echarts1")
    public String echarts1() {
        return "/html/echarts1.html";
    }

    /**
     * 进入就业信息列表页面 权限 0，1，2
     *
     * @return
     */
    @RequestMapping("/memberlist")
    public String memberList() {
        return "/html/member-list.html";
    }

    /**
     * 进入登录界面 权限 无
     *
     * @return
     */
    @RequestMapping("/login")
    public String login() {
        return "/html/login.html";
    }

    /**
     * 进入图表 界面 权限 0，1，2
     *
     * @return
     */
    @RequestMapping("/echarts4")
    public String echarts4() {
        return "/html/echarts4.html";
    }

    /**
     * 进入图表 界面 权限 0，1，2
     *
     * @return
     */
    @RequestMapping("/echarts2")
    public String echarts2() {
        return "/html/echarts2.html";
    }

    /**
     * 进入 学院管理 界面 权限 2
     *
     * @return
     */
    @RequestMapping("/organizationlist")
    public String organizationlist() {
        return "/html/organization-list.html";
    }

    /**
     * 进入 学院添加 界面 权限 2
     *
     * @return
     */
    @RequestMapping("/collegeadd")
    public String collegeAdd() {
        return "/html/college-add.html";
    }

    /**
     * 进入学院修改 界面 权限 2
     *
     * @return
     */
    @RequestMapping("/collegeedit")
    public String collegeEdit() {
        return "/html/college-edit.html";
    }

    /**
     * 进入专业列表 界面 权限 1，2
     *
     * @return
     */
    @RequestMapping("/specialtylist")
    public String specialtyList() {
        return "/html/specialty-list.html";
    }

    /**
     * 进入 专业添加  界面 权限 1，2
     *
     * @return
     */
    @RequestMapping("/specialtyadd")
    public String specialtyAdd() {
        return "/html/specialty-add.html";
    }

    /**
     * 进入 专业修改 界面 权限 1，2
     *
     * @return
     */
    @RequestMapping("/specialtyedit")
    public String specialtyEdit() {
        return "/html/specialty-edit.html";
    }

    /**
     * 进入 班级列表 界面 权限 1，2
     *
     * @return
     */
    @RequestMapping("/classgradelist")
    public String classgradeList() {
        return "/html/classgrade-list.html";
    }

    /**
     * 班级添加 权限 1，2
     * @return
     */
    @RequestMapping("/classgradeadd")
    public String classgradeAdd() {
        return "/html/classgrade-add.html";
    }


    /**
     * 班级修改 权限 1，2
     * @return
     */
    @RequestMapping("/classgradeedit")
    public String classgradeEdit() {
        return "/html/classgrade-edit.html";
    }

    /**
     * 错误页面 权限 无
     * @return
     */
    @RequestMapping("/error")
    public String error(){
        return "/html/error.html";
    }

    /**
     * 各个学院辅导员列表 权限 1（特定），2
     * @return
     */
    @RequestMapping("/person_0")
    public String person0List(){
        return "/html/person_0-list.html";
    }

    /**
     * 添加辅导员 权限 1（特定），2
     * @return
     */
    @RequestMapping("/person_o_add")
    public String person0Add(){
        return "/html/person_o_add.html";
    }

    /**
     * 修改辅导员页面 权限 1（特定），2
     * @return
     */
    @RequestMapping("/person_0_edit")
    public String person0Edit(){
        return "/html/person_0-edit.html";
    }

    /**
     * 学院管理员列表 权限 2
     * @return
     */
    @RequestMapping("/person_1_list")
    public String person1List(){
        return "/html/person_1-list.html";
    }

    /**
     *  添加 学院 管理 权限2
     * @return
     */
    @RequestMapping("/person1add")
    public String  person1Add(){
        return "/html/person_1_add.html";
    }

    /**
     * 修改学院管理 权限2
     * @return
     */
    @RequestMapping("/person_1_edit")
    public String person1Edit(){
        return "/html/person_1-edit.html";
    }

    /**
     * 收集毕业生信息 权限无
     * @return
     */
    @RequestMapping("/getinfo")
    public String getInfo(){
        return "/html/getinfo.html";
    }

    /**
     * 桌面页面 权限 1，2，3
     * @return
     */
    @RequestMapping("/welcome")
    public String welcome(){
        return "/html/welcome.html";
    }

    /**
     * 修改用户信息 权限 1，2，3
     * @return
     */
    @RequestMapping("/personedit")
    public String personedit(){return "/html/personedit.html";}

    /**
     * 导出到Excal 权限 1，2，3
     * @return
     */
    @RequestMapping("/toexcal")
    public String toExcal(){return "/html/toExcal.html";}

    /**
     * 读取组织架构 权限 2，3
     * @return
     */
    @RequestMapping("/echarts3")
    public String echarts3(){return "/html/echarts3.html";}


    @RequestMapping("/fase")
    public String fase(){return "/html/fase.html";}

    @RequestMapping("/faseLogin")
    public String faseLogin(){return "/html/faseLogin.html";}



}

