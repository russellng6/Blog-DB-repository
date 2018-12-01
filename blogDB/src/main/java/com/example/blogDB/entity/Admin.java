package com.example.blogDB.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Access;
import javax.persistence.AccessType;



@Entity
@Access(AccessType.FIELD)
public class Admin {

	@Id
	private Long id;					//ID field
	

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


    protected Admin() {}	//default constructor, for JPA
    
    public Admin(String name, String password){		//constructor
    	this.name = name;
    	this.password = password;
    }

    public String toString() {
    	return "Admin:" + getName();
    }
    
}
