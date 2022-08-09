package com.in28minutes.rest.webservices.restfullwebservices.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    // GET
    // URI - /hello-world
    //method - "Hello world"
    @GetMapping(path = "/hello-world")
    public String helloWorld() {
        return "Hello World !!";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello world");
    }

    @GetMapping(path = "/hello-world/path-variable/{name}")
    public HelloWorldBean helloWordPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }

    @GetMapping(path = "/hello-world-internationalization")
    public String helloWorldInternationalization(
//            @RequestHeader(name = "Accept-Language", required = false) Locale locale
    ) {
//        return "Hello world Internationalization" ;
        return messageSource
                .getMessage(
                        "hello.morning.message",
                        null, "Default Message",
                        LocaleContextHolder.getLocale());
        // en = hello world
        // nl = Hallo Wereld
        // fr = Bonjour le monde
    }
}
