package com.in28minutes.rest.webservices.restfullwebservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    // GET
    // URI - /hello-world
    //method - "Hello world"
    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World !!" ;
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello world") ;
    }
}
