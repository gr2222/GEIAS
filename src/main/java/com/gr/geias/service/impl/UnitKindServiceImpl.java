package com.gr.geias.service.impl;

import com.gr.geias.entity.UnitKind;
import com.gr.geias.mapper.UnitKindMapper;
import com.gr.geias.service.UnitKindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
@Service
public class UnitKindServiceImpl implements UnitKindService {
    @Autowired
    UnitKindMapper unitKindMapper;

    @Override
    public List<UnitKind> getUnitKind() {
        return unitKindMapper.queryUnitKind();
    }
}
