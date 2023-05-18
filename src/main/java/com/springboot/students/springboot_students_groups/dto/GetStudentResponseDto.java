package com.springboot.students.springboot_students_groups.dto;

import lombok.Data;

@Data
public class GetStudentResponseDto {

    private int id;
    private String fullName;
    private String admissionDate;
    private GetGroupInfo group;

}
