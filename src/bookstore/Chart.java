package bookstore;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
/**
 * @author MLUN
 *
 */
public class Chart {
	List <Book> bookList = new ArrayList<Book>();
	List <Integer> amountList = new ArrayList<Integer>();
	List <Integer> amountstatus = new ArrayList<Integer>();
	BigDecimal total = new BigDecimal("0");
	Store store;
	public Chart() {
		store = Store.getInstance();
	}
	/**
	 * @param Add book to chart.
	 */
	public void add(Book book) {
		int num;
		int i = bookList.indexOf(book);
		if(i == -1) {
			bookList.add(book);
			amountList.add(1);
			amountstatus.add(0);
		} else {
			num = amountList.get(i);
			amountList.set(i,++num);
		}
	}
	/**
	 * @param Remove book from chart.
	 * @return True if success, false if failure. ( Book does not exist in chart. )
	 */
	public boolean remove(Book book) {
		int num;
		int i = bookList.indexOf(book);
		if(i == -1) {
			return false;
		} else {
			if(amountList.get(i) == 1) {
				bookList.remove(i);
				amountList.remove(i);
				amountstatus.remove(i);
			} else {
				num = amountList.get(i);
				amountList.set(i,--num);
			}
			return true;
		}
	}
	/**
	 * @return The entire list of books.
	 */
	public List <Book> getBooks() {
		return bookList;
	}
	/**
	 * @return The entire list of book prices.
	 */
	public List <Integer>  getAmount() {
		return amountList;
	}
	/*
	 * Override default toString function
	 */
	public String toString()  {
		String acc = "";
		for(int i = 0;i< bookList.size();i++) {
			acc = acc + "[" + bookList.get(i).toString() + "," + amountList.get(i).toString() + "," +
					amountstatus.get(i).toString() + "]\n";
		}
		acc = acc + "------------------------------\n";
		acc = acc + " Total sum: " + total + "\n";
		acc = acc + "------------------------------\n";
		return acc;
	}
	/**
	 * @return Return total sum. ( after purchase )
	 */
	public BigDecimal getTotal() {
		return total;
	}
	/**
	 * @return Return a list that contain the number of books, successfully purchased.
	 */
	public List<Integer> getAmountstatus() {
		return amountstatus;
	}
	/**
	 * Buy the books in the chart.
	 */
	public void buyer() {
		for(int i = 0;i< bookList.size();i++) {
			Book[] listan = new Book[amountList.get(i)];
			for(int j = 0;j< amountList.get(i);j++) {
				listan[j] = bookList.get(i);
			}
			int[] kalle = new int[listan.length];
			Store sd = Store.getInstance();
			kalle = sd.buy(listan);
			int acc = 0;
			for(int j = 0;j< kalle.length;j++) {
				if(kalle[j] == 0) {
					acc += 1;
					total = total.add(bookList.get(i).getPrice());
				}
			}
			amountstatus.set(i,acc);
		}
	}
}
