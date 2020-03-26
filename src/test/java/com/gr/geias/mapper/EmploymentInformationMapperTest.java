package com.gr.geias.mapper;

import com.gr.geias.GeiasApplicationTests;
import com.gr.geias.entity.*;
import org.apache.ibatis.annotations.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-06 16:53
 */
class EmploymentInformationMapperTest extends GeiasApplicationTests {
    @Autowired
    EmploymentInformationMapper informationMapper;
    @Autowired
    SpecialtyMapper specialtyMapper;
    @Autowired
    ClassGradeMapper classGradeMapper;
    @Test
    void queryList() {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setEnableStatus(0);
        personInfo.setPersonId(4);
        EmploymentInformation employmentInformation = new EmploymentInformation();
        Area area = new Area();
        area.setAreaId(13);
        employmentInformation.setArea(area);
        UnitKind unitKind = new UnitKind();
        unitKind.setUnitId(2);
        employmentInformation.setUnitKind(unitKind);
        EmploymentWay employmentWay = new EmploymentWay();
        employmentWay.setEmploymentWayId(1);
        employmentInformation.setEmploymentWay(employmentWay);
        Integer[] a = new Integer[]{7000, 9000};
        List<EmploymentInformation> employmentInformations = informationMapper.queryList(null, 0, 1000, null, a);
        for (int i = 0; i < employmentInformations.size(); i++) {
            System.out.println(employmentInformations.get(i));
        }
    }

    @Test
    void insertEmploymentInformation() {
        for (int n = 0; n < 1000; n++) {
            int[] ar = new int[]{4, 5, 67, 8, 66, 10, 64, 12, 63, 14, 62, 16, 60, 18, 58,
                    20, 56, 22, 54, 24, 52, 26, 50, 28, 48, 30, 46, 32, 44, 34, 42, 36, 40,
                    38, 6, 9, 11, 65, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31, 33, 35, 37, 39,
                    41, 43, 45, 47, 49, 51, 53, 55, 57, 59, 61};
            Random random = new Random();
            int anInt = random.nextInt(ar.length);
            Area area = new Area();
            area.setAreaId(ar[anInt]);
            int[] cg = new int[]{2, 3, 4, 5, 6, 8, 9};
            int cgint = random.nextInt(cg.length);
            ClassGrade classGrade = new ClassGrade();
            classGrade.setClassId(cg[cgint]);
            int[] uk = new int[]{1, 2, 3, 4};
            int ukint = random.nextInt(uk.length);
            UnitKind unitKind = new UnitKind();
            unitKind.setUnitId(uk[ukint]);
            int[] ew = new int[]{1, 2, 3, 4};
            int ewint = random.nextInt(ew.length);
            EmploymentWay employmentWay = new EmploymentWay();
            employmentWay.setEmploymentWayId(ew[ewint]);
            Integer integer = classGradeMapper.queryspecialtyId(cg[cgint]);
            Specialty specialty = new Specialty();
            specialty.setSpecialtyId(integer);
            Integer integer2 = specialtyMapper.queryCollegeId(integer);
            College college = new College();
            college.setCollegeId(integer2);
            EmploymentInformation employmentInformation = new EmploymentInformation();
            employmentInformation.setCollege(college);
            employmentInformation.setSpecialty(specialty);
            employmentInformation.setClassGrade(classGrade);
            employmentInformation.setUnitKind(unitKind);
            employmentInformation.setEmploymentWay(employmentWay);
            employmentInformation.setArea(area);
            employmentInformation.setName("小"+random.nextInt(100000));
            employmentInformation.setCreateTime(new Date());
            employmentInformation.setGender(random.nextInt(2));
            employmentInformation.setSalary(Integer.toString(random.nextInt(10000)+1000));
            employmentInformation.setStudentNum(random.nextInt(10000000)+10000000);
            Integer integer1 = informationMapper.insertEmploymentInformation(employmentInformation);
            System.out.println("已完成"+n+"个");
        }
    }

    @Test
    void qureyInfoByStudentNum() {
//        EmploymentInformation employmentInformation = informationMapper.qureyInfoByStudentNum(19689416);
//        System.out.println(employmentInformation);
        addInfoForGEIAS();
    }


    private void addInfoForGEIAS() {
        Integer[][] classId = {{18, 24, 21},
                {19, 24, 21},
                {20, 24, 21},
                {21, 25, 21},
                {22, 26, 21},
                {23, 27, 22},
                {24, 27, 22},
                {25, 29, 22},
                {26, 29, 22},
                {27, 37, 23},
                {28, 37, 23},
                {29, 38, 23},
                {30, 38, 23},
                {31, 39, 24},
                {32, 40, 25},
                {33, 41, 26},
                {34, 41, 26},
                {35, 42, 26}};
        Integer[] areas = {4, 5, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40, 42, 44, 46, 48, 50, 52, 54, 56, 58, 60, 62, 63, 64, 66, 67};
        Integer[] unitIds = {1, 2, 3, 4};
        Integer[] wayIds = {1, 2, 3, 4};
        String[] names = {"小李", "小美", "小花"};

        for (int i = 0; i < 550; i++) {
            Random random = new Random();
            int claInt = random.nextInt(classId.length);
            int classIdnum = classId[claInt][0];
            int speciaty = classId[claInt][1];
            int college = classId[claInt][2];
            int studentNum = random.nextInt(1000000) + 10000000;
            String name = names[random.nextInt(names.length)] + random.nextInt(1000);
            int gender = random.nextInt(2);
            int area = areas[random.nextInt(areas.length)];
            int unitId = unitIds[random.nextInt(unitIds.length)];
            int wayId = wayIds[random.nextInt(wayIds.length)];
            int salary = random.nextInt(15000) + 500;
            EmploymentInformation employmentInformation = new EmploymentInformation();
            employmentInformation.setStudentNum(studentNum);
            employmentInformation.setName(name);
            employmentInformation.setGender(gender);
            employmentInformation.setSalary(String.valueOf(salary));
            Area area1 = new Area();
            area1.setAreaId(area);
            employmentInformation.setArea(area1);
            ClassGrade classGrade = new ClassGrade();
            classGrade.setClassId(classIdnum);
            employmentInformation.setClassGrade(classGrade);
            Specialty specialty = new Specialty();
            specialty.setSpecialtyId(speciaty);
            employmentInformation.setSpecialty(specialty);
            College college1 = new College();
            college1.setCollegeId(college);
            employmentInformation.setCollege(college1);
            UnitKind unitKind = new UnitKind();
            unitKind.setUnitId(unitId);
            employmentInformation.setUnitKind(unitKind);
            EmploymentWay employmentWay = new EmploymentWay();
            employmentWay.setEmploymentWayId(wayId);
            employmentInformation.setEmploymentWay(employmentWay);
            informationMapper.insertEmploymentInformation(employmentInformation);
            System.out.println("已完成"+i+"个,姓名"+name+"班级"+classIdnum);
        }

    }

    @Test
    void queryListCount() {
        EmploymentInformation employmentInformation = new EmploymentInformation();
        Specialty specialty = new Specialty();
        specialty.setSpecialtyId(29);
        employmentInformation.setSpecialty(specialty);
        Integer integer = informationMapper.queryListCount(employmentInformation, null, null);
        System.out.println(integer);
    }
}