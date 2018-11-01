package com.example.blogDB.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogDB.dto.BlogPost;
import com.example.blogDB.entity.Post;
import com.example.blogDB.repository.BloggerRepository;
import com.example.blogDB.repository.PostRepository;

@Service
public class BlogService {

	@Autowired
	PostRepository postRepository;
	
	public List<BlogPost> getAllBlogs() {
		Iterable<Post> users = postRepository.findAll();
		Iterator<Post> itr = users.iterator();
		List<BlogPost> blogs = new ArrayList<BlogPost>();
		
		// checking the next element availabilty
		while (itr.hasNext()) {
			Post post = itr.next();
			BlogPost p = new BlogPost(post.getId(), post.getTitle(), post.getContent(), post.getVisible());
			p.setFile(post.getImage());
			if(post.getImage() != null) {
				p.setImg(Base64.getEncoder().encodeToString(post.getImage()));
			}
			blogs.add(p);
		}
		return blogs;
	}

	public void saveBlog(BlogPost newBlog) throws IOException {
		
		Post post = new Post();
		post.setTitle(newBlog.getTitle());
		post.setContent(newBlog.getContent());
		post.setVisible(newBlog.isVisible());
		/*if(newBlog.getFile() != null && newBlog.getFile().getBytes() != null) {
			post.setImage(newBlog.getFile().getBytes());
		}*/
		post.setImage(newBlog.getFile());
		
		postRepository.save(post);
	}

	public void deleteBlog(Long id) {
		postRepository.deleteById(id);
	} 
	
	//Implementation of adding comments to a blog, i have updated Post.java to contain comments in ArrayList<String> format
	//what is the relationship between Post and BlogPost? 
	//how do i change the blogcontroller to integrate this function
	//-Russell
	public void addComment(Post currentBlog, String comment) {
		currentBlog.addComments(comment);	//add a comment onto the comments list
		return;
	}

}
