package com.tatcha.jscripts.confirmation;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.jscripts.TcConstants;
import com.tatcha.jscripts.bag.TestAddToCart;
import com.tatcha.jscripts.dao.TestCase;
import com.tatcha.jscripts.dao.User;
import com.tatcha.jscripts.helper.TatchaTestHelper;

public class TestOrderConfirmation {

    private TatchaTestHelper testHelper = new TatchaTestHelper();
    private final static Logger logger = Logger.getLogger(TestAddToCart.class);
    private TestCase testCase;

    /**
     * Verify the Order Confirmation page
     * 
     * @param driver2
     * @param prop2
     * @param locator2
     * @param user
     * @param tcList
     * @throws Exception
     */
    public void verifyOrderConfirmation(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
            List<TestCase> tcList) throws Exception {

        logger.info("BEGIN verifyOrderConfirmation");
        final String FUN_ID = "FUN_VOC";
//        String FUNCTIONALITY = "Verify the order confirmation page";
//        testCase = new TestCase("TC-19.1", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
        testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        
        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        String timeStamp = sdf.format(Calendar.getInstance().getTime());
/*
        try {
            Actions actions = new Actions(driver);
            wait.until(ExpectedConditions
                    .visibilityOfElementLocated(By.xpath(locator.getProperty("confirmOrder.modal.title").toString())));
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locator.getProperty("confirmOrder.modal.close.button").toString())));
            
            // Click close button                
            WebElement closeButtonElement = driver.findElement(By.xpath(locator.getProperty("confirmOrder.modal.close.button").toString()));
            actions.moveToElement(closeButtonElement).click(closeButtonElement);
            actions.perform();
            
            
            logger.info("Modalbox is present");
            wait.until(ExpectedConditions
                    .invisibilityOfElementLocated(By.xpath(locator.getProperty("confirmOrder.modal.title").toString())));

        } catch (TimeoutException te) {
            logger.info("Modalbox is NOT present");
        }
        */
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.getProperty("confirmOrder.title").toString())));
        getTestHelper().logAssertion(getClass().getSimpleName(), "THANK YOU FOR YOUR ORDER",
                driver.findElement(By.xpath(locator.getProperty("confirmOrder.title").toString())).getText());
        
        String orderId = driver.findElement(By.xpath(locator.getProperty("confirmOrder.orderId.label").toString())).getText();

        getTestHelper().logAssertion(getClass().getSimpleName(), "Hello, "+user.getFname()+"! Your order number is "+orderId+".",
                driver.findElement(By.xpath(locator.getProperty("confirmOrder.label.text").toString())).getText());
        
        getTestHelper().logAssertion(getClass().getSimpleName(), prop.getProperty("confirmOrder.info.text").toString(),
                driver.findElement(By.xpath(locator.getProperty("confirmOrder.info.text").toString())).getText());

        timeStamp = sdf.format(Calendar.getInstance().getTime());
        logger.info("ORDER ID : " +orderId+ " TIMESTAMP : " + timeStamp);
        
        testCase.setStatus(TcConstants.PASS);
        tcList.add(testCase);
        logger.info("END verifyOrderConfirmation");
    }

    public TatchaTestHelper getTestHelper() {
        return testHelper;
    }

    public void setTestHelper(TatchaTestHelper testHelper) {
        this.testHelper = testHelper;
    }
}
