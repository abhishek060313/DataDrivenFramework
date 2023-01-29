package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;

	public AccountPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Edit your account information")
	private WebElement editYourAccountInformationOption;

	public boolean verifyTheDisplayOfEditYourAccountInformationOption() {

		boolean displayStatus = false;
		try {
			displayStatus = editYourAccountInformationOption.isDisplayed();
		} catch (Exception e) {
			return false;
		}

		return displayStatus;
	}

}
