package com.nopcommerce.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Configuration;
import org.testng.annotations.Test;

import com.nopcommerce.PageObject.testPageObject;
import com.nopcommerce.testBase.testBase;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TC_testLogin_001 extends testBase {
	
	@Test
	public void loginDetails() throws IOException {
		logger.info("***Starting TC_testLogin_001***");
		driver.get(confiPropObj.getProperty("baseURL"));
		testPageObject tp= new testPageObject(driver);
		logger.info("*** Validating Login details***");
		tp.setUsername(confiPropObj.getProperty("userName"));
		tp.setPassword(confiPropObj.getProperty("userPassword"));
		tp.clickLogin();
		String expectedtitle="Dashboard / nopCommerce administration";
		String actual=driver.getTitle();
		if (expectedtitle.equals(actual)){
		logger.info("***Validation successful***");
			Assert.assertTrue(true);
		}
		
		else {
			logger.error("***Validation unsuccessful****");
			captureScreen(driver,"loginDetails");
			Assert.assertTrue(false);
		}
		
		}
}
