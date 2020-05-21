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
public class PersonInfo implements Serializable {

    private Integer personId;

    private Integer enableStatus;

    private String personName;

    private Date createTime;

    private String password;

    private String username;

    private Integer collegeId;

    private String faceToken;

}
