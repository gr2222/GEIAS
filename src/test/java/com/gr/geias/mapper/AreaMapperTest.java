package com.gr.geias.mapper;

import com.gr.geias.GeiasApplicationTests;
import com.gr.geias.entity.Area;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-06 23:54
 */
class AreaMapperTest extends GeiasApplicationTests {
    @Autowired
    AreaMapper areaMapper;

    @Test

    void queryArea() {
        Area area = new Area();
        area.setParentId(4);
        List<Area> areas = areaMapper.queryArea(area);
        System.out.println(areas.size());
    }
}