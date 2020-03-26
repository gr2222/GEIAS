package com.gr.geias.service.impl;

import com.gr.geias.entity.ClassGrade;
import com.gr.geias.entity.OrganizationNum;
import com.gr.geias.entity.Specialty;
import com.gr.geias.mapper.ClassGradeMapper;
import com.gr.geias.mapper.OrganizationNumMapper;
import com.gr.geias.mapper.SpecialtyMapper;
import com.gr.geias.service.ClassGradeService;
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
public class SpecialtyServiceImpl implements SpecialtyService {
    @Autowired
    SpecialtyMapper specialtyMapper;
    @Autowired
    OrganizationNumMapper organizationNumMapper;
    @Autowired
    ClassGradeService classGradeService;


    @Override
    public List<Specialty> getSpecialty(Integer collegeId) {
        return specialtyMapper.querySpecialty(collegeId);
    }

    @Override
    @Transactional
    public Boolean addSpecialty(Specialty specialty) {
        try {
            Integer integer = specialtyMapper.insertSpecialty(specialty);
            OrganizationNum organizationNum = new OrganizationNum();
            organizationNum.setSum(0);
            organizationNum.setSpecialtyId(specialty.getSpecialtyId());
            organizationNumMapper.insertOrganizationNum(organizationNum);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加专业失败");
        }
    }

    @Override
    public Boolean updateSpecialty(Specialty specialty) {
        Integer integer = specialtyMapper.updateSpecialty(specialty);
        if (integer>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    @Transactional
    public Boolean delSpecialty(Integer specialtyId) {
        try {
            Integer integer = organizationNumMapper.delSpecialtyCount(specialtyId);
            List<ClassGrade> classGrade = classGradeService.getClassGrade(specialtyId, null);
            for (int i = 0; i < classGrade.size(); i++) {
                classGradeService.delClassGrade(classGrade.get(i).getClassId());
            }
            Integer integer1 = specialtyMapper.delSpecialty(specialtyId);

            if (integer>0 && integer1>0){
                return true;
            }else {
                throw new RuntimeException("删除时失败");
            }
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Specialty getSpecialtyById(Integer specialtyId) {
        return specialtyMapper.querySpecialtyById(specialtyId);
    }

    @Override
    @Transactional
    public Integer getAndSetSpecialtyCount(Integer specialtyId) {
        try {
            Integer integer = specialtyMapper.queryCountSpecialty(specialtyId);
            if (integer == null) {
                integer = 0;
            }
            Integer integer1 = organizationNumMapper.updataOrganizationNumBySpecialtyId(integer, specialtyId);
            if (integer1 <= 0) {
                throw new Exception();
            }
            return integer;
        } catch (Exception e) {
            throw new RuntimeException("查询并持久化失败");
        }
    }
}
