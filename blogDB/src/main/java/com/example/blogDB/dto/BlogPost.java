package com.example.blogDB.dto;

public class BlogPost {

	private Long id;
	private String title;
	private String content;
	
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
	public BlogPost(Long id, String title, String content) {
		super();
		this.id = id;
		this.title = title;
		this.content = content;
	}
	public BlogPost(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public BlogPost() {
		super();
		// TODO Auto-generated constructor stub
	}
}
