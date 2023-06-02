/**
 * 
 */
package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.models.entities.Blog;
import com.example.demo.models.repos.BlogRepository;


/**
 * @author Prasetyo Adi
 *
 */
@Service
@Transactional
public class BlogServiceImpl implements BlogService {
	
	@Autowired
	private BlogRepository BlogRepository;

	@Override
	public Blog save(Blog blog) throws Exception {
		return BlogRepository.save(blog);
	}

	@Override
	public Blog findById(Long id) throws Exception {
		Optional<Blog> entity = BlogRepository.findById(id);
		if (entity.isPresent()) {
			return BlogRepository.findById(id).get();
		} else {
			return null;
		}
		
	}

	@Override
	public List<Blog> findAll() throws Exception {
		List<Blog> blogList = BlogRepository.findAll();
		return blogList;
	}

	@Override
	public Blog update(Long id, Blog blog) throws Exception {
		Optional<Blog> entityOpt = BlogRepository.findById(id);
		if (entityOpt.isPresent()) {
			Blog entity = BlogRepository.findById(id).get();
			entity.setAuthor(blog.getAuthor());
			entity.setTitle(blog.getTitle());
			entity.setBody(blog.getBody());
			return BlogRepository.save(entity);
		} else {
			return null;
		}
	}

	@Override
	public Blog removeById(Long id) throws Exception {
		Optional<Blog> entityOpt = BlogRepository.findById(id);
		if (entityOpt.isPresent()) {
			Blog entity = BlogRepository.findById(id).get();
			BlogRepository.deleteById(id);
			return entity;
		} else {
			return null;
		}
		
	}

	@Override
	public Page<Blog> findWithPagination(Integer pageIndex, Integer pageSize, String sortField, String sortDirection)
			throws Exception {
		PageRequest pageRequest;

		if (sortField != null) {
			Sort.Direction direction = Sort.Direction.fromOptionalString(sortDirection).orElse(Sort.Direction.ASC);
			pageRequest = PageRequest.of(pageIndex, pageSize, direction, sortField);
		} else {
			pageRequest = PageRequest.of(pageIndex, pageSize);
		}
		return BlogRepository.findAll(pageRequest);
	}

}
