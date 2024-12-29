package com.hotelogix.smoke.admin.General;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.admin.PriceManager.SaveAddonsPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class EarlyBirdDiscountPage {
	
	
	@FindBy(xpath="//a[text()='Add a Discount ']")
	public  WebElement addDiscount;
	
	@FindBy(xpath="//input[@id='title']")
	public  WebElement txt_title;
	
	@FindBy(xpath="	//input[@name='fromOcc[]']")
	public  WebElement txt_frmOcc;
	
	@FindBy(xpath="//input[@name='toOccu[]']")
	public  WebElement txt_toOcc;
	
	@FindBy(xpath="//input[@name='fromDiscount[]']")
	public  WebElement txt_fromDisc;
	
	@FindBy(xpath="//input[@name='toDiscount[]']")
	public  WebElement txt_toDisc;
	
	@FindBy(xpath="//input[@name='Submit5']")
	public  WebElement btn_Save;
	
	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public  List<WebElement> tr_count;
	
	@FindBy(xpath="//form[@name='frmListView']//tbody//tr[2]")
	public  WebElement discount_savemsg;
	
	public String title;
	
	public void addEarlyBirdDiscount(String title,String frmOcc,String toOcc,String frmDisc,String toDisc) throws Exception
	{
		GenericMethods.clickElement(addDiscount);
		this.title=title;
		GenericMethods.sendKeys(txt_title, title);
		GenericMethods.sendKeys(txt_frmOcc, frmOcc);
		GenericMethods.sendKeys(txt_toOcc, toOcc);
		GenericMethods.sendKeys(txt_fromDisc, frmDisc);
		GenericMethods.sendKeys(txt_toDisc, toDisc);
		
		GenericMethods.clickElement(btn_Save);
		
	}
	
	public String verify_saveMsg() throws Exception
	{
		try
		{
		String exp_msg=GenericMethods.getText(discount_savemsg);
		return exp_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	
	public  void verify_savedDiscount(String value) throws Exception
	{
		String str = null;
		try
		{
			
		int count=GenericMethods.tr_count(tr_count);
		for(int i=2;i<=count;i++)
		{
		String saved_discount=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		//str=saved_addon.split(" ")[0];
		//arr.add(str[0]);	
		if(saved_discount.contains(title))
		{
			String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]//img")).getAttribute("src");
			Assert.assertEquals(status.endsWith(value), true);
			break;
		}
		}
		//Assert.assertEquals(str.contains(title), true);
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
