package com.hotelogix.smoke.frontdesk.Payment;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;



public class ReservationFolioPage
{

	@FindBy(xpath="//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr//td[2]//input")
	public static List<WebElement> chkboxCount;


	@FindBy(xpath="//div[@class='bat_account_statement']")
	public static WebElement backToAccStmt;


	public AccountStatementLandingPage fn_verifyPaidAmt() throws Exception
	{
		try
		{
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i+=2)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	//li.add(str1);
	    	if(str1.contains("Paid by "+AccountStatementLandingPage.str1Value+" with Cash"))
	    	{
	    		String str=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[8]")).getText();
	    		if(str.contains(AccountStatementLandingPage.amt1))
	    		{
	    		//Assert.assertTrue(str.contains(amt));
//	    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//	    		ele1.click();
	            System.out.println("Paid amount has been successfully routed to selected guest ID folio.");
	            break;
	    		}

	    	}
	    }
	    GenericMethods.clickElement(backToAccStmt);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public AccountStatementLandingPage fn_verifyRoutedCustomChrgTxt() throws Exception
	{
		try
		{
			Thread.sleep(7000);
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i++)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]//a[1]")).getText();
	    	arr.add(str1);
	    	if(str1.contains(AccountStatementLandingPage.CustomCharge))
	    	{
	    		Assert.assertEquals(str1.contains(AccountStatementLandingPage.CustomCharge), true);
	    		System.out.println("Posted custom charge has been successfully routed to the selected guest ID.");
	            break;
	    	}
	    }
	    Assert.assertEquals(arr.contains(AccountStatementLandingPage.CustomCharge), true);
	    GenericMethods.clickElement(backToAccStmt);
	    Thread.sleep(14000);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public AccountStatementLandingPage fn_verifyRoutedPaymentTxt() throws Exception
	{
		try
		{
			String[] a=AccountStatementLandingPage.routedGuestN.split(" ");
			String guestName=a[1]+" "+a[2];
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i++)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	arr.add(str1);
	    	if(str1.contains("Paid by "+guestName+" with Cash"))
	    	{
	    		Assert.assertEquals(str1.contains("Paid by "+guestName+" with Cash"), true);
	    		System.out.println("Paid amount has been successfully routed to the selected guest ID.");
	            break;


	    	}
	    }
	    Assert.assertEquals(arr.contains("Paid by "+guestName+" with Cash"), true);
	    GenericMethods.clickElement(backToAccStmt);
	    Thread.sleep(6000);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public AccountStatementLandingPage fn_verifyRoutedOtherChrgTxt() throws Exception
	{
		try
		{
		int count=GenericMethods.tr_count(chkboxCount);
	    for(int i=2;i<=count;i++)
	    {
	    	String str1=GenericMethods.driver.findElement(By.xpath("//td[@class='front_tbl_lft']//table[@class='bat_frn_paytbl']//tr["+i+"]//td[4]")).getText();
	    	//li.add(str1);
	    	if(str1.contains(AccountStatementLandingPage.product) && str1.contains(AccountStatementLandingPage.folioNum))
	    	{
	    		System.out.println("Posted other charge has been successfully routed to the selected guest ID.");
	            break;


	    	}
	    }
	    GenericMethods.clickElement(backToAccStmt);
	    AccountStatementLandingPage ASP=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
		return ASP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}




}
