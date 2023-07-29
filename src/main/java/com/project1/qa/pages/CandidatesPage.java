package com.project1.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import com.project1.qa.base.TestBase;
import com.project1.qa.util.Helpers;

public class CandidatesPage extends BasePage {
	
	Helpers helper =new Helpers();
	
	public CandidatesPage(WebDriver driver) {
		super(TestBase.getDriver());
	}

	@FindBy(xpath="//span[text()='Recruitment']")
	WebElement requirementLink;
	
	@FindBy(xpath="//button[text()=' Add ']")
	WebElement addButton;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(xpath="//label[text()='Vacancy']/../following-sibling::div//i")
	WebElement vacencyDropDown;
	
	@FindBy(xpath="//label[text()='Email']/../following-sibling::div//input")
	WebElement gmailText;
	
	@FindBy(xpath="//label[text()='Contact Number']/../following-sibling::div//input")
	WebElement contactNumField;
	
	@FindBy(xpath="//label[text()='Resume']/../following-sibling::div//input")
	WebElement resumeUpload;
	
	@FindBy(xpath="//label[text()='Keywords']/../following-sibling::div//input")
	WebElement keywordField;
	
	@FindBy(xpath="//label[text()='Date of Application']/../following-sibling::div//input")
	WebElement dateField;
	
	@FindBy(xpath="//label[text()='Notes']/../following-sibling::div//textarea")
	WebElement notesField;
	
	@FindBy(xpath="//label[text()='Consent to keep data']/../following-sibling::div//i")
	WebElement keepdataChexkBox;
	
	@FindBy(xpath="//button[text()=' Save ']")
	WebElement saveButton;
	
	public void addCandidate() throws InterruptedException {
		
		helper.waitForPageToLoad();
		helper.highLightElement(driver, requirementLink);
		requirementLink.click();
		Reporter.log("<B><font color = 'blue'>Step1 .</font></B>clicked requirementLink");
		
		helper.waitForPageToLoad();
		helper.highLightElement(driver, addButton);
		addButton.click();
		Reporter.log("<B><font color = 'blue'>Step2 .</font></B>clicked on addButton");
		
		helper.waitForPageToLoad();
		helper.highLightElement(driver, firstName);
		firstName.sendKeys(helper.getRandomString());
		Reporter.log("<B><font color = 'blue'>Step3 .</font></B>Entered First name");
		
		helper.highLightElement(driver, lastName);
		lastName.sendKeys(helper.getRandomString());
		Reporter.log("<B><font color = 'blue'>Step4 .</font></B>Entered Last name");
		
		helper.waitForPageToLoad();
		helper.highLightElement(driver, vacencyDropDown);
		vacencyDropDown.click();
		Reporter.log("<B><font color = 'blue'>Step5 .</font></B>clicked on vacencyDropDown ");
		
		List<WebElement> vacencyList = driver.findElements(By.xpath("//label[text()='Vacancy']/../following-sibling::div//div[@class='oxd-select-dropdown --positon-bottom']/div/span"));
		System.out.println("vacencyList : " + vacencyList.size());
		for (WebElement ele : vacencyList) {
			Thread.sleep(2000);
			String actualText=ele.getText();
			if(actualText.equals("Software Engineer")) {
				Thread.sleep(2000);
				helper.highLightElement(driver, ele);
				ele.click();
				Reporter.log("<B><font color = 'blue'>Step6 .</font></B>clicked vacency list type");
				break;
			}
		}
		
		helper.highLightElement(driver, gmailText);
		gmailText.sendKeys(helper.getRandomString()+"@gmail.com");
		Reporter.log("<B><font color = 'blue'>Step7 .</font></B>Entered gmail");
		
		helper.highLightElement(driver, contactNumField);
		contactNumField.sendKeys("0123456789");
		Reporter.log("<B><font color = 'blue'>Step8 .</font></B>Entered Contact Number");
		
		helper.highLightElement(driver, resumeUpload);
		resumeUpload.sendKeys("C:\\Users\\Official\\Downloads\\sampleResume1.pdf");
		Reporter.log("<B><font color = 'blue'>Step9 .</font></B>Uploaded resume");
		
		helper.highLightElement(driver, keywordField);
		keywordField.sendKeys("Automation Tester");
		Reporter.log("<B><font color = 'blue'>Step10 .</font></B>Entered Role");
		
		Actions action=new Actions(driver);
		action.click(dateField);
		Thread.sleep(3000);
		action.keyDown(Keys.CONTROL).sendKeys("a").perform();
		Thread.sleep(3000);
		action.keyDown(Keys.CLEAR).perform();
		Thread.sleep(3000);
		action.keyUp(Keys.CONTROL).perform();
	//	dateField.click();
		Thread.sleep(2000);
	//	dateField.clear();
		Thread.sleep(2000);
		helper.highLightElement(driver, dateField);
		dateField.sendKeys("2022-09-27");
		Reporter.log("<B><font color = 'blue'>Step11 .</font></B>Entered date");

		helper.highLightElement(driver, notesField);
		notesField.sendKeys("save the candiate details");
		Reporter.log("<B><font color = 'blue'>Step12 .</font></B>Entered text in Notefield");
		
		helper.highLightElement(driver, saveButton);
		saveButton.click();
		Reporter.log("<B><font color = 'blue'>Step13 .</font></B>Clicked on Save Button");
		helper.waitForPageToLoad();
		
	}
}