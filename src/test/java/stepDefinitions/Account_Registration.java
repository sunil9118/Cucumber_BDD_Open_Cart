package stepDefinitions;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.Account_Registration_Page;
import pageObjects.Home_Page;

public class Account_Registration {
	WebDriver driver;
	Home_Page hp;
	public Account_Registration_Page regpage;

	@Given("Navigate to registration page")
	public void navigate_to_registration_page() {
		hp = new Home_Page(BaseClass.getDriver());
		hp.click_MyAccount();
		hp.clik_Register();

	}

	@When("Enter the registration details")
	public void enter_the_registration_details(DataTable dataTable) {
		Map<String, String> dataMap = dataTable.asMap();
		regpage = new Account_Registration_Page(BaseClass.getDriver());
		regpage.setFirstName(dataMap.get("FirstName"));
		regpage.setLastName(dataMap.get("LastName"));
		regpage.setEmail(BaseClass.randomeString() + "@gmail.com");
		regpage.setPassword(dataMap.get("password"));

	}

	@When("Select privacy policy")
	public void select_privacy_policy() throws InterruptedException {
		regpage.privacyPolicy();

	}

	@When("Clik on continue button")
	public void clik_on_continue_button() {
		regpage.buttonContinue();

	}

	@Then("New account should be created")
	public void new_account_should_be_created() {
		String confMsg = regpage.confirmationMSG();
		Assert.assertEquals(confMsg, "Your Account Has Been Created!");

	}

}
