package pageObjects;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {

	public WebDriver driver;
	public JavascriptExecutor js;

	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	public Base_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		js = (JavascriptExecutor) driver;

	}

}
