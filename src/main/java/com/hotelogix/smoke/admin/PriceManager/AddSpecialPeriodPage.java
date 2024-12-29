package com.hotelogix.smoke.admin.PriceManager;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddSpecialPeriodPage {

	@FindBy(xpath="//div[text()='Add/Edit Special Period']")
	public static WebElement AddEditSpecialPeriod;

	@FindBy(xpath="//input[@name='title']")
	public static WebElement SpecialPeriodTitle;

	@FindBy(xpath="//select[@id='seasonAttributeId']")
	public static WebElement SelSeasonAttribute;

	@FindBy(xpath="//img[@id='showCalFrom']")
	public static WebElement StartCalIcon;

	@FindBy(xpath="//div[@id='calFromContainer']//table//tr//div//a[2]")
	public static WebElement StartCalmonth;

	@FindBy(xpath="//select[@id='calFromContainer_nav_month']")
	public static WebElement SelMonth;

	@FindBy(xpath="//input[@id='calFromContainer_nav_year']")
	public static WebElement StartCalEntrYr;

	@FindBy(xpath="//button[@id='calFromContainer_nav_submit']")
	public static WebElement StartCalOk;

	@FindBy(xpath="//div[@id='calFromContainer']//table//tbody//a")
	public static WebElement StartDate;

	@FindBy(xpath="//div[@id='calToContainer']//table//tbody//a")
	public static WebElement EndDate;


	@FindBy(xpath="//img[@id='showCalTo']")
	public static WebElement EndCalIcon;

	@FindBy(xpath="//div[@id='calToContainer']//table//div//a[2]")
	public static WebElement EndCalmonth;

	@FindBy(xpath="//select[@id='calToContainer_nav_month']")
	public static WebElement EndSelMonth;

	@FindBy(xpath="//input[@id='calToContainer_nav_year']")
	public static WebElement EndEntrYr;

	@FindBy(xpath="//button[@id='calToContainer_nav_submit']")
	public static WebElement EndCalOk;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save;

	@FindBy(xpath="//table[@id='cal1']//tbody//tr//td//a")
    public  List<WebElement> link_fromDateCollection;
	
	@FindBy(xpath="//table[@id='calTo']//tbody//tr//td//a")
    public  List<WebElement> dataCollection;
	
	
	public static String Sam_Tit;

	public void fn_EnterMandatoryFieldsForAddSeason() throws Exception
	{
		GenericMethods.sendKeys(SpecialPeriodTitle, "Sample Special Period");
		GenericMethods.selectElement(SelSeasonAttribute, "High");
		GenericMethods.clickElement(StartCalIcon);
		GenericMethods.clickElement(StartCalmonth);
		GenericMethods.selectElement(SelMonth, "Aug");
		GenericMethods.sendKeys(StartCalEntrYr, "2016");
		GenericMethods.clickElement(StartCalOk);
		GenericMethods.clickElement(StartDate);

		GenericMethods.clickElement(EndCalIcon);
		GenericMethods.clickElement(EndCalmonth);
		GenericMethods.selectElement(EndSelMonth, "Oct");
		GenericMethods.sendKeys(EndEntrYr, "2020");
		GenericMethods.clickElement(EndCalOk);


	}

	public String fn_SPMandatory() throws Exception
	{
		try
		{
		Sam_Tit=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(SpecialPeriodTitle, Sam_Tit);
		//String Sam_Tit=abc;
		GenericMethods.selectElementByIndex(SelSeasonAttribute, 1);
		GenericMethods.clickElement(StartCalIcon);
		//GenericMethods.clickElement(StartCalmonth);
		//GenericMethods.selectElement(SelMonth, "Aug");
		//StartCalEntrYr.clear();
		//Thread.sleep(1000);
		//GenericMethods.sendKeys(StartCalEntrYr, "2026");
		//Thread.sleep(1000);
		//GenericMethods.clickElement(StartCalOk);
		//Thread.sleep(500);
		GenericMethods.clickElement(StartDate);

		GenericMethods.clickElement(EndCalIcon);
		GenericMethods.clickElement(EndCalmonth);
		GenericMethods.selectElement(EndSelMonth, "Mar");
//		EndEntrYr.clear();
//		GenericMethods.sendKeys(EndEntrYr, "2028");
		Thread.sleep(500);
		GenericMethods.clickElement(EndCalOk);
		Thread.sleep(500);
		GenericMethods.clickElement(EndDate);
		GenericMethods.clickElement(Save);
		return Sam_Tit;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public SpecialPeriodLandingPage save() throws Exception
	{

		GenericMethods.clickElement(Save);
		SpecialPeriodLandingPage SPLL = PageFactory.initElements(GenericMethods.driver, SpecialPeriodLandingPage.class);
		return SPLL;
	}

	
	public String fn_selectSeasonAttri(int attri) throws Exception{
		try{
			GenericMethods.selectElementByIndex(SelSeasonAttribute, attri);
		Select sel=new Select(SelSeasonAttribute);
		String str=sel.getFirstSelectedOption().getText();
		return str;
		}catch(Exception e){
			throw e;
		}
	}



	public SeasonsLandingPage fn_addSPeriod(String title,int dateDiff) throws Exception
	{try{
		Sam_Tit=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(SpecialPeriodTitle,Sam_Tit);
		GenericMethods.selectElement(SelSeasonAttribute, title);
		GenericMethods.clickElement(StartCalIcon);
		//GenericClass.clickElement(link_fromDate);
		   Calendar cal = Calendar.getInstance();
	       System.out.println("current date: " + cal.getTime());
	       String[] arr=cal.getTime().toString().split(" ");
	       String currDate=arr[2];
	       for(WebElement date: link_fromDateCollection)
	       {
	           String strobj1=date.getText();
	           if(currDate.contains(strobj1)){
	           date.click();
	           break;
	           }
	       }
	      // int curr=Calendar.DATE;
	       cal.add(Calendar.DATE,dateDiff);
	       Date dob=cal.getTime();
	       String st=dob.toString();
	       String[] parts=st.split(" ");
	       String parts2=parts[2];
	       System.out.println(parts2);
	       Thread.sleep(2000);
	       GenericMethods.js_Click(EndCalIcon);
	       for(WebElement date1: dataCollection )
	       {
	           String strobj2=date1.getText();
	           if(parts2.contains(strobj2)){
	           date1.click();
	           break;
	       }
	       }
	       GenericMethods.clickElement(Save);
		
	       SeasonsLandingPage SLP=PageFactory.initElements(GenericMethods.driver, SeasonsLandingPage.class);
		return SLP;
	       }catch(Exception e){
	    	   throw e;
	       }
	}
}
