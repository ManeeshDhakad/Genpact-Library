package com.library.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.entity.Book;  


public interface BookRepository extends CrudRepository<Book, Integer>  
{  
	
}  