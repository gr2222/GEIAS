package com.gr.geias.service.impl;

import com.gr.geias.GeiasApplicationTests;
import com.gr.geias.entity.Specialty;
import com.gr.geias.service.SpecialtyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-10 11:46
 */
class SpecialtyServiceImplTest extends GeiasApplicationTests {
    @Autowired
    SpecialtyService specialtyService;
    @Test
    void addSpecialty() {
        Specialty specialty = new Specialty();
        specialty.setCollegeId(1);
        specialty.setSpecialtyName("物联网");
        specialtyService.addSpecialty(specialty);
    }

    @Test
    void getAndSetSpecialtyCount() {
        specialtyService.getAndSetSpecialtyCount(1);

    }
}