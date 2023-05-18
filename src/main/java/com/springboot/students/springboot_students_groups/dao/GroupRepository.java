package com.springboot.students.springboot_students_groups.dao;

import com.springboot.students.springboot_students_groups.entity.Group;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepository extends JpaRepository<Group, Integer> {
}
