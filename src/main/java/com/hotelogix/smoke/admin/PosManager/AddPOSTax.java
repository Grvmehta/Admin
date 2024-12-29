package com.hotelogix.smoke.admin.PosManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddPOSTax {

	@FindBy(xpath="//input[@id='taxNameMulName_0']")
	public static WebElement TaxTitle;

	@FindBy(xpath="//input[@id='taxShortName']")
	public static WebElement TaxIDSN;

	@FindBy(xpath="//input[@type='radio']")
	public static WebElement TPRadio;

	@FindBy(xpath="//input[@name='tax']")
	public static WebElement Tax;

	@FindBy(xpath="//textarea[@id='descriptionMulDes_0']")
	public static WebElement TaxDesc;

	@FindBy(xpath="//input[@type='submit']")
	public static WebElement SaveTaxPOS;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public static WebElement select_code;

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
	
	
	@FindBy(id="isTaxble")
	public  WebElement isTaxable;
	
	@FindBy(xpath="//table[@id='taxOnTaxTbl']/tbody/tr[1]/td[1]")
	public static List<WebElement> POST;
	
	
	@FindBy(xpath="//table[@id='taxOnTaxTbl']/tbody/tr")
	public static List<WebElement> taxesCount;
	
	


	public static String TaxName;
	public static String POSTaxAcntTitle;
    public static String POSTaxAcntCode;
    
    public static String posTax1="CGST";
    public static String posTax2="SGST";
    public static String posTaxOnTax1="CESS";

	public static void accountCode() throws Exception
    {
		try
		{
	   GenericMethods.clickElement(addnewaccnt);
	   POSTaxAcntTitle=GenericMethods.generateRandomString();
 	   GenericMethods.sendKeys(acc_title, POSTaxAcntTitle);
 	   Thread.sleep(2000);
 	   POSTaxAcntCode=GenericMethods.generateRandomString();
 	   GenericMethods.sendKeys(acc_code, POSTaxAcntCode);
 	   Thread.sleep(2000);
 	   GenericMethods.clickElement(acc_savebtn);
 	   GenericMethods.ActionOnAlert("Accept");
		}
		catch(Exception e)
		{
			throw e;
		}
    }


	public String AddPTax() throws Exception
	{

		try
		{
		TaxName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxTitle, TaxName);

		String cde=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxIDSN, cde);

		accountCode();
		Thread.sleep(2000);
		//GenericMethods.selectElement(select_code, "aghPx");


		GenericMethods.clickElement(TPRadio);
        GenericMethods.sendKeys(Tax, "10");

        String efg=GenericMethods.generateRandomString();
        GenericMethods.sendKeys(TaxDesc, efg);

		return TaxName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public String AddPOSTax1() throws Exception
	{

		try
		{
			TaxName=posTax1;
			
		//TaxName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxTitle, TaxName);

		String cde=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxIDSN, cde);

		accountCode();
		Thread.sleep(2000);
		//GenericMethods.selectElement(select_code, "aghPx");


		GenericMethods.clickElement(TPRadio);
        GenericMethods.sendKeys(Tax, "2.5");

       // String efg=GenericMethods.generateRandomString();
        GenericMethods.sendKeys(TaxDesc, TaxName);

		return TaxName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public String AddPOSTax2() throws Exception
	{

		try
		{
			TaxName=posTax2;
			
		//TaxName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxTitle, TaxName);

		String cde=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxIDSN, cde);

		accountCode();
		Thread.sleep(2000);
		//GenericMethods.selectElement(select_code, "aghPx");


		GenericMethods.clickElement(TPRadio);
        GenericMethods.sendKeys(Tax, "2.5");

       // String efg=GenericMethods.generateRandomString();
        GenericMethods.sendKeys(TaxDesc, TaxName);

		return TaxName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	public String AddPOSTaxForTaxOnTax() throws Exception
	{

		try
		{
			TaxName=posTaxOnTax1;
			
		//TaxName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxTitle, TaxName);

		String cde=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(TaxIDSN, cde);

		accountCode();
		Thread.sleep(2000);
		//GenericMethods.selectElement(select_code, "aghPx");


		GenericMethods.clickElement(TPRadio);
        GenericMethods.sendKeys(Tax, "10");

       // String efg=GenericMethods.generateRandomString();
        GenericMethods.sendKeys(TaxDesc, TaxName);

		return TaxName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	

	
	public POSTaxListPage SaveTax() throws Exception
	{
		try
		{
		GenericMethods.clickElement(SaveTaxPOS);
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(SaveTaxPOS);
		}
		catch(Exception e)
		{
			throw e;
		}
		POSTaxListPage PTLP=PageFactory.initElements(GenericMethods.driver, POSTaxListPage.class);
		return PTLP;
	}
	
	public void enableTaxOnTax() throws Exception
	{
		GenericMethods.clickElement(isTaxable);
		int count1=GenericMethods.tr_count(POST);
		System.out.println("Count is"+count1);
		for(int i=1;i<=count1;i++)
		{
			String s1=GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody["+i+"]/tr[1]/td[2]")).getText();
			System.out.println("s1"+s1);
			if(s1.contains(posTax1 ))
			{
				System.out.println("In first IF");
				GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody["+i+"]/tr[1]/td[1]//input")).click();
			}
			 if(s1.contains(posTax2 ))
			{
				 System.out.println("In 2nd IF");
				GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody["+i+"]/tr[1]/td[1]//input")).click();
			}
	}
		GenericMethods.clickElement(SaveTaxPOS);
	}
	
	public void verifyingTaxOnTax() throws Exception
	{
		//GenericMethods.clickElement(isTaxable);
		int count1=GenericMethods.tr_count(taxesCount);
		System.out.println("Count is"+count1);
		for(int i=1;i<=count1;i++)
		{
			String s1=GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody[1]/tr["+i+"]/td[2]")).getText();
			System.out.println("s1"+s1);
			if(s1.contains(posTax1 ))
			{
				System.out.println("In first IF");
			boolean isSelected=	GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody/tr["+i+"]/td[1]//input")).isSelected();
			Assert.assertTrue(isSelected);
			}
			 if(s1.contains(posTax2 ))
			{
				 System.out.println("In 2nd IF");
				 boolean isSelected=	GenericMethods.driver.findElement(By.xpath("//table[@id='taxOnTaxTbl']/tbody/tr["+i+"]/td[1]//input")).isSelected();
				Assert.assertTrue(isSelected);		
			}
	}
		//GenericMethods.clickElement(SaveTaxPOS);
	}
}
