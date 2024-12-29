package com.hotelogix.smoke.admin.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent1;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfRegisteredTravelAgentLP {

	@FindBy(xpath="//table[@class='list_viewnew']//td[11]/a")
	public  WebElement link_sendEmail;

	@FindBy(xpath="//input[@name='id[]']")
	public  List<WebElement> count_CheckBox;

	@FindBy(xpath="//a[@title='Add a Travel Agent']")
	public  WebElement btn_AddTravelAgent;

	@FindBy(xpath="//a[@title='Delete Selected Travel Agent(s)']")
	public  WebElement btn_DeleteTravelAgent;

	@FindBy(xpath="//div[@class='error_new']")
	public  WebElement txt_verifyMsg;

	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement drpdwn_view;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public List<WebElement> count_trcount; 


	public static String src;

	public  void  view_all() throws Exception
    {
		try
		{
    	GenericMethods.selectElement(drpdwn_view, "All");
    	GenericMethods.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
	
    }



	public  void sendEmail() throws Exception
	{
       try
       {
		GenericMethods.clickElement(link_sendEmail);
		String msg=GenericMethods.ActionOnAlert("Accept");
		Assert.assertEquals(msg, "E-mail sent Successfully.");
       }
       catch(Exception e)
       {
    	   throw e;
       }
	}



public AddTravelAgentPage AddTravelAgent_Btn() throws Exception{

	try
	{
		Thread.sleep(3000);
	   GenericMethods.clickElement(btn_AddTravelAgent);
	}catch(NoSuchElementException e){
		Thread.sleep(2500);
		GenericMethods.js_Click(btn_AddTravelAgent);
	}catch(Exception e){
		throw e;
	}
	AddTravelAgentPage ATA=PageFactory.initElements(GenericMethods.driver,AddTravelAgentPage.class);
    return ATA;
}

public void fn_verifyRegisteredTA(String value) throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(count_trcount);
	for(int i=2;i<=count;i++)
	{
	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
	arr.add(data);
	Assert.assertEquals(data, AddTravelAgentPage.TaName);
	String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]//img")).getAttribute("src");
	Assert.assertEquals(src.endsWith(value),true);
	break;
	}
	Assert.assertEquals(arr.contains(AddTravelAgentPage.TaName), true);
	}catch(AssertionError e){
		throw e;
	}catch(Exception e){
		throw e;
	}
}



public void fn_sendEmail() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(count_trcount);
	for(int i=2;i<=count;i++)
	{
		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
		arr.add(data);
		if(data.contains(AddTravelAgentPage.TaName))
		{
			Assert.assertEquals(data.contains(AddTravelAgentPage.TaName),true);
			GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[11]//div")).click();
			Thread.sleep(3000);
			String txt=GenericMethods.Alert_Accept();
		    Assert.assertEquals(txt.equals("E-mail sent Successfully."), true);
			break;

		}
	}
	
	Assert.assertEquals(arr.contains(AddTravelAgentPage.TaName), true);
  
	}catch(AssertionError e){
		throw e;
	}catch(Exception e){
		throw e;
	}
}







}