package com.hotelogix.smoke.admin.PriceManager;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.hotelogix.smoke.genericandbase.GenericMethods;

public class FrontdeskPackagesListPage {
	
	
	
    public static String data;
    public static String src;
    
    public static String src1;
    
    
	  @FindBy(xpath="//input[@name='id[]']")
	    public static List<WebElement> ChkBox;
    
	//table//tr[4]/td
    
	  @FindBy(xpath="//table//tr[4]/td")
	    public static WebElement Msg;
    
  
    

	    @FindBy(xpath="//a[@title='Attach a Package']")
	    public static WebElement AttachPackage_Btn;    
    
    
    
	    public AttachPackagesPage AttachPackage_Click() throws Exception{
	    	
	    	GenericMethods.clickElement(AttachPackage_Btn);
	    	AttachPackagesPage APP2=PageFactory.initElements(GenericMethods.driver, AttachPackagesPage.class);
	    	return APP2;
	     }
    
    
    
	
    public  FrontDeskPackageDetailPage  VerifyAndConfigure() throws Exception{
    	
    	
    	
   
    	  
  

        int trcount=GenericMethods.tr_count(ChkBox);
        System.out.println(trcount);
       int tr=trcount+2;
        for(int i=2;i<=tr;i++){
         
        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
        System.out.println(data);         
          
        if(data.contains(AddEditPackagePage.packageName)){
               System.out.println(data +" Searched Package Find ");
                src=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/img")).getAttribute("src");
                GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[7]/a")).click();
             
               break;
           }
          
	}
    	
    	
        FrontDeskPackageDetailPage FPD=PageFactory.initElements(GenericMethods.driver, FrontDeskPackageDetailPage.class);
    	return FPD;
    }


	
	
	
	
	public void VerifyConfigueration() throws InterruptedException{
		
	String msg=Msg.getText();
	System.out.println(msg);
	if(msg.contains(AddEditPackagePage.packageName)){
		System.out.println("syso Package added suceesfully goin to congigure it");
	}
		
	     int trcount=GenericMethods.tr_count(ChkBox);
	        System.out.println(trcount);
	       int tr=trcount+2;
	        for(int i=2;i<=tr;i++){
	         
	        data=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[3]")).getText();
	        System.out.println(data);         
	          
	        if(data.contains(AddEditPackagePage.packageName)){
	               System.out.println(data +" Searched Package Find ");
	                src1=GenericMethods.driver.findElement(By.xpath("//table[@class='list_viewnew']//tr["+i+"]//td[6]/a")).getText();
	             
	             
	               break;
	           }
	          
		}
		
		if(src.equals(src1)){
			System.out.println("Activation status remaining same");
		}
		else{
			System.out.println("Before configuring " +src);
			System.out.println("After configuring " +src1);
			
			System.out.println("Activation status changed");
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
    

    
    
    
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
