package com.example.blogDB.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.blogDB.dto.BlogForm;
import com.example.blogDB.dto.BlogPost;
import com.example.blogDB.dto.CommentForm;
import com.example.blogDB.entity.Comment;
import com.example.blogDB.entity.Post;
import com.example.blogDB.repository.PostRepository;
import com.example.blogDB.service.BlogService;


@Controller
public class BlogController {

    @Autowired
    BlogService blogService;
    
    @Autowired
    PostRepository postRepository;
    
    @Value("${error.message}")
    private String errorMessage;
    
    @RequestMapping(value = { "/blogList" }, method = RequestMethod.GET)
    public String allBlogs(Model model) {
 
    	List<BlogPost> posts = blogService.getAllBlogs();
    	Collections.reverse(posts);
        model.addAttribute("blogs", posts);
 
        return "list";
    }
 
    @RequestMapping(value = { "/blogList/{id}/delete" })
    public String deleteBlog(Model model, @PathVariable Long id) {
 
        blogService.deleteBlog(id);
        model.addAttribute("blogs", blogService.getAllBlogs());
 
        return "redirect:/blogList";
    }
    
    @RequestMapping(value = { "/blogList/{id}/edit" })
    public String editBlogs(Model model, @PathVariable Long id) {
 
    	Post post = postRepository.findById(id).get();
        model.addAttribute("blog", post);
        BlogForm blogForm = new BlogForm();
        blogForm.setId(post.getId());
        blogForm.setTitle(post.getTitle());
        blogForm.setContent(post.getContent());
        blogForm.setVisible(post.getVisible());
        model.addAttribute("blogForm", blogForm);
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "editBlog";
    }

    
    //Comment implementation
    @RequestMapping(value = { "/blogList/{id}/addComment" }, method = RequestMethod.GET)
    public String showAddCommentPage(Model model, @PathVariable Long id) {
        CommentForm commentForm = new CommentForm();
        Post post = postRepository.findById(id).get();
        List<Comment> comments = post.getComments();
        Collections.reverse(comments);
        model.addAttribute("comments", comments);
        
        commentForm.setBlogId(id);
        model.addAttribute("commentForm", commentForm);
        
        List<BlogPost> blogs = new ArrayList<BlogPost>();
		
		// checking the next element availabilty
		BlogPost p = new BlogPost(post.getId(), post.getTitle(), post.getContent(), post.getVisible(), post.getCommentsAsString());
		p.setFile(post.getImage());
		if(post.getImage() != null) {
			p.setImg(Base64.getEncoder().encodeToString(post.getImage()));
		}
		blogs.add(p);
		
		model.addAttribute("blogs", blogs);
		//model.addAttribute("blogs", blogService.getAllBlogs());
        return "addComment";
    }
 
    @RequestMapping(value = { "/blogList/{id}/addNewComment" }, method = RequestMethod.POST)
    public String saveComment(Model model, @PathVariable Long id, @ModelAttribute("commentForm") CommentForm commentForm) throws IOException {
  
        blogService.addComment(id, 1L, commentForm.getContent());
        Post post = postRepository.findById(id).get();
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "redirect:/blogList/" + id + "/addComment";
    }
    
    //add blogs
    @RequestMapping(value = { "/blogList/addBlog" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        BlogForm blogForm = new BlogForm();
        model.addAttribute("blogForm", blogForm);
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "addBlog";
    }
 
    @RequestMapping(value = { "/blogList/addBlog" }, method = RequestMethod.POST)
    public String saveBlog(Model model, //
            @ModelAttribute("blogForm") BlogForm blogForm) throws IOException {

 
        String title = blogForm.getTitle();
        String content = blogForm.getContent();
        Boolean visible = blogForm.getVisible();
        MultipartFile file = null;
        if(blogForm.getImage() != null) {
            file = blogForm.getImage();
        }
        
        if (title != null && title.length() > 0 //
                && content != null && content.length() > 0) {
            BlogPost newBlog = new BlogPost(title, content, visible);
            if(file != null) {
                newBlog.setFile(file.getBytes());
            }
            
            blogService.saveBlog(newBlog);
 
            return "redirect:/blogList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "addBlog";
    }
    
    @RequestMapping(value = { "/blogList/editBlog/{id}" }, method = RequestMethod.POST)
    public String saveEdittedBlog(Model model, //
            @ModelAttribute("blogForm") BlogForm blogForm, @PathVariable long id) throws IOException {

 
        String title = blogForm.getTitle();
        String content = blogForm.getContent();
        Boolean visible = blogForm.getVisible();
        MultipartFile file = null;
        
        if (title != null && title.length() > 0 //
                && content != null && content.length() > 0) {
            BlogPost newBlog = new BlogPost(title, content, visible);
            newBlog.setId(id);
            
            
            if(blogForm.getImage() != null && blogForm.getImage().getBytes().length > 0) {
                file = blogForm.getImage();
                newBlog.setFile(file.getBytes());
            }else {
            	Post post = postRepository.findById(id).get();
            	if(post.getImage() != null && post.getImage().length > 0) {
            		newBlog.setFile(post.getImage());
            	}
            }
            blogService.saveBlog(newBlog);
 
            return "redirect:/blogList";
        }
 
        model.addAttribute("errorMessage", errorMessage);
        return "addBlog";
    }
    

}
