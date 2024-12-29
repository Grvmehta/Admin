/*package com.hotelogix.smoke.AdminTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;


import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;
import testlink.api.java.client.TestLinkAPIResults;

public class TestDev {

	public static String DEV_KEY = "9119686a2aa490fef9e3668a27225b4d"; //Your API 
	
	public static String SERVER_URL = "http://livestable.stayez.com/testlink/lib/api/xmlrpc.php"; //your testlink server url
	public static String PROJECT_NAME = "Test Project"; 
	public static String PLAN_NAME = "Test Plan 1";
	public static String BUILD_NAME = "Sample Smoke";
	
	
	@Test
	public void fn_Test() throws Exception{
		try{
		String exception = null;
		System.out.println("Harish");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://hotelogix.net/frontdesk/login/");
		driver.findElement(By.xpath("//input[@id='hotelCodeId']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='userNameId']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='passwordId']")).sendKeys("");
		driver.findElement(By.xpath("//input[@id='txtCaptcha']")).sendKeys("111111");
		driver.findElement(By.xpath("//input[@name='Submit52']")).click();
		
		
		
		String result=TestLinkAPIResults.TEST_PASSED;
		updateTestLinkResult("ATP-12",exception,result);
		System.out.println("Harish");
		}catch(Exception e){
			throw e;
		}
	}
	
	
	private void updateTestLinkResult(String testCase, String exception, String result) throws TestLinkAPIException{
		
		TestLinkAPIClient testlinkAPIClient = new TestLinkAPIClient(DEV_KEY, SERVER_URL);
		testlinkAPIClient.reportTestCaseResult(PROJECT_NAME, PLAN_NAME, testCase, BUILD_NAME, exception, result);
		
		}

	
	
}
*/