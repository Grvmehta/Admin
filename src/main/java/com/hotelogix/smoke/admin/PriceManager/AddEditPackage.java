package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddEditPackage {
	@FindBy(xpath="//td[@class='comments']//input")
	public  WebElement namePackage;

	@FindBy(xpath="//input[@name='minStay']")
	public  WebElement lengthOfStay;

	@FindBy(xpath="//input[@name='pkgShortName']")
	public  WebElement shortName;

	@FindBy(xpath="//tbody/tr//td/textarea")
	public  WebElement description;

	@FindBy(xpath="//input[@value='Save']")
	public  WebElement save_BT;

	@FindBy(xpath="//form//table//tr[3]/td/table//td[2]/input")
	public  WebElement PackageName_TxtBox;

	@FindBy(xpath="//input[@name='minStay']")
	public  WebElement LengthFStay_TxtBox;

	@FindBy(xpath="//input[@name='pkgShortName']")
	public  WebElement PackageShortName;

	@FindBy(xpath="//td//textarea")
	public  WebElement Description_TxtBox;

	@FindBy(xpath="	//input[@name='next']")
	public  WebElement Save_Btn;

	@FindBy(xpath="//a[@id='addInclusionsLink']")
	public  WebElement inclusion_lnk;

	@FindBy(xpath="//table[@class='inclusion_tbl']//tr[3]//td[8]//input")
	public  WebElement edit_price;

	@FindBy(xpath="//form[@id='frmEditView']//tr[7]//tbody[1]//tr//th[2]")
	public  List<WebElement> added_incl;
	
	@FindBy(xpath="//tbody/tr//td/textarea")
	public static WebElement discription;


	public static ArrayList<String> arr=new ArrayList<String>();

	public static String windowID;
	public static String pkgName;
	public static String packageName;
	public static String FDPkg;

	public void fillPkgDetails(String NoOfNights) throws Exception
	{

		try
		{
 		String name=GenericMethods.generateRandomString();
		pkgName=name;
		Thread.sleep(2000);
		GenericMethods.sendKeys(lengthOfStay, NoOfNights);
		GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(description, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(namePackage, pkgName);
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  void fillPkgDetailsFD(String NoOfNights) throws Exception
	{

		//String name=GenericMethods.generateRandomString();
		FDPkg="Sample Package FD";
		GenericMethods.sendKeys(lengthOfStay, NoOfNights);
		GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(description, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(namePackage, pkgName);
	}


	public  void fillPkgDetailsFD1(String NoOfNights) throws Exception
	{

		//String name=GenericMethods.generateRandomString();
		FDPkg="Sample Inclusive of tax pkg FD";
		GenericMethods.sendKeys(lengthOfStay, NoOfNights);
		GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(description, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(namePackage, FDPkg);
	}

	public  void fillPkgDetailsFD2(String NoOfNights) throws Exception
	{

		//String name=GenericMethods.generateRandomString();
		FDPkg="Sample Choc Bar Pkg FD";
		GenericMethods.sendKeys(lengthOfStay, NoOfNights);
		GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(description, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(namePackage, FDPkg);
	}

	public  void fillPkgDetailsFD3(String NoOfNights) throws Exception
	{

		//String name=GenericMethods.generateRandomString();
		FDPkg="Sample Choc Bar Pkg FD";
		GenericMethods.sendKeys(lengthOfStay, NoOfNights);
		GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(description, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(namePackage, FDPkg);
	}


	public  void fillPkgDetailsFD4(String NoOfNights) throws Exception
	{

		//String name=GenericMethods.generateRandomString();
		FDPkg="Sample Weekly Rate pkg FD";
		GenericMethods.sendKeys(lengthOfStay, NoOfNights);
		GenericMethods.sendKeys(shortName, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(description, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(namePackage, FDPkg);
	}




	public  ListofPackagesInPackageMaster clickOnSave() throws Exception
	{
		try
		{
		GenericMethods.clickElement(save_BT);
		ListofPackagesInPackageMaster pageobj=	PageFactory.initElements(GenericMethods.driver, ListofPackagesInPackageMaster.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public  ListofPackagesInPackageMaster makePackage(String NoOfNights) throws Exception
	{
		try
		{
		fillPkgDetails(NoOfNights);

		clickOnSave();
		ListofPackagesInPackageMaster pageobj=	PageFactory.initElements(GenericMethods.driver, ListofPackagesInPackageMaster.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public ListofPackagesInPackageMaster AddingPackage() throws Exception
	{

		packageName=AddEditGroupPage.generateRandomString();
		GenericMethods.sendKeys(PackageName_TxtBox,  packageName);
		String shortName=AddEditGroupPage.generateRandomString();
		GenericMethods.sendKeys(PackageShortName, shortName);
		GenericMethods.sendKeys(LengthFStay_TxtBox, "2");
		GenericMethods.sendKeys(Description_TxtBox,"Alot Inside the package" );
		GenericMethods.clickElement(Save_Btn);
		ListofPackagesInPackageMaster LOP=PageFactory.initElements(GenericMethods.driver, ListofPackagesInPackageMaster .class);
		return LOP;

	}

	public  AddMoreInclusions checkadded_addon() throws Exception
	{
		


		try
		{
		GenericMethods.clickElement(inclusion_lnk);
		}
		catch(Exception e)
		{
	    WebElement ele=GenericMethods.ExplicitWait(inclusion_lnk, "//a[@id='addInclusionsLink']");
        ele.click();
		}

		AddMoreInclusions AMI=PageFactory.initElements(GenericMethods.driver, AddMoreInclusions.class);
		return AMI;
	}

	public  void edit_defaultrate() throws Exception
	{
		try
		{
	    edit_price.clear();
	    GenericMethods.sendKeys(edit_price, "150.00");
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public void verify_addedIncl() throws Exception
	{
		try
		{
			ArrayList<String> arr=new ArrayList<String>();
		int incl_count=GenericMethods.tr_count(added_incl);
		for(int i=1;i<=incl_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//form[@id='frmEditView']//tr[7]//tbody[1]//tr["+i+"]//td[2]")).getText();
			arr.add(data);
			if(data.equals(AddMoreInclusions.a))
			{
				Assert.assertEquals(data.equals(AddMoreInclusions.a),true);
				break;
			}
			
		}
		Assert.assertEquals(arr.contains(AddMoreInclusions.a), true);
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

	public ListofPackagesInPackageMaster fillPkgDetail(int iTestCaseRow) throws Exception
	{

		try
		{
		String name=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName));
		pkgName=name;
		
		
		
		GenericMethods.sendKeys(lengthOfStay, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_LengthOfStay)));
		Thread.sleep(2000);
		GenericMethods.sendKeys(shortName, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ShortName)));
		Thread.sleep(2000);
		GenericMethods.sendKeys(discription, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Description)));
		Thread.sleep(2000);
		GenericMethods.sendKeys(namePackage, pkgName);
	    GenericMethods.clickElement(save_BT);
		
		
		}
		catch(Exception e)
		{
			throw e;
		}
		
		
		ListofPackagesInPackageMaster LOPM=PageFactory.initElements(GenericMethods.driver,ListofPackagesInPackageMaster.class);
		return LOPM;
	}



}
