import java.io.IOException;
import java.util.concurrent.*;

public class algoClient {

	
	public static void main(String [] args) throws IOException, InterruptedException {
		
		stuff price = new stuff(); 
		//all essential variables into their respective Strings or doubles
		// had to sort through excess words in String to get value
		String changePercent = price.essentials().get(3).substring(42, price.essentials().get(3).length() - 3);
		double priceChangePercent = doubleParser(changePercent); // this changed Strings into doubles
		
		String name = price.essentials().get(0).substring(27, price.essentials().get(0).length() - 2);
		
		String curPrice = price.essentials().get(1).substring(28, price.essentials().get(1).length() - 2);
		double currentPrice = doubleParser(curPrice.replaceAll(",", "")); // got rid of commas in prices
		
		int shareCount = 100000; // initial amount of shares
		
		
/////////////////////////////////////////////////////////////////////////////////////////////////////
		
		//System.out.println(priceChangePercent);
		
		execution money = new execution(shareCount, currentPrice, name, priceChangePercent);
		boolean going = true; // this makes sure that if the kill switch was activated, the code would stop trading after the shares we bought or sold
		while(going == true) {
		going = money.execute();
		Thread.sleep(20000); // 4000 = 4 seconds
		}
		
//		System.out.println(priceChangePercent + "%");
//		System.out.println(name);
//		System.out.println(currentPrice);
		
		
//		System.out.print(price.getList());
		
//		for(int i = 0; i < price.essentials().size(); i++) {
//			System.out.println(price.essentials().get(i));
//		}
	}
	
	public static double doubleParser(String a) { // changed strings to doubles above
		double b = Double.parseDouble(a);
		return b;
	}
}
