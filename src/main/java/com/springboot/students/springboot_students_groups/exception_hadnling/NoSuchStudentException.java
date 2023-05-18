package com.springboot.students.springboot_students_groups.exception_hadnling;

public class NoSuchStudentException extends RuntimeException{
    public NoSuchStudentException(String message) {
        super(message);
    }
}
