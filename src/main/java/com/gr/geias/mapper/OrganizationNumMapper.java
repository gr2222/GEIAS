package com.gr.geias.mapper;

import com.gr.geias.entity.OrganizationNum;
import org.apache.ibatis.annotations.*;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-09 09:11
 */
public interface OrganizationNumMapper {
    /**
     * 添加人数
     * @param num 信息
     * @return
     */
    @Insert("insert into tb_organization_num(sum,class_id,college_id,specialty_id) values(#{num.sum},#{num.classId},#{num.collegeId},#{num.specialtyId})")
    Integer insertOrganizationNum(@Param("num") OrganizationNum num);

    /**
     * 修改已有的学院人数
     * @param sum
     * @param collegeId
     * @return
     */
    @Update("update tb_organization_num set sum=#{sum} where college_id=#{collegeId}")
    Integer updataOrganizationNumByCollegeId(@Param("sum")Integer sum,@Param("collegeId")Integer collegeId);

    /**
     * 查询学院人数
     * @param collegeId 学院id
     * @return
     */
    @Select("select sum from tb_organization_num where college_id=#{collegeId}")
    Integer queryCountByCollegeId(@Param("collegeId")Integer collegeId);

    /**
     * 删除学院人数记录
     * @param collegeId 学院id
     * @return
     */
    @Delete("delete FROM tb_organization_num where college_id=#{collegeId}")
    Integer delCollegeCount(@Param("collegeId") Integer collegeId);

    /**
     * 查询专业人数
     * @param specialtyId
     * @return
     */
    @Select("select sum from tb_organization_num where specialty_id=#{specialtyId}")
    Integer queryCountByspecialtyId(@Param("specialtyId")Integer specialtyId);


    /**
     * 删除专业人数记录
     * @param specialtyId 专业id
     * @return
     */
    @Delete("delete FROM tb_organization_num where specialty_id=#{specialtyId}")
    Integer delSpecialtyCount(@Param("specialtyId") Integer specialtyId);

    /**
     * 查询班级人数
     * @param classId
     * @return
     */
    @Select("select sum from tb_organization_num where class_id=#{classId}")
    Integer queryCountByclassId(@Param("classId")Integer classId);


    /**
     * 修改已有的专业人数
     * @param sum
     * @param specialtyId
     * @return
     */
    @Update("update tb_organization_num set sum=#{sum} where specialty_id=#{specialtyId}")
    Integer updataOrganizationNumBySpecialtyId(@Param("sum")Integer sum,@Param("specialtyId")Integer specialtyId);

    /**
     * 更新班级人数
     * @param sum
     * @param classGradeId
     * @return
     */
    @Update("update tb_organization_num set sum=#{sum} where class_id=#{classGradeId}")
    Integer updateNumByClassGradeId(@Param("sum")Integer sum,@Param("classGradeId")Integer classGradeId);

    /**
     * 删除班级人数记录
     * @param classId
     * @return
     */
    @Delete("delete from tb_organization_num where class_id= #{classId}")
    Integer delClassGrade(@Param("classId") Integer classId);

    /**
     * 获取学校总人数
     * @return
     */
    @Select("select SUM(sum) from tb_organization_num where college_id is not null;")
    Integer queryAllCollegeSum();

}
