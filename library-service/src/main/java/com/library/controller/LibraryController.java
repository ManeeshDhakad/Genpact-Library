package com.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.entity.Library;
import com.library.model.LibModel;
import com.library.service.LibraryService;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin
public class LibraryController {

	@Autowired
	LibraryService libService;
	
	@GetMapping("allLibs")
	public List<Library> getAllLibraries() {
		 return libService.getAllLibraries();
	}
	
	@PostMapping("createdLib")
	public Library createLibrary(@RequestBody Library lib) {
		 return libService.createLibrary(lib);
	}
	
	@PostMapping("updateLib")
	public Library updateLibrary(@RequestBody Library lib) {
		 return libService.updateLibrary(lib);
	}
	
	@DeleteMapping("deleteLib/{libId}")
	public void removeLibrary(@PathVariable("libId") int libId) {
		 libService.removeLibrary(libId);
	}
}
