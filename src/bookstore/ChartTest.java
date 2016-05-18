package bookstore;
import static org.junit.Assert.*;
import java.math.BigDecimal;
import org.junit.BeforeClass;
import org.junit.Test;
/**
 * @author MLUN
 *
 */
public class ChartTest {
	/**
	 * No Setup is needed.
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	
	}
	/**
	 * Test to add books to chart.
	 */
	@Test
	public void addTest() {
		Chart ch = new Chart();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		Book testBookThree = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering едц");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard3");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		testBookThree.setAuthor("Rich Bloke");
		testBookThree.setTitle("Desired");
		testBookThree.setPrice(new BigDecimal("564.50"));
		ch.add(testBookOne);
		ch.add(testBookTwo);
		ch.add(testBookThree);
		ch.add(testBookThree);
		String result = ch.toString();
		assertEquals("[Average Swede,Mastering едц,999.00,1,0]\n" +
				"[Cunning Bastard3,Random Sales,999.00,1,0]\n" +
				"[Rich Bloke,Desired,564.50,2,0]\n" +
				"------------------------------\n" +
				" Total sum: 0\n" +
				"------------------------------\n", result);
	}
	/**
	 * Test to remove a book from the chart.
	 */
	@Test
	public void removeTest() {
		Chart ch = new Chart();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		Book testBookThree = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering едц");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard3");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		testBookThree.setAuthor("Rich Bloke");
		testBookThree.setTitle("Desired");
		testBookThree.setPrice(new BigDecimal("564.50"));
		ch.add(testBookOne);
		ch.add(testBookTwo);
		ch.add(testBookThree);
		ch.add(testBookThree);
		ch.remove(testBookThree);
		ch.remove(testBookOne);
		String result = ch.toString();
		assertEquals("[Cunning Bastard3,Random Sales,999.00,1,0]\n" +
				"[Rich Bloke,Desired,564.50,1,0]\n" +
				"------------------------------\n" +
				" Total sum: 0\n" +
				"------------------------------\n", result);
	}
	/**
	 * Test to purchase, from the chart, and also test that the bookstore is properly updated.
	 */
	@Test
	public void buyerTest() {
		Chart ch = new Chart();
		Book testBookOne = new Book();
		Book testBookTwo = new Book();
		Book testBookThree = new Book();
		testBookOne.setAuthor("Average Swede");
		testBookOne.setTitle("Mastering едц");
		testBookOne.setPrice(new BigDecimal("999.00"));
		testBookTwo.setAuthor("Cunning Bastard3");
		testBookTwo.setTitle("Random Sales");
		testBookTwo.setPrice(new BigDecimal("999.00"));
		testBookThree.setAuthor("Rich Bloke");
		testBookThree.setTitle("Desired");
		testBookThree.setPrice(new BigDecimal("564.50"));
		ch.add(testBookOne);
		ch.add(testBookOne);
		ch.add(testBookTwo);
		ch.add(testBookThree);
		ch.add(testBookThree);
		Store sd = Store.getInstance();
		ch.buyer();
		assertEquals(	"[Average Swede,Mastering едц,999.00,2,2]\n" +
				"[Cunning Bastard3,Random Sales,999.00,1,0]\n" +
				"[Rich Bloke,Desired,564.50,2,0]\n" +
				"------------------------------\n" +
				" Total sum: 1998.00\n" +
				"------------------------------\n", ch.toString());
		assertEquals("[Average Swede,Mastering едц,762.00,13]\n" +
				"[Rich Bloke,How To Spend Money,1000000.00,1]\n" +
				"[First Author,Generic Title,185.50,5]\n" +
				"[Second Author,Generic Title,1748.00,3]\n" +
				"[Cunning Bastard,Random Sales,999.00,23]\n" +
				"[Rich Bloke,Desired,564.50,0]\n", sd.toString());
	}
}
