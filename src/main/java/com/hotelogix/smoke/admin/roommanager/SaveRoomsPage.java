package com.hotelogix.smoke.admin.roommanager;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;

public class SaveRoomsPage
{
	
	//xpath of ADD A ROOM

	//xpath of save button
	@FindBy(xpath="//input[@name='btnSave2']")
	public  WebElement save;

	//xpath of Room Name/Number Text box
	@FindBy(xpath="//input[@id='rmNameOrNoMulName_0']")
	public  WebElement roomNameNumber;
//xpath of Room code Text box
	@FindBy(xpath="//input[@id='roomCode']")
	public  WebElement RoomCode;
	//xpath of Room Type drop down
	@FindBy(id="rmTypeId")
	public  WebElement roomType;

	@FindBy(xpath="//form[@name='frmEditViewForLInk']//table//tr[2]//tbody//tr[3]//td[2]")
	public  WebElement RoomAddedMssg;

	@FindBy(xpath="//input[@name='Submit']")
	public  WebElement RoomCancel;

	public static String a;
	public static String b;

	static int number = GenericMethods.randomNumber();
	public static String roomNumber = number+"";
	static String rmNumber='"'+roomNumber+'"';
	static String actTitle= "Room List";

	//public static String roomcode=  GenericMethods.generateRandomString();
   
	
	
