package com.hotelogix.smoke.admin.PriceManager;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddSeasonPage {

	@FindBy(xpath="//div[text()='Add/Edit a Season']")
	public static WebElement AddEditSeason;

	@FindBy(xpath="//input[@id='title']")
	public static WebElement Season_Title;

	@FindBy(xpath="//select[@id='seasonAttributeId']")
	public static WebElement SelectSeasonAttribute;

	@FindBy(xpath="//img[@id='showCalFrom']")
	public static WebElement CalenderStartDate;
	
	@FindBy(xpath="//tbody[starts-with(@class,'m')]//a")
	public static WebElement link_startDate;

	@FindBy(xpath="//div[@id='calFromContainer']//table//tr//div//a[2]")
	public static WebElement DateMonth;

	@FindBy(xpath="//input[@id='calFromContainer_nav_year']")
	public static WebElement Cal_Enter_Year;

	@FindBy(xpath="//select[@id='calFromContainer_nav_month']")
    public static WebElement MonthSel;

	@FindBy(xpath="//button[text()='OK']")
	public static WebElement Calender_OK;

	@FindBy(xpath="//div[@id='calFromContainer']//tbody//tr[2]//td[6]//a")
	public static WebElement StartDate_Hit;

	@FindBy(xpath="//img[@id='showCalTo']")
	public static WebElement CalenderEndDate;
	
	@FindBy(xpath="//table[@id='calTo']//td[4]/a")
	public static WebElement link_endDate;

	@FindBy(xpath="//div[@id='calToContainer']//table//div//a[2]")
	public static WebElement EndDateMonth;

	@FindBy(xpath="//select[@id='calToContainer_nav_month']")
	public static WebElement SelectEndDate;

	@FindBy(xpath="//input[@id='calToContainer_nav_year']")
	public static WebElement EndDateYear;

	@FindBy(xpath="//button[@id='calToContainer_nav_submit']")
	public static WebElement EndOk;

	@FindBy(xpath="//div[@id='calToContainer']//table//tbody//tr[2]//td[6]//a")
	public static WebElement EndDateHit;

	@FindBy(xpath="//input[@value='Save']")
	public static WebElement SeasonSave;

	public static String b;

	public String fn_EnterMandatoryFields() throws Exception
	{

		try
		{

		b=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(Season_Title, b);
		//String b=abc;
		GenericMethods.selectElementByIndex(SelectSeasonAttribute, 1);
		GenericMethods.clickElement(CalenderStartDate);
		//GenericMethods.clickElement(DateMonth);
		//GenericMethods.selectElement(MonthSel, "Aug");
		//GenericMethods.sendKeys(Cal_Enter_Year, "2030");
		//GenericMethods.clickElement(Calender_OK);
		GenericMethods.clickElement(link_startDate);
		Thread.sleep(500);
		//GenericMethods.clickElement(StartDate_Hit);
		GenericMethods.clickElement(CalenderEndDate);
		//GenericMethods.clickElement(EndDateMonth);
		//GenericMethods.selectElement(SelectEndDate, "Jul");
		Thread.sleep(500);
		//EndDateYear.clear();
		GenericMethods.clickElement(link_endDate);
		//GenericMethods.sendKeys(EndDateYear, "2032");
		//GenericMethods.clickElement(EndOk);
		//Thread.sleep(500);
		//GenericMethods.clickElement(EndDateHit);


		//AddSeasonPage.b=b;
		
		GenericMethods.clickElement(SeasonSave);
		return b;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public int fn_addSpecificDetails(String naDate,String name,int dateCounter,int seasonIndex,int nextSeasonStartDate) throws Exception
	{

		try
		{

		//b=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(Season_Title, name);
		//String b=abc;
		GenericMethods.selectElementByIndex(SelectSeasonAttribute, seasonIndex);
		int date=	GenericMethods.getNADate(naDate);
		String month=	GenericMethods.getNADateMonth(naDate);
		String year=	GenericMethods.getNADateYear(naDate);
		
		GenericMethods.clickElement(CalenderStartDate);
		Thread.sleep(500);
		GenericMethods.clickElement(DateMonth);
		Thread.sleep(500);
		GenericMethods.selectElement(MonthSel, month);
		GenericMethods.sendKeys(Cal_Enter_Year, year);
		GenericMethods.clickElement(Calender_OK);
		Thread.sleep(500);
		/*if(name.equalsIgnoreCase("summer"))
		{
			//date=date;
		}
		else
		{
			date=nextSeasonStartDate;
		}*/
		GenericMethods.driver.findElement(By.xpath("//a[text()="+nextSeasonStartDate+"]")).click();
		//GenericMethods.clickElement(link_startDate);
		Thread.sleep(500);
		//GenericMethods.clickElement(StartDate_Hit);
		GenericMethods.clickElement(CalenderEndDate);
		GenericMethods.clickElement(EndDateMonth);
		GenericMethods.selectElement(SelectEndDate, month);
		Thread.sleep(1000);
		//EndDateYear.clear();
		
		//GenericMethods.clickElement(link_endDate);
		
		GenericMethods.sendKeys(EndDateYear, year);
		GenericMethods.clickElement(EndOk);
		Thread.sleep(500);
		//GenericMethods.clickElement(EndDateHit);
		date=nextSeasonStartDate+dateCounter;
		GenericMethods.driver.findElement(By.xpath("//div[@id='calToContainer']//a[text()="+date+"]")).click();

		//AddSeasonPage.b=b;
		
		GenericMethods.clickElement(SeasonSave);
		return date;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	
	
	
	public  SeasonsLandingPage Seasons_save() throws Exception
	{
		try
		{
		GenericMethods.clickElement(SeasonSave);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(SeasonSave);
		}
		catch(Exception e)
		{
			throw e;
		}
		SeasonsLandingPage SLP=PageFactory.initElements(GenericMethods.driver, SeasonsLandingPage.class);
		return SLP;

	}

	public static void fn_VerifyAddSeasonPage()
	{
		String abc= AddEditSeason.getText();
		Assert.assertEquals(abc, "Add/Edit a Season");
	}


}
