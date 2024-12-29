package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;
//import com.sun.jna.platform.win32.WinNT.GENERIC_MAPPING;

public class PackageDetailsFrontDesk {

	@FindBy(xpath="//td[@class='container_box']//tr[1]//table[2]//tr[2]")
	public  WebElement title;

	@FindBy(xpath="//input[@name='btnSubmit']")
	public  WebElement save_Bt;

	@FindBy(xpath="//tbody//tr[10]/td//input[@type='checkbox']")
	public  WebElement inclusiveTax ;

	@FindBy(xpath="//td[@class='pkgPropertyBack']//tr[5]/td//a")
	public  WebElement chngRateToPost_link;

	@FindBy(xpath="//td[@class='pkgPropertyBack']//tr[5]/td//select")
	public  WebElement chngRateToPost_DrpDwn;

	@FindBy(xpath="//input[@id='postInclusiveTax']")
    public  WebElement InclusiveOfTax_ChkBox;

    @FindBy(id="btnSubmit")
    public  WebElement Save_Btn;

    @FindBy(xpath="//input[@value='Publish To Grid']")
    public  WebElement ToGrid_btn;

    @FindBy(xpath="//td[@class='error']")
    public  WebElement PkgDetl_savemsg;

    @FindBy(xpath="//td[@class='pkgPropertyBack']//tr[1]//td[2]")
    public  WebElement Edit_PkgName;

    @FindBy(xpath="//span[@class='comments']/input[1]")
    public  WebElement saveAsGrid_btn;

    @FindBy(xpath="//td[@class='crumbs']//a[2]")
    public  WebElement PkgFrontdesk_lnk;

    @FindBy(xpath="//input[@value='Publish To Daily Rate']")
    public  WebElement ToDailyRate_btn;

    @FindBy(xpath="//span[@class='comments']/input[1]")
    public  WebElement saveAsDailyRate_btn;

    @FindBy(xpath="//a[contains(@onclick,'closeOpenRateViewDetails')]")
    public  WebElement view_Lnk;

    @FindBy(xpath="//tr[3]//table//tr[2]//td[4]//a")
    public  WebElement price_text;
    
    @FindBy(xpath="//a[@id='allTimeAnc']")
    public  WebElement validity_link;

    @FindBy(xpath="//input[@id='validityTypeDT']")
    public  WebElement date_RadioBtn;

	@FindBy(xpath="//img[@id='showCalFrom']")
	public  WebElement cal_imgFrom;
	
	@FindBy(xpath="//img[@id='showCalTo']")
	public  WebElement cal_imgTo;
	
	
	@FindBy(xpath="//div[@class='calheader']//a[2]")
	public  WebElement cal_MonthLink;
	
	@FindBy(xpath="//div[@id='calToContainer']//a[2]")
	public  WebElement cal_MonthLinkTo;
	
	
	@FindBy(xpath="//*[@id='calFromContainer_nav_month']")
	public  WebElement cal_MonthDrop;
	
	@FindBy(xpath="//*[@id='calToContainer_nav_month']")
	public  WebElement cal_MonthDropTo;
	
	
	@FindBy(id="calFromContainer_nav_year")
	public  WebElement cal_Year;
	
	@FindBy(id="calToContainer_nav_year")
	public  WebElement cal_YearTo;
	
	
	@FindBy(id="calFromContainer_nav_submit")
	public  WebElement cal_Ok;
	
	@FindBy(id="calToContainer_nav_submit")
	public  WebElement cal_OkTo;
	
    
	  @FindBy(xpath="//*[@id='tabDT']//input[@name='btnAddDateWise']")
	  public  WebElement validityOk_Btn;
	  
	  @FindBy(xpath="//a[@id='allTimeAnc']")
	  public  WebElement anothervalidity_Btn;
	  
	  @FindBy(xpath="//input[@id='isPeriod']")
	  public  WebElement allowOverlapping_chkbx;
	  
	  @FindBy(xpath="//a[@id='labpkgName_1']")
	  public  WebElement link_PName;
	  
	  @FindBy(xpath="//input[@id='pkgName_1']")
	  public  WebElement txt_PName;
	  
	  @FindBy(xpath="//input[@id='chkId_1']")
	  public  WebElement chk_Discount;
	  
	  @FindBy(xpath="//input[@type='submit']")
	  public  WebElement btn_Submit;
	  
	
	  @FindBy(xpath="//tr[19]//tbody[1]//tr[9]//table//tbody//tr")
		public  List<WebElement> trcount;
	
	  
	

    public static String PageTitle="Package Details(Frontdesk)";
    public static String exp_msg="Any changes made to the package will be saved automatically and redirect to the grid preview page.\n"+
                                 " Would you like to proceed?";

    public static String Grid_msg="This action will permanently publish this package to grid.\n"+
"Are you sure to proceed?";

    public  String dailyRate="Any changes made to the package will be saved automatically and redirect to the daily rate preview page.\n"+
                                 " Would you like to proceed?";

    public  String dailyRate_savemsg="This action will permanently publish this package to Daily Rate.\n"+
"Are you sure to proceed?";

