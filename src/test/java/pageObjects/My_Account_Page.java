package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class My_Account_Page extends Base_Page {

	public My_Account_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div/a[text()='Logout']")
	WebElement link_logout;
	@FindBy(xpath = "//div/h2[text()='My Account']")
	WebElement msgheading;

	public void logout() {
		js.executeScript("arguments[0].click();", link_logout);
		// link_logout.click();
	}

	public boolean myAccountVerification() {

		try {
			msgheading.isDisplayed();
			return true;

		} catch (Exception e) {
			return false;
		}
	}

}
