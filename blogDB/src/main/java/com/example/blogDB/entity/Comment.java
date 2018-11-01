package com.example.blogDB.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.FetchType;


@Entity
public class Comment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;					//ID field
	public Long getId() { 				//getter
		return id; 
	}
    public void setId(Long id) { 		//setter
    	this.id = id; 
    }

    private String content;				//content field
    public String getContent() {
    	return content;
    }
    public void setContent(String content) {
    	this.content = content;
    }

   /* @Temporal(TemporalType.DATE)
    Date publicationDate;
    }*/
    
    public Comment() {}	//default  constructor
    
    public Comment(String content, Reader author) {
    	this.content = content;
    	//this.author = author;
    	
    }
    
    /*public String toString() {
    	return "Commented by: " " +  getAuthor() + "\n" + getContent();
    }*/

    
    /*@ManyToOne(fetch = FetchType.EAGER)	//many comments from one author
    @JoinColumn(name = "comment_author")
    private Reader author;
    public Reader getAuthor() {
    	return author;
    }
    
    
    @ManyToOne(fetch = FetchType.Eager)		//many comments on one post
    @JoinColumn(name = "post_commentedOn")
    private Post commentedOn;
    public Post getCommentedOn() {
    	return commentedOn;
    }
    
    */


}
