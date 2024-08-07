package com.example.LibraryManagement3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.LibraryManagement3")
public class LibraryManagement3Application {

	public static void main(String[] args) {
		SpringApplication.run(LibraryManagement3Application.class, args);
	}

}
