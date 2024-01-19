package tasks;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutPage2;
import validations.CheckOutPage2Validation;
import validations.MiniCartValidation;


public class CheckOutPageTask2 extends baseClass {
	
	boolean CheckOutPage2 = false;
	
	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	private static final CheckOutPageTasks  copt = new CheckOutPageTasks ();
	private static final CheckOutPage2Validation cop2v = new CheckOutPage2Validation();
	private static CheckOutPage CP = new CheckOutPage(driver);

	public  static void checkOutPage2() throws Exception {	
		if(Actionsss.elementSize(cop2.getshippingPage())) {
			logger.info("Shipping page alreday loaded");
		}else {
			CheckOutPageTasks.GuestMailCheckOut();
		}
	
	}	
	public  static  void getCutomerInfo() throws Exception {	
			checkOutPage2();
			CheckOutPage2Validation.customerInfoValidationInCOP2_Page();
	}
	public static  void editEmailInCheckoutPage2() throws Exception {
			checkOutPage2();
			Thread.sleep(2000);
			if(Actionsss.displayElement(CP.getSelectGuestCheckoutBtn())) {			
				Actionsss.click(cop2.getEditCustomerInfo());
				//logger.info(editedEmail);
				 Faker faker = new Faker();
				 String randomFirstName = faker.name().firstName(); 
			     String editedEmail = randomFirstName + "Edited@etg.digital";    
				Actionsss.sendKeys(CP.getSelectGuestEmailInput(), editedEmail, "Edited email");
				Actionsss.click(CP.getSelectContinueasGuesttBtn());
				cop2v.editEmailValidation();
			}else {			
				logger.info("User is checked in as registered");
			}		
	}

	public  void getBackToCart() throws Exception {	
		 checkOutPage2();
		 CheckOutPage2Validation.bactToCartValidationInCop2_Page();
		 Actionsss.click(cop2.getBackToCart());
		 MiniCartValidation.VerifiedThatCheckOutBtnClick();			
		 CheckOutPageTasks.guestCheckout();
		 CheckOutPage2Validation.bactToCartValidationInCop2_Page();
		
	}
	
	public void  getshippingInfo() throws Exception {
		 checkOutPage2();
		 CheckOutPage2Validation.shippingDetailValidationInCop2_Page();		
	}
	
	public void getOrderSummary() throws Exception {
		checkOutPage2();
		CheckOutPage2Validation.orderSummaryValidationInCop2_Page();		
	}
	
	public  void getNextPaymentButton() throws Exception {	
		 checkOutPage2();
		 CheckOutPage2Validation.nextPaymentButtonValidationInCop2_Page();
		
	}
	
	
	public  void getEtgLogo() throws Exception {
		 checkOutPage2();
		 CheckOutPage2Validation.etgLogoValidationInCop2_Page();
	
	}
}
