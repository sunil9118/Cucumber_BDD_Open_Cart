package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hook {

	WebDriver driver;
	Properties p;

	// initializing the browser for stepdefinition file
	@Before
	public void setup() throws IOException {

		driver = BaseClass.intializeBrowser();
		p = BaseClass.getproperties();
		driver.get(p.getProperty("appURL"));
		driver.manage().window().maximize();
	}

	@After
	public void teardown(Scenario scenario) {
		driver.quit();

	}

	// attaching screenshot if step is failed
	@AfterStep
	public void addScreeshot(Scenario scenario) {

		if (scenario.isFailed()) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "img/png", scenario.getName());

		}
	}

}
