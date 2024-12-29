package com.hotelogix.smoke.admin.roommanager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SaveRoomTaxesPage
{
	@FindBy(id="taxNameMulName_0")
	public  WebElement taxTitle;

	@FindBy(id="taxShortName")
	public  WebElement taxShortName;

	@FindBy(id="descriptionMulDes_0")
	public  WebElement description;

	@FindBy(id="woSlabTaxAmount")
	public  WebElement taxPercent;

	@FindBy(xpath="//select[@id='slabTaxAppliedOnPV']")
	public  WebElement taxType;
	
	@FindBy(xpath="//select[@id='slabTaxAppliedOnFV']")
	public  WebElement fixtaxType;
	
	

	@FindBy(xpath="//select[@id='slabTaxAppliedOnPV']//option[2]")
	public  WebElement selectTaxType;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public  WebElement select_acntcode;

	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public  WebElement addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public  WebElement acc_title;

	@FindBy(xpath="//input[@name='accountCode']")
	public  WebElement acc_code;

	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	public  WebElement acc_savebtn;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public  WebElement acc_cancelbtn;

	@FindBy(xpath="//*[@id='addSlabLink']//a")
	public  WebElement slab_Link;
	
	@FindBy(xpath="//input[@id='slbMinAmount_1']")
	public  WebElement slab_Range1;
	
	@FindBy(xpath="//input[@id='slbMinAmount_2']")
	public  WebElement slab_Range2;
	
	@FindBy(xpath="//input[@id='slbMinAmount_3']")
	public  WebElement slab_Range3;
	
	@FindBy(xpath="//input[@id='slbTaxAmount_1']")
	public  WebElement slab_Per1;
	
	@FindBy(xpath="//input[@id='slbTaxAmount_2']")
	public  WebElement slab_Per2;
	
	@FindBy(xpath="//input[@id='slbTaxAmount_3']")
	public  WebElement slab_Per3;
	
	@FindBy(xpath="//input[@id='slbTaxAmount_4']")
	public  WebElement slab_Per4;
	
	@FindBy(xpath="//img[@id='showCalFrom']")
	public  WebElement cal_img;
	
	@FindBy(xpath="//div[@class='calheader']//a[2]")
	public  WebElement cal_MonthLink;
	
	@FindBy(xpath="//*[@id='calFromContainer_nav_month']")
	public  WebElement cal_MonthDrop;
	
	@FindBy(id="calFromContainer_nav_year")
	public  WebElement cal_Year;
	
	@FindBy(id="calFromContainer_nav_submit")
	public  WebElement cal_Ok;
	
	
	
	@FindBy(xpath="//td[contains(@class,'selectable')]/a[1]")
	public  WebElement cal_selectCurrDate;
	
	
	
	@FindBy(xpath="//table[@id='webresCalPopup_t']//tbody//tr//td//a")
	public  List<WebElement> DateCollection;

	@FindBy(name="Submit5")
	public  WebElement saveBtn;
	
	
	@FindBy(id="isTaxble")
	public  WebElement isTaxable;
	
	@FindBy(xpath="//table[@id='taxOnTaxTbl']/tbody/tr[1]/td[1]")
	public  List<WebElement> tax_count;
	
	
	
	@FindBy(xpath="//input[@value='FV']")
	public  WebElement rb_fixedValue;
	
	
	public static String taxName="Tax"+GenericMethods.randomNumber();
	public static String ShortName="Short Name1"+GenericMethods.randomNumber();
    public static String RoomTaxAcntTitle;
    public static String RoomTaxAcntCode;

    public static String slabTaxName1="CGST";
    public static String slabTaxName2="SGST";
    public static String taxOnTaxName1="CESS";
    
    
    public static String fixTaxName1="PerReservation"; 
    public static String fixTaxName2="PerNight";
    public static String fixTaxName3="RackRate";
    
    public static  String month="";
    public static String year="";
    

	public  void accountCode() throws Exception
    {
		try
		{
		 GenericMethods.clickElement(addnewaccnt);
		 RoomTaxAcntTitle=GenericMethods.generateRandomString();
 	     GenericMethods.sendKeys(acc_title, RoomTaxAcntTitle);
 	     Thread.sleep(2000);
 	     RoomTaxAcntCode=GenericMethods.generateRandomString();
 	     GenericMethods.js_Sendkey(acc_code, RoomTaxAcntCode);
 	    Thread.sleep(1000);
 	    GenericMethods.clickElement(acc_savebtn);
 	   // GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
    }


	public  RoomTaxesLandingPage saveRoomTaxes() throws Exception
	{
		try
		{
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, ShortName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		GenericMethods.sendKeys(taxPercent, "5");
		//GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(taxType, 2);
		Thread.sleep(500);
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public  RoomTaxesLandingPage creatingTaxOnRackRate() throws Exception
	{
		try
		{
		taxName=fixTaxName3;
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, ShortName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		GenericMethods.sendKeys(taxPercent, "10");
		//GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(taxType, 2);
		Thread.sleep(500);
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public  RoomTaxesLandingPage createSlabTax1(String date) throws Exception
	{
		try
		{
			taxName=slabTaxName1;
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, taxName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		//GenericMethods.sendKeys(taxPercent, "5");
	//	GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(taxType, 1);
		Thread.sleep(500);
		
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(1500);
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(1500);
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(1500);
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(500);
		
		//Selecting Slab range
		GenericMethods.sendKeys(slab_Range1, "1000");
		GenericMethods.sendKeys(slab_Range2, "2500");
		GenericMethods.sendKeys(slab_Range3, "7500");
		
		//Selecting Slab percentage
		GenericMethods.sendKeys(slab_Per1, "0");
		GenericMethods.sendKeys(slab_Per2, "6");
		GenericMethods.sendKeys(slab_Per3, "9");
		GenericMethods.sendKeys(slab_Per4, "14");
		
		//Getting NA Date
		String split[]=	date.split(" ");
		for(int i=0;i<=split.length-1;i++)
			
		{
			System.out.println(split[i]);
		}
		 month=split[0].substring(0, 3);
		year=split[2];
		String date1[]=split[1].split(",");
		int i=Integer.parseInt(date1[0]);
		int seldate=i+1;
		//Calander code
        GenericMethods.clickElement(cal_img);
        Thread.sleep(2000);
        GenericMethods.clickElement(cal_MonthLink);
		GenericMethods.selectElement(cal_MonthDrop, month);
		GenericMethods.sendKeys(cal_Year,year );
		GenericMethods.clickElement(cal_Ok);
		GenericMethods.clickElement(cal_selectCurrDate);
		
		//Clicking sbmit Button
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

		}
	
	public  RoomTaxesLandingPage createSlabTax2() throws Exception
	{
		try
		{
			taxName=slabTaxName2;
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, taxName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		//GenericMethods.sendKeys(taxPercent, "5");
	//	GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(taxType, 1);
		Thread.sleep(500);
		
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(1500);
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(1500);
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(1500);
		GenericMethods.clickElement(slab_Link);
		Thread.sleep(500);
		
		//Selecting Slab range
		GenericMethods.sendKeys(slab_Range1, "1000");
		GenericMethods.sendKeys(slab_Range2, "2500");
		GenericMethods.sendKeys(slab_Range3, "7500");
		
		//Selecting Slab percentage
		GenericMethods.sendKeys(slab_Per1, "0");
		GenericMethods.sendKeys(slab_Per2, "6");
		GenericMethods.sendKeys(slab_Per3, "9");
		GenericMethods.sendKeys(slab_Per4, "14");
		
		//Getting NA Date
		/*String split[]=	date.split(" ");
		for(int i=0;i<=split.length-1;i++)
			
		{
			System.out.println(split[i]);
		}
		String month=split[0].substring(0, 3);
		
		String date1[]=split[1].split(",");
		int i=Integer.parseInt(date1[0]);
		int seldate=i+1;*/
		//Calander code
		
		System.out.println("Month in slab 2 is::"+month);
		System.out.println("year in slab 2 is::"+year);
        GenericMethods.clickElement(cal_img);
        Thread.sleep(2000);
        GenericMethods.clickElement(cal_MonthLink);
		GenericMethods.selectElement(cal_MonthDrop, month);
		GenericMethods.sendKeys(cal_Year, year);
		GenericMethods.clickElement(cal_Ok);
		GenericMethods.clickElement(cal_selectCurrDate);
		
		//Clicking sbmit Button
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

		}
	
	public  RoomTaxesLandingPage creatingTaxOnTariff() throws Exception
	{
		try
		{
			
			taxName=taxOnTaxName1;
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, taxName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		GenericMethods.sendKeys(taxPercent, "10");
		//GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(taxType, 1);
		Thread.sleep(500);
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	public void enableTaxOnTax() throws Exception
	{
		GenericMethods.clickElement(isTaxable);
		int count1=GenericMethods.tr_count(tax_count);
		System.out.println("Count is"+count1);
		for(int i=1;i<=count1;i++)
		{
			String s1=GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody["+i+"]/tr[1]/td[2]")).getText();
			System.out.println("s1"+s1);
			if(s1.contains(slabTaxName1 ))
			{
				System.out.println("In first IF");
				GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody["+i+"]/tr[1]/td[1]//input")).click();
			}
			 if(s1.contains(slabTaxName2 ))
			{
				 System.out.println("In 2nd IF");
				GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody["+i+"]/tr[1]/td[1]//input")).click();
			}
	}
		GenericMethods.clickElement(saveBtn);
	}
	
	public RoomTaxesLandingPage creatingPerReservationTax() throws Exception
	{
		try
		{
			
			taxName=fixTaxName1;
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, taxName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.clickElement(rb_fixedValue);
		
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		GenericMethods.sendKeys(taxPercent, "10");
		//GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(fixtaxType, 1);
		Thread.sleep(500);
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
	
	public RoomTaxesLandingPage creatingPerNightTax() throws Exception
	{
		try
		{
			
			taxName=fixTaxName2;
		GenericMethods.sendKeys(taxTitle, taxName);
		GenericMethods.sendKeys(taxShortName, taxName);
		accountCode();
		Thread.sleep(2000);
		GenericMethods.clickElement(rb_fixedValue);
		
		GenericMethods.selectElementByIndex(select_acntcode, 1);
		Thread.sleep(3000);
		GenericMethods.sendKeys(description, taxName);
		GenericMethods.sendKeys(taxPercent, "10");
		//GenericMethods.clickElement(taxType);
		GenericMethods.selectElementByIndex(fixtaxType, 2);
		Thread.sleep(500);
		GenericMethods.clickElement(saveBtn);
		
		RoomTaxesLandingPage RTLP = PageFactory.initElements(GenericMethods.driver, RoomTaxesLandingPage.class);
		return RTLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}
}
