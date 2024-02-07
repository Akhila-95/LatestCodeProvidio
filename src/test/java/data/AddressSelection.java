  package data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import pageObjects.ShippingPageObject;

public class AddressSelection extends baseClass{
	
	static final String fName = "FirstName";
	private static final String lName = "LastName";
	private static final String Phone = "PhoneNumber";
	private static ShippingPageObject shippingPage = new ShippingPageObject(driver);
	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);

	
	public static void Address() throws Exception {
		 List<WebElement> guestCheckOut = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
		 if(guestCheckOut.size()>0) {
			 test.info("Verifed that shipping address is Entered in Guest user");
			 Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fname, fName);
			 Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), lname, lName);
			 Actionsss.addressFromDropDown(shippingPage.getShippingAddress());	
			 Thread.sleep(1000);
			 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, Phone);
			 
		 }else {			 
			test.info("Verify the shipping address entered in Registered user");
				if(Actionsss.displayElement(shippingPage.getShippingToDisplay()) && Actionsss.displayElement(shippingPage.getSaveShippingAddress()) && Actionsss.elementSize(shippingPage.getsavedShippingAddressList())) {
					if(Actionsss.elementSize(shippingPage.getSavedAddress())) {
						test.info("User logged-in and having  saved  address");
				          //randomizing the saved address
						selectingRandomSavedShippingAddress();
						
						//if user want to add new address though having saved address
						//addNewAddress();
					}
				}else {
					test.info("User logged-in and have no saved  address");
					 //Enters name and address	
					shippingAddressDetailsWithName();
					
					saveTheShippingAddress();
				}
		 }
		 
	}
	
	public static void editShippingAddress() throws Exception {
		 List<WebElement> guestCheckOut = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
		 if(guestCheckOut.size()>0) {
			 test.info("Verifed that shipping address is Entered in Guest user");
			 addressEdit();
			 
		 }else {
			 
			test.info("Verify the shipping address entered in Registered user");
				if(Actionsss.displayElement(shippingPage.getShippingToDisplay()) && Actionsss.displayElement(shippingPage.getSaveShippingAddress()) && Actionsss.elementSize(shippingPage.getsavedShippingAddressList())) {
					//if(Actionsss.elementSize(shippingPage.getSavedAddress())) {
						//test.info("User logged-in and having  saved  address");
				          //randomizing the saved address
						//selectingRandomSavedShippingAddress();
						
						//if user want to add new address though having saved address
						//addNewAddress();
						
						// UPDATE ADDRE
						//Actionsss.CombinedClick(shippingPage.getUpdateAddress());
						 addressEdit();
						
					//}else {
						//test.info("User logged-in and have no saved  address");
						 //Enters name and address	
						// addressEdit();
						
						//saveTheShippingAddress();
				//	}
				}
		 }
		 
	}
	
	public static void updateShippingAddress() throws InterruptedException {
		  Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), "akhila", fName);			  
		  Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), "akhi", lName);
		  Actionsss.updateShippingAddress(shippingPage.getShippingAddress());		
		  Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, Phone);
	}
	
	public static void editBillingAddress() throws InterruptedException {
		Actionsss.sendKeys(paymentPage.getBillingFName(), fakeFirstName, "Billing address first name");
		Actionsss.sendKeys(paymentPage.getBillingLName(), fakelastName, "Billing address last name");
		Actionsss.editAddress(shippingPage.getBillingAddress());			
		Actionsss.sendKeys(paymentPage.getBillingPhoneNumber(), "7868764789", "Billing phone number");
	}
	
	public static void addressEdit() throws InterruptedException {
		Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fakeFirstName, "edited first name");
		 Actionsss.sendKeys(shippingPage.getSelectLastNameInput(),fakelastName, "edited last name");
		 Actionsss.editAddress(shippingPage.getShippingAddress());			
		 Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, Phone);
	}
	

	public static void addNewShippingAddressWithName() throws InterruptedException {
				
			  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname
			  Thread.sleep(1000);
			  if(Actionsss.displayElement(shippingPage.getFirstName())) {
				  Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fname, fName);			  
				  Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), lname, lName);
				  Actionsss.addNewShippinggAddress(shippingPage.getShippingAddress());	
				  Thread.sleep(1000);		  
				  Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, Phone);
	 
			  }
		  }
	
	public static void selectingRandomSavedShippingAddress() throws InterruptedException {
		
		  test.info("User logged in and have saved  Address ");		
		  if(Actionsss.displayElement(shippingPage.getAddressDropDownSelect())) {
			  Actionsss.click(shippingPage.getAddressDropDownSelect());	
			int savedAddressCount=Actionsss.getSizeOfList(shippingPage.getsavedShippingAddressList());
			if(savedAddressCount>1) {
				Actionsss.selectByOptions(shippingPage.getsavedShippingAddressList());
				test.pass("Randomly selected the saved address");
			}
		  }
	}	
	
	 public void addNewAddress() throws Exception {
			
		  if(Actionsss.displayElement(shippingPage.getAddNewAddress())) {
			  Actionsss.javascriptClick(shippingPage.getAddNewAddress());
		  }
	  }
	  public static void shippingAddressDetailsWithName() throws InterruptedException {
		
		  //this method send the shipping first name,last name and address details , phonenumber by checking the display of firstname 
		  Thread.sleep(1000);
		  if(Actionsss.displayElement(shippingPage.getFirstName())) {
			  Actionsss.sendKeys(shippingPage.getSelectfirstNameInput(), fname, fName);			  
			  Actionsss.sendKeys(shippingPage.getSelectLastNameInput(), lname, lName);
			  Actionsss.addressFromDropDown(shippingPage.getShippingAddress());		
			  Actionsss.sendKeys(shippingPage.getSelectPhoneInput(), phonenumber, Phone);
 
		  }
	  }
	  
	  public static void saveTheShippingAddress() throws Exception {
		 
		  if(Actionsss.elementSize(shippingPage.getSaveShippingAddressList())) {
			  if(Actionsss.displayElement(shippingPage.getSaveShippingAddress())) {
				  Actionsss.javascriptClick(shippingPage.getSaveShippingAddress());
			  }
		  }
	  }
	  public void selectPaymentMethod() throws Exception {
		 
		  if(Actionsss.elementSize(shippingPage.getPaymentButtonList())) {
			  Thread.sleep(2000);	 
			  if(Actionsss.displayElement(shippingPage.getPaymentButton())) {
				  Actionsss.javascriptClick(shippingPage.getPaymentButton());
			  }
		  }
	  }
	  
	  public void selectBillingAddress() throws InterruptedException {
		  
		 
		  if(Actionsss.displayElement(shippingPage.getBillingAddressDisplay())) {
			  
			  if(Actionsss.displayElement(shippingPage.getBillingFName())) {
				  
				  Thread.sleep(1000);		
				  Actionsss.sendKeys(shippingPage.getBillingFName(), fakeFirstName,fName);
				  logger.info("Entered fname");
				  Actionsss.sendKeys(shippingPage.getBillingLName(),fakelastName,lName);
				  logger.info("Entered lname");	
				  Actionsss.addressFromDropDown(shippingPage.getBillingAddress());
				  
				  Actionsss.sendKeys(shippingPage.getBillingPhoneNumber(), phonenumber, Phone);
				  logger.info("Entered phone number");
				  Thread.sleep(2000);
			  }
		  }
	  }
	

}
