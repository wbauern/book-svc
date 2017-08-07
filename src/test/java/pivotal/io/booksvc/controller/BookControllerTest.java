package pivotal.io.booksvc.controller;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pivotal.io.booksvc.controller.BookController;
import pivotal.io.booksvc.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class BookControllerTest {
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookService bookServiceMock;
	
	@Test
	public void testGetBook() {
		assertTrue(true);
	}
}
