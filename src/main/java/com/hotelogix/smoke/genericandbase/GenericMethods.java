package com.hotelogix.smoke.genericandbase;







import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverLogLevel;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.hotelogix.smoke.admin.WebTravelAgent.TravleAgent_LoginPage;
import com.hotelogix.smoke.login.AdminLoginPage;
import com.hotelogix.smoke.login.EmailAccountLoginPage;
import com.hotelogix.smoke.login.WebGuestConsoleLoginPage;


//import autoitx4java.AutoItX;
//
//import com.hms.hotelogix.automationframework.pages.GenericMethods.ExcelUtil;
//import com.hms.hotelogix.automationframework.pages.GenericMethods.GenericClass;
//import com.hms.hotelogix.automationframework.pages.admin.LoginPage.AdminLogin;

public class GenericMethods {



	public static Set<String> handles4;
	public static String Parent;
	public static String Child;
	public static int size;
	private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private static final int RANDOM_STRING_LENGTH =5;
    public static WebDriver driver;

    //private static final String CHAR_LIST ="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    //private static final int RANDOM_STRING_LENGTH = 8;

    private static final String Num_LIST ="0123456789";
    private static final int RANDOM_NUM_LENGTH = 4;


    //public static HomePageclass home;

    public static String Currenthandle4;


  //Random Number generator within a range.

    static int min=1;
    static int max=1000;
    
    public static  float tamt;

    public static int randomNumber()
    {
   	 Random rand = new Random();
   	 int randomNum = rand.nextInt((max-min)+1)+min;
   	 return randomNum;
    }
    
