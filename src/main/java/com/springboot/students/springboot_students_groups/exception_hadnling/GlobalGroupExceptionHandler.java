package com.springboot.students.springboot_students_groups.exception_hadnling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalGroupExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<GroupIncorrectData> handleException(Exception exception){
        GroupIncorrectData data = new GroupIncorrectData();
        data.setInfo(exception.getMessage());
        return new ResponseEntity<>(data, HttpStatus.BAD_REQUEST);
    }

}
