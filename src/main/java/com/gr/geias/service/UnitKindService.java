package com.gr.geias.service;

import com.gr.geias.entity.UnitKind;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
public interface UnitKindService {
    /**
     * 获取工作分类
     * @return
     */
    List<UnitKind> getUnitKind();

}
