package workshop02;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Book> books = new ArrayList<Book>();
    private int netPrice;
    private int discount;

    public void addBook(Book book) {
        getBooks().add(book);
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

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
}