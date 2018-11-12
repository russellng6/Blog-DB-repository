package com.example.blogDB.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.example.blogDB.entity.Blogger;


//@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {
	Optional<Blogger> findById(Long id);
	
	List<Blogger> findByName(String name);
	
}
