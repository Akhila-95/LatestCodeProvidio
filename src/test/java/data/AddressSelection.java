  package data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CheckOutPage2;
import pageObjects.CheckOutPage3;
import pageObjects.PaymentPage;
import pageObjects.ShippingAddressPage;

public class AddressSelection extends baseClass{
	
	static final String fName = "FirstName";
	private static final String lName = "LastName";
	private static final String Phone = "PhoneNumber";
	private static ShippingAddressPage SAP = new ShippingAddressPage(driver);
	private static final CheckOutPage3 cop3 = new CheckOutPage3(driver);

	
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
				if(Actionsss.displayElement(SAP.getShippingToDisplay()) && Actionsss.displayElement(SAP.getSaveShippingAddress()) && Actionsss.elementSize(SAP.getsavedShippingAddressList())) {
					//if(Actionsss.elementSize(SAP.getSavedAddress())) {
						//test.info("User logged-in and having  saved  address");
				          //randomizing the saved address
						//selectingRandomSavedShippingAddress();
						
						//if user want to add new address though having saved address
						//addNewAddress();
						
						// UPDATE ADDRE
						//Actionsss.CombinedClick(SAP.getUpdateAddress());
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
		  Actionsss.sendKeys(SAP.getSelectfirstNameInput(), "akhila", fName);			  
		  Actionsss.sendKeys(SAP.getSelectLastNameInput(), "akhi", lName);
		  Actionsss.updateShippingAddress(SAP.getShippingAddress());		
		  Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
	}
	
	public static void editBillingAddress() throws InterruptedException {
		Actionsss.sendKeys(cop3.getBillingFName(), fakeFirstName, "Billing address first name");
		Actionsss.sendKeys(cop3.getBillingLName(), fakelastName, "Billing address last name");
		 Actionsss.editAddress(SAP.getBillingAddress());			
		 Actionsss.sendKeys(cop3.getBillingPhoneNumber(), "7868764789", "Billing phone number");
	}
	
	public static void addressEdit() throws InterruptedException {
		Actionsss.sendKeys(SAP.getSelectfirstNameInput(), fakeFirstName, "edited first name");
		 Actionsss.sendKeys(SAP.getSelectLastNameInput(),fakelastName, "edited last name");
		 Actionsss.editAddress(SAP.getShippingAddress());			
		 Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
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
			  Actionsss.sendKeys(SAP.getSelectLastNameInput(), lname, lName);
			  Actionsss.addressFromDropDown(SAP.getShippingAddress());		
			  Actionsss.sendKeys(SAP.getSelectPhoneInput(), phonenumber, Phone);
 
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
				  
				  Actionsss.sendKeys(SAP.getBillingPhoneNumber(), phonenumber, Phone);
				  logger.info("Entered phone number");
				  Thread.sleep(2000);
			  }
		  }
	  }
	

}
