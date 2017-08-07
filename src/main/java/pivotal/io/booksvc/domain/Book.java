package pivotal.io.booksvc.domain;

import java.math.BigDecimal;

public class Book {
	public String isbn;
	public String title;
	public Integer pageCount;
	public String detailsSource;
	public Integer inventory = 0;
	public BigDecimal price = BigDecimal.ZERO;
	
	public Book(String isbn, String title, Integer pageCount, String detailsSource) {
		this.isbn = isbn;
		this.title = title;
		this.pageCount = pageCount;
		this.detailsSource = detailsSource;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public Integer getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public String getDetailsSource() {
		return detailsSource;
	}

	public void setDetailsSource(String detailsSource) {
		this.detailsSource = detailsSource;
	}

	public Integer getInventory() {
		return inventory;
	}

	public void setInventory(Integer inventory) {
		this.inventory = inventory;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
