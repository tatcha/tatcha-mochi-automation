package com.tatcha.jscripts.review;

import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.jscripts.TcConstants;
import com.tatcha.jscripts.dao.TestCase;
import com.tatcha.jscripts.dao.User;
import com.tatcha.jscripts.helper.TatchaTestHelper;
import com.tatcha.jscripts.summary.TestItems;
import com.tatcha.jscripts.summary.TestSummary;

/**
 * Class that checks different sections of Checkout - Order Review page
 * 
 * @author Reshma
 *
 */
public class ReviewOrder {

    private TatchaTestHelper testHelper = new TatchaTestHelper();
    private final static Logger logger = Logger.getLogger(ReviewOrder.class);
    private TestCase testCase;

    /**
     * Verify Review Order page and edit button of Shipping and Payment section
     * 
     * @param driver
     * @param prop
     * @param locator
     * @param user
     * @param map
     * @param tcList
     * @throws Exception
     */
    public void verifyReviewOrder1(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            Map<String, Boolean> map, List<TestCase> tcList) throws Exception {

        logger.info("BEGIN verifyReviewOrder");
        final String FUN_ID = "FUN_VRO1";
//        String FUNCTIONALITY = "Verify Review order and edit button of shipping and payment section";
//        testCase = new TestCase("TC-9.1", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator.getProperty("checkout.title").toString())));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator.getProperty("checkout.step3.title").toString())));

        TestShippingSection testShipping = new TestShippingSection();
        testShipping.testShippingSection(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestPaymentSection testPayment = new TestPaymentSection();
        testPayment.testPaymentSection(FLOW_ID,driver, prop, locator, user, map, tcList);
        TestReviewOrder testReview = new TestReviewOrder();
        testReview.testReviewOrder(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestSummary testSummary = new TestSummary();
        testSummary.testSummary(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestItems testItem = new TestItems();
        testItem.testItems(FLOW_ID, driver, prop, locator, user, map, tcList);

        // Click place order button
        By placeOrderButtonLocator = By.xpath(locator.getProperty("reviewOrder.placeOrder.button").toString());
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButtonLocator);
        if (placeOrderButtonElement.isEnabled()) {
            placeOrderButtonElement.click();
        }
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyReviewOrder");
    }

    /**
     * Verify Review order page for logged-in user
     * 
     * @param driver
     * @param prop
     * @param locator
     * @param user
     * @param map
     * @param tcList
     * @throws Exception
     */
    public void verifyReviewOrder2(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            Map<String, Boolean> map, List<TestCase> tcList, boolean doPlaceOrder) throws Exception {

        logger.info("BEGIN verifyReviewOrder2");
        final String FUN_ID = "FUN_VRO2";
//        String FUNCTIONALITY = "Verify Review order page";
//        testCase = new TestCase("TC-9.2", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator.getProperty("checkout.title").toString())));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator.getProperty("checkout.step3.title").toString())));

        TestShippingSection testShipping = new TestShippingSection();
        testShipping.testReviewShipping(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestPaymentSection testPayment = new TestPaymentSection();
        testPayment.testReviewPayment(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestReviewOrder testReview = new TestReviewOrder();
        testReview.testReviewOrder(FLOW_ID, driver, prop, locator, user, map, tcList);

        if (doPlaceOrder) {
            // Click place order button
            By placeOrderButtonLocator = By.xpath(locator.getProperty("reviewOrder.placeOrder.button").toString());
            WebElement placeOrderButtonElement = driver.findElement(placeOrderButtonLocator);
            if (placeOrderButtonElement.isEnabled()) {
                placeOrderButtonElement.click();
            }
        }
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyReviewOrder2");
    }

    /**
     * Verify Review order and edit shipping and payment section separately
     * 
     * @param driver
     * @param prop
     * @param locator
     * @param user
     * @param map
     * @param tcList
     * @throws Exception
     */
    public void verifyReviewOrder3(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            Map<String, Boolean> map, List<TestCase> tcList) throws Exception {

        logger.info("BEGIN verifyReviewOrder3");
        final String FUN_ID = "FUN_VRO3";
//        String FUNCTIONALITY = "Verify Review order and edit shipping and payment section separately";
//        testCase = new TestCase("TC-9.3", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator.getProperty("checkout.title").toString())));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator.getProperty("checkout.step3.title").toString())));

        TestShippingSection testShipping = new TestShippingSection();
        testShipping.testEditShipping(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestPaymentSection testPayment = new TestPaymentSection();
        testPayment.testEditPayment(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestReviewOrder testReview = new TestReviewOrder();
        testReview.testReviewOrder(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestSummary testSummary = new TestSummary();
        testSummary.testSummary(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestItems testItem = new TestItems();
        testItem.testItems(FLOW_ID, driver, prop, locator, user, map, tcList);

        // Click place order button
        By placeOrderButtonLocator = By.xpath(locator.getProperty("reviewOrder.placeOrder.button").toString());
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButtonLocator);
        if (placeOrderButtonElement.isEnabled()) {
            placeOrderButtonElement.click();
        }
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyReviewOrder3");
    }

    /**
     * Verify Review order and edit shipping and payment section
     * 
     * @param driver
     * @param prop
     * @param locator
     * @param user
     * @param map
     * @param tcList
     * @throws Exception
     */
    public void verifyReviewOrder4(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            Map<String, Boolean> map, List<TestCase> tcList) throws Exception {
    	
        logger.info("BEGIN verifyReviewOrder4");
        final String FUN_ID = "FUN_VRO4";      
//        String FUNCTIONALITY = "Verify review order and edit shipping and payment";
//        testCase = new TestCase("TC-9.4", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator.getProperty("checkout.title").toString())));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator.getProperty("checkout.step3.title").toString())));

        TestShippingSection testShipping = new TestShippingSection();
        testShipping.testEditShipping(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestPaymentSection testPayment = new TestPaymentSection();
        testPayment.testEditPaymentBilling(FLOW_ID, driver, prop, locator, user, map, tcList);
        testPayment.testReviewPayment(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestReviewOrder testReview = new TestReviewOrder();
        testReview.testReviewOrder(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestSummary testSummary = new TestSummary();
        testSummary.testSummary(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestItems testItem = new TestItems();
        testItem.testItems(FLOW_ID, driver, prop, locator, user, map, tcList);

        // Click place order button
        By placeOrderButtonLocator = By.xpath(locator.getProperty("reviewOrder.placeOrder.button").toString());
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButtonLocator);
        if (placeOrderButtonElement.isEnabled()) {
            placeOrderButtonElement.click();
        }
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyReviewOrder4");
    }

    /**
     * Verify Review Order page when cart has egift certificate
     * 
     * @param driver
     * @param prop
     * @param locator
     * @param user
     * @param map
     * @param tcList
     * @throws Exception
     */
    public void verifyEGiftReviewOrder(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            Map<String, Boolean> map, List<TestCase> tcList) throws Exception {

        logger.info("BEGIN verifyEGiftReviewOrder");
        final String FUN_ID = "FUN_VERO";
//        String FUNCTIONALITY = "Verify Review order when EGift Certificate only in cart";
//        testCase = new TestCase("TC-9.5", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        		
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator.getProperty("checkout.title").toString())));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//*[@id='ext-gen44']/body/main/div[1]/div/ul/li[2]/a")));

        TestPaymentSection testPayment = new TestPaymentSection();
        testPayment.testReviewEGiftPayment(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestSummary testSummary = new TestSummary();
        testSummary.testEgiftSummary(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestItems testItem = new TestItems();
        testItem.testEgiftItem(FLOW_ID, driver, prop, locator, user, map, tcList);

        // Click place order button
        By placeOrderButtonLocator = By.xpath(locator.getProperty("reviewOrder.placeOrder.button").toString());
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButtonLocator);
        if (placeOrderButtonElement.isEnabled()) {
            placeOrderButtonElement.click();
        }
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyEGiftReviewOrder");
    }

    /**
     * Verify Review order page for Guest user, User Registration happens
     * depending on the flag set in the map parameter
     * 
     * @param driver
     * @param prop
     * @param locator
     * @param user
     * @param map
     * @param data
     * @param tcList
     * @throws Exception
     */
    public void verifyGuestReviewOrder(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            Map<String, Boolean> map, Properties data, List<TestCase> tcList) throws Exception {

        logger.info("BEGIN verifyGuestReviewOrder");
        final String FUN_ID = "FUN_VGRO";
//        String FUNCTIONALITY = "Verify Review Order for guest checkout";
//        testCase = new TestCase("TC-9.6", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        		
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.cssSelector(locator.getProperty("checkout.title").toString())));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath(locator.getProperty("checkout.step3.title").toString())));

        TestShippingSection testShipping = new TestShippingSection();
        testShipping.testReviewShipping(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestPaymentSection testPayment = new TestPaymentSection();
        testPayment.testReviewPayment(FLOW_ID, driver, prop, locator, user, map, tcList);
        TestCreateAccount testCreateAccnt = new TestCreateAccount();
        testCreateAccnt.testCreateAccount(FLOW_ID, driver, prop, locator, user, map, data, tcList);
        TestReviewOrder testReview = new TestReviewOrder();
        testReview.testGuestReviewOrder(FLOW_ID, driver, prop, locator, user, map, data, tcList);

        // Click place order button
        By placeOrderButtonLocator = By.xpath(locator.getProperty("reviewOrder.placeOrder.button").toString());
        WebElement placeOrderButtonElement = driver.findElement(placeOrderButtonLocator);
        if (placeOrderButtonElement.isEnabled()) {
            placeOrderButtonElement.click();
        }
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyGuestReviewOrder");
    }

    /**
     * @return the testHelper
     */
    public TatchaTestHelper getTestHelper() {
        return testHelper;
    }

    /**
     * @param testHelper
     *            the testHelper to set
     */
    public void setTestHelper(TatchaTestHelper testHelper) {
        this.testHelper = testHelper;
    }
}