	public  RoomsLandingPage saveRooms() throws Exception
	{
		String roomcode=  GenericMethods.generateRandomString();
		//..Method enters required details for adding a room
		//..Navigates to RoomsLandingPage and initializes it
		try
		{
		GenericMethods.sendKeys(roomNameNumber, roomNumber);
		GenericMethods.sendKeys(RoomCode, roomcode);


		//GenericMethods.selectElement(roomType, "fj");
		GenericMethods.selectElementByIndex(roomType, 1);
		GenericMethods.clickElement(save);

//		String expTitle = GenericMethods.driver.getTitle();
//
//		Assert.assertEquals(actTitle, expTitle);

		RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
		return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}

	public static String GetSelectedRoomName() throws Exception
	{

		try
		{
		String GetRoomTypeName = roomNumber;
		return GetRoomTypeName;
		}
		catch(Exception e)
		{
			throw e;
		}
	}

	public  String GetSelectedRoomType() throws Exception
	{

		try
		{
		Select select = new Select(roomType);
		WebElement ele=select.getFirstSelectedOption();
		String abc=ele.getText();
		return abc;
		}
		catch(Exception e)
		{
			throw e;
		}
	}




	public RoomsLandingPage AddRoomTypeName() throws Exception
	{



      //GenericMethods.sendKeys(roomNameNumber, roomNumber);
     SaveRoomsPage.roomNumber=roomNumber;
     GenericMethods.driver.navigate().back();
     new RoomsLandingPage().Existing_RoomCHk();
      if(RoomsLandingPage.searchtxt.contains(roomNumber))
      {
    	  SaveRoomsPage.roomNumber=SaveRoomsPage.roomNumber+2;
          GenericMethods.sendKeys(roomNameNumber, SaveRoomsPage.roomNumber);
          GenericMethods.selectElementByIndex(roomType, 1);
    	  String RTName=new SaveRoomsPage().GetSelectedRoomType();

      }

      else
      {
    	  GenericMethods.sendKeys(roomNameNumber, roomNumber);
    	  GenericMethods.selectElementByIndex(roomType, 1);
    	  String RTName=new SaveRoomsPage().GetSelectedRoomType();
      }

      //String RNAme = SaveRoomsPage.GetSelectedRoomName();


	  GenericMethods.clickElement(save);
	  RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
	  return RLP;


	}

	//============//TC_06: Save and Duplicate Room================================================================================

	//xpath of Save and Duplicate
	@FindBy(xpath="//input[@name='btnSave']")
	public  WebElement saveAndDuplicate;

	static int number2 = GenericMethods.randomNumber();
	static String roomNumber2 = number2+"";

	static int number3 = GenericMethods.randomNumber();
	static String roomNumber3 = number3+"";



	public RoomsLandingPage saveAndDuplicate() throws Exception
	{
	 String roomcode=  GenericMethods.generateRandomString();
	// roomcode="rm"+roomcode;
		//..Method adds 2 room names on clicking Save and Duplicate
		//..Navigates to RoomsLandingPage on saving
		try
		{
		//..Generates 1st room name and stores it in variable a
	    a=GenericMethods.generateRandomString();
		System.out.println(a);
		GenericMethods.sendKeys(roomNameNumber,a);
		roomcode=a+roomcode;
		GenericMethods.sendKeys(RoomCode, roomcode);
		//GenericMethods.selectElement(roomType, "HMS");
		GenericMethods.selectElementByIndex(roomType, 2);
		GenericMethods.clickElement(saveAndDuplicate);
		//..Generates 2nd room name and stores it in variable b
	    b=GenericMethods.generateRandomString();
		System.out.println(b);
		GenericMethods.sendKeys(roomNameNumber,b);
		roomcode=b+roomcode;
		GenericMethods.sendKeys(RoomCode, roomcode);
		GenericMethods.clickElement(save);
		//..Initializing RoomsLandingPage
		RoomsLandingPage RLP=PageFactory.initElements(GenericMethods.driver,RoomsLandingPage.class );
		return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}



	public  RoomsLandingPage fn_SaveAndDuplicateMultpl2RM() throws Exception
	{

		try
		{
		GenericMethods.sendKeys(roomNameNumber, roomNumber);
		GenericMethods.selectElementByIndex(roomType, 1);
		  GenericMethods.clickElement(saveAndDuplicate);



		  String RoomAddedMssgTxt = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt.contains("saved successfully"))
			{
				GenericMethods.sendKeys(roomNameNumber, roomNumber=roomNumber+2);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(save);


			}

//		  else{
//				Thread.sleep(2500);
//				fn_SaveAndDuplicateMultpl2RM();
//			}
//
//		  Thread.sleep(9000);
//
//			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  RoomsLandingPage fn_SaveAndDuplicateMultpl3RM() throws Exception
	{

		try
		{
		GenericMethods.sendKeys(roomNameNumber, roomNumber);
		GenericMethods.selectElementByIndex(roomType, 1);
		  GenericMethods.clickElement(saveAndDuplicate);



		  String RoomAddedMssgTxt = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt.contains("saved successfully"))
			{
				GenericMethods.sendKeys(roomNameNumber, roomNumber=roomNumber+2);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);
			}

		  String RoomAddedMssgTxt1 = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt.contains("saved successfully"))
			{
				GenericMethods.sendKeys(roomNameNumber, roomNumber=roomNumber+3);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(save);
			}


//		  else{
//				Thread.sleep(2500);
//				fn_SaveAndDuplicateMultpl2RM();
//			}
//
//		  Thread.sleep(9000);
//
//			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public  RoomsLandingPage fn_SaveAndDuplicateMultpl4RM() throws Exception
	{
		try
		{
		  String RoomAddedMssgTxt1 = RoomAddedMssg.getText();

		  if(RoomAddedMssgTxt1.contains("saved successfully"))
			{
				Thread.sleep(2500);

				GenericMethods.sendKeys(roomNameNumber, roomNumber+2);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}
		  String RoomAddedMssgTxt2 = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt2.contains("saved successfully"))
			{
				Thread.sleep(2500);

				GenericMethods.sendKeys(roomNameNumber, roomNumber+3);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}
		  String RoomAddedMssgTxt3 = RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt3.contains("saved successfully"))
			{
				Thread.sleep(2500);

				GenericMethods.sendKeys(roomNameNumber, roomNumber+4);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(save);

			}


//		  else{
//				Thread.sleep(2500);
//				fn_SaveAndDuplicateMultpl4RM();
//			}
//
//
//		  Thread.sleep(9000);
//
//			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public  RoomsLandingPage fn_SaveAndDuplicateMultpl6RM() throws Exception
	{
		  String RoomAddedMssgTxt2 =  RoomAddedMssg.getText();
		  if(RoomAddedMssgTxt2.contains("saved successfully"))
			{
				Thread.sleep(2500);
				GenericMethods.sendKeys(roomNameNumber, roomNumber+6);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}

		  else{
				Thread.sleep(2500);
				fn_SaveAndDuplicateMultpl6RM();
			}



		  Thread.sleep(9000);

			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;


	}


	public  RoomsLandingPage fn_SaveAndDuplicateMultpl8RM() throws Exception
	{
		  String RoomAddedMssgTxt3 = RoomAddedMssg.getText();

		  if(RoomAddedMssgTxt3.contains("saved successfully"))
			{
				Thread.sleep(2500);
				GenericMethods.sendKeys(roomNameNumber, roomNumber+8);
				GenericMethods.selectElementByIndex(roomType, 1);
				  GenericMethods.clickElement(saveAndDuplicate);

			}

		  else{
				Thread.sleep(2500);
				fn_SaveAndDuplicateMultpl8RM();
			}

		  Thread.sleep(9000);

			GenericMethods.clickElement(RoomCancel);

	RoomsLandingPage RLP = PageFactory.initElements(GenericMethods.driver, RoomsLandingPage.class);
	return RLP;


	}









}
