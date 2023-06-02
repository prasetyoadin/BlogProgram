/**
 * 
 */
package com.example.demo.helpers;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Prasetyo Adi
 *
 */

@Configuration
public class ModelMapperHelper {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
}
