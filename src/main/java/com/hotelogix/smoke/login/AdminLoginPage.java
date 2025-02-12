package com.hotelogix.smoke.login;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;




public class AdminLoginPage {

	@FindBy(xpath="//input[@id='hotelCodeId']")
	public  WebElement Hotel_Code;

	@FindBy(xpath="//input[@id='userNameId']")
	public  WebElement Username;

	@FindBy(xpath="//input[@id='passwordId']")
	public  WebElement Password;

	@FindBy(xpath="//input[@name='Submit52']")
	public  WebElement Login;

	@FindBy(xpath="//input[@id='txtCaptcha']")
	public  WebElement txtbox_captcha;

	
	
	
	
	
	public BasePage adminlogin_12719() throws Exception{
		try
		{
			GenericMethods.sendKeys(Hotel_Code, "12719");
			GenericMethods.sendKeys(Username, "deepa.kthayat@hotelogix.com");
			GenericMethods.sendKeys(Password, "deepak");
			GenericMethods.clickElement(Login);
			BasePage BP = PageFactory.initElements(GenericMethods.driver, BasePage.class);
			return BP;
		}catch(Exception e){
				throw e;
		}

	}

	public  BasePage adminlogin_12725() throws Exception{

		try{
		try{
	        GenericMethods.sendKeys(Hotel_Code, "12725");

	        }catch(Exception e){
	            String str="//input[@id='hotelCodeId']";
	            WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
	            GenericMethods.sendKeys(we, "12725");
	            }

	       try{
	           GenericMethods.sendKeys(Username, "c.handravijayeciimt@gmail.com");
	       }catch(Exception e){
	           String str="//input[@id='userNameId']";
	           WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
	           GenericMethods.sendKeys(we, "c.handravijayeciimt@gmail.com");
	       }

	       try{
	           GenericMethods.sendKeys(Password, "bdc776d0");
	       }catch(Exception e){
	           String str="//input[@id='passwordId']";
	           WebElement we=GenericMethods.ExplicitWait(Password, str);
	           GenericMethods.sendKeys(we, "bdc776d0");
	       }

	       try{
	           GenericMethods.clickElement(Login);
	       }catch(Exception e){
	           String str="//input[@name='Submit52']";
	           WebElement we=GenericMethods.ExplicitWait(Login, str);
	           GenericMethods.clickElement(we);
	       }
	       }catch(Exception e){

	    	   GenericMethods.driver.navigate().refresh();
	    	   Thread.sleep(3500);
	   		try{
		        GenericMethods.sendKeys(Hotel_Code, "12725");

		        }catch(Exception e1){
		            String str="//input[@id='hotelCodeId']";
		            WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
		            GenericMethods.sendKeys(we, "12725");
		            }

		       try{
		           GenericMethods.sendKeys(Username, "c.handravijayeciimt@gmail.com");
		       }catch(Exception e1){
		           String str="//input[@id='userNameId']";
		           WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
		           GenericMethods.sendKeys(we, "c.handravijayeciimt@gmail.com");
		       }

		       try{
		           GenericMethods.sendKeys(Password, "bdc776d0");
		       }catch(Exception e1){
		           String str="//input[@id='passwordId']";
		           WebElement we=GenericMethods.ExplicitWait(Password, str);
		           GenericMethods.sendKeys(we, "bdc776d0");
		       }

		       try{
		           GenericMethods.clickElement(Login);
		       }catch(Exception e1){
		           String str="//input[@name='Submit52']";
		           WebElement we=GenericMethods.ExplicitWait(Login, str);
		           GenericMethods.clickElement(we);
		       }

	       }

	       BasePage BP = PageFactory.initElements(GenericMethods.driver, BasePage.class);
	        return BP;
	    }



	public  BasePage adminlogin(int iTestCaseRow) throws Exception{

		try{
			
		try{
	        GenericMethods.sendKeys(Hotel_Code,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));
	        GenericMethods.clickElement(Username);
	        Thread.sleep(4000);
	        }catch(Exception e){
	            String str="//input[@id='hotelCodeId']";
	            WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
	            GenericMethods.sendKeys(we, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));
	            }

	       try{
	           GenericMethods.sendKeys(Username,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));
	       }catch(Exception e){
	           String str="//input[@id='userNameId']";
	           WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
	           GenericMethods.sendKeys(we,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));
	       }

	       try{
	           GenericMethods.sendKeys(Password, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
	       }catch(Exception e){
	           String str="//input[@id='passwordId']";
	           WebElement we=GenericMethods.ExplicitWait(Password, str);
	           GenericMethods.sendKeys(we, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
	       }

	       GenericMethods.js_Sendkey(txtbox_captcha, "111111");


	       try{
	           GenericMethods.clickElement(Login);
	       }catch(Exception e){
	           String str="//input[@name='Submit52']";
	           WebElement we=GenericMethods.ExplicitWait(Login, str);
	           GenericMethods.clickElement(we);
	       }
	       }catch(Exception e){

	    	   GenericMethods.driver.navigate().refresh();
	    	   Thread.sleep(3500);
	   		try{
		        GenericMethods.sendKeys(Hotel_Code, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));

		        }catch(Exception e1){
		            String str="//input[@id='hotelCodeId']";
		            WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
		            GenericMethods.sendKeys(we, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_HotelCode)));
		            }

		       try{
		           GenericMethods.sendKeys(Username,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));
		       }catch(Exception e1){
		           String str="//input[@id='userNameId']";
		           WebElement we=GenericMethods.ExplicitWait(Hotel_Code, str);
		           GenericMethods.sendKeys(we,  ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_EmailAddressUsername)));
		       }

		       try{
		           GenericMethods.sendKeys(Password, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
		       }catch(Exception e1){
		           String str="//input[@id='passwordId']";
		           WebElement we=GenericMethods.ExplicitWait(Password, str);
		           GenericMethods.sendKeys(we, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Password)));
		       }


		       GenericMethods.js_Sendkey(txtbox_captcha, "111111");

		       try{
		           GenericMethods.clickElement(Login);
		       }catch(Exception e1){
		           String str="//input[@name='Submit52']";
		           WebElement we=GenericMethods.ExplicitWait(Login, str);
		           GenericMethods.clickElement(we);
		       }

	       }

	       BasePage BP = PageFactory.initElements(GenericMethods.driver, BasePage.class);
	        return BP;
	    }




}

