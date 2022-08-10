package com.in28minutes.rest.webservices.restfullwebservices.filtering;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping(path = "/filtering")
    public SomeBean retrieveSomeBean(){
        return new SomeBean("Value1", "Value2", "Value3") ;
    }
    @GetMapping(path = "/filtering-list")
    public List<SomeBean> filteringList(){
        return Arrays.asList(
                new SomeBean("value21","value22","value23") ,
                new SomeBean("value31","value32","value33")

        ) ;
    }
}
