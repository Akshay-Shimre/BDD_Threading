package stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.testng.Assert;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LandingPage {
	
	private LoginPage loginPg=new LoginPage(DriverFactory.getDriver());
    private com.pages.LandingPage landingPg;
	
	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) throws InterruptedException {
	  
		List<Map<String, String>> credentialList=dataTable.asMaps();
		
		String userName=credentialList.get(0).get("username");
		String password=credentialList.get(0).get("password");
		
		DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		Thread.sleep(5000);
		System.out.println(userName);
		System.out.println(password);

		landingPg = loginPg.doLogin(userName, password);
		
	}
	
	@Given("user is on Landing page")
	public void user_is_on_landing_page() {
		
		Assert.assertTrue(loginPg.getLoginPageTitle().equals(landingPg.landingPgTitle()));
	   
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(DataTable expectedAccountSection) {
	   
		List<String> expectedList=expectedAccountSection.asList();
		System.out.println("Expected Account Section List : "+expectedAccountSection);
		List<String> actualList=landingPg.getAccountSectionList();
		System.out.println("Actual Account Section List : "+actualList);
		
		Assert.assertTrue(expectedList.equals(actualList));

		
	}

	@Then("account section count should be {int}")
	public void account_section_count_should_be(Integer sectionCount) {
	   
		Integer expectedCount=sectionCount;
		Integer actualSectionCount=landingPg.getAccountSectionCount();
		
		System.out.println("Expected count "+expectedCount);
		System.out.println("Actual count "+actualSectionCount);

		
		Assert.assertTrue(expectedCount.equals(actualSectionCount));
		
	/*	if (expectedCount.equals(actualSectionCount))
		{
			System.out.println("Count Matched -  No of Actual section = "+actualSectionCount+ "No of Expected Section = "+expectedCount);
		}
		
		else
		{
			Assert.assertNotEquals(actualSectionCount, expectedCount);
		} */
	}

	
	
}


