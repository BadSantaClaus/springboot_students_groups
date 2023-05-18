package com.springboot.students.springboot_students_groups.service;

import com.springboot.students.springboot_students_groups.entity.Group;
import com.springboot.students.springboot_students_groups.entity.Student;
import com.springboot.students.springboot_students_groups.dao.StudentRepository;
import com.springboot.students.springboot_students_groups.dto.*;
import com.springboot.students.springboot_students_groups.exception_hadnling.NoSuchStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private MapStructMapper mapStructMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, MapStructMapper mapStructMapper) {
        this.studentRepository = studentRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    public List<GetStudentResponseDto> getAllStudents() {
        return mapStructMapper.getStudentsInfoList(studentRepository.findByOrderByIdAsc());
    }

    @Override
    public GetStudentResponseDto getStudent(int studentId) {
        return mapStructMapper.getStudentById(studentId);
    }

    @Override
    public String deleteStudent(int studentId) {
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        String returnMessage;
        if (optionalStudent.isPresent()) {
            String name = optionalStudent.get().getFullName();
            Group group = optionalStudent.get().getGroup();
            group.getStudents().remove(getStudent(studentId));
            studentRepository.deleteById(studentId);
            returnMessage = "Student " + name + " was deleted";
        } else {
            throw new NoSuchStudentException("There is no student with id: " + studentId + " in Database");
        }
        return returnMessage;
    }
}

