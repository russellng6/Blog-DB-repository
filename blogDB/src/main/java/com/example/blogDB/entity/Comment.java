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
    
    public Comment(String content, Reader author, Post commentedOn) {
    	this.content = content;
    	this.reader = author;
    	this.post = commentedOn;
    	
    }
    
    public String toString() {
    	if(reader != null)
    		return "Commented by: " +  reader.getName()  + "\n" + getContent();
    	else
    		return "Commented by: " +   "Anonymous " + "\n" + getContent();	
    }

    
    @ManyToOne(fetch = FetchType.EAGER)	//many comments from one author
    @JoinColumn(name = "comment_author")
    private Reader reader;
    public Reader getReader() {
    	return reader;
    }
    
    
    @ManyToOne(fetch = FetchType.EAGER)		//many comments on one post
    @JoinColumn(name = "post_commentedOn")
    private Post post;
    public Post getPost() {
    	return post;
    }
    

}
