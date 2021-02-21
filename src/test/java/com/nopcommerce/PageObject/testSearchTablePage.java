package com.nopcommerce.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class testSearchTablePage {
	
	public WebDriver driver;
	
	public testSearchTablePage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@id='SearchEmail']")
	@CacheLookup
	WebElement txtSearchEmail;
	
	@FindBy(xpath="//input[@id='SearchFirstName']")
	@CacheLookup
	WebElement txtSearchFirstName;
	
	@FindBy(xpath="//input[@id='SearchLastName']")
	@CacheLookup
	WebElement txtSearchLastName;
	
	@FindBy(xpath="//td[text()='victoria_victoria@nopCommerce.com']")
	@CacheLookup
	WebElement txtvictoria;
	
	@FindBy(xpath="//td[text()='Victoria Terces']")
	@CacheLookup
	WebElement txtTerces;
	
	@FindBy(xpath="//button[@id='search-customers']")
	@CacheLookup
	WebElement cliksearch;
	
	public void setEmail() {
		txtvictoria.sendKeys();
	}
	
	public void setFirstname() {
		txtTerces.sendKeys();
	}
	
	public void clicksearch() {
		cliksearch.click();
	}
	
	public void searchEmail(String email) {
		txtSearchEmail.sendKeys(email);
	}
	
	public void searchFirstname(String Fname) {
		txtSearchFirstName.sendKeys(Fname);
	}
	
	public void searchLastname(String Lname) {
		txtSearchLastName.sendKeys(Lname);
	}
}
