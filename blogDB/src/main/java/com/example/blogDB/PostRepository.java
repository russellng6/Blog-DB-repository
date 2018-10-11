package com.example.blogDB;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	List<Post> findByTitle(String title);
	
	List<Post> findByAuthor(Blogger author);
	
}