    public static void setClipboardData(String string) throws InterruptedException {
		//Copying the path of the file to the clipboard
	      //StringSelection class used for copy and paste operations.
    	Thread.sleep(5000);
	      StringSelection stringselect = new StringSelection(string);//Putting the path of the image to upload
	      Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselect, null);
		}

    public static void uploadImage(String imagelocation) throws Exception{
        try{
        	Thread.sleep(5000);
            //Setting clipboard with image location
      	  setClipboardData(imagelocation);
          //Some sleep time to detect the window popup
            Thread.sleep(1000);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot =  new Robot();
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            Thread.sleep(2000);
          //To Click on the "Open" button to upload files
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(500);
        } catch (Exception exp) {
            throw exp;
        }
    }
    public static boolean isEnable(String text ,WebElement element) throws InterruptedException{

    	Thread.sleep(5000);
        boolean result =element.isEnabled();
        //System.out.println(result);
        if(result == true){
        System.out.println(text + "Element is Enable");
        }
        else{
            System.out.println(text + "Element is Disabled");
        }
        return result;
    }


    public static String Alert_Accept() throws InterruptedException
    {
    	Thread.sleep(5000);
    	Alert alert = driver.switchTo().alert();
    	String str = alert.getText();
    	alert.accept();
    	return str;
    }

    public static String Alert_Dismiss() throws InterruptedException
    {
    	Thread.sleep(5000);
    	Alert alert = driver.switchTo().alert();
    	String str = alert.getText();
    	alert.dismiss();
    	return str;


    }

    
    
    public static void fn_switchTab() throws Exception{
    	try{  
    /*	ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
    	    int count=tabs2.size();
    	    driver.switchTo().window(tabs2.get(0));
    	   // driver.close();
    	    //driver.switchTo().window(tabs2.get(0));
    	    */
//    		Actions action= new Actions(GenericMethods.driver);
//			action.sendKeys(Keys.TAB).release().build().perform();
    		//GenericMethods.driver.close();
    		Thread.sleep(3000);
    		System.out.println("Switching Tabs");
    		GenericMethods.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w");
    		GenericMethods.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
    		
    		//GenericMethods.driver.switchTo().window(nameOrHandle)
    		GenericMethods.driver.switchTo().defaultContent();
			//return driver;
    	}catch(Exception e){
    		throw e;
    	}
    }
    

    public static WebDriver fn_defaultcontentofiframe() throws InterruptedException
    {Thread.sleep(5000);
    	driver.switchTo().defaultContent();
    	return driver;
    }

    public static WebDriver fn_switchiframe(WebElement frameval) throws InterruptedException
    {Thread.sleep(5000);
    	//driver.switchTo().frame("xd_frame");
    			driver.switchTo().frame(frameval);
    			//WebElement frm_WE=driver.findElement(By.xpath("//div[@id='login-form']/iframe"));
    			//driver.switchTo().frame(frm_WE);
    			//driver.findElement(By.id("Username")).sendKeys("a@b.com");


    		//	driver.switchTo().defaultContent();

    			return driver;
    }

    public static  boolean isAlertPresent() throws InterruptedException
    {Thread.sleep(5000);
        try
        {
            GenericMethods. driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException Ex)
        {
            return false;
        }
    }

    public static void selectElementByIndex(WebElement element, int index ) throws InterruptedException
    {//Thread.sleep(5000);

        Select gender = new Select(element);
        gender.selectByIndex(index);
        //gender.selectByIndex(index);
    }


    public static WebElement ExplicitWait(WebElement ele, String xp) throws InterruptedException
    {
    	Thread.sleep(5000);
   WebElement elem = (new WebDriverWait(GenericMethods.driver, 25000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xp)));
    ele=elem;
    return ele;
    }


    public static String GetTitle() throws InterruptedException
    {Thread.sleep(5000);
    	String str=GenericMethods.driver.getTitle();
    	System.out.println(str);
		return str;
    }

   

    public static void mouseOverElement( WebElement element) throws InterruptedException {
    	
    	try{
    	/*Thread.sleep(3000);
        Actions builder = new Actions(driver);
        
        builder.moveToElement(new WebDriverWait(driver,20).until(ExpectedConditions.elementToBeClickable(element))).build().perform();
*/
       // clickElement(element);
    		Thread.sleep(3000);
    		//fn_hold(element);
            Actions builder = new Actions(driver);
            
            builder.moveToElement(new WebDriverWait(driver,20).until(ExpectedConditions.visibilityOf(element))).build().perform();

    	}
    	catch(Exception e){
    		/*Thread.sleep(2000);
    		fn_hold(element);
    		Actions builder = new Actions(driver);

    	    builder.moveToElement(element).build().perform();*/
    		e.printStackTrace();

    	}
        }
    //

    public static String getText(WebElement element) throws InterruptedException {
    	Thread.sleep(1000);
        return element.getText().trim();
     }

   


    public static void switchToWindowHandle( String title) throws Exception {
    	Thread.sleep(5000);

    	try{
        	Set<String> setHndlValColls=driver.getWindowHandles();
            Iterator<String>  itHandleColls= setHndlValColls.iterator();
            while(itHandleColls.hasNext()==true){
            	Thread.sleep(5000);
                String hndlval=itHandleColls.next();
                driver.switchTo().window(hndlval);
                String titl=driver.getTitle();
                if(titl.contains(title)){
                   break;
                }
                }
        	}catch(Exception e){
        		throw e;
        	}

    }
    
    
  



    public static void selectbyNo(WebElement element, int a ) throws InterruptedException
    {
    	Thread.sleep(1000);
        Select gender = new Select(element);
        gender.selectByIndex(a);


    }



    public static void switchToWindowHandleByURL( String url) throws InterruptedException {

    	Thread.sleep(1000);
        Set<String> handler = driver.getWindowHandles();
        for (String handlesname : handler) {


            driver.switchTo().window(handlesname);
            String var = driver.getCurrentUrl();
            if (var.contains(url))
            {
                break;
            } else {
                driver.switchTo().defaultContent();
            }
        }

    }




    public static AdminLoginPage fn_OpenAdmin(String BrowserType, String URL) throws Exception
    {Thread.sleep(1000);
        try{
        	
        	Thread.sleep(3000);
    	fn_LaunchBrowser(BrowserType);
        }catch(Exception e){
        	Thread.sleep(2000);
        	fn_LaunchBrowser(BrowserType);
        	System.out.println("We are in catch block of fn_LaunchBrowser");
        }

    	driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);
       try{
        driver.get(URL);
       }catch(Exception e){
    	   Thread.sleep(2000);
    	   driver.get(URL);
   		GenericMethods.driver.navigate().refresh();

    	   System.out.println("We are in catch block of Launching URL");
       }
        AdminLoginPage ALO = PageFactory.initElements(GenericMethods.driver, AdminLoginPage.class);
        return ALO;
    }
//


