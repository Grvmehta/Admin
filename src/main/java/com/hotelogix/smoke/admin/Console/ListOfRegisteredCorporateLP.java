package com.hotelogix.smoke.admin.Console;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.UserManager.AddEditUser;
import com.hotelogix.smoke.admin.UserManager.UsersListLandingPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

	public class ListOfRegisteredCorporateLP {

		@FindBy(xpath="//input[@type='checkbox']")
		public  List<WebElement> count_trCount;

		@FindBy(xpath="//div[@class='headingtxt']//tr//td[2]")
		public  WebElement txt_title;

		@FindBy(xpath="//div[@id='listing-icons']//li[3]//img")
		public  WebElement link_addACorporate;

		@FindBy(xpath="//input[@name='searchTitle']")
		public  WebElement txtbx_Search;
		

		@FindBy(xpath="//input[@value='Search']")
		public  WebElement btn_Search;

		@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[4]/a")
		public  WebElement regCorporateName;

		@FindBy(xpath="//select[@name='maxEntries']")
		public  WebElement drpdwn_view;

		public  void verifyPage() throws InterruptedException{
			String abc=GenericMethods.getText(txt_title);
			Assert.assertEquals(abc, "List of Registered Corporate");
		}

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

		public  AddEditCorporate fn_NavigateToAddEditCorporate() throws Exception
		{
			try
			{
			GenericMethods.clickElement(link_addACorporate);
			}
			catch(NoSuchElementException e)
			{
				Thread.sleep(3000);
				GenericMethods.js_Click(link_addACorporate);
			}
			AddEditCorporate pageobj=	PageFactory.initElements(GenericMethods.driver, AddEditCorporate.class);
			return pageobj;
		}

		public  void fn_verifyRegCorporate(String value) throws Exception
		{
			try
			{
			ArrayList<String> arr=new ArrayList<String>();
			int count=GenericMethods.tr_count(count_trCount);
			for(int i=2;i<=count;i++)
			{
				String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]/a")).getText();
				arr.add(data);
				Assert.assertEquals(data, AddEditCorporate.corporateName);
				String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[11]//img")).getAttribute("src");
				Assert.assertEquals(src.endsWith(value),true);
				break;
			}
			Assert.assertEquals(arr.contains(AddEditCorporate.corporateName), true);
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

		public static String findCorpName(int i){

			String name= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]/a")).getText();
			return name;
			}







	}


