package com.gr.geias.dto;

import com.gr.geias.entity.College;
import com.gr.geias.entity.PersonInfo;
import lombok.Data;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-08 20:05
 */
@Data
public class CollegeAndPerson {
    private College college;
    private PersonInfo personInfo;
    private Integer sum;
}
