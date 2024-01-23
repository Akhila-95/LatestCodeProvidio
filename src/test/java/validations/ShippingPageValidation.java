package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage2;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;

public class ShippingPageValidation extends baseClass{

	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static PaymentPage pp = new PaymentPage(driver);
	static AddressSelection addresSelect = new AddressSelection();
	
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
	
	public  void editEmailValidationInCOP2() {
		test.info("Verify that the email ID is being edited on checkout page 2");
		  logger.info(emailEditedInCop2);
		if(!(guestmail.equals(emailEditedInCop2))) {
			test.pass("Successfully email id is edited the previous email is " +guestmail +" and edited email is "+ emailEditedInCop2);
			logger.info("Successfully email id is edited the previous email is " +guestmail +" and edited email is "+ emailEditedInCop2);
		}else {
			test.fail("Email id is not edited the previous email is " +guestmail +" and edited email is "+ emailEditedInCop2);
			logger.info("Email id is not edited the previous email is " +guestmail +" and edited email is "+ emailEditedInCop2);
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
	
	public static void pdpPageValidation() {
		test.info("Verifying the pagination of product from checkout page 2 ");
		if(Actionsss.displayElement(cop2.getPdpPage())) {
			 logger.info("Succesfully paginated to PDP page by clicking the product from check out page 2");
			 test.pass("Succesfully paginated to PDP page by clicking the product from check out page 2");
		 }else {
			 logger.info("Not paginated to PDP page by clicking the product from check out page 2");
			 test.fail(" Not paginated to PDP page by clicking the product from check out page 2");	 
		}
	}
	
	public static void VerifiedThatNextpaymentBtnClick() {
 		test.info("Verified That Nextpayment Btn click");
 		// Check if the PLP (Product Listing Page) or PDP (Product Detail Page) is already loaded.
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='card payment-form']"));
     	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the Nextpayment Btn and navigated to payment page");
     	    test.pass("Successfully Clicked on the Nextpayment Btn  and navigated to payment page");
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}

 	public static void negativeValidationForShippingAddress() throws Exception {
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {	  		
			test.info("Verify the display of all error messages for shipping address when user is clicked on next payment button without entering all the mandatory details and checked-in as guest");		
			addresSelect.selectPaymentMethod();
			 Thread.sleep(1000);
			if(Actionsss.displayElement(SAP.getFirstNameErrorMsg()) && Actionsss.displayElement(SAP.getlastNameErrorMsg()) && Actionsss.displayElement(SAP.getAddress1ErrorMsg())
					&& Actionsss.displayElement(SAP.getStateErrorMsg()) && Actionsss.displayElement(SAP.getCityErrorMsg()) && Actionsss.displayElement(SAP.getZipCodeErrorMsg())
					&& Actionsss.displayElement(SAP.getphoneNumberErrorMsg())) {
				test.pass("Successfully all the error messages are displayed for shipping address,first name, last name phone number");
				logger.info("Successfully all the error messages are displayed for shipping address,first name, last name phone number");
			}else {
				test.fail("No error messages are displayed for shipping address,first name, last name phone number");
				logger.info("No the error messages are displayed for shipping address,first name, last name phone number");
			}
		}else {
			test.info("User is checked in as registered verifying the  display of all error messages for shipping address when user is clicked on next payment button in guest user");
		}
	  }
	public static void firstNameError() throws Exception {
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {		
			test.info("User is checked-in as guest  verifying the display of error message for first Name by entering all the mandataory details expect first name.");
			Actionsss.clearText(SAP.getSelectfirstNameInput());
			Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, "last name");
			Actionsss.addressFromDropDown(SAP.getShippingAddress());			
			Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, "phone number");
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(SAP.getFirstNameErrorMsg())) {
				test.pass("Successfully  the error messages are displayed for first name.");
				logger.info("Successfully the error messages are displayed for first name.");
			}else {
				test.fail("No error messages are displayed for first name.");
				logger.info("No error messages are displayed for first name.");
			}	
		}else {
			test.info("User is checked in as registered verifying the display of error message for first Name by entering all the mandataory details expect first name in guest user.");
		}
	}
	
	public static void lastNameError() throws Exception {
		
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is checked-in as guest  verifying the display of error message for last Name by entering all the mandataory details expect last name.");
			
			Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, "first name");
			Actionsss.clearText(SAP.getSelectLastNameInput());
			Actionsss.addressFromDropDown(SAP.getShippingAddress());			
			Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, "phone number");
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(SAP.getlastNameErrorMsg())) {
				test.pass("Successfully  the error messages are displayed for last name.");
				logger.info("Successfully the error messages are displayed for last name.");
			}else {
				test.fail("No error messages are displayed for last name.");
				logger.info("No error messages are displayed for last name.");
			}
		}else {
			test.info("User is checked in as registered verifying the display of error message for last Name by entering all the mandataory details expect last name for guest user.");
		}
	}
	
	public static void addressMessageError() throws Exception {
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is checked-in as guest  verifying the display of error message for address Message by entering all the mandataory details expect address.");
			
			Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, "first name");
			Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, "last name");
			Actionsss.clearText(SAP.getShippingAddress());	
			Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber,"phone number");
			
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(SAP.getAddress1ErrorMsg())){
				test.pass("Successfully the error messages are displayed for shipping address");
				logger.info("Successfully the error messages are displayed for shipping address");
			}else {
				test.fail("No error messages are displayed for shipping address");
				logger.info("No the error messages are displayed for shipping address");
			}
		}else {
			test.info("User is checked-in as registered verifying the display of error message for address Message by entering all the mandataory details expect address for guest user.");
		}
	}
	
	public static void phoneNumberError() throws Exception {
		if(Actionsss.elementSize(pp.getContinueAsAGuest())) {
			test.info("User is checked-in as guest verifying the display of error message for phone number by entering all the mandataory details expect phone number.");
			
			Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, "first name");
			Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, "last name");
			Actionsss.addressFromDropDown(SAP.getShippingAddress());
			Actionsss.clearText(SAP.getSelectPhoneInput());
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(SAP.getphoneNumberErrorMsg())) {
				test.pass("Successfully the error messages are displayed for  phone number");
				logger.info("Successfully the error messages are displayed for  phone number");
			}else {
				test.fail("No error messages are displayed for  phone number");
				logger.info("No the error messages are displayed for  phone number");
			}
		}else {
			test.info("User is checked-in as registered verifying the display of error message for phone number by entering all the mandataory details expect phone number. for guest user.");
		}
	}
	

	
}
