package web_scraping;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class webScrapingAmazon {

	public static void main(String[]args) {
	
	  try {
		  
          Document docName = Jsoup.connect("https://www.amazon.com.br/s?k=Iphone&rh=p_89%3AApple&dc&__mk_pt_BR=%C3%85M%C3%85%C5%BD%C3%95%C3%91&qid=1595518883&rnid=18120432011&ref=sr_nr_p_89_1").userAgent("\"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/84.0.4147.89 Safari/537.31\"").get();
          Elements tempName = docName.select("h2.a-size-mini.a-spacing-none.a-color-base.s-line-clamp-4");
          Elements temp2 = docName.select("span:nth-of-type(2) > .a-price-whole");
          Excel.Excel2(tempName , temp2 );
           
             
      }
      
      catch (IOException e) {
          e.printStackTrace();
      }
	
	}
}
