package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import CreditCardPayment.CreditCardDetails;
import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.PaymentPageObjects;
import pageObjects.ShippingPageObject;
import validations.OrderPageValidation;
import validations.ShippingPageValidation;

public class ShippingPageTasks extends baseClass{

	private static final PaymentPageObjects paymentpage = new PaymentPageObjects(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final ShippingPageValidation shipping = new ShippingPageValidation();	
	private static ShippingPageObject shippingPage = new ShippingPageObject(driver);
	
	public static void shippingPage() throws InterruptedException, Exception {
		if(Actionsss.elementSize(shippingPage.getshippingPageList()) && Actionsss.elementSize(shippingPage.getNextPaymentButtonList())) {
			if(Actionsss.displayElement(shippingPage.getshippingPage()) && Actionsss.displayElement(shippingPage.getNextPaymentButton())) {
				logger.info("Shipping page alreday loaded");
			}
		}else {
			CheckOutPageTasks.GuestMailCheckOut();
		}
	}
	public static void getCutomerInfo() throws Exception {	
		shippingPage();
		ShippingPageValidation.customerInfoValidationInCOP2_Page();
	}
	
	public static void editEmailInCheckoutPage2() throws Exception {
		shippingPage();
	//	Thread.sleep(2000);
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {	
			Thread.sleep(1000);
			previousMail=Actionsss.getTextOfElement(paymentpage.getEditCustomerInfo());
			logger.info(previousMail);
			Actionsss.click(shippingPage.getEditCustomerInfo());			
			 Faker faker = new Faker();
			 String randomFirstName = faker.name().firstName(); 
		     String editedEmailInCop2 = randomFirstName + "EditedFromShippingPage@etg.digital"; 
		     emailEditedInCop2 =editedEmailInCop2;
		     logger.info(emailEditedInCop2);
			 Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop2, "Edited email");			
			 Actionsss.click(CP.getSelectContinueasGuesttBtn());
			 editedEmailFromCop3= Actionsss.getTextOfElement(paymentpage.getEditCustomerInfo());
			 shipping.editEmailValidationInCOP2();
			 ShippingPageTasks.enterValidAddress();
			 CreditCardDetails.creditCardDetails();
			 ReviewOrderPageTask.placeOrder();
			 OrderPageValidation.validatePlacetheOrderPage();
			 OrderPageValidation.orderNumberAndOrderDate();		
			
		}else {			
			test.info("User is checked in as registered so edit button ");
			test.pass("No edit button to edit cutomer info for registered user");
		}		
	}
	
	public static void paginationOfProductsInCheckOutPage2() throws InterruptedException, Exception {
		shippingPage();
		Actionsss.randomElementFromList(shippingPage.getproductsInCheckoutPage2());
		ShippingPageValidation.pdpPageValidation();
		ViewCartPageTasks.viewCartpage();
		CheckOutPageTasks.GuestMailCheckOut();
		//CheckOutPage2Tasks.enterValidAddress();
	}
	
	public static void getBackToCart() throws Exception {	
		 shippingPage();
		 ShippingPageValidation.bactToCartValidationInCop2_Page();
		 Actionsss.click(shippingPage.getBackToCart());				
		 CheckOutPageTasks.guestCheckout();
		// ShippingPageValidation.bactToCartValidationInCop2_Page();
		
	}
	
	public void  getshippingInfo() throws Exception {
		 shippingPage();
		 ShippingPageValidation.shippingDetailValidationInCop2_Page();		
	}
	
	public static void getOrderSummary() throws Exception {
		shippingPage();
		ShippingPageValidation.orderSummaryValidationInCop2_Page();		
	}
	
	public static void getNextPaymentButton() throws Exception {	
		 shippingPage();
		 ShippingPageValidation.nextPaymentButtonValidationInCop2_Page();		
	}
	
	public static void getEtgLogo() throws Exception {
		 shippingPage();
		 ShippingPageValidation.etgLogoValidationInCop2_Page();
	
	}
	
