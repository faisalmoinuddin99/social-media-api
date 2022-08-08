package com.in28minutes.rest.webservices.restfullwebservices.model;

import java.util.Date;

public class Post {
    private int postId ;
    private String postTitle ;
    private String postDesc ;
    private Date publishedDate ;

    public Post(int postId, String postTitle, String postDesc, Date publishedDate) {
        this.postId = postId;
        this.postTitle = postTitle;
        this.postDesc = postDesc;
        this.publishedDate = publishedDate;
    }


    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostDesc() {
        return postDesc;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(Date publishedDate) {
        this.publishedDate = publishedDate;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", postTitle='" + postTitle + '\'' +
                ", postDesc='" + postDesc + '\'' +
                ", publishedDate=" + publishedDate +
                '}';
    }
}