public static com.hotelogix.smoke.login.FrontdeskLoginPage fn_OpenFrontdesk(String BrowserType, String URL) throws Exception{
	Thread.sleep(1000);
	try{
    	fn_LaunchBrowser(BrowserType);
        }catch(Exception e){
        	Thread.sleep(2000);
        	fn_LaunchBrowser(BrowserType);
        	System.out.println("We are in catch block of fn_LaunchBrowser");
        }


	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);

	try{
	driver.get(URL);
	}catch(Exception e){
		   Thread.sleep(2000);
    	   driver.get(URL);
   		GenericMethods.driver.navigate().refresh();

	}

	com.hotelogix.smoke.login.FrontdeskLoginPage FLO = PageFactory.initElements(GenericMethods.driver, com.hotelogix.smoke.login.FrontdeskLoginPage.class);
        return FLO;

    }


    public static void sendKeys( WebElement element,String sValue) throws Exception 
    {//Thread.sleep(1000);
      try{
	       if(element.isDisplayed() && element.isEnabled()==true)
	         {
		         element.clear();
		         element.sendKeys(sValue);
	         }
         }
      catch (WebDriverException e) {
    	  js_Sendkey(element,sValue);
		} 
      catch(Exception e)
      {
    	  throw e;
      }
    }
    public static void js_Sendkey(WebElement element, String id) throws InterruptedException
    {
    	Thread.sleep(3000);
   	    JavascriptExecutor executor = (JavascriptExecutor)driver;
   	    executor.executeScript("arguments[0].value='"+id+"';", element);
   	}
