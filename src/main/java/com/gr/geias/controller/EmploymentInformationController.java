package com.gr.geias.controller;


import com.alibaba.druid.sql.visitor.functions.If;
import com.gr.geias.dto.AreaCount;
import com.gr.geias.dto.EmploymentInformationMsg;
import com.gr.geias.entity.*;
import com.gr.geias.enums.EnableStatusEnums;
import com.gr.geias.service.AreaService;
import com.gr.geias.service.EmploymentInformationService;
import com.gr.geias.service.EmploymentWayService;
import com.gr.geias.service.UnitKindService;
import com.gr.geias.util.ExcalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
@RestController
@RequestMapping("/employmentinformation")
public class EmploymentInformationController {
    @Autowired
    EmploymentInformationService informationService;
    @Autowired
    AreaService areaService;
    @Autowired
    EmploymentWayService employmentWayService;
    @Autowired
    UnitKindService unitKindService;
    @Autowired
    ExcalUtil excalUtil;

    /**
     *  获取毕业生就业信息列表 权限 0，1，2
     * @param pageNum
     * @param areaId
     * @param employmentWayId
     * @param unitId
     * @param levelId
     * @param name
     * @param salary
     * @param request
     * @return
     */
    @RequestMapping(value = "/getemploymentinfo", method = RequestMethod.GET)
    public Object findAll(@RequestParam("pageNum") Integer pageNum,
                          @RequestParam(value = "areaId", required = false) Integer areaId,
                          @RequestParam(value = "employmentWayId", required = false) Integer employmentWayId,
                          @RequestParam(value = "unitId", required = false) Integer unitId,
                          @RequestParam(value = "levelId", required = false) Integer levelId,
                          @RequestParam(value = "name", required = false) String name,
                          @RequestParam(value = "salary", required = false) String salary,
                          HttpServletRequest request) {
        Map<String,Object> map = new HashMap<>(3);
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        EmploymentInformation employmentInformation = new EmploymentInformation();
        if (areaId != null) {
            Area area = new Area();
            area.setAreaId(areaId);
            employmentInformation.setArea(area);
        }
        if (employmentWayId != null) {
            EmploymentWay employmentWay = new EmploymentWay();
            employmentWay.setEmploymentWayId(employmentWayId);
            employmentInformation.setEmploymentWay(employmentWay);
        }
        if (unitId != null) {
            UnitKind unitKind = new UnitKind();
            unitKind.setUnitId(unitId);
            employmentInformation.setUnitKind(unitKind);
        }
        if (levelId != null) {
            if (person.getEnableStatus() == EnableStatusEnums.TEACHER.getState()) {
                ClassGrade classGrade = new ClassGrade();
                classGrade.setClassId(levelId);
                employmentInformation.setClassGrade(classGrade);
            }
            if (person.getEnableStatus() == EnableStatusEnums.PREXY.getState()) {
                Specialty specialty = new Specialty();
                specialty.setSpecialtyId(levelId);
                employmentInformation.setSpecialty(specialty);
            }
            if (person.getEnableStatus() == EnableStatusEnums.schoolmaster.getState()) {
                College college = new College();
                college.setCollegeId(levelId);
                employmentInformation.setCollege(college);
            }
        }
        if (name != null) {
            employmentInformation.setName(name);
        }
        Integer[] a = null;
        if (salary != null) {
            String[] split = salary.split("｜");
            a = new Integer[2];
            a[0] = Integer.parseInt(split[0]);
            a[1] = Integer.parseInt(split[1]);
        }
        EmploymentInformationMsg employmentInfoList = informationService.getEmploymentInfoList(employmentInformation, pageNum, person, a);
        if (employmentInfoList.getSuccess()){
            map.put("success", true);
            map.put("list", employmentInfoList.getList());
            map.put("count", employmentInfoList.getCount());
        }else {
            map.put("success", false);
            map.put("errMsg", "出现错误");
        }
        return map;
    }

