package com.springboot.students.springboot_students_groups.service;

import com.springboot.students.springboot_students_groups.dao.GroupRepository;
import com.springboot.students.springboot_students_groups.dao.StudentRepository;
import com.springboot.students.springboot_students_groups.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.OrderBy;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;
    private MapStructMapper mapStructMapper;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, StudentRepository studentRepository,
                            MapStructMapper mapStructMapper) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
        this.mapStructMapper = mapStructMapper;
    }

    @Override
    @OrderBy("id")
    public List<GetGroupResponseDto> getAllGroups() {
        return mapStructMapper.getGroupsInfoList();
    }

    @Override
    public void saveGroup(AddGroupRequestDto addGroupRequestDto) {
        mapStructMapper.addGroup(addGroupRequestDto);
    }

    @Override
    public GetGroupResponseDto getGroupById(int groupId) {
        return mapStructMapper.getGroupById(groupId);
    }

    @Override
    public GetStudentResponseDto addStudentToGroup(AddStudentRequestDto addStudentRequestDto, int groupId) {
        return mapStructMapper.saveStudentInGroup(addStudentRequestDto, groupId);
    }

    @Override
    public GetStudentResponseDto updateStudentInGroup(UpdateStudentRequestDto updateStudentDto, int groupId) {
        return mapStructMapper.getStudentDto(mapStructMapper.updateStudentInGroup(updateStudentDto, groupId));
    }


}
