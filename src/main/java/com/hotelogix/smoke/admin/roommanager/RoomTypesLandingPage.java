package com.hotelogix.smoke.admin.roommanager;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class RoomTypesLandingPage
{
	@FindBy(xpath="//td[@class='padingtd']//tr[3]//td[11]//a[text()='Edit'] | //td[@class='padingtd']//tr[3]//td[12]//a[text()='Edit']")
	public  WebElement EditRoomType;

	@FindBy(xpath="//td[@class='main-field']")
	public  WebElement roomtype;

	@FindBy(id="errorTd")
	public  WebElement saveMessage;



	@FindBy(xpath="//a[@title='Add a Room Type']")
	public  WebElement addroomtype;


	public  SaveRoomTypesPage clickEdit() throws Exception
	{
		try
		{
		GenericMethods.clickElement(EditRoomType);
        //..Navigates to SaveRoomTypesPage and initializes it
		}catch(Exception e){
			WebElement ele1=GenericMethods.ExplicitWait(EditRoomType, "//td[@class='padingtd']//tr[3]//td[9]//a[text()='Edit']");
			ele1.click();
		}
		SaveRoomTypesPage SRTP = PageFactory.initElements(GenericMethods.driver, SaveRoomTypesPage.class);
		return SRTP;
	}

	public  void verify_roomtype() throws Exception
	{

		try
		{
			
			WebDriverWait wait = new WebDriverWait(GenericMethods.driver,40);
			wait.until(ExpectedConditions.visibilityOf(saveMessage));
		String message = GenericMethods.getText(saveMessage);
         
		Assert.assertEquals(message, "- Room Type(s) "+'"'+SaveRoomTypesPage.roomtype_txt+'"'+" saved successfully");
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


	public SaveRoomTypesPage addRoomType() throws Exception
	{
		try
		{
		GenericMethods.clickElement(addroomtype);
		SaveRoomTypesPage SRTP = PageFactory.initElements(GenericMethods.driver, SaveRoomTypesPage.class);
		return SRTP;
		}
		catch(Exception e)
		{
			throw e;
		}
	}
	
	

}
