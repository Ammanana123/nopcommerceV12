package com.nopcommerce.testCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.nopcommerce.PageObject.testCustomerPage;
import com.nopcommerce.PageObject.testPageObject;
import com.nopcommerce.PageObject.testSearchTablePage;
import com.nopcommerce.testBase.testBase;

public class TC_SearchCustomer_004 extends testBase {
	@Test
	public void searchCustomer() throws InterruptedException {
		
		logger.info("***Starting TC_SearchCustomer_004***");
		driver.get(confiPropObj.getProperty("baseURL"));
		testPageObject tp= new testPageObject(driver);
		logger.info("*** Validating Login details of testcase 004***");
		tp.setUsername(confiPropObj.getProperty("userName"));
		tp.setPassword(confiPropObj.getProperty("userPassword"));
		tp.clickLogin();
		Thread.sleep(3000);
		logger.info("***** Clicking on customer to find search customer ****");
		testCustomerPage tcp= new testCustomerPage(driver);
		tcp.customer1();
		tcp.cust2();
		Thread.sleep(4000);
		
		testSearchTablePage tst= new testSearchTablePage(driver);
		//tst.searchEmail("victoria_victoria@nopCommerce.com");
		//tst.setEmail("victoria_victoria@nopCommerce.com");
		//tst.setFirstname("Victoria Terces");
		tst.searchFirstname("Victoria ");
		tst.searchLastname("Terces");
		Thread.sleep(3000);
		tst.clicksearch();
		
		
		String expectedname="Victoria Terces";
		String Actualname=driver.findElement(By.xpath("//td[text()='Victoria Terces']")).getText();
		
		if( expectedname.equals(Actualname)) {
			logger.info("**** TC_SearchCustomer_004 passed successfully");
			Assert.assertTrue(true);
		}
		else {
			logger.warn("***** TC_SearchCustomer_004  failed");
			Assert.assertTrue(false);
		}
	}
	

}
