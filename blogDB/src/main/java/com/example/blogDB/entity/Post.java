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
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;					//ID field
	public Long getId() { 				//getter
		return id; 
	}
    public void setId(Long id) { 		//setter
    	this.id = id; 
    }

    private String title;
    public String getTitle() {
    	return title;
    }
    public void setTitle(String title) {
    	this.title = title;
    }

    private String content;
    public String getContent() {
    	return content;
    }
    public void setContent(String content) {
    	this.content = content;
    }

   /* @Temporal(TemporalType.DATE)
    Date publicationDate;
    }*/

    private boolean visible;    //set if blog will be visible to users or not. defaults to true
    public boolean getVisible() {
    	return visible;
    }
    
    public void setVisible(boolean visible) {
    	this.visible = visible;
    }

    //category and tags 
    private String category;
    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    private ArrayList<String> tags;
    public ArrayList<String> getTags() {
        return tags;
    }
    public void setTags(ArrayList<String> tags) {
        this.tags = tags;
    }
    public void addTag(String tag) {
        tags.add(tag);
    }
    
    //Comments implemented as list of strings
    private ArrayList<String> comments;
    public ArrayList<String> getComments() {
    	return comments;
    }
    public void addComments(String comment) {
    	comments.add(comment);
    }
    
    public Post() {}	//default  constructor
    
    public Post(String title, String content, Blogger author, String category, ArrayList<String> tags, boolean visible) {
    	this.title = title;
    	this.content = content;
    	//this.author = author;
    	this.category = category;
    	this.tags = tags;
    	this.comments = new ArrayList<String>(comments);	//create empty arraylist to hold comments
    	this.visible = visible;
    	
    }
    
    /*public String toString() {
    	return "Title:" + getTitle() + " " +  getAuthor() + "\n" + getContent();
    }*/

    
    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "blog_author")
    private Blogger author;
    
    public Blogger getAuthor() {
    	return author;
    }*/

    
}