package com.projet1.qa.test;

import org.testng.annotations.Test;

import com.project1.qa.base.TestBase;
import com.project1.qa.pages.LeavePage;

public class LeavepageTest extends TestBase{

	@Test
	public void leaveLink() throws InterruptedException {
	
	LeavePage leave=new LeavePage(getDriver());
	leave.leaveClickMethod();
	
	}

}
