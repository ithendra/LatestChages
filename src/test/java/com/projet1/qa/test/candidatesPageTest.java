package com.projet1.qa.test;

import org.testng.annotations.Test;

import com.project1.qa.base.TestBase;
import com.project1.qa.pages.CandidatesPage;


public class candidatesPageTest extends TestBase{
	
	@Test
	public void test() throws InterruptedException {
		
		CandidatesPage candidate=new CandidatesPage(getDriver());
		candidate.addCandidate();
		
		Thread.sleep(3000);
	}
}
