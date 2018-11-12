package com.example.blogDB.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.blogDB.entity.Reader;


public interface ReaderRepository extends CrudRepository<Reader, Long> {
	Optional<Reader> findById(Long id);
	
	List<Reader> findByName(String name);
	
	//List<Comment> findByReader(ArrayList<Post> posts); 
	
}