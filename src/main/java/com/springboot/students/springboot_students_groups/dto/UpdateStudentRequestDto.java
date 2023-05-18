package com.springboot.students.springboot_students_groups.dto;

import lombok.*;

@Data
public class UpdateStudentRequestDto {
    private Integer id;
    private String fullName;
    private String admissionDate;

}
