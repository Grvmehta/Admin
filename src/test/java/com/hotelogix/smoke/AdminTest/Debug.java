package com.hotelogix.smoke.AdminTest;

import java.util.List;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.hotelogix.smoke.admin.CompanyInfo.HotelInformationPage;
import com.hotelogix.smoke.admin.UserManager.AddEditUser;
import com.hotelogix.smoke.admin.UserManager.AddEditUserLevelPage;
import com.hotelogix.smoke.admin.UserManager.UsersLevelList;
import com.hotelogix.smoke.admin.UserManager.UsersListLandingPage;
import com.hotelogix.smoke.admin.roommanager.AddEditAmenity;
import com.hotelogix.smoke.admin.roommanager.AmenitiesLandingPage;
import com.hotelogix.smoke.admin.roommanager.RoomTypesLandingPage;
import com.hotelogix.smoke.admin.roommanager.SaveRoomTypesPage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;


import com.hotelogix.smoke.frontdesk.WebReservation.WebSelectRoomPage;
import com.hotelogix.smoke.genericandbase.BasePage;
import com.hotelogix.smoke.genericandbase.Constant;
import com.hotelogix.smoke.genericandbase.ExcelUtil;
import com.hotelogix.smoke.genericandbase.GenericMethods;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;


public class Debug {
	
	private static BasePage BP;
	private  String sTestCaseName;
	private int iTestCaseRow;
    public static  String wID;
	
    
    
    @BeforeClass
    public void Login() throws Throwable
    {
    	sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
    	ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin1);
    	iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

    	try{
    	//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.stayezee.com/admine/login/login/");
    	AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
        BP=AL.adminlogin(iTestCaseRow);
        wID=GenericMethods.GetCurrentWindowID();
    	}catch(Throwable e){
            Thread.sleep(1000);
    		System.out.println("System is showing problem during login");
    		//AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", "http://hotelogix.stayezee.com/admine/login/login/");
    		AdminLoginPage AL = GenericMethods.fn_OpenAdmin("FF", ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_AppURL)));
    		BP=AL.adminlogin(iTestCaseRow);
    		 wID=GenericMethods.GetCurrentWindowID();
    	}

    Thread.sleep(2000);
    }

	
	@Test(priority=21,description="Change Hotel Information and verify 'Save' button.")
	public void fn_verifySaveHotelInfoChanges() throws Throwable
	{
		try
		{
			
			sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
			ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin1);
			iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

		HotelInformationPage HP=BP.fn_navigateCompanyInfo();
	//	Assert.assertEquals(GenericMethods.driver.getTitle().contains(ExcelUtil.getCellData(iTestCaseRow, ExcelUtil.GetColumnIndex(Constant.Col_ExpectedResult1))),true );
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




		//@Test(priority=22,description="Creation of a User Level and verify its reflection on 'Add/Edit User' page.")
	    public void fn_verifyAdditionOfUserLevels() throws Throwable
		{
			try
			{
				sTestCaseName=Thread.currentThread().getStackTrace()[1].getMethodName();
				ExcelUtil.setExcelFile(Constant.Path_TestData1 +  Constant.File_AdminTestData,Constant.Sheet_Admin1);
				iTestCaseRow=ExcelUtil.getRowContains(sTestCaseName,Constant.Col_TestCaseName);

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

}
