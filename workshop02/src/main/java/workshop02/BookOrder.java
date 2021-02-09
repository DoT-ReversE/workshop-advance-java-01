package workshop02;

public class BookOrder {

	private Book book;
	private int quantity;
	private int price;
	
	public BookOrder(Book book) {
		this.book = book;
		this.quantity = 1;
	}
	
	public void addQuantity() {
		this.quantity++;
	}
	
	public void minusQuantity() {
		this.quantity--;
	}

	public int getQuantity() {
		return quantity;
	}

	public Book getBook() {
		return book;
	}
	
	public int getPrice() {
		this.price = this.book.getPrice() * quantity;
		return price;
	}
	
}
