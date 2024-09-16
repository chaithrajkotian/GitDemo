package definitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import util.TestContextSetup;

public class Hooks {
	TestContextSetup testContextSetup;
	
	public Hooks(TestContextSetup testContextSetup)
	{
		this.testContextSetup=testContextSetup;
	}
	
	@After
	public void afterScenario() throws IOException 
	{
		testContextSetup.testBase.WebDriverManager().quit();
	}
	
	//explain in notes vd 47
	@AfterStep
	public void addScreenShot(Scenario scenario) throws IOException
	{
		WebDriver driver = testContextSetup.testBase.WebDriverManager();
		if(scenario.isFailed())
		{
			//take ss
		File sourcePath=	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//scenario need byte format
	byte[] fileContent=	FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		
		
		
		}
		
		
		
		
	}
}