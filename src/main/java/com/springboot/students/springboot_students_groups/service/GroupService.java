package com.springboot.students.springboot_students_groups.service;

import com.springboot.students.springboot_students_groups.dto.*;

import java.util.List;

public interface GroupService {

    List<GetGroupResponseDto> getAllGroups();

    void saveGroup(AddGroupRequestDto addGroupRequestDto);

    GetGroupResponseDto getGroupById(int id);

    GetStudentResponseDto addStudentToGroup(AddStudentRequestDto addStudentRequestDto, int id);

    GetStudentResponseDto updateStudentInGroup(UpdateStudentRequestDto updateStudentDto, int groupId);
}
