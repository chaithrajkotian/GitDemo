package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import pageObjects.OfferPage;
import pageObjects.PageObjectManager;
import util.TestContextSetup;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;

public class OfferpageStepDefinition {

	PageObjectManager pageObjectManager;
	public String offerPageProductname;
	TestContextSetup testContextSetup;
	
	public OfferpageStepDefinition(TestContextSetup testContextSetup)
	{
	this.testContextSetup=	testContextSetup;
	}

	
	
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException { 
	    
		swithToOfferPage();
		//OfferPage offerPage = new OfferPage(testcontextSetup.driver);
		OfferPage offerPage= testContextSetup.pageObjectManager.getOfferPage();
		offerPage.searchItem(shortName);
		Thread.sleep(2000);

		 offerPageProductname=offerPage.getProductName();

	}
	
	public void swithToOfferPage()
	{
		//pageObjectManager= new PageObjectManager(tesxtcontentsetup.driver);
		LandingPage landingPage= testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDealsPage();
		testContextSetup.genericUtils.SwitchWindowToCild();
	}
	
	
	@Then("validate product name in offers page  matches with Landing Page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    
	Assert.assertEquals(offerPageProductname, testContextSetup.landingPageProductName);
		
	}

	
}
