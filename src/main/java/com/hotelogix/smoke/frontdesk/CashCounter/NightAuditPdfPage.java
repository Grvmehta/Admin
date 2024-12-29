package com.hotelogix.smoke.frontdesk.CashCounter;

import org.testng.Assert;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditPdfPage {



public void VerifyPage() throws Exception
{
	try
	{
String title=GenericMethods.driver.getTitle();
Assert.assertEquals(title, "night_audit__en__2.0.pdf");
GenericMethods.driver.close();

	}
	catch(Exception e)
	{
		throw e;
	}
	catch(AssertionError e)
	{
		throw e;
	}
}

}
