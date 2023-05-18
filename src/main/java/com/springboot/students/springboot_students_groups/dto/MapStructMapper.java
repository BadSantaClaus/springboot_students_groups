package com.springboot.students.springboot_students_groups.dto;

import com.springboot.students.springboot_students_groups.entity.Group;
import com.springboot.students.springboot_students_groups.entity.Student;


import java.util.List;

public interface MapStructMapper {
    GetGroupInfo getGroupInfo(Group group);
    GetGroupResponseDto getGroupById(int id);
    GetStudentInfo getStudentInfo(Student student);
    GetStudentResponseDto getStudentDto(Student student);
    Student updateStudentInGroup(UpdateStudentRequestDto updateStudentDto, int groupId);
    GetStudentResponseDto saveStudentInGroup(AddStudentRequestDto addStudentRequestDto, int groupId);
    GetGroupResponseDto addGroup(AddGroupRequestDto addGroupRequestDto);
    List<GetStudentResponseDto> getStudentsInfoList(List<Student> students);
    List<GetGroupResponseDto> getGroupsInfoList();
    GetStudentResponseDto getStudentById(int studentId);
}
