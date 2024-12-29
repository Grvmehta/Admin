package com.hotelogix.smoke.frontdesk.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import com.hotelogix.smoke.frontdesk.FrontdeskHome.FrontdeskLandingPage;
import com.hotelogix.smoke.frontdesk.SampleRestaurantPage.OrderFolioPage;
import com.hotelogix.smoke.genericandbase.GenericMethods;




public class AccountStatementLandingPage {

	public static String CustomChargeDescription="Item 2";

	public static String priceForCustomCharge="10";
	public static String  quantityForCustomCharge="1";
	public static String POSPoint;
	public static String item;
	
	public String postedRoomPrice;
	public String postedRoomTax;


	public static String exp_msg="Consolidate Now? \n"+" Accounts Consolidate automatically at Night Audit";


	@FindBy(xpath="//td[contains(normalize-space(text()),'ACCOUNT STATEMENT')]")
	public static WebElement PaymentPage;

	@FindBy(xpath="//input[@id='btnConsolidate']")
	public static WebElement ConsolidateAccountBtn;
	
	@FindBy(xpath="//input[@id='btnConsolidateAcc']")
	public WebElement btn_grpConsolidateAcc;

	@FindBy(xpath="//input[@type='checkbox']")
	public static List<WebElement> AllThePostedItemToAccount;

	@FindBy(xpath="//table[@class='payment_total']//tbody//tr[4]//td[2]")
	public static WebElement RoomTax;

	@FindBy(xpath="//input[@id='btnCustomCharges']")
	public static WebElement CustomChargeBtn;

	@FindBy(xpath="//td[text()='Custom Charge/Allowance']")
	public static WebElement CustomChargeAllowanceTitle;

	@FindBy(xpath="//a[text()='Close']")
	public static WebElement CloseBtnOnPopUp;

	@FindBy(xpath="//select[@id='selPOS']")
	public static WebElement POSDropdownInCustomCharge;

	@FindBy(xpath="//input[@id='ocTxtProduct']")
	public static WebElement DescriptionForCustomCharge;

	@FindBy(xpath="//input[@id='price']")
	public static WebElement PriceForCustomCharge;

	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public static WebElement QuantityForCustomCharge;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public static WebElement SaveCustomCharge;

	@FindBy(xpath="//input[@id='btnAddNewCharges']")
	public  static WebElement OtherChargesBtn;

	@FindBy(xpath="//select[@id='selPOSGuest']")
	public static WebElement ChargeToDropdown;

	@FindBy(xpath="//select[@id='selPOS']")
	public static WebElement POSPointDropdown;

	@FindBy(xpath="//select[@id='SelocTxtProduct']")
	public static WebElement  ProductDropdown;

	@FindBy(xpath="//input[@id='ocTxtQuantity']")
	public static WebElement QtyForOtherCharges;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public static WebElement SaveOtherCharges;

	@FindBy(xpath="//td[text()='Add Other Charges']")
	public static WebElement OtherChargesPopUpTitle;
	
	@FindBy(xpath="//td[text()='Other Charges']")
	public static WebElement OtherChargesGrpPopUpTitle;

	@FindBy(xpath="//a[text()='Close']")
	public static WebElement CloseBtnForOtherCharges;

	@FindBy(xpath="//input[@id='btnGenarateFolio']")
	public static WebElement GeneratorFolio;

	@FindBy(xpath="//input[@id='BtnPaymentsDeletLedger']")
	public static WebElement DeletePerfomaInvoiceBtn;

	@FindBy(xpath="//table[@class='payment_total']//tr[8]//td[@class='frn_total_g']")
	public static WebElement booking_bal;

	@FindBy(xpath="//input[@name='btnGenarateFolio']")
	public static WebElement generateFolioBtn;

	@FindBy(xpath="//table[@class='frn_paytbl_fllist']//tr[3]//table//td[1]//span")
	public static WebElement Nofolio;

	@FindBy(xpath="//input[@name='BtnPaymentsDeletLedger']")
	public static WebElement delPerformaInvoice;

	@FindBy(xpath="//input[@name='btnAddNewCharges']")
	public static WebElement otherCharges;

	@FindBy(xpath="//input[@name='btnGrpOtherCharge']")
	public static WebElement otherCharges1;

	@FindBy(xpath="//select[@name='selPOSGuest']")
	public static WebElement chargeTo;

	@FindBy(xpath="//select[@name='selPOSRoomOwner']")
	public static WebElement chargeToGrp;

	@FindBy(xpath="//select[@id='selPOS']")
	public static WebElement posPoint;

	@FindBy(xpath="//select[@name='SelocTxtProduct']")
	public static WebElement posProduct;

	@FindBy(xpath="//input[@name='ocTxtDiscount']")
	public static WebElement discount;

	@FindBy(xpath="//button[@id='ocBtnSave-button']")
	public static WebElement saveOtherCharge;

	@FindBy(xpath="//td[@class='front_tbl_lft']//tr//td[2]//input")
	public static List<WebElement> chkboxCount;

	@FindBy(xpath="//input[@name='btnCreateNewFolio']")
	public static WebElement routeToNewFolio;

	@FindBy(xpath="//div[@id='PanelSingleCreateNewFolio_h']")
	public static WebElement createFolioTitle;

	@FindBy(xpath="//div[@id='PanelCreateNewFolioGr_h']")
	public static WebElement createFolioTitleGrp;

	@FindBy(xpath="//input[@name='btnCustomCharges']")
	public static WebElement customChargeBtn;

	@FindBy(xpath="//input[@name='btnGrpCustomCharge']")
	public static WebElement customChrgGrp;

	@FindBy(xpath="//input[@name='ocTxtProduct' and @type='text']")
	public static WebElement description;

	@FindBy(xpath="//input[@name='price']")
    public static WebElement price;

	@FindBy(xpath="//select[@name='selGuestIds']")
	public static WebElement selGuestId;

	@FindBy(xpath="//button[@id='newFolioCreate-button']")
	public static WebElement createFolio;

	@FindBy(xpath="//input[@name='btnTransactionRoute']")
    public static WebElement routeChargesbtn;

	@FindBy(xpath="//div[@id='PanelRouteTr_h']")
	public static WebElement routeChargesTitle;

	@FindBy(xpath="//div[@id='PanelRouteGroupTr_h']")
	public static WebElement RCGroup;

	@FindBy(xpath="//button[@id='routeGoSave-button']")
    public static WebElement routeBtn;

	@FindBy(xpath="//select[@name='payTypesMode']")
    public static WebElement paymentMode;

	@FindBy(xpath="//select[@name='payTypes']")
	public static WebElement payTypes;

	@FindBy(xpath="//input[@name='amount']")
    public static WebElement amount;

    @FindBy(xpath="//input[@name='btnPaymentPayNow']")
    public static WebElement payNowBtn;

    @FindBy(xpath="//input[@name='btnRoutePay']")
    public static WebElement routePaymentBtn;

    @FindBy(xpath="//input[@name='btnRoutePayment']")
    public static WebElement routePaymentGrp;

    @FindBy(xpath="//div[@id='PanelRouteGroupPay_h']")
    public static WebElement routePaymentTitle;

    @FindBy(xpath="//button[@id='routePayGoSave-button']")
    public static WebElement routePaymentSave;

    @FindBy(xpath="//button[@id='refundDone-button']")
    public static WebElement refund;

    @FindBy(xpath="//input[@name='btnRefundTransaction']")
    public static WebElement refundBtn;

    @FindBy(xpath="//div[@id='PanelSingleRefund_h']")
    public static WebElement refundTitle;

    @FindBy(xpath="//div[@id='PanelGroupRefund_h']")
    public static WebElement refundTitleGrp;

    @FindBy(xpath="//td[@class='front_tbl_lft']//tr//td[4]")
	public static List<WebElement> rowCount;

    @FindBy(xpath="//table[@class='frn_paytbl_fllist']//tr[4]//td[2]")
    public static WebElement invoiceText;

