package com.library.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.library.entity.Library;
import com.library.repo.LibraryRepository;

@SpringBootTest
class LibraryServiceTests {

	@InjectMocks
	LibraryServiceImpl libService;

	@Mock
	private LibraryRepository libRepo;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void createLibTest() {	
		Library lib = new Library();
		lib.setId(1);
		lib.setName("Lib1");
		lib.setDescription("Lib 1 Desc");

		when(libRepo.save(any(Library.class))).thenReturn(lib);

		assertEquals(lib.getName(), libService.createLibrary(lib).getName());
	}

	@Test
	void getAllLibTest() {	
		Library lib = new Library();
		lib.setId(1);
		lib.setName("Lib1");
		lib.setDescription("Lib 1 Desc");
		List<Library> libs = new ArrayList<>();
		libs.add(lib);

		when(libRepo.findAll()).thenReturn(libs);
		assertEquals(1, libService.getAllLibraries().size());
	}
}
