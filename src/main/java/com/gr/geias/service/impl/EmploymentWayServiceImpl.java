package com.gr.geias.service.impl;

import com.gr.geias.entity.EmploymentWay;
import com.gr.geias.mapper.EmploymentWayMapper;
import com.gr.geias.service.EmploymentWayService;
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
public class EmploymentWayServiceImpl implements EmploymentWayService {
    @Autowired
    EmploymentWayMapper employmentWayMapper;

    @Override
    public List<EmploymentWay> getEmploymentWay() {
        return employmentWayMapper.queryEmploymentWay();
    }
}
