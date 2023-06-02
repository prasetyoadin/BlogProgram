/**
 * 
 */
package com.example.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.entities.Blog;

/**
 * @author Prasetyo Adi
 *
 */
public interface BlogService {

	public Blog save(Blog blog) throws Exception;

	public Blog findById(Long id) throws Exception;

	public List<Blog> findAll() throws Exception;

	public Blog update(Long id, Blog blog) throws Exception;

	public Blog removeById(Long id) throws Exception;

	public Page<Blog> findWithPagination(Integer pageIndex, Integer pageSize, String sortField, String sortDirection) throws Exception;

}
