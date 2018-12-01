package com.example.blogDB.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.example.blogDB.entity.Post;

//@Repository
public interface PostRepository extends CrudRepository<Post, Long> {
	Optional<Post> findById(Long id);
	
	List<Post> findByTitle(String title);
	

	
}
