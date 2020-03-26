package com.gr.geias.service.impl;

import com.gr.geias.entity.Area;
import com.gr.geias.mapper.AreaMapper;
import com.gr.geias.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    AreaMapper areaMapper;
    @Override
    public List<Area> getArea(Area area) {
        return areaMapper.queryArea(area);
    }
}
