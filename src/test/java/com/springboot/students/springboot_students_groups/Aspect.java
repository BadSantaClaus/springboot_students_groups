package com.springboot.students.springboot_students_groups;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@org.aspectj.lang.annotation.Aspect
@Component
public class Aspect {

    @Before("execution(* *(..))")
    public void all(){}

}
