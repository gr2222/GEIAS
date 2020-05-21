package com.gr.geias.controller;

import com.gr.geias.entity.*;
import com.gr.geias.enums.EnableStatusEnums;
import com.gr.geias.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-12 23:02
 */
@RestController
@RequestMapping("/welcome")
public class WelcomeController {
    @Autowired
    OrganizationNumService organizationNumService;
    @Autowired
    EmploymentInformationService employmentInformationService;
    @Autowired
    ClassGradeService classGradeService;
    @Autowired
    CollegeService collegeService;
    @Autowired
    SpecialtyService specialtyService;


    private static final Integer[][] SALARY = {{0, 3000}, {3000, 4000}, {4000, 5000}, {5000, 6000}, {6000, 7000}, {7000, 8000}, {8000, 9000}, {9000, 10000}, {10000, 11000}, {11000, 12000}, {12000, 13000}, {13000, 14000}, {14000, 100000000}};

    @RequestMapping(value = "/getcountbyarea", method = RequestMethod.GET)
    public Map<String, Object> getCountByArea(HttpServletRequest request) {
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        Map<String, Object> ruslt = new HashMap<>(4);
        if (person.getEnableStatus() == EnableStatusEnums.schoolmaster.getState()) {
            Integer integer = organizationNumService.geiAllCollegeSum();
            Integer count = employmentInformationService.getCount(null, person, null);
            ruslt.put("success", true);
            ruslt.put("yijiuye", count);
            ruslt.put("weijiuye", integer - count);
            return ruslt;
        }
        if (person.getEnableStatus() == EnableStatusEnums.PREXY.getState()) {
            Integer integer = organizationNumService.getcollegeCount(person.getCollegeId());
            Integer count = employmentInformationService.getCount(null, person, null);
            ruslt.put("success", true);
            ruslt.put("yijiuye", count);
            ruslt.put("weijiuye", integer - count);
            return ruslt;
        }
        if (person.getEnableStatus() == EnableStatusEnums.TEACHER.getState()) {
            Integer count = employmentInformationService.getCount(null, person, null);
            List<ClassGrade> classGradeList = classGradeService.getClassGrade(null, person.getPersonId());
            int sum = 0;
            for (int i = 0; i < classGradeList.size(); i++) {
                ClassGrade classGrade = classGradeList.get(i);
                Integer classGradeCount = organizationNumService.getClassGradeCount(classGrade.getClassId());
                sum += classGradeCount;
            }
            ruslt.put("success", true);
            ruslt.put("yijiuye", count);
            ruslt.put("weijiuye", sum - count);
            return ruslt;
        }
        return ruslt;
    }

