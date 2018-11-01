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
	
    @RequestMapping(value = { "/addBlog" }, method = RequestMethod.GET)
    public String showAddPersonPage(Model model) {
 
        BlogForm blogForm = new BlogForm();
        model.addAttribute("blogForm", blogForm);
        model.addAttribute("blogs", blogService.getAllBlogs());
        return "addBlog";
    }
 
    @RequestMapping(value = { "/addBlog" }, method = RequestMethod.POST)
    public String savePerson(Model model, //
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
    
}
