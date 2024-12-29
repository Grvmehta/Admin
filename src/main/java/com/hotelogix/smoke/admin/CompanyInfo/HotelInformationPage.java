package com.hotelogix.smoke.admin.CompanyInfo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;




import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class HotelInformationPage {

	@FindBy(xpath="//td[text()='Hotel Information']")
	public  WebElement HotelInformation;

	@FindBy(xpath="//input[@name='address1']")
	public  WebElement txtbx_Address1;

	@FindBy(xpath="//input[@name='city']")
	public  WebElement txtbx_HotelInfCity;

	@FindBy(xpath="//input[@name='zipCode']")
	public  WebElement txtbx_ZipCode;

	@FindBy(xpath="//input[@name='billingSameAddress']")
	public  WebElement chkbx_SameAsHotelAddress;

	@FindBy(xpath="//select[@name='bSal']")
	public  WebElement drpdwn_Salutation;

	@FindBy(xpath="//input[@name='Submit4']") 
	public  WebElement btn_SaveHotelInfo;

	@FindBy(xpath="//table[@class='table-content']//tr[2]//td[2]")
	public  WebElement txt_msg;
	
	@FindBy(xpath="//input[@name='logo']")
	public WebElement btn_hotelLogo;

	public void fn_EnterHotelInformation(String FilePath) throws Exception
	{

		//GenericMethods.clickElement(btn_hotelLogo);
		Thread.sleep(4000);
		//GenericMethods.autoit(FilePath, "File Upload");
		//GenericMethods.uploadImage(System.getProperty("user.dir")+FilePath);
		//Runtime.getRuntime().exec("C:\\Users\\barkha\\Desktop\\SmokeTC\\Smoak\\Smoak\\Smoak\\FileUpload1.exe");	
		//Runtime.getRuntime().exec("E:\\Admin-March 2020\\Smoak\\Smoak\\FileUpload1.exe");		
		Thread.sleep(6000);
		txtbx_Address1.clear();
		try{
		GenericMethods.sendKeys(txtbx_Address1, "123/43");
		}catch(Exception e){

			String abc = "//input[@name='address1']";
	 	   WebElement ele1=GenericMethods.ExplicitWait(txtbx_Address1, abc);
	 	   ele1.sendKeys("123/43");

		}
		txtbx_HotelInfCity.clear();
		try{
		GenericMethods.sendKeys(txtbx_HotelInfCity, "Noida");
		}catch(Exception e){

			String abc = "//input[@name='city']";
	 	   WebElement ele1=GenericMethods.ExplicitWait(txtbx_HotelInfCity, abc);
	 	   ele1.sendKeys("Noida");

		}
		
		try
		{
			txtbx_ZipCode.clear();
		GenericMethods.sendKeys(txtbx_ZipCode, "208001");
		}catch(Exception e){
			/*
			 * String abc2 = "//input[@name='zipCode']"; WebElement
			 * ele1=GenericMethods.ExplicitWait(txtbx_ZipCode, abc2);
			 * ele1.sendKeys("208001");
			 */
			e.printStackTrace();
		}
		try{
		GenericMethods.clickElement(chkbx_SameAsHotelAddress);
		}catch(Exception e){
			String abc3 = "//input[@name='billingSameAddress']";
		 	   WebElement ele1=GenericMethods.ExplicitWait(txtbx_ZipCode, abc3);
		 	  ele1.click();
		}
		try
		{
		GenericMethods.selectElement(drpdwn_Salutation, "Mr.");
		
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		try{
			Thread.sleep(2000);

		GenericMethods.clickElement(btn_SaveHotelInfo);
		}catch(Exception e){
			String abc4 = "//input[@value='Save Hotel Info']";
		 	   WebElement ele1=GenericMethods.ExplicitWait(btn_SaveHotelInfo, abc4);
		 	  Thread.sleep(2000);
		 	   ele1.click();
		}
	}

public String fn_verifyHotelSave() throws Exception
{
	try
	{
		Thread.sleep(2000);
	    String abc=txt_msg.getText();
        return abc;	
	}	
	catch(Exception e)
	{
		throw e;

	}




}




}