    @RequestMapping(value = "/getcountbysalary", method = RequestMethod.GET)
    public Map<String, Object> getCountBySalary(HttpServletRequest request) {
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        Map<String, Object> ruslt = new HashMap<>(4);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < SALARY.length; i++) {
            Integer count = employmentInformationService.getCount(null, person, SALARY[i]);
            list.add(count);
        }
        ruslt.put("success", true);
        ruslt.put("List", list);
        return ruslt;
    }

    @RequestMapping(value = "/getcountorg", method = RequestMethod.GET)
    public Map<String, Object> getCountOrg(HttpServletRequest request) {
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        Map<String, Object> ruslt = new HashMap<>(4);
        List<String> nameList = new ArrayList<>();
        List<Map<String, Object>> list = new ArrayList<>();
        if (person.getEnableStatus() == EnableStatusEnums.schoolmaster.getState()) {
            List<College> collegeList = collegeService.getCollege(null);
            for (int i = 0; i < collegeList.size(); i++) {
                College college = collegeList.get(i);
                Map<String, Object> map = new HashMap<>(2);
                EmploymentInformation employmentInformation = new EmploymentInformation();
                employmentInformation.setCollege(college);
                Integer count = employmentInformationService.getCount(employmentInformation, null, null);
                nameList.add(college.getCollegeName());
                map.put("name", college.getCollegeName());
                map.put("value", count);
                list.add(map);
            }
        }
        if (person.getEnableStatus() == EnableStatusEnums.PREXY.getState()) {
            List<Specialty> specialtyList = specialtyService.getSpecialty(person.getCollegeId());
            for (int i = 0; i < specialtyList.size(); i++) {
                Specialty specialty = specialtyList.get(i);
                Map<String, Object> map = new HashMap<>(2);
                EmploymentInformation employmentInformation = new EmploymentInformation();
                employmentInformation.setSpecialty(specialty);
                Integer count = employmentInformationService.getCount(employmentInformation, null, null);
                nameList.add(specialty.getSpecialtyName());
                map.put("name", specialty.getSpecialtyName());
                map.put("value", count);
                list.add(map);
            }
        }
        if (person.getEnableStatus() == EnableStatusEnums.TEACHER.getState()) {
            List<ClassGrade> classGradeList = classGradeService.getClassGrade(null, person.getPersonId());
            for (int i = 0; i < classGradeList.size(); i++) {
                ClassGrade classGrade = classGradeList.get(i);
                Map<String, Object> map = new HashMap<>(2);
                EmploymentInformation employmentInformation = new EmploymentInformation();
                employmentInformation.setClassGrade(classGrade);
                Integer count = employmentInformationService.getCount(employmentInformation, null, null);
                nameList.add(classGrade.getClassName());
                map.put("name", classGrade.getClassName());
                map.put("value", count);
                list.add(map);
            }
        }
        ruslt.put("success", true);
        ruslt.put("List", list);
        ruslt.put("NameList", nameList);
        return ruslt;
    }

    @RequestMapping(value = "/getcountorgratio", method = RequestMethod.GET)
    public Map<String, Object> getCountOrgRatio(HttpServletRequest request) {
        PersonInfo person = (PersonInfo) request.getSession().getAttribute("person");
        Map<String, Object> ruslt = new HashMap<>(4);
        List<String> nameList = new ArrayList<>();
        List<Float> list = new ArrayList<>();

        if (person.getEnableStatus() == EnableStatusEnums.schoolmaster.getState()) {
            List<College> collegeList = collegeService.getCollege(null);
            for (int i = 0; i < collegeList.size(); i++) {
                College college = collegeList.get(i);
                EmploymentInformation employmentInformation = new EmploymentInformation();
                employmentInformation.setCollege(college);
                Integer count = employmentInformationService.getCount(employmentInformation,
                        null, null);
                Integer integer = organizationNumService.getcollegeCount(college.getCollegeId());
                float ratio =0f;
                if (integer!=0){
                    ratio = (float)count / (float)integer;
                }
                nameList.add(college.getCollegeName());
                list.add(ratio*100);
            }
        }
        if (person.getEnableStatus() == EnableStatusEnums.PREXY.getState()) {
            List<Specialty> specialtyList = specialtyService.getSpecialty(person.getCollegeId());
            for (int i = 0; i < specialtyList.size(); i++) {
                Specialty specialty = specialtyList.get(i);
                EmploymentInformation employmentInformation = new EmploymentInformation();
                employmentInformation.setSpecialty(specialty);
                Integer count = employmentInformationService.getCount(employmentInformation,
                        null, null);
                Integer integer = organizationNumService.getspecialtyCount(specialty.getSpecialtyId());
                float ratio =0f;
                if (integer!=0){
                    ratio = (float)count / (float)integer;
                }
                nameList.add(specialty.getSpecialtyName());
                list.add(ratio*100);
            }
        }
        if (person.getEnableStatus() == EnableStatusEnums.TEACHER.getState()) {
            List<ClassGrade> classGradeList = classGradeService.getClassGrade(null,
                    person.getPersonId());
            for (int i = 0; i < classGradeList.size(); i++) {
                ClassGrade classGrade = classGradeList.get(i);
                EmploymentInformation employmentInformation = new EmploymentInformation();
                employmentInformation.setClassGrade(classGrade);
                Integer count = employmentInformationService.getCount(employmentInformation,
                        null, null);
                Integer integer = organizationNumService.getClassGradeCount(classGrade.getClassId());
                float ratio =0f;
                if (integer!=0){
                    ratio = (float)count / (float)integer;
                }
                nameList.add(classGrade.getClassName());
                list.add(ratio*100);
            }
        }
        ruslt.put("success", true);
        ruslt.put("List", list);
        ruslt.put("NameList", nameList);
        return ruslt;
    }
}
