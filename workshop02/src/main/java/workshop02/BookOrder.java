package workshop02;

public class BookOrder {

	private Book book;
	private int quantity;
	
	public BookOrder(Book book) {
		this.book = book;
		this.quantity = 1;
	}
	
	public void addQuantity() {
		this.quantity++;
	}

	public int getQuantity() {
		return quantity;
	}

	public Book getBook() {
		return book;
	}
	
}
