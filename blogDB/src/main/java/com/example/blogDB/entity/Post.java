package com.example.blogDB.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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

    @Column(columnDefinition = "TEXT")
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
    /*
    private ArrayList<String> comments;
    public ArrayList<String> getComments() {
    	return comments;
    }
    public void addComments(String comment) {
    	comments.add(comment);
    }*/
    
    public Post() {}	//default  constructor
    
    public Post(String title, String content, Blogger author, String category, ArrayList<String> tags, boolean visible) {
    	this.title = title;
    	this.content = content;
    	//this.author = author;
    	this.category = category;
    	this.tags = tags;
    	this.visible = visible;
    	
    }
    
    public String toString() {
    	return "Title:" + getTitle() + " " +  getBlogger() + "\n" + getContent();
    }
    
    
    
    @OneToMany(targetEntity=Comment.class, mappedBy = "post", cascade = CascadeType.REMOVE, orphanRemoval = true)	//we can remove Comments by deleting them from this arrayList
  	public List<Comment> comments;
  	public List<Comment> getComments() {
  		return comments;
  	}
  	public void setComment(List<Comment> comments) {
  		this.comments = comments;
  	}
    //convert comments to string with comment.toString()
    public List<String> getCommentsAsString() {
        List<String> temp = new ArrayList<String>();
        List<Comment> foo =  this.getComments();
        for(int i = 0; i < foo.size(); i++) {
            temp.add(foo.get(i).toString());
        }
        
        return temp;
    }


    
    @ManyToOne
    @JoinColumn(name = "blog_author")
    private Blogger blogger;
    public Blogger getBlogger() {
    	return blogger;
    }
    public void setBlogger(Blogger blogger) {
    	this.blogger= blogger;
    }
    
    @Lob 
    @Column(length=10000000)
    private byte[] image;
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
    


    
}