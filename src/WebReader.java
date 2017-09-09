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
		
		
		Document doc = Jsoup.connect("http://people.cs.umass.edu/~liberato/courses/2017-fall-compsci190d/").get();
		String title = doc.title();
		String body = doc.body().text();
		Elements links = doc.select("a[href]");
		
		for (Element link : links) {
			
			System.out.println("link : " + link.attr("href"));
			System.out.println("text : " + link.text());
			
		}
		
		System.out.println(title);
		System.out.println();
		//System.out.println(body);
		String description = doc.select("meta[name=description]").first().attr("content");
		System.out.println("Description : " + description);
		
		//String keywords = doc.select("meta[name=keywords]").first().attr("content");
		//System.out.println("Keywords : " + keywords);
		
		String html = Jsoup.connect("http://people.cs.umass.edu/~liberato/courses/2017-fall-compsci190d/").get().html();
		
		//System.out.println(html);
		
	}

}
