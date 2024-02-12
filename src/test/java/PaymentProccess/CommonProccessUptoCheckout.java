package PaymentProccess;

import com.providio.testcases.baseClass;

import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.MiniCartPage;
import pageObjects.ShippingPageObject;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;
import validations.ShippingPageValidation;

public class CommonProccessUptoCheckout extends baseClass {
	
	private static homepage homePage = new homepage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static ShippingPageObject shippingPage = new ShippingPageObject(driver);
	
	public static void commonCheckoutProccess() throws Exception {
		
		Actionsss.click(homePage.getMiniCartLink());
    	MiniCartValidation.VerifiedThatMinicartBtnClick();
    	Actionsss.click(MCP.getSelectviewCartBtn());
    	MiniCartValidation.VerifiedThatViewcartBtnClick();
    	
    	Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		
		if(Actionsss.elementSize(CP. getSelectGuestCheckoutBtnList())) {	
			test.info("User is guest");
			Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
			Thread.sleep(1000);
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, "email");
			Thread.sleep(1000);
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			 CheckOutPageValidation.verifyingThatGuestLoginForGc();			
		}else {
			test.info("User is registered");
		}		
		addressForm();			
	}
	
	public static void addressForm() throws InterruptedException, Exception {
		Thread.sleep(1000);
		if(Actionsss.elementSize(shippingPage.getshippingPageList()) && Actionsss.elementSize(shippingPage.getNextPaymentButtonList())) {
			if(Actionsss.displayElement(shippingPage.getshippingPage()) && Actionsss.displayElement(shippingPage.getNextPaymentButton())) {
				logger.info("gc and products in cart");
				AddressSelection.Address();
			}
		}else {
			AddressSelection.selectBillingAddress();		
		}
		
		Thread.sleep(2000);
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
		Thread.sleep(1000);
		ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
	}
}
