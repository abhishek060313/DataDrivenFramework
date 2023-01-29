package com.tests;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.Base;
import com.pageobjects.AccountPage;
import com.pageobjects.HomePage;
import com.pageobjects.LoginPage;
import com.util.DataUtil;
import com.util.MyXLSReader;

public class LoginTest extends Base {

	WebDriver driver;
	MyXLSReader excelReader;

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	@Test(dataProvider = "dataSupplier")
	public void testLogin(HashMap<String, String> hashMap) {

		if (!DataUtil.isRunnable(excelReader, "LoginTest", "Testcases") || hashMap.get("Runmode").equals("N")) {

			throw new SkipException("Runmode is set to N, hence not executed");
		}

		driver = openBrowserAndApplicationURL(hashMap.get("Browser"));

		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage loginPage = homepage.selectLoginOption();
		loginPage.enterEmailAddress(hashMap.get("Username"));
		loginPage.enterPassword(hashMap.get("Password"));
		AccountPage accountPage = loginPage.clickOnLoginButton();

		String expectedResult = hashMap.get("ExpectedResult");
		boolean expectedConvertedResult = false;

		if (expectedResult.equalsIgnoreCase("Success")) {
			expectedConvertedResult = true;
		} else if (expectedResult.equalsIgnoreCase("Failure")) {
			expectedConvertedResult = false;
		}

		boolean actualResult = false;

		actualResult = accountPage.verifyTheDisplayOfEditYourAccountInformationOption();

		Assert.assertEquals(actualResult, expectedConvertedResult);

	}

	@DataProvider
	public Object[][] dataSupplier() {
		Object[][] data = null;

		try {
			excelReader = new MyXLSReader("src\\test\\resources\\tutorialsNinjaData.xlsx");
			data = DataUtil.getTestData(excelReader, "LoginTest", "Data");
		} catch (Throwable e) {
			e.printStackTrace();

		}
		return data;
	}

}