//
//public static void input( WebElement element,String FieldName) {
//
////        try {
//        //    logger.info("Waiting for an element to be clickable " + element);
//            //highlightElementBorder(element);
////            WebDriverWait wait = new WebDriverWait(driver,
////                    Integer.parseInt(getConfigValues("timeOutInSeconds")));
//        //    ele = wait.until(ExpectedConditions.elementToBeClickable(element));
//           String sValue=ExcelUtil.TestCaseData.get(FieldName);
//            element.sendKeys(sValue);
//            //logger.info("Waited and send value to on element " + element);
////        } catch (Exception e) {
////            logger.info("Exception while supplying text to element"
////                    + e.getMessage());
////        }
//    }

    public static String getURL() throws InterruptedException
    {Thread.sleep(1000);
        String url=driver.getCurrentUrl();
        return url;
    }

    public static WebDriver fn_LaunchBrowser(String BrowserType) throws Exception {
    	Thread.sleep(1000);
    	WebDriver Driver_Object = null;
          if (BrowserType.equalsIgnoreCase("FF")
                  || BrowserType.equalsIgnoreCase("Firefox")) {
        	  System.out.println("Found firefox and launching....");
        	 System.setProperty("webdriver.gecko.driver","D:\\grv final\\hmsQaAutomation\\Smoak\\Resources\\Drivers\\geckodriver.exe");
             
        	 DesiredCapabilities capabilities=DesiredCapabilities.firefox();
             capabilities.setCapability("marionette", true);
              FirefoxProfile profile = new FirefoxProfile();
              profile.setPreference("browser.link.open_newwindow.restriction", 1);
              profile.setPreference("browser.link.open_newwindow", 2);
              capabilities.setCapability(FirefoxDriver.PROFILE, profile);
              Driver_Object= new FirefoxDriver(capabilities);
              Driver_Object.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        	/* DesiredCapabilities capabilities=DesiredCapabilities.firefox();
              capabilities.setCapability("marionette", true);
               FirefoxProfile profile = new FirefoxProfile();
               profile.setPreference("browser.link.open_newwindow.restriction", 1);
               profile.setPreference("browser.link.open_newwindow", 2);
               capabilities.setCapability(FirefoxDriver.PROFILE, profile);*/
        	  System.out.println("launching firefox");
        	  Thread.sleep(5000);
             //  Driver_Object= new FirefoxDriver();
               Thread.sleep(5000);
                       	          	  
        	//  ProfilesIni allProfiles = new ProfilesIni();
            //   FirefoxProfile myProfile = allProfiles.getProfile("default");
               //myProfile.setAcceptUntrustedCertificates(true);
              // myProfile.setAssumeUntrustedCertificateIssuer(true);*/
            //   Driver_Object = new FirefoxDriver(profile);

          } else if (BrowserType.equalsIgnoreCase("Safari")) {
              Driver_Object = new SafariDriver();
          } else if (BrowserType.equalsIgnoreCase("chrome")|| BrowserType.equalsIgnoreCase("Chrome")) {
        	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\qa\\Desktop\\SmokeTC\\Smoak\\Smoak\\Smoak\\Resources\\Drivers\\chromedriver.exe");
        	  DesiredCapabilities capabilities = DesiredCapabilities.chrome();
              ChromeOptions options = new ChromeOptions();
              options.addArguments("chrome.switches","--disable-extensions");
              options.addArguments("--test-type");
              LoggingPreferences loggingprefs = new LoggingPreferences();
              loggingprefs.enable(LogType.BROWSER, Level.ALL);
              capabilities.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
              capabilities.setCapability("chrome.binary", ".\\Resources\\Drivers\\chromedriver.exe");
              capabilities.setCapability("chrome.switches", Arrays.asList("--incognito"));
              capabilities.setCapability(ChromeOptions.CAPABILITY, options);
              Driver_Object = new ChromeDriver(capabilities);
          } else if (BrowserType.equalsIgnoreCase("IE")|| BrowserType.equalsIgnoreCase("InternetExplorer")) {
              System.setProperty("webdriver.ie.driver",".\\Resources\\Drivers\\IEDriverServer.exe");
              InternetExplorerDriverService.Builder service = new InternetExplorerDriverService.Builder();
              service = service.withLogLevel(InternetExplorerDriverLogLevel.TRACE);
              service = service.withLogFile(new File("d:\\logs\\selenium.log"));
              //    DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
              //    ieCapabilities.setCapability("requireWindowFocus", true);
              //.setCapability("ie.ensureCleanSession", true);
              //ieCapabilities.setCapability("nativeEvents", false);
              //            ieCapabilities.setCapability(CapabilityType.BROWSER_NAME,"Internet Explorer");
              //            ieCapabilities.setCapability(CapabilityType.VERSION, "8");
              //        ieCapabilities.setCapability("ie.forceCreateProcessApi", true);
              //            ieCapabilities.setCapability("ie.browserCommandLineSwitches","-private");

              // ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,
              // true);
              Driver_Object = new InternetExplorerDriver(service.build());
              // Driver_Object = new InternetExplorerDriver();
          } else if (BrowserType.equalsIgnoreCase("remote")) {
              DesiredCapabilities cap = new DesiredCapabilities();
              cap.setBrowserName("chrome");
              Driver_Object = new RemoteWebDriver(new URL(
                      "http://localhost:4446/wd/hub"), cap);
          }
          // DO NOT DELETE IT
          /*
           * else if(BrowserType.equalsIgnoreCase("bmp")){ ProjectSnappyProxy
           * objProjectSnappyProxy = ProjectSnappyProxy.getInstance();
           * System.setProperty("webdriver.chrome.driver",
           * ".\\Resources\\chromedriver.exe"); Driver_Object=new
           * ChromeDriver(objProjectSnappyProxy.getProxyDesiredCapabilties(4567));
           *
           * }
           */
//          else {
  //
//              logger.info("Provided Browser Type is invalid, please check");
//          }
          	
         // Driver_Object.manage().window().maximize();
          Driver_Object.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
          driver=Driver_Object;
          return Driver_Object;
    }

    
    
    
    public static WebElement fn_hold(WebElement ele) throws InterruptedException{
    	Thread.sleep(1000);
    	for(int i=1;i<=60;i++){
    		Thread.sleep(1000);
    		if(ele.isDisplayed()&& ele.isEnabled()==true){
    	    
    			break;
    		}
    	}
    	return ele;
    }
    
    
    
    

    public static void clickElement( WebElement element) throws Exception
    {try{
    	Thread.sleep(1000);
             element.click();
    }
    catch(Exception e){
    	Thread.sleep(7000);
    	 // element.click();
    	js_Click(element);
    }
    }


    public static void js_Click(WebElement element) throws InterruptedException{
    	try{
    	Thread.sleep(1000);
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    	}catch(Exception e){
    		Thread.sleep(4000);
    		  JavascriptExecutor executor = (JavascriptExecutor)driver;
    	        executor.executeScript("arguments[0].click();", element);
    	}
    }





    public static boolean checkElementDisplay( WebElement element) throws Exception
    {Thread.sleep(5000);
        boolean status = element.isDisplayed();
    if(status==true){
        System.out.println("Element is displaying");

    }else{
        System.out.println("Element not displayed");
    }


    Assert.assertTrue(status, "Validating Elements visibility");
    return status;

    }


    public static void selectElement(WebElement element, String a ) throws InterruptedException
    {try{
    	Thread.sleep(1000);
        Select gender = new Select(element);
        gender.selectByVisibleText(a);
    }catch(Exception e){
    	Thread.sleep(5000);
        Select gender = new Select(element);
        gender.selectByVisibleText(a);
    }
    }



    public static String jvmBitVersion() throws InterruptedException{
    	Thread.sleep(1000);
         return System.getProperty("sun.arch.data.model");
        }

        public static void autoit(String fileToUpload, String DialogTitle) throws InterruptedException {
        	Thread.sleep(5000);
        	String jacobDllVersionToUse;
            if (jvmBitVersion().contains("32")){
            jacobDllVersionToUse = "jacob-1.18-M2-x86.dll";
            }
            else {
            jacobDllVersionToUse = "jacob-1.18-M2-x64.dll";
            }
            File file = new File("Lib", jacobDllVersionToUse);
//            System.out.println(LibraryLoader.JACOB_DLL_PATH+"|||||||||"+file.getAbsolutePath());
//            System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
//            Runtime.getRuntime().loadLibrary(LibraryLoader.JACOB_DLL_PATH);
//            Runtime.getRuntime().loadLibrary(file.getAbsolutePath());
//        //    AutoItX x = new AutoItX();
//            x.winActivate(DialogTitle);
//            x.winWaitActive(DialogTitle);
//            x.ControlSetText(DialogTitle, "", "Edit1",fileToUpload) ;
//            Thread.sleep(1000);
//            x.controlClick(DialogTitle, "", "Button1") ;
//            Thread.sleep(1000);
    }

      public static int CheckBox_Count(List<WebElement> element) throws InterruptedException
     {Thread.sleep(1000);
          List<WebElement> checkBoxes = element;
                  //driver.findElements(By.xpath("//input[@type='Checkbox']"));
          for(int i=0; i<checkBoxes.size(); i=i+1){
              checkBoxes.get(i).click();
          }
          int checkedCount=0, uncheckedCount=0;
          for(int i=0; i<checkBoxes.size(); i++){
              System.out.println(i+" checkbox is selected "+checkBoxes.get(i).isSelected());
              if(checkBoxes.get(i).isSelected()){
                  checkedCount++;
              }else{
                  uncheckedCount++;
              }
          }
      
          checkedCount=checkedCount-1;
          return uncheckedCount;
     }


      public static int tr_count(List<WebElement> columnelements) throws InterruptedException
      {
    	  Thread.sleep(7000);
      int Total_tr=columnelements.size();
      System.out.println(Total_tr);
      return Total_tr;


      }



