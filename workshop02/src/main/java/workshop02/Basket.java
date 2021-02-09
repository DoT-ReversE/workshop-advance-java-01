package workshop02;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    private Map<String, BookOrder> bookOrdersMapByBookName = new HashMap<String, BookOrder>();
    private int netPrice;
    private int discount;

    public void addBook(Book book) {
        String bookName = book.getName();
        if (bookOrdersMapByBookName.containsKey(bookName)) {
        	BookOrder bookOrder = bookOrdersMapByBookName.get(bookName);
            bookOrder.addQuantity();
        } else {
        	BookOrder bookOrder = new BookOrder(book);
        	bookOrdersMapByBookName.put(bookName, bookOrder);
        }
    }

    public int getNetPrice() {
        return netPrice;
    }

    public void setNetPrice(int netPrice) {
        this.netPrice = netPrice;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }
    
    public int getTotalPrice() {
    	return this.netPrice - this.discount;
    }

	public Map<String, BookOrder> getBookOrdersMapByBookName() {
		return bookOrdersMapByBookName;
	}

	public void setBookOrdersMapByBookName(Map<String, BookOrder> bookOrdersMapByBookName) {
		this.bookOrdersMapByBookName = bookOrdersMapByBookName;
	}
}