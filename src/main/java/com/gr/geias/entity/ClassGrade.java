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
public class ClassGrade implements Serializable {

    private Integer classId;

    private String className;

    private Integer specialtyId;

    private Date createTime;

    private Integer adminId;


}
