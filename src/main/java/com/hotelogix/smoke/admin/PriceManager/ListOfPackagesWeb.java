package com.hotelogix.smoke.admin.PriceManager;

import java.util.ArrayList;
import java.util.List;

//import org.omg.CosNaming.NamingContextExtHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.BaseClass;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfPackagesWeb {
	public static String windowID;
	public static String statusDeactive;
	public static String statusActive;
	@FindBy(xpath="//div[@id='listing-icons']//ul//li[4]/a")
	public static WebElement attachPackageImg_BT;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a[text()='Configure']")
	public static WebElement configure_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a[text()='Add Activation Date']")
	public static WebElement addActivationDate_link;

	@FindBy(xpath="//tbody//tr//td[7]")
	public static WebElement addActivationDate;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[8]/a[text()='Edit']")
	public static WebElement edit_linkWeb;

	@FindBy(xpath="//table//tr//td[9]/img")
	public static WebElement status;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[3]")
	public static WebElement attachedpkg;

	@FindBy(xpath="//div[@class='headingtxt']//tbody//td[2]")
	public static WebElement pge_title;

	@FindBy(xpath="//form[@id='frmListView']//tbody//td[@id='errorTd']")
	public static WebElement error_msg;

	@FindBy(xpath="//td[@class='error']")
	public static WebElement relational_saveMsg;

	@FindBy(xpath="//input[@name='id[]']")
	public static List<WebElement> chkbox;

	@FindBy(xpath="//table[@class='list_viewnew']//tr")
	public static List<WebElement> trcount;

	@FindBy(xpath="//select[@name='maxEntries']")
	public static WebElement view_dropdwn;


	public static ArrayList<String> arr=new ArrayList<String>();
    public static String actiDate_lnkWeb="Add Activation Date";
    public static String src_off="off.GIF";
    public static String ActivForever="Activated Forever";



	public static void verifyPage() throws InterruptedException
	{
		String text=GenericMethods.getText(pge_title);
		Assert.assertEquals(text, "List of Packages (Web)");
	}

	public  void view_All() throws Exception
	{
		try
		{		GenericMethods.selectElement(view_dropdwn, "All");

			boolean b=GenericMethods.isAlertPresent();
			if(b==true){
		GenericMethods.Alert_Accept();
			}
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  String verifyMsg_attachRelational() throws Exception
	{
		try
		{
		String text=GenericMethods.getText(error_msg);
		return text;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public String  verifyMsg_relationalEdit() throws Exception
	{
		try
		{
		String text=GenericMethods.getText(relational_saveMsg);
		return text;
		//System.out.println("Package Copy of "+attachPackages.c+"saved successfully.");
		}catch(Exception e){
			throw e;
		}
	}

	public static PackageDetailsWeb clck_EditlnkWeb() throws Exception
    {
		int row_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=row_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			String[] lines=data.split("\n");
   			String name1=lines[0];
   			//String[] arr=name1.split(" ");
   			//String fword=arr[0];
   			//String rest=arr[1];
   			//System.out.println(arr);
   			if(name1.contains("Copy"))
   			{
   				System.out.println("Package name contains Copy word");
   			}
   			else
   			{
   				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
   				break;
   			}

		}

    	PackageDetailsWeb pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
	    return pageobj;
    }


	public  attachPackages attachPackage() throws Exception
	{
		try
		{
		
		GenericMethods.clickElement(attachPackageImg_BT);

		attachPackages pageobj=	PageFactory.initElements(GenericMethods.driver, attachPackages.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static PackageDetailsWeb configurePackageWeb() throws Exception{

		GenericMethods.clickElement(configure_link);

		PackageDetailsWeb pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
	    return pageobj;
	}

	public static AddActivationDateWeb fn_NavToActivationDateWeb() throws Exception{

		GenericMethods.clickElement(addActivationDate_link);
		AddActivationDateWeb pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateWeb.class);
		return pageobj;
	}

	public static void verifyAddActivationDate_link() throws Exception{
		Boolean result=GenericMethods.checkElementDisplay(addActivationDate_link);
		if(result.TRUE){
			System.out.println("AddActivationDate Link Displaying");
		}else
		{
			System.out.println("AddActivationDate Link not Displaying");
		}
	}


	public static void verifyForeverActivationOfWebPkg() throws Exception{

		Boolean abcd=GenericMethods.checkElementDisplay(addActivationDate);
		String abc=GenericMethods.getText(addActivationDate);

		if(abcd.TRUE){
			System.out.println("'Add Activation Date' link changed to 'Activated Forever' text");

		}else{
			System.out.println("link not changed");
		}

		Assert.assertEquals(abc, "Activated Forever");

		statusActive=status.getAttribute("src");
		if(statusActive.equals(statusDeactive)){
			System.out.println("status not changed");
		}else{
			System.out.println("status changed to Activate");
		}

	}

	public String verify_pageMsg() throws Exception
    {
		try
		{
    	String text=GenericMethods.getText(error_msg);
    	return text;
		}
		catch(Exception e)
		{
			throw e;
		}
    }

	public static void verifyattachedpkg() throws InterruptedException
	{

		String name=GenericMethods.getText(attachedpkg);
		if(name.contains("*"))
		{
			System.out.println("Attached package contains * ");
		}
		else
		{
			System.out.println("Attahced package does not contains * ");
		}
		//Assert.assertEquals(name,attachPackages.pkg_attached);
	}


	// new verification methods //

	static ArrayList<String> list1=new ArrayList<String>();
	static ArrayList<String> list2=new ArrayList<String>();

	public static void getPkgID1() throws Exception
	{
		try
		{
		int count1=GenericMethods.tr_count(chkbox)+1;
		for(int i=2;i<=count1;i++)
		{
			String url1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getAttribute("href");
			String ID1=url1.substring(url1.lastIndexOf("/")+1);
			list1.add(ID1);
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public static void getPkgID2() throws Exception
	{
		try
		{
		int count2=GenericMethods.tr_count(chkbox)+1;
		for(int j=2;j<=count2;j++)
		{
			String url2=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+j+"]//td[8]/a")).getAttribute("href");
			String ID2=url2.substring(url2.lastIndexOf("/")+1);
			list2.add(ID2);
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public static String b;
	public static String name1;

	public  String verifyPackage_name() throws Exception
    {
		try
		{
   	/* list2.removeAll(list1);
   	 b="";
   	 for(String str1 : list2)
   	 {
   		 b+=str1;
   	 }
   	 System.out.println(b);*/
	ArrayList<String> arr=new ArrayList<String>();
   	 int count=GenericMethods.tr_count(trcount);
   	// String data1=null;
   	 for(int i=2;i<=count;i++)
   	 {
   		 String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
 		arr.add(data.split("\n")[0]);		
   		 if(data.contains(attachPackages.c.trim()))
   		 {
/*   			String pkg_name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
   			 String[] lines=pkg_name.split("\n");
   			 String name1=lines[0];
   			 System.out.println(name1);
*/   			 //String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).getAttribute(name)
   			 Assert.assertEquals(data.contains(attachPackages.c.trim()),true);
 			String actImg =GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]/img")).getAttribute("src");
            Assert.assertEquals(actImg.endsWith("off.GIF"),true);
            String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[9]/img")).getAttribute("src");
   			Assert.assertEquals(status.endsWith("off.GIF"), true);
            break;
   		 }

   	 }

		 Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
		}
		catch(AssertionError e)
		{
			throw e;
		}
		catch(Exception e)
		{
			throw e;
		}
   	return name1;
		

   }


	public  String verifyPkg_Relational(String value1,String value2) throws Exception
	{
		try
		{
		/*list2.removeAll(list1);
	   	 b="";
	   	 for(String str1 : list2)
	   	 {
	   		 b+=str1;
	   	 }
	   	 System.out.println(b);*/
		ArrayList<String> arr=new ArrayList<String>();
	   	int count=GenericMethods.tr_count(trcount);
	   	for(int i=2;i<=count;i++)
	   	{
	   		 String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();	   		 
     		 arr.add(data.split("\n")[0]);
	   		
     		 if(data.contains(attachPackages.c))
             {
                 Assert.assertEquals(data.contains("Copy of "+attachPackages.c+"*"),true);
                 String activation=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/img")).getAttribute("src");
                 Assert.assertEquals(activation.endsWith(value1),true);
                 String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]/img")).getAttribute("src");
                 Assert.assertEquals(activation.endsWith(value1),true);
                 String configureLnk=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).getText();
                 Assert.assertEquals(configureLnk, value2);             
                 break;
             }
	   	}
	   	
	   	Assert.assertEquals(arr.contains("Copy of "+attachPackages.c+"*"), true);
	   	return name1;
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







	public static String s;
	public  PackageDetailsWeb confgr_attachedPkgWeb() throws Exception

	{
		try
		{
		/*list2.removeAll(list1);
	    s="";
	    for (String str : list2)
	    {
	    	s+=str;
	    }
		System.out.println(list2);*/
	     ArrayList<String> arr=new ArrayList<String>();
		int item_count=GenericMethods.tr_count(trcount);
		//String data1=null;		
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).click();
				break;
			}
		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);

		PackageDetailsWeb PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
    	return PDW;
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


	public  PackageDetailsWeb confgr_CRattachedPkgWeb() throws Exception

	{
		try
		{
		/*list2.removeAll(list1);
	    s="";
	    for (String str : list2)
	    {
	    	s+=str;
	    }
		System.out.println(list2);*/
	     ArrayList<String> arr=new ArrayList<String>();
		int item_count=GenericMethods.tr_count(trcount);
		//String data1=null;		
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).click();
				break;
			}
		}
		Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);

		PackageDetailsWeb PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
    	return PDW;
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

	
	
	
	public  void verifyAddActivationDate_linkWeb(String value) throws Exception
	{
		try
		{
			ArrayList<String> arr=new ArrayList<String>();
		int item_count=GenericMethods.tr_count(trcount);
		//String data1=null;
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			//System.out.println(data);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/a")).getText();
				Assert.assertEquals(str, value);
				break;
			}
		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
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

	public  AddActivationDateWeb NavTo_ActivationDateWeb() throws Exception
	{
		try
		{
			ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++)
		{

			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
				break;
			}

		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()),true);
			AddActivationDateWeb pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateWeb.class);
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

	
	public  AddActivationDateWeb NavTo_CRActivationDateWeb() throws Exception
	{
		try
		{
			ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++)
		{

			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
				break;
			}

		}
		Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"),true);
			AddActivationDateWeb pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateWeb.class);
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
	
	
	
	public  void verifyActivatedForever_textWeb(String value1,String value2) throws Exception
	{
		try
		{
			Thread.sleep(9000);
		ArrayList<String> arr=new ArrayList<String>();
		int tble_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=tble_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
            arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()),true);
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]")).getText();
				Assert.assertEquals(str, value1);
				String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]//img")).getAttribute("src");
			    Assert.assertEquals(src.endsWith(value2), true);
				break;
			}

		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
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

	
	public  void CRverifyActivatedForever_textWeb(String value1,String value2) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int tble_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=tble_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
            arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()),true);
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]")).getText();
				Assert.assertEquals(str, value1);
				String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]//img")).getAttribute("src");
			    Assert.assertEquals(src.endsWith(value2), true);
				break;
			}

		}
		Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);
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
	
	
	public static void afterPkgattach_status() throws InterruptedException
    {
    	int item_count=GenericMethods.tr_count(chkbox)+1;
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[8]/a")).getAttribute("href");
			//System.out.println(data);
			if(data.contains(ListOfPackagesWeb.b))
			{
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/img")).getAttribute("src");
				String extracted_img1=str.substring(str.lastIndexOf("/")+1);
				Assert.assertEquals(extracted_img1, src_off);
				String status_img=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[9]/img")).getAttribute("src");
				String extracted_img2=status_img.substring(status_img.lastIndexOf("/")+1);
				Assert.assertEquals(extracted_img2, src_off);
				System.out.println("Pass");
				break;
			}
		}
    }


   public  PackageDetailsWeb click_EditLinkWebPkg() throws Exception
   {
	   try
	   {
		   ArrayList<String> arr=new ArrayList<String>();
	   int tble_cnt=GenericMethods.tr_count(trcount);
	   for(int i=2;i<=tble_cnt;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			//System.out.println(data);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
				break;
			}
		}
	    Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
		PackageDetailsWeb PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
    	return PDW;
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

   
   
   public  PackageDetailsWeb clickEdit_relationalWebPkgFrmFD() throws Exception
   {
	   try
	   {
		   ArrayList<String> arr=new ArrayList<String>();
	   int tble_cnt=GenericMethods.tr_count(trcount);
	   for(int i=2;i<=tble_cnt;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			//System.out.println(data);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
				break;
			}
		}
	    Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);
		PackageDetailsWeb PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
    	return PDW;
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


   public  void verify_GridPkgWeb() throws Exception
   {
	   try
	   {
		   
		   ArrayList<String> arr=new ArrayList<String>();
	   int row_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=row_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				String grid_pkg=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
				String[] lines=grid_pkg.split("\n");
	   			String name1=lines[0];
	   		    System.out.println(name1);
	   		    String exp_name=attachPackages.c.concat(" [GRID]");
	   		    Assert.assertEquals(name1,exp_name);
  			    System.out.println("Pass");
  			  
   			    break;
   			    
			}
		}
		
		Assert.assertEquals(arr.contains(attachPackages.c.trim()+" [GRID]"), true);
		
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


   public  String verifyCRPackage_name() throws Exception
   {
	   try
	   {
  	/* list2.removeAll(list1);
  	 s="";
  	 for(String str1 : list2)
  	 {
  		 s+=str1;
  	 }
  	 System.out.println(s);*/
	   
	   ArrayList<String> arr=new ArrayList<String>();
  	 int count=GenericMethods.tr_count(trcount);
  	 for(int i=2;i<=count;i++)
  	 {
  		 String name1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		 arr.add(name1.split("\n")[0]); 		 
  		 if(name1.contains(attachPackages.c.trim()))
  		 {
  			
  			 Assert.assertEquals(name1.contains(attachPackages.c.trim()),true);
  			 Assert.assertEquals(name1.contains("*"),true);
  			 System.out.println("Pass");
  			 break;
  		 }

  	 }
  	 
  	 Assert.assertEquals(arr.contains("Copy of "+attachPackages.c.trim()+"*"), true);

  	return name1;
	   }
	   catch(Exception e)
	   {
		   throw e;
	   }

  }


public PackageDetailsWeb clkEdit_1NPkg() throws Exception
{
	try
	{
	   int tble_cnt=GenericMethods.tr_count(chkbox)+1;
       for(int i=2;i<=tble_cnt;i++)
       {
    		 String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
    		 if(data.equals("1 Room Night(s)"))
    		 {
 				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/a")).click();
 				break;
    		 }

       }
       PackageDetailsWeb PDW=PageFactory.initElements(GenericMethods.driver, PackageDetailsWeb.class);
       return PDW;
	}
	catch(Exception e)
	{
		throw e;
	}
}


}
