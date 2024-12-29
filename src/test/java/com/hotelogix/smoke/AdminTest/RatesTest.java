package com.hotelogix.smoke.AdminTest;

import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.General.AddDynamicDisounts;
import com.hotelogix.smoke.admin.General.EarlyBirdDiscountPage;
import com.hotelogix.smoke.admin.General.LastMinuteDiscountPage;
import com.hotelogix.smoke.admin.General.LongStayDiscountPage;
import com.hotelogix.smoke.admin.PosManager.AddEditPOSCategory;
import com.hotelogix.smoke.admin.PosManager.AddEditPOSPoint;
import com.hotelogix.smoke.admin.PosManager.AddPOSProduct;
import com.hotelogix.smoke.admin.PosManager.AddPOSTax;
import com.hotelogix.smoke.admin.PosManager.POSCategories;
import com.hotelogix.smoke.admin.PosManager.POSPointsLandingPage;
import com.hotelogix.smoke.admin.PosManager.POSProductsList;
import com.hotelogix.smoke.admin.PosManager.POSTaxListPage;
import com.hotelogix.smoke.admin.PriceManager.AddActivationDateFD;
import com.hotelogix.smoke.admin.PriceManager.AddEditPackage;
import com.hotelogix.smoke.admin.PriceManager.AddMoreInclusions;
import com.hotelogix.smoke.admin.PriceManager.AddSeasonPage;
import com.hotelogix.smoke.admin.PriceManager.AddSpecialPeriodPage;
import com.hotelogix.smoke.admin.PriceManager.AddonLandingPage;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesCorporate1;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesFrontdesk;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesTravelAgent1;
import com.hotelogix.smoke.admin.PriceManager.ListOfPackagesWeb;
import com.hotelogix.smoke.admin.PriceManager.ListofPackagesInPackageMaster;
import com.hotelogix.smoke.admin.PriceManager.PackageDetailsFrontDesk;
import com.hotelogix.smoke.admin.PriceManager.SaveAddonsPage;
import com.hotelogix.smoke.admin.PriceManager.SeasonsLandingPage;
import com.hotelogix.smoke.admin.PriceManager.SpecialPeriodLandingPage;
import com.hotelogix.smoke.admin.PriceManager.attachPackages;
import com.hotelogix.smoke.admin.Report.NightAuditReportPage;
import com.hotelogix.smoke.admin.roommanager.RoomTaxesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTypesLandingPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTaxesPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTypesPage;
import com.hotelogix.smoke.frontdesk.CashCounter.CashCounterPage;
import com.hotelogix.smoke.frontdesk.FrontdeskTrialPage.FrontdeskContinueTrialPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.FrontdeskLoginPage;

public class RatesTest {
	
    private static BasePage BP;
	private  String sTestCaseName;
	private int iTestCaseRow;
    public static  String wID;
    public static HashMap<String,Integer> hm=null;
    
    String pdtName="";
    String posPointName="";
    String addOnname="";
    
    String PName="";
    
    String naDate="";
    
    String dynamicDiscountPackage="Dynamic Discounts";

