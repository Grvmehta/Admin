package com.hotelogix.smoke.frontdesk.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;



public class AccountsLandingPage {

	@FindBy(xpath="//a[text()='Hotel']")
	public static WebElement Hotel_Tab;


	public void fn_ClickHotel() throws Exception
	{

   	 try
   	 {
   	    GenericMethods.clickElement(Hotel_Tab);
   	 }

   	 catch(Exception e)
   	 {
   		 throw e;
   	 }

	}

	public void fn_ValidateAccountsPage() throws Exception
	{

   	 try
   	 {
   	     String title= GenericMethods.driver.getTitle();
   	     Assert.assertEquals(title, "Accounts");
   	 }
   	 catch(Exception e)
   	 {
   		 throw e;
   	 }
     }

}
