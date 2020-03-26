package com.gr.geias.service.impl;

import com.gr.geias.entity.College;
import com.gr.geias.entity.OrganizationNum;
import com.gr.geias.entity.PersonInfo;
import com.gr.geias.entity.Specialty;
import com.gr.geias.mapper.CollegeMapper;
import com.gr.geias.mapper.OrganizationNumMapper;
import com.gr.geias.mapper.PersonInfoMapper;
import com.gr.geias.service.CollegeService;
import com.gr.geias.service.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
public class CollegeServiceImpl implements CollegeService {
    @Autowired
    CollegeMapper collegeMapper;
    @Autowired
    PersonInfoMapper personInfoMapper;
    @Autowired
    OrganizationNumMapper organizationNumMapper;
    @Autowired
    SpecialtyService specialtyService;

    @Override
    public List<College> getCollege(Integer adminId) {
        return collegeMapper.queryCollege(adminId);
    }

    @Override
    @Transactional
    public Boolean addCollege(College college) {
        int i = collegeMapper.addCollege(college);
        if (i > 0) {
            PersonInfo personInfo = new PersonInfo();
            personInfo.setPersonId(college.getAdminId());
            personInfo.setCollegeId(college.getCollegeId());
            Integer integer = personInfoMapper.updatePerseonofCollege(personInfo);
            OrganizationNum organizationNum = new OrganizationNum();
            organizationNum.setCollegeId(college.getCollegeId());
            organizationNum.setSum(0);
            Integer integer1 = organizationNumMapper.insertOrganizationNum(organizationNum);
            if (integer > 0 && integer1 > 0) {
                return true;
            } else {
                throw new RuntimeException("添加过程中出错");
            }
        } else {
            throw new RuntimeException("添加过程中出错");
        }
    }

    @Override
    public Integer getAndSetcount(Integer collegeId) {
        Integer integer = collegeMapper.quereyCollegeCount(collegeId);
        if (integer == null) {
            integer = 0;
        }
        organizationNumMapper.updataOrganizationNumByCollegeId(integer, collegeId);
        return integer;
    }

    @Override
    @Transactional
    public Boolean updateCollege(College college) {

        if (college.getAdminId() != null) {
            try {
                College college1 = collegeMapper.queryCollegeById(college.getCollegeId());
                PersonInfo personInfo = new PersonInfo();
                personInfo.setPersonId(college1.getAdminId());
                personInfo.setCollegeId(null);
                personInfoMapper.updatePerseonofCollege(personInfo);
                collegeMapper.updateCollege(college);
                PersonInfo personInfo1 = new PersonInfo();
                personInfo1.setPersonId(college.getAdminId());
                personInfo1.setCollegeId(college.getCollegeId());
                personInfoMapper.updatePerseonofCollege(personInfo1);
                return true;
            }catch (Exception e){
                throw  new RuntimeException("修改时出错");
            }
        }else{
            collegeMapper.updateCollege(college);
            return true;
        }
    }

    @Override
    @Transactional
    public Boolean delCollege(Integer collegeId){
        try {
            College college = collegeMapper.queryCollegeById(collegeId);
            organizationNumMapper.delCollegeCount(collegeId);
            PersonInfo personInfo = new PersonInfo();
            personInfo.setCollegeId(null);
            personInfo.setPersonId(college.getAdminId());
            personInfoMapper.updatePerseonofCollege(personInfo);
            List<Specialty> specialty = specialtyService.getSpecialty(collegeId);
            for (int i = 0; i < specialty.size(); i++) {
                specialtyService.delSpecialty(specialty.get(i).getSpecialtyId());
            }
            personInfoMapper.delPerson(collegeId);
            collegeMapper.delCollegeById(collegeId);
            return true;
        }catch (Exception e){
            throw new RuntimeException("删除出错,请重试");
        }
    }

    @Override
    public College getCollegeById(Integer collegeId) {
        return collegeMapper.queryCollegeById(collegeId);
    }
}
