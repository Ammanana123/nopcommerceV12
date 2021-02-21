package com.nopcommerce.testCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nopcommerce.PageObject.testPageObject;
import com.nopcommerce.Utilities.XLUtils;
import com.nopcommerce.testBase.testBase;


public class TC_DataDriven_Test_002  extends testBase{
	@Test(dataProvider="Logindata")
	public void testDataDriven(String username, String password, String exp) throws InterruptedException {
		logger.info("***TC_DataDriven_Test_002 ***");
		driver.get(confiPropObj.getProperty("baseURL"));
		testPageObject tp= new testPageObject(driver);
		logger.info("*** Validating Login details***");
		tp.setUsername(username);
		tp.setPassword(password);
		tp.clickLogin();
		Thread.sleep(3000);
		String expextedTitle="Dashboard / nopCommerce administration";
		String actualTitle=driver.getTitle();
		if(expextedTitle.equals(actualTitle)) {
			if(exp.equals("pass")){
			logger.info("***TC_DataDriven_Test_002 passed successfully***");
			tp.ClickLogout();
			Thread.sleep(3000);
			Assert.assertTrue(true);
		}else if(exp.equals("fail")){
				logger.warn("***TC_DataDriven_Test_002 failed *****");
				Assert.assertTrue(false);
			}
		}
		if (!expextedTitle.equals(actualTitle)) {
			if(exp.equals("pass")){
		logger.info("****TC_DataDriven_Test_002 failed ***");
		Assert.assertTrue(false);
		}else if(exp.equals("fail")){
	logger.info("***TC_DataDriven_Test_002 passed successfully***");
	Assert.assertTrue(true);
		}
				
			}
		
		logger.info("**** TC_DataDriven_Test_002 passed successfully ****");
		}
		
		
		
	@DataProvider(name="Logindata")
		public  String [][]getDataExcel() throws IOException {
			String path=".\\testdata\\datanopcom.xlsx";
		int totalrows=XLUtils.getRowCount(path, "Sheet1");
		int totalcol=XLUtils.getCellCount(path, "Sheet1", 1);
		String Logindata[][] = new String [totalrows][totalcol];
		for(int i=1; i<=totalrows; i++){
			
			for(int j=0; j<totalcol; j++) {
				 Logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
		}
			
		return 	Logindata;
			
		}
	
	
	}
	
	


