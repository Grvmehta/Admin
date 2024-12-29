package com.hotelogix.smoke.FrontdeskTest;

import java.util.ArrayList;

import javax.media.rtp.rtcp.Report;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.GroupToSingleReservationPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.AddOnsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebAddMoreRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebConfirmReservationPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebConfirmReservationPrintPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebMoreDetailsPage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebReservationHomePage;
import com.hotelogix.smoke.frontdesk.WebReservation.WebSelectRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestAddMoreRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConfirmReservationPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConfirmReservationPrintPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestConsoleLandingPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestSelectRoomPage;
import com.hotelogix.smoke.frontdesk.WebReservation.GuestConsole.WebGuestStayDetailsPage;
import com.hotelogix.smoke.admin.BaseClass.BaseClass;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesWeb;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsWeb;
import com.hotelogix.smoke.admin.PriceManager.RoomPricesLandingPage;
import com.hotelogix.smoke.emailaccount.EmailHomePage;
import com.hotelogix.smoke.emailaccount.InboxMailPage;
import com.hotelogix.smoke.frontdesk.Accounts.AccountsLandingPage;
//import com.hotelogix.smoke.admin.WebBookingEngine.SelectRoom_Packages;
//import com.hotelogix.smoke.admin.WebBookingEngine.WebReservationConsole;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditPdfPage;
import com.hotelogix.smoke.frontdesk.CashCounter.NightAuditVideoPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.CheckinCard;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.NightAuditLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.Payment.ReservationFolioPage;
import com.hotelogix.smoke.frontdesk.Report.CashierReportPage;
import com.hotelogix.smoke.frontdesk.Report.DailySalesReportPage;
import com.hotelogix.smoke.frontdesk.Report.DiscountAllowanceReportPage;
import com.hotelogix.smoke.frontdesk.Report.FRMonthlySummeryReport;
import com.hotelogix.smoke.frontdesk.Report.LiveSupportLandingWindow;
import com.hotelogix.smoke.frontdesk.Report.NoShowReportPage;
import com.hotelogix.smoke.frontdesk.Report.ORHouseCountReport;
import com.hotelogix.smoke.frontdesk.Report.ReportLandingPage;
import com.hotelogix.smoke.frontdesk.ReservationSearchResult.ReservationSearchResultLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.ConfirmOrderPage1;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFromNewTab;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.SampleRestaurantPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;
import com.hotelogix.smoke.login.FrontdeskLoginPage;
import com.hotelogix.smoke.login.WebGuestConsoleLoginPage;

public class FrontdeskTest {

	public WebDriver driver;
	private String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1=new ArrayList<String>();
	public static ArrayList<String> gd=new ArrayList<String>();
	 public static String Discount="SP Discount(10.00%)";


FrontdeskContinueTrialPage FCT=new FrontdeskContinueTrialPage();

@BeforeMethod
public static void Login() throws Exception

{
try
{
FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk("FF", "https://hotelogix.staygrid.com/frontdesk/login/login/");
//AL.Frontdesklogin_12725();
}catch(Exception e){
    Thread.sleep(4000);
	System.out.println("System is showing problem during login");
	FrontdeskLoginPage AL = GenericMethods.fn_OpenFrontdesk("FF", "https://hotelogix.staygrid.com/frontdesk/login/login/");


}
}


//@Test(priority=1)
public void fn_startLiveChat() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		SRP.fn_VerifySampleRestaurantPage();
		Thread.sleep(3000);
		SRP.fn_VerifyGroupGenerateAndConfirmOrderPage();
		Thread.sleep(3000);
		SRP.fn_TransferToRoomButton();
		GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_14 Executed");
	}
	 catch(Exception e)
	   {
		   throw e;
	   }
}


//@Test(priority=2)
public void fn_verifyLiveChatMsg() throws Exception
{
	try
	{
    FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.FrontDesklogin_20787();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	FP.fn_ClickCancelButton();
    String str=GenericMethods.GetCurrentWindowID();
	LiveSupportLandingWindow LSL=FP.fn_ClickLiveSupportButton();
	GenericMethods.windowHandle(str);
	LSL.fn_ValidateTitle();
	LSL.fn_ValidateAllLeaveaMessageElements();
	GenericMethods.Switch_Parent_Window(str);
    System.out.println("TC_15 Executed");
	}
	 catch(Exception e)
	   {
		   throw e;
	   }
}

