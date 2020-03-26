package com.gr.geias.service.impl;

import com.gr.geias.entity.ClassGrade;
import com.gr.geias.entity.EmploymentInformation;
import com.gr.geias.entity.OrganizationNum;
import com.gr.geias.entity.Specialty;
import com.gr.geias.mapper.ClassGradeMapper;
import com.gr.geias.mapper.EmploymentInformationMapper;
import com.gr.geias.mapper.OrganizationNumMapper;
import com.gr.geias.mapper.SpecialtyMapper;
import com.gr.geias.service.ClassGradeService;
import com.gr.geias.service.CollegeService;
import com.gr.geias.service.SpecialtyService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.EmptyStackException;
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
public class ClassGradeServiceImpl implements ClassGradeService {
    @Autowired
    ClassGradeMapper classGradeMapper;
    @Autowired
    OrganizationNumMapper organizationNumMapper;
    @Autowired
    SpecialtyMapper specialtyMapper;
    @Autowired
    SpecialtyService specialtyService;
    @Autowired
    CollegeService collegeService;
    @Autowired
    EmploymentInformationMapper employmentInformationMapper;

    @Override
    public List<ClassGrade> getClassGrade(Integer specialtyId, Integer adminId) {
        return classGradeMapper.queryClassGrade(specialtyId, adminId);
    }

    @Override
    @Transactional
    public Boolean addClassGrade(ClassGrade classGrade, Integer sum,Integer collegeId) {
        Integer integer = classGradeMapper.insertClassGrede(classGrade);
        if (integer > 0) {
            try {
                OrganizationNum organizationNum = new OrganizationNum();
                organizationNum.setClassId(classGrade.getClassId());
                organizationNum.setSum(sum);
                Integer integer1 = organizationNumMapper.insertOrganizationNum(organizationNum);
                collegeService.getAndSetcount(collegeId);
                specialtyService.getAndSetSpecialtyCount(classGrade.getSpecialtyId());
                if (integer1 > 0) {
                    return true;
                } else {
                    return false;
                }
            } catch (Exception e) {
                throw new RuntimeException("添加出错");
            }
        } else {
            return false;
        }
    }

    @Override
    @Transactional
    public Boolean updateClassGrade(ClassGrade classGrade, Integer sum,Integer collegeId) {
        try {
            Integer integer = classGradeMapper.updateClassGrede(classGrade);
            Integer integer1 = organizationNumMapper.updateNumByClassGradeId(sum, classGrade.getClassId());
            collegeService.getAndSetcount(collegeId);
            specialtyService.getAndSetSpecialtyCount(classGrade.getSpecialtyId());
            if (integer > 0 && integer1 > 0) {
                return true;
            } else {
                throw  new RuntimeException("更新错误");
            }
        }catch (Exception e){
            throw  new RuntimeException("更新错误");
        }

    }

    @Override
    @Transactional
    public Boolean delClassGrade(Integer classId) {
        try {
            Integer integer1 = organizationNumMapper.delClassGrade(classId);
            EmploymentInformation employmentInformation = new EmploymentInformation();
            ClassGrade classGrade = new ClassGrade();
            classGrade.setClassId(classId);
            employmentInformation.setClassGrade(classGrade);
            employmentInformationMapper.delEmploymentInformation(employmentInformation);
            Integer integer = classGradeMapper.delClassGrede(classId);
            if (integer > 0 && integer1 > 0) {
                return true;
            } else {
                throw new RuntimeException("删除记录失败");
            }
        }catch (Exception e){
            throw new RuntimeException("删除记录失败");
        }
    }
}