public static String generateRandomString() throws InterruptedException{
	//Thread.sleep(1000);
	        StringBuffer randStr = new StringBuffer();
	        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
	            int number = getRandomNumber();
	            char ch = CHAR_LIST.charAt(number);
	            randStr.append(ch);
	        }
	        return randStr.toString();
	    }

private static int getRandomNumber() throws InterruptedException {
	//Thread.sleep(1000);
	        int randomInt = 0;
	        Random randomGenerator = new Random();
	        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
	        if (randomInt - 1 == -1) {
	            return randomInt;
	        } else {
	            return randomInt - 1;
	        }
	    }




public static String GetCurrentWindowID() throws InterruptedException{

	Thread.sleep(1000);
         Currenthandle4 = driver.getWindowHandle();
//
            System.out.println("parent window id:"+Currenthandle4);

            return Currenthandle4;
  }

public  static void  windowHandle(String ParentID) throws InterruptedException{
	Thread.sleep(2000);
           Set<String> handles4= driver.getWindowHandles();
             handles4.remove(ParentID);
             driver.switchTo().window(handles4.iterator().next());
             Thread.sleep(2000);

}



//.................. Handle the Child Window..................//
public  static String  windowHandle_admin(String ParentID) throws InterruptedException
{
	Thread.sleep(1000);

       Set<String> handles4= driver.getWindowHandles();


        handles4.remove(ParentID);

//driver.switchTo().window(handles4.iterator().next());
//
//             Thread.sleep(2000);

        Iterator<String> it =handles4.iterator();
        String Child=it.next();

        driver.switchTo().window(Child);

// driver.switchTo().window(handles4.iterator().next());
       Thread.sleep(2000);

return Child;

}


