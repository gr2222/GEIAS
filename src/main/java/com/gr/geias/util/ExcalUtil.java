package com.gr.geias.util;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.gr.geias.dto.EmploymentInformationExcal;
import com.gr.geias.entity.EmploymentInformation;
import com.gr.geias.entity.PersonInfo;
import com.gr.geias.mapper.EmploymentInformationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-13 21:33
 */
@Component
public class ExcalUtil {
    @Autowired
    EmploymentInformationMapper employmentInformationMapper;

    private final static String TAG = "on";

    public void createExcal(HttpServletResponse response,
                            PersonInfo personInfo,
                            Set<String> excludeColumnFiledNames) throws IOException {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        SimpleDateFormat sdf = new SimpleDateFormat();
        sdf.applyPattern("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());

        String fileName = URLEncoder.encode("毕业生就业信息" + format, "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        ExcelWriter excelWriter = EasyExcel.write(
                response.getOutputStream(),
                EmploymentInformationExcal.class)
                .excludeColumnFiledNames(excludeColumnFiledNames).build();
        WriteSheet writeSheet = EasyExcel.writerSheet("信息1").build();
        Integer integer = employmentInformationMapper.queryListCount(null, personInfo, null);
        Integer num = (integer / 100) + 1;
        for (int i = 0; i < num; i++) {
            excelWriter.write(getdata(i, personInfo), writeSheet);
        }
        // 千万别忘记finish 会帮忙关闭流
        excelWriter.finish();
    }

    public Set<String> getExcludeColumn(String id,String studentNum,String name,String gender,String classGrade,String specialty,String college,String area,String unit,String way,String salary) {
        Set<String> set = new HashSet<>();
        if (id==null){
            set.add("informationId");
        }
        if (studentNum==null){
            set.add("studentNum");
        }
        if (name==null){
            set.add("name");
        }
        if (gender==null){
            set.add("gender");
        }
        if (classGrade==null){
            set.add("className");
        }
        if (specialty==null){
            set.add("specialtyName");
        }
        if (college==null){
            set.add("collegeName");
        }
        if (area==null){
            set.add("areaName");
        }
        if (unit==null){
            set.add("unitName");
        }
        if (way==null){
            set.add("wayName");
        }
        if (salary==null){
            set.add("salary");
        }
        return set;
    }

    private List getdata(Integer num, PersonInfo personInfo) {
        List<EmploymentInformationExcal> list = new ArrayList<>();
        int indexNum = PageMath.pageNumtoRowIndex(num, 100);
        List<EmploymentInformation> employmentInformations =
                employmentInformationMapper.queryList(null, indexNum,
                        100, personInfo, null);
        for (int i = 0; i < employmentInformations.size(); i++) {
            EmploymentInformation info = employmentInformations.get(i);
            EmploymentInformationExcal infoExcal = getInfoExal(info);
            list.add(infoExcal);
        }
        return list;
    }

    private EmploymentInformationExcal getInfoExal(EmploymentInformation info) {
        EmploymentInformationExcal infoExcal = new EmploymentInformationExcal();
        infoExcal.setAreaName(info.getArea().getAreaName());
        infoExcal.setClassName(info.getClassGrade().getClassName());
        infoExcal.setCollegeName(info.getCollege().getCollegeName());
        infoExcal.setCreateTime(info.getCreateTime());
        infoExcal.setGender(getGender(info.getGender()));
        infoExcal.setInformationId(info.getInformationId());
        infoExcal.setMsg(info.getMsg());
        infoExcal.setName(info.getName());
        infoExcal.setSalary(info.getSalary());
        infoExcal.setSpecialtyName(info.getSpecialty().getSpecialtyName());
        infoExcal.setStudentNum(info.getStudentNum());
        infoExcal.setUnitName(info.getUnitKind().getUnitName());
        infoExcal.setWayName(info.getEmploymentWay().getVayName());
        return infoExcal;
    }

    private String getGender(Integer gender) {
        if (gender == 1) {
            return "男";
        } else {
            return "女";
        }
    }
}
