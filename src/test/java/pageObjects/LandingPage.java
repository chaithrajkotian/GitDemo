package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

	
	By search = By.xpath("//input[@type='search']");
	By productName=By.cssSelector("h4.product-name");
	By topDeals=By.linkText("Top Deals");
	By increment =  By.cssSelector("a.increment");
	By addToCart = By.cssSelector("div.product-action button");
	
	//Actions
	
	public void searchItem(String name)
	{
		driver.findElement(search).sendKeys(name);
	}
	
	public String getproductname()
	{
		return driver.findElement(productName).getText();
	}
	
	public void selectTopDealsPage()
	{
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage()
	{
		return driver.getTitle();
	}
	
	
	public void incrementquantity(int quantity)
	{
		int i = quantity-1; //3-1=2
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
}
