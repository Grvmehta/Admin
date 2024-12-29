package com.hotelogix.smoke.admin.roommanager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditAmenity
{
	@FindBy(id="titleMulTang_0")
	public  WebElement amenityTitle;
	// Amenity Title

	@FindBy(id="descriptionMulTang_0")
	public  WebElement amenityDescription;
	// Amenity Description

	@FindBy(name="Submit5")
	public  WebElement save;
	//Save Button Submit5



	public static String amenityName;
//	static String expMessage1="- Amenity ";
//	static String expMessage2=" Saved Successfully";
//


   public static  int randomNumber = GenericMethods.randomNumber();
  // public  static String name=amenityName+randomNumber;
	//static String expMessage=expMessage1+'"'+amenityName+randomNumber+'"'+expMessage2;


   
   
   
	public  AmenitiesLandingPage fn_addAmentiyDetails() throws Exception
	{
		//..Method enters details required to add amenity and saves it
		//..Navigates to AmenitiesLandingPage
		try
		{
			amenityName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(amenityTitle,amenityName);
		GenericMethods.sendKeys(amenityDescription, amenityName);
		GenericMethods.clickElement(save);

		//..Initializing AmenitiesLandingPage
		AmenitiesLandingPage ALP = PageFactory.initElements(GenericMethods.driver, AmenitiesLandingPage.class);
		return ALP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


}
