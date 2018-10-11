package com.example.blogDB.entity;

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
    }
    private boolean visible;
    public boolean getVisible() {
    	return visible;
    }
    
    
    public void setVisible(visible) {
    	this.visible = visible;
    }
    */
    
    public Post() {}	//default  constructor
    
    public Post(String title, String content, Blogger author) {
    	this.title = title;
    	this.content = content;
    	//this.author = author;
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