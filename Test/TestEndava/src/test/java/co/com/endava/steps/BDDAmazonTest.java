package co.com.endava.steps;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import co.com.endava.amazon.Amazon;
import co.com.endava.model.Producto;
import co.com.endava.utilities.Browser;
import co.com.endava.utilities.Nav;
import co.com.endava.web.AppTest;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.java.Log;


@Log
public class BDDAmazonTest {
	
	WebDriver driver;
	Amazon amazon;
	
	@Given("^website loaded$")
	public void user_is_on_login_page() {
		log.info("------- Starting -----------");
		driver = Browser.load(Nav.Mozilla);
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		amazon = new Amazon(driver);
	}
	
    @When("^search book for testing$")
	public void user_enters_correct_credentials() {
    	amazon.searchProduct("Software Test Design");	
	}    
   
    @And("^choose book (.*)$")
    public void user_enters_password(String name){
    	amazon.chooseProduct(name);
    }
    
    @Then("^confirmed data of book (.*) , (.*) , (.*)$")
	public void user_get_confirmed(String title,String author, String rank) {
    	Producto producto = amazon.getProduct();
		
    	log.info("Info del producto "+producto);
		assertEquals(title, producto.getTitle());
		assertEquals(author, producto.getAuthor());
		assertTrue("El ranking no coicide", producto.getRanked().contains(rank));		
    	
	}
    
    @After
    public void tearDown() {
    	driver.close();// current window browser
    }

}
