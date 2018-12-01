package com.example.blogDB.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.blogDB.entity.Admin;


public interface AdminRepository extends CrudRepository<Admin, Long> {
	Optional<Admin> findById(Long id);
	
	List<Admin> findByName(String name);
	
}