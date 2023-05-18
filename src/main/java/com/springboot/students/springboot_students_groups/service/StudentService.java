package com.springboot.students.springboot_students_groups.service;

import com.springboot.students.springboot_students_groups.dto.GetStudentInfo;
import com.springboot.students.springboot_students_groups.dto.GetStudentResponseDto;

import java.util.List;

public interface StudentService {
    List<GetStudentResponseDto> getAllStudents();
    GetStudentResponseDto getStudent(int id);
    String deleteStudent(int id);
}
