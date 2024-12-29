package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class AttachPackagePage1 {



	public static String textTitle;



	@FindBy(xpath="//input[@id='chkId_1']")
	public static WebElement Radio_Btn1;


	@FindBy(xpath="//input[@value='Attach']")
	public static WebElement Attach_Btn;


	@FindBy(xpath="//form[@id='frmListView']//table[2]")
	public static WebElement tabletrs;

	@FindBy(xpath="//div[text()='Attach Package']")
	public static WebElement pageTitle;

	@FindBy(xpath="//form//table[2]//tr[2]//td[3]")
	public static WebElement PkgTitle;

	@FindBy(xpath="//table[@class='poptable'][2]//tr")
	public List<WebElement> rowcount;





    public static String data(){

    	String value1 = null;


		List<WebElement> rows= tabletrs.findElements(By.tagName("tr"));
		//int rsize=rows.size();




		for(int rnum=0;rnum<1;rnum++)

		{

	List<WebElement> columns=rows.get(rnum).findElements(By.xpath("//form[@id='frmListView']//table[2]//td[3]"));
int  colsize=columns.size();
System.out.println(colsize);


		for(int cnum=0;cnum<columns.size();cnum++)

		{


		String value=columns.get(cnum).getText();
		int i=value.indexOf("(");

        //String[] a=value.split("(");
         value1=value.substring(0, i).trim();
		if(value1.equals(attachPackages.c.trim()))
		{
			System.out.println(value1 +" matched");
			break;

		}

       }

}
		Assert.assertEquals(value1, attachPackages.c.trim(),"Pass");
		return value1;
}

public  void VerifyPage() throws InterruptedException{

String Wintitle=GenericMethods.driver.getTitle();
String titlePage=GenericMethods.getText(pageTitle);
if(Wintitle.equals(titlePage)){
	System.out.println(Wintitle + " page title showing");
          }

}


public GroupBookingSource AttachPackage() throws Exception
{

try
{
    textTitle=GenericMethods.getText(PkgTitle);
    System.out.println(textTitle + " is being attached to group");
    GenericMethods.clickElement(Radio_Btn1);
    GenericMethods.clickElement(Attach_Btn);
    GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
    return GBS;
}
catch(Exception e)
{
	throw e;
	
}

}



public GroupBookingSource attach_specificPkg() throws Exception
{

	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(rowcount);
	for(int i=2;i<=count;i++)
	{
		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='poptable'][2]//tr["+i+"]//td[3]")).getText();
		int index=data.lastIndexOf("(");
		textTitle=data.substring(0, index);
		arr.add(textTitle.trim());
		if(textTitle.contains(AddEditPackage.pkgName))
		{
			Assert.assertEquals(textTitle.contains(AddEditPackage.pkgName), true);
			GenericMethods.driver.findElement(By.xpath("//table[@class='poptable'][2]//tr["+i+"]//td[2]/input")).click();
			break;
		}
	}
	Assert.assertEquals(arr.contains(AddEditPackage.pkgName), true);
	
	GenericMethods.clickElement(Attach_Btn);
	GroupBookingSource GBS=PageFactory.initElements(GenericMethods.driver, GroupBookingSource.class);
	return GBS;
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
