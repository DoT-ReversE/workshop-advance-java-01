package workshop02;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DiscountCalculator {
	
    public static int get(Basket basket, int netPrice) {
    	int discount = 0;
    	
    	Map<String, BookOrder> bookOrdersMapByBookName = basket.getBookOrdersMapByBookName();
    	Set<String> uniqueBookNames = new HashSet<String>();
        for (Map.Entry<String, BookOrder> entry : bookOrdersMapByBookName.entrySet()) {
    		String bookName = entry.getKey();
    		uniqueBookNames.add(bookName);
    	}
    	int uniqueBookNameCount = uniqueBookNames.size();
    	
    	BookPromotion bookPromotion = new BookPromotion();
    	List<Promotion> promotions = bookPromotion.getPromotions();
    	int discountPercent = 0;
    	for (Promotion promotion : promotions) {
			if (uniqueBookNameCount == promotion.getUniqueItemCount()) {
				discountPercent = promotion.getDiscountPercent();
			}
		}
    	
    	discount = (netPrice * discountPercent) / 100;
    	
        return discount;
    }
    
}