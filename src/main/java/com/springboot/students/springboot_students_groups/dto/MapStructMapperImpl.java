package com.springboot.students.springboot_students_groups.dto;

import com.springboot.students.springboot_students_groups.entity.Group;
import com.springboot.students.springboot_students_groups.entity.Student;
import com.springboot.students.springboot_students_groups.dao.GroupRepository;
import com.springboot.students.springboot_students_groups.dao.StudentRepository;
import com.springboot.students.springboot_students_groups.exception_hadnling.NoSuchGroupException;
import com.springboot.students.springboot_students_groups.exception_hadnling.NoSuchStudentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class MapStructMapperImpl implements MapStructMapper {

    private GroupRepository groupRepository;
    private StudentRepository studentRepository;

    @Autowired
    public MapStructMapperImpl(GroupRepository groupRepository, StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    //*************************************Groups**************************

    @Override
    public GetGroupInfo getGroupInfo(Group group) {
        if (group == null) {
            return null;
        }
        GetGroupInfo getGroupInfo = new GetGroupInfo();
        getGroupInfo.setId(group.getId());
        getGroupInfo.setName(group.getName());
        return getGroupInfo;
    }

    @Override
    public GetGroupResponseDto getGroupById(int groupId) {
        GetGroupResponseDto getGroupResponseDto = new GetGroupResponseDto();
        Optional<Group> optionalGroup = groupRepository.findById(groupId);
        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            getGroupResponseDto.setId(group.getId());
            getGroupResponseDto.setName(group.getName());
            getGroupResponseDto.setStudents(getStudentsInfoList(group.getStudents()));
        } else  {
            throw new NoSuchGroupException("There is no group with id: " + groupId + " in Database");
        }
        return getGroupResponseDto;
    }

    @Override
    public GetGroupResponseDto addGroup(AddGroupRequestDto addGroupRequestDto) {
        Group group = new Group();
        group.setName(addGroupRequestDto.getName());
        groupRepository.save(group);
        return getGroupById(group.getId());
    }

    @Override
    public List<GetGroupResponseDto> getGroupsInfoList() {
        List<Group>  groups = groupRepository.findAll();
        List<GetGroupResponseDto> getGroupInfoList = new ArrayList<>();
        for (Group group : groups) {
            getGroupInfoList.add(getGroupById(group.getId()));
        }
        return getGroupInfoList;
    }

    //*************************************Students**************************

    @Override
    public GetStudentInfo getStudentInfo(Student student) {
        if (student == null) {
            return null;
        }
        GetStudentInfo getStudentInfo = new GetStudentInfo();
        getStudentInfo.setId(student.getId());
        getStudentInfo.setFullName(student.getFullName());
        getStudentInfo.setAdmissionDate(student.getAdmissionDate());
        return getStudentInfo;
    }

    @Override
    public GetStudentResponseDto getStudentDto(Student student) {
        GetStudentResponseDto getStudentsResponseDto = new GetStudentResponseDto();
        getStudentsResponseDto.setId(student.getId());
        getStudentsResponseDto.setFullName(student.getFullName());
        getStudentsResponseDto.setAdmissionDate(student.getAdmissionDate());
        getStudentsResponseDto.setGroup(getGroupInfo(student.getGroup()));
        return getStudentsResponseDto;
    }

    @Override
    public Student updateStudentInGroup(UpdateStudentRequestDto updateStudentDto, int groupId) {
        Student student = new Student();
        student.setFullName(updateStudentDto.getFullName());
        student.setAdmissionDate(LocalDate.parse(updateStudentDto.getAdmissionDate(),
                DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        student.setId(updateStudentDto.getId());
        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if (optionalGroup.isPresent()) {
            Group group = optionalGroup.get();
            student.setGroup(group);
            List<Student> studentList = group.getStudents();
            System.out.println("studentList.indexOf(student)");
            studentList.set(studentList.indexOf(student), student);
        } else throw new NoSuchGroupException("There is no group with id: " + groupId + " in Database");

        studentRepository.save(student);
        return student;
    }

    @Override
    public GetStudentResponseDto saveStudentInGroup(AddStudentRequestDto addStudentRequestDto, int groupId) {
        Student student = new Student();
        Optional<Group> optionalGroup = groupRepository.findById(groupId);

        if(optionalGroup.isPresent()){
            student.setGroup(optionalGroup.get());
            student.setFullName(addStudentRequestDto.getFullName());
            student.setAdmissionDate(LocalDate.parse(addStudentRequestDto.getAdmissionDate(),
                    DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        } else {
            throw new NoSuchGroupException("There is no group with id: " + groupId + " in Database");
        }
        studentRepository.save(student);

        optionalGroup.get().getStudents().add(student);
        return getStudentDto(student);
    }

    @Override
    public List<GetStudentResponseDto> getStudentsInfoList(List<Student> students) {
        if (students == null) {
            return null;
        }
        List<GetStudentResponseDto> getStudentsResponseDtoList = new ArrayList<>();
        for (Student student : students) {
            getStudentsResponseDtoList.add(getStudentDto(student));
        }
        return getStudentsResponseDtoList;
    }

    @Override
    public GetStudentResponseDto getStudentById(int studentId) {
        GetStudentResponseDto student = null;
        Optional<Student> optionalStudent = studentRepository.findById(studentId);
        if (optionalStudent.isPresent()) {
            student = getStudentDto(optionalStudent.get());
        } else {
            throw new NoSuchStudentException("There is no student with id: " + studentId + " in Database");
        }
        return student;
    }

}

