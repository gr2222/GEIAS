package com.gr.geias.service;

import com.gr.geias.entity.College;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface CollegeService {
    /**
     * 获取学院
     * @param adminId 管理id
     * @return
     */
    List<College> getCollege(Integer adminId);

    /**
     * 添加学院
     * @param college
     * @return
     */
    Boolean addCollege(College college);

    /**
     * 返回学院总人数并持久化到数据库中
     * @param collegeId
     * @return
     */
    Integer getAndSetcount(Integer collegeId);

    /**
     * 修改学院
     * @param college 学院信息
     * @return
     */
    Boolean updateCollege(College college);

    /**
     * 删除学院
     * @param collegeId 学院id
     * @return
     */
    Boolean delCollege(Integer collegeId);

    /**
     * 获取学院信息
     * @param collegeId 学院id
     * @return
     */
    College getCollegeById(Integer collegeId);
}