    /**
     * 获取 地区数量 列表 权限 0，1，2
     * @param request
     * @return
     */
    @RequestMapping(value = "/getcountbyarea",method = RequestMethod.GET)
    public Map<String,Object> getCountByArea(HttpServletRequest request){
        PersonInfo person = (PersonInfo)request.getSession().getAttribute("person");
        List<Area> areaList = areaService.getArea(null);
        Map<String,Object> ruslt = new HashMap<>(2);
        List<AreaCount> list = new ArrayList<>(36);
        try{
            EmploymentInformation employmentInformation = new EmploymentInformation();
            for (int i = 0; i < areaList.size(); i++) {
            Area area = areaList.get(i);
            employmentInformation.setArea(area);
            Integer count = informationService.getCount(employmentInformation, person,null);
            AreaCount areaCount = new AreaCount();
            areaCount.setName(area.getAreaName());
            areaCount.setValue(count);
            list.add(areaCount);
        }
        ruslt.put("success", true);
        ruslt.put("map", list);
        return ruslt;
        }catch (Exception e){
            ruslt.put("success", false);
            ruslt.put("errMsg", e.getMessage());
            return ruslt;
        }
    }

    /**
     * 获取就业途径数量 列表 权限 0，1，2
     * @param request
     * @return
     */
    @RequestMapping(value = "/getcountbyemploymentway",method = RequestMethod.GET)
    public Map<String,Object> getCountByEmploymentWay(HttpServletRequest request){
        PersonInfo person = (PersonInfo)request.getSession().getAttribute("person");
        List<EmploymentWay> areaList = employmentWayService.getEmploymentWay();
        Map<String,Object> ruslt = new HashMap<>(2);
        List<AreaCount> list = new ArrayList<>(6);
        try{
            EmploymentInformation employmentInformation = new EmploymentInformation();
            for (int i = 0; i < areaList.size(); i++) {
                EmploymentWay employmentWay = areaList.get(i);
                employmentInformation.setEmploymentWay(employmentWay);
                Integer count = informationService.getCount(employmentInformation, person,null);
                AreaCount areaCount = new AreaCount();
                areaCount.setName(employmentWay.getVayName());
                areaCount.setValue(count);
                list.add(areaCount);
            }
            ruslt.put("success", true);
            ruslt.put("map", list);
            return ruslt;
        }catch (Exception e){
            ruslt.put("success", false);
            ruslt.put("errMsg", e.getMessage());
            return ruslt;
        }

    }

    /**
     * 获取 职业分类 数量 列表 0，1，2
     * @param request
     * @return
     */
    @RequestMapping(value = "/getcountbyunitkind",method = RequestMethod.GET)
    public Map<String,Object> getCountByUnitKind(HttpServletRequest request){
        PersonInfo person = (PersonInfo)request.getSession().getAttribute("person");
        List<UnitKind> areaList = unitKindService.getUnitKind();
        Map<String,Object> ruslt = new HashMap<>(2);
        List<AreaCount> list = new ArrayList<>(6);
        List<String> stringList = new ArrayList<>(6);
        try{
            EmploymentInformation employmentInformation = new EmploymentInformation();
            for (int i = 0; i < areaList.size(); i++) {
                UnitKind unitKind = areaList.get(i);
                stringList.add(unitKind.getUnitName());
                employmentInformation.setUnitKind(unitKind);
                Integer count = informationService.getCount(employmentInformation, person,null);
                AreaCount areaCount = new AreaCount();
                areaCount.setName(unitKind.getUnitName());
                areaCount.setValue(count);
                list.add(areaCount);
            }
            ruslt.put("success", true);
            ruslt.put("map", list);
            ruslt.put("nameList", stringList);
            return ruslt;
        }catch (Exception e){
            ruslt.put("success", false);
            ruslt.put("errMsg", e.getMessage());
            return ruslt;
        }


    }

    /**
     * 导出数据
     * @param response
     * @param request
     */
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(HttpServletResponse response,
                         HttpServletRequest request,
                         @RequestParam(value = "id",required = false)String id,
                         @RequestParam(value = "studentNum",required = false)String studentNum,
                         @RequestParam(value = "name",required = false)String name,
                         @RequestParam(value = "gender",required = false)String gender,
                         @RequestParam(value = "class",required = false)String classGrade,
                         @RequestParam(value = "specialty",required = false)String specialty,
                         @RequestParam(value = "college",required = false)String college,
                         @RequestParam(value = "area",required = false)String area,
                         @RequestParam(value = "unit",required = false)String unit,
                         @RequestParam(value = "way",required = false)String way,
                         @RequestParam(value = "salary",required = false)String salary){
        PersonInfo personInfo = (PersonInfo)request.getSession().getAttribute("person");
        try {
            Set<String> excludeColumn = excalUtil.getExcludeColumn(id, studentNum, name, gender, classGrade, specialty, college, area, unit, way, salary);
            excalUtil.createExcal(response,personInfo,excludeColumn);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
