import java.io.IOException;
import java.util.concurrent.*;

public class execution {

	private int shareCount;
	private double currentPrice;
	private String name;
	private double priceChangePercent;
	private buy up;
	private sell down;
	
	public execution(int shareCount, double currentPrice, String name, double priceChangePercent) {
		
		this.shareCount = shareCount;
		this.currentPrice = currentPrice;
		this.name = name;
		this. priceChangePercent = priceChangePercent;
		
		this.up = new buy(this.shareCount, this.currentPrice, this.name, this.priceChangePercent);
		this.down = new sell(this.shareCount, this.currentPrice, this.name, this.priceChangePercent);

	}
	
	public boolean execute() throws InterruptedException { // this is decision of trade based off of percent change
		if(priceChangePercent < -0.5) { // if percent goes down, buy 100000 more shares
			if(priceChangePercent <= -3.0) { // if it goes down by more than 3%, double the amount of shares owned
				up.kill();
				return false;
			}else {
			String statement = up.toString();
			System.out.println(statement);
			shareCount = shareCount + 1000;
			System.out.println(shareCount);
			return true;
			}
		} else if(priceChangePercent > 0.5){ //sell 100000 shares
			if(priceChangePercent >= 3.0) { // sell all shares owned
				down.kill();
				return false;
			} else {
			String statement = down.toString();
			System.out.println(statement);
			shareCount = shareCount - 1000;
			System.out.println(shareCount);
			return true;
			}
		} else if(-0.5 <= priceChangePercent && priceChangePercent <= 0.5) { // do nothing if price change is negligible
			System.out.println("No action was done today.");
			System.out.println(this.name);
			System.out.println("Number of shares: " + shareCount);
			System.out.println("Price: " + this.currentPrice + " USD");
			System.out.println("Price Change: " + this.priceChangePercent + "%\n");
			return true;
		} else {
			return true;
		}
	}
}
