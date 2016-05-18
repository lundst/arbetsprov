package bookstore;
import java.math.BigDecimal;
/**
 * @author MLUN
 * Main function to test functionality manually.
 */
public class bookstoreMain {
	public static void main(String[] args) {
		Store mainStore = Store.getInstance();
		System.out.println(mainStore.toString());
		System.out.println("****************************");
		Book myBook = new Book();
		myBook.setAuthor("me");
		myBook.setTitle("My book title");
		myBook.setPrice(new BigDecimal("444"));
		mainStore.add(myBook, 1);
		System.out.println(mainStore.toString());
		System.out.println("Remove return : " + mainStore.remove(myBook));
		System.out.println(mainStore.toString());
		System.out.println("Remove return : " + mainStore.remove(myBook));
		System.out.println("delete return : " + mainStore.delete(myBook));
		System.out.println(mainStore.toString());
		System.out.println("****************************");
		Book[]  bookList = mainStore.list("Generic Title");
		for(int i = 0;i< bookList.length;i++) {
			System.out.println(bookList[i]);
		}
	}
}
