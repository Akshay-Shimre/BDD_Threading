package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
private WebDriver driver;

//Locators

private By email=By.name("email");
private By password=By.name("password");
private By loginButton=By.xpath("//input[@value='Login']");
private By forgotPassword=By.linkText("Forgotten Password");

// constructor of page class

public LoginPage (WebDriver driver)
{
	this.driver=driver;
}

//page actions

public String  getLoginPageTitle()
{
	return driver.getTitle();
	 
}

public boolean isForgotPassLinkExist()
{
	return driver.findElement(forgotPassword).isDisplayed();
}

public void enterUserName(String username) throws InterruptedException
{
	driver.findElement(email).sendKeys(username);
	Thread.sleep(5000);
}

public void enterUserPwd(String pwd) throws InterruptedException
{
	driver.findElement(password).sendKeys(pwd);
	Thread.sleep(5000);

}

public void clickSignIn() throws InterruptedException
{
	driver.findElement(loginButton).click();
	Thread.sleep(5000);

}

public LandingPage doLogin(String un, String pw) throws InterruptedException
{
	//System.out.println("Login with : "+ un + "and" + pw);
	driver.findElement(email).sendKeys(un);
	driver.findElement(password).sendKeys(pw);
	driver.findElement(loginButton).click();
	return new LandingPage(driver);
}


}
