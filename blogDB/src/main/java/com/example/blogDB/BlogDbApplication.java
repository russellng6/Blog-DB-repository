package com.example.blogDB;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;



@SpringBootApplication
public class BlogDbApplication {
	
	public Blogger createBlogger(String name, String password, String email) {	//create a new Blogger object
		return new Blogger(name, password, email);
	}
	
	public Post createPost(String title, String content, Blogger author) {	//create a new Post object
		return new Post(title, content, author);
	}

	
	public static final Logger log = LoggerFactory.getLogger(BlogDbApplication.class);

	public static void main(String[] args) {

		SpringApplication.run(BlogDbApplication.class);

	}
	
	//test application
	@Bean
	public CommandLineRunner demo(BloggerRepository bloggerRep, PostRepository postRep) {
		return (args) -> {
			//save some dummy Bloggers
			bloggerRep.save(new Blogger("Alice Randomname", "Password1234", "alicer@gmail.com"));
			bloggerRep.save(new Blogger("Bob Othername", "rocky526", "BobbyO@gmail.com"));
			
			//fetch blogger by name
			log.info("Blogger found by name('Alice Randomname'):");
			List<Blogger> foo = bloggerRep.findByName("Alice Randomname");
			log.info(foo.toString());
			
			//save a post, with this blogger as author
			log.info("Posting a blog to this blogger");
			Post temp = new Post("My First Blog!", "This is some text that I'm writing in the blog.\n This is some more text that is in the blog.", foo.get(0));
			postRep.save(temp);
			
			//find this post by author name
			log.info("Retrieving the first blog by author 'Alice Randomname'");
			List<Post> footwo = postRep.findByAuthor(foo.get(0));
			log.info(footwo.toString());
			
			//edit (replace the blog text)
			log.info("Editing the blog with new text");
			//postRep.delete(temp);	//delete
			temp.setContent("This is my revised blog\n now with different words");
			postRep.save(temp);
			footwo = postRep.findByAuthor(foo.get(0));
			log.info(footwo.toString());
			
			//deleting
			log.info("Deleting the blog");
			postRep.delete(temp);
			
			
			//re-searching by author name
			log.info("Contents of the database after blog deletion");
			footwo = postRep.findByAuthor(foo.get(0));
			log.info(footwo.toString());
			
			
		};
	}
	
}
