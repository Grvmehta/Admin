package com.hotelogix.smoke.admin.PosManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class POSProductsList {
	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> tr_count;

	@FindBy(xpath="//table[@class='table-content']//tr[2]//td[4]")
	public static WebElement productName1;

	@FindBy(xpath="//input[@name='prodName']")
	public static WebElement search_txtBox;

	@FindBy(xpath="//label//input[2]")
	public static WebElement go_BT;

	public void verify_addedPOSProduct(String value) throws Exception
	{
		try
		{
		GenericMethods.sendKeys(search_txtBox, AddPOSProduct.productName);
		GenericMethods.clickElement(go_BT);
		String name=GenericMethods.getText(productName1);
	    if(name.equals(AddPOSProduct.productName))
	    {
		Assert.assertEquals(name, AddPOSProduct.productName);
		String src=GenericMethods.driver.findElement(By.xpath("//table[@class='table-content']//tr[2]//td[11]//img")).getAttribute("src");
		Assert.assertEquals(src.endsWith(value), true);
	    }
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

	public String verify_addedPOSProductWithTax(String value) throws Exception
	{
		try
		{
		GenericMethods.sendKeys(search_txtBox, AddPOSProduct.productName);
		GenericMethods.clickElement(go_BT);
		String name=GenericMethods.getText(productName1);
	    if(name.equals(AddPOSProduct.productName))
	    {
		Assert.assertEquals(name, AddPOSProduct.productName);
		String src=GenericMethods.driver.findElement(By.xpath("//table[@class='table-content']//tr[2]//td[9]//img")).getAttribute("src");
		Assert.assertEquals(src.endsWith(value), true);
	    }
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
		return AddPOSProduct.productName;
	    
	}


	

	}

