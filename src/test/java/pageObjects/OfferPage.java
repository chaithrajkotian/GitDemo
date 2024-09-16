package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPage {

	public WebDriver driver;
	
public OfferPage(WebDriver driver) {
		
		this.driver=driver;
	}

//Objects
	By search = By.id("search-field");
	By productName = By.cssSelector("tr td:nth-child(1)");
	
	
	//action
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getProductName()
	{
	return	driver.findElement(productName).getText();
	}
	
}
