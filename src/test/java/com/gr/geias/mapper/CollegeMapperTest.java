package com.gr.geias.mapper;

import com.gr.geias.GeiasApplicationTests;
import com.gr.geias.entity.College;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-08 22:16
 */
class CollegeMapperTest extends GeiasApplicationTests {
    @Autowired
    CollegeMapper collegeMapper;

    @Test
    void addCollege() {
        College college = new College();
        college.setCollegeName("不知到");
        college.setCreateTime(new Date());
        college.setAdminId(11);
        int i = collegeMapper.addCollege(college);
        System.out.println(i);
        System.out.println(college.getCollegeId());
    }

    @Test
    void quereyCollegeCount() {
        College college = new College();
        college.setCollegeId(16);
        college.setCollegeName("不知道2");
        college.setAdminId(12);
        collegeMapper.updateCollege(college);
    }

    @Test
    void quereyCollegeCount1() {
        Integer integer = collegeMapper.quereyCollegeCount(2);
        System.out.println(integer);
    }
}