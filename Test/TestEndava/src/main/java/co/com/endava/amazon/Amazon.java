package co.com.endava.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import co.com.endava.model.Producto;

public class Amazon {

	private WebDriver driver;
	private final String url = "https://www.amazon.com/";
	
	public Amazon(WebDriver driver) {
		this.driver= driver;
		driver.get(url);
	}
	
	
	public void searchProduct(String product) {		
		WebElement element = driver.findElement(By.id("twotabsearchtextbox"));
		
		element.sendKeys(product);
		element.sendKeys(Keys.RETURN);
	}
	
	public void chooseProduct(String product) {		
		
		String selector = "//span[contains(text(),'"+product+"')]/ancestor::div[contains(@class, 'a-section a-spacing-medium')]";
		
		driver.findElement(By.xpath(selector)).click();
		
	}
	
	public Producto getProduct() {
		
		String title = driver.findElement(By.cssSelector("span[id='productTitle']")).getText();
		String autor = driver.findElement(By.cssSelector(".author > span > a")).getText();
		String rate = driver.findElement(By.cssSelector("span[id='acrCustomerReviewText']")).getText();
	
		return Producto.builder()
				.title(title)
				.author(autor)
				.ranked(rate)
				.build();
	}
}