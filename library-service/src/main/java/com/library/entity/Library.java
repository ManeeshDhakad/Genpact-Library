package com.library.entity;


import javax.persistence.Column;  
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;  
 
@Entity  
@Table  
public class Library   
{  
	@Id   
	@GeneratedValue
	private int id;  
	
	@Column  
	private String name;  
	
//	@Column  
//	@OneToMany
//	private List<Book> books;  
	
	@Column  
	private String description;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

//	public List<Book> getBooks() {
//		return books;
//	}
//
//	public void setBooks(List<Book> books) {
//		this.books = books;
//	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}  	
}  