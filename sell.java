
public class sell implements safetySwitch{

	private int shares;
	private String name;
	private double currentPrice;
	private double priceChangePercent;
	
	public sell(int numberOfShares, double current, String name, double percent) {
		System.out.println(numberOfShares);
		this.shares = numberOfShares;
		this.name = name;
		this.currentPrice = current;
		this.priceChangePercent = percent;
	}
	
	public int sold() { // this sells 1,000 shares at appropriate time
		this.shares = this.shares - 1000;
		return this.shares;
	}
	
	
	public String kill() { // this kills code if price change increases drastically
		return this.shares + " of " + this.name + " were sold at " + this.currentPrice + " due to a " + this.priceChangePercent + "% increase in share price";
	}
	
	public String toString() {
		String composite = "You have sold 1000 shares of " + this.name + " at " + this.currentPrice + " USD\nYou now have "+ sold() + " shares";
	return composite;
	}
}

