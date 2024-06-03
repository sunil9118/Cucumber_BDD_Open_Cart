package stepDefinitions;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Home_Page;
import pageObjects.Login_Page;
import pageObjects.My_Account_Page;
import utilities.DataReader;

public class Login_Steps {

//	WebDriver driver;
	Home_Page hp;
	Login_Page lp;
	My_Account_Page myaccPage;
	List<HashMap<String, String>> datamap; // Data driven

	@Given("Navigate user to login page")
	public void navigate_user_to_login_page() {

		BaseClass.getLogger().info("Navigate to home and click on login");
		hp = new Home_Page(BaseClass.getDriver());
		hp.click_MyAccount();
		hp.login();

	}

	@When("Enter credentails for logining the page \\(username: {string}, password: {string})")
	public void enter_credentails_for_logining_the_page_username_password(String email, String password) {
		BaseClass.getLogger().info("Entering Credential for logging");
		lp = new Login_Page(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);

	}

	@When("click on login button")
	public void click_on_login_button() {
		lp.clikLogin();
		BaseClass.getLogger().info("Clicked on Login button");

	}

	@Then("User redirected to MyAccount page")
	public void user_redirected_to_my_account_page() {
		BaseClass.getLogger().info("My Account Page Verification after successfull login");
		myaccPage = new My_Account_Page(BaseClass.getDriver());
		boolean targetPage = myaccPage.myAccountVerification();
		Assert.assertEquals(targetPage, true);

	}

	@Then("the user should be redirected to the MyAccount Page by passing email and password with excel row {string}")
	public void the_user_should_be_redirected_to_the_my_account_page_by_passing_email_and_password_with_excel_row(
			String rows) throws IOException {

		datamap = DataReader.data(".\\testData\\Opencart_LoginData.xlsx", "sheet1");

		int index = Integer.parseInt(rows) - 1;
		String email = datamap.get(index).get("username");
		String password = datamap.get(index).get("password");
		String exp_res = datamap.get(index).get("res");

		lp = new Login_Page(BaseClass.getDriver());
		lp.setEmail(email);
		lp.setPassword(password);
		lp.clikLogin();

		myaccPage = new My_Account_Page(BaseClass.getDriver());
		try {
			boolean targetPage = myaccPage.myAccountVerification();
			if (exp_res.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					myaccPage.logout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}

			}
			if (exp_res.equalsIgnoreCase("Invalid")) {
				if (targetPage == true) {
					myaccPage.logout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}

			}
		} catch (Exception e) {
			Assert.assertTrue(false);
		}

	}

}
