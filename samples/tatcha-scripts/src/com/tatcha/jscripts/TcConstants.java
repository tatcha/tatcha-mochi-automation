package com.tatcha.jscripts;

import com.tatcha.jscripts.dao.TestCase;

public final class TcConstants {

	private TcConstants() {
	}

	public static String PASS = "PASS";
	public static String FAIL = "FAIL";
	public static String BLANK = "";

	// Error fields
	public static String TC_ERR = "TC-ERR";
	public static String MOC_ERR = "MOC-ERR";
	public static String FUN_ERR = "Overall Testing";

	// Shipping Address Test Case Constants
	public static String SH_TC_101 = "TC-001";

	// Product Details Page Test Case Constants

	public static String PDP_TC_101 = "TC-101";
	public static String PDP_MOC_101 = "MOC-23";
	public static String PDP_FUN_101 = "Marketing Flags";
	public static String PDP_DESC_101;

	public static String PDP_TC_102 = "TC-102";
	public static String PDP_MOC_102 = "MOC-23";
	public static String PDP_FUN_102 = "Product Titles";
	public static String PDP_DESC_102 = "Product Title & Subtitle";

	public static String PDP_TC_103 = "TC-103";
	public static String PDP_MOC_103 = "MOC-23";
	public static String PDP_FUN_103 = "Product Price";
	public static String PDP_DESC_103;

	public static String PDP_TC_104 = "TC-104";
	public static String PDP_MOC_104 = "MOC-23";
	public static String PDP_FUN_104 = "Skin Variant";
	public static String PDP_DESC_104;

	public static String PDP_TC_105 = "TC-105";
	public static String PDP_MOC_105 = "MOC-23";
	public static String PDP_FUN_105 = "Size Variant";
	public static String PDP_DESC_105;

	public static String PDP_TC_106 = "TC-106";
	public static String PDP_MOC_106 = "MOC-23";
	public static String PDP_FUN_106 = "Quantity Notification";
	public static String PDP_DESC_106 = "Quantity Notification Message";

	public static String PDP_TC_107 = "TC-107";
	public static String PDP_MOC_107 = "MOC-23";
	public static String PDP_FUN_107 = "Quantity DDL";
	public static String PDP_DESC_107 = "Quantity Drop Down List";

	public static String PDP_TC_108 = "TC-108";
	public static String PDP_MOC_108 = "MOC-23";
	public static String PDP_FUN_108 = "Quantity Limit";
	public static String PDP_DESC_108 = "Quantity Limit Message";

	public static String PDP_TC_109 = "TC-109";
	public static String PDP_MOC_109 = "MOC-23";
	public static String PDP_FUN_109 = "Reviews";
	public static String PDP_DESC_109 = "Review Messages";

	public static String PDP_TC_110 = "TC-110";
	public static String PDP_MOC_110 = "MOC-23";
	public static String PDP_FUN_110 = "Product Images";
	public static String PDP_DESC_110 = "Main Image & Thumbnails";

	public static String PDP_TC_111 = "TC-111";
	public static String PDP_MOC_111 = "MOC-23";
	public static String PDP_FUN_111 = "Recommended For";
	public static String PDP_DESC_111 = "Benefits - Recommended For";

	public static String PDP_TC_112 = "TC-112";
	public static String PDP_MOC_112 = "MOC-23";
	public static String PDP_FUN_112 = "What It Is";
	public static String PDP_DESC_112 = "Benefits - What It Is";

	public static String PDP_TC_113 = "TC-103";
	public static String PDP_MOC_113 = "MOC-23";
	public static String PDP_FUN_113 = "Why It Works";
	public static String PDP_DESC_113 = "Benefits - Why It Works";

	public static String PDP_TC_114 = "TC-114";
	public static String PDP_MOC_114 = "MOC-23";
	public static String PDP_FUN_114 = "Ingredients";
	public static String PDP_DESC_114 = "Formulated without / Full Ingredients list / Spotlight Ingredients";

