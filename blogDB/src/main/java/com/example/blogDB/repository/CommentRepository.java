package com.example.blogDB.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.example.blogDB.entity.Comment;

//@Repository
public interface CommentRepository extends CrudRepository<Comment, Long> {
	Optional<Comment> findById(Long id);
	
	
}
