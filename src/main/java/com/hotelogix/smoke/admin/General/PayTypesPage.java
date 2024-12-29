package com.hotelogix.smoke.admin.General;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class PayTypesPage
{
	@FindBy(xpath="//div[@class='headingtxt']//td[2]")
	public static WebElement pgeTitle;

	@FindBy(xpath="//a[text()='Add a Pay Type']")
	public static WebElement addPayTypes;

	@FindBy(xpath="//form[@name='frmListView']//tbody//tr[2]")
	public static WebElement pgeMsg;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	public static List<WebElement> count;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_drpdown;


	public static String src_value="on.GIF";

	public  void verify_pgeTitle() throws InterruptedException
	   {
		   String txt=GenericMethods.getText(pgeTitle);
		   Assert.assertEquals(txt, "Pay Types");
	   }



	public AddEditPayType fn_clkAddPayType() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addPayTypes);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(addPayTypes);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddEditPayType APT=PageFactory.initElements(GenericMethods.driver,AddEditPayType.class);
		return APT;
	}



	public String  fn_verifySaveMsg() throws Exception
	{
		try
		{
		String text=GenericMethods.getText(pgeMsg);
		return text;
		}		
		catch(Exception e)
		{
			throw e;
		}
	}

	public POSPointsLandingPage  view_all() throws Exception
    {
		try
		{
    	GenericMethods.selectElement(view_drpdown, "All");
    	boolean b=GenericMethods.isAlertPresent();
    	if(b==true){
    	GenericMethods.ActionOnAlert("Accept");
    	}
    	POSPointsLandingPage pageObj=PageFactory.initElements(GenericMethods.driver, POSPointsLandingPage.class);
		return pageObj;
		}
		catch(Exception e)
		{
			throw e;
		}
    }

	public void fn_verifyAddedPayType(String value) throws Exception
	{
		try
		{
		int tbl_count=GenericMethods.tr_count(count);
		String data=null;
		for(int i=2;i<=tbl_count;i++)
		{
			 data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[3]")).getText();
			if(data.equals(AddEditPayType.PTTitle))
			{
				System.out.println(data);
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]//td[7]//img")).getAttribute("src");
				if(status.contains(value))
				{
					Assert.assertEquals(status.endsWith(value),true);
					//System.out.println("Added Pay Type is being displayed");
					break;
				}
			}
		}
		Assert.assertEquals(data, AddEditPayType.PTTitle);
		
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