	public static String PDP_TC_115 = "TC-115";
	public static String PDP_MOC_115 = "MOC-23";
	public static String PDP_FUN_115 = "Hadasei-3";
	public static String PDP_DESC_115;

	public static String PDP_TC_116 = "TC-116";
	public static String PDP_MOC_116 = "MOC-23";
	public static String PDP_FUN_116 = "How To Use";
	public static String PDP_DESC_116 = "Suggested Usage, Dosage & Texture";

	public static String PDP_TC_117 = "TC-117";
	public static String PDP_MOC_117 = "MOC-23";
	public static String PDP_FUN_117 = "Suggested Ritual";
	public static String PDP_DESC_117;

	public static String PDP_TC_118 = "TC-118";
	public static String PDP_MOC_118 = "MOC-23";
	public static String PDP_FUN_118 = "Q&A";
	public static String PDP_DESC_118 = "Questions & Answers";

	public static String PDP_TC_119 = "TC-119";
	public static String PDP_MOC_119 = "MOC-23";
	public static String PDP_FUN_119 = "Purity Promise";
	public static String PDP_DESC_119;

	public static String PDP_TC_XX = "TC-NIL";
	public static String PDP_MOC_XX = "MOC-NIL";
	public static String PDP_FUN_XX = "YTD";
	public static String PDP_DESC_XX = "NIL";

	// Product Listing Page Test Case Constants

	public static String PDP_TC_202 = "TC-202";
	public static String PDP_MOC_202 = "MOC-23";
	public static String PDP_FUN_202 = "Product Name";
	public static String PDP_DESC_202;

	/** CONSTANT VALUES FOR TEST FLOWS:- */

	// FLOW_1 LoginExpressCheckoutDefaultUS
	// FUN_1 testExpressCheckoutLoginUS
	public static String FLOW_1_TC = "TC-1";
	public static String FLOW_1_MOC = "MOC-1";
	public static String FLOW_1_FUN = "Express checkout with default US address and credit card";

	// FLOW_2 LoginExpressCheckoutDefaultInternational
	// FUN_2 testExpressCheckoutLoginInternational
	public static String FLOW_2_TC = "TC-2";
	public static String FLOW_2_MOC = "MOC-2";
	public static String FLOW_2_FUN = "Express checkout with default international address and credit card";

	// FLOW_3 LoginCheckoutFirstAddressUS
	// FUN_3 testLoginCheckoutFirstAddressUS
	public static String FLOW_3_TC = "TC-3";
	public static String FLOW_3_MOC = "MOC-3";
	public static String FLOW_3_FUN = "Checkout as logged in user with first address(US)";

	// FLOW_4 LoginCheckoutNewAddressUS
	// FUN_4 testLoginCheckoutNewAddressUS
	public static String FLOW_4_TC = "TC-4";
	public static String FLOW_4_MOC = "MOC-4";
	public static String FLOW_4_FUN = "Checkout as logged in user with a new address(US)";

	// FLOW_5 LoginCheckoutSelectAddressUS
	// FUN_5 testLoginCheckoutSelectAddressUS
	public static String FLOW_5_TC = "TC-5";
	public static String FLOW_5_MOC = "MOC-5";
	public static String FLOW_5_FUN = "Checkout as logged in user and selecting an existing address(US)";

	// FLOW_6 LoginCheckoutFirstAddressInternational
	// FUN_6 testLoginCheckoutFirstAddressInternational
	public static String FLOW_6_TC = "TC-6";
	public static String FLOW_6_MOC = "MOC-6";
	public static String FLOW_6_FUN = "Checkout as logged in user by adding first address(international)";

	// FLOW_7 LoginCheckoutNewAddressInternational
	// FUN_7 testLoginCheckoutNewAddressInternational
	public static String FLOW_7_TC = "TC-7";
	public static String FLOW_7_MOC = "MOC-7";
	public static String FLOW_7_FUN = "Checkout as logged in user with a new address(International)";

