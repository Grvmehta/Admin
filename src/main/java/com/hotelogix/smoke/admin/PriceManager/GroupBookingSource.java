package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.admin.Console.AddTravelAgentPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class GroupBookingSource {


public static String status="http://hotelogix.stayezee.com/images/on.GIF";





@FindBy(xpath="//a[text()='Attach Package']")
public static WebElement AttachPackage;


@FindBy(xpath="  //a[@title='Add a Group ']")
public static WebElement AddGroup_Btn;

 @FindBy(xpath="//form[@name='frmListView']//table//tr[2]/td")
public static WebElement VerifyGroupAddMsg;


 @FindBy(xpath="//table[@class='list_viewnew']//tr[2]/td[8]/a/img")
 public static WebElement StatusIcon;


 @FindBy(xpath=" //a[text()='Manage Source(s)']")
 public static WebElement ManageSource_link;


 @FindBy(xpath=" //form[@name='frmListView']//table//tr[3]//table//tr[2]//table//td")
 public static WebElement SourceColData;

 @FindBy(xpath="//select[@name='maxEntries']")
 public static WebElement view_DepDwn;


 @FindBy(xpath="//form[@name='frmListView']//table//tr[3]//table//tr[2]//table//tr[2]/td")
 public static WebElement SourceColData1;

 @FindBy(xpath="//table[@class='list_viewnew']/tbody//tr//input[@type='checkbox']")
	public static List<WebElement> checkBox;

@FindBy(xpath="//table[@class='list_viewnew']//tr")
public List<WebElement> rowcount;

 @FindBy(xpath="//*[@id='row_440']/td[6]/table/tbody/tr/td[1]")
 public static WebElement AttachedPackage;



 public static attachPackages attachPackage() throws Exception
	{
		//windowID=GenericMethods.GetCurrentWindowID();
		GenericMethods.clickElement(AttachPackage);
		attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
		return pageobj;
	}



public AttachPackagePage1 AttachPackage() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
    int count=GenericMethods.tr_count(rowcount);
    for(int i=2;i<=count;i++)
    {
	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	    arr.add(data);
	    if(data.contains(AddEditGroupPage.gname))
	    {
	    	Assert.assertEquals(data.contains(AddEditGroupPage.gname), true);
	    	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[7]//a[3]")).click();
	        break;
	    }

   }
    Assert.assertEquals(arr.contains(AddEditGroupPage.gname), true);

	AttachPackagePage1 APP1=PageFactory.initElements(GenericMethods.driver,AttachPackagePage1.class );
	return APP1;
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

public AddEditGroupPage AddGroup() throws Exception{

	try
	{
	GenericMethods.clickElement(AddGroup_Btn);
	AddEditGroupPage AEG=PageFactory.initElements(GenericMethods.driver,AddEditGroupPage.class);
	return AEG;
	}
	catch(Exception e)
	{
		throw e;
	}
	
}


public  void verifyGroup(String value) throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
    int count=GenericMethods.tr_count(rowcount);
    for(int i=2;i<=count;i++)
    {
    	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
    	arr.add(str);
    	if(str.contains(AddEditGroupPage.gname))
    	{
    		Assert.assertEquals(str.contains(AddEditGroupPage.gname), true);
    		String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]//img")).getAttribute("src");
    		Assert.assertEquals(src.contains(value), true);
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(AddEditGroupPage.gname), true);
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




public ManageSource MangaeSource_link() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
    int count=GenericMethods.tr_count(rowcount);
    for(int i=2;i<=count;i++)
    {
	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	    arr.add(data);
	    if(data.contains(AddEditGroupPage.gname))
	    {
	    	Assert.assertEquals(data.contains(AddEditGroupPage.gname), true);
	    	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]//a[2]")).click();
	        break;
	    }

    }
    Assert.assertEquals(arr.contains(AddEditGroupPage.gname), true);
    ManageSource MS=PageFactory.initElements(GenericMethods.driver,ManageSource.class);
	return MS;
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

public void verifyWebSource() throws Exception
{
	try
	{
     ArrayList<String> arr=new ArrayList<String>();
  
     int count=GenericMethods.tr_count(rowcount);
     for(int i=2;i<=count;i++)
     {
 	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
        arr.add(data);
        if(data.contains(AddEditGroupPage.gname))
        {
        	 List<WebElement> ele =GenericMethods.driver.findElements(By.xpath("//td[5]/table//tr"));
        int count1=GenericMethods.tr_count(ele);
        for(int j=1;j<=count1;j++)
        {
        	String source=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/table//tr["+j+"]/td")).getText();
        	if(source.contains("Web"))
        	{
        		Assert.assertEquals(source.contains("Web"), true);
        		break;
        	}
        }
        }
      break;
     }
     
	Assert.assertEquals(arr.contains(AddEditGroupPage.gname), true);
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





public void verifyTASource() throws Exception
{
	try
	{
     ArrayList<String> arr=new ArrayList<String>();
     int count=GenericMethods.tr_count(rowcount);
     for(int i=2;i<=count;i++)
     {
 	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
        arr.add(data);
        if(data.contains(AddEditGroupPage.gname))
        {
        List<WebElement> ele=GenericMethods.driver.findElements(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/table//tr"));
        int count1=GenericMethods.tr_count(ele);
        for(int j=1;j<=count1;j++)
        {
        	String source=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[5]/table//tr["+j+"]/td")).getText();
        	if(source.contains(AddTravelAgentPage.TaName))
        	{
        		Assert.assertEquals(source.contains(AddTravelAgentPage.TaName), true);
        		break;
        	}
        }
        }
      break;
     }
     
	Assert.assertEquals(arr.contains(AddEditGroupPage.gname), true);
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



public void VerifyAttachedPackage() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	Thread.sleep(5000);
    int count=GenericMethods.tr_count(rowcount);
    for(int i=2;i<=count;i++)
    {
	    String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
       arr.add(data);
       if(data.contains(AddEditGroupPage.gname))
       {
        Assert.assertEquals(data.contains(AddEditGroupPage.gname), true);
       	String pkg=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]")).getText();
       	if(pkg.contains(AttachPackagePage1.textTitle))
       	{
       		Assert.assertEquals(pkg.contains(AttachPackagePage1.textTitle), true);
       		break;
       	}
       }
       
     
    }
    
	Assert.assertEquals(arr.contains(AddEditGroupPage.gname), true);
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


public  void view() throws Exception
{

	try
	{
    GenericMethods.selectElement(view_DepDwn, "All");
    GenericMethods.ActionOnAlert("Accept");
    GenericMethods.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 
	}
	catch(Exception e)
	{
		throw e;
	}
}






}
