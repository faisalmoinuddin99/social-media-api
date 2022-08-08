package com.in28minutes.rest.webservices.restfullwebservices.model;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public class User {
    private int id ;
    private String name ;

    private Date birthDate ;

    private List<Post> post ;



    public User(int id, String name, Date birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(int id, String name, Date birthDate, List<Post> post) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
        this.post = post;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public List<Post> getPost() {
        return post;
    }

    public void setPost(List<Post> post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", post=" + post +
                '}';
    }
}
