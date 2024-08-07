package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class SecurityAspect {

    @Before("execution(* com.library.service.BookService.addBook(..))")
    public void checkSecurity() {
        System.out.println("Checking security before adding a book...");
        // Here you could add actual security checks
    }
}