    @BeforeTest
    public void Login() throws Throwable
    {
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
    	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
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
    
  //TC_07: Navigate to Room Tax Page
  	//TC_08: Save Room Taxes
  	//TC_09: User should be directed to 'Rooms Types List' page.
  	//TC_10: Taxes should be attached to the Room Type and saved successfully.
  	@Test(priority=1,description="Creation of Slab Tax.",groups="Rates")
  	public void fn_CreatingSlabTax1() throws Throwable
  	{
  		try
  		{
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			iTestCaseRow=	hm.get(sTestCaseName);
  			NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
  		String s1=	NAR.getNADate();
  		NAR.fn_clkHeader();
  		System.out.println("Text came as::::"+s1);
  		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
  		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
  		SRTP.createSlabTax1(s1);
  		//SRTP.createSlabTax2(s1);
  		String str=RTLP.verify_roomtax();
  		Assert.assertEquals(str.contains(SaveRoomTaxesPage.slabTaxName1), true);
  		RTLP.chk_taxstatus();
  		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  		SaveRoomTypesPage SRP=RLP.addRoomType();
  		SRP.verify_roomtax();
  		SRP.fn_clkRoomTypeList();
  		RLP.clickEdit();
  	//	SRP.clickCheckBox();
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
    
  	
  @Test(priority=2,description="Creation of Slab Tax2.",groups="Rates")
  	public void fn_CreatingSlabTax2() throws Throwable
  	{
  		try
  		{
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			iTestCaseRow=	hm.get(sTestCaseName);
  			/*NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
  		String s1=	NAR.getNADate();
  		NAR.fn_clkHeader();
  		System.out.println("Text came as::::"+s1);*/
  		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
  		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
  		//SRTP.createSlabTax1(s1);
  		SRTP.createSlabTax2();
  		String str=RTLP.verify_roomtax();
  		Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
  		RTLP.chk_taxstatus();
  		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  		SaveRoomTypesPage SRP=RLP.addRoomType();
  		SRP.verify_roomtax();
  		SRP.fn_clkRoomTypeList();
  		RLP.clickEdit();
  	//	SRP.clickCheckBox();
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
    
  	@Test(priority=3,description="Creation of room tax and attaching it to a room type.")
	public void fn_creatingRackRateTax() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			System.out.println(iTestCaseRow);
		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
		System.out.println("title::"+GenericMethods.driver.getTitle());
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		String s1=ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1));
		System.out.println(s1);
		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
		SRTP.creatingTaxOnRackRate();
		String str=RTLP.verify_roomtax();
		Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
		RTLP.chk_taxstatus();
		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
		SaveRoomTypesPage SRP=RLP.addRoomType();
		SRP.verify_roomtax();
		SRP.fn_clkRoomTypeList();
		RLP.clickEdit();
		//SRP.clickCheckBox();
		SRP.saveRoomType();
		
		RLP.verify_roomtype();
		
		
		System.out.println("TC_07_08_09_10 Executed");
		 ExcelUtil.CloseAllExcelReferences();
		}
		 catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
  	
	}
  	@Test(priority=4,description="Creation of tax On Tax",groups="Rates")
  	public void enablingTaxOnTaxInExistingTax() throws Throwable
  	{
  		try
  		{
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			iTestCaseRow=	hm.get(sTestCaseName);
  		/*	NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
  		String s1=	NAR.getNADate();
  		NAR.fn_clkHeader();
  		System.out.println("Text came as::::"+s1);*/
  		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
  		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
  		SRTP.creatingTaxOnTariff();
  		RTLP.enablingTaxOnTaxInExistingTax();
  		SRTP.enableTaxOnTax();
  		//Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
  		/*RTLP.chk_taxstatus();
  		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  		SaveRoomTypesPage SRP=RLP.addRoomType();
  		SRP.verify_roomtax();
  		SRP.fn_clkRoomTypeList();
  		RLP.clickEdit();
  	//	SRP.clickCheckBox();
  		SRP.saveRoomType();
  		
  		RLP.verify_roomtype();
  		*/
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
    
	@Test(priority=5,description="Creation of Per reservation tax",groups="Rates")
  	public void creatingPerReservationFixTax() throws Throwable
  	{
  		try
  		{
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			iTestCaseRow=	hm.get(sTestCaseName);
  		/*	NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
  		String s1=	NAR.getNADate();
  		NAR.fn_clkHeader();
  		System.out.println("Text came as::::"+s1);*/
  		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
  		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
  		SRTP.creatingPerReservationTax();
  		
  		//Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
  		RTLP.chk_taxstatus();
  		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  		SaveRoomTypesPage SRP=RLP.addRoomType();
  		SRP.verify_roomtax();
  		SRP.fn_clkRoomTypeList();
  		RLP.clickEdit();
  	//	SRP.clickCheckBox();
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
    
	
	@Test(priority=6,description="Creation of Per Night Tax",groups="Rates")
  	public void creatingPerNightFixTax() throws Throwable
  	{
  		try
  		{
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			iTestCaseRow=	hm.get(sTestCaseName);
  		/*	NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
  		String s1=	NAR.getNADate();
  		NAR.fn_clkHeader();
  		System.out.println("Text came as::::"+s1);*/
  		RoomTaxesLandingPage RTLP=BP.roomTaxPageNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
  		SaveRoomTaxesPage SRTP=RTLP.clickAddRoomTaxes();
  		SRTP.creatingPerNightTax();
  		
  		//Assert.assertEquals(str.contains(SaveRoomTaxesPage.taxName), true);
  		RTLP.chk_taxstatus();
  		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  		SaveRoomTypesPage SRP=RLP.addRoomType();
  		SRP.verify_roomtax();
  		SRP.fn_clkRoomTypeList();
  		RLP.clickEdit();
  	//	SRP.clickCheckBox();
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
    
    
	@Test(priority=7,description="Applying taxes in a room Type",groups="Rates")
  	public void applyingTaxesToRoomType() throws Throwable
  	{
  		try
  		{
  			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
  			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
  			//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
  			iTestCaseRow=	hm.get(sTestCaseName);
  		
  		RoomTypesLandingPage RLP=BP.roomTypesNavigate();
  		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
  		
  		SaveRoomTypesPage SRP=RLP.clickEdit();
  
  		SRP.applyingRoomTaxes("CGST", "SGST", "CESS");
  	//	SRP.clickCheckBox();
  		  		
  		RLP.verify_roomtype();
  		
  		 RLP=BP.roomTypesNavigate();
  		 SRP=RLP.clickEdit();
  		 boolean isSelected=	SRP.verifyingSelectionOfTaxes("CGST");
  		 Assert.assertTrue(isSelected);
  		 
  		 boolean isSelected1=	SRP.verifyingSelectionOfTaxes("SGST");
  		 Assert.assertTrue(isSelected1);
  		
  		 boolean isSelected2=	SRP.verifyingSelectionOfTaxes("CESS");
  		 Assert.assertTrue(isSelected2);
  		
  		System.out.println("TC_07_08_09_10 Executed");
  		 ExcelUtil.CloseAllExcelReferences();
  		}
  		 catch(Throwable e)
  		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
  		   ExcelUtil.CloseAllExcelReferences();
  		   throw e;
  		   }
  	}
    
	@Test(priority=8,description="Addition of POS Tax ,verify its status and reflection.")
    public void fn_verifyAdditionOfPOSTax1() throws Throwable
	{
		try
		{
			//taxName="CGST";
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		POSTaxListPage PTL=BP.fn_navigatePOSManagerPT();
		System.out.println(GenericMethods.driver.getTitle());
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		AddPOSTax APT=PTL.AddTax();
		APT.AddPOSTax1();
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
	
	@Test(priority=9,description="Addition of POS Tax2 ,verify its status and reflection.")
    public void fn_verifyAdditionOfPOSTax2() throws Throwable
	{
		try
		{
			//taxName="CGST";
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		POSTaxListPage PTL=BP.fn_navigatePOSManagerPT();
		System.out.println(GenericMethods.driver.getTitle());
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		AddPOSTax APT=PTL.AddTax();
		APT.AddPOSTax2();
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

    @Test(priority=10,description="Addition of POS TaxOnTax ,verify its status and reflection.")
    public void fn_verifyAdditionOfPOSTaxForTaxOnTax() throws Throwable
	{
		try
		{
			//taxName="CGST";
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			
		POSTaxListPage PTL=BP.fn_navigatePOSManagerPT();
		System.out.println(GenericMethods.driver.getTitle());
		Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
		AddPOSTax APT=PTL.AddTax();
		APT.AddPOSTaxForTaxOnTax();
		POSTaxListPage POTLP=APT.SaveTax();
		POTLP.fn_verifyPOST(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
        //POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
       // AddEditPOSPoint AEPP=PPL.AddEditPOSPoint();
        //AEPP.fn_verifyPOSTax();
        POTLP.enablingTaxOnTaxInExistingTax();
        APT.enableTaxOnTax();
        POTLP.enablingTaxOnTaxInExistingTax();
        APT.verifyingTaxOnTax();
		Reporter.log("Tax on Tax added successfully");
		 ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
	}
    @Test(priority=11,description="Addition of POS TaxOnTax ,verify its status and reflection.")
    public void fn_applyingtaxesOnPosPoint() throws Throwable
	{
		try
		{
			//taxName="CGST";
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			  POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
			  AddEditPOSPoint AEPP=PPL.EditPOSPoint();
			  AEPP.applyingPOSTaxes("CGST", "SGST", "CESS");
			  AEPP.clk_saveBtn();
			  PPL.EditPOSPoint();
			  
		  		 boolean isSelected=	AEPP.verifyingSelectionOfTaxes("CGST");
		  		 Assert.assertTrue(isSelected);
		  		 
		  		 boolean isSelected1=	AEPP.verifyingSelectionOfTaxes("SGST");
		  		 Assert.assertTrue(isSelected1);
		  		
		  		 boolean isSelected2=	AEPP.verifyingSelectionOfTaxes("CESS");
		  		 Assert.assertTrue(isSelected2);
			  
			   
		Reporter.log("Taxes applied successfully in POS point.");
		 ExcelUtil.CloseAllExcelReferences();
		}catch(Throwable e)
		   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
		   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
	}

    @Test(priority=12,description="Addition of POS pdt with taxes.")
    public void fn_addingPdtWithTaxes() throws Throwable
	{
		try
		{
			//taxName="CGST";
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
			
			POSPointsLandingPage PPL=BP.fn_navigatePOSManagerPP();
			AddEditPOSPoint AEPP=PPL.EditPOSPoint();
			posPointName=AEPP.getPosName();
			AEPP.clk_saveBtn();
			 Thread.sleep(6000);
			PPL.verify_AddNewPdtLnk(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		    AddEditPOSCategory AEPC=PPL.clk_AddNewCategory(AddEditPOSPoint.POSPointName);
		    POSCategories POSC=AEPC.fn_addPOSCategory();
		    POSC.fn_viewAll();
		    POSC.verify_addedPOSCategory(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		    Thread.sleep(3000);
		    POSC.clk_lnkPOSPoint();
		    AddPOSProduct APP=PPL.clk_addNewPOSPdtLnk();
		    List<String> ar=APP.verifyPOSCategory();
		    Assert.assertEquals(ar.contains(AddEditPOSCategory.name), true);
		    POSProductsList POPL=APP.fn_addPOSProductWithTaxes("CGST", "SGST","CESS");
		    pdtName=    POPL.verify_addedPOSProductWithTax(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
		    
		    System.out.println("TC_61_62_63 Executed");
		    Reporter.log("Addition of POS Point with a category and product.",true);
		    ExcelUtil.CloseAllExcelReferences();
	        }
			catch(Throwable e)
		   {
				GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				ExcelUtil.CloseAllExcelReferences();
				throw e;
		   }
	}

    @Test(priority=13,description="Creation of ADD-ONS(INCLUSIONS)")
	public void fn_verifyAdditionOfAddOnsWithExistingPdt() throws Throwable
	{
		try
		{
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
		//	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
			iTestCaseRow=	hm.get(sTestCaseName);
		AddonLandingPage AOLP=BP.addonsLandingPage();
		System.out.println("Title::"+GenericMethods.driver.getTitle());
		System.out.println(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1)));
		Assert.assertEquals(GenericMethods.driver.getTitle().contains( ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		SaveAddonsPage SAP=AOLP.clickAddAddons();
		SAP.saveAddonWithSpecificData(posPointName,pdtName);
		String msg=AOLP.verify_saveMsg();
		addOnname=SAP.AddonName;
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

	 @Test(priority=14,description="Creation of package in Package Master and attaching an Add-on to it.")
	   public void fn_attachingexistingAddonToPackage() throws Throwable
	   {
		 System.out.println("Started executing addon to package");
		   try
		   {
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
			ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
			//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
			AEP.fillPkgDetails("1");
			AEP.edit_defaultrate();
		    String a=GenericMethods.GetCurrentWindowID();
		    AddMoreInclusions AMI=AEP.checkadded_addon();
		    GenericMethods.windowHandle(a);
		   // Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
		   System.out.println("addOnname::"+addOnname);
		    AMI.select_preAddedAddons(addOnname);
		    GenericMethods.Switch_Parent_Window(a);
		    AEP.verify_addedIncl();
		    AEP.clickOnSave();
		    ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
		    
		     a=GenericMethods.GetCurrentWindowID();
			  attachPackages AP=LOPF.attachPackage();
			  GenericMethods.windowHandle(a);
			  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
			  PName=AP.getPkgName1(AddEditPackage.pkgName);
			  GenericMethods.Switch_Parent_Window(a);
		    
			//  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
			  // PName=AP.getPkgName1(AddEditPackage.pkgName);
			  int i=PName.indexOf("(");
			  System.out.println(i);
			 PName= PName.substring(0, i);
			   //String s1[]=PName.split("(");
			   //PName=s1[0];
			   System.out.println("PName::"+PName);
			 //  GenericMethods.Switch_Parent_Window(a);
			  String text=LOPF.verify_pkgSavedMsg();
			  Assert.assertEquals(text, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
			  LOPF.viewAll();
			  //ListOfPackagesFrontdesk.getPkgID2();
			  LOPF.verify_savedPkg();
			  PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
			  PDF.clickOnSave_BT();
			  LOPF.viewAll();
			  String c=GenericMethods.GetCurrentWindowID();
			  LOPF.verifyAddActivationDate_linkFD(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
			  AddActivationDateFD AADF=LOPF.AddActivationDateFD_click1();
			  GenericMethods.windowHandle(c);
			  AADF.activateForeverPackateFD();
			  GenericMethods.Switch_Parent_Window(a);
			  Thread.sleep(3000);
			  LOPF.verifyActivatedForeverFD_text(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
			  
		   
		    
		    Reporter.log("TC_13: When 'PACKAGE MASTER' is clicked under 'PRICE MANAGER' tab,system redirects user to 'List of Packages' page. \n"
		    		+"TC_14: When 'Add Inclusions' link on 'Add/Edit a Package' page is clicked,system displays a new window with title as :'Add More Inclusions'. \n"
		    		+"TC_15: On entering manadatory fields on 'Add/Edit a Package' page, selecting inclusion from 'Add More Inclusion' window,and clicking 'Save' button,package gets successfully saved with active status \n"
		    		+"It gets reflected on all types of packages: Frontdesk,Web,Corporate,TA.",true);

		    
		    System.out.println("TC_13_14_15 Executed");
		    ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   {
			   GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
	   }
	// @Test(priority=15,description="Creation of package in Package Master and attaching an Add-on to it.")
	   public void fn_addingValidityCombinationToPackage() throws Throwable
	   {
		 System.out.println("Started executing addon to package");
		   try
		   {
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
			ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
			//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
			/*AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
			AEP.fillPkgDetails("1");
			AEP.edit_defaultrate();
		    String a=GenericMethods.GetCurrentWindowID();
		    AddMoreInclusions AMI=AEP.checkadded_addon();
		    GenericMethods.windowHandle(a);
		   // Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
		   System.out.println("addOnname::"+addOnname);
		    AMI.select_preAddedAddons("Addon60");
		    GenericMethods.Switch_Parent_Window(a);
		    AEP.verify_addedIncl();
		    AEP.clickOnSave();*/
			 String a=GenericMethods.GetCurrentWindowID();
			 NightAuditReportPage NAR=BP.fn_NavigateNightAuditReport();
		  		naDate=	NAR.getNADate();
		  		System.out.println(naDate);
		    ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
		      Assert.assertEquals(GenericMethods.driver.getTitle().contains( ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true);
		      PackageDetailsFrontDesk PDF=    LOPF.editingParticularPackage(PName);
		      PDF.fn_addvalidity(naDate);
		      
		      LOPF.editingParticularPackage(PName);
		      
		      PDF.fn_addAnothervalidity(naDate);
		      
		     // ListOfPackagesFrontdesk.viewAll();
			 // ListOfPackagesFrontdesk.getPkgID1();
			  // a=GenericMethods.GetCurrentWindowID();
			 /* attachPackages AP=LOPF.attachPackage();
			  GenericMethods.windowHandle(a);
			  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
			   PName=AP.getPkgName1(AddEditPackage.pkgName);
			   System.out.println("PName::"+PName);
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
			  
		   
		    */
		    Reporter.log("TC_13: When 'PACKAGE MASTER' is clicked under 'PRICE MANAGER' tab,system redirects user to 'List of Packages' page. \n"
		    		+"TC_14: When 'Add Inclusions' link on 'Add/Edit a Package' page is clicked,system displays a new window with title as :'Add More Inclusions'. \n"
		    		+"TC_15: On entering manadatory fields on 'Add/Edit a Package' page, selecting inclusion from 'Add More Inclusion' window,and clicking 'Save' button,package gets successfully saved with active status \n"
		    		+"It gets reflected on all types of packages: Frontdesk,Web,Corporate,TA.",true);

		    
		    System.out.println("TC_13_14_15 Executed");
		    ExcelUtil.CloseAllExcelReferences();
		   }
		   catch(Throwable e)
		   {
			   GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
		   throw e;
		   }
	   }
	 
	  @Test(priority=16,description="Creation of a season")
		public void fn_verifyAdditionOfSeason() throws Throwable
		{
		  try
		  {
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
		    SeasonsLandingPage SELP=BP.fn_NavigateSeasons();
		    Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
		    String a=GenericMethods.GetCurrentWindowID();
			AddSeasonPage ASP=SELP.Add_Season();
			GenericMethods.windowHandle_admin(a);
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
		int date=	ASP.fn_addSpecificDetails("September 20, 2020","Summer",3,1,20);
			Thread.sleep(4000);
			GenericMethods.Switch_Parent_Window(a);
			  a=GenericMethods.GetCurrentWindowID();
				 ASP=SELP.Add_Season();
				GenericMethods.windowHandle_admin(a);
				Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
			date=	ASP.fn_addSpecificDetails("September 20, 2020","Spring",3,2,date);
			Thread.sleep(4000);	
			GenericMethods.Switch_Parent_Window(a);
				 a=GenericMethods.GetCurrentWindowID();
					 ASP=SELP.Add_Season();
					GenericMethods.windowHandle_admin(a);
					Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
					ASP.fn_addSpecificDetails("September 20, 2020","Winter",3,3,date);
					
					GenericMethods.Switch_Parent_Window(a);
			//ASP.Seasons_save();
			//GenericMethods.Switch_Parent_Window(a);
			Thread.sleep(3000);
			/*SELP.fn_verifySeasonLP();
	        SELP.fn_deleteSeason();
	        SELP.fn_clkDeleteSeasonBtn();*/
	        
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
		
		
	   
		@Test(priority=17,description="Creation of Special Period and verify its status.")
		public void fn_verifyAdditionOfSpecialPeriod() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
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

		@Test(priority=18,description="Creation of Dynamic discount")
		public void fn_verifyAdditionOfEarlyBirdDiscount() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				EarlyBirdDiscountPage earlyBirdObj=	BP.navigatingToEarlyBird();
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
			earlyBirdObj.addEarlyBirdDiscount("EarlyBird", "1", "10", "50", "20");
			
			String msg=earlyBirdObj.verify_saveMsg();
			Assert.assertEquals(msg.contains("Discount saved successfully."),true);
			
			earlyBirdObj.verify_savedDiscount(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;

			   }
		}
		
		@Test(priority=19,description="Creation of Last Minute discount")
		public void fn_verifyAdditionOflastMinuteDiscount() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				LastMinuteDiscountPage lastminuteObj=	BP.navigatingToLastMinute();
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
			lastminuteObj.addlastMinuteDiscount("LastMminute", "1", "10", "50", "20");
			
			String msg=lastminuteObj.verify_saveMsg();
			Assert.assertEquals(msg.contains("Discount saved successfully."),true);
			
			lastminuteObj.verify_savedDiscount(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;

			   }
		}
		
		
		@Test(priority=20,description="Creation of Dynamic discount")
		public void fn_verifyAdditionOfDynamicDiscount() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				AddDynamicDisounts dynDiscObj=	BP.navigatingToDynamicDiscount();
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
			dynDiscObj.addDynamicDiscount("Dynamic Pricing", "1", "10", "50", "20");
			
			//String msg=dynDiscObj.verify_saveMsg();
			//Assert.assertEquals(msg.contains("Discount saved successfully."),true);
			
			dynDiscObj.verify_savedDiscount(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;

			   }
		}
		
		@Test(priority=21,description="Creation of Long stay per night discount")
		public void fn_verifyAdditionOfPerNightLongStay() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				LongStayDiscountPage longStayObj=	BP.navigatingToLongStayDiscountPage();
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
			longStayObj.addPernightLongStay("LongStay Per Night", "2", "1");
			
			String msg=longStayObj.verify_saveMsg();
			Assert.assertEquals(msg.contains("Discount saved successfully."),true);
			
			longStayObj.verify_savedDiscount(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;

			   }
		}
		
		@Test(priority=22,description="Creation of Long Stay percentage discount")
		public void fn_verifyAdditionOfPercentageLongStay() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
				//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
				iTestCaseRow=	hm.get(sTestCaseName);
				LongStayDiscountPage longStayObj=	BP.navigatingToLongStayDiscountPage();
			Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
			longStayObj.addPercentageLongStay("Long Stay Percentage", "2", "30");
			
			String msg=longStayObj.verify_saveMsg();
			Assert.assertEquals(msg.contains("Discount saved successfully."),true);
			
			longStayObj.verify_savedDiscount(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2)));
			}catch(Throwable e)
			   {GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
			   ExcelUtil.CloseAllExcelReferences();
			   throw e;

			   }
		}

		 @Test(priority=23,description="Creation of package in Package Master and attaching dynamic,last minute and early bird discount.")
		   public void fn_addingFDPackageWithDynamicDiscounts() throws Throwable
		   {
			 System.out.println("Started executing addingFDPackageWithDynamicDiscounts");
			   try
			   {
					sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
					ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Rates2);
					//iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);
					iTestCaseRow=	hm.get(sTestCaseName);
				ListofPackagesInPackageMaster LOPM=BP.fn_navigatePackageMaster();
				//Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))), true);
				AddEditPackage AEP=LOPM.fn_NavigateToAddEditPackage();
				AEP.fillPkgDetails("1");
				AEP.edit_defaultrate();
			    String a=GenericMethods.GetCurrentWindowID();
			    AddMoreInclusions AMI=AEP.checkadded_addon();
			    GenericMethods.windowHandle(a);
			   // Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))), true);
			   System.out.println("addOnname::"+addOnname);
			    AMI.select_preAddedAddons(addOnname);
			    GenericMethods.Switch_Parent_Window(a);
			    AEP.verify_addedIncl();
			    AEP.clickOnSave();
			    ListOfPackagesFrontdesk LOPF=BP.fn_navigateFrontDskPkg();
			    
			     a=GenericMethods.GetCurrentWindowID();
				  attachPackages AP=LOPF.attachPackage();
				  GenericMethods.windowHandle(a);
				  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
				  PName=AP.getPkgName1(AddEditPackage.pkgName);
				  GenericMethods.Switch_Parent_Window(a);
			    
				//  Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult2))),true );
				  // PName=AP.getPkgName1(AddEditPackage.pkgName);
				  int i=PName.indexOf("(");
				  System.out.println(i);
				 PName= PName.substring(0, i);
				   //String s1[]=PName.split("(");
				   //PName=s1[0];
				   System.out.println("PName::"+PName);
				 //  GenericMethods.Switch_Parent_Window(a);
				  String text=LOPF.verify_pkgSavedMsg();
				  Assert.assertEquals(text, ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult3)));
				  LOPF.viewAll();
				  //ListOfPackagesFrontdesk.getPkgID2();
				  LOPF.verify_savedPkg();
				  PackageDetailsFrontDesk PDF=LOPF.confgr_attachedPkgFD();
				  PDF.clickOnSave_BT();
				  LOPF.viewAll();
				  String c=GenericMethods.GetCurrentWindowID();
				  LOPF.verifyAddActivationDate_linkFD(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult4)));
				  AddActivationDateFD AADF=LOPF.AddActivationDateFD_click1();
				  GenericMethods.windowHandle(c);
				  AADF.activateForeverPackateFD();
				  GenericMethods.Switch_Parent_Window(a);
				  Thread.sleep(3000);
				  LOPF.verifyActivatedForeverFD_text(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult5)));
				  
				  PDF=    LOPF.editingParticularPackage(PName);
				  
				  PDF.changePackageName(dynamicDiscountPackage);
				  
				  a=GenericMethods.GetCurrentWindowID();
				  PDF.applyingDynamicDiscounts("Early Bird");
				  GenericMethods.windowHandle(a);
				  PDF.enablingDynamicDiscount();
				  GenericMethods.Switch_Parent_Window(a);
				  
				  a=GenericMethods.GetCurrentWindowID();
				  PDF.applyingDynamicDiscounts("Last Minute");
				  GenericMethods.windowHandle(a);
				  PDF.enablingDynamicDiscount();
				  GenericMethods.Switch_Parent_Window(a);
				  
				  a=GenericMethods.GetCurrentWindowID();
				  PDF.applyingDynamicDiscounts("Dynamic Pricing");
				  GenericMethods.windowHandle(a);
				  PDF.enablingDynamicDiscount();
				  GenericMethods.Switch_Parent_Window(a);
				  
				  PDF.clickOnSave_BT();
				  
				  PDF=    LOPF.editingParticularPackage(dynamicDiscountPackage);
				  
				  
			    Reporter.log("TC_13: When 'PACKAGE MASTER' is clicked under 'PRICE MANAGER' tab,system redirects user to 'List of Packages' page. \n"
			    		+"TC_14: When 'Add Inclusions' link on 'Add/Edit a Package' page is clicked,system displays a new window with title as :'Add More Inclusions'. \n"
			    		+"TC_15: On entering manadatory fields on 'Add/Edit a Package' page, selecting inclusion from 'Add More Inclusion' window,and clicking 'Save' button,package gets successfully saved with active status \n"
			    		+"It gets reflected on all types of packages: Frontdesk,Web,Corporate,TA.",true);

			    
			    System.out.println("TC_13_14_15 Executed");
			    ExcelUtil.CloseAllExcelReferences();
			   }
			   catch(Throwable e)
			   {
				   GenericMethods.getscreenshot(Thread.currentThread().getStackTrace()[1].getMethodName());
				   ExcelUtil.CloseAllExcelReferences();
			   throw e;
			   }
		   }
		 
		 
		 
		
		 
		 
		 
		 
		 
}
