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
import com.tatcha.jscripts.commons.ReportGenerator;
import com.tatcha.jscripts.dao.TestCase;
import com.tatcha.jscripts.commons.TestMethods;
import com.tatcha.jscripts.confirmation.TestOrderConfirmation;
import com.tatcha.jscripts.dao.User;
import com.tatcha.jscripts.exception.TatchaException;
import com.tatcha.jscripts.helper.TatchaTestHelper;
import com.tatcha.jscripts.login.TestLogin;
import com.tatcha.jscripts.review.ReviewOrder;
import com.tatcha.utils.BrowserDriver;

/**
 * Flow 14 : Add to cart - Login in Checkout page - Order Review(With US address) -
 * Place order
 * 
 * @author Reshma
 *
 */
public class EditReviewUSAddress {

    private WebDriver driver = BrowserDriver.getChromeWebDriver();
    private StringBuffer verificationErrors = new StringBuffer();
    private Properties prop = new Properties();
    private Properties locator = new Properties();
    private Properties bagLocator = new Properties();
    private Properties data = new Properties();

    private TatchaTestHelper testHelper = new TatchaTestHelper();
    private final static Logger logger = Logger.getLogger(EditReviewUSAddress.class);

    private static TestMethods tmethods;
    private TestCase testCase;
    private List<TestCase> tcList = new ArrayList<TestCase>();
    private final String MODULE = "Flow-14 : EditReviewUSAddress";
    private final String FLOW_ID = "FLOW_14";

    @Before
    public void setUp() throws Exception {
        prop.load(new FileInputStream(getClass().getResource("/tatcha.properties").getFile()));
        locator.load(new FileInputStream(getClass().getResource("/checkoutElementLocator.properties").getFile()));
        bagLocator.load(new FileInputStream(getClass().getResource("/shoppingBagElementLocator.properties").getFile()));
        data.load(new FileInputStream(getClass().getResource("/testFlows/EditReviewUSAddress.properties").getFile()));
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
    public void testEditReviewUSAddress() throws Exception {

//        String FUNCTIONALITY = "Edit Payment and Shipping from Order Review";
//        testCase = new TestCase("Flow-14", "MOC-NIL", FUNCTIONALITY, "FAIL", "");
    	final String FUN_ID = "FUN_14";
    	testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_HH:mm:ss");
        String timeStamp = sdf.format(Calendar.getInstance().getTime());
        logger.info(getClass() + timeStamp);

        ReviewOrder reviewOrder = new ReviewOrder();
        User user = new User();
        Map<String, Boolean> map = new HashMap<String, Boolean>();

        TestAddToCart addToCart = new TestAddToCart();
        TestLogin testLogin = new TestLogin();

        map.put("isLogged", true);
        map.put("isUSAddress", true);
        map.put("isGiftCard", false);
        map.put("isCreditCard", true);
        map.put("isRegister", false);
        map.put("gotoOrderReview", false);

        WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);

        try {
            addToCart.addSpecificProductToCart(FLOW_ID, driver, prop, locator, user, tcList);

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h2.panel-title")));
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
            reviewOrder.verifyReviewOrder4(FLOW_ID, driver, prop, locator, user, map, tcList);

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
        logger.info("END testEditReviewUSAddress");
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