/*
@Test(priority=3)
public void fn_verifyYesCounterPopUp() throws Exception
{
try{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(4000);
		CCP.YesOpenNewCounter();
	    System.out.println("TC_23 Executed");

        Reporter.log("TC_23: When 'Yes' radio button is selected & 'Continue' button is clicked on Cash Counter Page,system displays a pop-up with message as:\n"
    		+"'Please Select Counter'.",true);	}

catch(Exception e)
 {
	   throw e;
 }
	}


@Test(priority=4)
public void fn_verifyFrontdeskConsolePage() throws Exception
{

try{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(2000);
		CCP.NoOpenNewcounter();
	//	FLP.verifyTitle();
		Thread.sleep(7000);
		Assert.assertEquals(GenericMethods.driver.getTitle(), "Frontdesk");
	    System.out.println("TC_24 Executed");
   
    Reporter.log("TC_24: When 'No' radio button is selected & 'Default Counter(Open)' is selected from dropdown , after clicking 'Continue' button on Cash Counter Page,system redirects user to Frontdesk landing page.",true);
	}
catch(Exception e)
 {
	   throw e;
 }	}



@Test(priority=5)
public void fn_verifyNAVideoLinkCashCounterPage() throws Exception
{
	try{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
		//String a=GenericMethods.GetCurrentWindowID();
		NightAuditVideoPage  NAV=CCP.ClickOnNightAuditVideoLink();
		GenericMethods.switchToWindowHandle("How to perform Night Audit?");
		Thread.sleep(2000);
		NAV.VerifyPage();
		GenericMethods.driver.close();
		GenericMethods.switchToWindowHandle("Frontdesk");
        System.out.println("TC_25 Executed");
        Reporter.log("TC_25: On clicking 'How to Perform Night Audit Video!' link on Cash Counter Page,system displays a new window for Night Audit Video.",true);
	}
	 catch(Exception e)
	   {
		   throw e;
	   }


	}


@Test(priority=6)
public void fn_verifyPDFDownloadingInCashCounterPage() throws Exception
{
	try
	{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.Frontdesklogin_20803();
	    CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	    String a=GenericMethods.GetCurrentWindowID();
	    NightAuditPdfPage NAP=CCP.ClickOnHowToUseLink();
	    GenericMethods.windowHandle(a);
	    Thread.sleep(2000);
	    NAP.VerifyPage();
	    GenericMethods.Switch_Parent_Window(a);
	    System.out.println("TC_26 Executed");
	    Reporter.log("TC_26: On clicking 'How to use?' link on Cash Counter Page,system starts downloading process of pdf file.",true);

	}
	 catch(Exception e)
	   {
		   throw e;
	   }
}


@Test(priority=7)
public void fn_verifySelectYourCounterDropDown() throws Exception
{
	try
	{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
        AL.Frontdesklogin_20803();
	    CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(5000);
	    CCP.YesOpenNewCounter();
	    Reporter.log("No Counter to Select", true);
	    System.out.println("TC_27 Executed");
    
        Reporter.log("TC_27: When 'Yes' radio button is clicked for 'Open New Cash Counter?' message,system does not display any counter in 'Select Your Counter' dropdown list in case of no other counter availability apart from 'Default Counter'",true);
	}

	 catch(Exception e)
	   {
		   throw e;
	   }
}



@Test(priority=8)
public void fn_verifyTapeChartFDPage() throws Exception
{
	try
	{
		FrontdeskLoginPage FL=new FrontdeskLoginPage();
	    FL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(6000);
		CCP.verify_pageHeader();

		Reporter.log("TC_28: Once a user enters login credential and clicks on 'Login' button,user gets redirected to Cash Counter Page in order to select cash counter.",true);

		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		FP.verifyTitle();

        Reporter.log("TC_29: On selecting 'Default Counter(Open)' and clicking 'Continue' button,user gets redirected to Frontdesk page wherein a panel to 'Perform Night Audit' apear.",true);

		FP.fn_ClickCancelButton();

	    System.out.println("TC_28_29_30 Executed");

	    Reporter.log(" TC_30: When 'Cancel' button for 'Perform Night Audit' panel is clicked,system displays an alert with message as:\n"
	    		+"'Do you wish to continue', wherein accepting that alert displays Frontdesk page (Tapechart).",true);
	}
	 catch(Exception e)
	   {
		   throw e;
	   }
}





@Test(priority=9)
public void fn_verifyFolioCreationInSampleRestaurantPage() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FrontdeskContinueTrialPage CP=FL.FrontDesklogin_20787();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	Thread.sleep(6000);
	FP.fn_ClickCancelButton();
	Thread.sleep(6000);
	String str=GenericMethods.GetCurrentWindowID();
	SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
	GenericMethods.windowHandle(str);
	Thread.sleep(4000);
	SRP.fn_VerifySampleRestaurantPage();

	Reporter.log("TC_42: When 'Hlx_Restaurant' button on Frontdesk page,system redirects user to Hlx_Restaurant page.",true);
	Thread.sleep(2000);
	OrderFromNewTab OFNT=SRP.ClickOnNewTab();
	OFNT.fn_verifynewTabTitle();

	Reporter.log("TC_43: When new tab on 'Hlx_Restaurant' page is clicked,system opens a new 'Order' tab.",true);

	Thread.sleep(2000);
	OFNT.SelectAndGetProduct();

	Reporter.log("TC_44: On entering an inclusion name in provided field,system displays the entered inclusion text.",true);

	Thread.sleep(2000);
	OFNT.SelectRoomNumberandGuestname();
	OFNT.fn_getGuestName();

	Reporter.log("TC_45: When a Room no. is selected from 'Room#' dropdown,its respective guest name gets displayed in 'Select Guest' dropdown.",true);

	OrderFolioPage OFP=OFNT.fn_clkTransferToRoom();
	Thread.sleep(2000);
	OFP.getFolioNumber();
	Thread.sleep(4000);
	OFP.fn_verifyTransactionCloseButton();

	GenericMethods.Switch_Parent_Window(str);
	System.out.println("TC_42_43_44_45_46 Executed");

	Reporter.log("TC_46: On clicking 'Transfer To Room' button,a Folio# gets generated with folio no.",true);

	}
	 catch(Exception e)
	   {
		   throw e;
	   }

}




 @Test(priority=10)
 public void fn_verifyConsolidateAccountClick() throws Exception
 {
     try
     {
    	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
    	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
    	 Thread.sleep(2000);
    	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
    	 Thread.sleep(6000);
    	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    	 Thread.sleep(4000);
    	 FP.fn_ClickCancelButton();
    	 Thread.sleep(4000);
    	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042223");
    	 Thread.sleep(2000);
    	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
    	 Thread.sleep(2000);
    	 AccountStatementLandingPage ASP=VDP.ClickToPayment();
    	 Thread.sleep(4000);
    	 ASP.AddOtherCharge();
    	 Thread.sleep(7000);
    	 ASP.fn_consolidateAcc();
    	 System.out.println("TC_47 Executed");

    	 Reporter.log("TC_47: When 'Consolidate Account' button is clicked on Account Statement page,Booking balance remains same.",true);
	 }
     catch(Exception e)
	   {
  	   throw e;
	   }

 }


@Test(priority=11)
public void fn_verifyAdditionOfAddOnInResrv() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 Thread.sleep(2000);
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(2000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042224");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(4000);
     EEP.fn_clkAddOn();
     Thread.sleep(2000);
     EEP.verify_addedInclusion();
     System.out.println("TC_51 Executed");

     Reporter.log("TC_51: On clicking 'Inclusions/Add-ons' link under 'Rates/Packages' section on 'Enable Editing' page,system displays 'Select Add-ons' pop-up \n"
    		 +"wherein when an inclusion is selected and 'Done' button is clicked,it gets displayed with its price.",true);
     }
     catch(Exception e)
	   {
  	   throw e;
	   }
}



@Test(priority=12)
public void fn_verifyPriceBreakupPerNightBasis() throws Exception
{

     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042224");
	 Thread.sleep(2000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(2000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(6000);
     EEP.fn_addDate();
     System.out.println("TC_52 Executed");

     Reporter.log("TC_52: When active date link cooresponding to rate type under 'Rates/Packages' is clicked,breakup gets created on per night basis.",true);
     }
     catch(Exception e)
	   {
  	   throw e;
	   }
}





@Test(priority=13)
public void fn_verifyAddEditGuestInfo() throws Exception
{
     try
     {

	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(2000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042224");
	 Thread.sleep(2000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(2000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(4000);
     EEP.fn_addeditDetails();
     Thread.sleep(2000);
     EEP.fn_editGuestDetail();
     System.out.println("TC_53_54 Executed");

     Reporter.log("TC_53: On clicking 'Add/Edit Detail' in a reservation,system displays a new form with title 'Guest Information' for editing guest details. \n"
    		 +"TC_54: When any of the guest detail like First Name and Last Name is changed and 'Save' button is clicked,reservation gets saved with new edited details.",true);
     }
     catch(Exception e)
	   {
  	   throw e;
	   }

}




@Test(priority=14)
public void fn_verifyRTClickReservCheckInCancelCheckIn() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(2000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 FP.fn_verifyCheckinPopup();
	 String a=GenericMethods.GetCurrentWindowID();
	 CheckinCard CC=FP.fn_clkCheckin();
	 GenericMethods.windowHandle(a);
	 Thread.sleep(4000);
	 CC.fn_clkCloseBtn();
	 GenericMethods.Switch_Parent_Window(a);
	 FP.fn_verifyCnclCheckinPopup();
	 Thread.sleep(3000);
	 FP.fn_acceptCnclCheckinPopup();
	 
	 System.out.println("TC_55_56_57_58 Executed");
	 
	 Reporter.log("TC_55: On right clicking 'Checkin' for a reservation on Frontdesk tapechart,system displays a pop-up for Checkin card. \n"
			 +"TC_56: When check-in pop-up is accepted,Check-in card gets displayed wherein when 'Close' button is clicked,reservation gets checked-in. \n"
			 +"TC_57: When 'Cancel Checkin' is clicked for a checked in reservation o frontdesk tapechart,system displays a pop-up with message as: \n"
			 +"'Do you wish to Unassign the reservation?' with an 'OK' and 'Cancel' buttons. \n"
			 +"TC_58: When 'OK' button of 'Cancel Checkin' pop-up is clicked,system unassigns the reservation.",true);
	 }
     catch(Exception e)
	   {
  	   throw e;
	   }
}






@Test(priority=15)
public void fn_verifyRTClickReservCheckIn() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(2000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 FP.fn_verifyCheckinPopup();
	 String a=GenericMethods.GetCurrentWindowID();
	 CheckinCard CC=FP.fn_clkCheckin();
	 GenericMethods.windowHandle(a);
	 Thread.sleep(5000);
	 CC.fn_clkCloseBtn();
	 GenericMethods.Switch_Parent_Window(a);
	 Thread.sleep(4000);
	 FP.fn_cancelCheckin();
	 System.out.println("TC_59_60 Executed");

	 Reporter.log("TC_59: On right clicking 'Checkin' for a reservation on Frontdesk tapechart,system displays a pop-up for Checkin card. \n"
	 		+ "TC_60: When check-in pop-up is accepted,Check-in card gets displayed wherein when 'Close' button is clicked,reservation gets checked-in. \n",true);
	 }
     catch(Exception e)
	   {
  	   throw e;
	   }

}



@Test(priority=16)
public void fn_verifyReservSavedWithExtraBed() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(4000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(4000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(4000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(7000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042526");
	 Thread.sleep(4000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(6000);
     EEP.fn_addExtraBed();
     Thread.sleep(5000);
     EEP.fn_clkSaveBtn();
     
     System.out.println("TC_62 Executed");

     Reporter.log("TC_62: When no. of extra beds say '1' is selected from 'Extra Bed' dropdown under 'Stay Details' section of a reservation and saved,reservation gets saved with one extra bed.",true);
     }
     catch(Exception e)
	   {
  	   throw e;
	   }
}


@Test(priority=17)
public void fn_verifyDiscountInPrice() throws Exception
{

try
{
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(2000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(5000);
	 ReservationSearchResultLandingPage RSP=FP.fn_SearchReservationID("042223");
	 Thread.sleep(2000);
	 ViewDetailsPage VDP=RSP.fn_ClickOnSearchedRecord();
	 Thread.sleep(4000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(4000);
     EEP.fn_clkAmtForDisc();
     
     System.out.println("TC_63 Executed");
     
     Reporter.log("TC_63: When 'Amount' under 'Rates/Packages' is double-clicked,'Standard Rate Details' pop-up gets displayed wherein when 'Discount' is applied and saved,new amount gets reflected in 'Amount'.",true);


}
catch(Exception e)
 {
	   throw e;
 }
}





@Test(priority=18)
public void fn_verifyManageChargeSharerInGrpReserv() throws Exception
{
     try
     {
	 FrontdeskLoginPage FL=new FrontdeskLoginPage();
	 FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	 Thread.sleep(2000);
	 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	 Thread.sleep(2000);
	 FP.fn_ClickCancelButton();
	 Thread.sleep(2000);
	 FP.fn_clickCurrentLnk();
	 Thread.sleep(3000);
	 ViewDetailsPage VDP=FP.fn_rightclkViewDetailsGrp();
	 Thread.sleep(2000);
	 EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
     Thread.sleep(5000);
     GroupToSingleReservationPage GSP=EEP.fn_clkGuestName();
     Thread.sleep(2000);
     GSP.fn_verifyGuestName();
     GSP.fn_clkManageSharerLnk();
     Thread.sleep(4000);
     GSP.fn_verifyManageSharerTitle();
     //GSP.fn_clkManageSharerLnk();
     GSP.fn_checkSharerGuest();
     Thread.sleep(2000);
     GSP.fn_verifyManagerSharerYes();
     
     System.out.println("TC_64_65_66 Executed");
     
     Reporter.log("TC_64: When user clicks on on 'Res#'/'Room'/'Guest name'/'Phone'/'Reserved'/'Action'/'Status' displayed at the bottom of reservation,then user gets redirected to group's single reservation \n"
    		 +"TC_65: On clicking 'Manage Sharer' link on group's single reservation form,new window for manage sharer(s) gets displayed. \n"
    		 +"TC_66: On selecting checkbox against guest in order to share charge,system displays text 'Yes' against each selected guest.",true);

     }
     catch(Exception e)
	   {
   	  throw e;

	   }

}



@Test(priority=19)
public void fn_verifyCheckinCheckoutRoomSharers() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		FP.fn_ClickCancelButton();
		//String str=GenericMethods.GetCurrentWindowID();
		ViewDetailsPage VDP=FP.fn_RightclkSingle(FrontdeskLandingPage.UNcheckinReserveID_G,FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(2000);
		EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		GroupToSingleReservationPage GSP=EP.fn_ClickRoomReservationID();
		Thread.sleep(2000);
		GSP.fn_ClickAfterCheckInFirstGuest_Link();
		Thread.sleep(2000);
		GSP.fn_ClickBeforeCheckOut_Link();
		
        System.out.println("TC_67 Executed");
        
        Reporter.log("TC_67: On changing Checkin and Checkout date for 1st and 2nd guest respectively in room sharer table,reservation gets updated on saving.As well as 1st guest Checks-in  one day later whereas 2nd guest Checks-out one day before.",true);

    }
    catch(Exception e)
	   {
  	  throw e;

	   }
}



@Test(priority=20)
public void fn_verifyTaxExemptInGrpReserv() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	Thread.sleep(2000);
    	AL.Frontdesklogin_20803();
    	Thread.sleep(2000);
    	CashCounterPage CCP=FCT.fn_ClickCountinueWithTrail_BT();
    	Thread.sleep(5000);
    	FrontdeskLandingPage FLP=CCP.NoOpenNewcounter();
    	Thread.sleep(3000);
    	FLP.fn_ClickCancelButton();
    	Thread.sleep(3000);
    	ReservationSearchResultLandingPage  RSR=FLP.fn_SearchReservationID("042513");
    	Thread.sleep(3000);
    	//used res#0222110 earlier
    	ViewDetailsPage VDP= RSR.fn_ClickOnSearchedRecord();
    	Thread.sleep(5000);
    	EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
    	Thread.sleep(5000);
    	EEP.fn_clkTaxExemptBtn();
    	EEP.verify_TETitle();
    	EEP.fn_selectTaxExempt();
    	Thread.sleep(5000);
    	EEP.fn_CalcTaxExempt();
    	
        System.out.println("TC_68_69 Executed");
        
        Reporter.log("TC_68: When in reserved group reservation of multiple rooms, checkbox against room is selected and 'Tax Exempt' button is clicked in order to exempt tax,system displays a new window as: 'Tax Exempt Group ID#' \n"
    		    +"TC_69: On selecting tax to be exempted and clicking 'OK' button,system exempt tax from selected room.",true);

    }
    catch(Exception e)
	   {
	  throw e;
	   }
}




@Test(priority=21)
public void fn_verifyPOSProdTransferToRoomPaymentVerification() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
    	Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		SRP.fn_VerifySampleRestaurantPage();
		Thread.sleep(3000);
		ConfirmOrderPage COP=SRP.fn_GenerateOrder();
		Thread.sleep(5000);
		ConfirmOrderPage1 COP1=COP.ConfirmOrder();
		Thread.sleep(5000);
		COP1.fn_verifyConfirmedOrder();
		OrderFolioPage OFP=COP1.BillTransferToRoom("105");
		OFP.fn_TransferToRoomButton();
		Thread.sleep(5000);
		OFP.fn_verifyTransactionCloseButton();
		Thread.sleep(5000);
		GenericMethods.driver.close();
		Thread.sleep(4000);
		GenericMethods.Switch_Parent_Window(str);
		Thread.sleep(4000);
		AccountStatementLandingPage ASP=FP.fn_NavigatePayment1();
		Thread.sleep(6000);
		ASP.VerifyPaymentPage();
		ASP.verifyAlert_ConsolidateBtnAccept();
		Thread.sleep(6000);
        ASP.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);


	    System.out.println("TC_71_72_73_74_75_76_77_78_79 Executed");
	    
	    	Reporter.log("TC_71: On clicking 'Sample Restaurant', system redirects user to 'Sample Restaurant' page. \n"
			    +"TC_72: On selecting featured product and clicking 'Generate Order', redirects user to new tab displayed selected product. \n"
			    +"TC_73: On clicking 'Confirm Order' button, selected order gets confirmed. \n"
			    +"TC_74: When room is selected from 'Room#' dropdown and 'Transfer to Room' button is clicked,confirmed order gets transferred to selected room no.\n"
			    +"TC_75: On clicking 'Transaction Close' button, transaction successfully gets saved in transaction list and a folio is generated for the same. \n"
			    +"TC_76: On right clicking reservation against which order has been transferred and clicking 'Payment', system redirects user to its account statement page.\n"
			    +"TC_77: When 'Consolidate Account' button is clicked on account statement page,a pop-up gets displayed with message as:\n"
			    +" 'Consolidate Now? Account Consolidate automatically at Night Audit.' \n"
			    +"TC_78: On accepting consolidate account pop-up,loading for the same occurs and account gets consolidated. \n"
			    +"TC_79: After consolidation if account,taxes against room and POS (if any) gets displayed in account statement.",true);
	}
    catch(Exception e)
	   {
 	   throw e;
	   }

}




@Test(priority=22)
public void fn_verifySampleRestaurantPaidTransactionClose() throws Exception
{
   try
   {
	    FrontdeskLoginPage AL=new FrontdeskLoginPage();
   	    FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
   	    Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		FP.fn_clickCurrentLnk();
        String str=GenericMethods.GetCurrentWindowID();
        SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
        Thread.sleep(10000);
        GenericMethods.windowHandle(str);
        //SRP.fn_VerifySampleRestaurantPage();
        //SRP.fn_VerifyGenerateAndConfirmOrderPage();
        ConfirmOrderPage COP=SRP.fn_GenerateOrder();
        Thread.sleep(4000);
        ConfirmOrderPage1 COP1=COP.ConfirmOrder();
       Thread.sleep(4000);
        COP1.fn_VerifyPayNowButton();
        Thread.sleep(7000);
       COP1.fn_verifyTransactionCloseButton();
       GenericMethods.driver.close();
       GenericMethods.Switch_Parent_Window(str);
       
       System.out.println("TC_80_81 Executed");
       
       Reporter.log("TC_80: When order is generated order is confirmed in POS and 'Pay Now' button is clicked,loading for 'Making Payment' starts,followed by successful payment. \n"
		       +"TC_81: On clicking 'Transaction Close' button, transaction successfully gets saved in transaction list and a folio is generated for the same.",true);

       
   }
   catch(Exception e)
	   {
	     throw e;
	   }
}




@Test(priority=23)
public void fn_verifyConsolidateAccountPopUp() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	Thread.sleep(5000);
    	AL.Frontdesklogin_20803();
    	Thread.sleep(5000);
    	CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
    	Thread.sleep(5000);
    	FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
    	Thread.sleep(5000);
    	FLP.fn_ClickCancelButton();
    	Thread.sleep(5000);
    	String a = GenericMethods.GetCurrentWindowID();
    	Thread.sleep(5000);
    	SampleRestaurantPage SRP = FLP.ClickToSampleRestaurant();
    	Thread.sleep(5000);
    	GenericMethods.windowHandle(a);
    	Thread.sleep(5000);
    	ConfirmOrderPage COP = SRP.GenrateOrder();
    	Thread.sleep(5000);
    	ConfirmOrderPage1 COP1 = COP.ConfirmOrder();
    	Thread.sleep(5000);
    	OrderFolioPage OFP=COP1.BillTransferToRoom("101");
		OFP.fn_TransferToRoomButton();
		Thread.sleep(5000);
		OFP.fn_verifyTransactionCloseButton();
		Thread.sleep(5000);
		GenericMethods.driver.close();
		Thread.sleep(4000);
		GenericMethods.Switch_Parent_Window(a);
		Thread.sleep(4000);
    	AccountStatementLandingPage ASL=FLP.fn_NavigatePayment();
    	Thread.sleep(5000);
    	ASL.verifyAlert_ConsolidateBtnAccept();
    	Thread.sleep(4000);
    	ASL.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);
    	
	    System.out.println("TC_82_83 Executed");
	    
	    Reporter.log("TC_82: When 'Consolidate Account' button is clicked on account statement page,a pop-up gets displayed with message as:\n"
			    +" 'Consolidate Now? Account Consolidate automatically at Night Audit.' \n"
			    +"TC_83: On accepting consolidate account pop-up,loading for the same occurs and account gets consolidated.",true);

	}
    catch(Exception e)
	   {
	  
    	throw e;
	   }

}






@Test(priority=24)
public void fn_verifyCustomChargeAllowanceInSingleCheckedInReserv() throws Exception
{
    try
    {
    	FrontdeskLoginPage AL=new FrontdeskLoginPage();
    	Thread.sleep(5000);
    	AL.Frontdesklogin_20803();
    	Thread.sleep(5000);
    	CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
    	Thread.sleep(5000);
    	FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
    	Thread.sleep(5000);
    	FLP.fn_ClickCancelButton();
    	Thread.sleep(5000);
    	ReservationSearchResultLandingPage RSR = FLP.fn_SearchReservationID("042168");
    	Thread.sleep(5000);
    	ViewDetailsPage VDP = RSR.fn_ClickOnSearchedRecord();
    	Thread.sleep(5000);
    	AccountStatementLandingPage ASL = VDP.ClickToPayment();
    	Thread.sleep(5000);
    	ASL.scroll_windowDown();
    	ASL.ClickToCustomCharge();
    	Thread.sleep(4000);
    	ASL.AddCustomCharge();
    	Thread.sleep(5000);
    	ASL.verifyAddedCustomCharge();
	    System.out.println("TC_84_85 Executed");
	    
	    Reporter.log("TC_84: When 'Custom Charge/Allowance' button is clicked in checked-in reservation,a new pop-up as: 'Custom Charge/Allowance' gets displayed. \n"
	    		     +"TC_85: On entering required fields in pop-up and clicking 'Save' button,loading for 'Updating Custom Charge' starts and custom charge successfully gets updated \n"
	    		 +"in account statement.",true);

	}
    catch(Exception e)
	   {
	   throw e;
	   }

}



@Test(priority=25)
public void fn_verifyOtherChargeInSingleCheckedinReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		Thread.sleep(5000);
		AL.Frontdesklogin_20803();
		Thread.sleep(5000);
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(5000);
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		Thread.sleep(5000);
		FLP.fn_ClickCancelButton();
		Thread.sleep(5000);
		ReservationSearchResultLandingPage RSR = FLP.fn_SearchReservationID("042169");
		Thread.sleep(5000);
		ViewDetailsPage VDP = RSR.fn_ClickOnSearchedRecord();
		Thread.sleep(5000);
		AccountStatementLandingPage ASL = VDP.ClickToPayment();
		Thread.sleep(5000);
		ASL.scroll_windowDown();
		ASL.VerifyOtherChargesPopUp();
		Thread.sleep(3000);
		ASL.AddOtherCharge();
		Thread.sleep(5000);
		ASL.VerifyOtherCharges();
		
	    System.out.println("TC_86_87 Executed");
	    
	    Reporter.log("TC_86: When 'Other Charges' button is clicked in checked-in reservation,a new pop-up as: 'Add Other Charges' gets displayed. \n"
    		     +"TC_87: On entering required fields in pop-up and clicking 'Save' button,loading for 'Updating Purchase' starts and charges successfully gets updated \n"
    		     +"in account statement.",true);

	    
	}
	 catch(Exception e)
	   {
	   throw e;
	   }

}




@Test(priority=26)
public void fn_verifyDeletePerformaInvoicePopUp() throws Exception
{
	try
	{
	FrontdeskLoginPage AL=new FrontdeskLoginPage();
	AL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    AccountStatementLandingPage ASP=FP.fn_NavigateAccountStmt();
    Thread.sleep(5000);
    ASP.fn_DeletePerformaInvoice();
    
    System.out.println("TC_88_89_90 Executed");
    
    Reporter.log("TC_88: On clicking 'Generate Folio' button,loading for 'Generating Folios' starts and folio gets successfully generated.\n"
    		    +"TC_89: When 'Delete Performa Invoice' button is clicked, pop-up with message as : \n"
    		    +"'Do you wish to delete all Perfoma Invoices?' gets displayed. \n"
    		    +"TC_90: When 'OK' button of pop-up is clicked, all generated folios successfully gets deleted.",true);
    
    
	}
	 catch(Exception e)
	   {
	   throw e;
	   }

}



@Test(priority=27)
public void fn_verifyRouteToNewFolioInReserv() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    AccountStatementLandingPage ASP=FP.fn_NavigateAccountStmt();
    Thread.sleep(3000);
    ASP.fn_addOtherCharge();
    Thread.sleep(4000);
    ASP.fn_addCustomCharges();
    Thread.sleep(4000);
    ASP.fn_CustomChargetoNewFolio();
    Thread.sleep(4000);
    ASP.fn_verifyRouteToNewFolio();
    ASP.fn_selectGuestIDToNewFolio();
    Thread.sleep(4000);
    ASP.fn_getPICustomCharge();
    Thread.sleep(4000);
    ASP.windowScrollUp();
    ASP.fn_verifyRoutedFolio();
    
    System.out.println("TC_92_93 Executed");
    
    Reporter.log("TC_92: When 'Route To New Folio' button is clicked in reservation's account statement,pop-up as: 'Create New Folio' gets displayed. \n"
    		+"On selecting a guest from dropdown and clicking 'Create' button in 'Create New Folio' pop-up,a new folio gets generated for selected guest under 'FOLIO LIST'.",true);
	}
	 catch(Exception e)
	   {
	   throw e;
	   }

}



@Test(priority=28)
public void fn_verifyRouteChargesInReserv() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	Thread.sleep(9000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(8000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(7000);
    FP.fn_ClickCancelButton();
    Thread.sleep(7000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    AccountStatementLandingPage ASP=FP.fn_NavigateAccountStmt();
    Thread.sleep(9000);
    ASP.fn_addOtherCharge();
    Thread.sleep(10000);
    ASP.fn_addCustomCharges();
    Thread.sleep(10000);
    ASP.fn_CustomChargetoNewFolio();
    Thread.sleep(9000);
    ASP.fn_selectGuestIDToNewFolio();
    Thread.sleep(9000);
    //ASP.fn_getPICustomCharge();
    ASP.fn_RouteCharges();
    Thread.sleep(9000);
    ASP.fn_verifyRouteCharges();
   // ASP.fn_selectGuestIDRouteCharge1();
    ASP.fn_selectGuest2RouteCharge();
    Thread.sleep(4000);
    ASP.windowScrollUp();
    ReservationFolioPage RFP=ASP.fn_verifyRoutedCustmChrgeG2();
    Thread.sleep(5000);
    RFP.fn_verifyRoutedCustomChrgTxt();
    Thread.sleep(4000);
    
    System.out.println("TC_94_95 Executed");
    
    Reporter.log("TC_94: When 'Route Charges' button in account statement is clicked,pop-up as: 'Route Charges' gets displayed. \n"
    		+"TC_95: On selecting guest from dropdown and clicking 'Route' button,charges successfully gets routed to the selected guest.",true);
	}
	 catch(Exception e)
	   {
	   
		 throw e;
	   }
}




@Test(priority=29)
public void fn_verifyRoutePayment() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	Thread.sleep(9000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(9000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(9000);
    FP.fn_ClickCancelButton();
    Thread.sleep(9000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    AccountStatementLandingPage ASP=FP.fn_NavigateAccountStmt();
    Thread.sleep(9000);
    ASP.fn_addOtherCharge();
    Thread.sleep(10000);
    ASP.fn_addCustomCharges();
    Thread.sleep(7000);
    ASP.fn_CustomChargetoNewFolio1();
    Thread.sleep(8000);
    ASP.fn_selectGuestIDToNewFolio();
    Thread.sleep(9000);
    ASP.fn_clkPayNow();
    Thread.sleep(9000);
   // Thread.sleep(3000);
    ASP.fn_clkRoutePayment1();
    Thread.sleep(9000);
    ASP.fn_verifyRoutePaymentTitle();
    Thread.sleep(2000);
    ASP.fn_selectGuest2RoutePayment();
    Thread.sleep(9000);
    ASP.windowScrollUp();
    ReservationFolioPage RSP=ASP.fn_verifyRoutedPaymentChrgeG2();
    Thread.sleep(9000);
    RSP.fn_verifyRoutedPaymentTxt();

    System.out.println("TC_96_97 Executed");
    
    Reporter.log("TC_96: When 'Route Payment' button in account statement is clicked,pop-up as: 'Route Payment' gets displayed. \n"
    		+"TC_97: On selecting guest from dropdown and clicking 'Route Payment' button,paid amount successfully gets routed to the selected guest.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=30)
public void fn_verifyRefund() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	Thread.sleep(9000);
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(9000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(9000);
    FP.fn_ClickCancelButton();
    Thread.sleep(9000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    AccountStatementLandingPage ASP=FP.fn_NavigateAccountStmt();
    Thread.sleep(9000);
    ASP.fn_addOtherCharge();
    Thread.sleep(10000);
    ASP.fn_addCustomCharges();
    Thread.sleep(10000);
    ASP.fn_clkRefundBtn();
    Thread.sleep(7000);
    ASP.fn_verifyRefundSingleTitle();
    ASP.fn_clkRefund();
    Thread.sleep(8000);
    ASP.fn_verifyRefund();
    
    System.out.println("TC_98_99 Executed");
    
    Reporter.log("TC_98: After selecting postd custom charge ,when 'Refund' button in account statement of a rservation,pop-up as: 'Refund' gets displayed. \n"
    		+"TC_99: On clicking 'Refund button of pop-up,loading for 'Refunding Amount' occurs and selected custom charge successfully gets refunded.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=31)
public void fn_verifySettleFolioAndLockPIAlertAccept() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		FrontdeskContinueTrialPage CP=AL.Frontdesklogin_20857();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
//		ReservationSearchResultLandingPage RSL=FP.fn_SearchReservationID("042948");
//		Thread.sleep(3000);
//		ViewDetailsPage VDP=RSL.fn_ClickOnSearchedRecord();
//		Thread.sleep(3000);
//		AccountStatementLandingPage ASL=VDP.ClickToPayment();
//		Thread.sleep(3000);
		AccountStatementLandingPage ASL=FP.fn_NavigatePayment2();
		Thread.sleep(4000);
		ASL.fn_addOtherCharge();
		Thread.sleep(10000);
		ASL.fn_clkGenerateFolio();
		Thread.sleep(8000);
//		ASL.fn_ValidatePaidAMTby_Checqe();
//		Thread.sleep(3000);
		ASL.fn_getPINum();
		Thread.sleep(1000);
		ASL.fn_makeFullPayment();
		Thread.sleep(3000);
		ASL.fn_ClickSettleFolio_Accept();
		Thread.sleep(3000);
	    ASL.fn_LockFolio();
	   // ASL.fn_verifyLockFolioPopup();
	    ASL.fn_verifyLockedFolio();
	    
		System.out.println("TC_100_101_102_103_104 Executed");
		
		Reporter.log("TC_100: When 'Pay Now' button is clicked after making payment through cheque,loading for 'Saving Payments' occur and payment successfully gets saved. \n"
				+"TC_101: On clicking 'Settle Folio' button in checked out or reservation whose check-out date is due,alert message as: 'Do you wish to settle all folios?' appears. \n"
				+"TC_102: When 'OK' button for settle folio alert is clicked,loading for 'Settling Folios' occur and folios gets settled successfully. \n"
				+"TC_103: On clicking 'Lock Image' in 'Folio List' against folio to be locked,alert message as: 'Do you wish to close this folio?' occurs, \n"
				+"TC_104: When 'OK' button of lock image alert is clicked,folio/PI gets locked and becomes an INV wherein no changes can be done and cannot be unlocked/deleted.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}





@Test(priority=32)
public void fn_verifyAdditionOfAddOnInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
//		ReservationSearchResultLandingPage RSL=FP.fn_SearchReservationID("042515");
//		Thread.sleep(3000);
//		ViewDetailsPage VDP=RSL.fn_ClickOnSearchedRecord();
		ViewDetailsPage VDP=FP.fn_GrpAddOn();
		Thread.sleep(3000);
		EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EP.fn_ValidateInclusionAddOns_Link();
		EP.fn_ValidateSelectedIncluAddons();
		
        System.out.println("TC_115_116 Executed");
        
        Reporter.log("TC_115: When 'Inclusions/Add-ons' under 'Rates/Packages' is clicked in a reserved group reservation of multiple rooms,new pop-up as :'Select Add-ons' gets displayed. \n"
        		+"TC_116: When add-on is selected and 'Done' button is clicked,loading for 'Updating Inclusions' occur and then selected add-on gets successfully added to the group reservation.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}





@Test(priority=33)
public void fn_verifyPriceChangeInGrpReservRoom() throws Exception
{
	try
	
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		Thread.sleep(5000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ID, FrontdeskLandingPage.rightClk_viewDetails);
        EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EP.fn_ChangePrice();
		Thread.sleep(5000);
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ID, FrontdeskLandingPage.rightClk_viewDetails);
        VDP.ClickToEnableEditingBtn();
        Thread.sleep(8000);
        EP.fn_verifyChangedPrice();

        System.out.println("TC_117 Executed");
        
        Reporter.log("TC_117: When price for any room in group reservation of multiple rooms and 'Save' button is clicked, loading for 'Saving Group Reservation' occurs and "
        		+" then changes gets successfully saved.",true);
	}
	 catch(Exception e)
	   {
 	  	   throw e;

	   }
}





@Test(priority=34)
public void fn_verifyRoomTariffChangeForExtraBedinGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ID, FrontdeskLandingPage.rightClk_viewDetails);
		EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		GroupToSingleReservationPage GRP=EP.fn_ClickRoomReservationID();
		Thread.sleep(3000);
		GRP.fn_ValidateExtraBed();
		Thread.sleep(3000);
		GRP.fn_ClickBackToGroup();
		Thread.sleep(3000);
		//EP.fn_clkGrpSave();
        System.out.println("TC_118_119 Executed");
        Reporter.log("TC_118: When no. of 'Extra Bed' dropdown is changed ,then loading for 'Adding Extra Bed(s)' occurs and extra bed gets successfully added. \n"
        		+"TC_119: When no. of Extra Bed changes in a group reservation of multiple room,then there is either increase or decrease of 'Room Tariff' depending on the no. of extra bed selected.",true);
	 
	}
        catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=35)
public void fn_verifyAddGuestDetailsInGrpReserv() throws Exception
{
	try
	{
		 FrontdeskLoginPage AL=new FrontdeskLoginPage();
		 FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		 CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		 FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		 FP.fn_ClickCancelButton();
		 ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_BarkhaID1, FrontdeskLandingPage.rightClk_viewDetails);
		 Thread.sleep(2000);
		 EnableEditingPage EP=VDP.ClickToEnableEditingBtn();
		 Thread.sleep(7000);	 
		 EP.fn_AddGuestDetailForRoom();
		 Thread.sleep(3000);
		 EP.verify_savedGuestDetail();
		 
         System.out.println("TC_120 Executed");
         
         Reporter.log("TC_120: When 'Add Guest Details' is cliked for a room in group reservation wherein on entering 'First Name','Last Name' and 'Phone' followed by clicking 'Save' button \n"
        		 +" loading for 'Saving group reservation occurs and details successfully gets added.'",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}




@Test(priority=36)
public void fn_verifyAddEditDetailsInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
	    Thread.sleep(2000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(2000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(2000);
		FP.fn_ClickCancelButton();
		Thread.sleep(2000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_HarveshID, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(2000);
		VDP.fn_ClickAddEditDetails_link();
		Thread.sleep(2000);
		VDP.fn_ChangeDetails();
        System.out.println("TC_121_122 Executed");
        
        Reporter.log("TC_121: When 'Add/Edit Details' is clicked in group reservation and any of the provide guest detail is changed,followed by clicking 'Save' button "
        		+"loading for 'Saving Guest Information' starts.\n"
        		+"TC_122: When 'Close' is clicked after saving added/edited guest details,loading for 'Saving Group Reservation' starts and changes gets successfully changed.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=37)
public void fn_verifyRTClickCheckinForGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		Thread.sleep(4000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(4000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(4000);
		FP.fn_ClickCancelButton();
		Thread.sleep(4000);
		String str=GenericMethods.GetCurrentWindowID();
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ForCheckIN, FrontdeskLandingPage.rightClk_CheckIN);
		Thread.sleep(5000);
		GenericMethods.windowHandle(str);
		GenericMethods.driver.close();
		GenericMethods.Switch_Parent_Window(str);
		Thread.sleep(4000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ForCheckIN, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(6000);
		VDP.fn_ValidateCheckINstatus();
		Thread.sleep(4000);
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		GroupToSingleReservationPage GSP=EEP.fn_clkSingleGuest();
		GSP.fn_ClickCancelCheckIn_BT();
		EEP.clk_grpSaveBtn();
//		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.GroupReservation_ForCheckIN, FrontdeskLandingPage.rightClk_CancelCheckIN);
//		Thread.sleep(4000);
//		GenericMethods.ActionOnAlert("Accept");
     
		System.out.println("TC_123 Executed");
		
		Reporter.log("TC_123: On right clicking a group reservation and selecting 'Check In',loading for 'Updating Reservation Status' starts and then status gets successfully updated. \n"
				+"Note: When we click 'Check In' for group reservation,only guest of that particular rooms gets checked in,rest of the guest in other room of that reservation remain reserved.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}





@Test(priority=38)
public void fn_verifyRTClickGrpCheckinCancelCheckinInGrpReserv() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20819();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_rightClkGrpCheckin();
    Thread.sleep(4000);
    FP.fn_AcceptCancelCheckinGrp();
    Thread.sleep(4000);
    ViewDetailsPage VDP=FP.fn_rightclkViewDetailsGrp1();
    Thread.sleep(4000);
    EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
    Thread.sleep(4000);
    EEP.fn_verifyCancelledCheckin();
    Thread.sleep(4000);
    GroupToSingleReservationPage GSP=EEP.fn_clkSingleGuest();
    Thread.sleep(4000);
    GSP.fn_clkCancelCheckinGrp();
    Thread.sleep(4000);
    EEP.fn_clkGrpSave();
    
    System.out.println("TC_124_125_126 Executed");
    
    Reporter.log("TC_124: On right clicking group reservation and selecting 'Group Check In',loading for 'Updating Group Reservation' starts and status gets successfully updated. \n"
    		+"TC_125: Now on right clicking checked in group reservation and selecting 'Cancel Check In',pop up with message as: \n"
    		+"'Do you wish to Unassign the reservation?' gets displayed.\n"
    		+"TC_126: When 'OK' button of 'Cancel Check In' pop up is clicked, loading for 'Updating Room display' starts and then reservation status gets successfully updated.",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}





@Test(priority=39)
public void fn_verifyCheckinSelected() throws Exception
{
	try
	{
	FrontdeskLoginPage FL=new FrontdeskLoginPage();
	FL.Frontdesklogin_20819();
	FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	Thread.sleep(4000);
	FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
    Thread.sleep(4000);
    FP.fn_ClickCancelButton();
    Thread.sleep(4000);
    FP.fn_clickCurrentLnk();
    Thread.sleep(7000);
    FP.fn_rightclkViewDetailsGrp1();
    Thread.sleep(4000);
    ViewDetailsPage VDP=new ViewDetailsPage();
    VDP.ClickToEnableEditingBtn();
    Thread.sleep(4000);
    EnableEditingPage EEP=new EnableEditingPage();
    String a=GenericMethods.GetCurrentWindowID();
    EEP.fn_AcceptCheckinSelected();
    Thread.sleep(4000);
    CheckinCard CC=new CheckinCard();
    GenericMethods.windowHandle(a);
    CC.fn_verifyCheckedinGuest();
    GenericMethods.Switch_Parent_Window(a);
    Thread.sleep(4000);
    FP.fn_rightclkViewDetailsGrp1();
    Thread.sleep(4000);
    VDP.ClickToEnableEditingBtn();
    Thread.sleep(4000);
    EEP.fn_clkSingleGuest();
    Thread.sleep(4000);
    GroupToSingleReservationPage GSP=new GroupToSingleReservationPage();
    GSP.fn_clkCancelCheckinGrp();
    Thread.sleep(4000);
    EEP.fn_clkGrpSave();
    
    System.out.println("TC_127_128 Executed");
    
    Reporter.log("TC_127: On selecting checkbox against room in group reservation which needs to be checked in and clicking 'Check-in Selected' \n"
    		+"pop up with message as: 'Do you wish to check in selected reservation?' \n"
    		+"TC_128: When 'OK' button of 'Check-in Selected' pop up is clicked,selected room gets successfully checked in.",true);
    
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}





@Test(priority=40)
public void fn_verifyAddNewRoomDeleteActionInGrpReserv() throws Exception
{
	try
	{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		ViewDetailsPage VDP=FLP.fn_GrpAddNewRoom();
		Thread.sleep(4000);
		 EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4221090' and @title='73. Komal zINDAL(G)")));
		//GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4221090' and @title='73. Komal zINDAL(G)"))
		Thread.sleep(3000);
		//new ViewDetailsPage().ClickToPayment();
		//Thread.sleep(5000);
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		//Thread.sleep(3000);*
		EEP.AddNewRoomToG();
		Thread.sleep(2000);
		//EEP.fn_addNewRoomDetail();
		//Thread.sleep(3000);
		EEP.VerifyDeleteAlertAddedRoom("Accept");
		Thread.sleep(2000);
		EEP.VerifyDeletedRoom();
		
        System.out.println("TC_129_130_131_132 Executed");
        
        Reporter.log("TC_129: When 'Add New Room' button in a group reservation is clicked,a new pop up for 'Add New Room' gets displayed. \n"
        		+"TC_130: On entering required details in 'Add New Room(s)' pop up and clicking 'Add' button,loading for 'Adding New Room(s)' occurs and room gets successfully added. \n"
        		+"TC_131: When delete icon under 'Action' column against added room is clicked in group reservation,a new pop up message as: \n"
        		+"'Do you wish to delete selected room(s)' appears, \n"
        		+"TC_132: When 'OK' button of delete icon pop up is clicked,loading for 'Deleting Room(s)' occurs and room gets successfully deleted .\n"
        		+"Note: Only rooms without reservation ID can be deleted.",true);
       
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=41)
public void fn_verifyEarlyCheckinSelectedInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FLP.fn_RightclkforViewDetailsPage(FLP.grp_earlyCheckin, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(3000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EEP.VerifyEarlyCheckInAlert();
		String a=GenericMethods.GetCurrentWindowID();
		CheckinCard CC=EEP.VerifyEarlyCheckInPopUp();
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4230208' and @title='76. sougata mondal(G) ']")));
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		GenericMethods.windowHandle(a);
		Thread.sleep(3000);
		CC.fn_clkCloseBtn();
		GenericMethods.Switch_Parent_Window(a);
		Thread.sleep(3000);
		//EEP.CheckInReservationAndVerifyCheckIn();
		FLP.fn_RightclkforViewDetailsPage(FLP.grp_earlyCheckin, FrontdeskLandingPage.rightClk_viewDetails);;
		Thread.sleep(2000);
		VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		GroupToSingleReservationPage GTSP=EEP.fn_clkSingleGuest();
		Thread.sleep(2000);
		GTSP.fn_clkCancelCheckinGrp();
		Thread.sleep(3000);
		EEP.fn_clkGrpSave();
		
        System.out.println("TC_133_134_135 Executed");
        
        Reporter.log("TC_133: On selecting checkbox for room that is to be early checked in an unchecked group reservation,followed by clicking 'Early Check-in Selected' button \n"
        		+"a new pop up for 'Early Checkin' appears. \n"
        		+"TC_134: When Reason,Charge ,Description is enetred and 'Early Checkin' button is clicked, a new message: \n"
        		+"'Do you wish to early check-in the Selected Reservation?' appears."
        		+"TC_135: When 'OK' button of 'Early Check-in Selected' pop up is clicked,loading for 'Updating Room Display' occurs and selected room gets successfully checked in.\n",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}





@Test(priority=42)
public void fn_verifyNoShowSelectedInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		ViewDetailsPage VDP=FLP.fn_GrpNoShow();
		Thread.sleep(3000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EEP.VerifyNoShowPopUpTitle();
		Thread.sleep(2000);
		EEP.verify_NoShowTitle();
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315051' and @title='120. Hanshel Tiron(G) ']")));
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		EEP.VerifyNoShowForReservation();
		
	    System.out.println("TC_136_137_138 Executed");
	    
	    Reporter.log("TC_136: ",true);
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}




@Test(priority=43)
public void fn_verifyAmountChangeInUncheckedGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		ViewDetailsPage VDP=FLP.fn_GrpDiscount();
		Thread.sleep(4000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		EEP.VerifyRateDetailPopUp();
		Thread.sleep(4000);
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315306' and @title='122. T pain(G)(A)']")));
		//EnableEditingPage EEP=new ViewDetailsPage().ClickToEnableEditingBtn();
		EEP.fn_applyDiscount();
		Thread.sleep(3000);
		FLP.fn_GrpDiscount();
		Thread.sleep(2000);
		VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		EEP.verify_DiscountAfterSave();
        System.out.println("TC_139_140_141 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=44)
public void fn_verifyManageSharerInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		ViewDetailsPage VDP=FLP.fn_GrpManageSharer();
		Thread.sleep(2000);
		EnableEditingPage EEP= VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
	    GroupToSingleReservationPage GTSP=EEP.fn_ClickRoomReservationID();
	    Thread.sleep(3000);
	    GTSP.fn_clkManageSharerLnk();
	    Thread.sleep(3000);
	    GTSP.fn_verifyManageSharerTitle();
	    Thread.sleep(3000);
	    GTSP.fn_checkSharerGuest();
	    Thread.sleep(3000);
	    GTSP.fn_verifyManagerSharerYes();
	    Thread.sleep(3000);
	    GTSP.fn_ClickBackToGroup();
        System.out.println("TC_142_143_144 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=45)
public void fn_verifyCheckinDateChangeForRoomInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
	    ViewDetailsPage VDP=FLP.fn_GrpManageSharer();
	    Thread.sleep(5000);
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(5000);
		//FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315442' and @title='127. deepak thayat(G)(A)']")));
		//new ViewDetailsPage().ClickToEnableEditingBtn();
		EEP.fn_SelectDateFrmDatePicker(EnableEditingPage.date_ChkInRoom, "Apr", "2016", "3");
		Thread.sleep(3000);
        //EEP.fn_clkGrpSave();
		System.out.println("TC_145_146 Executed");

	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=46)
public void fn_verifyCheckoutDateChangeForRoomInGrpReserv() throws Exception
{
	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		ViewDetailsPage VDP=FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.UNcheckinReserveID_G, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(3000);
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(3000);
		EEP.fn_ValidateOneDayBeforeCheckOut();
		Thread.sleep(5000);
		EEP.fn_clkGrpSave();
		Thread.sleep(5000);
		FP.fn_RightclkforViewDetailsPage(FrontdeskLandingPage.UNcheckinReserveID_G, FrontdeskLandingPage.rightClk_viewDetails);
		Thread.sleep(5000);
		VDP.ClickToEnableEditingBtn();
		Thread.sleep(5000);
		EEP.fn_SetPreviousCheckOutDate();
		Thread.sleep(3000);
		EEP.fn_clkGrpSave();
		//Thread.sleep(3000);
	    System.out.println("TC_147_148 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=47)
public void fn_verifyTaxExemptForRoomInGrpReserv() throws Exception
{

	try
	{
		    FrontdeskLoginPage AL=new FrontdeskLoginPage();
		    AL.Frontdesklogin_20803();
			CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
			FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
			Thread.sleep(3000);
			FLP.fn_ClickCancelButton();
			Thread.sleep(2000);
			ReservationSearchResultLandingPage  RSR=FLP.fn_SearchReservationID("042614");
			Thread.sleep(2000);
			ViewDetailsPage VDP=RSR.fn_ClickOnSearchedRecord();
			Thread.sleep(3000);
			EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
			Thread.sleep(3000);
			GroupToSingleReservationPage GSR= EEP.fn_clkGuestName();
			Thread.sleep(3000);
			GSR.fn_getRoomTax();
			Thread.sleep(2000);
			EEP.fn_clkTaxExemptBtn();
			Thread.sleep(3000);
			EEP.verify_TETitle();
			EEP.fn_selectTaxExempt();
			Thread.sleep(3000);
			EEP.fn_clkGuestName();
			Thread.sleep(3000);
			GSR.fn_CalcTaxExemptGTS();
			Thread.sleep(3000);
			
			System.out.println("TC_149_150_151 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}



@Test(priority=48)
public void fn_verifyPayTermInGrpReserv() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		ViewDetailsPage VDP=FLP.fn_GrpManageSharer();
		Thread.sleep(2000);
		//VDP.ClickToEnableEditingBtn();
		//ViewDetailsPage VDP=FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='2315442' and @title='127. deepak thayat(G)(A)']")));
		EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
		Thread.sleep(2000);
		String payee=EEP.ChangePayTerm(1);
		Thread.sleep(2000);
		GenericMethods.driver.navigate().refresh();
		Thread.sleep(5000);
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		FLP.fn_GrpManageSharer();
		Thread.sleep(2000);
	    EnableEditingPage EEP1=VDP.ClickToEnableEditingBtn();
		EEP1.VerifyPayTerm(payee);
	    System.out.println("TC_152 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=49)
public void fn_verifyDNRForSelectedRoom() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.Frontdesklogin_20803();
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		FLP.VerifyDNR();
	    System.out.println("TC_153_154 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=50)
public void fn_verifyTransferToRoomInGrpReserv() throws Exception
{

	try
	{
	  FrontdeskLoginPage AL=new FrontdeskLoginPage();
	  FrontdeskContinueTrialPage CP=AL.Frontdesklogin_20819();
	  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	  Thread.sleep(2000);
	  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	  Thread.sleep(2000);
      FP.fn_ClickCancelButton();
      String str=GenericMethods.GetCurrentWindowID();
      SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
      GenericMethods.windowHandle(str);
      Thread.sleep(4000);
      //SRP.fn_VerifySampleRestaurantPage();
      ConfirmOrderPage COP=SRP.fn_GenerateOrder();
      Thread.sleep(6000);
      ConfirmOrderPage1 COP1=COP.fn_clkConfirmOrderGrp1();
  	  Thread.sleep(6000);
  	  Thread.sleep(3000);
      OrderFolioPage OFP=COP1.fn_clkTransferTotRoom();
      Thread.sleep(5000);
      OFP.fn_verifyTransactionCloseButton();
      Thread.sleep(4000);
      GenericMethods.Switch_Parent_Window(str);
      FP.WindowScroll();
      Thread.sleep(3000);
      AccountStatementLandingPage ASP=FP.fn_RightclkGrp(FP.grp_TTRoom,FrontdeskLandingPage.rightClk_Payment);
      ASP.scroll_windowDown();
      Thread.sleep(4000);
      ASP.clk_GrpConsolidateBtn();
      Thread.sleep(4000);
      ASP.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);
      
      System.out.println("TC_156_157 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}




    //Auto Night Audit is being performed wherein postings needs to be checked manually


	@Test(priority=51)
	public void fn_verifyPerformAutoNAPaymentPostingInGrpReserv() throws Exception
	{

		try
		{
			FrontdeskLoginPage AL=new FrontdeskLoginPage();
			FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20805();
			CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(5000);
			FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
			Thread.sleep(5000);
			FP.fn_RefreshFrontdesk();
			Thread.sleep(5000);
			FP.fn_AutoNightAudit1();
			Thread.sleep(3000);
			
	        System.out.println("TC_158_159_160_161 Executed");
		}
		 catch(Exception e)
	 	   {
		  	   throw e;

	 	   }
	}





@Test(priority=52)
public void fn_verifyConsolidateAccountInNightAuditedGrpReserv() throws Exception
{

      try
      {
	  FrontdeskLoginPage AL=new FrontdeskLoginPage();
	  FrontdeskContinueTrialPage CP=AL.Frontdesklogin_20819();
	  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	  Thread.sleep(4000);
	  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	  Thread.sleep(4000);
      FP.fn_ClickCancelButton();
      String str=GenericMethods.GetCurrentWindowID();
      SampleRestaurantPage SRP=FP.ClickToSampleRestaurant();
      GenericMethods.windowHandle(str);
      Thread.sleep(6000);
      //SRP.fn_VerifySampleRestaurantPage();
      ConfirmOrderPage COP=SRP.fn_GenerateOrder();
      Thread.sleep(6000);
      ConfirmOrderPage1 COP1=COP.fn_clkConfirmOrderGrp();
  	  Thread.sleep(6000);
  	  Thread.sleep(3000);
      OrderFolioPage OFP=COP1.fn_clkTransferTotRoom();
      Thread.sleep(5000);
      OFP.fn_verifyTransactionCloseButton();
      Thread.sleep(4000);
      GenericMethods.Switch_Parent_Window(str);
      FP.WindowScroll();
      Thread.sleep(3000);
      AccountStatementLandingPage ASP=FP.fn_NavigateAccntstmtGenerateFolio();
      ASP.scroll_windowDown();
      Thread.sleep(4000);
      ASP.clk_GrpConsolidateBtn();
      Thread.sleep(4000);
      ASP.VerifyTransferedItem(OFP.folioId.trim(),OFP.folioTax);
	  
      System.out.println("TC_162 Executed");
      }
      catch(Exception e)
	   {
     	   throw e;

	   }
}



	@Test(priority=53)
	public void TC_163_164_165_166_167() throws Exception
	{

		try
		{
		  FrontdeskLoginPage FL=new FrontdeskLoginPage();
		  FL.Frontdesklogin_20819();
		  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntstmtGenerateFolio();
          Thread.sleep(4000);
          ASP.fn_addCustomChargesGrp();
          Thread.sleep(4000);
		  ASP.fn_addOtherChargeGFolio();
		  Thread.sleep(4000);
		  ASP.fn_clkGenerateFolio();
		  Thread.sleep(15000);
		  ASP.fn_verifyGeneratedFolio();
		  Thread.sleep(4000);
		  ASP.fn_clkGenerateFolio();
		  Thread.sleep(3000);
		  ASP.fn_clkTaxExemptBtn();
		  Thread.sleep(4000);
		  ASP.fn_saveTaxExempt();
		  Thread.sleep(4000);
		  ASP.fn_verifyTaxExempted();
		  Thread.sleep(4000);
		  ASP.fn_verifyGeneratedFolio();
		  System.out.println("TC_163_164_165_166_167 Executed");
		}
		 catch(Exception e)
	 	   {
		  	   throw e;

	 	   }
	}




   @Test(priority=54)
   public void fn_verifyRouteChargeIn1NightAuditedGrpReserv() throws Exception
   {

	   try
	   {
	      FrontdeskLoginPage FL=new FrontdeskLoginPage();
	      FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20857();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_addOtherChargeGrp();
          Thread.sleep(4000);
	      ASP.fn_RouteChargesGrp();
          Thread.sleep(3000);
          ASP.fn_verifyRCGrpTitle();
          Thread.sleep(2000);
	      ASP.fn_selectGuest2RouteChargeGrp();
	      Thread.sleep(5000);
	      ReservationFolioPage RSP=ASP.fn_verifyRoutedOtherChrgeG2Grp();
          Thread.sleep(3000);
          RSP.fn_verifyRoutedOtherChrgTxt();
          
          System.out.println("TC_168_169 Executed");
	   }
	   catch(Exception e)
 	   {
	  	   throw e;

 	   }
   }




    @Test(priority=55)
    public void fn_verifyRouteToNewFolioIn1NightAuditedGrpReserv() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20857();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_addOtherChargeGrp();
	      Thread.sleep(4000);
	      ASP.fn_routeToNewFolioGrp();
	      Thread.sleep(3000);
	      ASP.fn_verifyRouteToNewFolioGrp();
	      Thread.sleep(2000);
	      ASP.fn_selectGuestIDToNewFolioGrp();
	      Thread.sleep(4000);
	      ASP.fn_getPINum();
	      Thread.sleep(4000);
	      ASP.fn_verifyRoutedFolio();
	      System.out.println("TC_170_171 Executed");
    	}
    	 catch(Exception e)
  	   {
    	  	   throw e;

  	   }
    }




   @Test(priority=56)
   public void fn_verifyRoutePaymentIn1NightAuditedGrpReserv() throws Exception
   {

	   try
	   {
	      FrontdeskLoginPage FL=new FrontdeskLoginPage();
	      FrontdeskContinueTrialPage CP=FL.Frontdesklogin_20857();
          Thread.sleep(3000);
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_clkPayNowGrp();
	      Thread.sleep(3000);
	      ASP.fn_verifyPaidAmt();
          Thread.sleep(3000);
	      ASP.fn_clkRoutePaymentGrp();
	      Thread.sleep(4000);
	      ASP.fn_routePaymentGrp();
	      Thread.sleep(4000);
	      ASP.fn_afterRoutePaymentPI();
	      Thread.sleep(4000);
	      ReservationFolioPage RFP=ASP.fn_clkFolio();
	      RFP.fn_verifyPaidAmt();
	      System.out.println("TC_172_173 Executed");
	   }
	   catch(Exception e)
 	   {
	  	   throw e;

 	   }
   }
*/
   

    @Test(priority=57)
    public void fn_verifyCashModePayNowInGrpReserv() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20857();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(7000);
	      AccountStatementLandingPage ASP=FP.fn_NavigateAccntStmtGrp();
	      Thread.sleep(4000);
	      ASP.fn_addOtherChargeGrp();
	      Thread.sleep(4000);
	      ASP.fn_addCustomChargesGrp();
	      Thread.sleep(4000);
	      ASP.fn_clkRefundBtnGrp();
	      Thread.sleep(3000);
	      ASP.fn_verifyRefundGrpTitle();
	      Thread.sleep(2000);
	      ASP.fn_clkRefund();
	      Thread.sleep(3000);
	      ASP.fn_verifyRefundGrp();
	      Thread.sleep(3000);
	      ASP.fn_payNowCheque();
	      Thread.sleep(4000);
	      ASP.fn_verifyPaidAmtChequeGrp();
	      System.out.println("TC_174_175 Executed");
    	}
    	 catch(Exception e)
  	   {
    	  	   throw e;

  	   }
    }




    @Test(priority=58)
    public void fn_verifyChequeModePayNowInGrpReserv() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20857();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(4000);
	      ViewDetailsPage VDP=FP.fn_rightClkViewDetailsGrp2();
	      Thread.sleep(4000);
	      EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
	      Thread.sleep(5000);
	      GroupToSingleReservationPage GSP=EEP.fn_clkGuestName();
	      Thread.sleep(4000);
	      AccountStatementLandingPage ASP=GSP.fn_clkPaymentSingleguest();
	      Thread.sleep(4000);
	      ASP.fn_payNowCheque();
	      Thread.sleep(4000);
	      ASP.fn_verifyPaidAmtChequeGrp();
	      System.out.println("TC_176 Executed");
    	}
    	 catch(Exception e)
  	   {
    	  	   throw e;

  	   }
    }


    @Test(priority=59)
    public void TC_177_178_179() throws Exception
    {

    	try
    	{
    	  FrontdeskLoginPage FL=new FrontdeskLoginPage();
   	      FL.Frontdesklogin_20858();
    	  FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		  CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		  Thread.sleep(4000);
		  FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		  Thread.sleep(4000);
	      FP.fn_ClickCancelButton();
	      Thread.sleep(4000);
	      FP.fn_clickCurrentLnk();
	      Thread.sleep(4000);
	      FP.fn_NavigateAccntStmtGrp1();
	      Thread.sleep(4000);
	      AccountStatementLandingPage ASP=new AccountStatementLandingPage();
          ASP.fn_addOtherChargeSetteFolio();
          Thread.sleep(4000);
          ASP.fn_clkGenerateFolio();
          Thread.sleep(15000);
          ASP.fn_clkSettleFolioAccept();
          Thread.sleep(4000);
          ASP.fn_getPINum();
          Thread.sleep(4000);
          ASP.fn_LockFolio();
          Thread.sleep(4000);
         // ASP.fn_verifyLockFolioPopup();
          //Thread.sleep(4000);
          ASP.fn_verifyLockedFolio();
          System.out.println("TC_177_178_179 Executed");
    	}
    	 catch(Exception e)
  	   {
    	  	   throw e;

  	   }
    }



