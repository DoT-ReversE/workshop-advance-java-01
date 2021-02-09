package workshop02;

public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        int discount = DiscountCalculator.get(basket);
        
        basket.setNetPrice(netPrice);
        basket.setDiscount(discount);
        // TODO
    }
}
