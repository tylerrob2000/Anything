import java.io.IOException;
 
import java.util.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
public class stuff {
	private Document doc; // this is the website that we are scraping data off of
	private Elements meta; // this is an array list of element
	// Elements are ArrayLists of element
	// An element is one line of the source code
	// i.e.   <mete name = ...
	
	public stuff() throws IOException {
		this.doc = Jsoup.connect("https://www.marketwatch.com/investing/stock/amzn").get();
		this.meta = getList(); // this is an ArrayList of elements with the tag of the lines being meta. 
		// This gave approximately 45 lines of source code
	}
	
	public Elements getList() { // got all lines of source code that had tag of meta
		Elements metas = doc.getElementsByTag("meta");
		return metas;
	}
	
	public ArrayList<String> strs() { // this converted all lines of source code from type element to type string
		ArrayList<String> stringz = new ArrayList <String> (); 
		for(Element all: this.meta) {		{
				stringz.add(all.toString()); // this built in toString method did the conversion
			}
		}
		return stringz;
	}
	
	public ArrayList <String> essentials() { // this method found lines that contained the words name or price
		ArrayList <String> essential = new ArrayList <String> (); // the reason for these key words was because these 
		// lines had the only pieces of information needed
		for(int i = 0; i < strs().size(); i++) {
			if(strs().get(i).indexOf("price") != -1) {
				essential.add(strs().get(i));
			}
			if(strs().get(i).substring(12, 16).equals("name")) {
				essential.add(strs().get(i));
			}
		}
		return essential; // essential was an ArrayList of strings with each element (not to be confused with type element)
		//being parts of source code that gave name, price, and price change
	}
}
	

