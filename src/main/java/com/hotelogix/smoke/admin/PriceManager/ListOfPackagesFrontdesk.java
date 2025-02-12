package com.hotelogix.smoke.admin.PriceManager;

import java.awt.Desktop.Action;
import java.util.ArrayList;
import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.BaseClass;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class ListOfPackagesFrontdesk {
	public static String windowID;
	public static String statusDeactive;
	public static String statusActive;
	public static String data;
    public static String src;
    
    public String incName;

    public static String src1;

	@FindBy(xpath="//div[@class='headingtxt']//td[2]")
	public  WebElement pge_title;

	@FindBy(xpath="//div[@id='listing-icons']//ul//li[4]/a")
	public  WebElement attachPackageImg_BT;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a[text()='Configure']")
	public  WebElement configure_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[7]/a[text()='Edit']")
	public  WebElement edit_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[6]/a[text()='Add Activation Date']")
	public  WebElement addActivationDate_link;

	@FindBy(xpath="//table[@class='list_viewnew']//tr//td[6]")
	public  WebElement addActivationDate;

	@FindBy(xpath="//select[@name='maxEntries']")
	public  WebElement view_drpDwe;

	@FindBy(xpath="//table[@class='list_viewnew']/tbody//tr")
	public  List<WebElement> trcount;

	@FindBy(xpath="//table//tr[4]/td")
    public  WebElement Msg;

	@FindBy(xpath="//form[@id='frmListView']//tbody//td")
	public  WebElement error_msg;


	@FindBy(xpath="//input[@name='id[]']")
    public  List<WebElement> ChkBox;

	@FindBy(xpath="//td[@id='errorTd']")
	public  WebElement saveMsg;
	
	@FindBy(xpath="//input[@name='searchTitle']")
	public  WebElement searchinput;
	
	@FindBy(xpath="//input[@type='submit']")
	public  WebElement searchBtn;
	
	 @FindBy(xpath="//select[@name='maxEntries']")
	    public WebElement DD_View;
	  
	   @FindBy(xpath="	//input[@name='id[]']")
  public List<WebElement> CB_All;
	



	public static ArrayList<String> arr=new ArrayList<String>();
	public static String h="List of Packages (Frontdesk)";
    public static String src_value1="off.GIF";
    public static String actiDate_lnkFD="Add Activation Date";

	public  void verify_pgetitle() throws InterruptedException
	{
		String data=GenericMethods.getText(pge_title);
		Assert.assertEquals(data, h);
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


	public static String getPkgName(int i)
	{

	   String  data = GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]/strong[@class='main-field']")).getText();
   //    System.out.println(data);
       return data;
    }



	public  void selectView() throws Exception
	{
		try
		{
		GenericMethods.selectElement(view_drpDwe, "100");
		}
		catch(Exception e)
		{
			throw e;
		}
	}


    public   ListOfPackagesFrontdesk viewAll() throws Exception
    {
    	try
    	{    	GenericMethods.selectElement(view_drpDwe, "All");

    		boolean b=GenericMethods.isAlertPresent();
    		if(b==true){
    	GenericMethods.ActionOnAlert("Accept");
    		}
    	ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }

    public  PackageDetailsFrontDesk clck_Editlnk() throws Exception
    {
    	try{
    	GenericMethods.clickElement(edit_link);
    	}catch(Exception e)
    	{
    		Thread.sleep(2000);
    		GenericMethods.clickElement(edit_link);

    	}
    	PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return pageobj;
    }

    public String verify_pkgSavedMsg() throws Exception
    {
    	try
    	{
    	String text=GenericMethods.getText(saveMsg);
    	return text;
    	}
    	catch(Exception e)
    	{
    		throw e;
    	}
    }

    public static String ele_xpath1;

    public  void verify_savedPkg() throws Exception
    {
    	try
    	{
    	/*list2.removeAll(list1);
      	 s="";
      	 for(String str1 : list2)
      	 {
      		 s+=str1;
      	 }
      	 System.out.println(s);*/
    	int count=GenericMethods.tr_count(trcount);
    	for(int i=2;i<=count;i++)
    	{
    		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[3]")).getText();
    		//String[] parts=data.split("/n");
    		//int j=data.lastIndexOf("/");
    		//String str=data.substring(j+1);
    		arr.add(data.split("\n")[0]);
    		if(data.contains(attachPackages.c.trim()))
    		{
    			/*System.out.println("Added package found in the list");
    			String pkg_name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
      			String[] lines=pkg_name.split("\n");
      			String name1=lines[0];*/
      			 Assert.assertEquals(data.contains(attachPackages.c.trim()),true);
    			String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[6]/img")).getAttribute("src");
    			Assert.assertEquals(src.endsWith("off.GIF"), true);
    			String src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[8]/img")).getAttribute("src");
    			Assert.assertEquals(src1.endsWith("off.GIF"), true);
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
    	

//    	GenericMethods.getPkg_ID1(ChkBox,"//body//table//tr[2]//table//tbody//tr["+GenericMethods.i+"]//table[@class='list_viewnew']//tbody//tr[2]//td[7]/a", "href");
//    	attachPackage();
//    	attachPackages.selectPkg1_attach();
//    	pge_msg();
//    	GenericMethods.getPkg_ID2(ChkBox, "//table[@class='list_viewnew']/tbody//tr//td[8]/a", "href");
//    	String a=GenericMethods.verifyPackage_name(ChkBox, "//table[@class='list_viewnew']/tbody//tr//td[8]/a", "//table[@class='list_viewnew']/tbody//tr//td[3]", "href");
//    	Assert.assertEquals(a,attachPackages.c);
//


    


	public  PackageDetailsFrontDesk configurePackageFD(String pkgName) throws Exception
	{

		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
		   String data=  getPkgName(i);
		   if(data.contains(pkgName)){
     	   System.out.println("Searched Package Find");
     	   WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[7]/a[text()='Configure']"));
     	   abc.click();
     	   break;
        }
        else{
     	   System.out.println("Not verified");
        }

	}

	PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);

	return pageobj;
	}

	public  void verifyAddActivationDate_linkFD(String value) throws Exception
	{
		try
		{
//		list2.removeAll(list1);
//		s="";
//	    for (String str : list2)
//	    {
//	    	s+=str;
//	    }
//		System.out.println(list2);
		ArrayList<String> arr=new ArrayList<String>();
		int item_count=GenericMethods.tr_count(trcount);
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[3]")).getText();
    		arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				String str=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[6]/a")).getText();
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

	public  AddActivationDateFD clkAddActivationDateFD(String pkgName) throws Exception
	{
		//windowID = GenericMethods.GetCurrentWindowID();

		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
		   String data=  getPkgName(i);
		   if(data.contains(pkgName)){
     	   System.out.println("Searched Package Find");
     	   WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[6]/a[text()='Add Activation Date']"));
     	   abc.click();
     	   break;
        }
        else{
     	   System.out.println("Not verified");
        }

	}
		AddActivationDateFD pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateFD.class);
		return pageobj;
	}


	//new method for verification//

	public  AddActivationDateFD clklnk_AddActivationDateFD(String pkgName) throws Exception
	{
		windowID = GenericMethods.GetCurrentWindowID();

		int count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
		   String data=  getPkgName(i);
		   if(data.contains(pkgName)){
     	   System.out.println("Searched Package Find");
     	   WebElement  abc=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+i+"]//td[6]/a[text()='Add Activation Date']"));
     	   abc.click();
     	   break;
        }
        else{
     	   System.out.println("Not verified");
        }

	}
		AddActivationDateFD pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateFD.class);
		return pageobj;
	}




	public  void verifyForeverActivationOfFDPackage(String pkgName) throws InterruptedException
	{
		Thread.sleep(3000);
		int count=GenericMethods.tr_count(trcount);
		String abc= null;
		for(int i=2;i<=count;i++){
			String name=getPkgName(i);
			if(name.contains(pkgName)){
		 abc=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]")).getText();
		if(abc.equals("Activated Forever")){
			System.out.println("'Add Activation Date' link changed to 'Activated Forever' text");
		}else{
			System.out.println("link not changed");
		}
		}else{
			System.out.println("package name not matched");
		}
	}
	Assert.assertEquals(abc, "Activated Forever");

	}

	public static Boolean statusResult=null;

	public  Boolean chkStatus(String pkgName) throws InterruptedException{

		int count=	GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
			String name=getPkgName(i);
		if(name.equals(pkgName)){
		String src=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/img")).getAttribute("src");
		if(src.contains("on.GIF")){
			System.out.println("Status is ON");
			statusResult=true;
		}else{
			System.out.println("status is Off");
			 statusResult=false;
		}
		break;
		}else{
			System.out.println("Package not found");
		}

	}
		return statusResult;
	}

	public static Boolean statusResultAfter;

	public  Boolean chkStatusAfter(String pkgName) throws InterruptedException{

		int count=	GenericMethods.tr_count(trcount);
		for(int i=2;i<=count;i++){
			String name=getPkgName(i);
		if(name.equals(pkgName)){
		String src=	GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[8]/img")).getAttribute("src");
		if(src.contains("on.GIF")){
			System.out.println("Status is ON");
			statusResultAfter=true;
		}else{
			System.out.println("status is Off");
			statusResultAfter=false;
		}
		break;
		}else{
			System.out.println(" package not found");
		}

	}
		return statusResultAfter;
	}


	public static void compareStatus(){

		if(statusResult.equals(statusResultAfter)){
			System.out.println("Status not changed");

		}else{
			System.out.println("status changed");
		}
		Assert.assertEquals(statusResult.equals(statusResultAfter), false);

	}

	public attachPackages AttachPackage_Click() throws Exception{

    	GenericMethods.clickElement(attachPackageImg_BT);
    	attachPackages APP2=PageFactory.initElements(GenericMethods.driver, attachPackages.class);
    	return APP2;
     }


	public void VerifyConfigueration() throws InterruptedException{

		String msg=Msg.getText();
		System.out.println(msg);
		if(msg.contains(AddEditPackage.packageName)){
			System.out.println("syso Package added suceesfully goin to congigure it");
		}

		     int trcount=GenericMethods.tr_count(ChkBox);
		        System.out.println(trcount);
		       int tr=trcount+2;
		        for(int i=2;i<=tr;i++){

		        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
		        System.out.println(data);

		        if(data.contains(AddEditPackage.packageName)){
		               System.out.println(data +" Searched Package Find ");
		                src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).getText();


		               break;
		           }

			}

			if(src.equals(src1)){
				System.out.println("Activation status remaining same");
			}
			else{
				System.out.println("Before configuring " +src);
				System.out.println("After configuring " +src1);

				System.out.println("Activation status changed");
			}
	}



	public  PackageDetailsFrontDesk  VerifyAndConfigure() throws Exception
	{

        int trcount=GenericMethods.tr_count(ChkBox);
        System.out.println(trcount);
       int tr=trcount+2;
        for(int i=2;i<=tr;i++){

        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
        System.out.println(data);

        if(data.contains(AddEditPackage.packageName)){
               System.out.println(data +" Searched Package Find ");
                src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/img")).getAttribute("src");
                GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();

               break;
           }

	}
        PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return FPD;
    }


	static ArrayList<String> list1=new ArrayList<String>();
	static ArrayList<String> list2=new ArrayList<String>();

	public  void getPkgID1() throws Exception
	{
		try
		{
		int count1=GenericMethods.tr_count(ChkBox)+1;
		for(int i=2;i<=count1;i++)
		{
			String url1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).getAttribute("href");
			String ID1=url1.substring(url1.lastIndexOf("/")+1);
			list1.add(ID1);
		}
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  void getPkgID2() throws Exception
	{
		try
		{
		int count2=GenericMethods.tr_count(ChkBox)+1;
		for(int j=2;j<=count2;j++)
		{
			String url2=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+j+"]//td[7]/a")).getAttribute("href");
			String ID2=url2.substring(url2.lastIndexOf("/")+1);
			list2.add(ID2);
		}
		}
		catch(Exception e)
		{
			throw e;
		}

	}




	public static String s;
	public  PackageDetailsFrontDesk confgr_attachedPkgFD() throws Exception

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
    		String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody//tr["+k+"]//td[3]")).getText();
			//System.out.println(data);
    		arr.add(data.split("\n")[0]);

			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/a"));
				ele.click();
				break;
			}
		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);

		PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return FPD;

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


	public  PackageDetailsFrontDesk confgr_attachedPkgFD1() throws Exception

	{
		list2.removeAll(list1);
	    s="";
	    for (String str : list2)
	    {
	    	s+=str;
	    }
		System.out.println(list2);
		int item_count=GenericMethods.tr_count(trcount);
		for(int k=2;k<=item_count;k++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/a")).getAttribute("href");
			//System.out.println(data);
			if(data.contains(s))
			{
				GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+k+"]//td[7]/a")).click();
				break;
			}
		}

		PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return FPD;

	}


