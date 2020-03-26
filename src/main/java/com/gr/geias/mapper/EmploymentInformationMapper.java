package com.gr.geias.mapper;

import com.gr.geias.entity.EmploymentInformation;
import com.gr.geias.entity.PersonInfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface EmploymentInformationMapper {
    /**
     * 分页查询信息
     *
     * @param info     查询条件
     * @param indexnum 从第几个开始
     * @param pagesize 每一页有多大
     * @param user     管理权限
     * @param salary   工资范围
     * @return 信息列表
     */
    List<EmploymentInformation> queryList(@Param("info") EmploymentInformation info,
                                          @Param("indexnum") int indexnum,
                                          @Param("pagesize") int pagesize,
                                          @Param("user") PersonInfo user,
                                          @Param("salary") Integer[] salary);

    /**
     * 统计查询总数
     *
     * @param info   查询
     * @param user   管理权限
     * @param salary 工资范围
     * @return
     */
    Integer queryListCount(@Param("info") EmploymentInformation info,
                           @Param("user") PersonInfo user,
                           @Param("salary") Integer[] salary);

    /**
     * 插入毕业生信息
     *
     * @param employmentInformation 毕业生信息
     * @return
     */
    Integer insertEmploymentInformation(@Param("info") EmploymentInformation employmentInformation);

    /**
     * 删除就业信息
     *
     * @param employmentInformation 毕业生信息
     * @return
     */
    Integer delEmploymentInformation(@Param("info") EmploymentInformation employmentInformation);

    /**
     * 根据
     * @param studentNum
     * @return
     */
    @Select("select * from tb_employment_information where student_num=#{studentNum}")
    EmploymentInformation qureyInfoByStudentNum(@Param("studentNum") Integer studentNum);

    /**
     * 更新毕业生信息
     * @param employmentInformation
     * @return
     */
    Integer updayeInfo(@Param("info") EmploymentInformation employmentInformation);

}
