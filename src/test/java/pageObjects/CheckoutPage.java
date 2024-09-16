package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

	public WebDriver driver;
	
	public CheckoutPage(WebDriver driver) {
		this.driver=driver;
	}


	
	By cartBag = By.cssSelector("img[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoBtn = By.cssSelector("button.promoBtn");
	By placeOrder = By.xpath("//button[contains(text(),'Place Order')]");
	By productName = By.cssSelector("p.product-name");

	
	//Actions
	
	public void checkoutItems()
	{
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
	
	}
	
	public boolean verifyPromoBtn()
	{
		return driver.findElement(promoBtn).isDisplayed();
		
	}
	
	public boolean verifyPlaceOrder()
	{
		return driver.findElement(placeOrder).isDisplayed();
		
	}
	
	
	
	public String getProductName()
	{
		return driver.findElement(productName).getText();
	}

	
}
