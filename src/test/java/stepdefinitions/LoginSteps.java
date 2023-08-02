package stepdefinitions;

import org.junit.Assert;
import org.junit.runner.RunWith;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
public class LoginSteps {
	
private LoginPage loginPg=new LoginPage(DriverFactory.getDriver());
private static String PageTitle;
    @Given("^user is on login page$")
    public void user_is_on_login_page() throws Throwable {
       
    	DriverFactory.getDriver().get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
    	
    	
    }
   
    
    @Then("^page title should be \"([^\"]*)\"$")
    public void page_title_should_be_something(String expectedPageTitle) throws Throwable {
    	
    	
    	Assert.assertTrue(PageTitle.contains(expectedPageTitle));
        
    }
    
    @Then("^forgot your password link should be displayed$")
    public void forgot_your_password_link_should_be_displayed() throws Throwable {
        
    	Assert.assertTrue(loginPg.isForgotPassLinkExist());
    	
    }
    
    @When("^user enters username \"([^\"]*)\"$")
    public void user_enters_username_something(String username) throws Throwable {
        
    	loginPg.enterUserName(username);
    }

    @And("^user enters password \"([^\"]*)\"$")
    public void user_enters_password_something(String password) throws Throwable {
        
    	loginPg.enterUserPwd(password);
    }

    @And("^user clicks on Login button$")
    public void user_clicks_on_login_button() throws Throwable {
        
    	loginPg.clickSignIn();
    }
    
    @When("^user gets the title of the page$")
    public void user_gets_the_title_of_the_page() throws Throwable {
       
    	 PageTitle=loginPg.getLoginPageTitle();
    	System.out.println("Login Page Title is " +PageTitle);
    }
    
    

}
