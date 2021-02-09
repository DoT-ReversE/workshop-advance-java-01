package workshop02;

public class Checkout {
    public void process(Basket basket) {
        int netPrice = PriceCalculator.get(basket);
        basket.setNetPrice(netPrice);

        int discount = DiscountCalculator.get(basket);
        basket.setDiscount(discount);
        // TODO
    }
}
