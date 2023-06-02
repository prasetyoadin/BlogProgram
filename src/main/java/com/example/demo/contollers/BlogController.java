/**
 * 
 */
package com.example.demo.contollers;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.BlogData;
import com.example.demo.dto.ResponseData;
import com.example.demo.models.entities.Blog;
import com.example.demo.services.BlogService;

/**
 * @author Prasetyo Adi
 *
 */
@RestController
@RequestMapping("/api/blog")
public class BlogController {

	private static final Logger LOG = LoggerFactory.getLogger(BlogController.class);

	@Autowired
	private BlogService blogService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<ResponseData<Blog>> save(@Valid @RequestBody BlogData blogData, Errors errors) {
		ResponseData<Blog> responseData = new ResponseData<>();
		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		} else {
			Blog blog = modelMapper.map(blogData, Blog.class);

			responseData.getMessages().add(0, "Blog has been Posted");
			responseData.setStatus(true);
			try {
				responseData.setPayload(blogService.save(blog));
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			return ResponseEntity.ok().body(responseData);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseData<Blog>> findById(@PathVariable("id") Long id) {
		ResponseData<Blog> responseData = new ResponseData<>();
		responseData.getMessages().add(0, "Get Blog By Id Successfully");
		responseData.setStatus(true);
		try {
			responseData.setPayload(blogService.findById(id));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return ResponseEntity.ok().body(responseData);

	}

	@GetMapping
	public ResponseEntity<ResponseData<List<Blog>>> findById() {
		ResponseData<List<Blog>> responseData = new ResponseData<>();
		responseData.getMessages().add(0, "Get All Blog Successfully");
		responseData.setStatus(true);
		try {
			responseData.setPayload((List<Blog>) blogService.findAll());
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return ResponseEntity.ok().body(responseData);

	}

	@PutMapping("/{id}")
	public ResponseEntity<ResponseData<Blog>> update(@Valid @RequestBody BlogData blogData, @PathVariable("id") Long id,
			Errors errors) {
		ResponseData<Blog> responseData = new ResponseData<>();
		if (errors.hasErrors()) {
			for (ObjectError error : errors.getAllErrors()) {
				responseData.getMessages().add(error.getDefaultMessage());
			}
			responseData.setStatus(false);
			responseData.setPayload(null);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
		} else {
			Blog blog = modelMapper.map(blogData, Blog.class);

			responseData.setStatus(true);
			try {
				responseData.setPayload(blogService.update(id, blog));
				if (responseData.getPayload() == null) {
					responseData.getMessages().add(0, "Blog Not Found, Failed to Update");
				} else {
					responseData.getMessages().add(0, "Blog has been Updated");
				}
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			return ResponseEntity.ok().body(responseData);
		}

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseData<Blog>> deleteById(@PathVariable("id") Long id) {
		ResponseData<Blog> responseData = new ResponseData<>();

		responseData.setStatus(true);
		try {
			responseData.setPayload(blogService.removeById(id));
			if (responseData.getPayload() == null) {
				responseData.getMessages().add(0, "Blog Not Found, Failed to Delete");
			} else {
				responseData.getMessages().add(0, "Blog has been Deleted");
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return ResponseEntity.ok().body(responseData);

	}
	
	@GetMapping("/search")
	public ResponseEntity<ResponseData<Page<Blog>>> findWithPagination(@RequestParam("pageIndex") Integer pageIndex,
			@RequestParam(name = "pageSize") Integer pageSize,
			@RequestParam(name = "sortField", required = false) String sortField,
			@RequestParam(name = "sortDirection", required = false) String sortDirection) {
		ResponseData<Page<Blog>> responseData = new ResponseData<>();
		responseData.getMessages().add(0, "Get All Blog Successfully");
		responseData.setStatus(true);
		try {
			responseData.setPayload((Page<Blog>) blogService.findWithPagination(pageIndex, pageSize, sortField, sortDirection));
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		return ResponseEntity.ok().body(responseData);

	} 
}
