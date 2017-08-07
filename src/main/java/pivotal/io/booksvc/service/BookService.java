package pivotal.io.booksvc.service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import pivotal.io.booksvc.client.BookDetailSvcFeignClient;
import pivotal.io.booksvc.client.domain.BookDetails;
import pivotal.io.booksvc.domain.Book;

@Service
public class BookService {
	
	private BookDetailSvcFeignClient bookDetailSvcClient;
	
	private final Function<BookDetails,Book> mapBookDetails = (BookDetails details) -> 
	    new Book(details.getIsbn(), details.getTitle(), details.getPageCount(), details.getSource());
	
	public BookService(BookDetailSvcFeignClient bookDetailSvcClient) {
	    this.bookDetailSvcClient = bookDetailSvcClient;
	}
	
	public Book find(String isbn) {
		return mapBookDetails.apply(bookDetailSvcClient.getBookDetailsByIsbn(isbn));
	}
	
	public List<Book> findAll() {
		return bookDetailSvcClient.getAllBookDetails().stream().map(mapBookDetails).collect(Collectors.toList());
	}
	
	
}
