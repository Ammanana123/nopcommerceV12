package com.nopcommerce.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DriverCommand;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class testCustomerPage {
	private static final Select WebElement = null;

	public WebDriver driver;

	public testCustomerPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		@FindBy(xpath="(//span[text()='Customers'])[1]")
		@CacheLookup
		WebElement clkCustomer1;
		
		@FindBy(xpath="(//span[text()='Customers'])[2]")
		@CacheLookup
		WebElement clkCustomer9;
	
		@FindBy(xpath="//a[@class='btn bg-blue']")
		@CacheLookup
		WebElement btnbgblue;
		
		@FindBy(id="Email")
		@CacheLookup
		WebElement txtemail;
		
		@FindBy(name="Password")
		@CacheLookup
		WebElement txtPassword;
		
		@FindBy(id="FirstName")
		@CacheLookup
		WebElement txtFirstName;
		
		
		@FindBy(id="LastName")
		@CacheLookup
		WebElement txtLastName;
		
		
		@FindBy(id="Gender_Male")
		@CacheLookup
		WebElement RadioGender_Male;
		
		@FindBy(id="Gender_Female")
		@CacheLookup
		WebElement RadioGender_Female;
		
		
		@FindBy(id="DateOfBirth")
		@CacheLookup
		WebElement txtDateOfBirth;
		
		@FindBy(id="Company")
		@CacheLookup
		WebElement txtCompany;
		
		@FindBy(id="IsTaxExempt")
		@CacheLookup
		WebElement checkIsTaxExempt;
		
		@FindBy(xpath="(//div[@role='listbox'])[1]")
		@CacheLookup
		WebElement txtnews;
		
		@FindBy(xpath="(//div[@role='listbox'])[2]")
		@CacheLookup
		WebElement slcustrole;
		
		@FindBy(xpath="//select[@id='VendorId']")       //span[@title='delete']
		@CacheLookup
		WebElement selectVendor;
		
		@FindBy(id="Active")
		@CacheLookup
		WebElement chkActive;
		
		@FindBy(id="AdminComment")
		@CacheLookup
		WebElement txtAdminComment;
		
		@FindBy(xpath="//button[@name='save']")
		@CacheLookup
		WebElement clksave;
		
		public void customer1() {
			clkCustomer1.click();
		}
		
		public void cust2() {
			clkCustomer9.click();
		}
		
		public void addcust() {
			btnbgblue.click();
		}
		
		public void typemail(String email) {
			txtemail.sendKeys(email);
		}
		
		public void typepassword(String pwd){
			txtPassword.sendKeys(pwd);
		}
		
		public void typefirstname(String uname) {
			
			txtFirstName.sendKeys(uname);
		}
		
		public void typelastname(String Lname) {
			txtLastName.sendKeys(Lname);
		}
		
		public void checkmale(String gender) {
			RadioGender_Male.click();
		}
		
		public void checkfemale(String gender) {
			RadioGender_Female.click();
		}
		
		public void selectdate() {
			txtDateOfBirth.click();
			Actions act= new Actions(driver);
			act.moveToElement(driver.findElement(By.xpath("//span[@class='k-icon k-i-calendar']"))).click().perform();
			act.moveToElement(driver.findElement(By.xpath("//a[text()='16']"))).click().perform();
		}
		public void selectcompany(String comname) {
			txtCompany.sendKeys(comname);
		}
		public void checkTax() {
			 checkIsTaxExempt.click();
		}
		
		public void newsLetter(String newsname) {
			txtnews.click();
		driver.findElement(By.xpath("//li[text()='Your store name']")).click();	
		}
		
		public void customRoles(String role) {
			slcustrole.click();
			driver.findElement(By.xpath("//span[@title='delete']")).click();
			slcustrole.click();
			if(slcustrole.equals("Registered")) {
				driver.findElement(By.xpath("//li[text()='Registered'")).click();
			}
			else if(slcustrole.equals("Guests")) {
				
			driver.findElement(By.xpath("//li[text()='Guests'")).click();
			}
		}
		
		public void Vendor() {
			selectVendor.click();
			Select ss= new Select(driver.findElement(By.xpath("//select[@id='VendorId']")));
			ss.selectByIndex(1);
			
		}
		
		public void checkButton() {
			chkActive.click();	
		}
				
			public void admincontent() {
				txtAdminComment.sendKeys("Creating new nopcommerce customer for the nopcommerce project");
				
			}
			
			public void custsave() {
				clksave.click();
				
			}
		}
		

