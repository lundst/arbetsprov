package bookstore;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author MLUN
 *
 */
class Store implements BookList,Serializable
{
	final List <Book> storage = new ArrayList<Book>();
	final List <Integer> amountList = new ArrayList<Integer>();
	private static final long serialVersionUID = 1L;
	private Store() {
		// Block reflection
		if (SingletonHolder.INSTANCE != null)
		{
			throw new IllegalStateException("Cannot create second instance of this class");
		}
		Scanner sc = null;
		try {
			sc = new Scanner(new File("./bookstoredata.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while (sc.hasNextLine()) {
			String aLong = sc.nextLine();
			Scanner scanner = new Scanner(aLong);
			scanner.useDelimiter(";");
			Book kg = new Book();
			String titleA = scanner.next();
			String authorA = scanner.next();
			String priceA = scanner.next();
			priceA = priceA.replace(",", "");
			int numA = scanner.nextInt();
			kg.setTitle(titleA);
			kg.setAuthor(authorA);
			kg.setPrice(new BigDecimal(priceA));
			int i = storage.indexOf(kg);
			if(i == -1) {
				storage.add(kg);
				amountList.add(numA);
			} else {
				BigDecimal gg = storage.get(i).getPrice();
				amountList.get(i);
				if(gg.compareTo(new BigDecimal(priceA)) == -1) {
					storage.get(i).setPrice(new BigDecimal(priceA));
				} else {
					storage.get(i).setPrice(gg);
				}
				int gfg = amountList.get(i);
				amountList.set(i, numA +  gfg);
			}
			scanner.close();
		}
	}
	/**
	 * 
	 * Class that hold the instance of the book store.
	 *
	 */
	private static class SingletonHolder {
		public static final Store INSTANCE = new Store();
	}
	/**
	 * @return Return instance to allow usage of the created singleton instance.
	 */
	public static Store getInstance() {
		return SingletonHolder.INSTANCE;
	}
	/**
	 * @return Return the instance to allow read from file and such things.
	 */
	protected Object readResolve() {
		return getInstance();
	}
	/**
	 * @param Add a book to the book store.
	 */
	private synchronized void add(Book book) {
		int num;
		int i = storage.indexOf(book);
		if(i == -1) {
			storage.add(book);
			amountList.add(1);
		} else {
			num = amountList.get(i);
			amountList.set(i,++num);
		}
	}
	/**
	 * @param Remove a book from the book store. ( All books, including definition )
	 * @return
	 */
	public synchronized boolean delete(Book book) {
		int i = storage.indexOf(book);
		if(i == -1) {
			return false;
		} else {
			storage.remove(book);
			amountList.remove(i);
			return true;
		}
	}
	/**
	 * @param Remove ONE book, from the book store.
	 * @return 0 if "success", 2 if "None exist" and 1 if "out of stock" )
	 */
	public synchronized int remove(Book book) {
		int num;
		int i = storage.indexOf(book);
		if(i == -1) {
			return 2;
		} else {
			if(amountList.get(i) == 0) {
				return 1;
			} else {
				num = amountList.get(i);
				amountList.set(i,--num);
			}
			return 0;
		}
	}
	/** 
	 * @param Search string containing either book title or author.
	 * @return Return a list of books as search result.
	 */
	public synchronized Book[] list(String searchString) {
		List <Book> ret = new ArrayList<Book>(); // length of array unknown
		storage.iterator();
		for(Book thi : storage) {
			if(thi.getAuthor().equals(searchString)) {
				ret.add(thi);
			}
			if(thi.getTitle().equals(searchString)) {
				ret.add(thi);
			}
		}
		Book[]  array = new Book[ret.size()];
		int index = 0;
		for (Book value : ret) {
			array[index] = value;
			index++;
		}	
		return array;
	}
	/**
	 * @return Return a list of all books in the storage.
	 */
	public synchronized Book[] list() {
		Book[]  array = new Book[storage.size()];
		int index = 0;
		for (Book value : storage) {
			array[index] = value;
			index++;
		}	
		return array;
	}
	/** 
	 * @param Argument is book and the number of this particular book to add.
	 * @return Always return true; (Success)
	 */
	public synchronized boolean add(Book book, int amount) {
		for(int i = 0;i< amount;i++) {
			this.add(book);
		}
		return true;
	}
	/** 
	 * @param List of books to purchase
	 * @return Return a list with status of the book purchase.
	 *  0 if "success", 2 if "None exist" and 1 if "out of stock" )
	 */
	public synchronized int[] buy(Book... books) {
		List <Integer> res = new ArrayList<Integer>();
		for(Book thi : books) {
			res.add(remove(thi));
		}
		int[] array = new int[res.size()];
		int index = 0;
		for (Object value : res) {
			array[index] = (int) value;
			index++;
		}
		return array;
	} 
	/*
	 * Override default toString function
	 */
	public synchronized String toString()  {
		String acc = "";
		for(int i = 0;i< storage.size();i++) {
			acc = acc + "[" + storage.get(i).toString() + "," + amountList.get(i).toString() + "]\n";
		}
		return acc;
	}
}
