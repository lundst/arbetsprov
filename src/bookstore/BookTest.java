package bookstore;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * @author MLUN
 *
 */
public class BookTest {
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}
	/**
	 * 	Test : getAuthor
	 */
	@Test
	public void AuthorTest() {
		Book book = new Book();
		book.setAuthor("myBook");
		String result = book.getAuthor();
		assertEquals("myBook", result);
	}
	/**
	 * 	Test : getTitle
	 */
	@Test
	public void TitleTest() {
		Book book = new Book();
		book.setTitle("Best book ever");
		String result = book.getTitle();
		assertEquals("Best book ever", result);
	}
	/**
	 * 	Test: getPrice 
	 */
	@Test
	public void PriceTest() {
		Book book = new Book();
		book.setPrice(new BigDecimal("19.95"));
		BigDecimal result = book.getPrice();
		assertEquals(new BigDecimal("19.95"), result);
	}
	/**
	 * Test : Equals true ( Same price )
	 */
	@Test
	public void equalsTest() {
		Book book = new Book();
		book.setAuthor("myBook");
		book.setTitle("Best book ever");
		book.setPrice(new BigDecimal("19.95"));
		Book book1 = new Book();
		book1.setAuthor("myBook");
		book1.setTitle("Best book ever");
		book1.setPrice(new BigDecimal("19.95"));
		boolean result = book.equals(book1);
		assertEquals(true, result);
	}
	/**
	 * Test : Equals "true" ( Different price )
	 */
	@Test
	public void equalsTest1() {
		Book book = new Book();
		book.setAuthor("myBook");
		book.setTitle("Best book ever");
		book.setPrice(new BigDecimal("19.95"));
		Book book1 = new Book();
		book1.setAuthor("myBook");
		book1.setTitle("Best book ever");
		book1.setPrice(new BigDecimal("400"));
		boolean result = book.equals(book1);
		assertEquals(true, result);
	}
	/**
	 * 
	 * Test Equals "false"
	 */
	@Test
	public void equalsTest2() {
		Book book = new Book();
		book.setAuthor("myBook");
		book.setTitle("Best book ever");
		book.setPrice(new BigDecimal("400"));
		Book book1 = new Book();
		book1.setAuthor("myBook P");
		book1.setTitle("Best book ever");
		book1.setPrice(new BigDecimal("400"));
		boolean result = book.equals(book1);
		assertNotEquals(true, result);
	}
	/**
	 * 
	 */
	@Test
	public void equalsTest3() {
		Book book = new Book();
		book.setAuthor("myBook");
		book.setTitle("Best book ever");
		book.setPrice(new BigDecimal("400"));
		Book book1 = new Book();
		book1.setAuthor("myBook");
		book1.setTitle("Best book ever - not");
		book1.setPrice(new BigDecimal("400"));
		boolean result = book.equals(book1);
		assertNotEquals(true, result);
	}
	/**
	 * Test: toString
	 */
	@Test
	public void toStringTest() {
		Book book = new Book();
		book.setAuthor("myBook");
		book.setTitle("Best book ever");
		book.setPrice(new BigDecimal("19.95"));
		String result = book.toString();
		assertEquals("myBook,Best book ever,19.95", result);
	}
}
