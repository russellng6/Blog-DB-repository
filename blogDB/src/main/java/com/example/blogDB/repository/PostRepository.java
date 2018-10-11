package com.example.blogDB.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.blogDB.entity.Blogger;
import com.example.blogDB.entity.Post;

//@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	//List<Post> findByTitle(String title);
	
	//List<Post> findByBlogger(Blogger blogger);
	
}
