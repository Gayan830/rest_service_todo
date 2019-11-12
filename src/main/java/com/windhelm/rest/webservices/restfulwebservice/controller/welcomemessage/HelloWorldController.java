package com.windhelm.rest.webservices.restfulwebservice.controller.welcomemessage;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class HelloWorldController {

    @GetMapping("/")
    private String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello")
    private HelloWorldBean HelloBean(){
//        throw new RuntimeException("Error Occured");
       return new HelloWorldBean("Hello There");
    }

    @GetMapping("/hello/{name}")
    private HelloWorldBean sayHello(@PathVariable String name){
        return new HelloWorldBean(String.format("Hello, %s",name));
    }
}
