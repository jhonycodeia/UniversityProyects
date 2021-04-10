package co.com.endava.web;

import static org.junit.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.WebDriver;

import co.com.endava.amazon.Amazon;
import co.com.endava.model.Producto;
import co.com.endava.utilities.Browser;
import co.com.endava.utilities.Data;
import co.com.endava.utilities.Nav;
import lombok.extern.java.Log;

@Log
@RunWith(Parameterized.class)
public class AppTest {

	private static final String filename = "src/test/resources/amazonData.csv";
	private WebDriver driver;
	private boolean chrome = true;
	private Producto item;
	

	
	@Parameters
	public static List<String[]> getData() {
		return Data.csv(filename);
	}
	
	
	public AppTest(String book, String title, String author, String ranked) {
		item = Producto.builder()
				.book(book)
				.title(title)
				.author(author)
				.ranked(ranked)
				.build();
	}
	
	@Before
	public void before() {
		log.info("------- Starting -----------");
		if(chrome) {
			driver = Browser.load(Nav.Chrome);
		}else {
			driver = Browser.load(Nav.Mozilla);
		}
		driver.manage().timeouts().implicitlyWait(7,TimeUnit.SECONDS);
	}
	
	@Test
	public void test() {
		
		try {			
			
			Amazon amazon = new Amazon(driver);
			
			log.info("Data :"+item);
			
			amazon.searchProduct("Software Test Design");			
			amazon.chooseProduct(item.getBook());
			
			Producto producto = amazon.getProduct();
			
			log.info("Info del producto "+producto);
			
			assertEquals(item.getTitle(), producto.getTitle());
			assertEquals(item.getAuthor(), producto.getAuthor());
			assertTrue("El ranking no coicide", producto.getRanked().contains(item.getRanked()));		
			
		} catch (Exception e) {
			throw e;
		}
	}
	
	
	@After
	public void despues() {
		log.info("------- Closing -----------");
		driver.close();
	}

}
