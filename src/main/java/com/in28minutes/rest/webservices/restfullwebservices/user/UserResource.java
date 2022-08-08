package com.in28minutes.rest.webservices.restfullwebservices.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
      User user = service.findOne(id) ;
       if(user == null){
           throw new UserNotFoundException("id-" + id) ;
       }
      return  user ;
    }

    // CREATED
    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@RequestBody User user){
       User savedUser = service.save(user) ;
       // send the status as  ---- CREATED
        // /user/4 ---- send the ID no to the user
       URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri() ;
       return ResponseEntity.created(location).build() ;
    }
}
