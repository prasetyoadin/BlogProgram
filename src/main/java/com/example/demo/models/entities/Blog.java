/**
 * 
 */
package com.example.demo.models.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Prasetyo Adi
 *
 */

@Entity
@Table(name = "blog")
public class Blog implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1279064823913356106L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String author;
	
	@Column
	private String title;
	
	@Column
	private String body;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	public Blog() {
		
	}

	public Blog(Long id, String author, String title, String body) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
		this.body = body;
	}
	
	
	
	

}
