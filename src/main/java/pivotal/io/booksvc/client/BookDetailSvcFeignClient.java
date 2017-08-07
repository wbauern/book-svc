package pivotal.io.booksvc.client;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import pivotal.io.booksvc.client.domain.BookDetails;
import pivotal.io.booksvc.repository.BookDetailsCacheRepository;

@FeignClient(name="book-detail-svc", fallback=BookDetailSvcFeignClient.HystrixClientFallback.class)
public interface BookDetailSvcFeignClient {
	
    @RequestMapping(method = RequestMethod.GET, value = "/bookdetails/{isbn}")
    BookDetails getBookDetailsByIsbn(@PathVariable("isbn") String isbn);
    
    @RequestMapping(method = RequestMethod.GET, value = "/bookdetails")
    Collection<BookDetails> getAllBookDetails();

    @Component
    public class HystrixClientFallback implements BookDetailSvcFeignClient {
        
        @Autowired
        BookDetailsCacheRepository secondaryRepo;
    
        @Override
        @HystrixCommand(
                threadPoolKey = "CacheThreadPool", // Use a separate thread pool for the fallback method
                commandProperties = {
                    @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="100")}
        )
        
        public BookDetails getBookDetailsByIsbn(String isbn) {
            return secondaryRepo.findByIsbn(isbn);
        }
    
        @Override
        public Collection<BookDetails> getAllBookDetails() {
            return secondaryRepo.findAll();
        }
    }
}
