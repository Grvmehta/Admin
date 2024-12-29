package com.hotelogix.smoke.admin.Report;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class NightAuditReportPage {
	
	

	@FindBy(xpath="//a[text()='View Report']")
	public static WebElement  ViewReport;
	
   @FindBy(xpath="//td[text()='Night Audit Report']")
	public WebElement txt_pgeHeader;
	
   @FindBy(xpath="//table[@class='list_viewnew']//tr[2]//td[2]")
	public WebElement txt_NADate;
   
  public static String s1="";
	
public static void NightAuditReport_Page(){
	
	
		
		String title=GenericMethods.driver.getTitle();
		if(title.contains("Audit Report")){
		System.out.println(title + "page");
}
		else System.out.println("we are not on the page");
}


public NightAuditPage ViewReport_link() throws Exception{
	
	GenericMethods.clickElement(ViewReport);
	NightAuditPage NAP=PageFactory.initElements(GenericMethods.driver,NightAuditPage.class);
	return NAP;
}


public void fn_clkHeader() throws Exception{
try{
	GenericMethods.clickElement(txt_pgeHeader);
}catch(Exception e){
	throw e;
}
}

public String getNADate() throws Exception{
	
	
	
	s1=GenericMethods.getText(txt_NADate);
	NightAuditPage NAP=PageFactory.initElements(GenericMethods.driver,NightAuditPage.class);
	return s1;
}



}
