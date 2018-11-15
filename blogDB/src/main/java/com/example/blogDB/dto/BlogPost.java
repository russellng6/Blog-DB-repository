package com.example.blogDB.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;


public class BlogPost {

	private Long id;
	private String title;
	private String content;
	private boolean visible;
	private byte[] file;
	private String img;
	private int commentCount;
	
	public int getCommentCount() {
		return commentCount;
	}
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	//Comments implemented as list of strings
	private List<String> comments;
	
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

	public BlogPost(String title, String content, boolean visible) {
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
	public BlogPost(Long id, String title, String content, boolean visible, List<String> comments) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.title = title;
		this.content = content;
		this.visible = visible;
		this.comments = comments;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
    public List<String> getComments() {
    	return comments;
    }
    public void addComments(String comment) {
    	comments.add(comment);
    }
    
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}

	
}