public static void Switch_Parent_Window(String ParentID) throws InterruptedException{
	Thread.sleep(1000);
   driver.switchTo().window(ParentID);
   System.out.println("Yoo Back to Parent Window...");
   }


public static void Switch_Parent_Window1(String ParentID,String Child) throws InterruptedException{
	Thread.sleep(5000);
	  handles4.remove(Child);
driver.switchTo().window(ParentID);
System.out.println("Yoo Back to Parent Window...");
}


public static String value;
public static String ActionOnAlert(String Action){
	  try{
		  Thread.sleep(1000);
		   WebDriverWait wait = new WebDriverWait(driver, 2);
		   Alert alert = wait.until(ExpectedConditions.alertIsPresent());

		   value=alert.getText();
		  // System.out.println(value);
		 //  GenericClass.driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
		   if(Action.equalsIgnoreCase("Accept")){
		   alert.accept();
		   System.out.println("Accepted the alert successfully.");
		   }
		   else if(Action.equalsIgnoreCase("Dismiss")){
		   alert.dismiss();
		   System.out.println("Alert is successfully Dismissed.");
		   }
		   else if(Action.equalsIgnoreCase("")){
			   System.out.println("No Action performed");
		   }
		}catch(Throwable e){
		   System.err.println("Error came while waiting for the alert popup. "+e.getMessage());
		}

	  return value;
	  }

public static  EmailAccountLoginPage fn_OpenEmailBox(String BrowserType, String URL) throws Exception{
	Thread.sleep(1000);
	try
	{
	//fn_LaunchBrowser(BrowserType);
		//GenericMethods.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"'t'");
		JavascriptExecutor js = (JavascriptExecutor) driver;  

		js.executeScript("window.open('about:blank','_blank');");
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
    driver.get(URL);
	}
	catch(Exception e)
	{
		throw e;
	}

	EmailAccountLoginPage  EALP=PageFactory.initElements(GenericMethods.driver, EmailAccountLoginPage.class);
    return EALP;
}

public static WebGuestConsoleLoginPage fn_OpenWebGuestConsolePage(String BrowserType, String URL) throws Exception{
	Thread.sleep(1000);
	fn_LaunchBrowser(BrowserType);
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
    driver.get(URL);
    WebGuestConsoleLoginPage WCLP=PageFactory.initElements(GenericMethods.driver,WebGuestConsoleLoginPage.class);
    return WCLP;
}


public static TravleAgent_LoginPage fn_OpenTAGuestConsolePage(String BrowserType, String URL) throws Exception{
	Thread.sleep(1000);
	try
	{
		
		
	//fn_LaunchBrowser(BrowserType);
	//	GenericMethods.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.open('"+URL+"', '_blank');");
	driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.SECONDS);
  //  driver.get(URL);
    TravleAgent_LoginPage WCLP=PageFactory.initElements(GenericMethods.driver,TravleAgent_LoginPage.class);
    return WCLP;
	}
	catch(Exception e)
	{
		throw e;
	}
}

public static String generateRandomnum() throws InterruptedException{
	Thread.sleep(1000);
    StringBuffer randStr = new StringBuffer();
    for(int i=0; i<RANDOM_NUM_LENGTH; i++){
        int number = getRandomNumbe();
        char ch = Num_LIST.charAt(number);
        randStr.append(ch);
    }
    return randStr.toString();
}

private static int getRandomNumbe() throws InterruptedException {
	Thread.sleep(1000);
	int randomInt = 0;
    Random randomGenerator = new Random();
    randomInt = randomGenerator.nextInt(Num_LIST.length());
    if (randomInt - 1 == -1) {
        return randomInt;
    } else {
        return randomInt - 1;
    }
}


