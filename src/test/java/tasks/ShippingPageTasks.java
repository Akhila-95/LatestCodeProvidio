package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import data.AddressSelection;
import data.PaymentDetails;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutPage2;
import pageObjects.CheckOutPage3;
import pageObjects.ShippingAddressPage;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.ShippingPageValidation;

public class ShippingPageTasks extends baseClass{

	private static final CheckOutPage3 paymentpage = new CheckOutPage3(driver);
	private static final CheckOutPage2 shippingPage = new CheckOutPage2(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final ShippingPageValidation shipping = new ShippingPageValidation();
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static homepage homePage = new homepage(driver);
	
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
		     String editedEmailInCop2 = randomFirstName + "EditedFromCOP2@etg.digital"; 
		     emailEditedInCop2 =editedEmailInCop2;
		     logger.info(emailEditedInCop2);
			 Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop2, "Edited email");			
			 Actionsss.click(CP.getSelectContinueasGuesttBtn());
			 editedEmailFromCop3= Actionsss.getTextOfElement(paymentpage.getEditCustomerInfo());
			 shipping.editEmailValidationInCOP2();
			 ShippingPageTasks.enterValidAddress();
			 PaymentDetails.creditCardDetails();
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
		 ShippingPageValidation.bactToCartValidationInCop2_Page();
		
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
			//if(Actionsss.displayElement(SAP.getShippingToDisplay()) && Actionsss.displayElement(SAP.getSaveShippingAddress()) && Actionsss.elementSize(SAP.getsavedShippingAddressList())) {
				 String previousShippingaddress =SAP.getShippingAddress().getAttribute("value");
				 previousShippingAddress= previousShippingaddress;
				 Actionsss.click(shippingPage.getAddNewShippingAddress());
				 AddressSelection.shippingAddressDetailsWithName();
				 String newUpdatedShippingaddress =SAP.getShippingAddress().getAttribute("value");
				 newlyAddedShippingAddress= newUpdatedShippingaddress;
				 ShippingPageValidation.verifyingAddNewShippingAddress();
				
				 Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
				 Thread.sleep(1000);
				 ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
				 Thread.sleep(500);
				 Actionsss.click(homePage.clickOnLogo());
			//}
		}else {
				test.info("user logged in as guest");
				test.pass("No Add new address button");
		}
	}
	
	public static void updateNewShippingAddress() throws InterruptedException, Exception {
		shippingPage();
		if(!Actionsss.elementSize(CP.getGuestCheckout())) {	
			//if(Actionsss.displayElement(SAP.getShippingToDisplay()) && Actionsss.displayElement(SAP.getSaveShippingAddress()) && Actionsss.elementSize(SAP.getsavedShippingAddressList())) {
				Actionsss.click(shippingPage.getUpdateShippingAddress());
				Thread.sleep(2000);

		        String previousShippingaddress =SAP.getShippingAddress().getAttribute("value");
				previousShippingAddressInUpdate=previousShippingaddress ;
				logger.info(previousShippingAddressInUpdate);
				AddressSelection.updateShippingAddress();
				 String newUpdatedShippingaddress =SAP.getShippingAddress().getAttribute("value");
				updateShippingAddress =newUpdatedShippingaddress;
				logger.info(updateShippingAddress);
				ShippingPageValidation.verifyingTheUpdateShippingAddress();
				
				Actionsss.CombinedClick(shippingPage.getNextPaymentButton());	
				Thread.sleep(1000);
				ShippingPageValidation.VerifiedThatNextpaymentBtnClick();
				Thread.sleep(500);
				Actionsss.click(homePage.clickOnLogo());
			//	}
		}else {
			test.info("user logged in as guest");
			test.pass("No update address button");
			logger.info("user logged in as guest ");
		}
	}
}
