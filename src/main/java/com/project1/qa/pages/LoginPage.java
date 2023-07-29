package com.project1.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.project1.qa.base.TestBase;
import com.project1.qa.util.Helpers;

public class LoginPage extends BasePage{

	Helpers helper=new Helpers();
	
	public LoginPage(WebDriver driver) {
		super(TestBase.getDriver());
	}

	@FindBy(xpath="//input[@name='username']")
	WebElement usernameTextfield;
	
	@FindBy(name="password")
	WebElement passwordTextfield;
	
	@FindBy(xpath="//button[text()=' Login ']")
	WebElement loginButton;
	
	@FindBy(xpath="//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[3]/a")
	WebElement leaveModule;
	
	public void setLoginMethod(String uname , String pwd) throws InterruptedException {
		
		Thread.sleep(2000);
		
		helper.highLightElement(driver, usernameTextfield);
		helper.waitFor(usernameTextfield);
		usernameTextfield.sendKeys(uname);
		Reporter.log("<B><font color = 'blue'>Step1 .</font></B>entered username");
		
		helper.highLightElement(driver, passwordTextfield);
		helper.waitFor(passwordTextfield);
		passwordTextfield.sendKeys(pwd);
		Reporter.log("<B><font color = 'blue'>Step2 .</font></B>entered password");
		
		helper.highLightElement(driver, loginButton);
		helper.waitFor(loginButton);
		loginButton.click();
		Reporter.log("<B><font color = 'blue'>Step3 .</font></B>clicked on loginButton");
		

		Thread.sleep(2000);
	}

	
}
