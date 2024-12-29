package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.Console.AddTravelAgentPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ManageSource {
	
	
public static String source="Web";
public static String source1="Travel Agent";
	
	
	@FindBy(xpath="//div[@id='popup_head']")
	public static WebElement pageTitle;    

	
	@FindBy(xpath="	//select[@id='refType']")
	public static WebElement DropDown;  
	
	
	
	@FindBy(xpath="	//input[@id='chkId_1']")
	public static WebElement CheckBox;
	
	
	@FindBy(xpath="//table[2]//tr[2]/td[3]")
	public static WebElement SourceType;
	
	
	@FindBy(xpath="//input[@value='Save']")
	public static WebElement Save_Btn;
	
	@FindBy(xpath="//table[@class='poptable'][2]//tr")
	public List<WebElement> rowcount;
	
	
public void verifyPage(){
		
		
String Title=GenericMethods.driver.getTitle();
System.out.println(Title);
String Title1=pageTitle.getText();
if(Title.equals(Title1)){
	System.out.println(Title + " This is title ");
}else {
	System.out.println("Title not match");
}
		
}


public GroupBookingSource fn_addSpecificTA() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	GenericMethods.selectElementByIndex(DropDown, 3);
    int count=GenericMethods.tr_count(rowcount);
    for(int i=2;i<=count;i++)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable'][2]//tr["+i+"]//td[4]")).getText();
     	arr.add(data.split(" ")[0]);
    	if(data.contains(AddTravelAgentPage.TaName))
    	{
    		Assert.assertEquals(data.contains(AddTravelAgentPage.TaName), true);
    		GenericMethods.driver.findElement(By.xpath("//table[@class='poptable'][2]//tr["+i+"]//td[2]/input")).click();
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(AddTravelAgentPage.TaName), true);
	GenericMethods.clickElement(Save_Btn);
    GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
  	return GBS;
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


	
	
public GroupBookingSource WebSource() throws Exception{
	

	try
	{
	GenericMethods.selectElement(DropDown, source);
	GenericMethods.clickElement(CheckBox);
	GenericMethods.clickElement(Save_Btn);
	Thread.sleep(2000);
     GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
	return GBS;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public GroupBookingSource TravelAgentSource() throws Exception
{
	try
	{
	GenericMethods.selectElement(DropDown, source1);
	GenericMethods.clickElement(CheckBox);
	GenericMethods.clickElement(Save_Btn);
	Thread.sleep(2000);
	GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
	return GBS;	
	}
	catch(Exception e)
	{
		throw e;
	}
	
}



	

}
