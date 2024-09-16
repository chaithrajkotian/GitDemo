package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import util.TestContextSetup;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;

public class LandingPageStepDefinition {

	public WebDriver driver;
	
	public String offerPageProductname;
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	public LandingPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		
		//we are initializing  this here bcz  LandingPage object is essential because it will be used in multiple methods within the LandingPageStepDefinition class.
		//this.landingPage=testContextSetup.pageObjectManager.getLandingPage();
		 this.landingPage = testContextSetup.pageObjectManager.getLandingPage();

		
	}
		@Given("User is on Greencart Landing page")
	public void user_is_on_greencart_landing_page() {
			
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));	
	}

		@When("^user searched with shortname (.+) and etracted actual name of product$")
		public void user_searched_with_shortname_and_etracted_actual_name_of_product(String shortName ) throws InterruptedException {
			landingPage.searchItem(shortName);
			Thread.sleep(2000);
			testContextSetup.landingPageProductName = landingPage.getproductname().split("-")[0].trim();
			System.out.println(testContextSetup.landingPageProductName +" is extracted from Home page");
				
	}
	
	
		@When("Added {string} items of the selected product to cart")
		public void Added_items_of_selected_product_to_cart(String quantity)
		{
			landingPage.incrementquantity(Integer.parseInt(quantity));
			landingPage.addToCart();
		}
	
	
	


	
}
