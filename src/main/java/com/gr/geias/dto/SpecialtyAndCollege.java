package com.gr.geias.dto;

import com.gr.geias.entity.College;
import com.gr.geias.entity.Specialty;
import lombok.Data;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-10 11:09
 */
@Data
public class SpecialtyAndCollege {
    private Specialty specialty;
    private College college;
    private Integer sum;
}
