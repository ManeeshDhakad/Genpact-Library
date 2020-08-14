package com.library.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.entity.Library;
import com.library.repo.BookRepository;
import com.library.repo.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	LibraryRepository libRepo;
	
	@Autowired 
	BookService bookService;
	
	Logger logger = LoggerFactory.getLogger(LibraryServiceImpl.class);

	@Override
	public List<Library> getAllLibraries() {
		List<Library> libs = new ArrayList<Library>(); 
		try {
			libs = (List<Library>) libRepo.findAll();

		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		 
		return libs;
	}
	
	@Override
	public Library createLibrary(Library lib) {
		Library createLib = new Library();
		try {
			createLib = libRepo.save(lib);
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		
		return createLib;
	}

	@Override
	public Library updateLibrary(Library lib) {
		Library updatedLib = new Library();
		try {
			updatedLib = libRepo.findById(lib.getId()).get();
			if(updatedLib != null) {
				updatedLib = libRepo.save(lib);
			}
			
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		
		return updatedLib;
	}
	
	@Override
	public Library removeLibrary(int id) {
		Library deletedLib = new Library();
		try {
			deletedLib = libRepo.findById(id).get();
			if(deletedLib != null) {
				libRepo.deleteById(id);
			}
			
		} catch(Exception ex) {
			logger.error(ex.getMessage());
		}
		return deletedLib;
	}

}
