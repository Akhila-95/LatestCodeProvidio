package tasks;

import com.providio.testcases.baseClass;

import data.AddressSelection;
import data.PaymentDetails;
import data.PaymentDetailsofGuestandReg;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.MiniCartPage;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;
import validations.PaymentPageValidation;
import validations.ShippingAddressPageValidation;

public class PaymentPageTasks extends baseClass{
	private static final String Email = "GuestEmail";
	private static PaymentPage PMP = new PaymentPage(driver);
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static homepage homePage = new homepage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static boolean  paymentPage= false;
	
	public static void EnteringPaymentDetails() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.click(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
		Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);
		Thread.sleep(1000);
		Actionsss.click(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.VerifiedThatGuestLogin();
		Thread.sleep(2000);
		AddressSelection.Address();
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
		PaymentDetails.payment();
		Actionsss.CombinedClick(PMP.getSelectPlaceOrderBtn());
		Thread.sleep(5000);
		PaymentPageValidation.VerifiedThatPlaceOrderClick();
		Thread.sleep(2000);
		
	}
	
	public static void paymentDetails() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.click(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
		Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		Actionsss.click(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);
		Thread.sleep(1000);
		Actionsss.click(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.VerifiedThatGuestLogin();
		Thread.sleep(2000);
		AddressSelection.Address();
		Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
		Thread.sleep(2000);
		ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
		Thread.sleep(2000);
		 paymentPage= true;
	}
	
	public static void allErrorsInCreditCard() throws Exception {
		if(paymentPage) {
			PaymentDetailsofGuestandReg.allErrorsInCreditCard();
		}
	}
	
	public static void CreditCardCvvAndExpErrorMessage() throws Exception {
		if(paymentPage) {
			PaymentDetailsofGuestandReg.creditCardCvvAndExpError();
		}
	}

	public static void CreditCardCvvErrorMessage() throws InterruptedException {
		if(paymentPage) {
			PaymentDetailsofGuestandReg.creditCvvError();
		}
	}
	public static void  creditCardWithValidDetails() throws Exception {
		if(paymentPage) {
			PaymentDetails.positiveCreditCardDetails();
		}
	}
}
