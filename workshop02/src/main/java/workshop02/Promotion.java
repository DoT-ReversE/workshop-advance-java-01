package workshop02;

public class Promotion {

	private int uniqueItemCount;
	private int discountPercent;
	
	public Promotion(int uniqueItemCount, int discountPercent) {
		this.uniqueItemCount = uniqueItemCount;
		this.discountPercent = discountPercent;
	}
	
	public int getUniqueItemCount() {
		return uniqueItemCount;
	}
	public void setUniqueItemCount(int uniqueItemCount) {
		this.uniqueItemCount = uniqueItemCount;
	}
	public int getDiscountPercent() {
		return discountPercent;
	}
	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}
}
