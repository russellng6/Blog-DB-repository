package com.example.blogDB.dto;

<<<<<<< HEAD
<<<<<<< HEAD
import java.util.ArrayList;
=======
import org.springframework.web.multipart.MultipartFile;
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
=======
import org.springframework.web.multipart.MultipartFile;
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295

public class BlogPost {

	private Long id;
	private String title;
	private String content;
<<<<<<< HEAD
<<<<<<< HEAD
    //Comments implemented as list of strings
    private ArrayList<String> comments;

=======
=======
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
	private boolean visible;
	private byte[] file;
	private String img;
	
<<<<<<< HEAD
	
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
	
=======
	
	
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
<<<<<<< HEAD
<<<<<<< HEAD
	
    public ArrayList<String> getComments() {
    	return comments;
    }
    public void addComments(String comment) {
    	comments.add(comment);
    }
    
	public BlogPost(Long id, String title, String content) {
=======
	public BlogPost(String title, String content, boolean visible) {
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
=======
	public BlogPost(String title, String content, boolean visible) {
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
		super();
		this.id = id;
		this.title = title;
		this.content = content;
		this.visible = visible;
	}
	public BlogPost(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public BlogPost(Long id, String title, String content, boolean visible) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.content = content;
		this.visible = visible;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
}
