package com.gr.geias.mapper;

import com.gr.geias.entity.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface AreaMapper {
    /**
     * 获取地区信息
     * @param area
     * @return
     */
    List<Area> queryArea(@Param("area") Area area);
}
