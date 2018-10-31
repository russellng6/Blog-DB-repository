package com.example.blogDB.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

@Entity
public class Reader {

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

    protected Reader() {}	//default constructor, for JPA
    
    public Reader(String name, String password, String email){		//constructor
    	this.name = name;
    	this.password = password;
    	this.email = email;
    }

    public String toString() {
    	return "Reader:" + getName();
    }
    
    /*

    //set up relationships
    @OneToMany(targetEntity=Comment.class, mappedBy = "reader", cascade = CascadeType.REMOVE, orphanRemoval = true)	//we can remove comments by deleting them from this arrayList
	public List<Comment> comments;
	public List<Comment> getComments() {
		return comments;
	}
	public void setPosts(List<Comment> comments) {
		this.comments = comments;
	}*/
}