public static void getscreenshot(String name) throws Exception
{
	try
	{
		Thread.sleep(1000);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
     //The below method will save the screen shot in d drive with name "screenshot.png"
        String	s1=LocalDate.now().toString();
		System.out.println(s1);
		//FileHandler.copy(scrFile, new File("./Report/"+"Admin "+s1+"/Screenshot/"+name+".jpg"));
		getPageSource(name,s1);
	
      FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")+"\\Snapshot\\"+name+"."+"jpg"));
	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Taking screenshot failed");
	}
	}


public static void getPageSource(String fileName,String s1) throws IOException
{
String source=	driver.getPageSource();
FileUtils.write(new File("./Report/"+"Admin "+s1+"/Screenshot/"+fileName+".html"), source);
}


public  static String GetTimeStampValue()throws IOException, InterruptedException
{Thread.sleep(1000);
    Calendar cal = Calendar.getInstance();
    Date time=cal.getTime();
    String timestamp=time.toString();
    System.out.println(timestamp);
    String systime=timestamp.replace(":", "-");
    System.out.println(systime);
    return systime;
}


public static void fn_switchTabwithindex(int index) throws Exception{
	try{
/*	Set<String> tabID=driver.getWindowHandles();	
	ArrayList<String> arr=new ArrayList(tabID);
	int count=arr.size();
	driver.switchTo().window(arr.get(index));
	
*/
		/*driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL.SHIFT.TAB);
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL.SHIFT.TAB);*/
		Actions action= new Actions(driver);
		for(int i=0;i<=index;i++)
		{
			System.out.println("Tab switched ::"+i);
		
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();
		
		}
		action.release();
		driver.switchTo().defaultContent();
		/*Actions action1= new Actions(driver);
		action1.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();*/

	}catch(Exception e){
		throw e;
	}
	
}


public static void fn_switchTab1(int index) throws Exception{
	try{
		 
		Thread.sleep(3000);
		
		System.out.println("Switching Tabs");
		
		GenericMethods.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w");
		GenericMethods.driver.findElement(By.tagName("body")).sendKeys(Keys.CONTROL+"w");
		//GenericMethods.driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
	/*	Actions action= new Actions(driver);
		 
		action.keyDown(Keys.CONTROL).keyDown(Keys.SHIFT).sendKeys(Keys.TAB).build().perform();*/
		
		//GenericMethods.driver.switchTo().window(nameOrHandle)
		GenericMethods.driver.switchTo().defaultContent();
		
		

	}catch(Exception e){
		throw e;
	}
	
}
public static void zipFolder(String inputFolderPath, String outZipPath) throws IOException {
	
	
	
	try 
	{ 
	    //create a ZipOutputStream to zip the data to 
	    ZipOutputStream zos = new 
	           ZipOutputStream(new FileOutputStream(outZipPath)); 
	    //assuming that there is a directory named inFolder (If there 
	    //isn't create one) in the same directory as the one the code  runs from, 
	    //call the zipDir method 
	    zipDir(inputFolderPath, zos); 
	    //close the stream 
	    zos.close(); 
	} 
	catch(Exception e) 
	{ 
	    //handle exception 
	} 
}
	//here is the code for the method 
	public static void zipDir(String dir2zip, ZipOutputStream zos) 
	{ 
	    try 
	   { 
	        //create a new File object based on the directory we  have to zip     
	    	File  zipDir = new File(dir2zip); 
	        //get a listing of the directory content 
	        String[] dirList = zipDir.list(); 
	        byte[] readBuffer = new byte[2156]; 
	        int bytesIn = 0; 
	        //loop through dirList, and zip the files 
	        for(int i=0; i<dirList.length; i++) 
	        { 
	            File f = new File(zipDir, dirList[i]); 
	        if(f.isDirectory()) 
	        { 
	                //if the File object is a directory, call this 
	                //function again to add its content recursively 
	            String filePath = f.getPath(); 
	            zipDir(filePath, zos); 
	                //loop again 
	            continue; 
	        } 
	            //if we reached here, the File object f was not a directory 
	            //create a FileInputStream on top of f 
	            FileInputStream fis = new FileInputStream(f); 
	            //create a new zip entry 
	        ZipEntry anEntry = new ZipEntry(f.getPath()); 
	            //place the zip entry in the ZipOutputStream object 
	        zos.putNextEntry(anEntry); 
	            //now write the content of the file to the ZipOutputStream 
	            while((bytesIn = fis.read(readBuffer)) != -1) 
	            { 
	                zos.write(readBuffer, 0, bytesIn); 
	            } 
	           //close the Stream 
	           fis.close(); 
	    } 
	} 
	catch(Exception e) 
	{ 
	    //handle exception 
	} 
    
    }
    
