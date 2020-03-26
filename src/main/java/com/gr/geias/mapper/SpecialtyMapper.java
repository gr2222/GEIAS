package com.gr.geias.mapper;

import com.gr.geias.entity.Specialty;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface SpecialtyMapper  {
    /**
     * 获取专业信息
     * @param collegeId 学院
     * @return
     */
    List<Specialty> querySpecialty(@Param("collegeId") Integer collegeId);

    /**
     * 通过专业id 获取 学院id
     * @param specialtyId 专业id
     * @return
     */
    @Select("select college_id from tb_specialty where specialty_id=#{specialtyId}")
    Integer queryCollegeId(@Param("specialtyId") Integer specialtyId);

    /**
     * 添加专业信息
     * @param specialty
     * @return
     */
    Integer insertSpecialty(@Param("specialty") Specialty specialty);

    /**
     * 更新 专业
     * @param specialty 信息
     * @return
     */
    @Update("update tb_specialty set specialty_name=#{specialty.specialtyName},college_id=#{specialty.collegeId} where specialty_id=#{specialty.specialtyId}")
    Integer updateSpecialty(@Param("specialty")Specialty specialty);

    /**
     * 删除专业
     * @param specialtyId
     * @return
     */
    @Delete("delete from tb_specialty where specialty_id = #{specialtyId}")
    Integer delSpecialty(@Param("specialtyId") Integer specialtyId);

    /**
     * 查询专业信息通过id
     * @param specialtyId
     * @return
     */
    @Select("select * from tb_specialty where specialty_id = #{specialtyId}")
    Specialty querySpecialtyById(@Param("specialtyId") Integer specialtyId);

    /**
     * 获取专业总人数
     * @param specialtyId
     * @return
     */
    Integer queryCountSpecialty(@Param("specialtyId")Integer specialtyId);
}
