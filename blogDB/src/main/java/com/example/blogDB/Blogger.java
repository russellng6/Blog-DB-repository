package com.example.blogDB;

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

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;					//ID field
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
    
    public Blogger(String name, String password, String email){		//constructor
    	this.name = name;
    	this.password = password;
    	this.email = email;
    }

    public String toString() {
    	return "Author:" + getName();
    }

    //set up relationships
    @OneToMany(mappedBy = "author", cascade = CascadeType.REMOVE, orphanRemoval = true)	//we can remove posts by deleting them from this arrayList
	private List<Post> posts = new ArrayList<Post>();
}