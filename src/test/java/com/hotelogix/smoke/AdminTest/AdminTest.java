package com.hotelogix.smoke.AdminTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.hotelogix.smoke.admin.BaseClass.BaseClass;
import com.hotelogix.smoke.admin.CompanyInfo.HotelInformationPage;
import com.hotelogix.smoke.admin.Console.AddEditCorporate;
import com.hotelogix.smoke.admin.Console.AddTravelAgentPage;
import com.hotelogix.smoke.admin.Console.ListOfRegisteredCorporateLP;
import com.hotelogix.smoke.admin.Console.ListOfRegisteredTravelAgentLP;
import com.hotelogix.smoke.admin.Console.RegisteredTravelAgentPage;
import com.hotelogix.smoke.admin.General.AddBookingPolicyPage;
import com.hotelogix.smoke.admin.General.AddEditPayType;
import com.hotelogix.smoke.admin.General.BookingPolicyPage;
import com.hotelogix.smoke.admin.General.DefaultSettingLandingPage;
import com.hotelogix.smoke.admin.General.PayTypesPage;
import com.hotelogix.smoke.admin.PosManager.AddEditPOSCategory;
import com.hotelogix.smoke.admin.PosManager.AddEditPOSPoint;
import com.hotelogix.smoke.admin.PosManager.AddPOSProduct;
import com.hotelogix.smoke.admin.PosManager.AddPOSTax;
import com.hotelogix.smoke.admin.PosManager.POSCategories;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.admin.PosManager.POSProductsList;
import com.hotelogix.smoke.admin.PosManager.POSTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDate;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateCR;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateFD;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateTA;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateWeb;
import com.hotelogix.smoke.admin.PriceManager.AddEditGroupPage;
import com.hotelogix.smoke.admin.PriceManager.AddEditGroupTaxPage;
import com.hotelogix.smoke.admin.PriceManager.AddEditPackage;
import com.hotelogix.smoke.admin.PriceManager.AddEditPackagePage;
import com.hotelogix.smoke.admin.PriceManager.AddMoreInclusions;
import com.hotelogix.smoke.admin.PriceManager.AddSeasonPage;
import com.hotelogix.smoke.admin.PriceManager.AddSpecialPeriodPage;
import com.hotelogix.smoke.admin.PriceManager.AddonLandingPage;
import com.hotelogix.smoke.admin.PriceManager.AttachPackagePage;
import com.hotelogix.smoke.admin.PriceManager.AttachPackagePage1;
import com.hotelogix.smoke.admin.PriceManager.AttachPackagesPage;
import com.hotelogix.smoke.admin.PriceManager.CenteralizePackageLandingPage;
import com.hotelogix.smoke.admin.PriceManager.DefinePackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.EditPackageDetail;
import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.FrontdeskPackagesListPage;
import com.hotelogix.smoke.admin.PriceManager.GroupBookingSource;
import com.hotelogix.smoke.admin.PriceManager.GroupTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackageCentralizedRate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate1;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent1;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesWeb;
import com.hotelogix.smoke.admin.PriceManager.ListofPackagesInPackageMaster;
import com.hotelogix.smoke.admin.PriceManager.ManageSource;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsCentralisedRate;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsFrontDesk;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsTravelAgent;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsWeb;
import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SaveAddonsPage;
import com.hotelogix.smoke.admin.PriceManager.SeasonsLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SpecialPeriodLandingPage;
import com.hotelogix.smoke.admin.PriceManager.TravelAgentPackagesLandingPage;
import com.hotelogix.smoke.admin.PriceManager.attachPackages;
import com.hotelogix.smoke.admin.Report.NightAuditPage;
import com.hotelogix.smoke.admin.Report.NightAuditReportPage;
import com.hotelogix.smoke.admin.UserManager.AddEditUser;
import com.hotelogix.smoke.admin.UserManager.AddEditUserLevelPage;
import com.hotelogix.smoke.admin.UserManager.SetReportPermission;
import com.hotelogix.smoke.admin.UserManager.UsersLevelList;
import com.hotelogix.smoke.admin.UserManager.UsersListLandingPage;
import com.hotelogix.smoke.admin.WebManager.WebReservationSettingPage;
import com.hotelogix.smoke.admin.WebTravelAgent.TAReservationHomePage;
import com.hotelogix.smoke.admin.WebTravelAgent.TASelectRoomPage;
import com.hotelogix.smoke.admin.WebTravelAgent.TravleAgent_LoginPage;
//import com.hotelogix.smoke.admin.WebTravelAgent.WebReservationHomePageTA;
import com.hotelogix.smoke.admin.roommanager.AddEditAmenity;
import com.hotelogix.smoke.admin.roommanager.AmenitiesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTaxesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTypesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomsLandingPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTaxesPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTypesPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomsPage;
import com.hotelogix.smoke.emailaccount.EmailHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebAddMoreRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebSelectRoomPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;


public class AdminTest {


    private static BasePage BP;
	private  String sTestCaseName;
	private int iTestCaseRow;
    public static  String wID;
    public static HashMap<String,Integer> hm=null;


@BeforeTest
public void Login() throws Throwable
{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

	try{
	//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.stayezee.com/admine/login/login/");
	AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
    BP=AL.adminlogin(iTestCaseRow);
    wID=GenericMethods.GetCurrentWindowID();
	}catch(Throwable e){
        Thread.sleep(1000);
		System.out.println("System is showing problem during login");
		System.out.println("trying again");
		//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.stayezee.com/admine/login/login/");
		AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
		BP=AL.adminlogin(iTestCaseRow);
		 wID=GenericMethods.GetCurrentWindowID();
	}

Thread.sleep(2000);
}

@BeforeClass
public void fn_creatingCollection() throws Throwable {// TC_31_32_33
	try {
		hm=ExcelUtil.creatingCollectionofTestcaseNames();
	}
	catch(Exception e)
	{
		throw e;
	}
	}


