package com.springboot.students.springboot_students_groups.controller;

import com.springboot.students.springboot_students_groups.dto.*;
import com.springboot.students.springboot_students_groups.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups/")
public class GroupsController {

    private GroupService groupService;

    @Autowired
    public GroupsController(GroupService groupService) {
        this.groupService = groupService;
    }
    @GetMapping
    public List<GetGroupResponseDto> showAllGroups() {
        return groupService.getAllGroups();
    }

    @GetMapping("/{id}")
    public GetGroupResponseDto showGroupById(@PathVariable int id) {
        return groupService.getGroupById(id);
    }

    @PostMapping("/")
    public void addNewGroup(@RequestBody AddGroupRequestDto addGroupRequestDto) {
        groupService.saveGroup(addGroupRequestDto);
    }

    @PostMapping("/{groupId}")
    public GetGroupResponseDto addStudentToGroup(@RequestBody AddStudentRequestDto addStudentRequestDto,
                                                 @PathVariable int groupId) {
        groupService.addStudentToGroup(addStudentRequestDto, groupId);
        return groupService.getGroupById(groupId);
    }

    @PutMapping("/{groupId}")
    public GetStudentResponseDto updateStudent(@RequestBody UpdateStudentRequestDto updateStudentDto,
                                               @PathVariable int groupId) {
        return groupService.updateStudentInGroup(updateStudentDto, groupId);
    }

}
