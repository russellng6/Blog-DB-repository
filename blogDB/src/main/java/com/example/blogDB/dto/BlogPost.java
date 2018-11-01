package com.example.blogDB.dto;

public class BlogPost {

	private Long id;
	private String title;
	private String content;
	private boolean visible;
	
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
