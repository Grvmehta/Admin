package com.hotelogix.smoke.frontdesk.CashCounter;

import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditVideoPage {


	public void VerifyPage() throws Exception
	{
		try
		{
		String title=GenericMethods.driver.getTitle();
		Assert.assertEquals(title, "How to perform Night Audit?");
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

}