    @FindBy(xpath="//input[@name='BtnPaymentsDeletLedgerGr']")
	public static WebElement delPIGrp;

    @FindBy(xpath="(//td[@class='front_tbl_lft'])[2]//tr")
	public static List<WebElement> tbl_cnt;


    @FindBy(xpath="//input[@name='btnTaxExmptGR']")
    public static WebElement TaxExemptbtn;

    @FindBy(xpath="//div[@id='PanelEXemptTaxTrGR_h']")
    public static WebElement TaxExemptTitle;

    @FindBy(xpath="//select[@name='taxExmptReson']")
    public static WebElement TaxExemptReason;

    @FindBy(xpath="//table[@class='pnl_rates']//tr[2]//td[4]//input[2]")
    public static WebElement TECheckbox;

    @FindBy(xpath="//button[@id='txExmptSave-button']")
    public static WebElement TEBtn;

    @FindBy(xpath="//input[@name='chkshowAllgstId']")
    public static WebElement showAll;

    @FindBy(xpath="//table[@class='dont-print-me-hidden']//table//tr")
    public static List<WebElement> folioCount;

    @FindBy(xpath="//input[@name='ccChequeNo']")
    public static WebElement chequeNum;

    @FindBy(xpath="//input[@name='btnSettleFolio']")
    public static WebElement settleFolio;

    @FindBy(xpath="//table[@class='payment_total']//tr[8]//td[2]")
    public static WebElement totalBal;

    @FindBy(xpath="//input[@value='Check-out']")
	public static WebElement CheckOut_BT;

    @FindBy(xpath="//span[@class='lockfolio-img']")
	public static WebElement LockFolio_IMG;

    @FindBy(xpath="//span[@class='panel-link']")
    public static WebElement moreLink;

    @FindBy(xpath="//input[@id='txtRouteAmnt']")
    public static WebElement routeAmount;

	@FindBy(xpath="//a[@id='addNewAccountCode']")
	public static WebElement addnewaccnt;

	@FindBy(xpath="//input[@id='title']")
	public static WebElement acc_title;

	@FindBy(xpath="//input[@id='accountCode']")
	public static WebElement acc_code;

	@FindBy(xpath="//button[@class='ui-button ui-widget ui-state-default ui-corner-all ui-button-text-only']")
	public static WebElement acc_savebtn;

	@FindBy(xpath="//div[@class='ui-dialog-buttonset']//button[2]")
	public static WebElement acc_cancelbtn;

	@FindBy(xpath="//select[@id='accountCodeId']")
	public static WebElement accountcode;

	@FindBy(xpath="(//td[@class='front_tbl_lft'])[2]//tr")
	public static List<WebElement> Discription_COUNT;

    @FindBy(xpath="//span[@class='closebtn']")
    public static WebElement closebtn;
    
    
    @FindBy(xpath="//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr")
	public List<WebElement> Text_AccountRecords;

	public static String ChequeNum;
	
public	Map<Integer,String> postedRoomPriceList=null;
public	Map<Integer,String> postedRoomTaxList=null;

