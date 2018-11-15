package com.example.blogDB.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.blogDB.dto.BlogPost;
import com.example.blogDB.entity.Blogger;
import com.example.blogDB.entity.Comment;
import com.example.blogDB.entity.Post;
import com.example.blogDB.entity.Reader;
import com.example.blogDB.repository.BloggerRepository;
import com.example.blogDB.repository.CommentRepository;
import com.example.blogDB.repository.PostRepository;
import com.example.blogDB.repository.ReaderRepository;

@Service
public class BlogService {

	@Autowired
	BloggerRepository bloggerRepository;
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	ReaderRepository readerRepository;
	
	@Autowired
	CommentRepository commentRepository;
	
	
	public List<BlogPost> getAllBlogs() {
		Iterable<Post> users = postRepository.findAll();
		Iterator<Post> itr = users.iterator();
		List<BlogPost> blogs = new ArrayList<BlogPost>();
		
		// checking the next element availabilty
		while (itr.hasNext()) {
			Post post = itr.next();
			BlogPost p = new BlogPost(post.getId(), post.getTitle(), post.getContent(), post.getVisible(), post.getCommentsAsString());
			
			if(post.getCommentsAsString()!=null && !post.getCommentsAsString().isEmpty())
				p.setCommentCount(post.getCommentsAsString().size());
			else
				p.setCommentCount(0);
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
				//in future, need to save posts author as well
		if(newBlog.getId() != null) {
			post = postRepository.findById(newBlog.getId()).orElse(null);

			post.setId(newBlog.getId());
		}
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
	
	//Implementation of adding comments to a blog, i have updated Post.java to contain a list of Comment objects
	//-Russell
	public void addComment(Long p_id, Long r_id, String content) {
	    Post temp = postRepository.findById(p_id).orElse(null);	//find the post with the specified id, otherwise null
	    Reader author = readerRepository.findById(r_id).orElse(null);//find the reader with specified id
	    
		Comment comment = new Comment(content, author, temp);	//create a new comment
		commentRepository.save(comment);
		return;
	}

		
	//return a list of comments for given post id
	public List<String> returnComments(Long p_id) {
		Post temp = postRepository.findById(p_id).orElse(null);
		
		return temp.getCommentsAsString();
	}
	
	//Backend implementation of register and login functions. NEED to be called from the frontend in BlogController.java. 
	//May need to create "Forms" for each Blogger and Reader for the controller
	public boolean registerBlogger(String name, String password) {
		List<Blogger> bloggerLookup = bloggerRepository.findByName(name);	//check to see if name is already taken
		if (bloggerLookup.get(0).getName().equals(name)) {
			System.out.println("Name already taken\n");	//how can we show this error?
			return false;
		}
		else {	//create new blogger in repository and return true
		Blogger newBlogger = new Blogger(name, password);
		bloggerRepository.save(newBlogger);
		return true;
		}
	}
	
	//email field defaults to null. Use this to bind email to blogger account
	public void bindBloggerEmail(String name, String password, String email) {
		List<Blogger> bloggerLookup = bloggerRepository.findByName(name);
		Blogger temp = bloggerLookup.get(0);
		String bloggerName = temp.getName();	//should only be one blogger returned.
		String bloggerPassword = temp.getPassword();
		
		if(bloggerName.equals(name) && bloggerPassword.equals(password)) {
			temp.setEmail(email);
			bloggerRepository.save(temp);	//resave temp to the repository, overwriting the old Blogger
			return;	//should always be true
		}else {
			return;
		}
	}
	
	//given name, email, and new password to save, validate blogger credentials and save the new password
	public void resetBloggerPassword(String name, String password, String email) {
		List<Blogger> bloggerLookup = bloggerRepository.findByName(name);
		Blogger temp = bloggerLookup.get(0);
		String bloggerName = temp.getName();	//should only be one blogger returned.
		String bloggerEmail = temp.getEmail();

		if(bloggerName.equals(name) && bloggerEmail.equals(email)) {
			temp.setPassword(password);
			bloggerRepository.save(temp);	//resave temp to the repository, overwriting the old Blogger
			return;	//should always be true
		}else {
			return;
		}
		
	}
	
	public boolean loginBlogger(String name, String password) {
		List<Blogger> bloggerLookup = bloggerRepository.findByName(name);
		Blogger temp = bloggerLookup.get(0);
		String bloggerName = temp.getName();	//should only be one blogger returned.
		String bloggerPassword = temp.getPassword();
		
		if(bloggerName.equals(name) && bloggerPassword.equals(password)) {
			return true;	//if parameters match, return true
		}else {
			return false;
		}
	}
	
	public boolean registerReader(String name, String password) {
		List<Reader> readerLookup = readerRepository.findByName(name);	//check to see if name is already taken
		if (readerLookup.get(0).getName().equals(name)) {
			System.out.println("Name already taken\n");	//how can we show this error?
			return false;
		}
		else {	//create new reader in repository and return true
		Reader newReader = new Reader(name, password);
		readerRepository.save(newReader);
		return true;
		}
	}
	
	public void bindReaderEmail(String name, String password, String email) {
		List<Reader> readerLookup = readerRepository.findByName(name);
		Reader temp = readerLookup.get(0);
		String readerName = temp.getName();	//should only be one reader returned.
		String readerPassword = temp.getPassword();
		
		if(readerName.equals(name) && readerPassword.equals(password)) {
			temp.setEmail(email);
			readerRepository.save(temp);	//resave temp to the repository, overwriting the old Reader
			return;	//should always be true
		}else {
			return;
		}
	}
	
	//reset reader password given name, email, and new password
	public void resetReaderPassword(String name, String password, String email) {
		List<Reader> readerLookup = readerRepository.findByName(name);
		Reader temp = readerLookup.get(0);
		String readerName = temp.getName();	//should only be one reader returned.
		String readerEmail = temp.getEmail();
		
		if(readerName.equals(name) && readerEmail.equals(email)) {
			temp.setPassword(password);
			readerRepository.save(temp);	//resave temp to the repository, overwriting the old Reader
			return;	//should always be true
		}else {
			return;
		}
	}
	
	public boolean loginReader(String name, String password) {
		List<Reader> readerLookup = readerRepository.findByName(name);
		Reader temp = readerLookup.get(0);
		String readerName = temp.getName();	//should only be one reader returned.
		String readerPassword = temp.getPassword();
		
		if(readerName.equals(name) && readerPassword.equals(password)) {
			return true;	//if parameters match, return true
		}else {
			return false;
		}
	}
	
		

}
