package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/features",
glue="definitions", monochrome=true,tags="@PlaceOrder or @OfferPage",
plugin={"html:target/cucumber.html","json:target/cucumber.json",
	"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
	"rerun:target/failed_scenario.txt"
}

)
public class TestNgTestRunner extends AbstractTestNGCucumberTests {

	//run test parallely explin in notes vd41
	
	@Override
	@DataProvider(parallel=true)
	public Object[][] scenarios()
	{
		return super.scenarios();
	}
}
