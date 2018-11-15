package com.example.blogDB.dto;

public class CommentForm {
	private String comment;
	private Long blogId;

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getBlogId() {
		return blogId;
	}

	public void setBlogId(Long blogId) {
		this.blogId = blogId;
	}

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
