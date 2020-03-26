package com.gr.geias.service;

import com.gr.geias.entity.ClassGrade;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface ClassGradeService  {

    /**
     * 获取班级
     * @param specialtyId 专业
     * @param adminId 管理
     * @return
     */
    List<ClassGrade> getClassGrade(Integer specialtyId,Integer adminId);

    /**
     * 添加班级和班级人数 并统计到学院和专业人数上
     * @param classGrade
     * @param sum
     * @return
     */
    Boolean addClassGrade(ClassGrade classGrade,Integer sum,Integer collegeId);

    /**
     * 修改班级
     * @param classGrade
     * @return
     */
    Boolean updateClassGrade(ClassGrade classGrade,Integer sum,Integer college);

    /**
     * 删除班级信息
     * @param classId
     * @return
     */
    Boolean delClassGrade(Integer classId);
}
