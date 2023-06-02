/**
 * 
 */
package com.example.demo.models.repos;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.entities.Blog;

/**
 * @author Prasetyo Adi
 *
 */
public interface BlogRepository extends JpaRepository<Blog, Long> {
	
//	Page<Blog> findByAuthorAndTittleAndBody(String author, String title, String body, Pageable page);

}
