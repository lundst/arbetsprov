package bookstore;
import java.math.BigDecimal;
/**
 * @author MLUN
 *
 */
public class Book {
	private String title;
	private String author;
	private BigDecimal price;
	/**
	 * @return Returns the book title.
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param Set the title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return Returns the author.
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param Set the author.
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return Return the price.
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param Set the price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/*
	 * Override the default equal function.
	 * Equal is defined as books having the same author and title.
	 * Thus, connected with the physical object book!
	 * Price is considered a virtual property that are subject to constant change.
	 */
	@Override 
	public boolean equals(Object obj)  { 
		Book book = (Book) obj;
		if (book == null) return false;
		return this.getAuthor().equals(book.author) && this.getTitle().equals(book.title);
	}
	/*
	 * Override the default print function
	 */
	@Override 
	public String toString()  {
		return (this.author + "," + this.title + "," + this.price);
	}
}