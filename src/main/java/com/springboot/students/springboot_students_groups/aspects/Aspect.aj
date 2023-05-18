package com.springboot.students.springboot_students_groups.aspects;

import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@org.aspectj.lang.annotation.Aspect
public aspect Aspect {

    @Pointcut("execution(* * (..))")
    public void all(){}

    @Before("all()")
    public void aLL1(){

    }
}
