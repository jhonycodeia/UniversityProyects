package co.com.endava.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	
	private static WebDriver driver;
	
	public static WebDriver load(Nav nav){
		switch (nav) {
		case Chrome:
			WebDriverManager.chromedriver().setup();
			return new ChromeDriver();
			
		case Mozilla:
			WebDriverManager.firefoxdriver().setup();
			return new FirefoxDriver();

		default:
			return null;
		}
	}
	

}
