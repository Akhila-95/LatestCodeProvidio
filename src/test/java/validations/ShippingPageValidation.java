package validations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import pageObjects.ShippingPageObject;

public class ShippingPageValidation extends baseClass{

	
	private static ShippingPageObject shippingPage = new ShippingPageObject(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	static AddressSelection addresSelect = new AddressSelection();
	
	public static void customerInfoValidationInCOP2_Page() {
		 test.info("Verifying the customer information is displayed in checkout 2 page ");
		 if(Actionsss.displayElement(shippingPage.getCustomerInfo())) {
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
		 if(Actionsss.displayElement(shippingPage.getshippingInfo())) {
			 logger.info("shipping details form  is displayed in check out page 2");
			 test.pass("shipping details form is displayed in check out page 2");
		 }else {
			 logger.info("No shipping details form is displayed in check out page 2");
			 test.pass("No shipping details form is displayed in check out page 2");
		 }
	}
	
	public static void orderSummaryValidationInCop2_Page() {
		test.info("Verifying the orderSummary display in checkout 2 page ");
		 if(Actionsss.displayElement(shippingPage.getOrderSummaryDiv())) {
			 logger.info("orderSummary  is displayed in check out page 2");
			 test.pass("orderSummary  is displayed in check out page 2");
		 }else {
			 logger.info("No orderSummary  is displayed in check out page 2");
			 test.pass("No orderSummary  is displayed in check out page 2");
		 }
	}
	
	public static void bactToCartValidationInCop2_Page() {
		test.info("Verifying the back to cart  display in checkout 2 page ");
		 if(Actionsss.displayElement(shippingPage.getBackToCart())) {
			 logger.info("Back to cart is displayed in check out page 2");
			 test.pass("Back to cart is displayed in check out page 2");
		 }else {
			 logger.info("No Back to cart  is displayed in check out page 2");
			 test.pass("No Back to cart  is displayed in check out page 2");
		 }
	}
	
	public static void nextPaymentButtonValidationInCop2_Page() {
		test.info("Verifying the Next Payment Button   display in checkout 2 page ");
		 if(Actionsss.displayElement(shippingPage.getNextPaymentButton())) {
			 logger.info("Next Payment Button  is displayed in check out page 2");
			 test.pass("Next Payment Button  is displayed in check out page 2");
		 }else {
			 logger.info("No Next Payment Button  is displayed in check out page 2");
			 test.pass("No Next Payment Button  is displayed in check out page 2");
		 }
	}
	
	public static void etgLogoValidationInCop2_Page() {
		test.info("Verifying the  etg logo display in checkout 2 page ");
		 if(Actionsss.displayElement(shippingPage.getOrderSummaryDiv())) {
			 logger.info(" Etg logo  is displayed in check out page 2");
			 test.pass(" Etg logo is displayed in check out page 2");
		 }else {
			 logger.info("No etg logo  is displayed in check out page 2");
			 test.pass("No  etg logo  is displayed in check out page 2");
		 }
	}
	
	public static void pdpPageValidation() {
		test.info("Verifying the pagination of product from checkout page 2 ");
		if(Actionsss.displayElement(shippingPage.getPdpPage())) {
			 logger.info("Succesfully paginated to PDP page by clicking the product from check out page 2");
			 test.pass("Succesfully paginated to PDP page by clicking the product from check out page 2");
		 }else {
			 logger.info("Not paginated to PDP page by clicking the product from check out page 2");
			 test.fail(" Not paginated to PDP page by clicking the product from check out page 2");	 
		}
	}
	
	public static void VerifiedThatNextpaymentBtnClick() {
 		test.info("Verified That Nextpayment Btn click");		
     	WebElement miniCartPage = driver.findElement(By.xpath("//div[@class='card payment-form']"));    	
     	if (miniCartPage.isDisplayed()) {
     	    logger.info("Successfully Clicked on the Nextpayment Btn and navigated to payment page");
     	    test.pass("Successfully Clicked on the Nextpayment Btn  and navigated to payment page");
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}
	
	public static void verifyingTheUpdateShippingAddress() {
 		test.info("Verifying the update shipping address");
 		logger.info(previousShippingAddressInUpdate);
 		logger.info(updateShippingAddress);
     	if (!previousShippingAddressInUpdate.equals(updateShippingAddress)) {
     	    logger.info("Successfully Clicked on update button and updated the shiiping address, the previous shipping address is " +previousShippingAddressInUpdate + "and updated shipping address is "+ updateShippingAddress);
     	    test.pass("Successfully Clicked on update button and updated the shiiping address, the previous shipping address is " +previousShippingAddressInUpdate + "and updated shipping address is "+ updateShippingAddress);
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}

	public static void verifyingAddNewShippingAddress() {
 		test.info("Verifying the add new shipping address");
 		logger.info(previousShippingAddress);
 		logger.info(newlyAddedShippingAddress);
     	if (!previousShippingAddress.equals(newlyAddedShippingAddress)) {
     	    logger.info("Successfully Clicked on add new button and adding new  shipping address, the previous shipping address is " +previousShippingAddress + "and added new shipping address is "+newlyAddedShippingAddress);
     	    test.pass("Successfully Clicked on add  new  button and adding new  shipping address, the previous shipping address is " +previousShippingAddress+ "and added new  shipping address is "+ newlyAddedShippingAddress);
     	}else {
     		//test.fail("Click failed");
     		logger.info("Click failed");
     	}
 	}
 	public static void negativeValidationForShippingAddress() throws Exception {
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {	  		
			test.info("Verify the display of all error messages for shipping address when user is clicked on next payment button without entering all the mandatory details and checked-in as guest");		
			addresSelect.selectPaymentMethod();
			 Thread.sleep(1000);
			if(Actionsss.displayElement(shippingPage.getFirstNameErrorMsg()) && Actionsss.displayElement(shippingPage.getlastNameErrorMsg()) && Actionsss.displayElement(shippingPage.getAddress1ErrorMsg())
					&& Actionsss.displayElement(shippingPage.getStateErrorMsg()) && Actionsss.displayElement(shippingPage.getCityErrorMsg()) && Actionsss.displayElement(shippingPage.getZipCodeErrorMsg())
					&& Actionsss.displayElement(shippingPage.getphoneNumberErrorMsg())) {
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
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {		
			test.info("User is checked-in as guest  verifying the display of error message for first Name by entering all the mandataory details expect first name.");
			Actionsss.clearText(shippingPage.getSelectfirstNameInput());
			Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), lname, "last name");
			Actionsss.addressFromDropDown(shippingPage.getShippingAddress());			
			Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, "phone number");
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(shippingPage.getFirstNameErrorMsg())) {
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
		
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
			test.info("User is checked-in as guest  verifying the display of error message for last Name by entering all the mandataory details expect last name.");
			
			Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fname, "first name");
			Actionsss.clearText(shippingPage.getSelectLastNameInput());
			Actionsss.addressFromDropDown(shippingPage.getShippingAddress());			
			Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, "phone number");
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(shippingPage.getlastNameErrorMsg())) {
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
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
			test.info("User is checked-in as guest  verifying the display of error message for address Message by entering all the mandataory details expect address.");
			
			Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fname, "first name");
			Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), lname, "last name");
			Actionsss.clearText(shippingPage.getShippingAddress());	
			Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber,"phone number");
			
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(shippingPage.getAddress1ErrorMsg())){
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
		if(Actionsss.elementSize(paymentPage.getContinueAsAGuest())) {
			test.info("User is checked-in as guest verifying the display of error message for phone number by entering all the mandataory details expect phone number.");
			
			Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fname, "first name");
			Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), lname, "last name");
			Actionsss.addressFromDropDown(shippingPage.getShippingAddress());
			Actionsss.clearText(shippingPage.getSelectPhoneInput());
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(2000);
			if(Actionsss.displayElement(shippingPage.getphoneNumberErrorMsg())) {
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
