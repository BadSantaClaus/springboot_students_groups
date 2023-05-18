package com.springboot.students.springboot_students_groups.controller;

import com.springboot.students.springboot_students_groups.dto.GetStudentResponseDto;
import com.springboot.students.springboot_students_groups.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students/")
public class StudentsController {
    private StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<GetStudentResponseDto> showAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public GetStudentResponseDto showStudentById(@PathVariable int id) {
        return studentService.getStudent(id);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id) {
        return studentService.deleteStudent(id);
    }
}
