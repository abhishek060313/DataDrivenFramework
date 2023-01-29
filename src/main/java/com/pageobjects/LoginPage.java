package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-email")
	private WebElement emailAddressField;

	public void enterEmailAddress(String email) {
		emailAddressField.sendKeys(email);
	}

	@FindBy(id = "input-password")
	private WebElement passwordField;

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	public AccountPage clickOnLoginButton() {
		loginButton.click();
		return new AccountPage(driver);
	}
}
