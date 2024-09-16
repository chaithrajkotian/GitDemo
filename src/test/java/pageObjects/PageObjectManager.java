package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

	public WebDriver driver;
	public LandingPage landingPage;
	public OfferPage offerPage;
	public CheckoutPage checkOutPage;
	
	public PageObjectManager(WebDriver driver) {

		this.driver=driver;
		}
	
	//craeting object of landing page here rather that in stepdefinition
	public LandingPage getLandingPage()
	{
		landingPage=new LandingPage(driver);
		return landingPage;
		
	}
	
	public OfferPage getOfferPage()
	{
		offerPage = new OfferPage(driver);
		return offerPage;
	}
	
	public CheckoutPage getCheckOutPage()
	{
		checkOutPage= new CheckoutPage(driver);
		return checkOutPage;
	}
}
