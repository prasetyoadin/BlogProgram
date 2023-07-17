/**
 * 
 */
package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author Prasetyo Adi
 *
 */
class BlogServiceImplTest {
	
	@Autowired
    private MockMvc mockMvc;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@MockBean
	private BlogService blogService;

	/**
	 * Test method for {@link com.example.demo.services.BlogServiceImpl#save(com.example.demo.models.entities.Blog)}.
	 */
	@Test
	void testSave() {
//		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.demo.services.BlogServiceImpl#findById(java.lang.Long)}.
	 */
	@Test
	void testFindById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.demo.services.BlogServiceImpl#findAll()}.
	 */
	@Test
	void testFindAll() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.demo.services.BlogServiceImpl#update(java.lang.Long, com.example.demo.models.entities.Blog)}.
	 */
	@Test
	void testUpdate() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.demo.services.BlogServiceImpl#removeById(java.lang.Long)}.
	 */
	@Test
	void testRemoveById() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link com.example.demo.services.BlogServiceImpl#findWithPagination(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.String)}.
	 */
	@Test
	void testFindWithPagination() {
		fail("Not yet implemented");
	}

}
