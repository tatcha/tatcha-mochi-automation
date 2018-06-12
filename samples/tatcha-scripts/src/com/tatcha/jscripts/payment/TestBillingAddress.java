package com.tatcha.jscripts.payment;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
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
import com.tatcha.jscripts.myaccount.AddressBook;

/**
 * Verify the credit card option of Checkout - Payment page
 * 
 * @author Reshma
 *
 */
public class TestBillingAddress {

	private TatchaTestHelper testHelper = new TatchaTestHelper();
	private final static Logger logger = Logger.getLogger(TestBillingAddress.class);
	public static final String COUNTRY_US = "United States";
	private TestCase testCase;

	/**
	 * Verify billing address check box, select a different billing address, add
	 * new billing address
	 * 
	 * @param driver
	 * @param prop
	 * @param locator
	 * @param user
	 * @param billingSameAsShipping
	 * @param selectAddress
	 * @param tcList
	 * @throws Exception
	 */
	public void testBillingAddress(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
			boolean billingSameAsShipping, boolean selectAddress, List<TestCase> tcList) throws Exception {

		logger.info("BEGIN testBillingAddress");
		final String FUN_ID = "FUN_BA";
		// String FUNCTIONALITY = "Verify adding/selecting billing address";
		// testCase = new TestCase("TC-6.1", "MOC-NIL", FUNCTIONALITY, "FAIL",
		// "");
		testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);
		Properties myAccountLocator = new Properties();
		myAccountLocator
				.load(new FileInputStream(getClass().getResource("/myAccountElementLocator.properties").getFile()));

		By billingAddrCheckboxLocator = By.xpath(locator.getProperty("billingAddr.checkbox").toString());
		wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddrCheckboxLocator));

		getTestHelper().logAssertion(getClass().getSimpleName(),
				prop.getProperty("payment.billingAddr.title").toString(),
				driver.findElement(By.xpath(locator.getProperty("billingAddr.title").toString())).getText());
		getTestHelper().logAssertion(getClass().getSimpleName(),
				prop.getProperty("payment.billingAddr.label").toString(),
				driver.findElement(By.xpath(locator.getProperty("billingAddr.label").toString())).getText());
		WebElement billingAddrCheckboxElement = driver.findElement(billingAddrCheckboxLocator);
		if (billingSameAsShipping) {
			if (!billingAddrCheckboxElement.isSelected()) {
				billingAddrCheckboxElement.click();
			}
			logger.info("Billing address is same as shipping address");
		} else {
			if (billingAddrCheckboxElement.isSelected()) {
				billingAddrCheckboxElement.click();
			}
		}

		if (!billingSameAsShipping && selectAddress) {
			testSelectNewBillingAddress(FLOW_ID, driver, prop, locator, user, tcList);
		} else if (!billingSameAsShipping && !selectAddress) {
			testAddBillingAddress(FLOW_ID, driver, prop, locator, user, tcList);
		}
		testCase.setStatus(TcConstants.PASS);
		tcList.add(testCase);
		logger.info("END testBillingAddress");
	}

	/**
	 * Select a new billing address
	 * 
	 * @param driver
	 * @param prop
	 * @param locator
	 * @param user
	 * @param tcList
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	public void testSelectNewBillingAddress(String FLOW_ID, WebDriver driver, Properties prop, Properties locator,
			User user, List<TestCase> tcList) throws Exception {

		logger.info("BEGIN testSelectNewBillingAddress");
		final String FUN_ID = "FUN_SBA";
		// String FUNCTIONALITY = "Select a billing address";
		// testCase = new TestCase("TC-6.2", "MOC-NIL", FUNCTIONALITY, "FAIL",
		// "");
		testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);
		List<WebElement> addressListWebElement = null;

		By billingAddrCheckboxLocator = By.xpath(locator.getProperty("billingAddr.checkbox").toString());
		wait.until(ExpectedConditions.visibilityOfElementLocated(billingAddrCheckboxLocator));
		WebElement billingAddrCheckboxElement = driver.findElement(billingAddrCheckboxLocator);
		billingAddrCheckboxElement = driver.findElement(billingAddrCheckboxLocator);
		if (billingAddrCheckboxElement.isSelected()) {
			billingAddrCheckboxElement.click();
		}
		getTestHelper().logAssertion(getClass().getSimpleName(),
				prop.getProperty("payment.billingAddr.select.label").toString(),
				driver.findElement(By.xpath(locator.getProperty("billingAddr.select.label").toString())).getText());

		logger.info("Get all the billing address");
		addressListWebElement = driver.findElements(By.name(locator.getProperty("billing.addressList").toString()));

		if (addressListWebElement.size() > 0) {
			// Select an existing address
			logger.info("Select a billing address");
			if (addressListWebElement.size() >= 2) {
				addressListWebElement.get(1).click();
			} else {
				addressListWebElement.get(0).click();
			}
		}
		testCase.setStatus(TcConstants.PASS);
		tcList.add(testCase);
		logger.info("END testSelectNewBillingAddress");
	}

	/**
	 * Add a new billing address
	 * 
	 * @param driver
	 * @param prop
	 * @param locator
	 * @param user
	 * @param tcList
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws Exception
	 */
	public void testAddBillingAddress(String FLOW_ID, WebDriver driver, Properties prop, Properties locator, User user,
			List<TestCase> tcList) throws Exception {

		logger.info("BEGIN testAddBillingAddress");
		final String FUN_ID = "FUN_ABA";
		// String FUNCTIONALITY = "Add a billing address";
		// testCase = new TestCase("TC-6.3", "MOC-NIL", FUNCTIONALITY, "FAIL",
		// "");
		testCase = TestCase.getFunctionalityTestCase(FLOW_ID, FUN_ID);

		WebDriverWait wait = (WebDriverWait) new WebDriverWait(driver, 10);
		AddressBook addrBook = new AddressBook();

		Properties myAccountLocator = new Properties();
		myAccountLocator
				.load(new FileInputStream(getClass().getResource("/myAccountElementLocator.properties").getFile()));

		String addressId = null;
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath(locator.getProperty("billing.addAddr.button").toString())));
		driver.findElement(By.xpath(locator.getProperty("billing.addAddr.button").toString())).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(locator.getProperty("shipping.addAddr.title").toString())));
		addressId = addrBook.populateAddressBook(FLOW_ID, driver, prop, myAccountLocator, true, true, tcList);
		driver.findElement(By.xpath(locator.getProperty("shipping.addAddr.save.button").toString())).click();
		wait.until(ExpectedConditions
				.invisibilityOfElementLocated(By.xpath(locator.getProperty("shipping.addAddr.title").toString())));
		logger.info("Address Added with Id : " + addressId);
		testCase.setStatus(TcConstants.PASS);
		tcList.add(testCase);
		logger.info("END testAddBillingAddress");
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
