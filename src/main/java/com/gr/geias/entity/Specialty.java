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
public class Specialty implements Serializable {

    private Integer specialtyId;

    private String specialtyName;

    private Integer collegeId;

    private Date createTime;


}