//

	public  AddActivationDateFD AddActivationDateFD_click1() throws Exception
	{
		try
		{
			Thread.sleep(5000);
			ArrayList<String> arr=new ArrayList<String>();
				int r_count=GenericMethods.tr_count(trcount);
			//	String data1=null;
				for(int i=2;i<=r_count;i++){
					String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
/*					int j=data.lastIndexOf("/");
					data1=data.substring(j+1);
*/					arr.add(data.split("\n")[0]);
					if(data.contains(attachPackages.c.trim()))
					{
						Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
						GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).click();
						break;
					}

				}
				Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
				AddActivationDateFD pageobj=PageFactory.initElements(GenericMethods.driver, AddActivationDateFD.class);
				Thread.sleep(5000);
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


	public  void verifyActivatedForeverFD_text(String value) throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int r1_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=r1_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
            arr.add(data.split("\n")[0]);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				String activated_txt=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]")).getText();
				Assert.assertEquals(activated_txt,value);
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

	public  PackageDetailsFrontDesk click_EditLink() throws Exception
	{
		try
		{
			Thread.sleep(5000);
			ArrayList<String> arr=new ArrayList<String>();
		int tble_cnt=GenericMethods.tr_count(trcount);
	//	String data1=null;
		for(int i=2;i<=tble_cnt;i++)
		{
			//Thread.sleep(5000);
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			System.out.println("Edit link list data::::::::::::"+data);
			/*int j=data.lastIndexOf("/");
			data1=data.substring(j+1);*/
			arr.add(data.split("\n")[0]);
			
			if(data.contains(attachPackages.c.trim()))
			{
				System.out.println("cfrom attach pkgs"+attachPackages.c.trim());
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
				WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a"));
				Thread.sleep(2000);
				GenericMethods.js_Click(ele);
				Thread.sleep(2000);
				break;
			}
		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
		PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return FPD;
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

	public  void verify_GridPkg() throws Exception
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
	   		    System.out.println("name1::::::::::::::"+name1);
	   		    String exp_name=attachPackages.c.concat(" [GRID]");
	   		    System.out.println("exp_name::::::::::::::"+exp_name);
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


	public  void verify_DailyRatePkg() throws Exception
	{
		try
		{
		ArrayList<String> arr=new ArrayList<String>();
		int row_count=GenericMethods.tr_count(trcount);
		for(int i=2;i<=row_count;i++)
		{
			String data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			String[] lines=data.split("\n");
   			String name1=lines[0];
   			arr.add(name1);
   			System.out.println("name1:::::::::"+name1);
			if(data.contains(attachPackages.c.trim()))
			{
				Assert.assertEquals(data.contains(attachPackages.c.trim()), true);
	   		    String exp_name=attachPackages.c.concat(" [DLY]");
	   		    System.out.println("exp_name::::::::::::::"+exp_name);
	   		    Assert.assertEquals(name1,exp_name);
   			    System.out.println("Pass");
   			    break;
			}
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





	public  PackageDetailsFrontDesk get_parentPkgPrice() throws Exception
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
				Assert.assertEquals(data.contains(data), true);
				WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a"));
				ele.click();
				break;
			}
		}
		Assert.assertEquals(arr.contains(attachPackages.c.trim()), true);
		PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return FPD;
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

	
	public PackageDetailsFrontDesk editingParticularPackage(String pName)
	{
		try {
			GenericMethods.sendKeys(searchinput, pName);
			GenericMethods.clickElement(searchBtn);
			
			clck_Editlnk();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PackageDetailsFrontDesk FPD=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
    	return FPD;
	}
	
	public boolean VerifyPackage(int iTestCaseRow) throws Exception{
		
		boolean pak=false;
		try{
	GenericMethods.selectElement(DD_View, "All");
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(5000);
	int size=CB_All.size()+2;
	System.out.println("size::"+size);
	for(int i=2;i<=size-1;i++){
		String s=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName));
		System.out.println("Value of s::"+s);
	    String pakname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]/strong[1]")).getText();
	    System.out.println("pakname:::"+pakname);
		if(pakname.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)))){
			System.out.println("In if");
			
			String src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[8]/img")).getAttribute("src");
			incName=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']/tbody/tr["+i+"]/td[3]")).getText();
			System.out.println("incName:::"+incName);
			Thread.sleep(2000);
			Assert.assertTrue(src.endsWith("on.GIF"));
			pak=true;
			break;
			
		}
	}
		}
		catch(Exception e){
			
			throw e;
		}
	return pak;
		

		
	}
	
	public void CreatePackageAndAttachToFD(int iTestCaseRow,boolean res) throws Exception{
		try{
			Thread.sleep(5000);
	if(res==false){
	BasePage BP=new BasePage();
	ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
	AddEditPackage  AEP=LOPM.fn_NavigateToAddEditPackage();
	LOPM=AEP.fillPkgDetail(iTestCaseRow);
	ListOfPackagesFrontdesk  FPL= BP.fn_navigateFrontDskPkg();
	String a=GenericMethods.driver.getTitle();
	attachPackages  APP= FPL.AttachPackage_Click();
	GenericMethods.switchToWindowHandle("Attach Package"); 
	APP.selectPkgForFD(AddEditPackage.pkgName);
	GenericMethods.switchToWindowHandle(a); 
	PackageDetailsFrontDesk PDF=FPL.confgr_attachedPkgFD();	 
	FPL=PDF.clickOnSave_BT();

	String b=GenericMethods.driver.getTitle();

	AddActivationDateFD AADF=FPL.AddActivationDateFD_click1();
	GenericMethods.switchToWindowHandle("Add Activation Date"); 
	AADF.activateForeverPackateFD();
	GenericMethods.switchToWindowHandle(b);
	//FPL.verifyActivatedForeverFD_text();
	}
		}catch(Exception e){
			
			throw e;
		}
	}
	 public  FrontDeskPackageDetailPage clickOnPakEditlink(String PakName) throws Exception{
	    	String aPname=null;
	    	String fPname=null;
	    	try
	    	{
	    		
	    	if(PakName.contains("(")){
	    		String b[]=PakName.split("\\(");
	    		fPname=b[0].toString();
	    	}
	    		else{
	    				fPname=PakName;
	    			}

	    	int trcount=GenericMethods.tr_count(ChkBox);
	    	System.out.println(trcount);
	    	int tr=trcount+2;
	    	for(int i=2;i<=tr-1;i++){
	    	     
	    	    data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]/strong[1]")).getText();
	    	    System.out.println(data);      
	    	    if(data.contains("DLY")){
	    	    	String a[]=data.split("\\[");
	    	    	aPname=a[0].toString();
	    	    	System.out.println("DLY there");
	    	    }
	    	    else if(data.contains("GRID")){
	    	    	String a[]=data.split("\\[");
	    	    	aPname=a[0].toString();
	    	    	
	    	    }
	    	    else{
	    	    	aPname=data;
	    	    }
	    	    
	    	    if(aPname.equals(fPname.trim())){
	    	    	System.out.println(fPname +" Searched Package Find ");
	    	     GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
	    	     break;
	    	    }
	    	      

	    		  
	    	  }
	    		}
	    	catch(Exception e){
	    		
	    		throw e;
	    	}
	    	    FrontDeskPackageDetailPage FDPD=PageFactory.initElements(GenericMethods.driver,FrontDeskPackageDetailPage.class);
	    		return FDPD;
	    	}

}
