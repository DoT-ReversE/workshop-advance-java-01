package workshop02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BuyerTest {
	
    @Test
    public void buy_3_books_with_2_same_book_and_1_unique_book_size_of_book_is_2() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        Book book3 = new Book("Potter 2", 8);
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);

        // Check size of book in basket
        assertEquals(2, basket.getBookOrdersMapByBookName().size());
        assertEquals(2, basket.getBookOrdersMapByBookName().get("Potter 1").getQuantity()); // Issue :: Quantity of book in basket
        assertEquals(1, basket.getBookOrdersMapByBookName().get("Potter 2").getQuantity()); // Issue :: Quantity of book in basket
    }
	
    @Test
    public void buy_2_books_same_book_size_of_book_is_1() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new Book("Potter 1", 8);
        Book book2 = new Book("Potter 1", 8);
        basket.addBook(book1);
        basket.addBook(book2);

        // Check size of book in basket
        assertEquals(1, basket.getBookOrdersMapByBookName().size());
        assertEquals(2, basket.getBookOrdersMapByBookName().get("Potter 1").getQuantity()); // Issue :: Quantity of book in basket
    }
	
    @Test
    public void buy_2_same_books() {
    	// 1. Create basket
    	Basket basket = new Basket();
    	// 2. Add book to basket
    	Book book1 = new BookBuilder().chooseBook("Potter 1").build();
    	Book book2 = new BookBuilder().chooseBook("Potter 1").build();
    	basket.addBook(book1);
    	basket.addBook(book2);
    	// 3. Checkout
    	Checkout checkout = new Checkout();
    	checkout.process(basket);
    	
    	assertEquals(1600, basket.getNetPrice());
    	assertEquals(0, basket.getDiscount());
    	assertEquals(1600, basket.getTotalPrice());
    }

    @Test
    public void buy_3_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new BookBuilder().chooseBook("Potter 1").build();
        Book book2 = new BookBuilder().chooseBook("Potter 2").build();
        Book book3 = new BookBuilder().chooseBook("Potter 3").build();
        basket.addBook(book1);
        basket.addBook(book2);
        basket.addBook(book3);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        assertEquals(2400, basket.getNetPrice());
        assertEquals(240, basket.getDiscount());
        assertEquals(2160, basket.getTotalPrice());
    }

    @Test
    public void buy_2_books() {
    	// 1. Create basket
    	Basket basket = new Basket();
    	// 2. Add book to basket
    	Book book1 = new BookBuilder().chooseBook("Potter 1").build();
    	Book book2 = new BookBuilder().chooseBook("Potter 2").build();
    	basket.addBook(book1);
    	basket.addBook(book2);
    	// 3. Checkout
    	Checkout checkout = new Checkout();
    	checkout.process(basket);
    	
    	assertEquals(1600, basket.getNetPrice());
    	assertEquals(80, basket.getDiscount());
    	assertEquals(1520, basket.getTotalPrice());
    }

    @Test
    public void buy_1_books() {
        // 1. Create basket
        Basket basket = new Basket();
        // 2. Add book to basket
        Book book1 = new BookBuilder().chooseBook("Potter 1").build();
        basket.addBook(book1);
        // 3. Checkout
        Checkout checkout = new Checkout();
        checkout.process(basket);

        assertEquals(800, basket.getNetPrice()); // 8.00
        assertEquals(0, basket.getDiscount()); // 8.00
        assertEquals(800, basket.getTotalPrice()); // 8.00
    }
    
}