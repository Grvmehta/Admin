package com.hotelogix.smoke.AdminTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.PriceManager.FrontDeskPackageDetailPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.AddQuickReservationForm;
import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.frontdesk.Payment.AccountStatementLandingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.EnableEditingPage;
import com.hotelogix.smoke.frontdesk.ViewDetailsPage.ViewDetailsPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class RatesTestFD {
	
	
	private String rtype = "Delux";
	private String sTestCaseName;
	private int iTestCaseRow;
	public static ArrayList<String> a1 = new ArrayList<String>();
	public static ArrayList<String> gd = new ArrayList<String>();
	public static HashMap<String,Integer> hm=null;
	FrontdeskContinueTrialPage FCT = new FrontdeskContinueTrialPage();
	private FrontdeskLoginPage AL;
	private FrontdeskLandingPage FP;
	
	String seasonalrateRSV="";
	String lastMinuteRSV="";
	String earlyBirdRSV="";
	String dynamicRSV="";
	String longStayPercentageRSV="";
	String longStayPerNightRSV="";
	
	String seasonalrateRSV2A1C="";
	String longStayPercentageRSV2A1C="";
	String longStayPerNightRSV2A2C="";
	
	
	
	@BeforeTest
	 public void LaunchApp() throws Throwable {
			

			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			//hm=ExcelUtil.creatingCollectionofTestcaseNames();
			//iTestCaseRow=hm.get(sTestCaseName);
			String br = ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_Browser));
			try {
				ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL));
				GenericMethods.fn_OpenFrontdesk(br,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
				AL = new FrontdeskLoginPage();
				AL.FrontDeskLogin(iTestCaseRow);
				FrontdeskContinueTrialPage CP = new FrontdeskContinueTrialPage();
				Thread.sleep(2000);
				CashCounterPage CCP = CP.fn_ClickCountinueWithTrail_BT();
				Thread.sleep(2000);
				FP = CCP.fn_ClickContinueButton();

			} catch (Throwable e) {
				Thread.sleep(4000);
				System.out.println("System is showing problem during login");
				GenericMethods.fn_OpenFrontdesk(br,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
				AL = new FrontdeskLoginPage();
				AL.FrontDeskLogin(iTestCaseRow);
				FrontdeskContinueTrialPage CP = new FrontdeskContinueTrialPage();
				Thread.sleep(2000);
				CashCounterPage CCP = CP.fn_ClickCountinueWithTrail_BT();
				Thread.sleep(2000);
				FP = CCP.fn_ClickContinueButton();
			}
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
			
	//	@Test(priority = 1, description = "2 night single reservation with seasonal rate.")
		public void fn_create2NSingleReserv() throws Throwable {// TC_31_32_33
			try {

				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				//Assert.assertEquals(true, false);
				FP.fn_ClickCancelButton();
				Thread.sleep(6000);
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
				Thread.sleep(6000);
				FP = AQRP.FillQuickResForm(iTestCaseRow);
				FP.fn_verifyReservation();
				 seasonalrateRSV=FP.resvId;
				 WebElement ele = FP.getWebElement(seasonalrateRSV);
					Thread.sleep(2000);
					GenericMethods.clickElement(ele);
					ViewDetailsPage VDP = FP.ClickOnViewlink();
					EnableEditingPage EEP = VDP.ClickOnEnableEditing();
					EEP.getRoomRateAndTaxamount();
					Assert.assertEquals(EnableEditingPage.roomRate,
							ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
					
					Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
					
					
				
				Reporter.log("2 night single reservation created.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
		
	
		
		
		//@Test(priority = 2, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
		public void fn_LastMinutePkg2NResevation() throws Throwable {// TC_41
			try {
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
				String cwid = GenericMethods.GetCurrentWindowID();
				BasePage BP = FP.fn_NavigateAdmineConsole();
				GenericMethods.windowHandle(cwid);
				//GenericMethods.windowHandle_admin();
				
				ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
				boolean res = FPL.VerifyPackage(iTestCaseRow);
				FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
				String ti = GenericMethods.driver.getTitle();
				GenericMethods.Switch_Parent_Window(cwid);
				Thread.sleep(2000);
				GenericMethods.driver.navigate().refresh();
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				FP.fn_clickCurrentLnk();
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
				String selPak = AQRP.GetSelectedPackage(
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
				String pkgPrice = AQRP.GetPrice();
				AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
				Thread.sleep(2000);
				FP.fn_verifyReservation();
				lastMinuteRSV=FP.resvId;
				
				WebElement ele = FP.getWebElement(lastMinuteRSV);
				Thread.sleep(2000);
				GenericMethods.clickElement(ele);
				ViewDetailsPage VDP = FP.ClickOnViewlink();
				EnableEditingPage EEP = VDP.ClickOnEnableEditing();
				EEP.getRoomRateAndTaxamount();
				Assert.assertEquals(EnableEditingPage.roomRate,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
				
				Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
				
				
				GenericMethods.switchToWindowHandle(ti);
				FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
				String rate = FDP.getPerNightPrice(rtype);
				Assert.assertEquals(rate.trim(), pkgPrice.trim());
				GenericMethods.CloseWindow("Package");
				System.out.println("TC-41 Executed");
				System.out.println("Last minute reserv id is::"+lastMinuteRSV);
				Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
		

		//@Test(priority = 3, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
		public void fn_EarlyBirdPkg2NResevation() throws Throwable {// TC_41
			try {
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
				String cwid = GenericMethods.GetCurrentWindowID();
				BasePage BP = FP.fn_NavigateAdmineConsole();
				GenericMethods.windowHandle(cwid);
				//GenericMethods.windowHandle_admin();
				
				ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
				boolean res = FPL.VerifyPackage(iTestCaseRow);
				FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
				String ti = GenericMethods.driver.getTitle();
				GenericMethods.Switch_Parent_Window(cwid);
				Thread.sleep(2000);
				GenericMethods.driver.navigate().refresh();
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				FP.fn_clickCurrentLnk();
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
				String selPak = AQRP.GetSelectedPackage(
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
				String pkgPrice = AQRP.GetPrice();
				AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
				Thread.sleep(2000);
				
				FP.fn_verifyReservation();
				earlyBirdRSV=FP.resvId;
				
				WebElement ele = FP.getWebElement(earlyBirdRSV);
				Thread.sleep(2000);
				GenericMethods.clickElement(ele);
				ViewDetailsPage VDP = FP.ClickOnViewlink();
				EnableEditingPage EEP = VDP.ClickOnEnableEditing();
				EEP.getRoomRateAndTaxamount();
				Assert.assertEquals(EnableEditingPage.roomRate,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
				
				Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
				
				
				
				GenericMethods.switchToWindowHandle(ti);
				FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
				String rate = FDP.getPerNightPrice(rtype);
				Assert.assertEquals(rate.trim(), pkgPrice.trim());
				GenericMethods.CloseWindow("Package");
				System.out.println("TC-41 Executed");
				System.out.println("EarlyBird reserv id is::"+earlyBirdRSV);
				Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
		//@Test(priority = 4, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
		public void fn_DynamicPkg1NResevation() throws Throwable {// TC_41
			try {
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
				String cwid = GenericMethods.GetCurrentWindowID();
				BasePage BP = FP.fn_NavigateAdmineConsole();
				GenericMethods.windowHandle(cwid);
				//GenericMethods.windowHandle_admin();
				
				ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
				boolean res = FPL.VerifyPackage(iTestCaseRow);
				FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
				String ti = GenericMethods.driver.getTitle();
				GenericMethods.Switch_Parent_Window(cwid);
				Thread.sleep(2000);
				GenericMethods.driver.navigate().refresh();
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				FP.fn_clickCurrentLnk();
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
				String selPak = AQRP.GetSelectedPackage(
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
				String pkgPrice = AQRP.GetPrice();
				AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
				Thread.sleep(2000);
				
				FP.fn_verifyReservation();
				dynamicRSV=FP.resvId;
				
				GenericMethods.switchToWindowHandle(ti);
				FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
				String rate = FDP.getPerNightPrice(rtype);
				Assert.assertEquals(rate.trim(), pkgPrice.trim());
				GenericMethods.CloseWindow("Package");
				System.out.println("TC-41 Executed");
				System.out.println("Dynamic reserv id is::"+dynamicRSV);
				Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
		@Test(priority = 5, description = "To create 1 room 2 night reservation for Package with Inclusion and long stay percentage discount")
		public void fn_LongStayPercentage2NResevation() throws Throwable {// TC_41
			try {
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
				String cwid = GenericMethods.GetCurrentWindowID();
				BasePage BP = FP.fn_NavigateAdmineConsole();
				GenericMethods.windowHandle(cwid);
				//GenericMethods.windowHandle_admin();
				
				ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
				boolean res = FPL.VerifyPackage(iTestCaseRow);
				FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
				String ti = GenericMethods.driver.getTitle();
				GenericMethods.Switch_Parent_Window(cwid);
				Thread.sleep(2000);
				/*GenericMethods.driver.navigate().refresh();
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				FP.fn_clickCurrentLnk();*/
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
				String selPak = AQRP.GetSelectedPackage(
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
				String pkgPrice = AQRP.GetPrice();
				AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
				Thread.sleep(2000);
				
				FP.fn_verifyReservation();
				longStayPercentageRSV=FP.resvId;
				
				WebElement ele = FP.getWebElement(longStayPercentageRSV);
				Thread.sleep(2000);
				GenericMethods.clickElement(ele);
				ViewDetailsPage VDP = FP.ClickOnViewlink();
				EnableEditingPage EEP = VDP.ClickOnEnableEditing();
				EEP.getRoomRateAndTaxamount();
				Assert.assertEquals(EnableEditingPage.roomRate,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
				
				Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
				
				
				GenericMethods.switchToWindowHandle(ti);
				FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
				String rate = FDP.getPerNightPrice(rtype);
				Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
				GenericMethods.CloseWindow("Package");
				System.out.println("TC-41 Executed");
				System.out.println("Long stay percentage reserv id is::"+longStayPercentageRSV);
				Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
		@Test(priority = 6, description = "To create 1 room 3 night reservation for Package with Inclusion and long stay per nights")
		public void fn_LongStayPerNight3NResevation() throws Throwable {// TC_41
			try {
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
				String cwid = GenericMethods.GetCurrentWindowID();
				BasePage BP = FP.fn_NavigateAdmineConsole();
				GenericMethods.windowHandle(cwid);
				//GenericMethods.windowHandle_admin();
				
				ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
				boolean res = FPL.VerifyPackage(iTestCaseRow);
				FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
				String ti = GenericMethods.driver.getTitle();
				GenericMethods.Switch_Parent_Window(cwid);
				Thread.sleep(2000);
				/*GenericMethods.driver.navigate().refresh();
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				FP.fn_clickCurrentLnk();*/
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "5");
				String selPak = AQRP.GetSelectedPackage(
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
				String pkgPrice = AQRP.GetPrice();
				AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
				Thread.sleep(2000);
				
				FP.fn_verifyReservation();
				longStayPerNightRSV=FP.resvId;
				
				WebElement ele = FP.getWebElement(longStayPerNightRSV);
				Thread.sleep(2000);
				GenericMethods.clickElement(ele);
				ViewDetailsPage VDP = FP.ClickOnViewlink();
				EnableEditingPage EEP = VDP.ClickOnEnableEditing();
				EEP.getRoomRateAndTaxamount();
				Assert.assertEquals(EnableEditingPage.roomRate,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
				
				Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
				
				
				
				
				GenericMethods.switchToWindowHandle(ti);
				FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
				String rate = FDP.getPerNightPrice(rtype);
				Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
				GenericMethods.CloseWindow("Package");
				System.out.println("TC-41 Executed");
				System.out.println("Long Stay Per Night reserv id is::"+longStayPerNightRSV);
				Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
		
		@Test(priority = 7, description = "2 night single reservation with seasonal rate.")
				public void fn_create2NSingleReservFor2A1CSeasonalRate() throws Throwable {// TC_31_32_33
					try {

						sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
						ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
								Constant.Sheet_Rates2);
						//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
						iTestCaseRow=	hm.get(sTestCaseName);
						//Assert.assertEquals(true, false);
						FP.fn_ClickCancelButton();
						Thread.sleep(6000);
						AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
						Thread.sleep(6000);
						FP = AQRP.FillQuickResForm(iTestCaseRow);
						FP.fn_verifyReservation();
						seasonalrateRSV2A1C=FP.resvId;
						 WebElement ele = FP.getWebElement(seasonalrateRSV2A1C);
							Thread.sleep(2000);
							GenericMethods.clickElement(ele);
							ViewDetailsPage VDP = FP.ClickOnViewlink();
							EnableEditingPage EEP = VDP.ClickOnEnableEditing();
							EEP.getRoomRateAndTaxamount();
							Assert.assertEquals(EnableEditingPage.roomRate,
									ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
							
							Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
							
							
						
						Reporter.log("2 night single reservation created.", true);
					} catch (Throwable e) {
						GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
						ExcelUtil.CloseAllExcelReferences();
						throw e;
					}
				}
		
				@Test(priority = 8, description = "To create 1 room 2 night reservation for Package with Inclusion and long stay percentage discount")
				public void fn_LongStayPercentage2NResevationWith2A1C() throws Throwable {// TC_41
					try {
						sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
						ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
								Constant.Sheet_Rates2);
						//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
						iTestCaseRow=	hm.get(sTestCaseName);
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
						String cwid = GenericMethods.GetCurrentWindowID();
						BasePage BP = FP.fn_NavigateAdmineConsole();
						GenericMethods.windowHandle(cwid);
						//GenericMethods.windowHandle_admin();
						
						ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
						boolean res = FPL.VerifyPackage(iTestCaseRow);
						FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
						String ti = GenericMethods.driver.getTitle();
						GenericMethods.Switch_Parent_Window(cwid);
						Thread.sleep(2000);
						/*GenericMethods.driver.navigate().refresh();
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						FP.fn_clickCurrentLnk();*/
						AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "4");
						String selPak = AQRP.GetSelectedPackage(
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
						String pkgPrice = AQRP.GetPrice();
						AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
						Thread.sleep(2000);
						
						FP.fn_verifyReservation();
						longStayPercentageRSV2A1C=FP.resvId;
						
						WebElement ele = FP.getWebElement(longStayPercentageRSV2A1C);
						Thread.sleep(2000);
						GenericMethods.clickElement(ele);
						ViewDetailsPage VDP = FP.ClickOnViewlink();
						EnableEditingPage EEP = VDP.ClickOnEnableEditing();
						EEP.getRoomRateAndTaxamount();
						Assert.assertEquals(EnableEditingPage.roomRate,
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
						
						Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
						
						
						GenericMethods.switchToWindowHandle(ti);
						FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
						String rate = FDP.getPerNightPrice(rtype);
						Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
						GenericMethods.CloseWindow("Package");
						System.out.println("TC-41 Executed");
						System.out.println("Long stay percentage reserv id is::"+longStayPercentageRSV);
						Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
					} catch (Throwable e) {
						GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
						ExcelUtil.CloseAllExcelReferences();
						throw e;
					}
				}
				
				@Test(priority = 9, description = "To create 1 room 3 night reservation for Package with Inclusion and long stay per nights")
				public void fn_LongStayPerNight3NResevationWith2A2C() throws Throwable {// TC_41
					try {
						sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
						ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
								Constant.Sheet_Rates2);
						//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
						iTestCaseRow=	hm.get(sTestCaseName);
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
						String cwid = GenericMethods.GetCurrentWindowID();
						BasePage BP = FP.fn_NavigateAdmineConsole();
						GenericMethods.windowHandle(cwid);
						//GenericMethods.windowHandle_admin();
						
						ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
						boolean res = FPL.VerifyPackage(iTestCaseRow);
						FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
						String ti = GenericMethods.driver.getTitle();
						GenericMethods.Switch_Parent_Window(cwid);
						Thread.sleep(2000);
						/*GenericMethods.driver.navigate().refresh();
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						FP.fn_clickCurrentLnk();*/
						AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "5");
						String selPak = AQRP.GetSelectedPackage(
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
						String pkgPrice = AQRP.GetPrice();
						AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
						Thread.sleep(2000);
						
						FP.fn_verifyReservation();
						longStayPerNightRSV2A2C=FP.resvId;
						
						WebElement ele = FP.getWebElement(longStayPerNightRSV2A2C);
						Thread.sleep(2000);
						GenericMethods.clickElement(ele);
						ViewDetailsPage VDP = FP.ClickOnViewlink();
						EnableEditingPage EEP = VDP.ClickOnEnableEditing();
						EEP.getRoomRateAndTaxamount();
						Assert.assertEquals(EnableEditingPage.roomRate,
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
						
						Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
						
						
						
						
						GenericMethods.switchToWindowHandle(ti);
						FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
						String rate = FDP.getPerNightPrice(rtype);
						Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
						GenericMethods.CloseWindow("Package");
						System.out.println("TC-41 Executed");
						System.out.println("Long Stay Per Night reserv id is::"+longStayPerNightRSV);
						Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
					} catch (Throwable e) {
						GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
						ExcelUtil.CloseAllExcelReferences();
						throw e;
					}
				}
				
		
		@Test(priority = 10, description = "Performing AutoNA",invocationCount=3)
		public void performingNA() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			Thread.sleep(2000);
			GenericMethods.clickElement(FP.Btn_AutoNightAudit);
			Thread.sleep(1500);
			//FP.checkingNACompletionStatus1();
			WebElement we=FP.loader_NA1;
			 WebDriverWait wait=new WebDriverWait(GenericMethods.driver, 100);
			   wait.pollingEvery(1000, TimeUnit.MILLISECONDS);
			   wait.until(new ExpectedCondition<Boolean>() {
				    public Boolean apply(WebDriver driver) {
				    	//driver=GenericMethods.GI(). getDriver();
				    	boolean result=false;
				    		System.out.println(we.getText());
				        if(we.getText().contains("Updating Room Display..."))
				        {
				        	System.out.println("NA completed successfully");
				        	result=true;
				        	//break;
				        	//return true;
				        }
						return result;
						
				 
				    	//return result;
				    }
				});
			/*WebElement ele = FP.getWebElement(lastMinuteRSV);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();*/
		//	Thread.sleep(10000);
		}
		
		//@Test(priority =11, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForLastMinute() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			
			Thread.sleep(2000);
			FP.settingFSDateView();
			Thread.sleep(2000);
			
			WebElement ele = FP.getWebElement(lastMinuteRSV);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
	//	ASLP.VerifyRoomRateAndTax("Last");
		ASLP.VerifyRoomRateAndTaxForAllPostings("Last");
		/*Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		*/
			
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		//Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		//Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
		
		
		
		
		
		
		}
		
		
		@Test(priority = 12, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForLongStayPer() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			
			Thread.sleep(2000);
			FP.settingFSDateView();
			Thread.sleep(2000);
			
			WebElement ele = FP.getWebElement(longStayPercentageRSV);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
		//ASLP.VerifyRoomRateAndTax("Long");
		ASLP.VerifyRoomRateAndTaxForAllPostings("Long");
		
		/*
		Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		*/
		
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		//Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		//Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
		
		
		
		
		}
		
		@Test(priority = 13, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForLongStayPerNight() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			
			Thread.sleep(2000);
			FP.settingFSDateView();
			Thread.sleep(2000);
			
			WebElement ele = FP.getWebElement(longStayPerNightRSV);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
		ASLP.VerifyRoomRateAndTax("LongStay");
		ASLP.VerifyRoomRateAndTaxForAllPostings("LongStay");
		/*Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		*/
		
		
Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
		
		
		
			
		}
		
	//	@Test(priority = 14, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForEarlyBird() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			
			Thread.sleep(2000);
			FP.settingFSDateView();
			Thread.sleep(2000);
			
			WebElement ele = FP.getWebElement(earlyBirdRSV);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
	//	ASLP.VerifyRoomRateAndTax("LongStay");
		ASLP.VerifyRoomRateAndTaxForAllPostings("Early");
		/*Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		*/
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		//Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		//Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
		
		
		
			
		}
		
	//	@Test(priority = 15, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForSeasonalRate() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			
			Thread.sleep(2000);
			FP.settingFSDateView();
			Thread.sleep(2000);
			
			WebElement ele = FP.getWebElement(seasonalrateRSV);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
		//ASLP.VerifyRoomRateAndTax("Seasonal");
		ASLP.VerifyRoomRateAndTaxForAllPostings("Seasonal");
		/*Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		*/
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		//Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		//Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
		
		
			
		}
		
		
		@Test(priority = 16, description = "Validating Prices on Payment Page")
			public void validatingPricesOnPaymentPageFor2A1CSeasonalRate() throws Exception
			{
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				
				Thread.sleep(2000);
				FP.settingFSDateView();
				Thread.sleep(2000);
				
				WebElement ele = FP.getWebElement(seasonalrateRSV2A1C);
				Thread.sleep(2000);
				FP.fn_rightClickOnReservation(ele);
			AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
			//ASLP.VerifyRoomRateAndTax("Seasonal");
			ASLP.VerifyRoomRateAndTaxForAllPostings("Seasonal");
			/*Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			
			Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			*/
			
			Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
			
			Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			
			Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
			
			//Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
			
			Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
			
			//Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
			
				
			}
		
		@Test(priority = 17, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForLongStayPercentage2NResevationWith2A1C() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			Thread.sleep(2000);
			FP.settingFSDateView();
			Thread.sleep(2000);
			WebElement ele = FP.getWebElement(longStayPercentageRSV2A1C);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
		//ASLP.VerifyRoomRateAndTax("Long");
		ASLP.VerifyRoomRateAndTaxForAllPostings("Long");
		/*Assert.assertEquals(ASLP.postedRoomPrice,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		*/
		Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		//Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		//Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
			
		}
		
		@Test(priority = 18, description = "Validating Prices on Payment Page")
		public void validatingPricesOnPaymentPageForLongStayPerNight3NResevationWith2A2C() throws Exception
		{
			sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
					Constant.Sheet_Rates2);
			//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			Thread.sleep(2000);
			FP.fn_ClickCancelButton();
			Thread.sleep(2000);
			FP.settingFSDateView();
			WebElement ele = FP.getWebElement(longStayPerNightRSV2A2C);
			Thread.sleep(2000);
			FP.fn_rightClickOnReservation(ele);
		AccountStatementLandingPage ASLP=	FP.ClickOnPayment();
	//	ASLP.VerifyRoomRateAndTax("LongStay");
		ASLP.VerifyRoomRateAndTaxForAllPostings("LongStay");
		Assert.assertEquals(ASLP.postedRoomPriceList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(1),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
		
		Assert.assertEquals(ASLP.postedRoomPriceList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(2),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
		
		Assert.assertEquals(ASLP.postedRoomTaxList.get(3),ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult6)));
		}
		
		
	//	@Test(priority = 19, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
		public void fn_LastMinutePkg1NResevationOnSystemDate() throws Throwable {// TC_41
			try {
				sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
						Constant.Sheet_Rates2);
				//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				Thread.sleep(4000);
				FP.fn_ClickCancelButton();
				//GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
				String cwid = GenericMethods.GetCurrentWindowID();
				BasePage BP = FP.fn_NavigateAdmineConsole();
				GenericMethods.windowHandle(cwid);
				//GenericMethods.windowHandle_admin();
				
				ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
				boolean res = FPL.VerifyPackage(iTestCaseRow);
				FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
				String ti = GenericMethods.driver.getTitle();
				GenericMethods.Switch_Parent_Window(cwid);
				Thread.sleep(2000);
				/*GenericMethods.driver.navigate().refresh();
				Thread.sleep(2000);
				FP.fn_ClickCancelButton();
				FP.fn_clickCurrentLnk();*/
				
				FP.fn_clktodaysDateBtn();
				
				AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
				String selPak = AQRP.GetSelectedPackage(
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
				String pkgPrice = AQRP.GetPrice();
				AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
				Thread.sleep(2000);
				FP.fn_verifyReservation();
				lastMinuteRSV=FP.resvId;
				
				WebElement ele = FP.getWebElement(lastMinuteRSV);
				Thread.sleep(2000);
				GenericMethods.clickElement(ele);
				ViewDetailsPage VDP = FP.ClickOnViewlink();
				EnableEditingPage EEP = VDP.ClickOnEnableEditing();
				EEP.getRoomRateAndTaxamount();
				Assert.assertEquals(EnableEditingPage.roomRate,
						ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
				
				Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
				
				
				GenericMethods.switchToWindowHandle(ti);
				FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
				String rate = FDP.getPerNightPrice(rtype);
				Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
				GenericMethods.CloseWindow("Package");
				System.out.println("TC-41 Executed");
				System.out.println("Last minute reserv id is::"+lastMinuteRSV);
				Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
			} catch (Throwable e) {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
			}
		}
		
			//	@Test(priority = 20, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
				public void fn_EarlyBirdPkg1NResevationOnSystemDate() throws Throwable {// TC_41
					try {
						sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
						ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
								Constant.Sheet_Rates2);
						//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
						iTestCaseRow=	hm.get(sTestCaseName);
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
						String cwid = GenericMethods.GetCurrentWindowID();
						BasePage BP = FP.fn_NavigateAdmineConsole();
						GenericMethods.windowHandle(cwid);
						//GenericMethods.windowHandle_admin();
						
						ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
						boolean res = FPL.VerifyPackage(iTestCaseRow);
						FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
						String ti = GenericMethods.driver.getTitle();
						GenericMethods.Switch_Parent_Window(cwid);
						Thread.sleep(2000);
						/*GenericMethods.driver.navigate().refresh();
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						FP.fn_clickCurrentLnk();*/
						
						FP.fn_clktodaysDateBtn();
						
						AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
						String selPak = AQRP.GetSelectedPackage(
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
						String pkgPrice = AQRP.GetPrice();
						AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
						Thread.sleep(2000);
						
						FP.fn_verifyReservation();
						earlyBirdRSV=FP.resvId;
						
						WebElement ele = FP.getWebElement(earlyBirdRSV);
						Thread.sleep(2000);
						GenericMethods.clickElement(ele);
						ViewDetailsPage VDP = FP.ClickOnViewlink();
						EnableEditingPage EEP = VDP.ClickOnEnableEditing();
						EEP.getRoomRateAndTaxamount();
						Assert.assertEquals(EnableEditingPage.roomRate,
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
						
						Assert.assertEquals(EnableEditingPage.roomTax,ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
						
						
						
						GenericMethods.switchToWindowHandle(ti);
						FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
						String rate = FDP.getPerNightPrice(rtype);
						Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
						GenericMethods.CloseWindow("Package");
						System.out.println("TC-41 Executed");
						System.out.println("EarlyBird reserv id is::"+earlyBirdRSV);
						Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
					} catch (Throwable e) {
						GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
						ExcelUtil.CloseAllExcelReferences();
						throw e;
					}
				}
				
				
			//	@Test(priority = 21, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
				public void fn_DynamicPkg1NResevationOnSystemDate() throws Throwable {// TC_41
					try {
						sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
						ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
								Constant.Sheet_Rates2);
						//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
						iTestCaseRow=	hm.get(sTestCaseName);
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
						String cwid = GenericMethods.GetCurrentWindowID();
						BasePage BP = FP.fn_NavigateAdmineConsole();
						GenericMethods.windowHandle(cwid);
						//GenericMethods.windowHandle_admin();
						
						ListOfPackagesFrontdesk FPL = BP.fn_navigateFrontDskPkg();
						boolean res = FPL.VerifyPackage(iTestCaseRow);
						FPL.CreatePackageAndAttachToFD(iTestCaseRow, res);
						String ti = GenericMethods.driver.getTitle();
						GenericMethods.Switch_Parent_Window(cwid);
						Thread.sleep(2000);
						/*GenericMethods.driver.navigate().refresh();
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						FP.fn_clickCurrentLnk();*/
						
						FP.fn_clktodaysDateBtn();
						
						AddQuickReservationForm AQRP = FP.fn_createFDReserv(rtype, "3", "3");
						String selPak = AQRP.GetSelectedPackage(
								ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_PakageName)));
						String pkgPrice = AQRP.GetPrice();
						AQRP.FillQuickResvsFormBySelectingPak(iTestCaseRow, selPak);
						Thread.sleep(2000);
						
						FP.fn_verifyReservation();
						dynamicRSV=FP.resvId;
						
						GenericMethods.switchToWindowHandle(ti);
						FrontDeskPackageDetailPage FDP = FPL.clickOnPakEditlink(selPak);
						String rate = FDP.getPerNightPrice(rtype);
						Assert.assertNotEquals(rate.trim(), pkgPrice.trim());
						GenericMethods.CloseWindow("Package");
						System.out.println("TC-41 Executed");
						System.out.println("Dynamic reserv id is::"+dynamicRSV);
						Reporter.log("To create 1 room 2 night reservation for Package with Inclusion as rate type.", true);
					} catch (Throwable e) {
						GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
						ExcelUtil.CloseAllExcelReferences();
						throw e;
					}
				}
		
				

			//	@Test(priority = 21, description = "To create 1 room 2 night reservation for Package with Inclusion as rate type.")
				public void fn_gettingDateSet() throws Throwable {// TC_41
					try {
						sTestCaseName = Thread.currentThread().getStackTrace()[1].getMethodName();
						ExcelUtil.setExcelFile(Constant.Path_TestData1 + Constant.File_AdminTestData,
								Constant.Sheet_Rates2);
						//iTestCaseRow = ExcelUtil.getRowContains(sTestCaseName, Constant.Col_TestCaseName);
						iTestCaseRow=	hm.get(sTestCaseName);
						Thread.sleep(2000);
						FP.fn_ClickCancelButton();
						GenericMethods.clickElement(FrontdeskLandingPage.Current_Link);
						String cwid = GenericMethods.GetCurrentWindowID();
						FP.settingFSDateView();
						
						
						} catch (Throwable e) {
						GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
						ExcelUtil.CloseAllExcelReferences();
						throw e;
					}
				}
				
		@AfterMethod
		public void closeApp() throws Throwable {
			try {
				Set<String> setHndlValColls = GenericMethods.driver.getWindowHandles();
				Iterator<String> itHandleColls = setHndlValColls.iterator();
				while (itHandleColls.hasNext() == true) {
					String hndlval = itHandleColls.next();
					GenericMethods.driver.switchTo().window(hndlval);
					if (GenericMethods.driver.getTitle().contains("Frontdesk") == false) {
						GenericMethods.driver.close();
					}
				}
				GenericMethods.switchToWindowHandle("Frontdesk");
				GenericMethods.driver.navigate().refresh();
			} catch (Exception e) {
				Thread.sleep(10000);
				Set<String> setHndlValColls = GenericMethods.driver.getWindowHandles();
				Iterator<String> itHandleColls = setHndlValColls.iterator();
				while (itHandleColls.hasNext() == true) {
					String hndlval = itHandleColls.next();
					GenericMethods.driver.switchTo().window(hndlval);
					if (GenericMethods.driver.getTitle().contains("Frontdesk") == false) {
						GenericMethods.driver.close();
					}
				}

				GenericMethods.switchToWindowHandle("Frontdesk");
				GenericMethods.driver.navigate().refresh();
			}

		}
		
		

	}

