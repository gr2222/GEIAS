package com.gr.geias.service;

import com.gr.geias.entity.OrganizationNum;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-09 09:13
 */
public interface OrganizationNumService {
    /**
     * 获取学院总人数
     * @param collegeId
     * @return
     */
    Integer getcollegeCount(Integer collegeId);

    /**
     * 获取专业人数
     * @param specialtyId 专业id
     * @return
     */
    Integer getspecialtyCount(Integer specialtyId);

    /**
     * 获取班级人数
     * @param classId
     * @return
     */
    Integer getClassGradeCount(Integer classId);

    /**
     * 更新班级的人数
     * @param organizationNum
     * @return
     */
    Boolean updateClassGradesum(OrganizationNum organizationNum);

    /**
     * 获取学校总人数
     * @return
     */
    Integer geiAllCollegeSum();
}
