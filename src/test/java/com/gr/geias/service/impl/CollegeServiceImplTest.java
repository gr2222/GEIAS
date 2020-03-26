package com.gr.geias.service.impl;

import com.gr.geias.GeiasApplicationTests;
import com.gr.geias.entity.College;
import com.gr.geias.service.CollegeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-08 22:37
 */
class CollegeServiceImplTest extends GeiasApplicationTests {
    @Autowired
    CollegeService collegeService;

    @Test
    void addCollege() {
        College college = new College();
        college.setCollegeName("不知道");
        college.setAdminId(11);
        college.setCreateTime(new Date());
        collegeService.addCollege(college);
    }

    @Test
    void getAndSetcount() {

        Integer andSetcount = collegeService.getAndSetcount(16);
        System.out.println(andSetcount);

    }
}