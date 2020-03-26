package com.gr.geias.service.impl;

import com.gr.geias.dto.EmploymentInformationMsg;
import com.gr.geias.entity.EmploymentInformation;
import com.gr.geias.entity.PersonInfo;
import com.gr.geias.mapper.EmploymentInformationMapper;
import com.gr.geias.service.EmploymentInformationService;
import com.gr.geias.util.PageMath;
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
public class EmploymentInformationServiceImpl implements EmploymentInformationService {


    @Autowired
    EmploymentInformationMapper informationMapper;

    @Override
    public EmploymentInformationMsg getEmploymentInfoList(EmploymentInformation information, Integer pagenum, PersonInfo personInfo, Integer[] salary) {
        int i = PageMath.pageNumtoRowIndex(pagenum, 12);
        List<EmploymentInformation> employmentInformations = informationMapper.queryList(information, i, 12, personInfo, salary);
        Integer integer = informationMapper.queryListCount(information, personInfo, salary);
        EmploymentInformationMsg employmentInformationMsg = new EmploymentInformationMsg();
        if (integer >= 0) {
            employmentInformationMsg.setSuccess(true);
            employmentInformationMsg.setCount(integer);
            employmentInformationMsg.setList(employmentInformations);
        } else {
            employmentInformationMsg.setSuccess(false);
        }
        return employmentInformationMsg;
    }

    @Override
    public Integer getCount(EmploymentInformation information, PersonInfo personInfo,Integer[] salary) {
        return informationMapper.queryListCount(information, personInfo, salary);
    }

    @Override
    public Integer addEmpoymentInfo(EmploymentInformation employmentInformation) {
        return informationMapper.insertEmploymentInformation(employmentInformation);
    }

    @Override
    public EmploymentInformation getInfoByStudentNum(Integer studentNum) {
        return informationMapper.qureyInfoByStudentNum(studentNum);
    }

    @Override
    public Integer updateInfo(EmploymentInformation employmentInformation) {
        return informationMapper.updayeInfo(employmentInformation);
    }
}
