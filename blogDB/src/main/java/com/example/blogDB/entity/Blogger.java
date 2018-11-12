package com.example.blogDB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Blogger {

	private Long id;					//ID field
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Long getId() { 				//getter
		return id; 
	}
    public void setId(Long id) { 		//setter
    	this.id = id; 
    }

    private String name;				//name field
    public String getName() { 		//getter
		return name; 
	}
    public void setName(String name) { 	//setter
    	this.name = name; 
    }

    private String password;			//password field
    public String getPassword() { 		//getter
		return password; 
	}
    public void setPassword(String password) { //setter
    	this.password = password; 
    }

    private String email;				//email field
    public String getEmail() { 		//getter
		return email; 
	}
    public void setEmail(String email) { 	//setter
    	this.email = email; 
    }

    protected Blogger() {}	//default constructor, for JPA
    
    public Blogger(String name, String password){		//constructor
    	this.name = name;
    	this.password = password;
    	this.email = null;
    }

    public String toString() {
    	return "Author:" + getName();
    }

    //set up relationships
    @OneToMany(targetEntity=Post.class, mappedBy = "blogger", cascade = CascadeType.REMOVE, orphanRemoval = true)	//we can remove posts by deleting them from this arrayList
	public List<Post> posts;
	public List<Post> getPosts() {
		return posts;
	}
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
    
    
    
}