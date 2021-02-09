package workshop02;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiscountCalculator {
	
    public static int get(Basket basket) {
    	int discount = 0;
    	
    	List<Book> books = basket.getBooks();
    	Set<String> uniqueBookNames = new HashSet<String>();
    	for (Book book : books) {
			String bookName = book.getName();
			uniqueBookNames.add(bookName);
		}
    	int uniqueBookNameCount = uniqueBookNames.size();
    	
    	BookPromotionBuilder bookPromotion = new BookPromotionBuilder().build();
    	List<Promotion> promotions = bookPromotion.getPromotions();
    	int discountPercent = 0;
    	for (Promotion promotion : promotions) {
			if (uniqueBookNameCount == promotion.getUniqueItemCount()) {
				discountPercent = promotion.getDiscountPercent();
			}
		}
    	
    	int netPrice = basket.getNetPrice();
    	
    	discount = (netPrice * discountPercent) / 100;
    	
        return discount;
    }
    
}