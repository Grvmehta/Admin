package com.hotelogix.smoke.admin.PosManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AddPOSProduct {

	@FindBy(xpath="//input[@id='prodNameMulName_0']")
	public static WebElement SamplePOSProdTitle;

	@FindBy(xpath="//input[@name='prodCode']")
	public static WebElement POSProdID;

	@FindBy(xpath="//select[@id='posCat']")
	public static WebElement POSCategory;

	@FindBy(xpath="//input[@name='price']")
	public static WebElement Price;

	@FindBy(xpath="//select[@name='unit']")
	public static WebElement PerUnit;

	@FindBy(xpath="//input[@id='btnSave']")
	public static WebElement SavePOSP;

	@FindBy(xpath="//input[@id='btnSave']")
	public static WebElement SavePOSProduct;

	@FindBy(xpath="//select[@name='posCatId']//option")
	public static List<WebElement> productCat;

	@FindBy(xpath="//input[@name='prodNameMulName[]']")
	public static WebElement productTitle;

	@FindBy(xpath="//input[@name='prodCode']")
	public static WebElement productID;

	@FindBy(xpath="//select[@name='posCatId']")
	public static WebElement category;

	@FindBy(xpath="//input[@name='price']")
	public static WebElement price;

	@FindBy(xpath="//select[@name='unit']")
	public static WebElement Unit_drpDwn;

	@FindBy(xpath="//input[@name='Submit5']")
	public static WebElement savePOSProduct_BT;
	
	@FindBy(xpath="//*[@id='posAppTaxTdId']/table/tbody/tr")
	public List<WebElement> chkbox_tax;
	
	

	public List<String> verifyPOSCategory() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		Select sel=new Select(category);
		List<WebElement> we=sel.getOptions();
		for(WebElement we1:we)
		{	
			arr.add(we1.getText());
			
		}
		return arr;
		}
		catch(Exception e)
		{
			throw e;
		}
	
	}

	public static String productName;
	
	public  void fn_fillProductDetails() throws Exception
	{
		try
		{
		productName=GenericMethods.generateRandomString();
		GenericMethods.sendKeys(productID, GenericMethods.generateRandomString());
		GenericMethods.sendKeys(productTitle,productName);
		GenericMethods.selectElementByIndex(Unit_drpDwn, 3);
		GenericMethods.clickElement(price);
		price.clear();
		GenericMethods.sendKeys(price, "100");
		GenericMethods.selectElement(category, AddEditPOSCategory.name);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  POSProductsList fn_addPOSProduct() throws Exception
	{
		try
		{
		fn_fillProductDetails();
	
		GenericMethods.clickElement(savePOSProduct_BT);

		POSProductsList pageobj=PageFactory.initElements(GenericMethods.driver, POSProductsList.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  POSProductsList fn_addPOSProductWithTaxes(String taxName1,String taxName2,String taxName3) throws Exception
	{
		try
		{
		fn_fillProductDetails();
		applyingPOSTaxes(taxName1,taxName2,taxName3);
		GenericMethods.clickElement(savePOSProduct_BT);

		POSProductsList pageobj=PageFactory.initElements(GenericMethods.driver, POSProductsList.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public static void fn_enterPOSProdfields() throws Exception
	{
		GenericMethods.sendKeys(SamplePOSProdTitle, "Sample POS Prod Title1.1");
        GenericMethods.sendKeys(POSProdID, "21");
        GenericMethods.selectElement(POSCategory, "Sample Full Day Tour");
        Price.clear();
        GenericMethods.sendKeys(Price, "500");
        GenericMethods.selectElement(PerUnit, "Dozen");

	}

	public static AddPOSProduct fn_SavePOSProduct() throws Exception
	{
		GenericMethods.clickElement(SavePOSProduct);

		AddPOSProduct POPLP=PageFactory.initElements(GenericMethods.driver, AddPOSProduct.class);
		return POPLP;

	}
	
	public void applyingPOSTaxes(String taxName1,String taxName2,String taxName3) throws Exception
	{
		//td[@class='padingtd']//table//tbody//tr[17]/td[2]/table/tbody/tr[1]/td/input
		//roomtype_txt=rmtype_name.getAttribute("value");
		int count1=GenericMethods.tr_count(chkbox_tax);
		for(int i=1;i<=count1;i++)
		{
			WebElement we=GenericMethods.driver.findElement(By.xpath("//*[@id='posAppTaxTdId']/table/tbody/tr["+i+"]/td[1]/input"));
			String tax=GenericMethods.driver.findElement(By.xpath("//*[@id='posAppTaxTdId']/table/tbody/tr["+i+"]/td[2]")).getText();
			
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
		    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//*[@id='posAppTaxTdId']/table/tbody/tr["+i+"]/td[1]/input"));
		    	ele.click();
		    	//break;
		    }
		    if(parts1.contains(taxName2))
		    {
		    	System.out.println("In if 2");
		    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//*[@id='posAppTaxTdId']/table/tbody/tr["+i+"]/td[1]/input"));
		    	ele.click();
		    	//break;
		    }
		    if(parts1.contains(taxName3))
		    {
		    	System.out.println("In if 3");
		    	WebElement ele=GenericMethods.driver.findElement(By.xpath("//*[@id='posAppTaxTdId']/table/tbody/tr["+i+"]/td[1]/input"));
		    	ele.click();
		    	//break;
		    }
		    
		}	
		
		
	}


}
