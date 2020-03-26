package com.gr.geias.dto;

import com.gr.geias.entity.ClassGrade;
import com.gr.geias.entity.PersonInfo;
import com.gr.geias.entity.Specialty;
import lombok.Data;

/**
 * @author maitentai
 * @version 1.0
 * @date 2020-03-10 15:57
 */
@Data
public class ClassGradeAndSpecialty {
    private ClassGrade classGrade;
    private Specialty specialty;
    private PersonInfo personInfo;
    private Integer sum;
}
