package com.gr.geias.mapper;

import com.gr.geias.GeiasApplicationTests;
import com.gr.geias.entity.Specialty;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-10 14:48
 */
class SpecialtyMapperTest extends GeiasApplicationTests {
    @Autowired
    SpecialtyMapper specialtyMapper;
    @Test
    void updateSpecialty() {
        Specialty specialty = new Specialty();

    }

    @Test
    void delSpecialty() {
    }
}