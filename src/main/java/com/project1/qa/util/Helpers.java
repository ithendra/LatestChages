package com.project1.qa.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.project1.qa.base.TestBase;



/**
 * 
 * @author Jithendra
 *
 */

public class Helpers extends TestBase {
	
	
	private static final long TimeOut = 0;
	/**
	 * Takes a ScreenShot
	 * @param result
	 */
//	public static WebDriver driver;
	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
		
	/**
	 * This Method switches to a Alert if present any 
	 * @return
	 */
		public void isAlertPresent() {
			try {
			getDriver().switchTo().alert();
			}catch(NoAlertPresentException ex) {
			}
		}
	
		public void AlertAccept() {
			try {
			getDriver().switchTo().alert().accept();
			}catch(NoAlertPresentException ex) {
			}
		}
	
		public void waitFor(WebElement ele) {
			//waitForPageToLoad();
			//log("Waiting 60 seconds for element :" + ele + " to be visible");
			try {
			//	new WebDriverWait((WebDriver) driver,60).until(ExpectedConditions.visibilityOf(ele));
			//	new WebDriverWait((WebDriver) driver,Duration.ofSeconds(60)).until(ExpectedConditions.visibilityOf(ele));
				new WebDriverWait((WebDriver) driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(ele));
					}catch(Exception e) {
					}
		}
	
		public void waitForElementToBeClickable(WebElement ele) {
			//waitForPageToLoad();
			//log("Waiting 60 seconds for element :" + ele + " to be visible");
			try {
			//	new WebDriverWait((WebDriver) driver,60).until(ExpectedConditions.elementToBeClickable(ele));
			//	new WebDriverWait((WebDriver)driver,Duration.ofSeconds(60)).until(ExpectedConditions.elementToBeClickable(ele));
				new WebDriverWait((WebDriver)driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(ele));
					}catch(Exception e) {
						
					}
		
		}
	
		public void waitFor(WebElement ele , int time) {
			waitForPageToLoad();
			try {
		//		new WebDriverWait((WebDriver) driver,time).until(ExpectedConditions.visibilityOf(ele));
				new WebDriverWait((WebDriver) driver,Duration.ofSeconds(time)).until(ExpectedConditions.visibilityOf(ele));
			}catch(Exception e) {
			}
		}
	
		public void waitForPageToLoad() {
			waitForpage();
			try {
				waitFor(ExpectedConditions.invisibilityOfAllElements(getDriver().findElements(By.cssSelector(".preloader"))));
			}catch(Exception e) {
		}
			waitForpage();
		}
		
		public void waitFor(ExpectedCondition<Boolean>invisibilityOfAllElements)throws InterruptedException{
			
		//	Thread.sleep(2000);
			Thread.sleep(1500);
		}
		
		public void waitForpage() {
			try {
				
			//	Thread.sleep(5000);
				Thread.sleep(2000);
			}catch(Exception e) {
				
			}
		}
		
		 public  void jsCLick(WebElement ele) throws InterruptedException
		   {
			   JavascriptExecutor executor = (JavascriptExecutor)getDriver();
			   executor.executeScript("arguments[0].click();", ele);
		   }		 
		 public static void jsScrollintoview(WebElement Element) throws InterruptedException
		   {
		 JavascriptExecutor js = (JavascriptExecutor) getDriver();	       
	     js.executeScript("arguments[0].scrollIntoView();", Element);
		   }
		 public void jsXYCoordinates() throws InterruptedException {
			 JavascriptExecutor js = (JavascriptExecutor) getDriver();
			 js.executeScript("window.scrollTo(0,937.6)");
		 }

		public  void highLightElement(WebDriver driver, WebElement element)
		{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		
		js.executeScript("arguments[0].setAttribute('style', 'background: Cinnamon; border: 2px solid red;');", element);
		
		try 
		{
		//Thread.sleep(500);
		Thread.sleep(450);
		} 
		catch (InterruptedException e) {
		
		System.out.println(e.getMessage());
		} 
		
		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 
		
		}
		
		public static boolean explicitlyWait(WebElement element) {
		
			try {  
		
				// new WebDriverWait(getDriver(),TimeOut).until(ExpectedConditions.visibilityOf(element));
				new WebDriverWait(getDriver(),Duration.ofSeconds(TimeOut)).until(ExpectedConditions.visibilityOf(element));
				return true;
			}
			catch (NoSuchElementException e)
		
			{
				return false;
			}
		}
		
		/**
		 * This Method can be used to send input as text to input fields on the HRM UI
		 * @param element
		 * @param arg
		 * @return
		 */
		public boolean enterText (WebElement element ,String arg) {
		
			try {  
				
				element.sendKeys(arg);
				return true;
			}
			catch (NoSuchElementException e)
		
			{
				return false;
			}
		} 
		
