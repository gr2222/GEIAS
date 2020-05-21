package com.gr.geias.mapper;

import com.gr.geias.entity.PersonInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface PersonInfoMapper {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 秘密
     * @return 用户
     */
    @Select("select * from tb_person_info where username=#{username} and password=#{password} ")
    PersonInfo queryPerson(@Param("username") String username, @Param("password") String password);

    /**
     * 根据id查询人员
     *
     * @param personId
     * @return
     */
    @Select("select * from tb_person_info where person_id=#{personId} ")
    PersonInfo queryPersonById(@Param("personId") Integer personId);

    /**
     * 查询学院管理
     *
     * @return
     */
    @Select("select person_id,person_name from tb_person_info where enable_Status=1 and college_id is NULL")
    List<PersonInfo> queryCollegePerson();

    /**
     * 更新用户所属学院
     *
     * @param personInfo
     * @return
     */
    Integer updatePerseonofCollege(@Param("personInfo") PersonInfo personInfo);

    /**
     * 查询 一个学院里所有的老师
     *
     * @param collegeId
     * @return
     */
    @Select("select * from tb_person_info where enable_Status=0 and college_id=#{collegeId}")
    List<PersonInfo> queryPersonByCollegeId(@Param("collegeId") Integer collegeId);

    /**
     * 删除一个学院的的全部老师
     *
     * @param collegeId
     * @return
     */
    @Delete("delete from tb_person_info where college_id=#{collegeId}")
    Integer delPerson(@Param("collegeId") Integer collegeId);

    /**
     * 添加人员
     *
     * @param personInfo
     * @return
     */
    @Insert("insert into tb_person_info(enable_Status,person_name,create_time,password,username,college_id) values(#{person.enableStatus},#{person.personName},#{person.createTime},#{person.password},#{person.username},#{person.collegeId})")
    Integer insertPerson(@Param("person") PersonInfo personInfo);

    /**
     * 更新人员信息
     *
     * @param personInfo
     * @return
     */
    Integer updatePerson(@Param("person") PersonInfo personInfo);

    /**
     * 删除用户
     * @param personId
     * @return
     */
    @Delete("delete from tb_person_info where person_id=#{personId}")
    Integer delPersonById(@Param("personId") Integer personId);

    /**
     * 获取 权限为1的的用户
     * @return
     */
    @Select("select * from tb_person_info where enable_Status =1")
    List<PersonInfo> queryPerson1();

    @Update("update tb_person_info set face_token = #{faceToken} where person_id = #{personId}")
    Integer updatePersonById(@Param("personId") Integer personId,@Param("faceToken") String faceToken);
}

