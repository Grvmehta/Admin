package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.AddSpecialPeriodPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTaxesPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.itextpdf.text.log.SysoCounter;

public class POSTaxListPage {

	@FindBy(xpath="//td[text()='POS Tax List']")
	public static WebElement PTList;

	@FindBy(xpath="//a[@title='Add a Tax']")
	public static WebElement AddTax;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public static List<WebElement> POST;
	
	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement view;
	
	ArrayList<String> arr=null;

	public AddPOSTax AddTax() throws Exception
	{
		try
		{
		GenericMethods.clickElement(AddTax);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(AddTax);
		}
		catch(Exception e)
		{
			throw e;
		}
		AddPOSTax APT = PageFactory.initElements(GenericMethods.driver, AddPOSTax.class);
		return APT;

	}

	public  void fn_verifyPOST(String value) throws Exception
	{
		try
		{
			Thread.sleep(3000);
			String data="";
			arr	=new ArrayList<String>();
		int trcount=GenericMethods.tr_count(POST);
		System.out.println("TRcount::"+trcount);
		for(int i=2;i<trcount;i++)
		{
          data= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
         System.out.println("dataaaa:::"+data);
         String s2[]=data.split(" ");
		 arr.add(s2[0]);
		 System.out.println("AddPOSTax.TaxName:::"+AddPOSTax.TaxName);
		 if(arr.contains(AddPOSTax.TaxName))
		 {
         //   Assert.assertEquals(data, AddPOSTax.TaxName);
		    String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//img")).getAttribute("src");
		   System.out.println("SRC:::"+src);
		    Assert.assertTrue(src.endsWith(value));
		    break;
		}

	  }
		System.out.println("AddPOSTax.TaxName before comparing"+AddPOSTax.TaxName);
		Assert.assertEquals(arr.contains(AddPOSTax.TaxName), true);
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
		int count1=GenericMethods.tr_count(POST);
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
			System.out.println("Taxname::"+AddPOSTax.TaxName);
			if(data1.equals(AddPOSTax.TaxName))
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

	}}
