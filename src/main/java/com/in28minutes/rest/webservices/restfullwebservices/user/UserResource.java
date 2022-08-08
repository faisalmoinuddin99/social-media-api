package com.in28minutes.rest.webservices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    UserDaoService service ;

    // GET /users
    // retrieveAllUsers
    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return service.finaAll() ;
    }


    // retrieveUser(int id)
    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return service.findOne(id) ;
    }

    // CREATED
    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public void createUser(@RequestBody User user){
       User savedUser = service.save(user) ;
    }
}
