package com.springboot.students.springboot_students_groups.exception_hadnling;

public class NoSuchGroupException extends RuntimeException {

    public NoSuchGroupException(String message) {
        super(message);
    }
}
