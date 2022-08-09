package com.in28minutes.rest.webservices.restfullwebservices.controller;

import com.in28minutes.rest.webservices.restfullwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfullwebservices.model.User;
import com.in28minutes.rest.webservices.restfullwebservices.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
    public EntityModel<User> retrieveUser(@PathVariable int id){
      User user = service.findOne(id) ;
       if(user == null){
           throw new UserNotFoundException("id-" + id) ;
       }
       EntityModel<User> model = EntityModel.of(user) ;
       WebMvcLinkBuilder linkToUsers = linkTo(methodOn(this.getClass()).retrieveAllUsers()) ;

       model.add(linkToUsers.withRel("all-users")) ;

      return  model ;
    }



    // CREATED
    // input - details of user
    // output - CREATED & Return the created URI
    @PostMapping("/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
       User savedUser = service.save(user) ;
       // send the status as  ---- CREATED
        // /user/4 ---- send the ID no to the user
       URI location =  ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId()).toUri() ;
       return ResponseEntity.created(location).build() ;
    }
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id){
        User user =service.deleteById(id) ;
        if (user == null){
            throw new UserNotFoundException("id-"+id) ;
        }

    }
}
