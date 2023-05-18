package com.springboot.students.springboot_students_groups.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetStudentInfo {
    private int id;
    private String fullName;
    private String admissionDate;

}
