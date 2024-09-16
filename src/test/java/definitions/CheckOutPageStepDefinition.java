package definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import util.TestContextSetup;

import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import org.testng.Assert;

public class CheckOutPageStepDefinition {

	public WebDriver driver;
	
	public String offerPageProductname;
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	LandingPage landingPage;
	public String checkProductName;
	public CheckoutPage checkOutPage;
	public CheckOutPageStepDefinition(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
		 this.checkOutPage= testContextSetup.pageObjectManager.getCheckOutPage();

	}
		
	
	
	@Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name)
	{
	
		checkOutPage.checkoutItems();
		//takes time after click cart bag 
		
		//taking the name from checkout page and chevking landing oage pn and checkout page pn should be equal
		checkProductName=checkOutPage.getProductName().split("-")[0].trim();
		System.out.println(checkProductName);
		Assert.assertEquals(checkProductName,testContextSetup.landingPageProductName);
		
	}
	
	
	@Then("verify user has the ability to enter promo code and place the order")
	public void verify_user_has_ability_enter_promo_code()
	{
		Assert.assertTrue(checkOutPage.verifyPromoBtn());
		Assert.assertTrue(checkOutPage.verifyPlaceOrder());
	}
	
	
	
	
	


	
}
