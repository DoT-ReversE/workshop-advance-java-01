package workshop02;

import java.util.ArrayList;
import java.util.List;

public class BookPromotion {
	final Promotion TWO_UNIQUE_BOOK_PROMOTION = new Promotion(2, 5);
	final Promotion THREE_UNIQUE_BOOK_PROMOTION = new Promotion(3, 10);

	private List<Promotion> promotions;
	
	public BookPromotion() {
		promotions = new ArrayList<Promotion>();
		promotions.add(TWO_UNIQUE_BOOK_PROMOTION);
		promotions.add(THREE_UNIQUE_BOOK_PROMOTION);
	}
	
	public List<Promotion> getPromotions() {
		return promotions;
	}

	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}

}
