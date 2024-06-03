package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Account_Registration_Page extends Base_Page {

	JavascriptExecutor js = (JavascriptExecutor) driver;

	public Account_Registration_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txt_lastName;
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txt_firstName;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txt_e_Mail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txt_password;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chk_checkPolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		wait.until(ExpectedConditions.visibilityOf(txt_firstName));
		txt_firstName.sendKeys(fname);

	}

	public void setLastName(String lname) {
		txt_lastName.sendKeys(lname);
	}

	public void setPassword(String password) {
		txt_password.sendKeys(password);
	}

	public void setEmail(String email) {
		txt_e_Mail.sendKeys(email);
	}

	public void privacyPolicy() throws InterruptedException {
		js.executeScript("arguments[0].click();", chk_checkPolicy);

		// chk_checkPolicy.click();
	}

	public void buttonContinue() {
		js.executeScript("arguments[0].click();", btnContinue);
		// btnContinue.click();

	}

	public String confirmationMSG() {

		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	}

}
