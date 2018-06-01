
public class buy implements safetySwitch{
	
	private int shares;
	private String name;
	private double currentPrice;
	private double priceChangePercent;
	
	public buy(int numberOfShares, double current, String name, double percent) {
		this.shares = numberOfShares;
		this.name = name;
		this.currentPrice = current;
		this.priceChangePercent = percent;
		
	}
	
	public int bought() { //this buys 1,000 shares
		this.shares = this.shares + 1000;
		return this.shares;
	}
	
	public String kill() { // if it drops drastically, double the amount owned. Live life on the edge
		String statement = (this.shares + " of " + this.name + " were bought at " + this.currentPrice + " due to a " + this.priceChangePercent + "% decrease in share price");
		this.shares = this.shares * 2;
		return statement;
	}
	
	public String toString() {
		String composite = "You have bought 1000 shares of " + this.name + " at " + currentPrice + " USD\nYou now have "+ bought() + " shares";
	return composite;
	}
}
