package workshop02;

import java.util.List;

public class PriceCalculator {

    public static int get(Basket basket) {
        // Logic
    	int netPrice = 0;
    	
    	List<Book> books = basket.getBooks();
    	for (Book book : books) {
			int bookPrice = book.getPrice();
			netPrice += bookPrice;
		}
    	
        return netPrice;
    }
    
}