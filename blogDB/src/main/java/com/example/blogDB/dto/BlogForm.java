package com.example.blogDB.dto;

import org.springframework.web.multipart.MultipartFile;

public class BlogForm {

	private String title;
	private String content;
	private Boolean visible;
	private MultipartFile image;
	

	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}
	public Boolean getVisible() {
		return visible;
	}
	public void setVisible(Boolean visible) {
		this.visible = visible;
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
	public void setContent(String content) {
		this.content = content;
	}
	public BlogForm(String title, String content, Boolean visible) {
		super();
		this.title = title;
		this.content = content;
		this.visible = visible;
	}
	public BlogForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
