package com.example.blogDB.controller;

import java.io.IOException;

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
import com.example.blogDB.service.BlogService;


@Controller
public class BlogController {

	@Autowired
	BlogService blogService;
	
	@Value("${error.message}")
    private String errorMessage;
	
	@RequestMapping(value = { "/blogList" }, method = RequestMethod.GET)
    public String personList(Model model) {
 
        model.addAttribute("blogs", blogService.getAllBlogs());
 
        return "list";
    }
 
	@RequestMapping(value = { "/blogList/{id}" })
    public String personList(Model model, @PathVariable Long id) {
 
		blogService.deleteBlog(id);
        model.addAttribute("blogs", blogService.getAllBlogs());
 
        return "redirect:/blogList";
    }
	
		//preliminary controller implementation for adding comment
		//get info, into commentform
	   @RequestMapping(value = { "/blogList/{id}/addComment" }, method = RequestMethod.GET)
    	public String showAddCommentPage(Model model, @PathVariable Long id) {
 
        CommentForm commentForm = new CommentForm();	//create the comment form
        model.addAttribute("commentForm", commentForm);
        model.addAttribute("blogs", blogService.getAllBlogs());

        return "blogList/{id}/addComment";
    }
	
	  	@RequestMapping(value = { "/blogList/{id}/addComment" }, method = RequestMethod.POST)
    	public String commentList(Model model, @PathVariable Long id,  @ModelAttribute("commentForm") CommentForm commentForm) {	
 
		blogService.addComment(id, commentForm.getContent());	//get the string content from commentForm
 
        return "redirect:/blogList";
    }
	
	 
	
    @RequestMapping(value = { "/addBlog" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        BlogForm blogForm = new BlogForm();
        model.addAttribute("blogForm", blogForm);
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "addBlog";
    }
 
    @RequestMapping(value = { "/addBlog" }, method = RequestMethod.POST)
<<<<<<< HEAD
<<<<<<< HEAD
    public String savePerson(Model model, 
            @ModelAttribute("blogForm") BlogForm blogForm) {
=======
    public String savePerson(Model model, //
            @ModelAttribute("blogForm") BlogForm blogForm) throws IOException {
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
=======
    public String savePerson(Model model, //
            @ModelAttribute("blogForm") BlogForm blogForm) throws IOException {
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
 
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
    
<<<<<<< HEAD
<<<<<<< HEAD
    
    
    
=======
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
=======
>>>>>>> a3747cb0f55e39738ddf17e53c1d6f887d874295
}
