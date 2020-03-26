package com.gr.geias.mapper;

import com.gr.geias.entity.UnitKind;
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
public interface UnitKindMapper {
    /**
     * 查询工作分类
     * @return
     */
    @Select("select * from tb_unit_kind")
    List<UnitKind> queryUnitKind();

}
