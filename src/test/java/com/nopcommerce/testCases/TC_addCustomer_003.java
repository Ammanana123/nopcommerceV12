package com.nopcommerce.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.PageObject.testCustomerPage;
import com.nopcommerce.testBase.testBase;
import com.nopcommerce.PageObject.testPageObject;
public class TC_addCustomer_003 extends testBase {
	@Test
	public void testNopcomCustomer() throws InterruptedException, IOException {
		logger.info("***Starting TC_testLogin_003***");
		driver.get(confiPropObj.getProperty("baseURL"));
		testPageObject tp= new testPageObject(driver);
		logger.info("*** Validating Login details***");
		tp.setUsername(confiPropObj.getProperty("userName"));
		tp.setPassword(confiPropObj.getProperty("userPassword"));
		tp.clickLogin();
		Thread.sleep(3000);
		logger.info("***Adding new customer***");
		testCustomerPage tcp= new testCustomerPage(driver);
		tcp.customer1();
		tcp.cust2();
		tcp.addcust();
		Thread.sleep(3000);
		logger.info("***Filling the new customer details****");
		String email=randomString()+"@gmail.com";
		tcp.typemail(email);
		tcp.typepassword("Test123");
        tcp.typefirstname("Pavan");
		tcp.typelastname("Tippirisetty");
		tcp.checkmale("Male");
		tcp.selectdate();
		tcp.selectcompany("Teva");
		tcp.checkTax();
		tcp.newsLetter("Canadian news");
		Thread.sleep(5000);
		tcp.customRoles("Registered");
		Thread.sleep(5000);
		tcp.Vendor();
		tcp.checkButton();
		tcp.admincontent();
		tcp.custsave();
		Thread.sleep(3000);
		logger.info("****Customer details added****");
		
		String msg=driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
		
				if (msg.contains("The new customer has been added successfully.")) {
			logger.info("***testNopcomCustomer method passed successfully");
			Assert.assertTrue(true);
		}
		else {
			logger.warn("***testNopcomCustomer method failed****");
			captureScreen(driver,"logintest");
			Assert.assertTrue(false);
		}
			
	}
}
