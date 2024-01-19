  package data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;

public class AddressSelection extends baseClass{
	
	static final String fName = "FirstName";
	private static final String lName = "LastName";
	private static final String Phone = "PhoneNumber";
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static PaymentPage pp = new PaymentPage(driver);
	static AddressSelection addresSelect = new AddressSelection();
	
	public static void Address() throws Exception {
		 List<WebElement> guestCheckOut = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
		 if(guestCheckOut.size()>0) {
			 test.info("Verifed that shipping address is Entered in Guest user");
			 Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, fName);
			 Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, lName);
			 Actionsss.addressFromDropDown(SAP.getShippingAddress());			
			 Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
			 
		 }else {
			 
			test.info("Verify the shipping address entered in Registered user");
				if(Actionsss.displayElement(SAP.getShippingToDisplay()) && Actionsss.displayElement(SAP.getSaveShippingAddress()) && Actionsss.elementSize(SAP.getsavedShippingAddressList())) {
					if(Actionsss.elementSize(SAP.getSavedAddress())) {
						test.info("User logged-in and having  saved  address");
				          //randomizing the saved address
						selectingRandomSavedShippingAddress();
						
						//if user want to add new address though having saved address
						//addNewAddress();
					}else {
						test.info("User logged-in and have no saved  address");
						 //Enters name and address	
						shippingAddressDetailsWithName();
						
						saveTheShippingAddress();
					}
				}
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
			Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, lName);
			Actionsss.addressFromDropDown(SAP.getShippingAddress());			
			Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(1000);
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
			
			Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, fName);
			Actionsss.clearText(SAP.getSelectLastNameInput());
			Actionsss.addressFromDropDown(SAP.getShippingAddress());			
			Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(1000);
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
			
			Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, fName);
			Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, lName);
			Actionsss.clearText(SAP.getShippingAddress());	
			Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
			
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(1000);
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
			
			Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, fName);
			Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, lName);
			Actionsss.addressFromDropDown(SAP.getShippingAddress());
			Actionsss.clearText(SAP.getSelectPhoneInput());
			Thread.sleep(3000);
			addresSelect.selectPaymentMethod();
			Thread.sleep(1000);
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
	
	public static void selectingRandomSavedShippingAddress() throws InterruptedException {
		
		  test.info("User logged in and have saved  Address ");		
		  if(Actionsss.displayElement(SAP.getAddressDropDownSelect())) {
			  Actionsss.click(SAP.getAddressDropDownSelect());	
			int savedAddressCount=Actionsss.getSizeOfList(SAP.getsavedShippingAddressList());
			if(savedAddressCount>1) {
				Actionsss.selectByOptions(SAP.getsavedShippingAddressList());
				test.pass("Randomly selected the saved address");
			}
		  }
	}	
	
	  public void addNewAddress() throws Exception {
		
		  if(Actionsss.displayElement(SAP.getAddNewAddress())) {
			  Actionsss.javascriptClick(SAP.getAddNewAddress());
		  }
	  }
	  public static void shippingAddressDetailsWithName() throws InterruptedException {
		
		  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname 
		  Thread.sleep(1000);
		  if(Actionsss.displayElement(SAP.getFirstName())) {
			  Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fname, fName);
			  Thread.sleep(1000);	
			  Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, lName);
			  Actionsss.addressFromDropDown(SAP.getShippingAddress());
			  Thread.sleep(2000);	
			  Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
  
		  }else {
			  //if()
		  }
	  }
	  
	  public static void saveTheShippingAddress() throws Exception {
		 
		  if(Actionsss.elementSize(SAP.getSaveShippingAddressList())) {
			  if(Actionsss.displayElement(SAP.getSaveShippingAddress())) {
				  Actionsss.javascriptClick(SAP.getSaveShippingAddress());
			  }
		  }
	  }
	  public void selectPaymentMethod() throws Exception {
		 
		  if(Actionsss.elementSize(SAP.getPaymentButtonList())) {
			  Thread.sleep(2000);	 
			  if(Actionsss.displayElement(SAP.getPaymentButton())) {
				  Actionsss.javascriptClick(SAP.getPaymentButton());
			  }
		  }
	  }
	  
	  public void selectBillingAddress() throws InterruptedException {
		  
		 
		  if(Actionsss.displayElement(SAP.getBillingAddressDisplay())) {
			  
			  if(Actionsss.displayElement(SAP.getBillingFName())) {
				  
				  Thread.sleep(1000);		
				  Actionsss.sendKeys(SAP.getBillingFName(), fakeFirstName,fName);
				  logger.info("Entered fname");
				  Actionsss.sendKeys(SAP.getBillingLName(),fakelastName,lName);
				  logger.info("Entered lname");	
				  Actionsss.addressFromDropDown(SAP.getBillingAddress());
				  
				  Actionsss.sendKeys(SAP.getBillingPhoneNumber(), fakePhoneNum, Phone);
				  logger.info("Entered phone number");
				  Thread.sleep(2000);
			  }
		  }
	  }

}
