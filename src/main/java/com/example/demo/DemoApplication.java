package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}


/**
 * MVC : Model + View + Controller
 * Model :: DATA , View :: UI , Controller :: Manager
 * client --> Ice-cream Manager -->Vanilla(cone)
 *                              --> 1 scoop vanilla --> manager ==> DATA
 *                              --> 1 cone  --> Manager   :: UI ==> VIEW
 *                              Manager --> Vanilla(cone) --> client ==> Controller (request routing)
 *
 *
 */