	// FLOW_8 LoginCheckoutSelectAddressInternational
	// FUN_8 testLoginCheckoutSelectAddressInternational
	public static String FLOW_8_TC = "TC-8";
	public static String FLOW_8_MOC = "MOC-8";
	public static String FLOW_8_FUN = "Checkout as logged in user and selecting an existing address(International)";

	// FLOW_9 GuestCheckoutUSAddress
	// FUN_9 testGuestCheckoutUSAddress
	public static String FLOW_9_TC = "TC-9";
	public static String FLOW_9_MOC = "MOC-9";
	public static String FLOW_9_FUN = "Checkout as guest with US shipping address";

	// FLOW_10 GuestCheckoutInternationalAddress
	// FUN_10 testGuestCheckoutInternationalAddress
	public static String FLOW_10_TC = "TC-10";
	public static String FLOW_10_MOC = "MOC-10";
	public static String FLOW_10_FUN = "Checkout as a guest with international address and gift card";

	// FLOW_11 GuestCheckoutUSAddressRegister
	// FUN_11 testGuestCheckoutUSAddressRegister
	public static String FLOW_11_TC = "TC-11";
	public static String FLOW_11_MOC = "MOC-11";
	public static String FLOW_11_FUN = "Checkout as guest with US address and register in order review page";

	// FLOW_12 GuestCheckoutInternationalAddressRegister
	// FUN_12 testGuestCheckoutInternationalAddressRegister
	public static String FLOW_12_TC = "TC-12";
	public static String FLOW_12_MOC = "MOC-12";
	public static String FLOW_12_FUN = "Checkout as guest with international address and register in order review page";

	// FLOW_13 BagUpdateQuantityEditReview
	// FUN_13 testBagUpdateQuantityEditReview
	public static String FLOW_13_TC = "TC-13";
	public static String FLOW_13_MOC = "MOC-13";
	public static String FLOW_13_FUN = "1. Update product quantity from bag, 2. Edit Payment and edit Shipping from Order Review";

	// FLOW_14 EditReviewUSAddress
	// FUN_14 testEditReviewUSAddress
	public static String FLOW_14_TC = "TC-14";
	public static String FLOW_14_MOC = "MOC-14";
	public static String FLOW_14_FUN = "Edit Payment and Shipping from Order Review";

	// FLOW_15 GiftCertificateCheckout
	// FUN_15 testGiftCertificateCheckout
	public static String FLOW_15_TC = "TC-15";
	public static String FLOW_15_MOC = "MOC-15";
	public static String FLOW_15_FUN = "Add Gift Certificate to cart and place order with default payment";

	// FLOW_16 ProductGiftCertificateCheckout
	// FUN_16 testProductGiftCertificateCheckout
	public static String FLOW_16_TC = "TC-16";
	public static String FLOW_16_MOC = "MOC-16";
	public static String FLOW_16_FUN = "Login checkout egift and a product";

	// FLOW_17 ShoppingBagSamplesExpressCheckout
	// FUN_17 testShoppingBagSamplesExpressCheckout
	public static String FLOW_17_TC = "TC-17";
	public static String FLOW_17_MOC = "MOC-17";
	public static String FLOW_17_FUN = "Express checkout with a Product and Samples in cart";

	// FLOW_18 LoginMyAccount
	// FUN_18 testLoginMyAccount
	public static String FLOW_18_TC = "TC-18";
	public static String FLOW_18_MOC = "MOC-18";
	public static String FLOW_18_FUN = "Login and verify My Account";

	// FLOW 19 BagAutoDelivery
	// FUN_19 testBagAutoDelivery
	public static String FLOW_19_TC = "TC-19";
	public static String FLOW_19_MOC = "MOC-19";
	public static String FLOW_19_FUN = "Enable auto delivery for a product from shopping bag and checkout";

	/** LOGIN */

	// TestLogin
	// FUN_CL checkoutLogin
	public static String FUN_CL = "Login in the checkout flow";
	// FUN_CG checkoutGuest
	public static String FUN_CG = "Checkout as a guest";
	// FUN_L login
	public static String FUN_L = "Login to the account";

