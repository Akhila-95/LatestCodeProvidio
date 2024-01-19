package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CheckOutPage2;

public class CheckOutPage2Validation extends baseClass{

	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	
	public static void customerInfoValidationInCOP2_Page() {
		 test.info("Verifying the customer information is displayed in checkout 2 page ");
		 if(Actionsss.displayElement(cop2.getCustomerInfo())) {
			 logger.info("Customer information is displayed in check out page 2");
			 test.pass("Customer information is displayed in check out page 2");
		 }else {
			 logger.info("No Customer information is displayed in check out page 2");
			 test.pass("No Customer information is displayed in check out page 2");
		 }
	}
	
	public  void editEmailValidation() {
		test.info("Verify that the email ID is being edited on checkout page 2");
		if(guestmail.equals(editedEmail)) {
			test.pass("Successfully email id is edited the previous email is " +guestmail +" and edited email is "+ editedEmail);
			logger.info("Successfully email id is edited the previous email is " +guestmail +" and edited email is "+ editedEmail);
		}else {
			test.fail("Email id is not edited the previous email is " +guestmail +" and edited email is "+ editedEmail);
			logger.info("Email id is not edited the previous email is " +guestmail +" and edited email is "+ editedEmail);
		}
	}
	public static void shippingDetailValidationInCop2_Page() {
		test.info("Verifying the shipping details form  is displayed in checkout 2 page ");
		 if(Actionsss.displayElement(cop2.getshippingInfo())) {
			 logger.info("shipping details form  is displayed in check out page 2");
			 test.pass("shipping details form is displayed in check out page 2");
		 }else {
			 logger.info("No shipping details form is displayed in check out page 2");
			 test.pass("No shipping details form is displayed in check out page 2");
		 }
	}
	
	public static void orderSummaryValidationInCop2_Page() {
		test.info("Verifying the orderSummary display in checkout 2 page ");
		 if(Actionsss.displayElement(cop2.getOrderSummaryDiv())) {
			 logger.info("orderSummary  is displayed in check out page 2");
			 test.pass("orderSummary  is displayed in check out page 2");
		 }else {
			 logger.info("No orderSummary  is displayed in check out page 2");
			 test.pass("No orderSummary  is displayed in check out page 2");
		 }
	}
	
	public static void bactToCartValidationInCop2_Page() {
		test.info("Verifying the back to cart  display in checkout 2 page ");
		 if(Actionsss.displayElement(cop2.getBackToCart())) {
			 logger.info("Back to cart is displayed in check out page 2");
			 test.pass("Back to cart is displayed in check out page 2");
		 }else {
			 logger.info("No Back to cart  is displayed in check out page 2");
			 test.pass("No Back to cart  is displayed in check out page 2");
		 }
	}
	
	public static void nextPaymentButtonValidationInCop2_Page() {
		test.info("Verifying the Next Payment Button   display in checkout 2 page ");
		 if(Actionsss.displayElement(cop2.getNextPaymentButton())) {
			 logger.info("Next Payment Button  is displayed in check out page 2");
			 test.pass("Next Payment Button  is displayed in check out page 2");
		 }else {
			 logger.info("No Next Payment Button  is displayed in check out page 2");
			 test.pass("No Next Payment Button  is displayed in check out page 2");
		 }
	}
	
	public static void etgLogoValidationInCop2_Page() {
		test.info("Verifying the  etg logo display in checkout 2 page ");
		 if(Actionsss.displayElement(cop2.getOrderSummaryDiv())) {
			 logger.info(" Etg logo  is displayed in check out page 2");
			 test.pass(" Etg logo is displayed in check out page 2");
		 }else {
			 logger.info("No etg logo  is displayed in check out page 2");
			 test.pass("No  etg logo  is displayed in check out page 2");
		 }
	}
}