	public static void allErrorsInShippingForm() throws InterruptedException, Exception {
		 shippingPage();
		 ShippingPageValidation.negativeValidationForShippingAddress();
	}
	
	public static void firstNameError() throws Exception	{	
		 shippingPage();
		 ShippingPageValidation.firstNameError();		
	}
	
	public static void lastNameError() throws Exception {
		 shippingPage();
		 ShippingPageValidation.lastNameError();		
	}
	
	public static void addressError() throws Exception {
		 shippingPage();
		 ShippingPageValidation.addressMessageError();
	}
	
	public static void phoneNumberError() throws Exception {
		 shippingPage();
		 ShippingPageValidation.phoneNumberError();	
	}
	
	public static void giftMessage() throws InterruptedException, Exception {
		shippingPage();
		
	}
	
	public static void enterValidAddress() throws Exception {
		shippingPage();
		AddressSelection.Address();	
		Thread.sleep(2000);
		Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
		Thread.sleep(1000);
		ShippingPageValidation.VerifiedThatNextpaymentBtnClick();	
	}
	
	public static void addNewAddress() throws InterruptedException, Exception {
		shippingPage();
		if(!Actionsss.elementSize(CP.getGuestCheckout())) {
			/*if(Actionsss.elementSize(shippingPage.getShippingToLabelList())) {
				if(Actionsss.displayElement(shippingPage.getShippingToLabel())) {
					logger.info("User have saved address but not displaying the add new addresss etc");
				}
			}*/
			
			if(!Actionsss.displayElement(shippingPage.getAddNewShippingAddress())) {
				//AddressSelection.Address();			
				test.info("No saved address for this user to add new shipping address");
			}else {
			//if(Actionsss.displayElement(shippingPage.getShippingToDisplay()) && Actionsss.displayElement(shippingPage.getSaveShippingAddress()) && Actionsss.elementSize(shippingPage.getsavedShippingAddressList())) {
				 String previousShippingaddress =shippingPage.getShippingAddress().getAttribute("value");
				 previousShippingAddress= previousShippingaddress;
				 Actionsss.click(shippingPage.getAddNewShippingAddress());
				 AddressSelection.addNewShippingAddressWithName();
				 Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
				 Thread.sleep(1000);
				 ShippingPageValidation.VerifiedThatNextpaymentBtnClick();				 
				 Thread.sleep(1500);
				 String addAddress=Actionsss.getTextOfElement(shippingPage.getshipingAdrressInPaymentPage());
				 newlyAddedShippingAddress= addAddress; //Actionsss.getTextOfElement(shippingPage.getshipingAdrressInPaymentPage());
				 ShippingPageValidation.verifyingAddNewShippingAddress();
				 PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
			}
		}else {
				test.info("user logged in as guest");
				test.pass("No Add new address button");
		}
	}
	
	public static void updateNewShippingAddress() throws InterruptedException, Exception {
		shippingPage();
		if(!Actionsss.elementSize(CP.getGuestCheckout())) {	
			if(!Actionsss.displayElement(shippingPage.getAddNewShippingAddress())) {						
				test.info("No saved address for this user to update shipping address");
			}else {
				Actionsss.click(shippingPage.getUpdateShippingAddress());
				Thread.sleep(2000);

		        String previousShippingaddress =shippingPage.getShippingAddress().getAttribute("value");
				previousShippingAddressInUpdate=previousShippingaddress ;				
				AddressSelection.updateShippingAddress();				
				Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
				Thread.sleep(1000);
				ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
				Thread.sleep(1500);
				String updateAddress=Actionsss.getTextOfElement(shippingPage.getshipingAdrressInPaymentPage());
				updateShippingAddress=updateAddress;
				ShippingPageValidation.verifyingTheUpdateShippingAddress();
				Thread.sleep(2000);
				PlaceOrderWithDifferentPayments.orderPlacingWithCreditCard();
			}
		}else {
			test.info("user logged in as guest");
			test.pass("No update address button");
			logger.info("user logged in as guest ");
		}
	}
}
