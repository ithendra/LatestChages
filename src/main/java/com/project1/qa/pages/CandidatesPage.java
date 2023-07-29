package com.project1.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.project1.qa.base.TestBase;



public class CandidatesPage extends BasePage {
	
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
		
		requirementLink.click();
		
		addButton.click();
		
		firstName.sendKeys("virat");
		
		lastName.sendKeys("kohli");
		
		vacencyDropDown.click();
		
		List<WebElement> vacencyList = driver.findElements(By.xpath("//label[text()='Vacancy']/../following-sibling::div//div[@class='oxd-select-dropdown --positon-bottom']/div/span"));
		System.out.println("vacencyList : " + vacencyList.size());
		for (WebElement ele : vacencyList) {
			Thread.sleep(2000);
			String actualText=ele.getText();
			if(actualText.equals("Software Engineer")) {
				Thread.sleep(2000);
				ele.click();
				break;
			}
		}
		
		gmailText.sendKeys("virate@gmail.com");
		
		contactNumField.sendKeys("0123456789");
		
		resumeUpload.sendKeys("C:\\Users\\Official\\Downloads\\sampleResume1.pdf");
		
		keywordField.sendKeys("Automation Tester");
		
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
		dateField.sendKeys("2022-09-27");
		
		notesField.sendKeys("save the candiate details");

	}
}