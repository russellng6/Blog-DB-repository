package com.example.blogDB.dto;

public class CommentForm {
	private String comment;
	public String getContent() {
		return comment;
	}
	public void setContent(String comment) {
		this.comment = comment;
	}
	public CommentForm(String comment) {
		super();
		this.comment = comment;
		
	}
	public CommentForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
