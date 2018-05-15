package com.tatcha.jscripts.wrapper;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TcheckMenuLinks {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://52.43.54.174/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTcheckMenuLinks() throws Exception {
    driver.get(baseUrl + "/mocha/tatcha-bootstrap3/src/prototype-wrapper.html#");
    assertEquals("", driver.findElement(By.cssSelector("img.tatcha-logo")).getText());
    driver.findElement(By.linkText("Shop")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'Bestsellers')])[2]")).click();
    driver.findElement(By.xpath("(//a[contains(text(),'New')])[2]")).click();
    driver.findElement(By.linkText("Gifts")).click();
    driver.findElement(By.linkText("Pure Promise")).click();
    driver.findElement(By.cssSelector("input.form-control")).click();
    driver.findElement(By.cssSelector("input.form-control")).clear();
    driver.findElement(By.cssSelector("input.form-control")).sendKeys("cutex");
    driver.findElement(By.cssSelector("button.close")).click();
  }

  @After
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
