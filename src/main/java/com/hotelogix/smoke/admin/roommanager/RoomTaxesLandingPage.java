package com.hotelogix.smoke.admin.roommanager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;
//import com.sun.jna.platform.unix.X11.XCirculateEvent;

public class RoomTaxesLandingPage
{
	@FindBy(xpath="//a[text()='Add a Tax']")
	public  WebElement addaTax;

	@FindBy(xpath="//div[@class='error_new']")
	public  WebElement roomtax_msg;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public  List<WebElement> tax_count;

	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement view;

	public static String tax_src="on.GIF";


	ArrayList<String> arr= new ArrayList<String>();
	
	public  SaveRoomTaxesPage clickAddRoomTaxes() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addaTax);

		SaveRoomTaxesPage SRTP = PageFactory.initElements(GenericMethods.driver, SaveRoomTaxesPage.class);
		return SRTP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  String verify_roomtax() throws Exception
	{
		try
		{
		String taxpge_msg=GenericMethods.getText(roomtax_msg);
		//Assert.assertTrue(taxpge_msg.contains(SaveRoomTaxesPage.taxName));

		return taxpge_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  void chk_taxstatus() throws Exception
	{
		try
		{
		GenericMethods.selectElement(view, "All");
		
		boolean b1=GenericMethods.isAlertPresent();
		if(b1==true)
		{
			GenericMethods.Alert_Accept();
		}
		int count1=GenericMethods.tr_count(tax_count);
		System.out.println("count1::"+count1);
		//System.out.println(count1);
		for(int i=2;i<=count1;i++)
		{

			String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			System.out.println("data1:::"+data1);
			String s2[]=data1.split(" ");
			arr.add(s2[0]);
			if(data1.equals(SaveRoomTaxesPage.taxName))
			{
			//Assert.assertEquals(data1, SaveRoomTaxesPage.taxName);
			String data2=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//img")).getAttribute("src");
			System.out.println("in if Data2::"+data2);
			Assert.assertEquals(data2.contains(tax_src), true);
			break;
			}

		}
		System.out.println("SaveRoomTaxesPage.taxName"+SaveRoomTaxesPage.taxName);
		Assert.assertEquals(arr.contains(SaveRoomTaxesPage.taxName), true);

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
	
	public void enablingTaxOnTaxInExistingTax() throws Exception
	{
		try
		{
		GenericMethods.selectElement(view, "All");
		
		boolean b1=GenericMethods.isAlertPresent();
		if(b1==true)
		{
			GenericMethods.Alert_Accept();
		}
		int count1=GenericMethods.tr_count(tax_count);
		System.out.println("count1::"+count1);
		//System.out.println(count1);
		for(int i=2;i<=count1;i++)
		{

			String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			System.out.println("data1:::"+data1);
			String s2[]=data1.split(" ");
			arr.add(s2[0]);
			data1=s2[0];
			System.out.println("data1 after split"+data1);
			System.out.println("Taxname::"+SaveRoomTaxesPage.taxName);
			if(data1.equals(SaveRoomTaxesPage.taxName))
			{
				System.out.println("In if");
			//Assert.assertEquals(data1, SaveRoomTaxesPage.taxName);
			GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//a")).click();
			break;
			}

		}
		//System.out.println("SaveRoomTaxesPage.taxName"+SaveRoomTaxesPage.taxName);
		//Assert.assertEquals(arr.contains(SaveRoomTaxesPage.taxName), true);

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
