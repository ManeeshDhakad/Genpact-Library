package com.library.service;

import java.util.List;

import com.library.entity.Library;
import com.library.model.LibModel;

public interface LibraryService {
	List<Library> getAllLibraries();
	Library createLibrary(Library lib);
	Library updateLibrary(Library lib);
	Library removeLibrary(int id);
}