    //TC_02   User should be directed to the 'Amenities List' page.
	//TC_03 Save Amenity
	@Test(priority=2,description="Added amenity gets displayed on 'Amenities List' page and is also displayed on 'Add a Room Type' page under 'Select Amenities' >> 'Available Amenities'")
	public void fn_verifyAdditionOfAmenity() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
			//Assert.assertTrue(false);
		AmenitiesLandingPage ALP=BP.amenitiesPageNevigation();
		Thread.sleep(3000);
		String text=ALP.verify_pageTitle();
		Assert.assertEquals(text.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		AddEditAmenity AEA=ALP.fn_clkAddAmenity();
		AEA.fn_addAmentiyDetails();
		String msg=ALP.fn_verifyMsg();
		Assert.assertEquals(msg, "- Amenity "+'"'+AEA.amenityName+'"'+" Saved Successfully");
		ALP.fn_verifyAmentiy(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		//..Navigates to RoomTypesLandingPage to check f  or added amenity
		RoomTypesLandingPage RTLP=BP.roomTypesNavigate();
		SaveRoomTypesPage SRTP=RTLP.clickEdit();
		SRTP.chkamenity();
		//..Log Message
		
		Reporter.log("Added amenity gets displayed on 'Amenities List' page and is also displayed on 'Add a Room Type' page under 'Select Amenities' >> 'Available Amenities'",true);
		
		System.out.println("TC_02_03 Executed");
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
}


	
	//TC_04  User should be directed to 'Rooms List' page. 
	//TC_05 Save Rooms
	@Test(priority=3,description="Added Room is displayed on 'Rooms List' page with status as active(green tick)")
	public void fn_verifyAdditionOfRoom() throws Throwable
	{
		try		
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		RoomsLandingPage RLP=BP.roomsPageNavigate();
		Thread.sleep(5000);
		String str=GenericMethods.driver.getTitle();
		System.out.println("str:::::::::::::::::::::::::::::::"+str);
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		SaveRoomsPage SRP=RLP.click_AddRoom();		
		SRP.saveRooms();
		Thread.sleep(5000);
		RLP.verify_savedroom(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		//..Log Message
		Reporter.log("Added Room is displayed on 'Rooms List' page with status as active(green tick)",true);
		System.out.println("TC_04_05 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e)
		   {
			GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
}

	
	//TC_06: Save and Duplicate Room
	@Test(priority=4,description="On clicking 'Save and Duplicate' button on 'Add/Edit a Room',all the rooms of the same room type are displayed in ")
	public void fn_verifySaveAndDuplicateRoomBtn() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		RoomsLandingPage RLP=BP.roomsPageNavigate();
		SaveRoomsPage SRP=RLP.click_AddRoom();
		SRP.saveAndDuplicate();
		RLP.verifyroom_savedupl(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		//..Log Message
		Reporter.log("On clicking 'Save and Duplicate' button on 'Add/Edit a Room',all the rooms of the same room type are displayed in ",true);
		System.out.println("TC_06 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		}
		 catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences(); 
		   throw e;
		   }
	}

	
	//TC_07: Navigate to Room Tax Page
	//TC_08: Save Room Taxes
	//TC_09: User should be directed to 'Rooms Types List' page.
	//TC_10: Taxes should be attached to the Room Type and saved successfully.
	@Test(priority=5,description="Creation of room tax and attaching it to a room type.")
	public void fn_verifyRoomTaxSelectionInRoomType() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
		Thread.sleep(5000);
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
		SRTP.saveRoomTaxes();
		String str=RTLP.verify_roomtax();
		Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
		RTLP.chk_taxstatus();
		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
		Thread.sleep(5000);
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
		SaveRoomTypesPage SRP=RLP.addRoomType();
		SRP.verify_roomtax();
		SRP.fn_clkRoomTypeList();
		RLP.clickEdit();
		//SRP.clickCheckBox();
		SRP.saveRoomType();
		
		RLP.verify_roomtype();
		
		Reporter.log("TC_07: When 'ROOM TAXES' is clicked under 'ROOMS MANAGER' tab,system redirects user to 'Room Tax List' page. \n"
				  +"TC_08: On entering mandatory fields and entering 'Save' button,room tax gets successfully saved with active status. \n"
				+"It gets reflected on 'Add/Edit Room Type' page. \n"
				  +"TC_09: When 'ROOM TYPES' is clicked under 'ROOMS MANAGER' tab,system redirects user to 'RoomTypes List' page. \n"
				+"TC_10: When checkbox for a room tax is checked and 'Save' button is clicked,tax successfully gets attached to that room type.",true);

		System.out.println("TC_07_08_09_10 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		}
		 catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
	}
	
	
	    //TC_11 User should be directed to 'Add-Ons List' page.
		//TC_12: The Add-Ons should be saved successfully.
		@Test(priority=6,description="Creation of ADD-ONS(INCLUSIONS).It gets reflected in 'Add/Edit Package' page.")
		public void fn_verifyAdditionOfAddOns() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
			AddonLandingPage AOLP=BP.addonsLandingPage();
			Thread.sleep(3000);
			Assert.assertEquals(GenericMethods.driver.getTitle().contains( ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
			SaveAddonsPage SAP=AOLP.clickAddAddons();
			SAP.saveAddon();
			String msg=AOLP.verify_saveMsg();
			Assert.assertEquals(msg.contains(SAP.AddonName),true);
			AOLP.viewAll();
			AOLP.verify_savedAddOn(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
			AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
			String a=GenericMethods.GetCurrentWindowID();
			AddMoreInclusions AMI=AEP.checkadded_addon();
			GenericMethods.windowHandle(a);
			AMI.search_addon();
			GenericMethods.driver.close();
			GenericMethods.Switch_Parent_Window(a);
			
			Reporter.log("TC_11: When 'ADD-ONS(INCLUSIONS)' is clicked under 'PRICE MANAGER' tab,system redirects user to 'Add-Ons List' page. \n"
					+"TC_12: On entering mandatory fields and clicking 'Save Add-ons' button,add-on gets successfully saved with status as active. \n"
					+"It gets reflected on 'Add/Edit a Package' page.",true);
			
			System.out.println("TC_11_12 Executed");
			 ExcelUtil.CloseAllExcelReferences();
			}
			 catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;
			   }
		}

		
		
   @Test(priority=7,description="Creation of package in Package Master and attaching an Add-on to it.")
   public void fn_verifyAddAPackageWithInclusion() throws Throwable
   {
	   try
	   {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		Thread.sleep(5000);
		System.out.println("Page Titele::"+GenericMethods.driver.getTitle());
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.fillPkgDetails("1");
		AEP.edit_defaultrate();
	    String a=GenericMethods.GetCurrentWindowID();
	    AddMoreInclusions AMI=AEP.checkadded_addon();
	    GenericMethods.windowHandle(a);
	    Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
	    AMI.select_inclusion();
	    GenericMethods.Switch_Parent_Window(a);
	    AEP.verify_addedIncl();
	    AEP.clickOnSave();
	    LOPM.viewAll();
	    LOPM.verifysavedpkg(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	    ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
	    String b = GenericMethods.GetCurrentWindowID();
	    attachPackages AP=LOPF.attachPackage();
	    GenericMethods.windowHandle(b);
	    AP.search_pkg();
	    GenericMethods.Switch_Parent_Window(b);
	    ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
	    String c = GenericMethods.GetCurrentWindowID();
	    LOPW.attachPackage();
	    GenericMethods.windowHandle(c);
	    AP.search_pkg();
	    GenericMethods.Switch_Parent_Window(c);
	    BP.fn_navigateCorporatePkg();
	    ListOfPackagesCorporate.click_addviewpkg();
	    String d = GenericMethods.GetCurrentWindowID();
	    ListOfPackagesCorporate1.click_attackPkgbtn();
	    GenericMethods.windowHandle(d);
	    AP.search_pkg();
	    GenericMethods.Switch_Parent_Window(d);
	    BP.fn_navigatePriceManagerTAP1();
	    ListOfPackagesTravelAgent1 LOPT1=ListOfPackagesTravelAgent.click_addviewpkg();
	    String e = GenericMethods.GetCurrentWindowID();
	    LOPT1.click_attackPkgbtn();
	    GenericMethods.windowHandle(e);
	    AP.search_pkg();
	    GenericMethods.Switch_Parent_Window(e);
	    BP.fn_navigateFrontDskPkg();
	    
	    Reporter.log("TC_13: When 'PACKAGE MASTER' is clicked under 'PRICE MANAGER' tab,system redirects user to 'List of Packages' page. \n"
	    		+"TC_14: When 'Add Inclusions' link on 'Add/Edit a Package' page is clicked,system displays a new window with title as :'Add More Inclusions'. \n"
	    		+"TC_15: On entering manadatory fields on 'Add/Edit a Package' page, selecting inclusion from 'Add More Inclusion' window,and clicking 'Save' button,package gets successfully saved with active status \n"
	    		+"It gets reflected on all types of packages: Frontdesk,Web,Corporate,TA.",true);

	    
	    System.out.println("TC_13_14_15 Executed");
	    ExcelUtil.CloseAllExcelReferences();
	   }
	   catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
   }


  

 @Test(priority=8,description="Attaching a master package to Frontdesk Packages.This attached package is then configured and activated forever.")
 public void fn_verifyPkgAttachmentToFrontdesk() throws Throwable
 {
	 try
	 {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	  ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
	  AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
	  Thread.sleep(5000);
	  AEP.fillPkgDetails("1");
	  AEP.clickOnSave();
	  Thread.sleep(5000);
	  ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
	  Thread.sleep(5000);
      Assert.assertEquals(GenericMethods.driver.getTitle().contains( ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
     // ListOfPackagesFrontdesk.viewAll();
	 // ListOfPackagesFrontdesk.getPkgID1();
	  String a=GenericMethods.GetCurrentWindowID();
	  attachPackages AP=LOPF.attachPackage();
	  GenericMethods.windowHandle(a);
	  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
	  String PName=AP.getPkgName1(AddEditPackage.pkgName);
	  GenericMethods.Switch_Parent_Window(a);
	  String text=LOPF.verify_pkgSavedMsg();
	  Assert.assertEquals(text, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	  LOPF.viewAll();
	  //ListOfPackagesFrontdesk.getPkgID2();
	  LOPF.verify_savedPkg();
	  PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
	  PDF.clickOnSave_BT();
	  LOPF.viewAll();
	  String b=GenericMethods.GetCurrentWindowID();
	  LOPF.verifyAddActivationDate_linkFD(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
	  AddActivationDateFD AADF=LOPF.AddActivationDateFD_click1();
	  GenericMethods.windowHandle(b);
	  AADF.activateForeverPackateFD();
	  GenericMethods.Switch_Parent_Window(b);
	  Thread.sleep(3000);
	  LOPF.verifyActivatedForeverFD_text(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
	  
	  
	  Reporter.log("TC_16: On clicking 'FRONTDESK(PACKAGES)' under 'PRICE MANAGER' tab,system redirects user to 'List of Packages(Frontdesk)' page. \n"
			  +"TC_17: On clicking 'Attach a Package' button on 'List of Packages(Frontdesk)' page,a new window with title as :'Attach Packages' gets displayed. \n"
			  +"TC_18: When a package is selected and 'Attach' button is clicked in 'Attach Packages' window,package successfully gets attached with red cross mark under \n"
			  +"'status' and 'Activation' column. \n"
			  +"TC_19: When 'Configure' link is clicked for a package,user gets redirected to 'Package Detail' page. \n"
			  +"When 'Save' button is clicked after altering fields(if required),then package successfully gets saved with status as active and 'Add Activation Date' text gets displayed under 'Activation' column. \n"
			  +"TC_20: When 'Add Activation Date' link is clicked,,'a new window with title as: 'Add Activation Date' appears. \n'"
			  +"On selecting 'Activate Forever' checkbox and clicking 'Save' button,alert with message as: \n"
			  +"'Activating the Package forever will remove all the other Activation dates. Do you wish to continue?'. \n"   			 
			  +"TC_21: When activate forever alert is accepted,the new package gets successfully attached and saved with active status.",true);
	  	  
	  System.out.println("TC_16_17_18_19_20_21 Executed");
	  ExcelUtil.CloseAllExcelReferences();
	 }
	 catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
 } 



 
@Test(priority=9,description="Attaching a master package to Web Packages.This attached package is then configured and activated forever.")
public void fn_verifyPkgAttachmentToWeb() throws Throwable
{

try
{
	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
	//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	 ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
	 AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
	 Thread.sleep(5000);
	 AEP.fillPkgDetails("1");
	 AEP.clickOnSave();
	 Thread.sleep(5000);
	 ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
	 Thread.sleep(5000);
	 Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	// LOPW.view_All();
	// ListOfPackagesWeb.getPkgID1();
	 String windowID=GenericMethods.GetCurrentWindowID();
	 attachPackages AP=LOPW.attachPackage();
     GenericMethods.windowHandle(windowID);
     Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
     AP.getPkgName1(AddEditPackage.pkgName);
	 GenericMethods.Switch_Parent_Window(windowID);
	 String text=LOPW.verify_pageMsg();
	 Assert.assertEquals(text, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	 LOPW.view_All();
	 Thread.sleep(7000);
	 //ListOfPackagesWeb.getPkgID2();
	 LOPW.verifyPackage_name();
	 PackageDetailsWeb PDW=LOPW.confgr_attachedPkgWeb();
	 PDW.clickOnSave_BT();
	 Thread.sleep(7000);
	// LOPW.view_All();
	 LOPW.verifyAddActivationDate_linkWeb(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
	 String a=GenericMethods.GetCurrentWindowID();
	 AddActivationDateWeb AADW=LOPW.NavTo_ActivationDateWeb();
     GenericMethods.windowHandle(a);
     Thread.sleep(6000);
	 AADW.activateForeverPackateWeb();
	 GenericMethods.Switch_Parent_Window(a);
	 //Thread.sleep(8000);
	 LOPW.verifyActivatedForever_textWeb(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
	 	 
	  Reporter.log("TC_22: On clicking 'WEB(PACKAGES)' under 'PRICE MANAGER' tab,system redirects user to 'List of Packages(Web)' page. \n"
			  +"TC_23: On clicking 'Attach a Package' button on 'List of Packages(Web)' page,a new window with title as :'Attach Packages' gets displayed. \n"
			  +"TC_24: When a package is selected and 'Attach' button is clicked in 'Attach Packages' window,package successfully gets attached with red cross mark under \n"
			  +"'status' and 'Activation' column. \n"
			  +"TC_25: When 'Configure' link is clicked for a package,user gets redirected to 'Package Detail' page. \n"
			  +"When 'Save' button is clicked after altering fields(if required),then package successfully gets saved with status as active and 'Add Activation Date' text gets displayed under 'Activation' column. \n"
			  +"TC_26: When 'Add Activation Date' link is clicked,,'a new window with title as: 'Add Activation Date' appears. \n'"
			  +"On selecting 'Activate Forever' checkbox and clicking 'Save' button,alert with message as: \n"
			  +"'Activating the Package forever will remove all the other Activation dates. Do you wish to continue?'. \n"   			 
			  +"TC_27: When activate forever alert is accepted,the new package gets successfully attached and saved with active status.",true);
	 
	 System.out.println("TC_22_23_24_25_26_27 Executed");
	 ExcelUtil.CloseAllExcelReferences();
}
catch(Throwable e)
{GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}



 @Test(priority=10,description="Verify 'Publish to Grid' and 'Save As Grid' functionality for Frontdesk Package.")
 public void fn_verifyPublishToGridAndSaveFrontdeskPkg() throws Throwable
 {
	 try
	 {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		 ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
		 AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		 AEP.fillPkgDetails("1");
		 AEP.clickOnSave();
		 ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();		 
		  //LOPF.viewAll();
		// LOPF.getPkgID1();
	     String windowID=GenericMethods.GetCurrentWindowID();
	     attachPackages AP=LOPF.attachPackage();
         GenericMethods.windowHandle(windowID);
         AP.getPkgName1(AddEditPackage.pkgName);
	     GenericMethods.Switch_Parent_Window(windowID);
	     LOPF.viewAll();
	     // LOPF.getPkgID2();
	     //LOPF.verify_savedPkg();
	     PackageDetailsFrontDesk PDF= LOPF.confgr_attachedPkgFD();
	     PDF.clickOnSave_BT();
	     //LOPF.viewAll();
	     String a=GenericMethods.GetCurrentWindowID();
	     AddActivationDateFD AADF=LOPF.AddActivationDateFD_click1();
         GenericMethods.windowHandle(a);
         AADF.activateForeverPackateFD();
	     GenericMethods.Switch_Parent_Window(a);
	     Thread.sleep(7000);
	     //LOPF.viewAll();
	     LOPF.click_EditLink();
	     Thread.sleep(8000);
	     Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
         String msg1=PDF.accept_ToGrid();
         Thread.sleep(8000);
         Assert.assertEquals(msg1, PackageDetailsFrontDesk.exp_msg);
         PDF.verify_savemsg();
         Thread.sleep(4000);
	     String msg2=PDF.accept_SaveGrid();
	     Thread.sleep(4000);
	     Assert.assertEquals(msg2, PackageDetailsFrontDesk.Grid_msg);
	     PDF.clk_PkgFrontdeskLnk();
	     //LOPF.viewAll();
	     LOPF.verify_GridPkg();
	     
	     Reporter.log("TC_28: When 'Edit' link for a package on 'List of Packages(Frontdesk)' page is clicked,system redirects user to 'Package Details(Frontdesk)' page. \n"
	    		     +"TC_29: On clickiong 'Publish To Grid' button, an alert gets displayed with message as : \n"
	    		     +"'Any changes made to the package will be saved automatically and redirect to the grid preview page. Would you like to proceed? '\n"
	    		     +"TC_30: When 'OK' button of alert is clicked,packages successfully gets saved. \n"
	    		     +"TC_31: On clicking 'Save As Grid' button,an alert gets displayed with message as : \n"
	    		     +"'This action will permanently publish this package to grid. Are you sure to proceed?' \n"
	    		     +"TC_32: When 'OK' button of alert is clicked,frontdesk package successfully gets published to grid.",true);
	     
	     System.out.println("TC_28_29_30_31_32 Executed");
	     ExcelUtil.CloseAllExcelReferences();
	 }
	 catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;

	   }
 }



@Test(priority=11,description="Verify 'Publish to Grid' and 'Save As Grid' functionality for Web Package.")
public void fn_verifyPublishToGridAndSaveWebPkg() throws Throwable
{
	try
	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
		//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	 ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
	 AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
	 AEP.fillPkgDetails("1");
	 AEP.clickOnSave();
	 ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
	 //LOPW.view_All();
	// ListOfPackagesWeb.getPkgID1();
	 String windowID=GenericMethods.GetCurrentWindowID();
	 attachPackages AP=LOPW.attachPackage();
     GenericMethods.windowHandle(windowID);
	 AP.getPkgName1(AddEditPackage.pkgName);
	 GenericMethods.Switch_Parent_Window(windowID);
	 LOPW.view_All();
	 //ListOfPackagesWeb.getPkgID2();
	 PackageDetailsWeb PDW=LOPW.confgr_attachedPkgWeb();
	 PDW.clickOnSave_BT();
	// LOPW.view_All();
	 String a=GenericMethods.GetCurrentWindowID();
	 AddActivationDateWeb AADW=LOPW.NavTo_ActivationDateWeb();
	 Thread.sleep(4000);
     GenericMethods.windowHandle(a);
     AADW.activateForeverPackateWeb();
     Thread.sleep(4000);
	 GenericMethods.Switch_Parent_Window(a);
	 //LOPW.view_All();
	 LOPW.click_EditLinkWebPkg();
	 Thread.sleep(4000);
	
	 Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
	 String msg1=PDW.accept_ToGridWeb();
	 Thread.sleep(5000);
	 Assert.assertEquals(msg1, PackageDetailsWeb.exp_msgWeb);
	 PDW.verify_savemsgWeb();
	 String msg2=PDW.accept_SaveGridWeb();
	 Assert.assertEquals(msg2, PackageDetailsWeb.Grid_msgWeb);
	 PDW.clk_PkgWebLink();
	 //LOPW.view_All();
	 LOPW.verify_GridPkgWeb();	 	 
	 Reporter.log("TC_33: When 'Edit' link for a package on 'List of Packages(Web)' page is clicked,system redirects user to 'Package Details(Web)' page. \n"
		     +"TC_34: On clickiong 'Publish To Grid' button, an alert gets displayed with message as : \n"
		     +"'Any changes made to the package will be saved automatically and redirect to the grid preview page. Would you like to proceed? '\n"
		     +"TC_35: When 'OK' button of alert is clicked,packages successfully gets saved. \n"
		     +"TC_36: On clicking 'Save As Grid' button,an alert gets displayed with message as : \n"
		     +"'This action will permanently publish this package to grid. Are you sure to proceed?' \n"
		     +"TC_37: When 'OK' button of alert is clicked,web package successfully gets published to grid.",true);
	 	 
	 System.out.println("TC_33_34_35_36_37 Executed");
	 ExcelUtil.CloseAllExcelReferences();
	}
	 catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
}

 
 @Test(priority=12,description="Change and verify Night Audit time,Check-in time,Check-out time,Early Checkout Charge in Default Settings.")
 public void fn_verifySaveChangesInDefaultSettings() throws Throwable
 {
	 try
	 {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	   DefaultSettingLandingPage DSP= BP.fn_DefaultSettingsNavigate();
	   Thread.sleep(4000);
	   System.out.println(GenericMethods.driver.getTitle());
	   System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	   Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
	   DSP.change_nightAudit();
	   Thread.sleep(5000);
	   DSP.change_checkinTime();
	   DSP.change_checkoutTime();
	   DSP.change_earlyCheckoutCharge();
	   DSP.fn_verifyEarlyChkoutCharge();
	   String msg=DSP.verify_pgeMsg();
	   Assert.assertEquals(msg,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

	   Reporter.log("TC_38: On clicking 'DEFAULT SETTINGS' under 'GENERAL' tab,system redirects user to 'Default Settings' page. \n"
			       +"TC_39: When 'Click to Change' link next to 'Night Audit' is clicked, user can change night audit time, followed by click on Save Changes' button successfully changed night audit time. \n"
			       +"TC_40: When 'Click to Change' link next to 'Check-in Time' is clicked, user can change check-in time, followed by click on Save Changes' button successfully changed check-in  time. \n"
			       +"TC_41: When 'Click to Change' link next to 'Check-out Time' is clicked, user can change check-out time, followed by click on Save Changes' button successfully changed check-out time. \n"
			       +"TC_42: When 'Click to Change' link next to 'Check-out TimeEarly Check In/Check Out & Late Check Out Policy Options' is clicked, user can change early check-in/out & Late check-out time, followed by click on Save Changes' button successfully changed time.",true);
	   System.out.println("TC_38_39_40_41_42 Executed");
	   ExcelUtil.CloseAllExcelReferences();
	 }catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;

	   }
 }



  @Test(priority=13,description="Creation of 'Pay Type' and verify its status.")
  public void fn_verifyAdditionOfPayTypes() throws Throwable
  {
	  try
	  {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
 	 PayTypesPage PTP= BP.fn_NavigatePayTypes();
 	 Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
     AddEditPayType APT= PTP.fn_clkAddPayType();
     APT.fn_addPayTypeDetail();
     String text=PTP.fn_verifySaveMsg();
	 Assert.assertEquals(text, "Pay type `"+AddEditPayType.PTTitle+"` saved successfully");
     PTP.view_all();
     PTP.fn_verifyAddedPayType(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
     
     Reporter.log("TC_43: When 'PAY TYPES' under 'GENERAL' tab is clicked,system redirects user to 'Pay Types' page. \n"
    		    + "TC_44: On entering mandatory fields on 'Add Pay Type' page,followed by click on 'Save' button, pay type successfully gets saved with status as active.",true);
     
     System.out.println("TC_43_44 Executed");
	  }catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;

	   }
  }


  
	//@Test(priority=14,description="Creation of 'Booking Policy' and verify it.")
	public void fn_verifyAdditionOfBookingPolicy() throws Throwable
	{
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
		//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		try
		{
		BookingPolicyPage BPPA = BP.fn_NavigateBookingPolicy();
		String ParentID=GenericMethods.GetCurrentWindowID();
		AddBookingPolicyPage ABPP=BPPA.add_booking_policy();
		GenericMethods.windowHandle_admin(ParentID);
		ABPP.fn_addBookingPolicy();
		//String a=ABPP.fn_addBookPoli_Det();
		ABPP.Booking_Policy_Save();
		GenericMethods.Switch_Parent_Window(ParentID);
		BPPA.fn_verifyBookingP();

  	    Reporter.log("TC_45: When 'BOOKING POLICY' is clicked under 'GENERAL' tab, system rediects user to 'Booking Policy List' page.\n"
  	    		+"TC_46: After entering all mandatory details of Booking Policy, when user clicks on Save button Booking policy is saved Successfully",true);


		System.out.println("TC_45_46 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;

		   }
	}

    @Test(priority=15,description="Creation of a season")
	public void fn_verifyAdditionOfSeason() throws Throwable
	{
	  try
	  {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	    SeasonsLandingPage SELP=BP.fn_NavigateSeasons();
	    Thread.sleep(5000);
	    Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	    String a=GenericMethods.GetCurrentWindowID();
		AddSeasonPage ASP=SELP.Add_Season();
		GenericMethods.windowHandle_admin(a);
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
		ASP.fn_EnterMandatoryFields();
		//ASP.Seasons_save();
		GenericMethods.Switch_Parent_Window(a);
		Thread.sleep(3000);
		SELP.fn_verifySeasonLP();
        SELP.fn_deleteSeason();
        SELP.fn_clkDeleteSeasonBtn();
        
		Reporter.log("TC_47: When 'SEASONS' is clicked under 'PRICE MANAGER' tab, system redirects user to 'Season List' page.\n"
				+"TC_48: On clicking 'Add A Season', user gets redirected to 'Add/Edit a Season' window. \n"
				+"TC_49: On entering mandatory fields,followed by click on 'Save' button,season successfully gets saved. \n"
				+"Added Season gets reflected in Room Prices(only if Room Prices is switched to seasons)",true);

		System.out.println("TC_47_48_49 Executed");
	  }catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences(); 
	   throw e;

	   }
	}
	
	
   
	@Test(priority=16,description="Creation of Special Period and verify its status.")
	public void fn_verifyAdditionOfSpecialPeriod() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		SpecialPeriodLandingPage SPLP=BP.fn_NavigatePriceManagerSP();
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		String ParentID=GenericMethods.GetCurrentWindowID();
	    AddSpecialPeriodPage ASPP=SPLP.add_special_period();
		GenericMethods.windowHandle(ParentID);
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true);
		String text=ASPP.fn_selectSeasonAttri(1);
		ASPP.fn_addSPeriod(text, 1);
		Thread.sleep(2000);
		GenericMethods.Switch_Parent_Window(ParentID);
		Thread.sleep(3000);
		SPLP.fn_viewAll();
		Thread.sleep(3000);
		SPLP.fn_verifySpecialP();
        SPLP.fn_selectSP();
        SPLP.fn_clkDeleteSP();
        
		Reporter.log("TC_50: When 'SPECIAL PERIODS' is clicked under 'PRICE MANAGER' tab, system redirects user to 'Special Periods List' page.\n"
				    +"TC_51: When 'Add A Special Period' is clicked,'Add/Edit Special Period' window gets displayed. \n"   
				    +"TC_52: Added Special Period gets saved successfully with 'Active' status in 'Special Period List' page and gets reflected in 'Room Prices List' page(only if Room Price is switched to season mode)",true);

		System.out.println("TC_50_51_52 Executed");
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;

		   }
	}



	@Test(priority=17,description="Change Season/Special Period price,LastMin Rate and Web Rate for a room type.")
	public void fn_verifyRateChangeForWebLastMinAndSave() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		RoomPricesLandingPage RPLP=BP.fn_navigatePriceManagerRP();
		Thread.sleep(6000);
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	//	String abcd=RPLP.SpecialPeriod_Price();
		//RPLP.fn_saveSPPrice();
		//Assert.assertEquals(abcd, RoomPricesLandingPage.SBOP.getAttribute("value"));		
		String price=RPLP.lastminrate();
		//RPLP.lastmin_save();
		Assert.assertEquals(price,RPLP.savedLM);
		String webprice=RPLP.webrate();
		//RPLP.webrate_save();
        Assert.assertEquals(webprice, RPLP.savedWR);
		
		Reporter.log("TC_53: When 'ROOM PRICES' under 'PRICE MANAGER' tab is clicked, system redirects user to 'Room Prices List' page. \n"
				    +"TC_54: On clicking pencil sign to change rates for any season/special period"
				+"When Seasons/Special Period price,Last Min Rate and Web Rate is changed for a room type and floppy sign corresponding to that room type is clicked, prices for that room type gets saved successfully.",true);

		System.out.println("TC-53_54_55_56 Executed");
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;

		   }
	}

	

	
	@Test(priority=18,description="Addition of POS Tax ,verify its status and reflection.")
    public void fn_verifyAdditionOfPOSTax() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		POSTaxListPage PTL=BP.fn_navigatePOSManagerPT();
		System.out.println(GenericMethods.driver.getTitle());
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		AddPOSTax APT=PTL.AddTax();
		APT.AddPTax();
		POSTaxListPage POTLP=APT.SaveTax();
		POTLP.fn_verifyPOST(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
        POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
        AddEditPOSPoint AEPP=PPL.AddEditPOSPoint();
        AEPP.fn_verifyPOSTax();
                
		Reporter.log("Added POS Tax gets saved successfully in 'POS Tax List' with status as 'Active' as well as gets reflected in 'Add/Edit POS Point' page.",true);
		System.out.println("TC-57_58 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
	}

	 
    @Test(priority=19,description="Addition of POS Point and verify its status.")
	public void fn_verifyAdditionOfPOSPoint() throws Throwable
	{
	  try
	  {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
  	    POSPointsLandingPage PPLP=BP.fn_navigatePOSManagerPP();
  	    Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		AddEditPOSPoint APPP=PPLP.AddEditPOSPoint();
		APPP.fillDetails();
		APPP.clk_saveBtn();
		Thread.sleep(3000);
		String text=PPLP.verify_PgeMsg();
		Assert.assertEquals(text, "POS Point "+'`'+AddEditPOSPoint.POSPointName+'`'+" saved successfully");
		PPLP.view_all();
		PPLP.verify_POSPoint(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

		Reporter.log("Added POS Point gets saved suucessfully in 'POS Points List' with Active status.",true);
		System.out.println("TC-59_60 Executed");
		 ExcelUtil.CloseAllExcelReferences();
	  }catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;

	   }
	}

   
	@Test(priority=20,description="Addition of POS Point with a category and product.")
    public void fn_AdditionOfPOSPointWithCategoryAndProduct() throws Throwable
    {
        try
        {
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
        POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
		AddEditPOSPoint AEPP=PPL.AddEditPOSPoint();
		AEPP.fillDetails();
	    AEPP.clk_saveBtn();
	    Thread.sleep(6000);
	    PPL.view_all();
	    Thread.sleep(4000);
	    PPL.clickOnSpecificEdit(AddEditPOSPoint.POSPointName);
	    AEPP.clk_ProductRequiredChkbox();
	    Thread.sleep(1000);
	    AEPP.clk_saveBtn();
	    Thread.sleep(3000);
	    PPL.verify_AddNewPdtLnk(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	    AddEditPOSCategory AEPC=PPL.clk_AddNewCategory(AddEditPOSPoint.POSPointName);
	    POSCategories POSC=AEPC.fn_addPOSCategory();
	    POSC.fn_viewAll();
	    POSC.verify_addedPOSCategory(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	    Thread.sleep(3000);
	    POSC.clk_lnkPOSPoint();
	    AddPOSProduct APP=PPL.clk_addNewPOSPdtLnk();
	    Thread.sleep(4000);
	    List<String> ar=APP.verifyPOSCategory();
	    Thread.sleep(4000);
	    Assert.assertEquals(ar.contains(AddEditPOSCategory.name), true);
	    POSProductsList POPL=APP.fn_addPOSProduct();
	    POPL.verify_addedPOSProduct(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	    
	    System.out.println("TC_61_62_63 Executed");
	    Reporter.log("Addition of POS Point with a category and product.",true);
	    ExcelUtil.CloseAllExcelReferences();
        }catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;

		   }
	}

	

@Test(priority=21,description="Change Hotel Information and verify 'Save' button.")
public void fn_verifySaveHotelInfoChanges() throws Throwable
{
	try
	{
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
		//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	HotelInformationPage HP=BP.fn_navigateCompanyInfo();
	System.out.println("title::"+GenericMethods.driver.getTitle());
	System.out.println("Excel"+ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
	HP.fn_EnterHotelInformation(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ImgPath)));
	String abc=HP.fn_verifyHotelSave();
 	//Assert.assertEquals(abc, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));

	System.out.println("TC-64_65 Executed");
	Reporter.log("Change Hotel Information and verify 'Save' button.",true);
	 ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	  
	   }
}




	@Test(priority=22,description="Creation of a User Level and verify its reflection on 'Add/Edit User' page.")
    public void fn_verifyAdditionOfUserLevels() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		UsersLevelList ULL=BP.fn_navigateUserManager_UserLevels();
		//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		AddEditUserLevelPage AULP=ULL.AddNew_UserLevel();
		String abc= AULP.fn_EnterUserLevel();
		AULP.UserLevel_SaveChanges();
		ULL.verify_UserLevel(iTestCaseRow);
		UsersListLandingPage ULLP=BP.fn_navigateUserManager_UsersList();
		AddEditUser AEU=ULLP.fn_navigateToAddEditUser();
		List<String> l1=AEU.verify_UserLevel();
		Assert.assertEquals(l1.contains(abc), true);
		
		System.out.println("TC-66_67 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		Reporter.log("Creation of a User Level and verify its reflection on 'Add/Edit User' page.",true);
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;

		   }
	}

	
        @Test(priority=23,description="Creation of a user and assigning Report Permissions with it.")
	    public void fn_verifyAdditionOfUsersWithReportPermission() throws Throwable
	    {
    	  try
    	  {
    		  
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
    	   UsersListLandingPage ULP=BP.fn_navigateUserManager_UsersList();
    	   Thread.sleep(4000);
		   //Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		  AddEditUser AEU=ULP.fn_navigateToAddEditUser();
		  AEU.fillUserDetails();
		  Thread.sleep(4000);
		  String a=GenericMethods.GetCurrentWindowID();
		  SetReportPermission SRP=AEU.fn_NavigateSetReportPermsn();
		  GenericMethods.windowHandle(a);
		  Thread.sleep(5000);
		  String title=SRP.verifyPage();
		  Assert.assertEquals(title.contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
		  SRP.selectAllReport();
		  Thread.sleep(4000);
		  GenericMethods.Switch_Parent_Window(a);
		  AEU.clickOnSave_BT();
		  ULP.view_all();
		  ULP.fn_verifyAddedUser(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)),AddEditUser.userFname);
		  ExcelUtil.CloseAllExcelReferences();
		  System.out.println("TC-68_69_70 Executed");
    	  }catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;

		   }
	    }

       
		@Test(priority=24,description="Creation of Corporate.")
		public void fn_verifyAdditionOfCorporate() throws Throwable
		{
			try
			{
						sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
				ListOfRegisteredCorporateLP LORC=BP.fn_navigateToRegCorporateConsole();
				//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
				AddEditCorporate AEC=LORC.fn_NavigateToAddEditCorporate();
		        AEC.fn_fillForm();
		        LORC.view_all();
		        LORC.fn_verifyRegCorporate(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		        
		        System.out.println("TC-71_72 Executed");
		        ExcelUtil.CloseAllExcelReferences();
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;

			   }
		}


		
@Test(priority=25,description="Creation of a Travel Agent")
public void fn_verifyAdditionOfTravelAgent() throws Throwable
{
    try
    {
    			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	ListOfRegisteredTravelAgentLP LTA=BP.fn_NavigateRegisteredTravelAgent();
	//Assert.assertEquals(GenericMethods.driver.getTitle().contains( ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
    AddTravelAgentPage ATA=LTA.AddTravelAgent_Btn();
    ATA.fn_fillTADetails();
    ATA.clk_saveBtn();
    LTA.view_all();
    LTA.fn_verifyRegisteredTA(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
    
	System.out.println("TC-73_74 Executed");
	 ExcelUtil.CloseAllExcelReferences();
    }catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;

	   }
}


		
@Test(priority=26,description="Verify headers in night audit report and 'Export' button functionality.")
public void fn_verifyHeadersAndExportBtnInNightAuditReport() throws Throwable
{
	try
	{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
	//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	NightAuditPage NA=NAR.ViewReport_link();
	NA.VerifyHeaders();
	NA.DownloadNightAuditReportFile();
	NAR.fn_clkHeader();
	System.out.println("TC-75_76_77 Executed");
	 ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
}


@Test(priority=27,description="Change web settings and verify it.")
public void fn_verifyCreditCardChkboxInWebSettings() throws Throwable
{
	try
	{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		WebReservationSettingPage WRS=BP.fn_NavigateWebSetting();
		Thread.sleep(7000);
		System.out.println("Title:"+GenericMethods.driver.getTitle());
		System.out.println("Excel::"+ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		String txt=WRS.VerifySavedSettings();
		Thread.sleep(4000);
		Assert.assertEquals(txt, ExcelUtil.getCellData(iTestCaseRow,ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		System.out.println("TC-78_79 Executed");
		 ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
}



@Test(priority=28,description="Addition of master package to Centralised package.This attached package is then configured and activated forever.")
public void fn_verifyPkgAttachmentToCentralizedRate() throws Throwable
{try{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
  ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();	 
  Thread.sleep(5000);
  AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
  AEP.fillPkgDetails("1");
  AEP.clickOnSave();
  Thread.sleep(5000);
  ListOfPackageCentralizedRate LCP=BP.fn_NavigatePriceManager();
  Thread.sleep(5000);
  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
  //LCP.view();
 //LCP.getPkgID1();
  String a=GenericMethods.GetCurrentWindowID();
  attachPackages AP=LCP.attachPackage();
  Thread.sleep(3000);
  GenericMethods.windowHandle(a);
  Thread.sleep(3000);
  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  AP.selectPkgForCentralisedRate(AddEditPackage.pkgName);
  GenericMethods.Switch_Parent_Window(a);
  String txt=LCP.verify_pkgSavedMsg();
  Assert.assertEquals(txt, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
  LCP.view();
 //LCP.getPkgID2();
  LCP.verifyPackage_name(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult7)));
  PackageDetailsCentralisedRate PDCR=LCP.confgr_attachedPkgCR();
  PDCR.clickOnSave();
 LCP.view();
 Thread.sleep(19000);
  String b=GenericMethods.GetCurrentWindowID();
  LCP.verifyAddActivationDate_linkCR(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
  AddActivationDateCR AADC=LCP.NavTo_ActivationDateCR();
  GenericMethods.windowHandle(b);
  AADC.activateForeverPackateCR();
  Thread.sleep(10000);
  GenericMethods.Switch_Parent_Window(b);
// LCP.view();
  LCP.verifyActivatedForever_textCR(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
  ExcelUtil.CloseAllExcelReferences();
  System.out.println("TC-80_81_82_83_84_85 Executed");
}catch(Throwable e)
{GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
ExcelUtil.CloseAllExcelReferences();
throw e;
}
}



@Test(priority=29,description="Create a Group,add 'Web' and 'TA' as source and attach a package to it.")
public void fn_verifyAddAGrpWithSourcesAndPkgAttachment() throws Throwable
{
	
	try
	{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
	ListofPackagesInPackageMaster LPM=BP.fn_navigatePackageMaster();
	AddEditPackage AEP=LPM.fn_NavigateToAddEditPackage();
	AEP.fillPkgDetails("1");
	AEP.clickOnSave();
	Thread.sleep(4000);
	ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
	attachPackages AP=LCR.attachPackage();
	Thread.sleep(3000);
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	AP.fn_selectPkgCR();
	Thread.sleep(3000);
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	LCR.view();
	PackageDetailsCentralisedRate PDCR=LCR.confgr_attachedPkgCR();
	Thread.sleep(4000);
	PDCR.clickOnSave();
	Thread.sleep(4000);
	LCR.view();
	Thread.sleep(9000);
	AddActivationDateCR AACR=LCR.NavTo_ActivationDateCR();
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
	Thread.sleep(8000);
	AACR.activateForeverPackateCR();
	Thread.sleep(8000);
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	Thread.sleep(8000);
	ListOfRegisteredTravelAgentLP RTA=BP.fn_NavigateRegisteredTravelAgent();
	Thread.sleep(5000);
	AddTravelAgentPage ATA=RTA.AddTravelAgent_Btn();
	ATA.fn_fillTADetails();
	ATA.clk_saveBtn();
	Thread.sleep(5000);
	GroupBookingSource GBS=BP.fn_NavigatePriceManager1();
	AddEditGroupPage AGP=GBS.AddGroup();
	AGP.AddingGroup();
	GBS.view();
	GBS.verifyGroup(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
	Thread.sleep(4000);
	ManageSource MS=GBS.MangaeSource_link();
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
	MS.WebSource();
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
	Thread.sleep(3000);
	GBS.verifyWebSource();
	Thread.sleep(4000);
	GBS.MangaeSource_link();
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
    MS.fn_addSpecificTA();
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
	Thread.sleep(3000);
    GBS.verifyTASource();
    AttachPackagePage1 AP1= GBS.AttachPackage();
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
	Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
	Thread.sleep(3000);
	AP1.attach_specificPkg();
	Thread.sleep(3000);
	GenericMethods.switchToWindowHandle(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
	GBS.VerifyAttachedPackage();
	
	
	System.out.println("TC_86_87_88_89_90_91 Executed");
	 ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	{GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	 ExcelUtil.CloseAllExcelReferences();
	throw e;
	}	
}



@Test(priority=30,description="Addition of a group tax")
public void fn_verifyAdditionOfGroupTax() throws Throwable
{
        try
        {
        			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		GroupTaxListPage GTL=BP.fn_NavigateGroupTax();
		//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
	    AddEditGroupTaxPage AEGT=GTL.AddGroupTax_Btn();
	    AEGT.AddingGroupTax();
	    GTL.fn_viewAll();
	    GTL.verify_savedGroupTax(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
	    
	    System.out.println("TC-92_93 Executed");
	    ExcelUtil.CloseAllExcelReferences();
        }catch(Throwable e)
 	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
 	  ExcelUtil.CloseAllExcelReferences();
 	   throw e;

 	   }

}




@Test(priority=31,description="Create 2 night package with inclusion and attach it to Frontdesk packages.")
public void fn_Attach2NInclOfTaxPkgToFrontdesk() throws Throwable
{
	try
	{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
        AEP.makePackage("2");
        LOPM.viewAll();
        LOPM.verifysavedpkg(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        Thread.sleep(2000);
        ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
        String a=GenericMethods.GetCurrentWindowID();
        attachPackages AP= LOPF.attachPackage();
        Thread.sleep(2000);
        GenericMethods.windowHandle(a);
        Thread.sleep(3000);
        AP.selectPkgForFD(AddEditPackage.pkgName);
        GenericMethods.Switch_Parent_Window(a);
        Thread.sleep(3000);
        LOPF.viewAll();
        Thread.sleep(3000);
        PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
        PDF.selectInclusiveTax();
        PDF.clickOnSave_BT();
        Thread.sleep(3000);
        String b=GenericMethods.GetCurrentWindowID();
        AddActivationDateFD AAD=LOPF.AddActivationDateFD_click1();
        GenericMethods.windowHandle(b);
        Thread.sleep(3000);
        AAD.activateForeverPackateFD();
        GenericMethods.Switch_Parent_Window(b);
        Thread.sleep(3000);
        LOPF.verifyActivatedForeverFD_text(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
        
        System.out.println("TC-94_95_96 Executed");
        ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
   }




@Test(priority=32,description="")
public void fn_Attach3NWeeklyRatesPostingToFrontdesk() throws Throwable
{
	try
	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
	//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		  Thread.sleep(3000);
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.makePackage("3");
		LOPM.viewAll();
        LOPM.verifysavedpkg(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        Thread.sleep(4000);
        ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
        String a=GenericMethods.GetCurrentWindowID();
        attachPackages AP= LOPF.attachPackage();
        Thread.sleep(2000);
        GenericMethods.windowHandle(a);
        AP.selectPkgForFD(AddEditPackage.pkgName);
        GenericMethods.Switch_Parent_Window(a);
        LOPF.viewAll();
        PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
        Thread.sleep(4000);
        PDF.changeRatesToPost("Week");
        PDF.clickOnSave_BT();
        Thread.sleep(4000);
        LOPF.verifyAddActivationDate_linkFD(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
        String b=GenericMethods.GetCurrentWindowID();
        AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
        GenericMethods.windowHandle(b);
        Thread.sleep(2000);
        AAD.activateForeverPackateFD();
        GenericMethods.Switch_Parent_Window(b);
        Thread.sleep(2000);
        LOPF.verifyActivatedForeverFD_text(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
        
        System.out.println("TC-97_98_99 Executed");
        ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	{
		GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		 ExcelUtil.CloseAllExcelReferences();
		throw e;
	}
}



@Test(priority=33,description="Attach centralised package to web,configure it and activate it forever.")
public void fn_verifyCentralizedPkgAttachmentToWeb() throws Throwable
{
	try

	{
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
	//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.makePackage( "1");
		ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
		String a=GenericMethods.GetCurrentWindowID();
		attachPackages AP= LCR.attachPackage();
		Thread.sleep(4000);
		GenericMethods.windowHandle(a);
		AP.fn_selectPkgCR();
		Thread.sleep(4000);
		GenericMethods.Switch_Parent_Window(a);
		LCR.view();
		PackageDetailsCentralisedRate PCR=LCR.confgr_attachedPkgCR();
		Thread.sleep(4000);
		PCR.clickOnSave();
		Thread.sleep(4000);
		String b=GenericMethods.GetCurrentWindowID();
		Thread.sleep(8000);
		AddActivationDateCR AAC=LCR.NavTo_ActivationDateCR();
		GenericMethods.windowHandle(b);
		Thread.sleep(8000);
		AAC.activateForeverPackateCR();
		GenericMethods.Switch_Parent_Window(b);
		Thread.sleep(8000);
		ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
		Thread.sleep(5000);
        String c=GenericMethods.GetCurrentWindowID();
        LOPW.attachPackage();
        GenericMethods.windowHandle(c);
        Thread.sleep(4000);
        AP.selectPkg_WEBfrmCR(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        GenericMethods.Switch_Parent_Window(a);
        Thread.sleep(4000);
        LOPW.view_All();
        LOPW.verifyCRPackage_name();
        Thread.sleep(3000);
        PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
        PDW.clickOnSave_BT();
        String d=GenericMethods.GetCurrentWindowID();
        AddActivationDateWeb AAW=LOPW.NavTo_CRActivationDateWeb();
        GenericMethods.windowHandle(d);
        Thread.sleep(4000);
        AAW.activateForeverPackateWeb();
        GenericMethods.Switch_Parent_Window(d);
        Thread.sleep(3000);
        LOPW.CRverifyActivatedForever_textWeb(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
        
        
        System.out.println("TC_100 Executed");
        ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;

	   }

}

@Test(priority=34,description="Attach centralised package to TA,configure it and activate it forever.")
public void fn_verifyCentralizedPkgAttachmentToTA() throws Throwable
{
	try
	{
		
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
	//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
	if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
		
		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
		AEP.makePackage( "1");
		Thread.sleep(2000);
		ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
		String a=GenericMethods.GetCurrentWindowID();
		attachPackages AP= LCR.attachPackage();
		GenericMethods.windowHandle(a);
		AP.fn_selectPkgCR();
		GenericMethods.Switch_Parent_Window(a);
		LCR.view();
		PackageDetailsCentralisedRate PCR=LCR.confgr_attachedPkgCR();
		Thread.sleep(3000);
		PCR.clickOnSave();
		String b=GenericMethods.GetCurrentWindowID();
		Thread.sleep(4000);
		AddActivationDateCR AAC=LCR.NavTo_ActivationDateCR();
		GenericMethods.windowHandle(b);
		Thread.sleep(4000);
		AAC.activateForeverPackateCR();
		GenericMethods.Switch_Parent_Window(b);
		Thread.sleep(3000);
		TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
		ListOfPackagesTravelAgent1 LTA1=TALP.fn_NavigateTopackageListpageForTA();
		LTA1.view_All();
		String c=GenericMethods.GetCurrentWindowID();
		LTA1.click_attackPkgbtn();
		GenericMethods.windowHandle(c);
		Thread.sleep(4000);
		AP.selectPkg_TAfrmCR(AddEditPackage.pkgName);
		GenericMethods.Switch_Parent_Window(c);
		LTA1.verifyPkg_Relational(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		PackageDetailsTravelAgent PTA=LTA1.confgr_CRattachedPkgTA();
		PTA.clickOnSave_BT();
		String d=GenericMethods.GetCurrentWindowID();
		AddActivationDateTA AAD=LTA1.NavTo_ActivationDateTAfrmCR();
		GenericMethods.windowHandle(d);
		Thread.sleep(4000);
		AAD.activateForeverPackageTA();
		GenericMethods.Switch_Parent_Window(d);
		Thread.sleep(3000);
		LTA1.verifyActivatedForever_textTAfrmCR(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
        System.out.println("TC-101_102 Executed");
        ExcelUtil.CloseAllExcelReferences();
	}catch(Throwable e)
	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
	   ExcelUtil.CloseAllExcelReferences();
	   throw e;
	   }
}

	  //  @Test(priority=35,description="Attach a centralised packgae to TA and verify rates of the package as entered while configuring the package in centralized rate.")
		public void fn_verifyCentralizedRateOnTAConsole() throws Throwable
		{
		   try
		   {			  		   
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
				String hname=BP.fn_getHotelName();
			    ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
				AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
				AEP.makePackage( "1");
				Thread.sleep(3000);
				ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
				String a=GenericMethods.GetCurrentWindowID();
				attachPackages AP= LCR.attachPackage();
				Thread.sleep(3000);
				GenericMethods.windowHandle(a);
				AP.fn_selectPkgCR();
				GenericMethods.Switch_Parent_Window(a);
				LCR.view();
				Thread.sleep(9000);
				PackageDetailsCentralisedRate PCR=LCR.confgr_attachedPkgCR();
				PCR.getPkgName();
				PCR.clickOnView();
				String name=PCR.getRoomTypeName();
				String pkgPrice=PCR.getPackagePrice(name);				
				PCR.clickOnSave();
				String b=GenericMethods.GetCurrentWindowID();
				Thread.sleep(4000);
				AddActivationDateCR AAC=LCR.NavTo_ActivationDateCR();
				GenericMethods.windowHandle(b);
				Thread.sleep(4000);
				AAC.activateForeverPackateCR();
				GenericMethods.Switch_Parent_Window(b);
				Thread.sleep(6000);
				ListOfRegisteredTravelAgentLP RTA=BP.fn_navigateTravalAgentConsole();
			    AddTravelAgentPage ATA=RTA.AddTravelAgent_Btn();	    
			    String mailId=ATA.fn_fillTADetails();
			    ATA.clk_saveBtn();
			    Thread.sleep(7000);
			    RTA.fn_verifyRegisteredTA(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
				TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
				Thread.sleep(5000);
				ListOfPackagesTravelAgent1 LTA1=TALP.clkAddViewPkg_specificTA(AddTravelAgentPage.TaName);
				LTA1.view_All();
				String c=GenericMethods.GetCurrentWindowID();
				LTA1.click_attackPkgbtn();
				GenericMethods.windowHandle(c);
				Thread.sleep(4000);
				AP.selectPkg_TAfrmCR(AddEditPackage.pkgName);
				GenericMethods.Switch_Parent_Window(c);
				Thread.sleep(5000);
				PackageDetailsTravelAgent PTA=LTA1.confgr_CRattachedPkgTA();
				Thread.sleep(3000);
				PTA.clickOnSave_BT();
				String d=GenericMethods.GetCurrentWindowID();
				AddActivationDateTA AAD=LTA1.NavTo_ActivationDateTAfrmCR();
				GenericMethods.windowHandle(d);
				Thread.sleep(4000);
				AAD.activateForeverPackageTA();
				Thread.sleep(4000);
				GenericMethods.Switch_Parent_Window(d);	
				BP.fn_navigateTravalAgentConsole();
				Thread.sleep(12000);
				RTA.fn_sendEmail();	
    	    	Thread.sleep(3000);
		        EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
    		    Thread.sleep(3000);
    		
    		    EmailHomePage EHP=EAL.DoSquirrelMailLogin(iTestCaseRow);
    	        Thread.sleep(3000);

    		
    	        EHP.GetAccountDetailsForGuest(hname, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
                Thread.sleep(2000);
                ArrayList<String> al1=EHP.fn_getTALogin();
                Thread.sleep(2000);
                TravleAgent_LoginPage TAL=GenericMethods.fn_OpenTAGuestConsolePage("FF", al1.get(0).toString());
                Thread.sleep(4000);
                String txt=TAL.verify_pageHeader();
               Assert.assertEquals(txt,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
                TAReservationHomePage TARP=TAL.DoLogin(al1.get(1).toString(),al1.get(2).toString(), al1.get(3).toString());
                Thread.sleep(4000);
                String header1=TARP.verify_pageHeader();
                Thread.sleep(4000);
                Assert.assertEquals(header1, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
                TASelectRoomPage TASP=TARP.fn_CheckAvability();
                Thread.sleep(12000);
                String e=TASP.verify_pageHeader();
               Assert.assertEquals(e, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
                TASP.packagePriceVerify(name, pkgPrice);
                TASP.logout();
                GenericMethods.fn_switchTab1(2);
                System.out.println("TC-103_104_105_106_107 Executed");
                ExcelUtil.CloseAllExcelReferences();
		   }catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
		}


        @Test(priority=36,description="Attach a centralised packgae to web and verify rates of the package as entered while configuring the package in centralized rate.")
        public void fn_verifyCentralizedRateOnWeb() throws Throwable
        {
          try
           {
        	  System.out.println("Strting executing fn_verifyCentralizedRateOnWeb");
      		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
      		ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
      		//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
      		if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
        	ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
        	AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    		AEP.makePackage("1");
    		Thread.sleep(2000);
    		ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
    		Thread.sleep(3000);
    		String a=GenericMethods.GetCurrentWindowID();
    		attachPackages AP=LCR.attachPackage();
    		Thread.sleep(5000);
    		GenericMethods.windowHandle(a);
    		AP.fn_selectPkgCR();
    		GenericMethods.Switch_Parent_Window(a);
    		LCR.view();
    		Thread.sleep(5000);
    		PackageDetailsCentralisedRate PDC=LCR.confgr_attachedPkgCR();
		    PDC.getPkgName();
		    PDC.clickOnView();
			String name=PDC.getRoomTypeName();
			String pkgPrice=PDC.getPackagePrice(name);
			System.out.println("pkgPrice as second argument::"+pkgPrice);
			PDC.clickOnSave();
    		String b=GenericMethods.GetCurrentWindowID();
    		AddActivationDateCR AADC=LCR.NavTo_ActivationDateCR();
    		GenericMethods.windowHandle(b);
    		AADC.activateForeverPackateCR();
    		GenericMethods.Switch_Parent_Window(b);
    		Thread.sleep(4000);
    		ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
            String c=GenericMethods.GetCurrentWindowID();
            LOPW.attachPackage();
            GenericMethods.windowHandle(c);
            Thread.sleep(4000);
            AP.selectPkg_WEBfrmCR("Centralized Rate");
            GenericMethods.Switch_Parent_Window(a);
            Thread.sleep(4000);
            LOPW.view_All();
            LOPW.verifyCRPackage_name();
            Thread.sleep(3000);
            PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
            PDW.clickOnSave_BT();
            String d=GenericMethods.GetCurrentWindowID();
            AddActivationDateWeb AAW=LOPW.NavTo_CRActivationDateWeb();
            GenericMethods.windowHandle(d);
            Thread.sleep(4000);
            AAW.activateForeverPackateWeb();
            GenericMethods.Switch_Parent_Window(d);
            Thread.sleep(5000);
            LOPW.CRverifyActivatedForever_textWeb(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
            WebReservationSettingPage WRSP=BP.fn_navigateWebSetting();
           String ParentID= GenericMethods.GetCurrentWindowID();
           System.out.println(ParentID);
			WebReservationHomePage WRHP=WRSP.launchSecureCanvasURL();
			String txt=WRHP.fn_ValidateStaydetailsPage();
			Assert.assertEquals(txt.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3))), true);
			WebSelectRoomPage WSRP=WRHP.fn_CheckAvability();
			Thread.sleep(3000);
			String header=WSRP.fn_ValidateRoomPackagesSection();
			Assert.assertEquals(header.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4))), true);
			WSRP.packagePriceVerify(name, pkgPrice);
			GenericMethods.	Switch_Parent_Window(ParentID);
			
		    System.out.println("TC-108_109_110 Executed");
		    ExcelUtil.CloseAllExcelReferences();
           }catch(Throwable e)
 	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
 	  ExcelUtil.CloseAllExcelReferences();
 	   throw e;

 	   }

	}



		 @Test(priority=37,description="Update price in centralised package attached to Web, and verify updated price on Web console.")
		 public void fn_verifyUpdatedCentralizedPkgRateOnWeb() throws Throwable
		 {  
			 try{
				  System.out.println("Strting executing fn_verifyUpdatedCentralizedPkgRateOnWeb");
					sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
					ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
				//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
					if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
				    ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
				    AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
				    AEP.makePackage( "1");
				    Thread.sleep(9000);
					ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
					Thread.sleep(9000);
					String a=GenericMethods.GetCurrentWindowID();
					attachPackages AP= LCR.attachPackage();
					GenericMethods.windowHandle(a);
					AP.fn_selectPkgCR();
					Thread.sleep(5000);
					GenericMethods.Switch_Parent_Window(a);
					LCR.view();
					Thread.sleep(5000);
		    		PackageDetailsCentralisedRate PDC=LCR.confgr_attachedPkgCR();
				    PDC.getPkgName();
				    PDC.clickOnView();
					String name=PDC.getRoomTypeName();
			        String price=PDC.fn_alterPkgPrice(name, "10500");
			        Thread.sleep(4000);
			        PDC.clickOnSave();
           		    Thread.sleep(3000);
					String b=GenericMethods.GetCurrentWindowID();
					AddActivationDateCR AADC=LCR.NavTo_ActivationDateCR();
		    		GenericMethods.windowHandle(b);
		    		AADC.activateForeverPackateCR();
		    		GenericMethods.Switch_Parent_Window(b);
		    		Thread.sleep(4000);
		    		ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();
		            String c=GenericMethods.GetCurrentWindowID();
		            LOPW.attachPackage();
		            GenericMethods.windowHandle(c);
		            Thread.sleep(4000);
		            AP.selectPkg_WEBfrmCR("Centralized Rate");
		            GenericMethods.Switch_Parent_Window(a);
		            Thread.sleep(4000);
		            LOPW.view_All();
		            LOPW.verifyCRPackage_name();
		            Thread.sleep(3000);
		            PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
		            PDW.clickOnSave_BT();
		            String d=GenericMethods.GetCurrentWindowID();
		            AddActivationDateWeb AAW=LOPW.NavTo_CRActivationDateWeb();
		            GenericMethods.windowHandle(d);
		            Thread.sleep(4000);
		            AAW.activateForeverPackateWeb();
		            GenericMethods.Switch_Parent_Window(d);
		            Thread.sleep(5000);
		            WebReservationSettingPage WRSP=BP.fn_navigateWebSetting();
		            String ParentID= GenericMethods.GetCurrentWindowID();
		            System.out.println(ParentID);
					WebReservationHomePage WRHP=WRSP.launchSecureCanvasURL();
					Thread.sleep(5000);
					String txt=WRHP.fn_ValidateStaydetailsPage();
					Assert.assertEquals(txt.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
					WebSelectRoomPage WSRP=WRHP.fn_CheckAvability();
					String header=WSRP.fn_ValidateRoomPackagesSection();
					Assert.assertEquals(header.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
					WSRP.packagePriceVerify(name, price);	
					GenericMethods.fn_switchTab();	

					// GenericMethods.fn_switchTab1(1);
				System.out.println("TC-111_112 Executed");
				 ExcelUtil.CloseAllExcelReferences();
			 }catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;
			   }
	 }

	
		 
	  	 @Test(priority=38,description="Update price in centralised package attached to TA, and verify updated price on TA console.")
		 public  void fn_verifyUpdatedCentralizedPkgRatesOnTA() throws Throwable
		 {			 
			try{
				System.out.println("Strting executing fn_verifyUpdatedCentralizedPkgRatesOnTA");
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
				String hname=BP.fn_getHotelName();
				ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
				Thread.sleep(9000);
			    AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
			    Thread.sleep(9000);
			    AEP.makePackage( "1");
				ListOfPackageCentralizedRate LCR=BP.fn_navigateCentralisedRate();
				String a=GenericMethods.GetCurrentWindowID();
				attachPackages AP= LCR.attachPackage();
				GenericMethods.windowHandle(a);
				AP.fn_selectPkgCR();
				Thread.sleep(5000);
				GenericMethods.Switch_Parent_Window(a);
				LCR.view();
				Thread.sleep(5000);
	    		PackageDetailsCentralisedRate PDC=LCR.confgr_attachedPkgCR();
			    PDC.getPkgName();
			    PDC.clickOnView();
				String name=PDC.getRoomTypeName();
				System.out.println("name is:::"+name);
				 Thread.sleep(4000);
		        String price=PDC.fn_alterPkgPrice(name, "10500");
		        Thread.sleep(4000);
		        PDC.clickOnSave();
       		    Thread.sleep(3000);
				String b=GenericMethods.GetCurrentWindowID();
				AddActivationDateCR AADC=LCR.NavTo_ActivationDateCR();
	    		GenericMethods.windowHandle(b);
	    		AADC.activateForeverPackateCR();
	    		GenericMethods.Switch_Parent_Window(b);
	    		Thread.sleep(4000);
	    		ListOfRegisteredTravelAgentLP RTA=BP.fn_navigateTravalAgentConsole();
	    		Thread.sleep(3000);
			    AddTravelAgentPage ATA=RTA.AddTravelAgent_Btn();	    
			    String mailId=ATA.fn_fillTADetails();
			    ATA.clk_saveBtn();
			    Thread.sleep(4000);
				TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
				ListOfPackagesTravelAgent1 LTA1=TALP.clkAddViewPkg_specificTA(AddTravelAgentPage.TaName);
				LTA1.view_All();
				String c=GenericMethods.GetCurrentWindowID();
				LTA1.click_attackPkgbtn();
				GenericMethods.windowHandle(c);
				Thread.sleep(4000);
				AP.selectPkg_TAfrmCR(AddEditPackage.pkgName);
				GenericMethods.Switch_Parent_Window(c);
				PackageDetailsTravelAgent PTA=LTA1.confgr_CRattachedPkgTA();
				PTA.clickOnSave_BT();
				String d=GenericMethods.GetCurrentWindowID();
				AddActivationDateTA AAD=LTA1.NavTo_ActivationDateTAfrmCR();
				GenericMethods.windowHandle(d);
				Thread.sleep(4000);
				AAD.activateForeverPackageTA();
				GenericMethods.Switch_Parent_Window(d);	
				BP.fn_navigateTravalAgentConsole();
		        RTA.fn_sendEmail();		    
		        String ParentID= GenericMethods.GetCurrentWindowID();
	            System.out.println(ParentID);
		        EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser)), ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
    		    Thread.sleep(2000);
    		
    		    EmailHomePage EHP=EAL.DoSquirrelMailLogin(iTestCaseRow);
    	        Thread.sleep(2000);
   		
    	        EHP.GetAccountDetailsForGuest(hname, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
                Thread.sleep(2000);
                ArrayList<String> al1=EHP.fn_getTALogin();
                try
                {
                TravleAgent_LoginPage TAL=GenericMethods.fn_OpenTAGuestConsolePage("FF", al1.get(0).toString());              
                TAReservationHomePage TARP=TAL.DoLogin(al1.get(1).toString(),al1.get(2).toString(), al1.get(3).toString());
                TASelectRoomPage TASP=TARP.fn_CheckAvability();
                TASP.packagePriceVerify(name, price);   
                TASP.logout();
                GenericMethods.fn_switchTab1(1);		


				System.out.println("TC-113 Executed");
				 ExcelUtil.CloseAllExcelReferences();
                }
                catch(Exception e)
                {
                	 GenericMethods.fn_switchTab();	
                	GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
     			   ExcelUtil.CloseAllExcelReferences();
                }
                
                
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;
			   }
			 }




	  	
     @Test(priority=39,description="Attach frontdesk package to web with 'Attach Relational' functionality,configure ad activate it forever.")
     public void fn_verifyAttachRelationalFrontdeskPkgToWeb() throws Throwable
     {
    	 try
    	 {
    		 System.out.println("Strting executing fn_verifyAttachRelationalFrontdeskPkgToWeb");
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
    		    ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
    			AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    			AEP.makePackage( "1");
    			LOPM.viewAll();
    	        LOPM.verifysavedpkg(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
    	        ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
    	        String a=GenericMethods.GetCurrentWindowID();
    	        attachPackages AP= LOPF.attachPackage();
    	        Thread.sleep(2000);
    	        GenericMethods.windowHandle(a);
    	        AP.selectPkgForFD(AddEditPackage.pkgName);
    	        GenericMethods.Switch_Parent_Window(a);
    	        LOPF.viewAll();
    	        PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
    	        PDF.clickOnSave_BT();
    	        String b=GenericMethods.GetCurrentWindowID();
    	        AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
    	        GenericMethods.windowHandle(b);
    	        Thread.sleep(2000);
    	        AAD.activateForeverPackateFD();
    	        GenericMethods.Switch_Parent_Window(b);
    	        Thread.sleep(3000);
     		     
    		    ListOfPackagesWeb LOPW=BP.fn_navigateWebPkg();   
    	        String c=GenericMethods.GetCurrentWindowID();
    	        LOPW.attachPackage();
    	        GenericMethods.windowHandle(c);
    	        AP.selectSpecifiedPackage1("Frontdesk");
    	        AP.selectPkg_WebfrmFrontdesk(AddEditPackage.pkgName);
    	        GenericMethods.Switch_Parent_Window(c);
   	            String text=LOPW.verifyMsg_attachRelational();
   	            System.out.println(text);
   	            System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
   	            Assert.assertEquals(text.equals(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);               
   	            LOPW.view_All();
   	            LOPW.verifyPkg_Relational(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
                
                System.out.println("TC-114 Executed");
                ExcelUtil.CloseAllExcelReferences();
    	 }catch(Throwable e)
  	   {
    		 GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
  	         ExcelUtil.CloseAllExcelReferences();
  	   throw e;
  	   }
     }

     
    @Test(priority=40,description="Attach frontdesk package to TA with 'Attach Relational' functionality,configure and activate it forever.")
    public void fn_verifyAttachRelationalFrontdeskPkgToTA() throws Throwable
    {
    	try  	
    	{
    		System.out.println("Strting executing fn_verifyAttachRelationalFrontdeskPkgToTA");
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
    		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
    		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    		AEP.makePackage( "1");    	
            ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
            String a=GenericMethods.GetCurrentWindowID();
            attachPackages AP= LOPF.attachPackage();
            Thread.sleep(2000);
            GenericMethods.windowHandle(a);
            Thread.sleep(3000);
            AP.selectPkgForFD(AddEditPackage.pkgName);
            GenericMethods.Switch_Parent_Window(a);
            LOPF.viewAll();
            PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();          
            PDF.clickOnSave_BT();
            String b=GenericMethods.GetCurrentWindowID();
            AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
            GenericMethods.windowHandle(b);
            Thread.sleep(2000);
            AAD.activateForeverPackateFD();
            GenericMethods.Switch_Parent_Window(b);
            Thread.sleep(4000);     		
    		ListOfRegisteredTravelAgentLP RTA=BP.fn_navigateTravalAgentConsole();
    		Thread.sleep(3000);
		    AddTravelAgentPage ATA=RTA.AddTravelAgent_Btn();	    
		    String mailId=ATA.fn_fillTADetails();
		    ATA.clk_saveBtn();
		    Thread.sleep(4000);
			TravelAgentPackagesLandingPage TALP=BP.fn_navigatePriceManagerTAP();
			ListOfPackagesTravelAgent1 LTA1=TALP.clkAddViewPkg_specificTA(AddTravelAgentPage.TaName);
			LTA1.view_All();
			String c=GenericMethods.GetCurrentWindowID();
			LTA1.click_attackPkgbtn();
			GenericMethods.windowHandle(c);
			Thread.sleep(4000);          
			AP.selectPkg_TAfrmFD(AddEditPackage.pkgName);
            GenericMethods.Switch_Parent_Window(a);
            Thread.sleep(2000);
            PackageDetailsTravelAgent PDTA=LTA1.confgr_attachedPkgTA();
            PDTA.clickOnSave_BT();
            String d=GenericMethods.GetCurrentWindowID();
            AddActivationDateTA AADT=LTA1.NavTo_ActivationDateTA();
            GenericMethods.windowHandle(d);
            Thread.sleep(4000);
            AADT.activateForeverPackageTA();
            GenericMethods.Switch_Parent_Window(d);
            Thread.sleep(4000);
            LTA1.verifyActivatedForever_textTA(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
        
            System.out.println("TC_115_116_117_118_119_120_121 Executed");
            ExcelUtil.CloseAllExcelReferences();
    	}catch(Throwable e)
 	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
 	  ExcelUtil.CloseAllExcelReferences();
 	   throw e;
 	   }
    }



 //   @Test(priority=41,description="Addition of 'Relational Modifier' in copy of package attached from frontdesk to web and verify price of child package(i.e. Web Package).")
    public void fn_AdditionOFRelationalModifierInCopyPkgForWeb() throws Throwable
    {
    	try
    	{
    		//System.out.println("Strting executing fn_AdditionOFRelationalModifierInCopyPkgForWeb");
    		System.out.println("Strting executing fn_verifyAttachRelationalFrontdeskPkgToTA");
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			if(hm.get(sTestCaseName)==null){throw new SkipException("No need to execute test");}else{iTestCaseRow=	hm.get(sTestCaseName);}
    		
    		
    		//Thread.sleep(4000);
    		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
    		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    		AEP.makePackage( "1");    	
    				
    		ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
            String a=GenericMethods.GetCurrentWindowID();
            attachPackages AP= LOPF.attachPackage();
            Thread.sleep(2000);
            GenericMethods.windowHandle(a);
            Thread.sleep(3000);
            AP.selectPkgForFD(AddEditPackage.pkgName);
            GenericMethods.Switch_Parent_Window(a);
            Thread.sleep(2000);
            LOPF.viewAll();
            PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();          
            PDF.clickOnSave_BT();
            String b=GenericMethods.GetCurrentWindowID();
            AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
            GenericMethods.windowHandle(b);
            Thread.sleep(2000);
            AAD.activateForeverPackateFD();
            GenericMethods.Switch_Parent_Window(b);
            Thread.sleep(4000);     		    		   		
   		    ListOfPackagesWeb LOPW=	BP.fn_navigateWebPkg();
    	    String c=GenericMethods.GetCurrentWindowID();
    	    LOPW.attachPackage();
    	    GenericMethods.windowHandle(c);
    	    Thread.sleep(3000);
    	    AP.selectSpecifiedPackage1("Frontdesk");
         	AP.selectPkg_WebfrmFrontdesk(AddEditPackage.pkgName);
    	    GenericMethods.Switch_Parent_Window(c);
    	    Thread.sleep(3000);
    	    LOPW.view_All();
    	    PackageDetailsWeb PDW=LOPW.confgr_CRattachedPkgWeb();
    	    PDW.clickOnSave_BT();
    	    String d=GenericMethods.GetCurrentWindowID();
   	        Thread.sleep(3000);
    	    AddActivationDateWeb AADW=LOPW.NavTo_CRActivationDateWeb();
    	    GenericMethods.windowHandle(d);
     	    Thread.sleep(3000);
    	    AADW.activateForeverPackateWeb();
    	    GenericMethods.Switch_Parent_Window(d);
	        Thread.sleep(3000);
    	    LOPW.clickEdit_relationalWebPkgFrmFD();
    	    PDW.add_relationalRateModifier();
    	    PDW.clickOnSave_BT();
    	    Thread.sleep(3000);
    	    String text=LOPW.verifyMsg_relationalEdit();
		    Assert.assertEquals(text, "Package Copy of "+attachPackages.c+" saved successfully.");
    	    BP.fn_navigateFrontDskPkg();
    	    Thread.sleep(3000);
    	    LOPF.get_parentPkgPrice();
    	    PDF.fn_packagePrice();
    	    Thread.sleep(3000);
    	    BP.fn_navigateWebPkg();
    	    Thread.sleep(3000);
    	    LOPW.clickEdit_relationalWebPkgFrmFD();
    	    Thread.sleep(3000);
    	    PDW.fn_packagePriceWeb();
    	
    	System.out.println("TC_122 Executed");
    	}catch(Throwable e)
 	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
 	   throw e;
 	   }

    }




    @Test(priority=42,description="Verify 'Publish to Daily Rate' and 'Save as Daily Rate' functionality for package attached to frontdesk.")
    public void fn_PublishAndSaveAsDailyRateActivatedFDPkg() throws Throwable
    {
    	try
    	{   	
    		System.out.println("Strting executing fn_PublishAndSaveAsDailyRateActivatedFDPkg");
    		ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
    		AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
    		AEP.makePackage( "1");    	
            ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
            String a=GenericMethods.GetCurrentWindowID();
            attachPackages AP= LOPF.attachPackage();
            Thread.sleep(2000);
            GenericMethods.windowHandle(a);
            Thread.sleep(3000);
            AP.selectPkgForFD(AddEditPackage.pkgName);
            GenericMethods.Switch_Parent_Window(a);
            LOPF.viewAll();
            PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();          
            PDF.clickOnSave_BT();
            String b=GenericMethods.GetCurrentWindowID();
            AddActivationDateFD AAD= LOPF.AddActivationDateFD_click1();
            GenericMethods.windowHandle(b);
            Thread.sleep(2000);
            AAD.activateForeverPackateFD();
            GenericMethods.Switch_Parent_Window(b);
            Thread.sleep(2000);     		    		   	    			
            LOPF.click_EditLink();
    	    Thread.sleep(4000);
    	    PDF.accept_ToDailyRate();
    	    Thread.sleep(4000);
    	    PDF.verify_savemsg();
    	    PDF.accept_SaveDailyRate();
    	    Thread.sleep(4000);
    	    PDF.clk_PkgFrontdeskLnk();
    	    Thread.sleep(4000);
    	    LOPF.verify_DailyRatePkg();
    	    
    	    System.out.println("TC_123_124_125_126 Executed");
    	    ExcelUtil.CloseAllExcelReferences();
    	}catch(Throwable e)
  	   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
  	 ExcelUtil.CloseAllExcelReferences();
  	   throw e;
  	   }
    }






@AfterMethod
public void closeApp() throws Throwable
{
try{
       Set<String> str=GenericMethods.driver.getWindowHandles();
       Iterator<String> itr=str.iterator();
       int size=str.size();       
       while(itr.hasNext()==true){
    	  String windowVal= itr.next();
    	  if(windowVal.equals(wID)==false){
    		  GenericMethods.driver.switchTo().window(windowVal);
    		  GenericMethods.driver.close();
              
    	  }
    	  
    	 
       }
       GenericMethods.Switch_Parent_Window(wID);
      // BP.fn_clkLogo();
       
}catch(Throwable e){
	Thread.sleep(2000);
	 Set<String> str=GenericMethods.driver.getWindowHandles();
     Iterator<String> itr=str.iterator();
     int size=str.size();       
     while(itr.hasNext()==true){
  	  String windowVal= itr.next();
  	  if(windowVal.equals(wID)==false){
  		GenericMethods.driver.switchTo().window(windowVal);
		  GenericMethods.driver.close();  	  }
  	  
  	 
     }
     GenericMethods.Switch_Parent_Window(wID);
}
}



}
