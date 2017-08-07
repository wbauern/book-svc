package pivotal.io.booksvc.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pivotal.io.booksvc.domain.Book;
import pivotal.io.booksvc.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
	
	private BookService bookService;
	
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@GetMapping("/{isbn}")
	public Book getBook(@PathVariable String isbn) {
		return bookService.find(isbn);
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.findAll();
	}
	
}
