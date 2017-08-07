package pivotal.io.booksvc.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import pivotal.io.booksvc.client.domain.BookDetails;

@Repository
public class BookDetailsCacheRepository {
	@SuppressWarnings("serial")
    private final Map<String, BookDetails> bookMap = new HashMap<String, BookDetails>() {{
		put("978-1-4493-7464-8", new BookDetails("978-1-4493-7464-8", "Cloud Native Java", 628, "CACHE"));
		put("978-1-4919-3243-8", new BookDetails("978-1-4919-3243-8", "Cloud Foundry: The Definitive Guide", 324, "CACHE"));
		put("978-0134434421", new BookDetails("978-0134434421", "Domain-Driven Design Distilled", 176, "CACHE"));
	}};

	public BookDetails findByIsbn(String isbn) {
		return bookMap.get(isbn);
	}
	
	   public Collection<BookDetails> findAll() {
	        return bookMap.values();
	    }
}