/*
@Test(priority=60)
public void fn_verifyRatesandTaxesInWebReserv() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		Thread.sleep(2000);
		AL.Frontdesklogin_20803();
		Thread.sleep(2000);
		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(2000);
		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		Thread.sleep(2000);
		FLP.fn_ClickCancelButton();
		Thread.sleep(2000);
		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		Thread.sleep(2000);
		ExcelUtil.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Smoke1");
		Thread.sleep(2000);
		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		Thread.sleep(2000);
		String a=GenericMethods.GetCurrentWindowID();
		Thread.sleep(2000);
		WebReservationHomePage  WRH=FLP.ClickOnWebReservation();
		Thread.sleep(2000);
		GenericMethods.windowHandle(a);
		Thread.sleep(4000);
		WRH.fn_ValidateStaydetailsPage();
		Thread.sleep(4000);
		WebSelectRoomPage WSR= WRH.fn_CheckAvability();
		Thread.sleep(2000);
		WSR.fn_ValidateRoomPackagesSection();
		Thread.sleep(4000);
		WebAddMoreRoomPage WAM=WSR.SelectRoom();
		Thread.sleep(2000);
		WAM.fn_pageVerify();
		Thread.sleep(4000);
		WebConfirmReservationPage WCR=WAM.ClickOnConfirmBtn();
		Thread.sleep(2000);
		WCR.fn_ConfirmBookingPaymentPage();
		
		WebConfirmReservationPrintPage WCRP=WCR.ConfirmBooking(iTestCaseRow);
		Thread.sleep(2000);
		ArrayList<String> AmtDetails=WCRP.GetAmtDetails();
		Thread.sleep(2000);
		String rid=WCRP.GetReservationId();
		Thread.sleep(2000);
		WCRP.CloseWindow();
		Thread.sleep(2000);
		GenericMethods.Switch_Parent_Window(a);
//		Thread.sleep(2000);
//		GenericMethods.Alert_Accept();
//		Thread.sleep(2000);
//		GenericMethods.driver.close();
//		Thread.sleep(2000);
//		GenericMethods.fn_OpenFrontdesk("FF", "http://hotelogix.staygrid.com/frontdesk/login/login/");
//		Thread.sleep(2000);
//		FrontdeskLoginPage AL1=new FrontdeskLoginPage();
//		Thread.sleep(2000);
//		AL1.Frontdesklogin_20803();
//		Thread.sleep(2000);
//		CashCounterPage CCP1 = FCT.fn_ClickCountinueWithTrail_BT();
//		Thread.sleep(2000);
//		FrontdeskLandingPage FLP1 = CCP1.NoOpenNewcounter();
//		Thread.sleep(2000);
//		FLP1.fn_ClickOnCancelButton();
		Thread.sleep(2000);
		ReservationSearchResultLandingPage RSR= FLP.fn_SearchByReservationID(rid.trim());
		Thread.sleep(2000);
		ViewDetailsPage VDP= RSR.fn_ClickOnSearchedRecord();
		Thread.sleep(2000);
		ArrayList<String> amtDetails= VDP.GetAmtDetails();
		Thread.sleep(2000);
		Assert.assertEquals(AmtDetails, amtDetails);
		Thread.sleep(2000);
    System.out.println("TC_180_181_182_183_184_185_186_187_188 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}



@Test(priority=61)
public void fn_verifyWebPkgOnSelectRoomPackagesPage() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		WebReservationHomePage WRP =FP.fn_WebReservationLink();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		WebSelectRoomPage WSP=WRP.fn_CheckAvability();
		Thread.sleep(3000);
		WSP.pageVerify();
		Thread.sleep(3000);
		WSP.fn_SelectWebPackagesOnWeb();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_189 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=62)
public void fn_verifyWebRatesOnSelectRoomPackagesPage() throws Exception
{

	try
	{
		    FrontdeskLoginPage AL=new FrontdeskLoginPage();
		    AL.FrontDesklogin_20787();
		    Thread.sleep(3000);
			FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
			CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
			Thread.sleep(3000);
			FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
			Thread.sleep(3000);
			FP.fn_ClickCancelButton();
		    Thread.sleep(3000);
		    String str=GenericMethods.GetCurrentWindowID();
		    BasePage BP=FP.fn_clkAdminLnk();
		    GenericMethods.windowHandle(str);
		    Thread.sleep(6000);
		    ListOfPackagesWeb LPW=BP.fn_navigateWebPkg();
		    Thread.sleep(6000);
		    PackageDetailsWeb PDW=LPW.clkEdit_1NPkg();
		    Thread.sleep(5000);
		    PDW.get_PkgName();
		    Thread.sleep(5000);
		    PDW.get_PublishedPkgPrice();
		    Thread.sleep(7000);
            PDW.clickOnSave_BT();
		    GenericMethods.driver.close();
		    GenericMethods.Switch_Parent_Window(str);
		    String str1=GenericMethods.GetCurrentWindowID();
			WebReservationHomePage WRP =FP.fn_WebReservationLink();
			GenericMethods.windowHandle(str1);
			Thread.sleep(3000);
			WebSelectRoomPage WSP=WRP.fn_CheckAvability();
			Thread.sleep(3000);
			WSP.verify_PublishedPkgPrice();
		    GenericMethods.Switch_Parent_Window(str1);
            System.out.println("TC_190 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}


@Test(priority=63)
public void fn_verifyLastMinRateOnSelectroomPackagesPage() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		BasePage BP=FP.fn_clkAdminLnk();
	    GenericMethods.windowHandle(str);
		Thread.sleep(6000);
		RoomPricesLandingPage RPL=BP.fn_navigatePriceManagerRP();
		Thread.sleep(4000);
        RPL.get_LastMinRate();
        RPL.clk_cancel();
	    Thread.sleep(7000);
	    GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
		String str1=GenericMethods.GetCurrentWindowID();
		Thread.sleep(3000);
		WebReservationHomePage WRP =FP.fn_WebReservationLink();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str1);
		Thread.sleep(4000);
		WebSelectRoomPage WSP=WRP.fn_CheckAvability();
		Thread.sleep(3000);
		WSP.verify_LastMinPrice();
	    GenericMethods.Switch_Parent_Window(str1);
        System.out.println("TC_191 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }

}


	@Test(priority=64)
    public void fn_verifyPriceAndDiscAmtOnMoreDetailPage() throws Exception
    {

		try
		{
			  FrontdeskLoginPage FL=new FrontdeskLoginPage();
	          FrontdeskContinueTrialPage CP = FL.FrontDesklogin_20787();
	          Thread.sleep(3000);
	          CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	          Thread.sleep(3000);
	          FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	          Thread.sleep(4000);
	          FP.fn_ClickCancelButton();
	          Thread.sleep(3000);
	          String str=GenericMethods.GetCurrentWindowID();
	          WebReservationHomePage WRP =FP.fn_WebReservationLink();
	          Thread.sleep(3000);
	          GenericMethods.windowHandle(str);
	          WebSelectRoomPage WSP=WRP.spclDisc_chkAvailability();
	          Thread.sleep(3000);
	          WSP.fn_getPkgPriceDisc();
	          Thread.sleep(3000);
	          WebMoreDetailsPage MDP=WSP.fn_clkMoreDetails();
	          Thread.sleep(3000);
	          MDP.fn_verifyPriceDisc();
	          Thread.sleep(3000);
              System.out.println("TC_192_193 Executed");
		}
		 catch(Exception e)
	 	   {
		  	   throw e;

	 	   }
    }




    @Test(priority=65)
    public void fn_verifyAdditionOfAddOnInWebReserv() throws Exception
    {

    	try
    	{
    		  FrontdeskLoginPage FL=new FrontdeskLoginPage();
	          FrontdeskContinueTrialPage CP = FL.FrontDesklogin_20787();
	          Thread.sleep(3000);
	          CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	          Thread.sleep(3000);
	          FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
	          Thread.sleep(4000);
	          FP.fn_ClickCancelButton();
	          Thread.sleep(3000);
	          String str=GenericMethods.GetCurrentWindowID();
	          WebReservationHomePage WRP =FP.fn_WebReservationLink();
	          Thread.sleep(3000);
	          GenericMethods.windowHandle(str);
	          WebSelectRoomPage WSP= WRP.spclDisc_chkAvailability();
	          Thread.sleep(3000);
	          WebAddMoreRoomPage WAM= WSP.fn_SelectRoomandRate();
	          Thread.sleep(3000);
	          AddOnsPage AP=WAM.fn_ClickAddOnsLink();
	          Thread.sleep(3000);
	          AP.fn_SelectAddons();
	          Thread.sleep(3000);
	          WAM.fn_ValidateAddedAddOns();
              System.out.println("TC_194  Executed");
    	}
    	 catch(Exception e)
  	   {
    	  	   throw e;

  	   }
    }



    @Test(priority=66)
    public void fn_verfiyAmtTaxPolicyInWebBookingConfirmationMail() throws Exception
    {

    	try
    	{
    		FrontdeskLoginPage AL=new FrontdeskLoginPage();
    		Thread.sleep(2000);

    		AL.Frontdesklogin_20803();
    		Thread.sleep(2000);
    		CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
    		Thread.sleep(2000);
    		FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
    		Thread.sleep(2000);
    		FLP.fn_ClickCancelButton();
    		Thread.sleep(2000);
    		sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
    		Thread.sleep(2000);
    		ExcelUtil.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Smoke1");
    		Thread.sleep(2000);
    		iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
    		Thread.sleep(2000);
    		String a=GenericMethods.GetCurrentWindowID();
    		Thread.sleep(2000);
    		WebReservationHomePage  WRH=FLP.ClickOnWebReservation();
    		Thread.sleep(2000);
    		GenericMethods.windowHandle(a);
    		Thread.sleep(2000);
    		WebSelectRoomPage WSR= WRH.fn_CheckAvability();
    		Thread.sleep(2000);
    		WebAddMoreRoomPage WAM=WSR.SelectRoom();
    		Thread.sleep(2000);
    		WebConfirmReservationPage WCR=WAM.ClickOnConfirmBtn();
    		Thread.sleep(2000);
    		
    		WebConfirmReservationPrintPage WCRP=WCR.ConfirmBooking(iTestCaseRow);
    		Thread.sleep(2000);
    		String rid=WCRP.GetReservationId();
    		ArrayList<String> al2=WCRP.GetResrvDetails();
    		Thread.sleep(2000);
    		GenericMethods.driver.close();
    		GenericMethods.Switch_Parent_Window(a);
    		Thread.sleep(2000);
    		ReservationSearchResultLandingPage RSRP=FLP.fn_SearchByReservationID(rid.trim());
            RSRP.VerifyReservationById(rid.trim());
    		EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox("FF", "http://mail.stayezee.com/squirrelmail/src/login.php");
    		Thread.sleep(2000);

    		EmailHomePage EHP=EAL.DoSquirrelMailLogin();
    		Thread.sleep(2000);

    		EHP.GetAccountDetailsForGuest("Zara", "Web Booking confirmation for Reservation ID");
    		Thread.sleep(2000);
    		ArrayList <String>	a11=EHP.GetBookingAmtDetail();
    		Thread.sleep(2000);
    		Assert.assertEquals(al2, a11);
    		Thread.sleep(2000);
            System.out.println("TC_195_196 Executed");
    	}
    	 catch(Exception e)
  	   {
    	  	   throw e;

  	   }
    }


   @Test(priority=67)
   public void fn_verifyCreationOfWebReservByGuestConsole() throws Exception
   {

	   try
	   {
		   FrontdeskLoginPage AL=new FrontdeskLoginPage();
		   Thread.sleep(2000);
		   AL.Frontdesklogin_20803();
		   Thread.sleep(2000);
		   CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
		   Thread.sleep(2000);
		   FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
		   Thread.sleep(2000);
		   FLP.fn_ClickCancelButton();
		   Thread.sleep(2000);
		   sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
		   Thread.sleep(2000);
		   ExcelUtil.setExcelFile(Constant.Path_TestData + Constant.File_TestData,"Smoke1");
		   Thread.sleep(2000);
		   iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
		   Thread.sleep(2000);
		   String a=GenericMethods.GetCurrentWindowID();
		   Thread.sleep(2000);
		   WebReservationHomePage  WRH=FLP.ClickOnWebReservation();
		   Thread.sleep(2000);
		   GenericMethods.windowHandle(a);
		   Thread.sleep(2000);
		   WebSelectRoomPage WSR= WRH.fn_CheckAvability();
		   Thread.sleep(2000);
		   WebAddMoreRoomPage WAM=WSR.SelectRoom();
		   Thread.sleep(2000);
		   WebConfirmReservationPage WCR=WAM.ClickOnConfirmBtn();
		   Thread.sleep(2000);
		  
		   WebConfirmReservationPrintPage WCRP=WCR.ConfirmBooking(iTestCaseRow);
		   Thread.sleep(2000);
		   WCRP.CloseWindow();
		   Thread.sleep(2000);
		   GenericMethods.Switch_Parent_Window(a);
		   Thread.sleep(2000);
		   GenericMethods.driver.close();
		   Thread.sleep(2000);
		   EmailAccountLoginPage EAL=GenericMethods.fn_OpenEmailBox("FF", "http://mail.stayezee.com/squirrelmail/src/login.php");
		   Thread.sleep(2000);
		   EmailHomePage EHP=EAL.DoSquirrelMailLogin();
		   Thread.sleep(2000);
		   EHP.GetAccountDetailsForGuest("Zara", "Account Details");
		   Thread.sleep(2000);
		   gd=EHP.GetGuestLoginDetails();
		   Thread.sleep(2000);
		   GenericMethods.driver.close();
		   Thread.sleep(2000);
		   WebGuestConsoleLoginPage WGCL=GenericMethods.fn_OpenWebGuestConsolePage("FF", gd.get(0).toString());
		   Thread.sleep(2000);
   		   Assert.assertEquals("Web Reservation Login", GenericMethods.getText(GenericMethods.driver.findElement(By.xpath("//td[text()='Web Reservation Login']"))));
		   Thread.sleep(2000);
		   WebGuestConsoleLandingPage WGCLP=WGCL.DoLogin(gd.get(1).toString(),gd.get(2).toString(), gd.get(3).toString());
   	       Thread.sleep(2000);
   		   Assert.assertEquals("Reservation Details", GenericMethods.getText(WebGuestConsoleLandingPage.GuestReservationPageTitle).trim());
		   Thread.sleep(2000);
		   WebGuestStayDetailsPage WGS=WGCLP.ClickOnBookNow();
		   Thread.sleep(2000);
		   WGS.ValidateTitle();
		   WebGuestSelectRoomPage WGSR=WGS.fn_CheckAvability();
		   Thread.sleep(2000);
		   WebGuestAddMoreRoomPage WGAMR=WGSR.SelectRoom();
		   Thread.sleep(2000);
		   WebGuestConfirmReservationPage WGCRP=WGAMR.ClickOnConfirmBtn();
		   Thread.sleep(2000);
		   WGCRP.VerifyTitle();
		   WebGuestConfirmReservationPrintPage WCRPP=WGCRP.ConfirmBooking();
		   Thread.sleep(2000);
		   String rid=WCRPP.GetReservationId();
		   Thread.sleep(2000);
		   GenericMethods.driver.close();
		   Thread.sleep(2000);
		   FrontdeskLoginPage AL1 = GenericMethods.fn_OpenFrontdesk("FF", "http://hotelogix.staygrid.com/frontdesk/login/login/");
		   Thread.sleep(2000);
		   AL1.Frontdesklogin_20803();
		   Thread.sleep(2000);
		   CashCounterPage CCP1 = FCT.fn_ClickCountinueWithTrail_BT();
		   Thread.sleep(2000);
		   FrontdeskLandingPage FLP1 = CCP1.NoOpenNewcounter();
		   Thread.sleep(2000);
		   FLP1.fn_ClickOnCancelButton();
		   Thread.sleep(4000);
		   ReservationSearchResultLandingPage  RSR=FLP.fn_SearchByReservationID(rid.trim());
		   Thread.sleep(3000);
		   RSR.VerifyReservationById(rid.trim());

           System.out.println("TC_197_198_199_200_201 Executed");
	   }
	   catch(Exception e)
 	   {
	  	   throw e;

 	   }
   }




	@Test(priority=68)
	public void fn_verifyAutoNAPostingsInAccounts() throws Exception
	{
		try
		{

		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20805();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(5000);
		GenericMethods.driver.navigate().refresh();
		Thread.sleep(5000);
		FP.fn_AutoNightAudit1();
		Thread.sleep(3000);
		//FP.fn_ClickCancelButtonAlert();
		//Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		AccountsLandingPage ALP=FP.fn_ClickAccounts_Link();
		Thread.sleep(5000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		ALP.fn_ValidateAccountsPage();
		Thread.sleep(3000);
		ALP.fn_ClickHotel();
		Thread.sleep(3000);
		GenericMethods.Switch_Parent_Window(str);
	    System.out.println("TC_202_203_204_205 Executed");
		}
		 catch(Exception e)
	 	   {
		  	   throw e;

	 	   }
	}



@Test(priority=69)
public void fn_verifyHouseCountReportForSpecificDateRange() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_VerifyReportPage();
		Thread.sleep(3000);
		RLP.fn_ClickOccupancyReport();
		Thread.sleep(3000);
		ORHouseCountReport HCR=RLP.fn_ClickHouseCountReport();
		Thread.sleep(3000);
		HCR.HouseCountReportSection();
		Thread.sleep(3000);
		HCR.fn_GetMonthlyReport();
		Thread.sleep(3000);
		HCR.fn_VerifySearchedDate();
	    GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);

        System.out.println("TC_206_207_208 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=70)
public void fn_verifyMonthlySummaryReportForSpecificMonth() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
	    Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_ClickOFinancialReport();
		Thread.sleep(3000);
		FRMonthlySummeryReport MSR=RLP.fn_ClickMonthlySummaryReport_BT();
		Thread.sleep(3000);
		MSR.Fn_MonthlySummaryReportPage();
		MSR.fn_VerifyMonthlyReport("Jun", "2015");
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_209_210 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}


@Test(priority=71)
public void fn_verifyCashierReport() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_ClickRevenueReport();
		Thread.sleep(3000);
		CashierReportPage MSR=RLP.fn_ClickCashierReport();
		Thread.sleep(3000);
		MSR.fn_InputDate("Default Counter", "-All POS Points/Frontdesk-");
		Thread.sleep(3000);
		MSR.fn_PrintWindowhandle();
		Thread.sleep(3000);
		MSR.DownloadNightAuditReportFile();
		Thread.sleep(3000);
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_211_212 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



@Test(priority=72)
public void fn_verifyNoShowReportForSpecificDateRange() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
		FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_ReservationReport();
		Thread.sleep(3000);
		NoShowReportPage NSR=RLP.fn_NoShowReport_Link();
		Thread.sleep(3000);
		NSR.fn_InputDate();
		Thread.sleep(3000);
		NSR.fn_PrintWindowhandle();
		Thread.sleep(3000);
		NSR.DownloadNightAuditReportFile();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
	    
        System.out.println("TC_213_214 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}


@Test(priority=73)
public void fn_verifyExportOfMonthlySummaryReport() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		Thread.sleep(3000);
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_ClickOFinancialReport();
		Thread.sleep(2500);
		FRMonthlySummeryReport MSR=RLP.fn_ClickMonthlySummaryReport_BT();
		Thread.sleep(2500);
		MSR.fn_ClickPrintBT();
		Thread.sleep(5000);
		MSR.fn_PrintWindowhandle();
		Thread.sleep(3000);
		MSR.DownloadNightAuditReportFile();
		Thread.sleep(5000);
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_215_216 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}


@Test(priority=74)
public void fn_verifyExportOfDiscountReport() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
	    CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
	    Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_DiscountReport();
		Thread.sleep(3000);
		DiscountAllowanceReportPage DARP=RLP.fn_DiscountAllowance_Link();
		Thread.sleep(3000);
		DARP.fn_InputDate("Default Counter", "-All POS Points/Frontdesk-");
		Thread.sleep(3000);
		DARP.fn_ClickPrintBT();
		Thread.sleep(5000);
		DARP.fn_PrintWindowhandle();
		Thread.sleep(3000);
		DARP.DownloadNightAuditReportFile();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_217_218 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}




@Test(priority=75)
public void fn_verifyExportOfDailySalesReport() throws Exception
{

	try
	{
		FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    AL.FrontDesklogin_20787();
		Thread.sleep(3000);
		FrontdeskContinueTrialPage CP=new FrontdeskContinueTrialPage();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		Thread.sleep(3000);
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		Thread.sleep(3000);
		FP.fn_ClickCancelButton();
		Thread.sleep(3000);
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		Thread.sleep(3000);
		GenericMethods.windowHandle(str);
		RLP.fn_POSReport();
		Thread.sleep(3000);
	    DailySalesReportPage DSRP=RLP.fn_DailySalesReport_Link();
		Thread.sleep(3000);
		DSRP.fn_InputDate("Default Counter", "All POS Points");
		Thread.sleep(3000);
		DSRP.fn_ClickPrintBT();
		Thread.sleep(3000);
		DSRP.fn_PrintWindowhandle();
		Thread.sleep(3000);
		DSRP.DownloadNightAuditReportFile();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
        System.out.println("TC_219_220 Executed");
	}
	 catch(Exception e)
	   {
	  	   throw e;

	   }
}



   @Test(priority=76)
	public void fn_verifyCalcOfHouseCountReport() throws Exception
   {

	   try
	   {
	    FrontdeskLoginPage AL=new FrontdeskLoginPage();
	    FrontdeskContinueTrialPage CP=AL.FrontDesklogin_20787();
		CashCounterPage CCP=CP.fn_ClickCountinueWithTrail_BT();
		FrontdeskLandingPage FP=CCP.fn_ClickContinueButton();
		FP.fn_ClickCancelButton();
		String str=GenericMethods.GetCurrentWindowID();
		ReportLandingPage RLP=FP.fn_ReportButton();
		GenericMethods.windowHandle(str);
		Thread.sleep(3000);
		RLP.fn_ClickOccupancyReport();
		ORHouseCountReport HCR=RLP.fn_ClickHouseCountReport();
		HCR.HouseCountReportSection();
		HCR.fn_GetMonthlyReport();
		GenericMethods.driver.close();
	    GenericMethods.Switch_Parent_Window(str);
	    System.out.println("TC_221 Executed");
	   }
	   catch(Exception e)
 	   {
	  	   throw e;

 	   }
	}
*/


   //@Test(priority=77)
   public void fn_verifyAddNewRoomInGrpReserv() throws Exception
   {

   	try
   	{
   FrontdeskLoginPage AL=new FrontdeskLoginPage();
   AL.Frontdesklogin_20803();
   CashCounterPage CCP = FCT.fn_ClickCountinueWithTrail_BT();
   FrontdeskLandingPage FLP = CCP.NoOpenNewcounter();
   FLP.fn_ClickCancelButton();
   Thread.sleep(2000);
   ReservationSearchResultLandingPage  RSR=FLP.fn_SearchReservationID("042615");
   Thread.sleep(2000);
    ViewDetailsPage VDP=RSR.fn_ClickOnSearchedRecord();
   EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
   //ViewDetailsPage VDP=FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4250492' and @title='83. Tony Marle(G)(A)")));
   //EnableEditingPage EEP=VDP.ClickToEnableEditingBtn();
   int exp=EEP.CountRoomInGroup();
   EEP. AddRoomToGroup("King Suite","1","1");
   Thread.sleep(2000);
   GenericMethods.driver.navigate().refresh();
   FLP.fn_ClickCancelButton();
   Thread.sleep(2000);
   ReservationSearchResultLandingPage  RSR1=FLP.fn_SearchReservationID("042615");
   Thread.sleep(2000);
   ViewDetailsPage VDP1=RSR1.fn_ClickOnSearchedRecord();
   Thread.sleep(2000);
   EnableEditingPage EEP1=VDP1.ClickToEnableEditingBtn();
   //ViewDetailsPage VDP1=FLP.fn_rightclkViewDetailsSingle(GenericMethods.driver.findElement(By.xpath("//div[@resrvid='4250492' and @title='83. Tony Marle(G)(A)")));
   //EnableEditingPage EEP1=VDP1.ClickToEnableEditingBtn();
   int act=EEP1.CountRoomInGroup();
   Thread.sleep(2000);
   Assert.assertEquals(exp+1, act);
   Thread.sleep(2000);
   EEP1.DeleteAddedRoomFromGroup("042683");
   Thread.sleep(2000);
   System.out.println("TC_222 Executed");
   	}
    catch(Exception e)
	   {
   	   throw e;

	   }

   }
   
   
   
   @Test
   public void fn_create1NRackRateReservWithAddOns() throws Throwable{
	   
	   try{
		   
		   System.out.println("This is fn_create1NRackRateReservWithAddOns method");
	   }catch(Throwable e){
		   
		  throw e; 
	   }
	   
   }




@AfterMethod
public void closeApp() throws Exception
{
try{
        GenericMethods.driver.close();
		GenericMethods.driver.quit();
}catch(Exception e){
	Thread.sleep(2000);
	System.out.println("Heyy I am in closeApp method catch");
	 GenericMethods.driver.close();
		GenericMethods.driver.quit();


}
}
}
