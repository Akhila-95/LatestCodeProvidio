package tasks;

import com.providio.testcases.baseClass;

import CreditCardPayment.CreditCardDetails;
import PaymentProccess.CommonProccessUptoCheckout;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.CheckOutPage;
import pageObjects.PaymentPageObjects;
import pageObjects.ProductDetailPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.CheckOutPageValidation;
import validations.OrderPageValidation;

public class ProductsAndItsOrdersTasks extends baseClass  {

	private static final ProductDetailPage pdp = new  ProductDetailPage(driver);
	private static final loginPage lp = new loginPage(driver);
	private static homepage homePage = new homepage(driver);
	private static final String Email = "GuestEmail";
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);

	
	public static void OnlyGcInCartWithCreditCard() throws Exception {	
		test.info("Verifying the place order of only gift certificate in cart using credit card payment");
			GiftCertificatePageTasks.giftCertificateForm();	
			CommonProccessUptoCheckout.commonCheckoutProccess();
			
			CreditCardDetails.creditCardDetails();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.validatePlacetheOrderPage();
			OrderPageValidation.orderNumberAndOrderDate();	
			
			Actionsss.javascriptClick(homePage.clickOnLogo());
	}

	
	public static void OnlyGcInCartWithPaypal() throws Exception {
		test.info("Verifying the place order of only gift certificate in cart using paypal payment");
		GiftCertificatePageTasks.giftCertificateForm();	
		CommonProccessUptoCheckout.commonCheckoutProccess();		
		PlaceOrderWithDifferentPayments.orderPlacingWithPaypalFromCheckoutPage();  	
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	

	public static void gcInCartNoGcSectionVisible() throws Exception {
		test.info("Verifying no gift certificate section is visible when gift certificate in cart");
		GiftCertificatePageTasks.giftCertificateForm();	
		CommonProccessUptoCheckout.commonCheckoutProccess();
		Thread.sleep(1000);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
			 test.fail("Though gift certificate in cart,Gift ceritificate section is visible");
		 }else {
			 test.pass("Gift certificate is in cart ,so no Gift certificate section is visible ");
		 }
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void placeOrderOfcombinationOfGcAndSimpleProductWithPaypal() throws Exception {
		test.info("Verifying the place order of gift certificate and simple product in cart using paypal payment");
		GiftCertificatePageTasks.giftCertificateForm();	
		CommonProccessUptoCheckout.commonCheckoutProccess();		
		PlaceOrderWithDifferentPayments.orderPlacingWithPaypalFromCheckoutPage();  	
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	
	public static void placeOrderOfcombinationOfGcAndSimpleProductWithCreditCard() throws Exception {
		test.info("Verifying the place order of gift certificate and simple product in cart using credit card payment");
		ProductListingPageTasks.simpleProductsGloves();
		allAttributesSelection.selectTheAttributesInPdp();
		GiftCertificatePageTasks.giftCertificateForm();	
		CommonProccessUptoCheckout.commonCheckoutProccess();		
		CreditCardDetails.creditCardDetails();
		ReviewOrderPageTask.placeOrder();
		OrderPageValidation.validatePlacetheOrderPage();
		OrderPageValidation.orderNumberAndOrderDate();	
		Actionsss.javascriptClick(homePage.clickOnLogo());
	}

	public static void pdpPagebuyNowButton() throws Exception {	
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdp();
		 Actionsss.scrollWindowsByPixel(150);
		 Thread.sleep(3000);
		 Actionsss.javascriptClick(pdp.getBuyNowButton());
		 Thread.sleep(2000);
		 CheckOutPageTasks.GuestMailCheckOut();
		 ShippingPageTasks.enterValidAddress();
		 PaymentPageTasks.creditCardWithValidDetails();
		 ReviewOrderPageTask.placeOrder();
		 OrderPageValidation.paymentInOrderConfirmationPage();
		 OrderDetailPageTasks.getOrderConfirmationPage();
		 
		 Actionsss.javascriptClick(homePage.clickOnLogo());
		}
	
	public static void pdpPageBuyNowPopUp() throws Exception {
		 LoginPageTasks.verifyThatuserLogin();
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdpForBuyNow();		
		 Thread.sleep(3000);
		 if(Actionsss.elementSize(CP. getSelectGuestCheckoutBtnList())) {	
				test.info("User logged in as guest");
				Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());		
				Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);		
				Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
				CheckOutPageValidation.VerifiedThatGuestLogin();
				ShippingPageTasks.enterValidAddress();
				PaymentPageTasks.creditCardWithValidDetails();
				ReviewOrderPageTask.placeOrder();
				OrderPageValidation.paymentInOrderConfirmationPage();
				OrderDetailPageTasks.getOrderConfirmationPage();
			}else {
				test.info("User logged in as registered");
				Thread.sleep(2000);
				Actionsss.click(pdp.getplaceOrderInBuyNow());	
				test.info("Verifying order placing through buy now button");
				OrderPageValidation.paymentInOrderConfirmationPage();
				OrderDetailPageTasks.getOrderConfirmationPage();
			}		 	 
		 Actionsss.javascriptClick(homePage.clickOnLogo());
	}
}
