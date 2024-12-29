package com.hotelogix.smoke.frontdesk.ViewDetailsPage;

import java.util.ArrayList;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ViewDetailsPage {




@FindBy(xpath="//input[@value='Enable Editing']")
public static WebElement EnableEditingBtn;

@FindBy(xpath="//input[@id='btnmainSRPay']")
public static WebElement PaymentBtn;

@FindBy(xpath="//form[@id='frmSingleResView']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]")
public static WebElement Amt;


@FindBy(xpath="//form[@id='frmSingleResView']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]")
public static WebElement Tax;

@FindBy(xpath="//form[@id='frmSingleResView']/table/tbody/tr/td/table[2]/tbody/tr/td[2]/table[1]/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/table/tbody/tr[6]/td[2]")
public static WebElement AmtWithTax;

@FindBy(xpath="//span[text()='Add/Edit Details']")
public static WebElement AddEditDetails_link;

@FindBy(xpath="//input[@id='srTxtLastName']")
public static WebElement LastName_ED;

@FindBy(xpath="//input[@id='phoneNo']")
public static WebElement Phone_ED;

@FindBy(xpath="//input[@id='btnSave']")
public static WebElement Save_BT;

@FindBy(xpath="//table[@id='roomGrTableId']//tr[2]//td[8]")
public static WebElement Status_Text;

@FindBy(xpath="//input[@id='btnmainSRClose']")
public static WebElement Close_BT;

@FindBy(xpath="//span[@class='closebtn']")
public static WebElement btn_closeReserv;

@FindBy(xpath="//input[@value='Enable Editing']")
public WebElement Btn_EnableEditing;

public static ArrayList<String> als=new ArrayList<String>();

public EnableEditingPage ClickToEnableEditingBtn() throws Exception
{
	try
	{
GenericMethods.clickElement(EnableEditingBtn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(1000);
		GenericMethods.js_Click(EnableEditingBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
EnableEditingPage EEP = PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
return EEP;
}

public AccountStatementLandingPage ClickToPayment() throws Exception
{
	try
	{
GenericMethods.clickElement(PaymentBtn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(PaymentBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
AccountStatementLandingPage ASL=PageFactory.initElements(GenericMethods.driver, AccountStatementLandingPage.class);
return ASL;
}



public ArrayList<String> GetAmtDetails() throws InterruptedException
{
String amt=GenericMethods.getText(Amt);
String tax=GenericMethods.getText(Tax);
String amtWithTax=GenericMethods.getText(AmtWithTax);
als.add(amt);
als.add(tax);
als.add(amtWithTax);
return als;
}


public void fn_ClickAddEditDetails_link() throws Exception
{

	 try
	 {
         GenericMethods.clickElement(AddEditDetails_link);
	 }
	 catch(NoSuchElementException e)
	 {
		 Thread.sleep(3000);
		 GenericMethods.js_Click(AddEditDetails_link);
	 }
	 catch(Exception e)
	 {
		 throw e;
	 }

}

public void fn_ChangeDetails() throws Exception
{

	 try
	 {
		String str=GenericMethods.generateRandomString();
		LastName_ED.clear();
        GenericMethods.sendKeys(LastName_ED, str);
        String num=GenericMethods.generateRandomnum();
        Phone_ED.clear();
        GenericMethods.sendKeys(Phone_ED, num);
        GenericMethods.clickElement(Save_BT);
        GenericMethods.clickElement(btn_closeReserv);
	 }
	 catch(Exception e)
	 {
		 throw e;
	 }

}

public void fn_ValidateCheckINstatus() throws Exception
{

  	 try
  	 {
  	    String str=GenericMethods.getText(Status_Text);
  	    Assert.assertTrue(str.contains("Checked In"));
        //GenericMethods.clickElement(Close_BT);
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


public EnableEditingPage ClickOnEnableEditing() throws Exception{
	try{
		Thread.sleep(2000);
	GenericMethods.clickElement(Btn_EnableEditing);
	}
	catch(Exception e){
	
	throw e;
	}
	EnableEditingPage EEP=PageFactory.initElements(GenericMethods.driver, EnableEditingPage.class);
	return EEP;
		
	}



}
