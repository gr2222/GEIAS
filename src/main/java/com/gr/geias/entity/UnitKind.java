package com.gr.geias.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author maotentai
 * @since 2020-03-06
 */
@Data
public class UnitKind implements Serializable {

    private Integer unitId;

    private String unitName;

    private Date createTime;


}
