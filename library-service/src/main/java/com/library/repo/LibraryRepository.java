package com.library.repo;

import org.springframework.data.repository.CrudRepository;

import com.library.entity.Library;  


public interface LibraryRepository extends CrudRepository<Library, Integer>  
{  
}  