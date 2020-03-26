package com.gr.geias.mapper;

import com.gr.geias.entity.College;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface CollegeMapper  {
    /**
     * 获取学院
     * @param adminid
     * @return
     */
    List<College> queryCollege(@Param("adminid") Integer adminid);

    /**
     * 添加 学院
     * @param college
     * @return
     */
    int addCollege(@Param("college") College college);

    /**
     * 查询学院下面一共有多少人
     * @param collegeId 学院id
     * @return
     */
    Integer quereyCollegeCount(@Param("collegeId")Integer collegeId);

    /**
     * 更新学院信息
     * @param college 学院信息
     * @return
     */
    Integer updateCollege(@Param("college") College college);

    /**
     * 根据学院id查学院
     * @param collegeId 学院id
     * @return
     */
    @Select("select * from tb_college where college_id=#{collegeId}")
    College queryCollegeById(@Param("collegeId")Integer collegeId);

    /**
     * 删除学院信息
     * @param collegeId 学院id
     * @return
     */
    @Delete("DELETE FROM tb_college WHERE college_id = #{collegeId}")
    Integer delCollegeById(@Param("collegeId") Integer collegeId);
}
