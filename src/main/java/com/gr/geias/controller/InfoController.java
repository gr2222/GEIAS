package com.gr.geias.controller;

import com.gr.geias.entity.*;
import com.gr.geias.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-12 18:03
 */
@RestController
@RequestMapping("/info")
public class InfoController {
    @Autowired
    CollegeService collegeService;
    @Autowired
    SpecialtyService specialtyService;
    @Autowired
    ClassGradeService classGradeService;
    @Autowired
    AreaService areaService;
    @Autowired
    EmploymentWayService employmentWayService;
    @Autowired
    UnitKindService unitKindService;
    @Autowired
    EmploymentInformationService employmentInformationService;

    @RequestMapping("/getcollege")
    public Map<String, Object> getCollege() {
        Map<String, Object> map = new HashMap<>(3);
        List<College> collegeList = collegeService.getCollege(null);
        map.put("success", true);
        map.put("collegeList", collegeList);
        return map;
    }

    @RequestMapping("/getspecialty")
    public Map<String, Object> getSpecialty(@RequestParam("collegeId") Integer collegeId) {
        Map<String, Object> map = new HashMap<>(3);
        List<Specialty> specialty = specialtyService.getSpecialty(collegeId);
        map.put("success", true);
        map.put("specialtyList", specialty);
        return map;
    }

    @RequestMapping("/getclassgrade")
    public Map<String, Object> getClassGrade(@RequestParam("specialtyId") Integer specialtyId) {
        Map<String, Object> map = new HashMap<>(3);
        List<ClassGrade> classGrade = classGradeService.getClassGrade(specialtyId, null);
        map.put("success", true);
        map.put("classGradeList", classGrade);
        return map;
    }

    @RequestMapping("/getinit")
    public Map<String, Object> getinit() {
        Map<String, Object> map = new HashMap<>(4);
        List<Area> area = areaService.getArea(null);
        map.put("areaList", area);
        List<EmploymentWay> employmentWay = employmentWayService.getEmploymentWay();
        map.put("employmentWayList", employmentWay);
        List<UnitKind> unitKind = unitKindService.getUnitKind();
        map.put("unitKindList", unitKind);
        map.put("success", true);
        return map;
    }

    @RequestMapping("/addemploymentinfo")
    public Map<String, Object> addEmploymentInfo(@RequestParam("studentNum") Integer studentNum,
                                                 @RequestParam("name") String name,
                                                 @RequestParam("gender") Integer gender,
                                                 @RequestParam("jiuye") Integer jiuye,
                                                 @RequestParam("collegeId") Integer collegeId,
                                                 @RequestParam("specialtyId") Integer specialtyId,
                                                 @RequestParam("classId") Integer classId,
                                                 @RequestParam("areaId") Integer areaId,
                                                 @RequestParam("unitId") Integer unitId,
                                                 @RequestParam("employmentwayId") Integer employmentwayId,
                                                 @RequestParam("salary") String salary,
                                                 @RequestParam(value = "update", required = false) Boolean update) {
        Map<String, Object> map = new HashMap<>(3);
        if(jiuye>1){
            //todo
        }
        EmploymentInformation infoByStudentNum = employmentInformationService.getInfoByStudentNum(studentNum);
        EmploymentInformation employmentInfo = new EmploymentInformation();
        if (update == null) {
            update = false;
        }
        if (!update) {
            if (infoByStudentNum != null) {
                map.put("success", false);
                map.put("writed", true);
                map.put("errMsg", "该学号已经填写过了，需不需要修改");
                return map;
            }
        } else {
            employmentInfo.setInformationId(infoByStudentNum.getInformationId());
        }
        employmentInfo.setStudentNum(studentNum);
        employmentInfo.setName(name);
        employmentInfo.setGender(gender);
        College college = new College();
        college.setCollegeId(collegeId);
        employmentInfo.setCollege(college);
        Specialty specialty = new Specialty();
        specialty.setSpecialtyId(specialtyId);
        employmentInfo.setSpecialty(specialty);
        ClassGrade classGrade = new ClassGrade();
        classGrade.setClassId(classId);
        employmentInfo.setClassGrade(classGrade);
        Area area = new Area();
        area.setAreaId(areaId);
        employmentInfo.setArea(area);
        UnitKind unitKind = new UnitKind();
        unitKind.setUnitId(unitId);
        employmentInfo.setUnitKind(unitKind);
        EmploymentWay employmentWay = new EmploymentWay();
        employmentWay.setEmploymentWayId(employmentwayId);
        employmentInfo.setEmploymentWay(employmentWay);
        employmentInfo.setSalary(salary);
        employmentInfo.setCreateTime(new Date());
        Integer integer = 0;
        if (update) {
            integer = employmentInformationService.updateInfo(employmentInfo);
        } else {
            integer = employmentInformationService.addEmpoymentInfo(employmentInfo);
        }
        if (integer > 0) {
            map.put("success", true);
        } else {
            map.put("success", false);
            map.put("errMsg", "出现错误");
        }
        return map;
    }

}
