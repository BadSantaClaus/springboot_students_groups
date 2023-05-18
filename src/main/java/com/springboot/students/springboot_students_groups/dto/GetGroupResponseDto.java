package com.springboot.students.springboot_students_groups.dto;

import lombok.Data;

import java.util.List;

@Data
public class GetGroupResponseDto {

    private Integer id;
    private String name;
    private List<GetStudentResponseDto> students;

}