	public void VerifyPaymentPage() throws Exception
	{
		try
		{
		String pp=GenericMethods.getText(PaymentPage);
		Assert.assertEquals("ACCOUNT STATEMENT", pp);

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
	
	
	public void clk_GrpConsolidateBtn() throws Exception
	{
		try
		{
			Thread.sleep(4000);
		GenericMethods.clickElement(btn_grpConsolidateAcc);
		GenericMethods.Alert_Accept();
		}
		catch(Exception e)
		{
			throw e;
		}
	}


	public FrontdeskLandingPage clk_SingleConsolidateBtn() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ConsolidateAccountBtn);
		GenericMethods.ActionOnAlert("Accept");
		GenericMethods.clickElement(closebtn);
		FrontdeskLandingPage FLP=PageFactory.initElements(GenericMethods.driver, FrontdeskLandingPage.class);
		return FLP;
		}
		catch(Exception e)
		{
			throw e;
		}

	}


	public void verifyAlert_ConsolidateBtnAccept() throws Exception
	{
		try
		{
		GenericMethods.clickElement(ConsolidateAccountBtn);
		String str=GenericMethods.ActionOnAlert("Accept");
		Assert.assertEquals(str, exp_msg);
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

public void VerifyAlertForConsolidateAccount() throws Exception{
	GenericMethods.clickElement(ConsolidateAccountBtn);
	GenericMethods.ActionOnAlert("Dismiss");
	String a=GenericMethods.value;
	System.out.println(a);
    System.out.println(exp_msg);
	int trueLen=a.length();
	int expLen=exp_msg.length();
	Assert.assertEquals(trueLen,expLen);
	Assert.assertEquals(a, exp_msg);
}

public void VerifyTransferedItem(String id,String Producttax) throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	Thread.sleep(2000);
	String fid=id.trim();
	Thread.sleep(2000);
	int size=GenericMethods.tr_count(tbl_cnt);
	//Thread.sleep(2000);
	int count=size-2;
	Thread.sleep(2000);
	for(int i=count;i>=2;i-=2)
	{
		
		String fNum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText().trim();
        int j=fNum.lastIndexOf("(");
        arr.add(fNum.substring(j+1, fNum.lastIndexOf(")")).split(" ")[1]);
		if(fNum.contains(fid))
		{
			Thread.sleep(2000);
			Assert.assertEquals(fNum.contains(fid), true);
			System.out.println(fid + " Folio number Posted to account statement");
			String tax=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[8]")).getText();
            Assert.assertEquals(tax, Producttax);
            break;
		}
	}
	Assert.assertEquals(arr.contains(fid), true);
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

public void VerifyRoomTaxOnAccountStatement() throws InterruptedException{
	String a=GenericMethods.getText(RoomTax).trim();
	int size=GenericMethods.tr_count(AllThePostedItemToAccount)+2;
	for(int i=2;i<=size;i+=2){
		String tax=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[8]")).getText().trim();
		if(tax.equals(a)){
			System.out.println(tax + "  POSTED IN account section");
			break;

		}
	}

}


public void VerifyTransferedItemTax(String folioNum) throws Exception{
	GenericMethods.clickElement(ConsolidateAccountBtn);
	GenericMethods.ActionOnAlert("Accept");
	Thread.sleep(9000);
	String ftax=folioNum.trim();
	int size=GenericMethods.tr_count(tbl_cnt);
	int count=size-2;
	for(int i=count;i>=2;i-=2){
		//System.out.println(i);
		String fNum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//span//a")).getText().trim();
		if(fNum.equals(OrderFolioPage.folioId.trim()))
		{
			System.out.println(ftax + " Folio tax Posted to account statement");
			String Tax= GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[8]")).getText();
			Assert.assertEquals(Tax, OrderFolioPage.folioTax);

			break;
		}
	}
}
public void ClickToCustomCharge() throws Exception
{
	try
	{
	GenericMethods.clickElement(CustomChargeBtn);
	Assert.assertEquals(GenericMethods.getText(CustomChargeAllowanceTitle), "Custom Charge/Allowance");
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


public void AddCustomCharge() throws Exception
{
	try
	{
	//GenericMethods.clickElement(CustomChargeBtn);
	Select s=new Select(POSDropdownInCustomCharge);
	s.selectByVisibleText("Sample Restaurant");
	Thread.sleep(2000);
	GenericMethods.sendKeys(DescriptionForCustomCharge,AccountStatementLandingPage.CustomChargeDescription);
	Thread.sleep(2000);
	/*String ex=Keys.chord(Keys.CONTROL,"a");
	Thread.sleep(2000);
	GenericMethods.sendKeys(PriceForCustomCharge, ex);
	Thread.sleep(2000);
	PriceForCustomCharge.sendKeys(priceForCustomCharge);
	Thread.sleep(2000);*/
	 Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(price, Keys.chord(Keys.CONTROL, "a"), "50").build().perform() ;
	Thread.sleep(2000);
	acobj.sendKeys(QuantityForCustomCharge, Keys.chord(Keys.CONTROL, "a"), "1").build().perform() ;
	Thread.sleep(2000);
//	QuantityForCustomCharge.sendKeys(quantityForCustomCharge);
	Thread.sleep(2000);
	GenericMethods.clickElement(SaveCustomCharge);
	}
	catch(Exception e)
	{
		throw e;
	}
	
}


public void verifyAddedCustomCharge() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	int size=GenericMethods.tr_count(tbl_cnt);
	for(int i=size-2;i>=2;i-=2)
	{
		String s=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
		arr.add(s);
		if(s.equals(AccountStatementLandingPage.CustomChargeDescription))
		{
			Assert.assertEquals(s.contains(AccountStatementLandingPage.CustomChargeDescription), true);
			break;
		}
	}
	Assert.assertEquals(arr.contains(AccountStatementLandingPage.CustomChargeDescription), true);
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


public void VerifyOtherChargesPopUp() throws Exception
{
	try
	{
	GenericMethods.clickElement(OtherChargesBtn);
	Assert.assertEquals(GenericMethods.getText(OtherChargesPopUpTitle), "Add Other Charges");
	//GenericMethods.clickElement(CloseBtnForOtherCharges);
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

public void AddOtherCharge() throws Exception
{
	try
	{
	GenericMethods.clickElement(OtherChargesBtn);
	Select s=new Select(ChargeToDropdown);

	s.selectByIndex(1);
	Select s1=new Select(POSPointDropdown);
	s1.selectByIndex(1);
	Thread.sleep(3000);
	 POSPoint=s1.getFirstSelectedOption().getText();
	Select s2=new Select(ProductDropdown);
	s2.selectByIndex(1);
	 item=s2.getFirstSelectedOption().getText();
	String ex=Keys.chord(Keys.CONTROL,"a");
	GenericMethods.sendKeys(QtyForOtherCharges, ex);
    QtyForOtherCharges.sendKeys("1");
    GenericMethods.clickElement(SaveOtherCharges);
    GenericMethods.clickElement(GeneratorFolio);
    Thread.sleep(15000);
	}
	catch(Exception e)
	{
		throw e;
	}

}

public void VerifyOtherCharges() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	int size=GenericMethods.tr_count(tbl_cnt);
	int count=size-2;
	for(int i=count;i>=2;i-=2)
	{
		String s=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
		arr.add(s);
		if(s.equals(AccountStatementLandingPage.item))
		{
			Assert.assertEquals(s.equals(AccountStatementLandingPage.item), true);
			System.out.println(s + " Other Charge added ");
			break;
		}
	}
	Assert.assertEquals(arr.contains(AccountStatementLandingPage.item), true);
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


public void VerifyAlertForPIDeletion() throws Exception
{
	  GenericMethods.driver.findElement(By.xpath("//input[@id='chkboxMail_1']")).click();
	  GenericMethods.clickElement(DeletePerfomaInvoiceBtn);
	  GenericMethods.ActionOnAlert("Dismiss");
	  Assert.assertEquals(GenericMethods.value, "Do you wish to delete all Proforma Invoices?");
	}


public void fn_consolidateAcc() throws Exception
{
	try
	{
	String str1=GenericMethods.getText(booking_bal);
	GenericMethods.clickElement(ConsolidateAccountBtn);
	GenericMethods.ActionOnAlert("Accept");
	String str2=GenericMethods.getText(booking_bal);
	Assert.assertEquals(str1, str2);
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


public void fn_DeletePerformaInvoice() throws Exception
{
	try
	{
    GenericMethods.clickElement(generateFolioBtn);
    Thread.sleep(15000);
    GenericMethods.clickElement(delPerformaInvoice);
    String str=GenericMethods.ActionOnAlert("Accept");
    Assert.assertEquals(GenericMethods.value, "Do you wish to delete all Proforma Invoices?");
    String text=GenericMethods.getText(Nofolio);
    Assert.assertEquals(text, "No Folio Generated.");
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

public static String product;
public void fn_addOtherCharge() throws Exception
{
	try
	{
	GenericMethods.clickElement(otherCharges);
	Thread.sleep(14000);
	Select sel=new Select(chargeTo);
	//sel.selectByVisibleText("Gaurav X");
	sel.selectByIndex(1);
	Select sel1=new Select(posPoint);
	//sel1.selectByVisibleText("Hlx_Restaurant");
	sel1.selectByIndex(1);
	Thread.sleep(3000);
	Select sel2=new Select(posProduct);
	//sel2.selectByVisibleText("Sample French Onion Soup");
	sel2.selectByIndex(1);
	product=sel2.getFirstSelectedOption().getText();
	//GenericMethods.sendKeys(discount, "2");
	Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
	Thread.sleep(2000);
	GenericMethods.clickElement(saveOtherCharge);
	Thread.sleep(6000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void fn_addOtherChargeGrp() throws Exception
{

	try
	{
		GenericMethods.clickElement(otherCharges1);
		Select sel=new Select(chargeToGrp);
		//sel.selectByVisibleText("price/C103");
		sel.selectByIndex(2);
		Select sel1=new Select(posPoint);
		//sel1.selectByVisibleText("Sample Restaurant");
		sel1.selectByIndex(1);
		Thread.sleep(3000);
		Select sel2=new Select(posProduct);
		//sel2.selectByVisibleText("Sample French Onion Soup");
		sel2.selectByIndex(1);
		product=sel2.getFirstSelectedOption().getText();
		Actions acobj= new Actions(GenericMethods.driver);
		acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
		//GenericMethods.sendKeys(discount, "2");
		GenericMethods.clickElement(saveOtherCharge);
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_addOtherChargeSetteFolio() throws Exception
{

	try
	{
		GenericMethods.clickElement(otherCharges1);
		Select sel=new Select(chargeToGrp);
		//sel.selectByVisibleText("fj/A105");
		sel.selectByIndex(2);
		Thread.sleep(3000);
		Select sel1=new Select(posPoint);
		//sel1.selectByVisibleText("Sample Restaurant");
		sel1.selectByIndex(1);
        Thread.sleep(4000);
		Select sel2=new Select(posProduct);
		//sel2.selectByVisibleText("Sample French Onion Soup");
		sel2.selectByIndex(1);
		Thread.sleep(4000);
		product=sel2.getFirstSelectedOption().getText();
	    GenericMethods.sendKeys(discount, "2");
		Thread.sleep(4000);
	    GenericMethods.clickElement(saveOtherCharge);
		Thread.sleep(6000);
	}
	catch(Exception e)
	{
		throw e;
	}
}





public void fn_routeToNewFolio() throws Exception
{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(product))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);


}



public void fn_routeToNewFolioGrp() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	if(data.equals(product))
    	{
    		PINum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);
	}
	catch(Exception e)
	{
		throw e;
	}

}


public void fn_verifyRouteToNewFolio() throws Exception
{
	try
	{
	String text=GenericMethods.getText(createFolioTitle);
	Assert.assertEquals(text, "Create New Folio");
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


public void fn_verifyRouteToNewFolioGrp() throws Exception
{
	try
	{
	String text=GenericMethods.getText(createFolioTitleGrp);
	Assert.assertEquals(text, "Create New Folio");
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


public static String CustomCharge;

public void fn_addCustomCharges() throws Exception
{
	try
	{
    GenericMethods.js_Click(customChargeBtn);
    Thread.sleep(14000);
    Select sel=new Select(chargeTo);
    //sel.selectByVisibleText("Gaurav X");
    sel.selectByIndex(1);
    Thread.sleep(3000);
    Select sel1=new Select(posPoint);
    sel1.selectByVisibleText("Hlx_Restaurant");
    Thread.sleep(2000);
    CustomCharge=GenericMethods.generateRandomString();
    //description.click();
    GenericMethods.js_Sendkey(description, CustomCharge);
    //price.clear();
    Thread.sleep(3000);
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(PriceForCustomCharge, Keys.chord(Keys.CONTROL, "a"), "50").build().perform() ;
    //GenericMethods.sendKeys(price, "50");
   // discount.clear();
	Thread.sleep(3000);
	acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
   // GenericMethods.sendKeys(discount, "2");
    GenericMethods.js_Click(saveOtherCharge);
    Thread.sleep(10000);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(12000);
	    Select sel=new Select(chargeTo);
	    //sel.selectByVisibleText("Gaurav X");
	    sel.selectByIndex(1);
	    Thread.sleep(3000);
	    Select sel1=new Select(posPoint);
	    sel1.selectByVisibleText("Hlx_Restaurant");
	    Thread.sleep(2000);
	    CustomCharge=GenericMethods.generateRandomString();
	    //description.click();
	    GenericMethods.js_Sendkey(description, CustomCharge);
	    //price.clear();
	    Thread.sleep(3000);
	    Actions acobj= new Actions(GenericMethods.driver);
		acobj.sendKeys(PriceForCustomCharge, Keys.chord(Keys.CONTROL, "a"), "50").build().perform() ;
	    //GenericMethods.sendKeys(price, "50");
	   // discount.clear();
		Thread.sleep(3000);
		acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
	   // GenericMethods.sendKeys(discount, "2");
	    GenericMethods.js_Click(saveOtherCharge);
	    Thread.sleep(10000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_addCustomChargesGrp() throws Exception
{
	try
	{
	GenericMethods.clickElement(customChrgGrp);
	Assert.assertEquals(GenericMethods.getText(CustomChargeAllowanceTitle), "Custom Charge/Allowance");
    Select sel=new Select(chargeToGrp);
    //sel.selectByVisibleText("price/C103");
    sel.selectByIndex(2);
    Select sel1=new Select(posPoint);
   // sel1.selectByVisibleText("Sample Restaurant");
    sel1.selectByIndex(1);
    Thread.sleep(4000);
    CustomCharge=GenericMethods.generateRandomString();
    //description.click();
    GenericMethods.js_Sendkey(description, CustomCharge);
    Thread.sleep(7000);
    //price.clear();
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(price, Keys.chord(Keys.CONTROL, "a"), "50").build().perform() ;
    //GenericMethods.sendKeys(price, "50");
   // discount.clear();
	Thread.sleep(4000);
	acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
   // GenericMethods.sendKeys(discount, "2");
    GenericMethods.js_Click(saveOtherCharge);
    Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}




public void fn_CustomChargetoNewFolio() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	GenericMethods.js_Click(generateFolioBtn);
	Thread.sleep(25000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	arr.add(data);
    	if(data.equals(CustomCharge))
    	{
    		Assert.assertEquals(data.equals(CustomCharge), true);
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(CustomCharge), true);
    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);
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

public static String routedGuestN;
public void fn_selectGuestIDToNewFolio() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	//sel.selectByVisibleText("Gaurav X (price/C102)");
	sel.selectByIndex(1);
	WebElement ele=sel.getFirstSelectedOption();
	String a=ele.getText();
	routedGuestN=a.substring(0, a.indexOf("(")).trim();
	GenericMethods.clickElement(createFolio);
	Thread.sleep(6000);
	}
	catch(Exception e)
	{
		throw e;
	}
}






public void fn_selectGuestIDToNewFolioGrp() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	//sel.selectByVisibleText("Barkha Kapoor (price/C103)");
	sel.selectByIndex(1);
	GenericMethods.clickElement(createFolio);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String folioNum;
public static String PINum;
public void fn_RouteChargesGrp() throws Exception
{
	try
	{
		
		GenericMethods.clickElement(generateFolioBtn);
		Thread.sleep(15000);
		int count=GenericMethods.tr_count(tbl_cnt);
		int count1=count-2;
	    for(int i=count1;i>=2;i-=2)
	    {
	    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
	    	if(data.equals(product))
	    	{
	    		folioNum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a[2]")).getText();
	    		PINum=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
	    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
	    		GenericMethods.js_Click(ele);
	    		break;
	    	}
	    }
	    GenericMethods.clickElement(routeChargesbtn);
	}
	catch(Exception e)
	{
		throw e;
	}

}


public void fn_RouteCharges() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	GenericMethods.js_Click(generateFolioBtn);
	Thread.sleep(25000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	arr.add(data);
    	if(data.equals(CustomCharge))
    	{
    		Assert.assertEquals(data.equals(CustomCharge), true);
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(CustomCharge), true);
    GenericMethods.clickElement(routeChargesbtn);
    Thread.sleep(15000);
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


public void fn_verifyRouteCharges() throws Exception
{
	try
	{
	String text=GenericMethods.getText(routeChargesTitle);
	Assert.assertEquals(text, "Route Charges");
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

public void fn_verifyRCGrpTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(RCGroup);
	Assert.assertEquals(text, "Route Charges");
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

public void fn_selectGuestIdRouteCharge() throws Exception
{
	Select sel=new Select(selGuestId);
	sel.selectByVisibleText("Gaurav X (PI 85)");
	GenericMethods.clickElement(routeBtn);
	Thread.sleep(4000);
}



public void fn_selectGuestIDRouteCharge1() throws Exception
{
	//GenericMethods.clickElement(showAll);
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	for(WebElement li1:li)
	{
		String PI=li1.getText();
		if(PI.contains(afterPI))
		{
			WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option"));
			//GenericMethods.js_Click(ele);
			Actions actobj=new Actions(GenericMethods.driver);
			actobj.click(ele).build().perform();
			break;
		}
	}
	GenericMethods.clickElement(routeBtn);
	Thread.sleep(4000);
}


public void fn_selectGuest2RouteCharge() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	//li.size();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		if(Guest2N.contains("David"))
		{
			li.get(i).click();
		//	WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option["+i+"]"));
			//GenericMethods.js_Click(ele);
//			Actions actobj=new Actions(GenericMethods.driver);
//			actobj.click(ele).build().perform();
			Thread.sleep(3000);
			break;
		}
	}
	GenericMethods.clickElement(routeBtn);
	Thread.sleep(12000);
	}
	catch(Exception e)
	{
		throw e;
	}
}



public void fn_selectGuestIdRouteChargeGrp() throws Exception
{
	GenericMethods.clickElement(showAll);
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	for(WebElement li1:li)
	{
		String PI=li1.getText();
		if(PI.contains(PINum))
		{
			WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option"));
			//GenericMethods.js_Click(ele);
			Actions actobj=new Actions(GenericMethods.driver);
			actobj.click(ele).build().perform();

			break;
		}
	}
	GenericMethods.clickElement(routeBtn);
	Thread.sleep(4000);
}

public static String RouteToPI;
public void fn_selectGuest2RouteChargeGrp() throws Exception
{
	try
	{
	Thread.sleep(3000);
	GenericMethods.clickElement(showAll);
	Thread.sleep(2000);
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		int a=Guest2N.indexOf("(");
		RouteToPI=Guest2N.substring(a+1,Guest2N.indexOf(")"));
		if(Guest2N.contains("Richard"))
		{
			li.get(i).click();
			//WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option"));
			//GenericMethods.js_Click(ele);
			//Actions actobj=new Actions(GenericMethods.driver);
			//actobj.click(ele).build().perform();
            Thread.sleep(3000);
			break;
		}
	}
	GenericMethods.js_Click(routeBtn);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ReservationFolioPage fn_verifyRoutedOtherChrgeG2Grp() throws Exception
{
	try
	{
    int count1=GenericMethods.tr_count(folioCount);
    if(count1>=10)
    {
        GenericMethods.js_Click(moreLink);
        for(int i=4;i<=count1;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
        	if(actual.contains("Richard") && actual.contains(RouteToPI))
        	{
        	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
        	  ele.click();

        	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  //Assert.assertEquals(actual, afterPI);
        	  break;
        	}
        	else
        		if(actual.contains("Group Owner")||actual.contains("Room Type"))
        		{
        			System.out.println("Header row is being displayed");
        		}
        		else

                	if(actual.contains("Richard") && actual.contains(RouteToPI))
                	{
                	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
                	  ele.click();

                	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
                	  //Assert.assertEquals(actual, afterPI);
                	  break;
                	}
        }

    }

    else
    {
    	for(int i=4;i<=count1;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
        	if(actual.contains("Group Owner")||actual.contains("Room Type"))

        	{
        		System.out.println("Header row is being displayed");
        	}

        	else

        	if(actual.contains("Richard"))
        	{
        	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
        	  ele.click();

        	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  //Assert.assertEquals(actual, afterPI);
        	  break;
        	}
        }

    }
      ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
      return RFP;
	}
	catch(Exception e)
	{
		throw e;
	}

}




public void fn_CustomChargetoNewFolio1() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count2=count-2;
    for(int i=count2;i>=2;i-=2)
    {
    	String str=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	arr.add(str);
    	//li.add(ele.getText());
    	if(str.contains(CustomCharge))
    	{
    		Assert.assertEquals(str.contains(CustomCharge), true);
    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele1.click();
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(CustomCharge), true);
    GenericMethods.clickElement(routeToNewFolio);
    Thread.sleep(15000);
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


public static String amt="50.00";
public void fn_clkPayNow() throws Exception
{
	try
	{
    Select sel=new Select(paymentMode);
    sel.selectByValue("cash");
    //Select sel1=new Select(paymentTypes);
    //sel1.selectByValue("");
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), amt).build().perform() ;
	//amt=GenericMethods.getText(amount);
	GenericMethods.js_Click(payNowBtn);
	Thread.sleep(6000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public static String amt1="1.00";
public void fn_clkPayNowGrp() throws Exception
{
	try
	{
    Select sel=new Select(paymentMode);
    sel.selectByValue("cash");
    //Select sel1=new Select(paymentTypes);
    //sel1.selectByValue("");
    Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), amt1).build().perform() ;
	//amt=GenericMethods.getText(amount);
	GenericMethods.js_Click(payNowBtn);
	Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static String num;


public void fn_payNowCheque() throws Exception
{num=GenericMethods.generateRandomnum();

	try
	{
	    Select sel=new Select(paymentMode);
	   // sel.selectByValue("cheque");
	    sel.selectByIndex(2);
	    Thread.sleep(4000);
	    Select sel1=new Select(payTypes);
	    //sel1.selectByVisibleText("Cheque1");
	    sel1.selectByIndex(1);
	    Thread.sleep(4000);
	    Actions acobj= new Actions(GenericMethods.driver);
		acobj.sendKeys(amount, Keys.chord(Keys.CONTROL, "a"), amt1).build().perform() ;
		Thread.sleep(4000);
		GenericMethods.js_Sendkey(chequeNum,num );
        Thread.sleep(3000);
		//amt=GenericMethods.getText(amount);
		GenericMethods.js_Click(payNowBtn);
		Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}

}




public void fn_makeFullPayment() throws Exception
{
	try
	{
		num=GenericMethods.generateRandomnum();
	Select sel=new Select(paymentMode);
    sel.selectByValue("cheque");
    Thread.sleep(4000);
    Select sel1=new Select(payTypes);
    //sel1.selectByVisibleText("Cheque1");
    sel1.selectByIndex(1);
    Thread.sleep(3000);
    GenericMethods.js_Sendkey(chequeNum, num);
    Thread.sleep(3000);
    GenericMethods.js_Click(payNowBtn);
	Thread.sleep(3000);
	}
	catch(Exception e)
	{
		throw e;
	}
}




public void fn_clkSettleFolio() throws Exception
{
   String balance=GenericMethods.getText(totalBal);
   if(balance!="Rs 0.00")
   {
	   fn_makeFullPayment();
	   Thread.sleep(3000);
	   GenericMethods.clickElement(settleFolio);
	   Thread.sleep(3000);
   }

   else
   {


    Thread.sleep(3000);

   }

}




public void fn_clkSettleFolioAccept() throws Exception
{
	try
	{
	String balance=GenericMethods.getText(totalBal);
	   if(balance!="Rs 0.00")
	   {
		   fn_makeFullPayment();
		   Thread.sleep(4000);
		   GenericMethods.clickElement(settleFolio);
		   String str=GenericMethods.ActionOnAlert("Accept");
		   Assert.assertEquals(str, "Do you wish to settle all folios?");
	   }

	   else
	   {

		   GenericMethods.clickElement(settleFolio);
		   String str=GenericMethods.ActionOnAlert("Accept");
		   Assert.assertEquals(str, "Do you wish to settle all folios?");

	   }
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


public void fn_verifyPaidAmt() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str.contains(amt1))
    		{
    		Assert.assertTrue(str.contains(amt1));
//    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele1.click();
            System.out.println("Paid amount has been successfully posted in Account Statement.");
            break;
    		}

    	}
    }
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



public void fn_verifyPaidAmtChequeGrp() throws Exception{
	try{
num=GenericMethods.generateRandomnum();
	JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
	jsx.executeScript("scroll(0, -550)");
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {

    	//Thread.sleep(3000);
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("with Cheque ("+num+")"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str.contains(amt1))
    		{
    		Assert.assertTrue(str.contains(amt1));
//    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele1.click();
            System.out.println("Amount paid by cheque has been successfully posted in Account Statement.");
            break;
    		}

    	}
    }
	}catch(Exception e){
		throw e;
	}

}



public void fn_clkRoutePayment1() throws Exception
{
	try
	{

		String[] a=routedGuestN.split(" ");
		String guestName=a[1]+" "+a[2];
		
		ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(tbl_cnt);
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("Paid by "+guestName+" with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]")).getText();

    		if(str.equalsIgnoreCase(""))
    		{
    			Assert.assertTrue(str.contains(""));
    		   String str2=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])//tbody//tr["+i+"]//td[9]")).getText();
    		   arr.add(str2.split(" ")[1]);
    		   //Assert.assertTrue(str.contains(amt));
    		   if(str2.contains(amt))
    		      {
    	             Assert.assertTrue(str2.contains(amt));
    		         WebElement ele1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])//tbody//tr["+i+"]//td[2]//input"));
    		         ele1.click();
    		         break;
    		      }
    		}
    	}
    }
    Assert.assertEquals(arr.contains(amt), true);

    GenericMethods.clickElement(routePaymentBtn);
    Thread.sleep(10000);
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



public static String str1Value;



public void fn_clkRoutePaymentGrp() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
	//int count1=count-2;
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
        String[] parts=str1.split(" ");
        str1Value=parts[2]+" "+parts[3];
    	if(str1.contains("Paid by "+str1Value+" with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[5]")).getText();
    		if(str.equalsIgnoreCase(""))
    		{
    		Assert.assertTrue(str.contains(""));
    		String str2=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str2.contains(amt1))
    		{
    		WebElement ele1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele1.click();
    		break;
    		}
    	}

    	}
    }

    GenericMethods.clickElement(routePaymentGrp);
    Thread.sleep(15000);
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



public void fn_verifyRoutePaymentTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(routePaymentTitle);
	Assert.assertEquals(text, "Route Payment");
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

public void fn_routePaymentSave() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	sel.selectByVisibleText("Gaurav X (PI 85)");
	GenericMethods.clickElement(routePaymentSave);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_selectGuest2RoutePayment() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	List<WebElement> li=sel.getOptions();
	//li.size();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		if(Guest2N.contains("David"))
		{
			li.get(i).click();
		//	WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option["+i+"]"));
			//GenericMethods.js_Click(ele);
//			Actions actobj=new Actions(GenericMethods.driver);
//			actobj.click(ele).build().perform();
			Thread.sleep(3000);
			break;
		}
	}
	Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(routeAmount, Keys.chord(Keys.CONTROL, "a"), "50.00").build().perform() ;
	GenericMethods.clickElement(routePaymentSave);
	Thread.sleep(4000);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ReservationFolioPage fn_verifyRoutedPaymentChrgeG2() throws Exception
{
	try
	{
	
		ArrayList<String> arr=new ArrayList<String>();
    GenericMethods.js_Click(moreLink);
    int count=GenericMethods.tr_count(folioCount);
    for(int i=4;i<=count;i++)
    {
    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
    	arr.add(actual.split(" ")[1]);
    	if(actual.contains("David"))
    	{
    		Assert.assertEquals(actual.contains("David"), true);
    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
    	  ele.click();

    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
    	  //Assert.assertEquals(actual, afterPI);
    	  break;
    	}
    }
    Assert.assertEquals(arr.contains("David"), true);
	
	/*else
	{
		 int count=GenericMethods.tr_count(folioCount);
		    for(int i=4;i<=count;i++)
		    {
		    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
		    	if(actual.contains("David"))
		    	{
		    		Assert.assertEquals(actual.contains("David"), true);
		    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
		    	  ele.click();

		    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
	}*/
	}
	catch(AssertionError e)
	{
		throw e;
	}
	
	catch(NoSuchElementException e)
	{
		ArrayList<String> arr=new ArrayList<String>(); 				
		int count=GenericMethods.tr_count(folioCount);
	    for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
	    	arr.add(actual);
	    	if(actual.contains("David"))
	    	{
	    		Assert.assertEquals(actual.contains("David"), true);
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
	    	  ele.click();

	    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
	    Assert.assertEquals(arr.contains("David"), true);
	}
	catch(Exception e)
	{
		throw e;
	}
    ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
    return RFP;

}


public void fn_routePaymentGrp() throws Exception
{
	try
	{
	Select sel=new Select(selGuestId);
	//sel.selectByVisibleText("Barkha Kapoor (PI 154)");
	List<WebElement> li=sel.getOptions();
	//li.size();
	for(int i=0;i<=li.size();i++)
	{
		String Guest2N=li.get(i).getText();
		String[] parts=Guest2N.split(" ");
		String a=parts[1]+" "+parts[2];
		if(!a.equals(str1Value))
		{
			li.get(i).click();
		//	WebElement ele=GenericMethods.driver.findElement(By.xpath("//select[@name='selGuestIds']//option["+i+"]"));
			//GenericMethods.js_Click(ele);
//			Actions actobj=new Actions(GenericMethods.driver);
//			actobj.click(ele).build().perform();
			Thread.sleep(3000);
			break;
		}
	}

	String selectedGuest=sel.getFirstSelectedOption().getText();
	GenericMethods.clickElement(routePaymentSave);
	Thread.sleep(10000);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public ReservationFolioPage fn_clkFolio() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(folioCount);
	if(count>10)
	{
		GenericMethods.clickElement(moreLink);
		for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains(afterPI))
	    	{
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    	else
	    		if(actual.contains("Group Owner")||actual.contains("Room Type"))
		    	{
		    		System.out.println("Header row is being displayed");
		    	}
	    		else
	    	    	if(actual.contains(afterPI))
	    	    	{
	    	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]"));
	    	    	  GenericMethods.js_Click(ele);
	    	    	  Thread.sleep(4000);
	    	    	  //Assert.assertEquals(actual, afterPI);
	    	    	  break;
	    	    	}
	    }
	}

	else
	{
		for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains("Group Owner")||actual.contains("Room Type"))
	    	{
	    		System.out.println("Header row is being displayed");
	    	}
	    	else
	    	if(actual.contains(afterPI))
	    	{
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
	}



    ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
    return RFP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public ReservationFolioPage fn_verifyRoutedCustmChrgeG2() throws Exception
{
	try
	{
	ArrayList<String> arr=new ArrayList<String>();
	GenericMethods.js_Click(moreLink);
	/*if(value==true)
	{
    GenericMethods.js_Click(moreLink);
    Thread.sleep(1000);*/
    int count1=GenericMethods.tr_count(folioCount);
    for(int i=4;i<=count1;i++)
    {
    	String actual1=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
    	arr.add(actual1.split(" ")[1]);
    	if(actual1.contains("David"))
    	{
    		Assert.assertEquals(actual1.contains("David"),true);
    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
    	  ele.click();
    	  break;
    	}
    }
    Assert.assertEquals(arr.contains("David"), true);
	
	/*else
	{
		 int count=GenericMethods.tr_count(folioCount);
		    for(int i=4;i<=count;i++)
		    {
		    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
		    	arr.add(actual);
		    	if(actual.contains("David"))
		    	{
		    		Assert.assertEquals(actual.contains("David"), true);
		    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
		    	  ele.click();

		    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
		    Assert.assertEquals(arr.contains("Mr. David R"), true);
	}*/
   
	}
	catch(NoSuchElementException e)
	{	
		ArrayList<String> arr=new ArrayList<String>();

		 int count=GenericMethods.tr_count(folioCount);
		    for(int i=4;i<=count;i++)
		    {
		    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[3]")).getText();
		    	arr.add(actual.split(" ")[1]);
		    	if(actual.contains("David"))
		    	{
		    		Assert.assertEquals(actual.contains("David"), true);
		    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]"));
		    	  ele.click();

		    	  //System.out.println("Charges has been successfully routed to the selected guest ID.");
		    	  //Assert.assertEquals(actual, afterPI);
		    	  break;
		    	}
		    }
		    Assert.assertEquals(arr.contains("David"), true);
	}
	Thread.sleep(6000);
	 ReservationFolioPage RFP=PageFactory.initElements(GenericMethods.driver, ReservationFolioPage.class);
	    return RFP;
}




public void fn_LockFolio() throws Exception
{
	try
	{

		//int size=folioCount.size();
		//String text=folioCount.get(size-1).getText();
		boolean value=moreLink.isDisplayed();
		//if(text.contains("More >>"))
		//{
			
		//}
		ArrayList<String> arr=new ArrayList<String>();
		if(value==true)
		{
		GenericMethods.clickElement(moreLink);
		}
		int count=GenericMethods.tr_count(folioCount);

		Thread.sleep(3000);
		for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	//int j=actual.lastIndexOf("(");
	    	//String a=actual.split(" ")[0]+" "+actual.split(" ")[1];
	    	arr.add(actual.split(" ")[0]);
	    	if(actual.contains(afterPI))
	    	{
	    		Assert.assertTrue(actual.contains(afterPI));
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  String msg=GenericMethods.ActionOnAlert("Accept");
	    	  Assert.assertEquals(msg, "Do you wish to Close this Folio?");
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
		Thread.sleep(2000);
		Assert.assertEquals(arr.contains("PI"), true);

	}
	
	catch(NoSuchElementException e)
	{
		ArrayList<String> arr=new ArrayList<String>();
		int count=GenericMethods.tr_count(folioCount);

		Thread.sleep(3000);
		for(int i=4;i<=count;i++)
	    {
	    	String actual2=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	arr.add(actual2);
	    	if(actual2.contains(afterPI))
	    	{
	    		Assert.assertTrue(actual2.contains(afterPI));
	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
	    	  GenericMethods.js_Click(ele);
	    	  Thread.sleep(4000);
	    	  String msg=GenericMethods.ActionOnAlert("Accept");
	    	  Assert.assertEquals(msg, "Do you wish to Close this Folio?");
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
      Assert.assertEquals(arr.contains(afterPI), true);
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


public void fn_verifyLockFolioPopup() throws Exception
{
	try
	{
		Thread.sleep(3000);;
	String msg=GenericMethods.ActionOnAlert("Accept");
	Assert.assertEquals(msg, "Do you wish to Close this Folio?");
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


public void fn_verifyLockedFolio() throws Exception
{
	try
	{
	//int size=folioCount.size();
	//String text=folioCount.get(size-1).getText();
		boolean b=moreLink.isDisplayed();
	if(b==true)
	{
		GenericMethods.clickElement(moreLink);
	}

	Thread.sleep(3000);
	int count=GenericMethods.tr_count(folioCount);


		for(int i=4;i<=count;i++)
	    {
	    	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]")).getText();
	    	if(actual.contains("INV"))
	    	{
//	    	  WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span"));
//	    	  GenericMethods.js_Click(ele);
              Assert.assertTrue(actual.contains("INV"));
              String lockValue=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[7]//span")).getAttribute("class");
              Assert.assertEquals(lockValue, "unlockfolio-img");
	    	  System.out.println("Settled folio has been successfully locked.");
	    	  //Assert.assertEquals(actual, afterPI);
	    	  break;
	    	}
	    }
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





public void fn_clkRefundBtn() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count2=count-2;
    for(int i=count2;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	arr.add(data);
    	if(data.equals(CustomCharge))
    	{
    		Assert.assertEquals(data.equals(CustomCharge), true);
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(CustomCharge), true);
    GenericMethods.clickElement(refundBtn);
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


public void fn_clkRefundBtnGrp() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	Thread.sleep(15000);
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains(CustomCharge))
    	{
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
    GenericMethods.clickElement(refundBtn);
    Thread.sleep(15000);
	}
	catch(Exception e)
	{
		throw e;
	}
}



public void fn_clkRefund() throws Exception
{
	try
	{
	GenericMethods.clickElement(refund);
	Thread.sleep(5000);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(refund);
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void fn_verifyRefundSingleTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(refundTitle);
	Assert.assertEquals(text, "Refund");
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


public void fn_verifyRefundGrpTitle() throws Exception
{
	try
	{
	String text=GenericMethods.getText(refundTitleGrp);
	Assert.assertEquals(text, "Refund");
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




public void fn_verifyRefund() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	Thread.sleep(1000);
    	String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();    	
    	arr.add(data1.split(" ")[4]);
    	if(data1.contains("Refund for "+CustomCharge))
    	{
    		Assert.assertEquals(data1.contains("Refund for "+CustomCharge), true);
//    		String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele.click();
//    		break;
    		System.out.println("Added custom charge has been successfully refunded.");
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(CustomCharge), true);
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


public void fn_verifyRefundGrp() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains("Refund for "+CustomCharge))
    	{
    		Assert.assertTrue(data.contains("Refund for "+CustomCharge));
//    		String data1=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]"));
//    		ele.click();
//    		break;
    		System.out.println("Added custom charge has been successfully refunded.");
    		break;
    	}
    }
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


public void fn_verifyAddedCustomCharge() throws InterruptedException
{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1 =count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
    	if(data.contains(CustomCharge))
    	{
    		System.out.println("Custom charge has been addedd successfully.");
    		break;
    	}
    }
}


public static String substring1;
public static String substring2;

public void fn_getPreviousFolioNumber()
{
	//int count=GenericMethods.tr_count(chkboxCount);
     int   size1=rowCount.size();
     String text=rowCount.get(size1-2).getText();
     System.out.println(text);
     String answer = text.substring(text.indexOf("(")+1,text.indexOf(")"));
     substring1=answer.substring(7);
     System.out.println(substring1);
}


public void fn_getAfterFolioNumber()
{
	 int   size1=rowCount.size();
     String text=rowCount.get(size1-2).getText();
     System.out.println(text);
     String answer = text.substring(text.indexOf("(")+1,text.indexOf(")"));
     substring2=answer.substring(7);
     System.out.println(substring2);
     Assert.assertTrue(text.contains(product));
     if(substring1!=substring2)
     {
    	 System.out.println("Other charges have been successfully added for "+product);
     }
}

public void fn_addOtherChargeGFolio() throws Exception
{
	try
	{
	GenericMethods.clickElement(otherCharges1);
	Assert.assertEquals(GenericMethods.getText(OtherChargesGrpPopUpTitle), "Other Charges");
	Select sel=new Select(chargeToGrp);
	//sel.selectByVisibleText("fj/784");
	sel.selectByIndex(2);
	Select sel1=new Select(posPoint);
	//sel1.selectByVisibleText("Sample Restaurant");
	sel1.selectByIndex(1);
	Thread.sleep(4000);
	Select sel2=new Select(posProduct);
	//sel2.selectByVisibleText("Sample French Onion Soup");
	sel2.selectByIndex(1);
	product=sel2.getFirstSelectedOption().getText();
	Actions acobj= new Actions(GenericMethods.driver);
	acobj.sendKeys(discount, Keys.chord(Keys.CONTROL, "a"), "2").build().perform() ;
	//GenericMethods.sendKeys(discount, "2");
	GenericMethods.clickElement(saveOtherCharge);
	Thread.sleep(3000);
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


public void fn_clkGenerateFolio() throws Exception
{
	try
	{
	GenericMethods.clickElement(generateFolioBtn);
	}
	catch(NoSuchElementException e)
	{
		Thread.sleep(2000);
		GenericMethods.js_Click(generateFolioBtn);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifyGeneratedFolio() throws Exception
{
	try
	{
	String text=GenericMethods.getText(invoiceText);
	Assert.assertTrue(text.contains("PI"));
	System.out.println("Folio has been generated successfully");
	WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl_fllist']//tr[4]//td[1]//input"));
	ele.click();
	GenericMethods.clickElement(delPIGrp);
	GenericMethods.ActionOnAlert("Accept");
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


public void fn_clkTaxExemptBtn() throws Exception
{
	try
	{
	int coun=GenericMethods.tr_count(tbl_cnt);
	int count1=coun-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]")).getText();
     	if(data.contains(product))
    	{
    		//System.out.println("Other charge has been addedd successfully.");
    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[2]//input"));
    		ele.click();
    		break;
    	}
    }
     GenericMethods.clickElement(TaxExemptbtn);
	}
	catch(Exception e)
	{
		throw e;
	}
}


public void fn_verifyTaxExemptTitle() throws InterruptedException
{
	String text=GenericMethods.getText(TaxExemptTitle);
	Assert.assertTrue(text.contains("Tax Exempt Res ID#"));
}


public void fn_saveTaxExempt() throws Exception
{
    Select sel=new Select(TaxExemptReason);
    //sel.selectByVisibleText("Training");
    sel.selectByIndex(1);
    GenericMethods.clickElement(TECheckbox);
    GenericMethods.clickElement(TEBtn);
}


public void fn_verifyTaxExempted() throws InterruptedException
{
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]")).getText();
     	if(data.contains("Exempted Tax ("+product+")"))
    	{
    		//System.out.println("Other charge has been addedd successfully.");
    		System.out.println("Tax has been successfully exempted.");
    		break;
    	}
    }
}

public static String afterPI;
public void fn_getPINum() throws Exception
{
	try
	{
		Thread.sleep(3000);
		ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	arr.add(data);
    	if(data.equals(product))
    	{
    		Assert.assertEquals(data.contains(product), true);
    		afterPI=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
//    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+count1+"]//td[2]//input"));
//    		GenericMethods.js_Click(ele);
    		break;
    	}
    }
    
    Assert.assertEquals(arr.contains(product), true);
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


public void fn_getPICustomCharge() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
	int count=GenericMethods.tr_count(tbl_cnt);
	int count1=count-2;
    for(int i=count1;i>=2;i-=2)
    {
    	String data=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[4]//a")).getText();
    	arr.add(data);
    	if(data.equals(CustomCharge))
    	{
    		Assert.assertEquals(data.equals(CustomCharge), true);
    		afterPI=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
//    		WebElement ele=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+count1+"]//td[2]//input"));
//    		GenericMethods.js_Click(ele);
    		break;
    	}
    }
    Assert.assertEquals(arr.contains(CustomCharge), true);
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


public static int firstNum;
public void fn_getPINum1()
{
   String[] num=afterPI.split(" ");
   firstNum = Integer.valueOf(num[1]);
   System.out.println(firstNum);

}



public void fn_afterRoutePaymentPI() throws Exception
{
	try
	{
	int count=GenericMethods.tr_count(chkboxCount);
    for(int i=2;i<=count;i+=2)
    {
    	String str1=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[4]")).getText();
    	//li.add(str1);
    	if(str1.contains("Paid by "+str1Value+" with Cash"))
    	{
    		String str=GenericMethods.driver.findElement(By.xpath("(//table[@class='frn_paytbl'])[2]//tbody//tr["+i+"]//td[9]")).getText();
    		if(str.contains(amt1))
    		{
    		Assert.assertTrue(str.contains(amt1));
    		afterPI=GenericMethods.driver.findElement(By.xpath("//table[@class='frn_paytbl']//tbody//tr["+i+"]//td[5]//a")).getText();
    		//ele1.click();
    		break;
    		}
    	}
    }
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



public void fn_verifyRoutedFolio() throws Exception
{
	try
	{
		ArrayList<String> arr=new ArrayList<String>();
    int count=GenericMethods.tr_count(folioCount);
    if(count>10)
    {
    	GenericMethods.clickElement(moreLink);
    	for(int i=4;i<=count;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]/a")).getText();
        	arr.add(actual);
        	if(actual.equals(afterPI))
        	{
        		Assert.assertEquals(actual, afterPI);
        	  System.out.println("Charges has been successfully routed to the selected guest ID.");       	  
        	  break;
        	}
        }
    	Assert.assertEquals(arr.contains(afterPI), true);
    }

    else
    {
    	for(int i=4;i<=count;i++)
        {
        	String actual=GenericMethods.driver.findElement(By.xpath("//table[@class='dont-print-me-hidden']//table//tr["+i+"]//td[2]/a")).getText();
        	arr.add(actual);
        	if(actual.equals(afterPI))
        	{
          	  Assert.assertEquals(actual, afterPI);
        	  System.out.println("Charges has been successfully routed to the selected guest ID.");
        	  break;
        	}
        }
    	Assert.assertEquals(arr.contains(afterPI), true);
    }
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


public void fn_verifySettleFolioMsg() throws Exception
{
   //GenericMethods.clickElement(settleFolio);
   String text=GenericMethods.ActionOnAlert("Dismiss");
   Assert.assertEquals(text, "Do you wish to settle all folios?");

}


public void fn_ValidatePayAmount()
{

  	 try
  	 {
  		Select sel=new Select(paymentMode);
  	   	sel.selectByVisibleText("Cash");

  	    Select sel1=new Select(payTypes);
	   	sel1.selectByVisibleText("Cash");

	   	GenericMethods.sendKeys(amount, "1");
        GenericMethods.clickElement(payNowBtn);
  	 }
  	 catch(Exception e)
  	 {
  		// throw e;
  		 String str=e.getMessage();
  		 System.out.println(str);
  	 }

    }

public void fn_ValidateGenerateFolio_BT() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(generateFolioBtn);
  		GenericMethods.clickElement(CheckOut_BT);
  		GenericMethods.ActionOnAlert("Dismiss");
  		System.out.println(GenericMethods.value);
  		GenericMethods.ActionOnAlert("Dismiss");
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ValidateLockFolio_IMG() throws Exception
{

  	 try
  	 {
  		GenericMethods.clickElement(LockFolio_IMG);
  		//GenericMethods.ActionOnAlert("Dismiss");
  		String str=GenericMethods.Alert_Dismiss();
  		Assert.assertEquals(str, "Do you wish to Close this Folio?");
  		//System.out.println(GenericMethods.value);
  	 }
  	 catch(Exception e)
  	 {
  		 throw e;
  	 }

}


public void fn_ValidatePayAmountByCheque()
{

    try{
          Select sel=new Select(paymentMode);
          sel.selectByVisibleText("Cheque");

          Select sel1=new Select(payTypes);
          sel1.selectByVisibleText("Cheque");

          ChequeNum=GenericMethods.generateRandomString();

          GenericMethods.sendKeys(chequeNum, ChequeNum);
          GenericMethods.sendKeys(amount, "1");
          GenericMethods.clickElement(payNowBtn);
    }
    catch(Exception e)
    {
       // throw e;
          String str=e.getMessage();
          System.out.println(str);
    }

 }

public void fn_ValidatePaidAMTby_Checqe() throws Exception{
try{

    int count=Discription_COUNT.size();
    for(int i=3; i<=count-1; i+=2){
        String str=GenericMethods.driver.findElement(By.xpath("(//td[@class='front_tbl_lft'])[2]//tr["+i+"]//td[4]")).getText();

        if(str.contains(ChequeNum)){
            String sr=GenericMethods.driver.findElement(By.xpath("(//td[@class='front_tbl_lft'])[2]//tr["+i+"]//td[9]")).getText();
            System.out.println(sr);
            Assert.assertTrue(sr.contains("1"));
            break;
        }
    }


}catch(Exception e){
    throw e;
}
}



public void fn_ClickSettleFolio_BT(String Alertcommand) throws Exception
{
    GenericMethods.clickElement(settleFolio);
    //GenericMethods.ActionOnAlert(Alertcommand);
    String str=GenericMethods.Alert_Dismiss();
    Assert.assertEquals(str, "Do you wish to settle all folios?");
}


public void fn_ClickSettleFolio_Dismiss() throws Exception
{
    GenericMethods.clickElement(settleFolio);
    //GenericMethods.ActionOnAlert(Alertcommand);
    String str=GenericMethods.Alert_Dismiss();
    Assert.assertEquals(str, "Do you wish to settle all folios?");
}


public void fn_ClickSettleFolio_Accept() throws Exception
{
	try
	{
    GenericMethods.clickElement(settleFolio);
    //GenericMethods.ActionOnAlert(Alertcommand);
    String str=GenericMethods.Alert_Accept();
    Assert.assertEquals(str, "Do you wish to settle all folios?");
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

public void scroll_windowDown()
{
	JavascriptExecutor jse = (JavascriptExecutor)GenericMethods.driver;
	jse.executeScript("window.scrollBy(0,250)", "");
}

public void windowScrollUp() throws Exception
{
	try
	{
	JavascriptExecutor jsx = (JavascriptExecutor)GenericMethods.driver;
	jsx.executeScript("scroll(0, -550)");
	}
	catch(Exception e)
	{
		throw e;
	}
}

public void  VerifyRoomRateAndTax(String str) throws Exception{
	try{
		int size=Text_AccountRecords.size();
		for(int i=2;i<=size-2;i=i+2){
			String text=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/a")).getText();
			if(text.startsWith(str)){
				postedRoomPrice=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[7]")).getText();
				Thread.sleep(2000);
				System.out.println("postedRoomPrice::"+postedRoomPrice);
				postedRoomTax=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[8]")).getText();
				System.out.println("postedRoomTax::"+postedRoomTax);
				break;

			}

		}

	}
	catch(Exception e){
		throw e;
	}
}

public void  VerifyRoomRateAndTaxForAllPostings(String str) throws Exception{
	try{
		postedRoomPriceList=new HashMap<Integer,String>();
		postedRoomTaxList=new HashMap<Integer,String>();
		int size=Text_AccountRecords.size();
		int x=0;
		
		for(int i=2;i<=size-2;i=i+2){
	
		x++;
			String text=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[4]/a")).getText();
			if(text.startsWith(str)){
			postedRoomPrice=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[7]")).getText();
				Thread.sleep(2000);
				postedRoomPriceList.put(x, postedRoomPrice);
				System.out.println("postedRoomPrice::"+postedRoomPrice);
				postedRoomTax=GenericMethods.driver.findElement(By.xpath("//form/div/table/tbody/tr/td/table[3]/tbody/tr[3]/td/table/tbody/tr["+i+"]/td[8]")).getText();
				
				postedRoomTaxList.put(x, postedRoomTax);
				System.out.println("postedRoomTax::"+postedRoomTax);
				//break;

			}

		}

	}
	catch(Exception e){
		throw e;
	}
}




}



