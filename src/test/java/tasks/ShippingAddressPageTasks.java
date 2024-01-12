package tasks;

import com.providio.testcases.baseClass;

import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.MiniCartPage;
import pageObjects.ShippingAddressPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;
import validations.ShippingAddressPageValidation;

public class ShippingAddressPageTasks extends baseClass{
	
	private static final String Email = "GuestEmail";
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static homepage homePage = new homepage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	protected static boolean  shippingAddressPage  =false;

	public static void EnteringShippingDetails() throws Exception {
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
		Actionsss.click(homePage.clickOnLogo());
		Thread.sleep(2000);
	}

	public static void shippingDetails() throws Exception {
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
		
		shippingAddressPage=true;
	}
	
	public static void allErrorsInShippingForm() throws Exception {		
		if(shippingAddressPage) {			
			AddressSelection.negativeValidationForShippingAddress();
		}	
	}
	public static void firstNameError() throws Exception	{
		if(shippingAddressPage) {
			AddressSelection.firstNameError();
		}
	}
	public static void lastNameError() throws Exception {
		if(shippingAddressPage) {
			AddressSelection.lastNameError();
		}
	}
	public static void addressError() throws Exception {
		if(shippingAddressPage) {
			AddressSelection.addressMessageError();
		}
	}
	
	public static void phoneNumberError() throws Exception {
		if(shippingAddressPage) {
			AddressSelection.phoneNumberError();
		}
	}
	public static void enterValidAddress() throws Exception {
		if(shippingAddressPage) {
			AddressSelection.Address();			
			Actionsss.CombinedClick(SAP.getSelectNextPaymentBtn());
			Thread.sleep(2000);
			ShippingAddressPageValidation.VerifiedThatNextpaymentBtnClick();
			Thread.sleep(2000);
			Actionsss.click(homePage.clickOnLogo());
			Thread.sleep(2000);
		}
	}
}