public static int getNADate(String date)
{
	
	//Getting NA Date
	String split[]=	date.split(" ");
	for(int i=0;i<=split.length-1;i++)	
	{
		System.out.println(split[i]);
	}
		String date1[]=split[1].split(",");
	int i=Integer.parseInt(date1[0]);
	int seldate=i+1;
	return seldate;
	
}

public static String getNADateMonth(String date)
{
	//Getting NA Date
			String split[]=	date.split(" ");
			for(int i=0;i<=split.length-1;i++)
				
			{
				System.out.println(split[i]);
			}
			String month=split[0].substring(0, 3);
			
	
	return month;
	
}

public static String getNADateYear(String date)
{
	//Getting NA Date
	String split[]=	date.split(" ");
	for(int i=0;i<=split.length-1;i++)
		
	{
		System.out.println(split[i]);
	}

	String year=split[2];
	
	
	return year;
	
}

public  static String randomUniqueString()   {
	String uniqueString=null;
	try{
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddhhmmss");
		Date date = new Date();
		uniqueString = format.format(date);

	}catch(Exception e){

		e.printStackTrace();
	}

	return uniqueString;
}

public static String getSelectedValueFromDropdown(WebElement ele) throws Exception{
	try{

		Select s=new Select(ele);
		String selOption=s.getFirstSelectedOption().getText().trim();
		return selOption;
	}catch(Exception e){
		throw e;
	}
}

public static void fn_ActionsClick(WebElement we) throws Exception{
	try{
		new Actions(driver).click(we).build().perform();
		
	}catch(Exception e){
		throw e;
	}
}

public static void AcceptAlertAfterValidate() throws Exception {
	try {
		Thread.sleep(2000);
	boolean val=isAlertPresent();
	if(val==true) {
		ActionOnAlert("Accept");
	}
	}catch(Exception e) {
		throw e;
	}
}

public static String GetWebElementAttributeValue(WebElement ele,String attrName) throws Exception{
	String name=null;
	try{


		name=ele.getAttribute(attrName);
	}
	catch(Exception e){

		throw e;
	}
	return name;
}
public static String selectValueFromDropdownUsingIndex(WebElement element, int index) throws Exception{
	String  selValue=null;
	try{
		Select s=new Select(element);
		s.selectByIndex(index);	
		selValue=s.getFirstSelectedOption().getText();
	}catch(Exception e){
		throw e;
	}return selValue;
}

public static float fn_getRateFromRateString(String rateString){

	if((rateString.contains(",")==true) & (rateString.contains(".")==true)==true){

		String main []=rateString.split("\\.");
		String	SubMain []=main[0].toString().split("\\,");
		String inner[]=SubMain[0].split("\\s");
		String  whole=(inner[1] + SubMain[1] + "." + main[1]).toString();
		System.out.println("Price is in string format:"+ whole );
		tamt=Float.parseFloat(whole);
		System.out.println("Price is in float format:"+ tamt);
	}
	else if(rateString.contains(".")==true){
		String main []=rateString.split("\\.");
		String submain[]=main[0].split("\\s");
		String whole=(submain[1]+"."+main[1] ).toString();
		System.out.println("Price is in string format:"+ whole );
		tamt=Float.parseFloat(whole);
		System.out.println("Price is in float format:"+ tamt);
	}

	return tamt;

}

public static String GetSelectedValueFromDropdown(WebElement element){

	Select s=new Select(element);

	return s.getFirstSelectedOption().getText();

}

public static void CloseWindow(String title) throws Exception {
	try{
		Set<String> setHndlValColls=driver.getWindowHandles();
		Iterator<String>  itHandleColls= setHndlValColls.iterator();
		while(itHandleColls.hasNext()==true){
			String hndlval=itHandleColls.next();
			driver.switchTo().window(hndlval);
			if(driver.getTitle().contains(title)){
				driver.close();
			}
		}
	}catch(Exception e){
		throw e;
	}
}
}




