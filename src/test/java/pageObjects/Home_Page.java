package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home_Page extends Base_Page {

	public Home_Page(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement myAccount;
	@FindBy(xpath = "//a[@class='dropdown-item'][normalize-space()='Register']")
	WebElement register;
	@FindBy(xpath = "//a[normalize-space()='Login']")
	WebElement el_login;

	public void click_MyAccount() {
		myAccount.click();
	}

	public void clik_Register() {
		register.click();
	}

	public void login() {
		el_login.click();
	}
}
