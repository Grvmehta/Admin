package com.hotelogix.smoke.admin.Console;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditCorporate {
	@FindBy(xpath="//input[@name='businessName']")
	public  WebElement txtbx_cName;

	@FindBy(xpath="//input[@name='address1']")
	public  WebElement txtbx_Addres;

	@FindBy(xpath="//select[@name='countryId']")
	public  WebElement drpdwn_country;

	@FindBy(xpath="//select[@name='stateId']")
	public  WebElement drpdwn_state;

	@FindBy(xpath="//input[@name='city']")
	public  WebElement txtbx_city;

	@FindBy(xpath="//input[@name='zipCode']")
	public  WebElement txtbx_zipCode;

	@FindBy(xpath="//select[@name='salution']")
	public  WebElement drpdwn_salutation;

	@FindBy(xpath="//input[@name='fName']")
	public  WebElement txtbx_fName;

	@FindBy(xpath="//input[@name='lName']")
	public  WebElement txtbx_lName;

	@FindBy(xpath="//input[@name='designation']")
	public  WebElement txtbx_designation;

	@FindBy(xpath="//input[@name='phoneNo']")
	public  WebElement txtbx_ofcNo;

	@FindBy(xpath="//input[@name='email']")
	public  WebElement txtbx_eMail;

	@FindBy(xpath="//input[@id='chkSameAsMainfficeAddress']")
	public  WebElement chkbx_SameAsMainOfficeAddress;

	@FindBy(xpath="//input[@id='chkSameAsContact']")
	public  WebElement chkbx_SameAsMainContacPerson;

	@FindBy(xpath="//tbody//tr[7]//td[2]/input")
	public  WebElement btn_save;
	
	public static String corporateName;




	public  ListOfRegisteredCorporateLP fn_fillForm() throws Exception
	{
		try
		{
		corporateName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(txtbx_cName, corporateName);
		GenericMethods.sendKeys(txtbx_Addres,GenericMethods.generateRandomString());
		GenericMethods.selectElementByIndex(drpdwn_country, 1);
		Thread.sleep(8000);
		GenericMethods.selectElementByIndex(drpdwn_state, 4);
		GenericMethods.sendKeys(txtbx_city,GenericMethods.generateRandomString());
		GenericMethods.sendKeys(txtbx_zipCode, GenericMethods.generateRandomString());
		GenericMethods.selectElementByIndex(drpdwn_salutation, 3);
		GenericMethods.sendKeys(txtbx_fName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(txtbx_lName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(txtbx_designation, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(txtbx_ofcNo,GenericMethods.generateRandomString());
		GenericMethods.sendKeys(txtbx_eMail, GenericMethods.generateRandomString()+"@gmail.com");
		GenericMethods.clickElement(chkbx_SameAsMainOfficeAddress);
		GenericMethods.clickElement(chkbx_SameAsMainContacPerson);
		Thread.sleep(2000);
		GenericMethods.js_Click(btn_save);
		ListOfRegisteredCorporateLP pageobj = PageFactory.initElements(GenericMethods.driver, ListOfRegisteredCorporateLP.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  ListOfRegisteredCorporateLP registerACorporate() throws Exception
	{
		try
		{
		new AddEditCorporate().fn_fillForm();
		Thread.sleep(1000);
		GenericMethods.clickElement(btn_save);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfRegisteredCorporateLP pageobj = PageFactory.initElements(GenericMethods.driver, ListOfRegisteredCorporateLP.class);
		return pageobj;
	}

}