	/** MY ACCOUNT */
	// 18
	// AddressBook
	// FUN_VAB verifyAddressBook
	public static String FUN_VAB = "Verify address book of my account";
	// FUN_AAD addAddress
	public static String FUN_AAD = "Add address to address book";
	// FUN_PAB populateAddressBook
	public static String FUN_PAB = "Populate the address fields";
	// FUN_RAD removeAddress
	public static String FUN_RAD = "Remove address from address book";

	// ProfileSettings
	// FUN_VPS verifyProfileSettings
	public static String FUN_VPS = "Verify the profile settings page";
	// FUN_CPW changePassword
	public static String FUN_CPW = "Test change password option of profile settings";
	// FUN_CEM changeEmail
	public static String FUN_CEM = "Test change email option of profile settings";
	// FUN_EPR editProfile
	public static String FUN_EPR = "Test edit profile option of profile settings";

	// OrderHistory
	// FUN_VOH verifyOrderHistory
	public static String FUN_VOH = "Verify the order history page";
	// FUN_VOD verifyOrderDetails
	public static String FUN_VOD = "Verify the order details of each order in order history";

	/** BAG */

	// TestAddToCart
	// FUN_ASP addSpecificProductToCart
	public static String FUN_ASP = "Adding a specific product to cart";
	// FUN_AGC addGiftCertificateToCart
	public static String FUN_AGC = "Adding a gift certificate to cart";
	// FUN_APC addProductsToCart
	public static String FUN_APC = "Adding a list of products to cart";

	// TestCartItems
	// FUN_UIQ testUpdateItemQuantity
	public static String FUN_UIQ = "Update the quntity of a product in shopping bag";

	// ShoppingBag
	// FUN_VSB verifyShoppingBag
	public static String FUN_VSB = "Verify Shopping Bag page";
	// FUN_VSA verifySamples
	public static String FUN_VSA = "Verify Samples section of shopping bag";
	// FUN_VPD verifyProducts
	public static String FUN_VPD = "Verify Products in shopping bag";
	// FUN_VGW verifyGiftWrap
	public static String FUN_VGW = "Verify Gift Wrap section of shopping bag";
	// FUN_VSM verifySummary
	public static String FUN_VSM = "Verify Summary in shopping bag";
	// FUN_VPSM verifyPromoSummary
	public static String FUN_VPSM = "Verify Summary in shopping bag when promotion is applied";
	// FUN_VPR verifyPromotion
	public static String FUN_VPR = "Verify Promotion in shopping bag";

	/** SHIPPING */

	// ShippingAddress
	// FUN_VSHA verifyShippingAddress
	public static String FUN_VSHA = "Add first shipping address in Checkout-shipping page";
	// FUN_VSHA2 verifyShippingAddress2
	public static String FUN_VSHA2 = "Add a shipping address to the list of available addresses in Checkout-shipping page";
	// FUN_VSHA3 verifyShippingAddress3
	public static String FUN_VSHA3 = "Select a shipping address from the available list of shipping addresses in Checkout - Shipping page";
	// FUN_VSHA4 verifyShippingAddress4
	public static String FUN_VSHA4 = "Add an international shipping address to the list of available addresses in Checkout-shipping page";

	// TestShippingOption
	// FUN_SSHO testSelectShippingOption
	public static String FUN_SSHO = "Select a shipping option";

	// TestShippingAddress
	// FUN_AFSHA testAddFirstShippingAddress
	public static String FUN_AFSHA = "Populate shipping address fields of thr first address";
	// FUN_ASHA testAddShippingAddress
	public static String FUN_ASHA = "Populate the shipping address fields";
	// FUN_SSHA testSelectShippingAddress
	public static String FUN_SSHA = "Select a shipping address from the list";

	/** PAYMENT */

	// TestPaymentSection
	// FUN_PY testPaymentSection
	public static String FUN_PY = "Verify the edit button of payment section in order review page";
	// FUN_EPY testEditPayment
	public static String FUN_EPY = "Edit payment details from order review page";
	// FUN_EPB testEditPaymentBilling
	public static String FUN_EPB = "Modify payment details";
	// FUN_REP testReviewEGiftPayment
	public static String FUN_REP = "Verify the payment section in order review page when egift in cart";
	// FUN_RPY testReviewPayment
	public static String FUN_RPY = "Review payment details of Order Review page";

