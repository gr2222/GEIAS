package com.gr.geias.mapper;

import com.gr.geias.entity.EmploymentWay;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface EmploymentWayMapper  {
    /**
     * 获取工作来源
     * @return
     */
    @Select("select * from tb_employment_way")
    List<EmploymentWay> queryEmploymentWay();

}
