package com.hotelogix.smoke.admin.General;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditPayType
{
   @FindBy(xpath="//input[@id='titBoxId']")
   public  WebElement txtbx_payTypesTitle;

   @FindBy(xpath="//input[@id='payShortName']")
   public  WebElement txtbx_PTShortName;

   @FindBy(xpath="//select[@name='paymentMode']")
   public  WebElement drpdwn_payMode;

   @FindBy(xpath="//a[@id='addNewAccountCode']")
	public  WebElement link_addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public  WebElement txtbx_accTitle;

	@FindBy(xpath="//input[@id='accountCode']")
	public  WebElement txtbx_accCode;

	@FindBy(xpath="//html/body/div[7]/div[11]/div/button[1]/span")
	public  WebElement btn_accSave;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public  WebElement btn_accCancel;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public  WebElement drpdwn_accountCode;

	@FindBy(xpath="//input[@value='Save']")
	public  WebElement btn_save;



	public static String PTTitle;
	public static String shortName;
	public static String PayTypeAcntTitle;
    public static String PayTypeAcntCode;


    public  void accountCode() throws Exception
    {try{
	   GenericMethods.clickElement(link_addnewaccnt);
	   PayTypeAcntTitle=GenericMethods.generateRandomString();
 	   GenericMethods.sendKeys(txtbx_accTitle, PayTypeAcntTitle);
 	   Thread.sleep(2000);
 	   PayTypeAcntCode=GenericMethods.generateRandomString();
 	   GenericMethods.sendKeys(txtbx_accCode, PayTypeAcntCode);
 	   Thread.sleep(2000);
 	   GenericMethods.clickElement(btn_accSave);
 	   GenericMethods.ActionOnAlert("Accept");
    }catch(Exception e){
    	throw e;
    }
    }



	public PayTypesPage fn_addPayTypeDetail() throws Exception
	{
		try
		{
		PTTitle=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(txtbx_payTypesTitle, PTTitle);
		shortName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(txtbx_PTShortName, shortName);
		//GenericMethods.selectElement(accountcode, "Training");
		accountCode();
		Thread.sleep(2000);
		//GenericMethods.selectElement(payMode, "Cash");
		GenericMethods.selectElementByIndex(drpdwn_payMode, 1);
		GenericMethods.clickElement(btn_save);
		PayTypesPage PTP = PageFactory.initElements(GenericMethods.driver, PayTypesPage.class);
		return PTP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}



}
