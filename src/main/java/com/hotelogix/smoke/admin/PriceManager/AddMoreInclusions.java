package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddMoreInclusions
{
   @FindBy(xpath="//div[@id='popup_head']")
   public  WebElement title;

   @FindBy(xpath="//table[@class='poptable']/tbody/tr")
   public  List<WebElement> incl_count;

   @FindBy(xpath="//table[@class='poptable']//tr[2]//td[2]/input")
   public  WebElement chkbox_incl1;

   @FindBy(xpath="//table[@class='poptable']//tr[2]//td[3]")
   public  WebElement name_incl1;

   @FindBy(xpath="//span[@class='comments']/input")
   public  WebElement addtopkg_btn;

   @FindBy(xpath="//table[@class='poptable']//tr")
   public  List<WebElement> chkboxes;



   public static ArrayList<String> arr=new ArrayList<String>();

   public static String a;

   public  void verify_title() throws Exception
   {
	   String childId=GenericMethods.windowHandle_admin(AddEditPackage.windowID);
	   GenericMethods.checkElementDisplay(title);
   }


   public  AddEditPackage search_addon() throws Exception
   {
	  
	   try
	   {
	   int count=GenericMethods.tr_count(incl_count);
	   for(int i=2;i<=count;i++)
	   {
		   String data=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[3]")).getText();
		  // arr.add(data);
		   if(data.contains(SaveAddonsPage.AddonName))
		   {
		   Assert.assertEquals(data.contains(SaveAddonsPage.AddonName), true);
		   break;
		   }
	   }

	   AddEditPackage pageobj= PageFactory.initElements(GenericMethods.driver, AddEditPackage.class);
	   return pageobj;
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


   public  AddEditPackage select_inclusion() throws Exception
   {
	   try
	   {
	   //String childID=GenericMethods.windowHandle_admin(AddEditPackage.windowID);
	   GenericMethods.clickElement(chkbox_incl1);
	   a=GenericMethods.getText(name_incl1);
	   GenericMethods.clickElement(addtopkg_btn);
	   //GenericMethods.Switch_Parent_Window(AddEditPackage.windowID);
	   AddEditPackage pageobj= PageFactory.initElements(GenericMethods.driver, AddEditPackage.class);
	   return pageobj;
	   }
	   catch(Exception e)
	   {
		   throw e;
	   }
   }


   public  AddEditPackage select_ChocBarIncl() throws Exception
   {
	   String childID=GenericMethods.windowHandle_admin(AddEditPackage.windowID);
	   int count=GenericMethods.tr_count(chkboxes);
	   for(int i=2;i<=count;i++)
	   {
		   a=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[3]")).getText();
	       if(a.contains("Choc bar"))
	       {
	    	   WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[2]//input"));
	    	   ele.click();
	    	   break;
	       }
	   }
	   //GenericMethods.clickElement(chkbox_incl1);
	   //a=GenericMethods.getText(name_incl1);
	   GenericMethods.clickElement(addtopkg_btn);
	   GenericMethods.Switch_Parent_Window(AddEditPackage.windowID);
	   AddEditPackage pageobj= PageFactory.initElements(GenericMethods.driver, AddEditPackage.class);
	   return pageobj;

   }

   
   public  AddEditPackage select_preAddedAddons(String addonName) throws Exception
   {
	  // String childID=GenericMethods.windowHandle_admin(AddEditPackage.windowID);
	   int count=GenericMethods.tr_count(chkboxes);
	   System.out.println("Add-ons Count:::"+count);
	   for(int i=2;i<=count;i++)
	   {
		   a=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[3]")).getText();
		   System.out.println("value of A::"+a);
	       if(a.contains(addonName))
	       {
	    	   System.out.println("In if");
	    	   WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[2]//input"));
	    	   ele.click();
	    	   break;
	       }
	   }
	   //GenericMethods.clickElement(chkbox_incl1);
	   //a=GenericMethods.getText(name_incl1);
	   GenericMethods.clickElement(addtopkg_btn);
	  // GenericMethods.Switch_Parent_Window(AddEditPackage.windowID);
	   AddEditPackage pageobj= PageFactory.initElements(GenericMethods.driver, AddEditPackage.class);
	   return pageobj;

   }

   public  AddEditPackage select_ChocBarPA() throws Exception
   {
	   String childID=GenericMethods.windowHandle_admin(AddEditPackage.windowID);
	   int count=GenericMethods.tr_count(chkboxes);
	   for(int i=2;i<=count;i++)
	   {
		   a=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[3]")).getText();
	       if(a.contains("Choc Bar FD"))
	       {
	    	   String[] parts=a.split("\n");
	    	   String part1=parts[1];
	    	   Assert.assertEquals(part1, "Everyday but Check-out Per Child");
	    	   WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable']//tr["+i+"]//td[2]//input"));
	    	   ele.click();
	    	   break;
	       }
	   }
	   //GenericMethods.clickElement(chkbox_incl1);
	   //a=GenericMethods.getText(name_incl1);
	   GenericMethods.clickElement(addtopkg_btn);
	   GenericMethods.Switch_Parent_Window(AddEditPackage.windowID);
	   AddEditPackage pageobj= PageFactory.initElements(GenericMethods.driver, AddEditPackage.class);
	   return pageobj;

   }



}
