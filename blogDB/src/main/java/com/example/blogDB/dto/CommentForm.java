package com.example.blogDB.dto;

public class CommentForm {
	
		private String content;
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		
		public CommentForm(String content) {
			super();

			this.content = content;
		}
		public CommentForm() {
			super();
			// TODO Auto-generated constructor stub
		}
		
	}



