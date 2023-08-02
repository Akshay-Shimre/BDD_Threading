package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	private WebDriver driver;
	
	//Constructor for Webdriver instance
	public LandingPage (WebDriver driver)
	{
		this.driver=driver;
	}
	
	//Locators
	
	By getContent=By.cssSelector("div#content h2");
	
	
	//Actions
	
	public int getAccountSectionCount()
	{
		return driver.findElements(getContent).size();
	}
	
	public List<String> getAccountSectionList()
	{
		List<String> accountList= new ArrayList<>();
		List<WebElement> accountSectionList=driver.findElements(getContent); 
		
		for (WebElement e : accountSectionList)
		{
			String text=e.getText();
			System.out.println(text);
			accountList.add(text);
		}
		
		return accountList;
	}
	
	public String landingPgTitle()
	{
		return driver.getTitle();
	}

}
