import java.io.IOException;
import java.util.logging.Logger;

import org.jsoup.*;
import java.util.logging.Level;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebReader {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	
		
		String webpage = "http://people.cs.umass.edu/~liberato/courses/2017-fall-compsci190d/";
		Document doc = Jsoup.connect(webpage).get();
	
		
		scrapeLinks(doc);
		System.out.println(doc.html());
		scrapeText(doc);
		
	}
	
	
	static void scrapeLinks(Document page) {
		
		Elements links = page.select("a[href]");
		for (Element link : links) {
			
			System.out.println("link : " + link.attr("href"));
			System.out.println("text : " + link.text());
			
		}
	}
	
	static void scrapeText(Document page) {
		String title = page.title();
		String body = page.body().text();
		
		System.out.println(title);
		System.out.println();
		System.out.println(body);
		
		String description = page.select("meta[name=description]").first().attr("content");
		System.out.println("Description : " + description);
		
	}

}
