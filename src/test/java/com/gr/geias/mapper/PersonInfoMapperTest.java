package com.gr.geias.mapper;

import com.gr.geias.GeiasApplicationTests;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-06 19:21
 */
class PersonInfoMapperTest extends GeiasApplicationTests {
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Test
    void queryPerson() {
        personInfoMapper.queryPerson("maotentai", "123123");
    }
}