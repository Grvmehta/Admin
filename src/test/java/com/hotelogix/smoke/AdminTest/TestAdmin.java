package com.hotelogix.smoke.AdminTest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestAdmin {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://staygrid.com/admine/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testCode() throws Exception {
    //driver.get(baseUrl + "/admine/login/login/redirect/1/rurl/JTJGYWRtaW5lJTJG");
    driver.get(baseUrl);

    driver.findElement(By.id("hotelCodeId")).clear();
    driver.findElement(By.id("hotelCodeId")).sendKeys("20819");
    driver.findElement(By.id("userNameId")).clear();
    driver.findElement(By.id("userNameId")).sendKeys("barkha.kapoorhms@gmail.com");
    driver.findElement(By.id("passwordId")).clear();
    driver.findElement(By.id("passwordId")).sendKeys("123456");
    driver.findElement(By.name("Submit52")).click();
    Thread.sleep(5000);
    driver.navigate().refresh();
    driver.findElement(By.linkText("Rooms Manager")).click();
    driver.findElement(By.linkText("Amenities")).click();
    driver.findElement(By.cssSelector("img[alt=\"Add an Amenity\"]")).click();

    driver.findElement(By.id("titleMulTang_0")).sendKeys("testamen");
    driver.findElement(By.cssSelector("td.comments > input[name=\"Submit5\"]")).click();
    assertEquals(driver.getTitle(), "Amenities List");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