    public  void verify_PageTitle() throws InterruptedException
    {
    	try{
    	String text=GenericMethods.getText(title);
    	Assert.assertEquals(text, PageTitle);
    	}catch(Exception e)
    	{
    		Thread.sleep(2000);
    		String text=GenericMethods.getText(title);
        	Assert.assertEquals(text, PageTitle);
    	}

    }


	public  ListOfPackagesFrontdesk clickOnSave_BT() throws Exception
	{

		try
		{
		GenericMethods.clickElement(save_Bt);
		
		}
		catch(NoSuchElementException e)
		{
			Thread.sleep(3000);
			GenericMethods.js_Click(save_Bt);
		}
		catch(Exception e)
		{
			throw e;
		}
		ListOfPackagesFrontdesk pageobj=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return pageobj;
	}

	public  void selectInclusiveTax() throws Exception
	{

		try
		{
		GenericMethods.clickElement(inclusiveTax);
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  PackageDetailsFrontDesk changeRatesToPost(String optionToSelect) throws Exception{
		
		try
		{
		GenericMethods.clickElement(chngRateToPost_link);
		GenericMethods.selectElement(chngRateToPost_DrpDwn, optionToSelect);

		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  PackageDetailsFrontDesk clck_publishToGrid() throws Exception
	{
		GenericMethods.clickElement(ToGrid_btn);
		String popup_msg=GenericMethods.ActionOnAlert("Dismiss");
		//String str=popup_msg.trim();
		Assert.assertEquals(popup_msg,exp_msg);
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
	}

	public  String  accept_ToGrid() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ToGrid_btn);
		String popup1_msg=GenericMethods.ActionOnAlert("Accept");
		return popup1_msg;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  PackageDetailsFrontDesk clck_saveAsGrid() throws Exception
	{
		GenericMethods.clickElement(saveAsGrid_btn);
	    String popup=GenericMethods.ActionOnAlert("Dismiss");
	    Assert.assertEquals(popup, Grid_msg);
	    PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;
	}


	public  String accept_SaveGrid() throws Exception
	{
		try
		{
		GenericMethods.clickElement(saveAsGrid_btn);
		String msg2=GenericMethods.ActionOnAlert("Accept");
		//PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return msg2;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  PackageDetailsFrontDesk clk_publishToDailyRate() throws Exception
	{
		GenericMethods.clickElement(ToDailyRate_btn);
		String popup=GenericMethods.ActionOnAlert("Dismiss");
		Assert.assertEquals(popup, dailyRate);
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;

	}

	public PackageDetailsFrontDesk accept_ToDailyRate() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ToDailyRate_btn);
		String popup1=GenericMethods.ActionOnAlert("Accept");
		Assert.assertEquals(popup1.equals(dailyRate), true);
		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
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

	public  PackageDetailsFrontDesk clk_SaveAsDailyRate() throws Exception
	{
        GenericMethods.clickElement(saveAsDailyRate_btn);
        String popup=GenericMethods.ActionOnAlert("Dismiss");
        Assert.assertEquals(popup, dailyRate_savemsg);
        PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
		return pageobj;

	}


	public  PackageDetailsFrontDesk accept_SaveDailyRate() throws Exception
	{
		try
		{
		GenericMethods.clickElement(saveAsDailyRate_btn);
		String msg=GenericMethods.ActionOnAlert("Accept");
        Assert.assertEquals(msg.equals(dailyRate_savemsg),true);

		PackageDetailsFrontDesk pageobj=PageFactory.initElements(GenericMethods.driver, PackageDetailsFrontDesk.class);
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


	public static String name;

	public  String get_PkgName() throws Exception
	{
		try
		{
	    name=GenericMethods.getText(Edit_PkgName);
	    return name;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  void verify_savemsg() throws Exception
	{
		try
		{
		get_PkgName();
	    String saving_Msg="- Package " + PackageDetailsFrontDesk.name + " saved successfully.";
		String msg_save=GenericMethods.getText(PkgDetl_savemsg);
//	    JavascriptExecutor jse = (JavascriptExecutor)GenericMethods.driver;
//	    WebElement element = GenericMethods.driver.findElement(By.xpath("//td[@class='error']"));
//	    jse.executeScript("return arguments[0].text", element);
		Assert.assertEquals(msg_save, saving_Msg);
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

  public  ListOfPackagesFrontdesk SaveDetails() throws Exception
   {

		GenericMethods.clickElement(InclusiveOfTax_ChkBox);
		GenericMethods.clickElement(Save_Btn);
		ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
		return FPL;
   }

  public  ListOfPackagesFrontdesk clk_PkgFrontdeskLnk() throws Exception
  {
	  try
	  {
	  GenericMethods.clickElement(PkgFrontdesk_lnk);
	  }
	  catch(NoSuchElementException e)
	  {
		  Thread.sleep(3000);
		  GenericMethods.js_Click(PkgFrontdesk_lnk);
	  }
	  catch(Exception e)
	  {
		  throw e;
	  }
	  ListOfPackagesFrontdesk FPL=PageFactory.initElements(GenericMethods.driver, ListOfPackagesFrontdesk.class);
	  return FPL;
  }


  public static int pkgPrice;

  public  int fn_packagePrice() throws Exception
  {
	  try
	  {
	  GenericMethods.js_Click(view_Lnk);
	  Thread.sleep(5000);
	  String str=GenericMethods.getText(price_text);
	  String [] split=str.valueOf(str).split("\\.");
	  String frstpart=split[0];
	  pkgPrice=Integer.parseInt(frstpart);
	  //pkgPrice=(int)f;
	  //pkgPrice=Integer.parseInt(frstpart);

	  return pkgPrice;
	  }
	  catch(Exception e)
	  {
		  throw e;
	  }
  }

  public void fn_addvalidity(String naDate) throws Exception
  {
		  GenericMethods.clickElement(validity_link);
		  GenericMethods.clickElement(date_RadioBtn);
		  int date=	  GenericMethods.getNADate(naDate);
		  String month= GenericMethods.getNADateMonth(naDate);
		  String year= GenericMethods.getNADateYear(naDate);
	  
		  GenericMethods.clickElement(cal_imgFrom);
	      Thread.sleep(2000);
	      GenericMethods.clickElement(cal_MonthLink);
			GenericMethods.selectElement(cal_MonthDrop, month);
			GenericMethods.sendKeys(cal_Year,year );
			GenericMethods.clickElement(cal_Ok);
			Thread.sleep(1000);
			GenericMethods.driver.findElement(By.xpath("//a[text()="+date+"]")).click();
			Thread.sleep(1000);
			
			
		  GenericMethods.clickElement(cal_imgTo);
	      Thread.sleep(4000);
	      GenericMethods.clickElement(cal_MonthLinkTo);
			GenericMethods.selectElement(cal_MonthDropTo, month);
			GenericMethods.sendKeys(cal_YearTo,year );
			GenericMethods.clickElement(cal_OkTo);
			Thread.sleep(1000);
			
			date=date+8;
			GenericMethods.driver.findElement(By.xpath("//div[@id='calToContainer']//a[text()="+date+"]")).click();
		
			GenericMethods.clickElement(validityOk_Btn);
			
			
  }
  
  public void fn_addAnothervalidity(String naDate) throws Exception
  {
		  GenericMethods.clickElement(anothervalidity_Btn);
		 // GenericMethods.clickElement(date_RadioBtn);
		  int date=	  GenericMethods.getNADate(naDate);
		  String month= GenericMethods.getNADateMonth(naDate);
		  String year= GenericMethods.getNADateYear(naDate);
	  
		  GenericMethods.clickElement(cal_imgFrom);
	      Thread.sleep(2000);
	      GenericMethods.clickElement(cal_MonthLink);
			GenericMethods.selectElement(cal_MonthDrop, month);
			GenericMethods.sendKeys(cal_Year,year );
			GenericMethods.clickElement(cal_Ok);
			Thread.sleep(1000);
			date=date+3;
			GenericMethods.driver.findElement(By.xpath("//a[text()="+date+"]")).click();
			Thread.sleep(1000);
			
			
		  GenericMethods.clickElement(cal_imgTo);
	      Thread.sleep(4000);
	      GenericMethods.clickElement(cal_MonthLinkTo);
			GenericMethods.selectElement(cal_MonthDropTo, month);
			GenericMethods.sendKeys(cal_YearTo,year );
			GenericMethods.clickElement(cal_OkTo);
			Thread.sleep(1000);
			
			date=date+4;
			GenericMethods.driver.findElement(By.xpath("//div[@id='calToContainer']//a[text()="+date+"]")).click();
			
			GenericMethods.clickElement(allowOverlapping_chkbx);
		
			GenericMethods.clickElement(validityOk_Btn);
			
			GenericMethods.clickElement(save_Bt);
  }
  
  
  public void changePackageName(String newName) throws Exception
  {
	  GenericMethods.clickElement(link_PName);
	  GenericMethods.sendKeys(txt_PName, newName);
  }
  
  public void applyingDynamicDiscounts(String discountName) throws Exception
  {
	 int size= GenericMethods.tr_count(trcount);
	  
	  for(int i=1;i<=size;i++)
	  {
		  int count=0;
		  String s1=GenericMethods.driver.findElement(By.xpath("//tr[19]//tbody[1]//tr[9]//table//tbody//tr["+i+"]//td")).getText();
		  if(s1.contains(discountName))
		  {
			  count=i+1;
			  GenericMethods.driver.findElement(By.xpath("//tr[19]//tbody[1]//tr[9]//table//tbody//tr["+count+"]//a")).click();
			  break;
		  }
	  }
	  
	  
  }
  
  public void enablingDynamicDiscount() throws Exception
  {
	  GenericMethods.clickElement(chk_Discount);
	  GenericMethods.clickElement(btn_Submit);
  }
  
  public void verifyingAttachedDiscounts()
  {
	  
  }
  
  
}
