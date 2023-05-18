package com.springboot.students.springboot_students_groups.dao;

import com.springboot.students.springboot_students_groups.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByOrderByIdAsc();
}
