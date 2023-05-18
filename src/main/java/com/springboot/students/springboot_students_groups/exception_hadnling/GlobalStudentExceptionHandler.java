package com.springboot.students.springboot_students_groups.exception_hadnling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalStudentExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<StudentIncorrectData> handleException(Exception exception){
        StudentIncorrectData data = new StudentIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }
}
