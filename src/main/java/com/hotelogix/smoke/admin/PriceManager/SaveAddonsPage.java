package com.hotelogix.smoke.admin.PriceManager;

import org.apache.poi.xssf.model.CalculationChain;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SaveAddonsPage
{
	@FindBy(id="titleMulTang_0")
	public  WebElement addonTitle;

	@FindBy(name="shortName")
	public  WebElement addonShortName;

	@FindBy(id="posPointId")
	public  WebElement selectPOSPoint;

	/*@FindBy(xpath="//select[@id='posPointId']/option[2]")
	public static WebElement selectPOSPoint;*/

	@FindBy(id="prodIdMannual")
	public  WebElement selectProduct;

	/*@FindBy(xpath="//select[@id='prodIdMannual']/option[2]")
	public static WebElement selectProduct;
	*/
	@FindBy(id="price")
	public  WebElement price;

	@FindBy(name="calcRule")
	public  WebElement selectCalculationRule;

	/*
	@FindBy(xpath="//select[@name='calcRule']/option[2]")
	public static WebElement selectCalculationRule;
	*/

	@FindBy(id="postingRythm")
	public  WebElement selectPostingRythm;


	/*
	@FindBy(xpath="//select[@id='postingRythm']/option[2]")
	public static WebElement selectPostingRythm;
	*/
	@FindBy(name="Submit5")
	public  WebElement save;

	public static String AddonName;



	public AddonLandingPage saveAddon() throws Exception
	{
		try
		{
		//Get Unique Addon Name
		int addonNo1= GenericMethods.randomNumber();

		AddonName="Addon"+addonNo1;

		GenericMethods.sendKeys(addonTitle, AddonName);
		GenericMethods.sendKeys(addonShortName,Integer.toString(addonNo1));

		GenericMethods.selectElementByIndex(selectPOSPoint, 1);
		Thread.sleep(2000);

		GenericMethods.selectElementByIndex(selectProduct, 1);

		//GenericMethods.sendKeys(price, "100"); Price will be Picked Up

		GenericMethods.selectElementByIndex(selectCalculationRule, 1);
		Thread.sleep(2000);

		GenericMethods.selectElementByIndex(selectPostingRythm, 1);

		GenericMethods.clickElement(save);
		
		boolean b=GenericMethods.isAlertPresent();
    	if(b==true){
        	GenericMethods.Alert_Accept();
    	}

		AddonLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AddonLandingPage.class);
		return ALP;

		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public AddonLandingPage saveAddonWithSpecificData(String posPointName,String pdtName) throws Exception
	{
		try
		{
		//Get Unique Addon Name
		int addonNo1= GenericMethods.randomNumber();

		AddonName="Addon"+addonNo1;

		GenericMethods.sendKeys(addonTitle, AddonName);
		GenericMethods.sendKeys(addonShortName,Integer.toString(addonNo1));

		GenericMethods.selectElement(selectPOSPoint, posPointName);
		Thread.sleep(2000);

		GenericMethods.selectElement(selectProduct, pdtName);

		//GenericMethods.sendKeys(price, "100"); Price will be Picked Up

		GenericMethods.selectElementByIndex(selectCalculationRule, 1);
		Thread.sleep(2000);

		GenericMethods.selectElementByIndex(selectPostingRythm, 1);

		GenericMethods.clickElement(save);

		AddonLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AddonLandingPage.class);
		return ALP;

		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public  AddonLandingPage fn_addChocBar() throws Exception
	{
		//Get Unique Addon Name
		int addonNo1= GenericMethods.randomNumber();

		AddonName="Choc Bar FD";

		GenericMethods.sendKeys(addonTitle, AddonName);
		GenericMethods.sendKeys(addonShortName,Integer.toString(addonNo1));

		GenericMethods.selectElementByIndex(selectPOSPoint, 1);
		Thread.sleep(2000);

		GenericMethods.selectElementByIndex(selectProduct, 1);

		//GenericMethods.sendKeys(price, "100"); Price will be Picked Up

		GenericMethods.selectElementByIndex(selectCalculationRule, 1);
		Thread.sleep(2000);

		GenericMethods.selectElementByIndex(selectPostingRythm, 3);

		GenericMethods.clickElement(save);

		AddonLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AddonLandingPage.class);
		return ALP;


	}



}
