package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login_Page extends Base_Page {

	public Login_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//button[@type='submit']")
	WebElement btn_login;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_email;

	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void setEmail(String email) {
		txt_email.sendKeys(email);
	}

	public void clikLogin() {
		js.executeScript("arguments[0].click();", btn_login);
		// btn_login.click();
	}

}
