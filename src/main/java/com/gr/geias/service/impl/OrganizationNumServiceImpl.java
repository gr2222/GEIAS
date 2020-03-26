package com.gr.geias.service.impl;

import com.gr.geias.entity.OrganizationNum;
import com.gr.geias.mapper.OrganizationNumMapper;
import com.gr.geias.service.OrganizationNumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-09 09:13
 */
@Service
public class OrganizationNumServiceImpl implements OrganizationNumService {
    @Autowired
    OrganizationNumMapper organizationNumMapper;

    @Override
    public Integer getcollegeCount(Integer collegeId) {
        return organizationNumMapper.queryCountByCollegeId(collegeId);
    }

    @Override
    public Integer getspecialtyCount(Integer specialtyId) {
        return organizationNumMapper.queryCountByspecialtyId(specialtyId);
    }

    @Override
    public Integer getClassGradeCount(Integer classId) {
        return organizationNumMapper.queryCountByclassId(classId);
    }

    @Override
    public Boolean updateClassGradesum(OrganizationNum organizationNum) {
        Integer integer = organizationNumMapper.updateNumByClassGradeId(organizationNum.getSum(), organizationNum.getClassId());
        if (integer > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Integer geiAllCollegeSum() {
        return organizationNumMapper.queryAllCollegeSum();
    }
}
