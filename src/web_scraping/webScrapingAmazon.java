package web_scraping;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class webScrapingAmazon {

public static void main(String[] args) throws InterruptedException {
		


		List <WebElement> searchAmazonPrices;
		List <WebElement> searchAmazonProducts;
		
		List <String> allLinkPrice = new ArrayList<>();
		List <String> allLinkProduct = new ArrayList<>();
		
		File file = new File("C:\\Users\\wesll\\Documents\\bibliotecas Java\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com.br/");				
		Thread.sleep(500);
		
		driver.findElement(By.name("field-keywords")).sendKeys("Iphone");
		driver.findElement(By.name("field-keywords")).sendKeys(Keys.ENTER);
	
		searchAmazonProducts = driver.findElements(By.xpath("//div[@class='a-section a-spacing-none a-spacing-top-small']/h2/a"));			
		searchAmazonPrices = driver.findElements(By.xpath("//span[@class='a-price-whole']"));

		
		Excel.Excel2(searchAmazonProducts, searchAmazonPrices);
		
		driver.get("file:///C:/Users/wesll/eclipse-workspace/web_scraping/Resultados%20de%20Pesquisa.xls");				
		Thread.sleep(500);
	

	}
	

}