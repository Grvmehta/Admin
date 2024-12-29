package com.hotelogix.smoke.admin.Console;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




import com.hotelogix.smoke.genericandbase.GenericMethods;

public class RegisteredTravelAgentPage {


	public static String src;


	@FindBy(xpath="//td[text()='List of Registered Travel Agent']")
	public  WebElement txt_pgTitle;

	@FindBy(xpath="//a[@title='Add a Travel Agent']")
	public  WebElement btn_AddTravelAgent;

	@FindBy(xpath="//a[@title='Delete Selected Travel Agent(s)']")
	public  WebElement btn_DeleteTravelAgent;

	@FindBy(xpath="//a[@title='Cancel']")
	public  WebElement btn_Cancel;

	@FindBy(xpath="//a[text()='Main']")
	public  WebElement link_Main;

	@FindBy(xpath="//span[text()='Search Registered Travel Agent:']")
	public  WebElement txt_Search;

	@FindBy(xpath="//input[@name='searchTitle']")
	public  WebElement txtbx_Search;

	@FindBy(xpath="//input[@type='submit']")
	public  WebElement btn_Search;

	@FindBy(xpath="//div[@class='error_new']")
	public  WebElement txt_verifyMsg;

	@FindBy(xpath="//input[@name='id[]']")
	public  List<WebElement> count_CheckBox;


public String checkStatus() throws InterruptedException{
	int trcount=GenericMethods.tr_count(count_CheckBox);
	 int tr=trcount+2;
	    for(int i=2;i<=tr;i++){
	    String  Tname=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[4]")).getText();
	    if(Tname.contains(AddTravelAgentPage.TaName)){
	    System.out.println(AddTravelAgentPage.TaName +"  Find ");
	     src= GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[10]/a/img")).getAttribute("src");
	     break;
	    }
	    }

		return src;






}


public AddTravelAgentPage AddTravelAgent_Btn() throws Exception{

	try{
	GenericMethods.clickElement(btn_AddTravelAgent);
	}catch(Exception e){

	WebElement ele1 =GenericMethods.ExplicitWait(btn_AddTravelAgent, "//a[@title='Add a Travel Agent']");
		ele1.click();
	}




	AddTravelAgentPage ATA=PageFactory.initElements(GenericMethods.driver,AddTravelAgentPage.class);
    return ATA;

}

public void Verify_RegisteredTravelAgent() throws InterruptedException{
	String str;
	try{
	str=GenericMethods.getText(txt_verifyMsg);
	}catch(Exception e){

		Thread.sleep(3500);
		str=GenericMethods.getText(txt_verifyMsg);
	}


	System.out.println(str);
	     if(str.contains("saved successfully")){
	    	 System.out.println( str + "showing ");
	     }else System.out.println("not saved");

}














}
