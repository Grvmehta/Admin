package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditPOSPoint {

	@FindBy(xpath="//input[@name='posPointShortName']")
	public static WebElement posPointShortName;

	@FindBy(xpath="//tr//td/input")
	public static WebElement posPointName;

	@FindBy(xpath="//td/select[@name='deptId']")
	public static WebElement deptName;

	@FindBy(xpath="//input[@name='porductReq']")
	public static WebElement productReq_CB;

	@FindBy(xpath="//input[@id='posPointNameMulName_0']")
	public static WebElement POSPTitle;

	@FindBy(xpath="//input[@id='posPointShortName']")
	public static WebElement PosPointSN;

	@FindBy(xpath="//select[@name='deptId']")
	public static WebElement DeptDD;

	@FindBy(xpath="//input[@value='Save POS Point']")
	public static WebElement SPOP;

	@FindBy(xpath="//input[@id='posPointShortName']")
	public static WebElement PPSN;

	@FindBy(xpath="//input[@id='updateForSync']")
	public static WebElement UPACCC;

	@FindBy(xpath="//input[@name='porductReq']")
	public static WebElement ProductRequired;

	@FindBy(xpath="//td[text()='Add/Edit a POS Point']")
	public static WebElement AEPP;

	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public static WebElement addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public static WebElement acc_title;

	@FindBy(xpath="//input[@id='accountCode']")
	public static WebElement acc_code;

	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	public static WebElement acc_savebtn;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public static WebElement acc_cancelbtn;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public static WebElement accountcode;
	
	
	@FindBy(xpath="//td[@class='padingtd']//tr[20]//td[2]//font")
	public List<WebElement> count_font;

	@FindBy(xpath="//input[@name='taxs[]']")
	public List<WebElement> chkbox_tax;
	

	public static String a;
	public static String b;
	public static String name;
	
	ArrayList<String> arr=null;


	public String AddPOSFields() throws Exception
	{
	GenericMethods.sendKeys(POSPTitle, "Sample POS Point Title");
	String a= "Sample POS Point Title";
	GenericMethods.sendKeys(PosPointSN, "Sample SHort Name");
	GenericMethods.selectElement(DeptDD, "Sample Marketing");

	AddEditPOSPoint.a=a;
	return a;
	}

	       public static String POSPointName;
	       public static String POSPointAcntTitle;
	       public static String POSPointAcntCode;

	       public static void accountCode() throws Exception
	       {
	    	   POSPointAcntTitle=GenericMethods.generateRandomString();
	    	   GenericMethods.clickElement(addnewaccnt);
	    	   GenericMethods.sendKeys(acc_title, POSPointAcntTitle);
	    	   POSPointAcntCode=GenericMethods.generateRandomString();
	    	   GenericMethods.sendKeys(acc_code, POSPointAcntCode);
	    	   GenericMethods.clickElement(acc_savebtn);
	    	   GenericMethods.ActionOnAlert("Accept");

	       }


	       public  void fillDetails() throws Exception
	       {
	    	   try
	    	   {
	    	   POSPointName=GenericMethods.generateRandomString();
	    	   GenericMethods.sendKeys(posPointShortName, GenericMethods.generateRandomString());
	    	   GenericMethods.sendKeys(posPointName, POSPointName);
	    	   GenericMethods.selectbyNo(deptName, 2);
	    	   Select sel=new Select(accountcode);
	    	   if(sel.getOptions().size()<=1==true){
//	    	   GenericMethods.clickElement(addnewaccnt);
//	    	   GenericMethods.sendKeys(acc_title, "POS");
//	    	   GenericMethods.sendKeys(acc_code, "111");
//	    	   GenericMethods.clickElement(acc_savebtn);
	    	   accountCode();
	    	   }
	    	   GenericMethods.selectElementByIndex(accountcode, 1);
	    	   }
	    	   catch(Exception e)
	    	   {
	    		   throw e;
	    	   }
	    //	   GenericMethods.clickElement(productReq_CB);
	       }


	public  POSPointsLandingPage clk_saveBtn() throws Exception
	{
		try
		{
		GenericMethods.clickElement(SPOP);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(SPOP);
		}
		catch(Exception e)
		{
			throw e;
		}
		POSPointsLandingPage PPLP=PageFactory.initElements(GenericMethods.driver, POSPointsLandingPage.class);
		return PPLP;
	}

	public  String EditSavePOSPT() throws Exception
	{
		POSPTitle.clear();
		GenericMethods.sendKeys(POSPTitle, GenericMethods.generateRandomString());
		b=POSPTitle.getText();
		/*String cde=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(PPSN, cde);*/
		//GenericMethods.clickElement(UPACCC);
	    return b;

	}
	
	public String getPosName()
	{
		POSPointName=POSPTitle.getAttribute("value");
		b=POSPointName;
		System.out.println("B is:::"+b);
		System.out.println("POSPointName::"+POSPointName);
		return POSPointName;
		
	}

	public  String clk_ProductRequiredChkbox() throws Exception
	{
		try
		{
		b=POSPTitle.getAttribute("value");	
		if(ProductRequired.isSelected())
		{
			System.out.println("Checkbox is selected");
		}
		else
		{
		GenericMethods.clickElement(AddEditPOSPoint.ProductRequired);
		}
		}
		catch(Exception e)
		{
			throw e;
		}
		return b;
	}

	
	
	public void fn_verifyPOSTax() throws Exception
	{
		try
		{
			arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(chkbox_tax);
		System.out.println("count:::"+count);
		for(int i=count;i>0;i--)
		{
			//WebElement element=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//font["+i+"]"));
			WebElement element=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[2]"));
			String data=	GenericMethods.getText(element);
			System.out.println("Data::::"+data);
			
			String parts1=data.split(" ")[0];
			arr.add(parts1);
			
		}
		Assert.assertEquals(arr.contains(AddPOSTax.TaxName),true);
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
	
	public void applyingPOSTaxes(String taxName1,String taxName2,String taxName3) throws Exception
	{
		//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr[1]/td/input
		//roomtype_txt=rmtype_name.getAttribute("value");
		int count1=GenericMethods.tr_count(chkbox_tax);
		for(int i=1;i<=count1;i++)
		{
			WebElement we=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[1]"));
			String tax=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[2]")).getText();
			
			String parts1=tax.split(" ")[0];
			System.out.println("Parts 1 came as::"+parts1);
			
			System.out.println(tax+"is there and selection came as:"+we.isSelected());
			if(we.isSelected())
			{
				System.out.println("Checkbox is selected");
				GenericMethods.clickElement(we);
			}
			
			//String tax=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]//td[2]/table//td")).getText();
			System.out.println("Tax name:"+tax);
		  //  arr.add(tax);
		    if(parts1.contains(taxName1))
		    {
		    	System.out.println("In if 1");
		    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[1]//input"));
		    	ele.click();
		    	//break;
		    }
		    if(parts1.contains(taxName2))
		    {
		    	System.out.println("In if 2");
		    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[1]//input"));
		    	ele.click();
		    	//break;
		    }
		    if(parts1.contains(taxName3))
		    {
		    	System.out.println("In if 3");
		    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[1]//input"));
		    	ele.click();
		    	//break;
		    }
		    
		}	
		
		
	}

	public boolean verifyingSelectionOfTaxes(String taxName1) throws Exception
	{
		
		int count1=GenericMethods.tr_count(chkbox_tax);
		for(int i=1;i<=count1;i++)
		{
			//WebElement we=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]/td/input"));
			//String tax=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr["+i+"]//td[2]/table//td")).getText();
			
			WebElement we=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[1]//input"));
			String tax=GenericMethods.driver.findElement(By.xpath("//td[@class='padingtd']//tr[22]//td[2]//tr["+i+"]/td[2]")).getText();
			
			String parts1=tax.split(" ")[0];
			System.out.println("Parts 1 came as::"+parts1);
			
			System.out.println(tax+"is there and selection came as:"+we.isSelected());
			if(we.isSelected() && parts1.equalsIgnoreCase(taxName1))
			{
				System.out.println("Checkbox is selected");
				//GenericMethods.clickElement(we);
				return true;
			}
			
		    
		}	
		
		return false;
		
	}
}
