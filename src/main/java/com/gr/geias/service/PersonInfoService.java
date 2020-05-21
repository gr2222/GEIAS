package com.gr.geias.service;

import com.gr.geias.entity.PersonInfo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface PersonInfoService {
    /**
     * 登录
     * @param username 用户名
     * @param password 密码
     * @return
     */
    PersonInfo login(String username, String password);

    /**
     * 根据id查询用户
     * @param personId
     * @return
     */
    PersonInfo getPersonById(Integer personId);

    /**
     * 所有学院管理
     * @return
     */
    List<PersonInfo> getCollegePerson();

    /**
     * 得到一个学院里的所有老师
     * @param collegeId
     * @return
     */
    List<PersonInfo> getPersonByCollegeId(Integer collegeId);

    /**
     * 添加人员
     * @param personInfo
     * @return
     */
    Boolean insertPerson(PersonInfo personInfo);

    /**
     * 修改人员信息
     * @param personInfo
     * @return
     */
    Boolean updatePerson(PersonInfo personInfo);

    /**
     * 删除人员
     * @param personId
     * @return
     */
    Boolean delPerson(Integer personId);

    /**
     * 得到所有管理信息
     * @return
     */
    List<PersonInfo> getPerson1();

    /**
     * 添加人脸识别信息
     * @param personInfo
     * @param faseImage
     * @return
     */
    Boolean addFace(PersonInfo personInfo, String faseImage);


    PersonInfo checkFace(String image);

}
