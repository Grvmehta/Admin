package com.hotelogix.smoke.admin.Console;

import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddTravelAgentPage {

	public static String TaName;



	@FindBy(xpath="//input[@type='file']")
	public  WebElement btn_Browse;

	@FindBy(xpath="//input[@id='businessName']")
	public  WebElement txtbx_TravelAgentName;

	@FindBy(xpath="//input[@id='address1']")
	public  WebElement txtbx_Address1;

	@FindBy(xpath="//select[@id='countryId']")
	public  WebElement drpdwn_Country;

	@FindBy(xpath="//select[@id='stateId']")
	public  WebElement drpdwn_State;

	@FindBy(xpath="//input[@id='city']")
	public  WebElement txtbx_City;

	@FindBy(xpath="//td[@class='padingtd']//table//tr[17]/td[2]/input")
	public  WebElement txtbx_ZipCode;

	@FindBy(xpath="//input[@id='fName']")
	public  WebElement txtbx_FirstName;

	@FindBy(xpath="//input[@id='lName']")
	public  WebElement txtbx_LastName;

	@FindBy(xpath="//input[@id='designation']")
	public  WebElement txtbx_Designation;

	@FindBy(xpath="//input[@id='phoneNo']")
	public  WebElement txtbx_OfficePhone;

	@FindBy(xpath="//input[@id='email']")
	public  WebElement txtbx_EmailID;

	@FindBy(xpath="//input[@id='chkSameAsMainfficeAddress']")
	public  WebElement chkbx_SameAsMainOfficeAdd;

	@FindBy(xpath="//input[@id='chkMainBillingContact']")
	public  WebElement chkbx_SameAsContactPerson;

	@FindBy(xpath="//td[@class='comments']/input")
	public  WebElement btn_Save;

	@FindBy(xpath="//div[@id='listing-icons']/ul/li[2]/input")
	public  WebElement btn_SAVE;


	
	public static String Email;
	
public String  fn_fillTADetails() throws Exception{

	try
	{
	TaName=GenericMethods.generateRandomString();
	GenericMethods.sendKeys(txtbx_TravelAgentName, TaName);
	GenericMethods.sendKeys(txtbx_Address1, "NY City");

	GenericMethods.selectElementByIndex(drpdwn_Country, 1);
	Thread.sleep(1000);
	GenericMethods.selectElementByIndex(drpdwn_State, 3);
	Thread.sleep(1000);
	GenericMethods.sendKeys(txtbx_City, "Rio Negro City");
	GenericMethods.sendKeys(txtbx_ZipCode, "0000A1");
	GenericMethods.sendKeys(txtbx_FirstName, GenericMethods.generateRandomString());
	GenericMethods.sendKeys(txtbx_LastName, GenericMethods.generateRandomString());
	GenericMethods.sendKeys( txtbx_Designation, "Owner");
	GenericMethods.sendKeys( txtbx_OfficePhone, GenericMethods.generateRandomnum());
	GenericMethods.sendKeys( txtbx_EmailID,GenericMethods.generateRandomString()+"@stayezee.com");
	
	Email=txtbx_EmailID.getAttribute("value");
	
	Thread.sleep(2000);
	GenericMethods.js_Click(chkbx_SameAsMainOfficeAdd);
	Thread.sleep(2000);
	GenericMethods.js_Click( chkbx_SameAsContactPerson);
    Thread.sleep(2000);
	return Email;
	
	}
	catch(Exception e)
	{
		throw e;
	}
}




public ListOfRegisteredTravelAgentLP clk_saveBtn() throws Exception
{
	try
	{
	GenericMethods.js_Click(btn_SAVE);
	
	ListOfRegisteredTravelAgentLP RTA=PageFactory.initElements(GenericMethods.driver, ListOfRegisteredTravelAgentLP.class);
	return RTA;
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String GetMailId() throws Exception{
	
	try
	{
	String s1="deepakthayatharishbarkha@stayezee.com";
	String arr[]=s1.split("@");
	String rep=arr[0];
	int length=rep.length();


	Random rn=new Random();
	int randomnum=rn.nextInt(length-1)+1;
	System.out.println(randomnum);
	String result=rep.substring(0, randomnum)
	     +"."
	     +rep.substring(randomnum, length)
	     +"@"
	     +arr[1];
	System.out.println(result);
	return result;
	}
	catch(Exception e)
	{
		throw e;
	}
}











}
