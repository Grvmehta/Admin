package com.hotelogix.smoke.admin.roommanager;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AmenitiesLandingPage
{

	//@FindBy(xpath="//div[@id='heading_new']//ul//li[3]//a[2][@title='Add an Amenity ']")
	//public static WebElement addAmenity;
	////div[@id='heading_new']//ul//li[3]//a[2][@title='Add an Amenity ']


	@FindBy(xpath="//a[text()='Add an Amenity ']")
	public  WebElement addAmenity;

	@FindBy(xpath="//div[@class='error_new']")
	public  WebElement message;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public  List<WebElement> count;


	public  String src_value="on.GIF";

//	static String amenityName="Test Amenity1";
//	static String expMessage1="- Amenity ";
//	static String expMessage2=" Saved Successfully";
//
//	static int randomNumber = GenericMethods.randomNumber();
//	static String expMessage=expMessage1+'"'+amenityName+randomNumber+'"'+expMessage2;
//


	public String verify_pageTitle() throws Exception
	{
		try
		{
		String str=GenericMethods.driver.getTitle();
        return str;
		}	
		catch(Exception e)
		{
			throw e;
		}
	}

	public  AddEditAmenity fn_clkAddAmenity() throws Exception
	{
		//..Method navigates to AddEditAmenity page
		//..Taking return of AddEditAmenity page
		try
		{
		GenericMethods.clickElement(addAmenity);
		AddEditAmenity AEA=PageFactory.initElements(GenericMethods.driver, AddEditAmenity.class);
		return AEA;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  String fn_verifyMsg() throws Exception
	{
		//..Method verifies message displayed on saving amenity
		//..Fetches text of message being displayed
		try
		{
		String msg=GenericMethods.getText(message);
        return msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  void fn_verifyAmentiy(String value) throws Exception
	{
		//..Method compares text of each amenity with added amenity text
		//..Verifies added amenity
        ArrayList<String> arr=new ArrayList<String>();
		try
		{
		int amenity_count=GenericMethods.tr_count(count);
		for(int i=2;i<=amenity_count;i++)
		{
			String amenity_name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			arr.add(amenity_name);
			if(amenity_name.equals(AddEditAmenity.amenityName))
			{
				//System.out.println(amenity_name);
				Assert.assertEquals(amenity_name, new AddEditAmenity().amenityName);
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[6]//img")).getAttribute("src");
				if(status.contains(value))
				{
					Assert.assertEquals(status.contains(value), true);
					break;
				}
			}			
		}
		Assert.assertEquals(arr.contains(AddEditAmenity.amenityName), true);
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
