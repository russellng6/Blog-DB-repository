package com.example.blogDB;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

//@Repository
public interface BloggerRepository extends CrudRepository<Blogger, Long> {
	List<Blogger> findByName(String name);
	
	//List<Post> findByPosts(ArrayList<Post> posts);
	
}
