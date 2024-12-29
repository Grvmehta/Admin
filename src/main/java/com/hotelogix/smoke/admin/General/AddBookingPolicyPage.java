package com.hotelogix.smoke.admin.General;

import java.util.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddBookingPolicyPage {

	@FindBy(xpath="//input[@id='title']")
	public  WebElement txtbx_Booking;


	@FindBy(xpath="//input[@id='bookingBforDuration']")
	public  WebElement txtbx__Arrival;

	@FindBy(xpath="//select[@id='bookingType']")
	public  WebElement drpdwn_Booking;


	@FindBy(xpath="//input[@id='charge']")
	public  WebElement Charge;

	@FindBy(xpath="//input[@value='Save']")
	public  WebElement Save;

	public static String BookPo1;

	public   String fn_addBookingPolicy() throws Exception
	{
		try
		{
		String abcd1=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(txtbx_Booking, abcd1);

		GenericMethods.sendKeys(txtbx__Arrival, "3");
		//GenericMethods.selectElement(Booking_DropDown, "No Deposit");
		GenericMethods.selectElementByIndex(drpdwn_Booking, 3);
		//GenericMethods.sendKeys(Charge, "10");
		//String BookPol= "Sample Booking Title1.145";

		//System.out.println(BookPol);
		AddBookingPolicyPage.BookPo1=abcd1;
		return abcd1;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	
	
	
	
	public  String fn_Boking_Text() throws Exception
	{try{
	String a=fn_addBookingPolicy();
	return a;
	}catch(Exception e){
		throw e;
	}
	}
	
	
	
	
	
	public  BookingPolicyPage Booking_Policy_Save() throws Exception
	{

		try
		{
	GenericMethods.clickElement(Save);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(Save);
		}
		catch(Exception e)
		{
			throw e;
		}
	BookingPolicyPage BPOP=PageFactory.initElements(GenericMethods.driver, BookingPolicyPage.class);
	return BPOP;


	}





}
