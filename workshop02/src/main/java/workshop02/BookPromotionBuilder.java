package workshop02;

import java.util.ArrayList;
import java.util.List;

public class BookPromotionBuilder {

	List<Promotion> promotions;
	
	public BookPromotionBuilder() {
		promotions = new ArrayList<Promotion>();
	}
	
	public BookPromotionBuilder build() {
		Promotion threeUniqueBook = new Promotion(3, 10);
		promotions.add(threeUniqueBook);
		return this;
	}
	
	public void create(Promotion promotion) {
		promotions.add(promotion);
	}
	
	public List<Promotion> getPromotions() {
		return promotions;
	}
	
}
