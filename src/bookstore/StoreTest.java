package bookstore;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * @author MLUN
 *
 */
public class StoreTest {
	/**
	 * No setup is needed
	 * NOTE: One SINGLETON instance of Storage is created,
	 *       this instance is modified throughout the entire test.
	 *       Thus: Tests are not independent.
	 *       To adress this and other issues, are considered out of scope for this limited implementation.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception { 
	}
	/**
	 * Test the toString function.
	 */
	@Test
	public void toStringtest() {
		Store store = Store.getInstance();
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,4]\n", result);
	}
	/**
	 * Test that no new instances are created.
	 */
	@Test
	public void instancesTest() {
		Store store = Store.getInstance();
		Store mainStore = Store.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("me");
		testBook.setTitle("My book title");
		testBook.setPrice(new BigDecimal("444"));
		mainStore.add(testBook, 1);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,15]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,1]\n", result);
	}
	/**
	 * Test to add book to the storage.
	 */
	@Test
	public void addTest() {
		Store store = Store.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("me");
		testBook.setTitle("My book title");
		testBook.setPrice(new BigDecimal("444"));
		store.add(testBook, 1);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,15]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,4]\n", result);
	}
	/**
	 * Test to add two books to the storage.
	 */
	@Test
	public void addTest1() {
		Store store = Store.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("me");
		testBook.setTitle("My book title");
		testBook.setPrice(new BigDecimal("444"));
		store.add(testBook, 1);
		store.add(testBook, 1);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,15]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,3]\n", result);
	}
	/**
	 * Test to list all book with the title "Generic Title".
	 */
	@Test
	public void listTest() {
		Store store = Store.getInstance();
		Book[] testBook;
		testBook = store.list("Generic Title");
		int i = 0;
		String stringNums = "";
		while (i < testBook.length) {
			stringNums += testBook[i++].toString();
		}
		assertEquals("First Author,Generic Title,185.50Second Author,Generic Title,1748.00", stringNums);
	}
	/**
	 * Test to delete a book in the storage. ( Also remove the definition of it. )
	 */
	@Test
	public void deleteTest() {
		Store store = Store.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Rich Bloke");
		testBook.setTitle("Desired");
		testBook.setPrice(new BigDecimal("444"));
		store.delete(testBook);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[me,My book title,444,4]\n", result);
	}
	/**
	 * Try to remove a book, although the definition say´s there´s 0 books left.
	 * ( out-off-stock )
	 */
	@Test
	public void removeTest() {
		Store store = Store.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Rich Bloke");
		testBook.setTitle("Desired");
		testBook.setPrice(new BigDecimal("444"));
		int res = store.remove(testBook);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,4]\n", result);
		assertEquals(1,res);
	}
	/**
	 * Remove a book, from the storage
	 */
	@Test
	public void removeTest1() {
		Store store = Store.getInstance();
		Book testBook = new Book();
		testBook.setAuthor("Cunning Bastard");
		testBook.setTitle("Random Sales");
		testBook.setPrice(new BigDecimal("999.00"));
		int res = store.remove(testBook);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,14]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,22]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,4]\n", result);
		assertEquals(0,res);
	}
	/**
	 * Test to buy several book from the storage, and control that the amount is is correctly reduced.
	 */
	@Test
	public void buyTest() {
		Store store = Store.getInstance();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering והצ");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		Book[] listan = new Book[2];
		listan[0] = testBookOne;
		listan[1] = testBookTwo;
		store.buy(listan);
		String result = store.toString();
		assertEquals("[Average Swede,Mastering והצ,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,21]\n" +
				"[Rich Bloke,Desired,564.50,0]\n" +
				"[me,My book title,444,4]\n", result);
	}
	/**
	 * Test to buy several book from the storage, and control that return status function correctly.
	 * 0 - Success.
	 * 1 - Out of stock.
	 * 2 - Does not exist.
	 */
	@Test
	public void buyTest1() {
		Store store = Store.getInstance();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		Book testBookThree = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering והצ");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard3");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		testBookThree.setAuthor("Rich Bloke");
		testBookThree.setTitle("Desired");
		testBookThree.setPrice(new BigDecimal("564.50"));
		Book[] listan = new Book[3];
		listan[0] = testBookOne;
		listan[1] = testBookTwo;
		listan[2] = testBookThree;
		store.toString();
		//System.out.println("Before " + store.toString());
		int[] result = store.buy(listan);
		//System.out.println("After " + store.toString());
		//Store aa = Store.getInstance();
		//System.out.println("After another " + aa.toString());
		int i = 0;
		String[] stringNums = {"","",""};
		while (i < result.length) {
			stringNums[i] = String.valueOf(result[i++]);
		}
		assertArrayEquals(new String[]{"0","2","1"}, stringNums);
	}
}
