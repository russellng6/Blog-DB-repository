package com.example.blogDB.service;

import java.util.ArrayList;
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
			BlogPost p = new BlogPost(post.getId(), post.getTitle(), post.getContent());
			blogs.add(p);
		}
		return blogs;
	}

	public void saveBlog(BlogPost newBlog) {
		
		Post post = new Post();
		post.setTitle(newBlog.getTitle());
		post.setContent(newBlog.getContent());
		postRepository.save(post);
	}

	public void deleteBlog(Long id) {
		postRepository.deleteById(id);
	}

}
