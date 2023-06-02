/**
 * 
 */
package com.example.demo.dto;

import javax.validation.constraints.NotEmpty;

/**
 * @author Prasetyo Adi
 *
 */
public class BlogData {

	@NotEmpty(message = "Author is required")
	private String author;
	
	@NotEmpty(message = "Title is required")
	private String title;
	
	@NotEmpty(message = "Body is required")
	private String body;

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	
}
