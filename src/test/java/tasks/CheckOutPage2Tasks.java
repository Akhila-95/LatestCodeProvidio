package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutPage2;
import pageObjects.CheckOutPage3;
import validations.ShippingPageValidation;

public class CheckOutPage2Tasks extends baseClass{

	private static final CheckOutPage3 cop3 = new CheckOutPage3(driver);
	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static final ShippingPageValidation shipping = new ShippingPageValidation();

	
	public static void checkOutPage2() throws InterruptedException, Exception {
		
		if(Actionsss.elementSize(cop2.getshippingPageList())) {
			if(Actionsss.displayElement(cop2.getshippingPage()))
			logger.info("Shipping page alreday loaded");
		}else {
			CheckOutPageTasks.GuestMailCheckOut();
		}
	}
	
	public static void getCutomerInfo() throws Exception {	
		checkOutPage2();
		ShippingPageValidation.customerInfoValidationInCOP2_Page();
	}
	
	public static void editEmailInCheckoutPage2() throws Exception {
		checkOutPage2();
	//	Thread.sleep(2000);
		if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {	
			Thread.sleep(1000);
			previousMail=Actionsss.getTextOfElement(cop3.getEditCustomerInfo());
			logger.info(previousMail);
			Actionsss.click(cop2.getEditCustomerInfo());			
			 Faker faker = new Faker();
			 String randomFirstName = faker.name().firstName(); 
		     String editedEmailInCop2 = randomFirstName + "EditedFromCOP2@etg.digital"; 
		     emailEditedInCop2 =editedEmailInCop2;
		     logger.info(emailEditedInCop2);
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(),  emailEditedInCop2, "Edited email");			
			Actionsss.click(CP.getSelectContinueasGuesttBtn());
			editedEmailFromCop3= Actionsss.getTextOfElement(cop3.getEditCustomerInfo());
			shipping.editEmailValidationInCOP2();
		}else {			
			test.info("User is checked in as registered so edit button ");
			test.pass("No edit button to edit cutomer info for registered user");
		}		
	}
	
	public static void paginationOfProductsInCheckOutPage2() throws InterruptedException, Exception {
		checkOutPage2();
		Actionsss.randomElementFromList(cop2.getproductsInCheckoutPage2());
		ShippingPageValidation.pdpPageValidation();
		ViewCartPageTasks.viewCartpage();
		CheckOutPageTasks.GuestMailCheckOut();
		//CheckOutPage2Tasks.enterValidAddress();
	}
	
	public static void getBackToCart() throws Exception {	
		 checkOutPage2();
		 ShippingPageValidation.bactToCartValidationInCop2_Page();
		 Actionsss.click(cop2.getBackToCart());				
		 CheckOutPageTasks.guestCheckout();
		 ShippingPageValidation.bactToCartValidationInCop2_Page();
		
	}
	
	public void  getshippingInfo() throws Exception {
		 checkOutPage2();
		 ShippingPageValidation.shippingDetailValidationInCop2_Page();		
	}
	
	public static void getOrderSummary() throws Exception {
		checkOutPage2();
		ShippingPageValidation.orderSummaryValidationInCop2_Page();		
	}
	
	public static void getNextPaymentButton() throws Exception {	
		 checkOutPage2();
		 ShippingPageValidation.nextPaymentButtonValidationInCop2_Page();		
	}
	
	public static void getEtgLogo() throws Exception {
		 checkOutPage2();
		 ShippingPageValidation.etgLogoValidationInCop2_Page();
	
	}
	
	public static void allErrorsInShippingForm() throws InterruptedException, Exception {
		 checkOutPage2();
		 ShippingPageValidation.negativeValidationForShippingAddress();
	}
	public static void firstNameError() throws Exception	{	
		 checkOutPage2();
		 ShippingPageValidation.firstNameError();		
	}
	
	public static void lastNameError() throws Exception {
		 checkOutPage2();
		 ShippingPageValidation.lastNameError();		
	}
	public static void addressError() throws Exception {
		 checkOutPage2();
		 ShippingPageValidation.addressMessageError();
		}
	public static void phoneNumberError() throws Exception {
		 checkOutPage2();
		 ShippingPageValidation.phoneNumberError();	
	}
	public static void giftMessage() throws InterruptedException, Exception {
		checkOutPage2();
		
}
	public static void enterValidAddress() throws Exception {
			checkOutPage2();
			AddressSelection.Address();	
			Thread.sleep(2000);
			Actionsss.CombinedClick(cop2.getNextPaymentButton());	
			Thread.sleep(1000);
			ShippingPageValidation.VerifiedThatNextpaymentBtnClick();	
	}
	
	
}
