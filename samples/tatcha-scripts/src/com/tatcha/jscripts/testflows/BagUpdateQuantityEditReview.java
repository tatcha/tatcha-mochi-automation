package com.tatcha.jscripts.testflows;

import static org.junit.Assert.fail;

import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tatcha.jscripts.TcConstants;
import com.tatcha.jscripts.bag.TestAddToCart;
import com.tatcha.jscripts.bag.TestCartItems;
import com.tatcha.jscripts.commons.ReportGenerator;
import com.tatcha.jscripts.dao.TestCase;
import com.tatcha.jscripts.commons.TestMethods;
import com.tatcha.jscripts.confirmation.TestOrderConfirmation;
import com.tatcha.jscripts.dao.User;
import com.tatcha.jscripts.exception.TatchaException;
import com.tatcha.jscripts.helper.TatchaTestHelper;
import com.tatcha.jscripts.login.TestLogin;
import com.tatcha.jscripts.review.ReviewOrder;
import com.tatcha.jscripts.summary.TestSummary;
import com.tatcha.utils.BrowserDriver;

/**
 * Flow : 13
 * 
 * @author Reshma
 *
 */
public class BagUpdateQuantityEditReview {

    private WebDriver driver = BrowserDriver.getChromeWebDriver();
    private StringBuffer verificationErrors = new StringBuffer();
    private Properties prop = new Properties();
    private Properties locator = new Properties();
    private Properties bagLocator = new Properties();
    private Properties data = new Properties();

    private TatchaTestHelper testHelper = new TatchaTestHelper();
    private final static Logger logger = Logger.getLogger(BagUpdateQuantityEditReview.class);
    private int QTY_TWO = 2;

    private static TestMethods tmethods;
    private TestCase testCase;
    private List<TestCase> tcList = new ArrayList<TestCase>();
    private final String MODULE = "Flow-13 : BagUpdateQuantityEditReview";
    private final String FLOW_ID = "FLOW_13";

    @Before
    public void setUp() throws Exception {
        prop.load(new FileInputStream(getClass().getResource("/tatcha.properties").getFile()));
        locator.load(new FileInputStream(getClass().getResource("/checkoutElementLocator.properties").getFile()));
        bagLocator.load(new FileInputStream(getClass().getResource("/shoppingBagElementLocator.properties").getFile()));
        data.load(new FileInputStream(getClass().getResource("/testFlows/BagUpdateQuantityEditReview.properties").getFile()));

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        boolean testInLocal = Boolean.parseBoolean(prop.getProperty("testInLocal").toString());
        if (testInLocal) {
            String url = data.getProperty("url").toString();
            driver.get(url);
        } else {
            tmethods = TestMethods.getInstance();
            String baseUrl = tmethods.getBaseURL();
            driver.get(baseUrl);
        }
    }

    /**
     * Test the checkout flow of logged in user. Pre-requisite : The user should
     * have default shipping and payment details,
     * 
     * @throws Exception
     */
    @Test
    public void testBagUpdateQuantityEditReview() throws Exception {
    	final String FUN_ID = "FUN_13";
//        String FUNCTIONALITY = "1. Update product quantity from bag, 2. Edit Payment and edit Shipping from Order Review";
//        testCase = new TestCase("Flow-13", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
    	testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        String timeStamp = sdf.format(Calendar.getInstance().getTime());

        logger.info(getClass() + timeStamp);

        ReviewOrder reviewOrder = new ReviewOrder();
        User user = new User();
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        TestAddToCart addToCart = new TestAddToCart();
        TestCartItems testCartItems = new TestCartItems();
        TestSummary testSummary = new TestSummary();
        TestLogin testLogin = new TestLogin();

        map.put("isLogged", true);
        map.put("isUSAddress", true);
        map.put("isGiftCard", false);
        map.put("isCreditCard", true);
        map.put("isRegister", false);
        map.put("gotoOrderReview", true);

        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        try {
            addToCart.addSpecificProductToCart(FLOW_ID, driver, prop, locator, user, tcList);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.panel-title")));

            testSummary.testBagSummary(FLOW_ID, driver, prop, bagLocator, user, map, tcList);
            String merchTotalString = driver
                    .findElement(By.xpath(bagLocator.getProperty("summary.merchtotal.value").toString())).getText();
            String orderTotalString = driver
                    .findElement(By.xpath(bagLocator.getProperty("summary.total.value").toString())).getText();
            double merchPrice = getTestHelper().getPrice(merchTotalString);
            double orderTotal = getTestHelper().getPrice(orderTotalString);

            testCartItems.testUpdateItemQuantity(FLOW_ID, driver, prop, bagLocator, user, tcList);

            testSummary.testBagSummary(FLOW_ID, driver, prop, bagLocator, user, map, tcList);
            merchTotalString = driver
                    .findElement(By.xpath(bagLocator.getProperty("summary.merchtotal.value").toString())).getText();
            orderTotalString = driver.findElement(By.xpath(bagLocator.getProperty("summary.total.value").toString()))
                    .getText();
            double merchPriceUpdated = getTestHelper().getPrice(merchTotalString);
            double orderTotalUpdated = getTestHelper().getPrice(orderTotalString);

            getTestHelper().logAssertion(getClass().getSimpleName(), merchPrice * QTY_TWO == merchPriceUpdated);
            getTestHelper().logAssertion(getClass().getSimpleName(),
                    orderTotalUpdated == orderTotal + (merchPriceUpdated - merchPrice));

            wait.until(ExpectedConditions
                    .elementToBeClickable(By.xpath("//*[@id='cart-table']/div[2]/div/div[2]/button")));

            // Click checkout button in shopping bag
            Actions actions = new Actions(driver);
            WebElement checkoutButtonElement = driver
                    .findElement(By.xpath("//*[@id='cart-table']/div[2]/div/div[2]/button"));
            actions.moveToElement(checkoutButtonElement).click(checkoutButtonElement);
            actions.perform();

            // Login as a registered user at the checkout
            testLogin.checkoutLogin(FLOW_ID, driver, data, user, tcList);

            // Verify Review Order for express checkout
            reviewOrder.verifyReviewOrder3(FLOW_ID, driver, prop, locator, user, map, tcList);

            TestOrderConfirmation testConf = new TestOrderConfirmation();
            testConf.verifyOrderConfirmation(FLOW_ID, driver, prop, locator, user, tcList);

            testCase.setStatus(TcConstants.PASS);
            tcList.add(testCase);
        } catch (Exception exp) {
            try {
                throw new TatchaException(exp, tcList);
            } catch (Exception e) {
                logger.error("Handling Tatcha Exception " + e.toString());
            }
        }
        boolean generateReport = Boolean.parseBoolean(prop.getProperty("generateReport").toString());
        if (generateReport && ReportGenerator.getInstance().generateReport(MODULE, tcList)) {
            logger.info("Report Generation Succeeded for: " + MODULE);
        } else {
            logger.info("Report Generation Failed for: " + MODULE);
        }
        logger.info("END testBagUpdateQuantityEditReview");
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

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
