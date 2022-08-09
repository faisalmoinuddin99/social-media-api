package com.in28minutes.rest.webservices.restfullwebservices.service;

import com.in28minutes.rest.webservices.restfullwebservices.model.Post;
import com.in28minutes.rest.webservices.restfullwebservices.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Component
public class UserDaoService {
    private static final List<User> users = new ArrayList<>() ;
    private static final List<Post> posts = new ArrayList<>() ;

    static {
        posts.add(new Post(1,"Goa","Trip to Goa", new Date())) ;
        posts.add(new Post(2,"New York","5 Days in New York", new Date())) ;
    }
    private static int userCount = 3 ;
    static {
        users.add(new User(1,"Adam",new Date(),posts)) ;
        users.add(new User(2,"Eve", new Date())) ;
        users.add(new User(3,"Jack",new Date(), posts)) ;
    }

    public List<User> finaAll() {
        return users ;
    }
     public User save(User user) {

        user.setId(++userCount);
        users.add(user) ;
        return  user ;
     }

     public User findOne(int id) {
        for(User user : users){
            if (user.getId() == id){
                return user ;
            }
        }
        return null ;
     }

     // Retrieve details of a post
    public Post findOnePost(int id,int postId){
        for (User user: users){
            if(user.getId() == id) {
                for (Post post : posts){
                    if (post.getPostId() == postId) {
                        return post ;
                    }
                }
            }
        }
        return null ;
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();
        while (iterator.hasNext()) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
                return user;
            }
        }
        return null ;
    }

}