	// TestCreditCard
	// FUN_AFCC testAddFirstCreditCard
	public static String FUN_AFCC = "Add first credit card";
	// FUN_ACC testAddCreditCard
	public static String FUN_ACC = "Add a credit card to the list of credit cards";
	// FUN_SCC testSelectCreditCard
	public static String FUN_SCC = "Select a credit card from list of credit cards";

	// TestGiftCard
	// FUN_AGCD testAddGiftCard
	public static String FUN_AGCD = "Add a gift card";
	// FUN_CGCB testCheckGiftCardBalance
	public static String FUN_CGCB = "Check gift card balance";
	// FUN_RGCD testRemoveGiftCard
	public static String FUN_RGCD = "Remove gift card";

	// TestBillingAddress
	// FUN_BA testBillingAddress
	public static String FUN_BA = "Verify adding/selecting billing address";
	// FUN_ABA testAddBillingAddress
	public static String FUN_ABA = "Add a billing address";
	// FUN_SBA testSelectNewBillingAddress
	public static String FUN_SBA = "Select a billing address";

	// PaymentOption
	// FUN_VPO verifyPaymentOption
	public static String FUN_VPO = "Verify Payment option by selecting Credit card";
	// FUN_VPO2 verifyPaymentOption2
	public static String FUN_VPO2 = "Verify payment option by adding a gift card";

	/** CONFIRMATION */

	// TestOrderConfirmation
	// FUN_VOC verifyOrderConfirmation
	public static String FUN_VOC = "Verify the order confirmation page";

	/** REVIEW */

	// TestShippingSection
	// FUN_SH testShippingSection
	public static String FUN_SH = "Verify the edit button of shipping section in order review page";
	// FUN_RSH testReviewShipping
	public static String FUN_RSH = "Review shipping details of Order Review page";
	// FUN_ESH testEditShipping
	public static String FUN_ESH = "Edit shipping details from order review page";

	// ReviewOrder
	// FUN_VRO1 verifyReviewOrder1
	public static String FUN_VRO1 = "Verify Review order and edit button of shipping and payment section";
	// FUN_VRO2 verifyReviewOrder2
	public static String FUN_VRO2 = "Verify Review order page";
	// FUN_VRO3 verifyReviewOrder3
	public static String FUN_VRO3 = "Verify Review order and edit shipping and payment section separately";
	// FUN_VRO4 verifyReviewOrder4
	public static String FUN_VRO4 = "Verify review order and edit shipping and payment";
	// FUN_VERO verifyEGiftReviewOrder
	public static String FUN_VERO = "Verify Review order when EGift Certificate only in cart";
	// FUN_VGRO verifyGuestReviewOrder
	public static String FUN_VGRO = "Verify Review Order for guest checkout";

	// TestCreateAccount
	// FUN_CAC testCreateAccount
	public static String FUN_CAC = "Create account on checkout";

	// TestReviewOrder
	// FUN_RO testReviewOrder
	public static String FUN_RO = "Verify checkbox when address is international";
	// FUN_GRO testGuestReviewOrder
	public static String FUN_GRO = "Verify checkbox when address is international for guest checkout";

	/** SUMMARY */

	// TestSummary
	// FUN_S testSummary
	public static String FUN_S = "Verify Summary";
	// FUN_BS testBagSummary
	public static String FUN_BS = "Verify summary in shopping bag page";
	// FUN_ES testEgiftSummary
	public static String FUN_ES = "Verify summary when Gift certificate is in cart";

	// TestItems
	// FUN_IT testItems
	public static String FUN_IT = "verify items section of summary";
	// FUN_EIT testEgiftItem
	public static String FUN_EIT = "Verify items section of summary for egift";

	// doubt this method has no pass condition: verifyShoppingBag

	

}
