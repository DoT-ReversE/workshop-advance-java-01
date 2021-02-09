package workshop02;

import java.util.Map;

public class PriceCalculator {

    public static int get(Basket basket) {
        // Logic
    	int netPrice = 0;
    	
    	Map<String, BookOrder> bookOrdersMapByBookName = basket.getBookOrdersMapByBookName();
        for (Map.Entry<String, BookOrder> entry : bookOrdersMapByBookName.entrySet()) {
    		BookOrder bookOrder = entry.getValue();
    		int bookPrice = bookOrder.getBook().getPrice();
    		int quantity = bookOrder.getQuantity();
    		int orderPrice = bookPrice * quantity;
    		netPrice += orderPrice;
        }
    	
        return netPrice;
    }
    
}