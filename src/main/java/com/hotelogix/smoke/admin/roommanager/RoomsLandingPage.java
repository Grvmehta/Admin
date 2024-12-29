package com.hotelogix.smoke.admin.roommanager;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.admin.BaseClass.BaseClass;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class RoomsLandingPage
{
	//Add A Room button xpath
	@FindBy(xpath="a[text()='Add a Room']")
	public  WebElement addroom;

	//xpath for Room Name/Number*
	@FindBy(id="rmNameOrNoMulName_0")
	public  WebElement roomNumber;

	//xpath for Room Type* dropdown
	@FindBy(xpath="select[@id='rmTypeId']//option[2]")
	public  WebElement selectRoomType;

	@FindBy(xpath="//a[text()='Add a Room'] | //a[text()='Add a Unit']")
	public  WebElement addRooms;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[3]")
	public  WebElement room1;

	@FindBy(xpath="//form[@name='frmListView']/table/tbody/tr[2]/td[1]")
	public  WebElement pgemsg;

	@FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[8]//img")
	public  WebElement status1;

	@FindBy(xpath="//td[8]//img[contains(@src,'https://20819.hotelogix.staygrid.com/images/on.GIF')]")
	public  WebElement Active;

	 @FindBy(xpath="//td[8]//img[contains(@src,'https://20819.hotelogix.staygrid.com/images/off.GIF')]")
	 public  WebElement deactive;

	 @FindBy(xpath="//table[@class='list_viewnew']/tbody/tr")
	 public  List<WebElement> roomname_count;

	 @FindBy(xpath="//input[@class='input-style2']")
	 public  WebElement Searchfield;

	 @FindBy(xpath="//input[@class='btn-style']")
	 public  WebElement Searchbt;

	 @FindBy(xpath="//td[@class='main-field']")
	 public  WebElement VerifyRoom;

	 @FindBy(xpath="//select[@name='maxEntries']")
		public  WebElement view_drpdown;

	 ArrayList<String> arr= new ArrayList<String>();

	public static String scr_value="on.GIF";
    public static String img_value;
    public static String saved_msg="- Room "+SaveRoomsPage.rmNumber+" Saved Successfully";
    public static String saved_msg1="- Room "+'"'+SaveRoomsPage.b+'"'+" Saved Successfully";
    public static String saved_msgor="- Unit "+SaveRoomsPage.rmNumber+" Saved Successfully";


	//xpath for comment box
	@FindBy()
	public static WebElement comment;

	
	

	public  void  view_all() throws Exception
    {
		try
		{
    	GenericMethods.selectElement(view_drpdown, "All");
    	GenericMethods.ActionOnAlert("Accept");
//    	POSPointsLandingPage pageObj=PageFactory.initElements(GenericMethods.driver, POSPointsLandingPage.class);
//		return pageObj;
		}
		catch(Exception e)
		{
			throw e;
		}
    }

	public static String searchtxt;
	public  SaveRoomsPage Existing_RoomCHk() throws Exception
	{

		try
		{
       String abc = SaveRoomsPage.roomNumber;

       GenericMethods.sendKeys(Searchfield, abc);
  	   GenericMethods.clickElement(Searchbt);
  	   searchtxt=GenericMethods.getText(VerifyRoom);
  	   System.out.println(searchtxt);
  	   click_AddRoom();
  	   SaveRoomsPage SRP = PageFactory.initElements(GenericMethods.driver, SaveRoomsPage.class);
		return SRP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}



	public  SaveRoomsPage click_AddRoom() throws Exception
	{
		try
		{

		GenericMethods.clickElement(addRooms);
		//..Initializing SaveRoomsPage
		SaveRoomsPage SRP = PageFactory.initElements(GenericMethods.driver, SaveRoomsPage.class);
		return SRP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	
	
	public  void verify_savedroom(String value) throws Exception
	{
		//Method verifies the message displayed on successful save
		try
		{
		String msg1=GenericMethods.getText(pgemsg);
		//Assert.assertEquals(msg1, saved_msg || saved_msgor);
		Assert.assertTrue(msg1.equals(saved_msg)||msg1.equals(saved_msgor));
		
		int rowcount=GenericMethods.tr_count(roomname_count);
		for(int i=2;i<=rowcount;i++)
		{
			String name=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
			arr.add(name);
			if(name.equals(SaveRoomsPage.roomNumber))
			{
				String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[9]//img")).getAttribute("src");
				Assert.assertEquals(status.endsWith(value),true);
				break;
			}
			Assert.assertEquals(arr.contains(SaveRoomsPage.roomNumber),true);
		}
		Assert.assertEquals(arr.contains(SaveRoomsPage.roomNumber), true);
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

	public  void  verifyroom_savedupl(String value) throws Exception
	{
		try
		{
		String msg=GenericMethods.getText(pgemsg);

		Assert.assertEquals(msg,"- Room "+'"'+SaveRoomsPage.b+'"'+" Saved Successfully");

		int count=GenericMethods.tr_count(roomname_count);
		for(int i=2;i<=count;i++)
		{
			String roomname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[3]")).getText();
			arr.add(roomname);
			if(roomname.equals(SaveRoomsPage.b))
			{
			//Assert.assertEquals(roomname,SaveRoomsPage.b);
			String status=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr[2]//td[9]//img")).getAttribute("src");
			Assert.assertEquals(status.endsWith(value),true);
			break;
		    }			
			Assert.assertEquals(arr.contains(SaveRoomsPage.b), true);
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
	public FrontdeskLandingPage fn_NavigateFrontdesk() throws Exception
	{
		try
		{
		Actions act=new Actions(GenericMethods.driver);
		act.sendKeys(Keys.chord(Keys.CONTROL,Keys.TAB)).perform();
		GenericMethods.driver.switchTo().defaultContent();
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

}