		public String getRandomString() {
		    String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		    StringBuilder salt = new StringBuilder();
		    Random rnd = new Random();
		    while (salt.length() < 10) { // length of the random string.
		        int index = (int) (rnd.nextFloat() * SALTCHARS.length());
		        salt.append(SALTCHARS.charAt(index));
		    }
		    String saltStr = salt.toString();
		    return saltStr;
	
		}
		
		public boolean containsAKeyword(String myString, String[] linkText){
			   for(String keyword : linkText){
			      if(myString.contains(keyword)){
			         return true;
			      }
			   }
			   return false; // Never found match.
		
			}
			
		public void Scrollintoview(WebElement  element) throws InterruptedException	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver(); 
		 //This will scroll the page till the element is found		
		 js.executeScript("arguments[0].scrollIntoView();", element);
		 
		 
		}
		
		public boolean selectDropDownValue (WebElement element, String type, String value) {
		
			try {
		
				Select select=new Select(element);
		
				switch (type) 
				{
				case "index":
					select.selectByIndex(Integer.parseInt(value));
					break;
				case "value":
					select.selectByValue(value);
					break;
				case "visibletext":
					select.selectByVisibleText(value);
					break;
		
				default:
					System.out.println("please pass the correct selection criteria...");
					break;	
				}
				return true;
			}
			catch (NoSuchElementException e)
			{	
				return false;
			}
		}
		
		
		public void SwitchtoFrame(WebElement elememt)   {
			try {
				getDriver().switchTo().frame(elememt);
			} catch (NoSuchFrameException e)
		    {
			    System.out.println(e.getMessage());
			    }
		}
		public void SwitchOutOf_iFrame()   {
			try {
				getDriver().switchTo().defaultContent();
			} catch (NoSuchFrameException e)
		    {
			    System.out.println(e.getMessage());
			    }
		}
		
		public void selectFilterValue(List<WebElement> list,String value) {
			try {
				for (WebElement element : list) 
				{ 
					if (element.getAttribute("innerText").contains(value)) {
						element.click();
					}
				}
			}
			catch (NoSuchElementException e)
			{
			}
		}
		
		public boolean uploadFile(String fileLocation) throws  InterruptedException, AWTException {
			try {
				Thread.sleep(10000);		
				StringSelection stringSelection = new StringSelection(fileLocation);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
				Robot robot = new Robot();	
				Thread.sleep(10000);
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_V);
				Thread.sleep(10000);
				robot.keyRelease(KeyEvent.VK_V);
				robot.keyRelease(KeyEvent.VK_CONTROL);
				Thread.sleep(10000);
				robot.keyPress(KeyEvent.VK_ENTER);
				Thread.sleep(10000);
				robot.keyRelease(KeyEvent.VK_ENTER);
		
				return true;
			} 
			catch (NoSuchElementException e) 
			{
				return false;
			}
		}

		public void click(WebElement ele) {
//			highLightElement( driver, ele);
			ele.click();
			waitForPageToLoad();
		}
		
		public void RightClick(WebElement element) throws InterruptedException {
			Actions act = new Actions(getDriver());
			act.contextClick(element).build().perform();
			Thread.sleep(2000);
		}

		public void CntrlAll() throws InterruptedException, AWTException {
			Robot robot1 = new Robot();

			robot1.keyPress(KeyEvent.VK_CONTROL);
			robot1.keyPress(KeyEvent.VK_A);
			Thread.sleep(2000);
			robot1.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot1.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
			robot1.keyRelease(KeyEvent.VK_A);
			Thread.sleep(2000);
			robot1.keyRelease(KeyEvent.VK_CONTROL);
			Thread.sleep(2000);
		}
		
		public void SelectSecondValuefromRightClick() throws InterruptedException, AWTException {
			Robot robot = new Robot();
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(2000);
			robot.keyPress(KeyEvent.VK_DOWN);
			Thread.sleep(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
//			robot.keyPress(KeyEvent.VK_ENTER);
//			Thread.sleep(10000);
		}
	
		
		public void SelectDropdownValue(WebElement element, String string) {
			
			Select status = new Select(element) ;
			status.selectByVisibleText(string);
		}
		public void waitFor(String textToBeDisplayedOnPage) throws InterruptedException {
			// TODO Auto-generated method stub
			try {
		//		new WebDriverWait((WebDriver) driver,60).until(ExpectedConditions.textToBePresentInElement(driver.get().findElement(By.xpath("//body")), textToBeDisplayedOnPage));
			//	new WebDriverWait((WebDriver) driver,Duration.ofSeconds(60)).until(ExpectedConditions.textToBePresentInElement(driver.get().findElement(By.xpath("//body")), textToBeDisplayedOnPage));
				new WebDriverWait((WebDriver) driver,Duration.ofSeconds(10)).until(ExpectedConditions.textToBePresentInElement(driver.get().findElement(By.xpath("//body")), textToBeDisplayedOnPage));
			}catch(Exception e) {
							System.out.println("TEXT WAS NOT FOUND IN THE CURRENT PAGE" );
						}
			
		}
}