package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage2 {

		WebDriver lDriver;
	    //pageFactory constructor for this page
		public CheckOutPage2(WebDriver rDriver){
			lDriver =rDriver;
			PageFactory.initElements(rDriver, this);
		}
		
		@FindBy(xpath="//div[@class='card shipping-section']")
		List<WebElement> shippingPage;
		public List<WebElement> getshippingPage() {
			return shippingPage;
		}
		
		@FindBy(css="div.customer-summary")
		WebElement customerInfo;
		public WebElement getCustomerInfo() {
			return customerInfo;
		}
		
		@FindBy(xpath = "//button[@aria-label='action.edit.step.msg.customer']")
		WebElement editCutomerInfo;
		public WebElement getEditCustomerInfo() {
			return editCutomerInfo;
		}
		@FindBy(css="div.shipping-section")
		WebElement shippingInfo;
		public WebElement getshippingInfo() {
			return shippingInfo;
		}
		
		@FindBy(xpath="//h2[contains(text(),'Order Summary')]")
		WebElement orderSummaryDiv;
		public WebElement getOrderSummaryDiv() {
			return orderSummaryDiv;
		}
		
		@FindBy(css="a.back-to-cart")
		WebElement backToCart;
		public WebElement getBackToCart() {
			return backToCart;
		}
		
		@FindBy(css="button.submit-shipping")
		WebElement  nextPaymentButton;
		public WebElement getNextPaymentButton() {
			return nextPaymentButton;
		}
		
		@FindBy(css="img.logo")
		WebElement  etgLogo;
		public WebElement getEtgLogo() {
			return  etgLogo;
		}
		
		@FindBy(xpath = "//div[contains(@class,'card order-product-summary')]//a[contains(@class,'line-item-text')]")
		List<WebElement> productsInCheckoutPage2;
		public List<WebElement> getproductsInCheckoutPage2() {
			return productsInCheckoutPage2;
		}
		@FindBy(css = "div.product-detail")
		WebElement pdpPage;
		public WebElement getPdpPage() {
			return pdpPage;
		}
		@FindBy(xpath = "(//fieldset[@class='gift-message-block '])[1]//label[contains(@class,'checkout-checkbox')]")
		WebElement giftMessageCheckButton;
		public WebElement getGiftMessageCheckButton() {
			return giftMessageCheckButton;
		}
		@FindBy(xpath = "(//fieldset[@class='gift-message-block '])[1]//textarea")
		WebElement giftMessageTextArea;
		public WebElement getGiftMessagegiftMessageTextArea() {
			return giftMessageTextArea;
		}
		
		@FindBy(xpath = "(//button[contains(@class,'btn-show-details')])[3]")
		WebElement updateAddressBtn;
		public WebElement getUpdateAddressBtn() {
			return updateAddressBtn;
		}
		
		
	
		//Fname
		@FindBy(xpath ="//input[@id='shippingFirstNamedefault']")
		WebElement firstNameInput; 
		public WebElement getSelectfirstNameInput(){
			return firstNameInput;
		}
		//LName
		@FindBy(xpath ="//input[@id='shippingLastNamedefault']")
		WebElement lastNameInput; 
		public WebElement getSelectLastNameInput(){
			return lastNameInput;
		}

		
		//Phone
		@FindBy(xpath ="//input[@id='shippingPhoneNumberdefault']")
		WebElement PhoneInput; 
		public WebElement getSelectPhoneInput(){
			return PhoneInput;
		}
		
		//Phone
		@FindBy(xpath ="//button[contains(text(),'Next: Payment')]")
		WebElement NextPaymentBtn; 
		public WebElement getSelectNextPaymentBtn(){
			return NextPaymentBtn;
		}
		
		@FindBy(xpath="(//fieldset[contains(@class, 'shipping-method-block')])[1]")
		WebElement checkOutPage2;	
		public WebElement getcheckOutPage2() {
			return checkOutPage2;	
		}
		
		// WebElements for shippingLabel
		@FindBy(xpath = "(//h2[contains(text(),'Shipping')])[2]")
		 List<WebElement> shippingLabel;

		public  List<WebElement> getShippingLabel() {
		    return shippingLabel;
		}

		// WebElements for pickUpStoreLabel
		@FindBy(xpath = "(//span[contains(text(),'Store Pickup')])[1]")
		 List<WebElement> pickUpStoreLabel;

		public  List<WebElement> getPickUpStoreList() {
		    return pickUpStoreLabel;
		}

		// WebElements for enterAddressList
		@FindBy(xpath = "(//button[contains(text(),'Enter Address')])[2]")
		 List<WebElement> enterAddressList;

		public List<WebElement> getEnterAddressList() {
		    return enterAddressList;
		}

		// WebElements for storePickUpList
		@FindBy(xpath = "(//span[contains(text(),'Store Pickup')])[2]")
		 List<WebElement> storePickUpList;

		public List<WebElement> getStorePickUpList() {
		    return storePickUpList;
		}	
		
		// WebElement for shippingLabelDisplay
		@FindBy(xpath = "(//h2[contains(text(),'Shipping')])[2]")
		 WebElement shippingLabelDisplay;

		public  WebElement getShippingLabelDisplay() {
		    return shippingLabelDisplay;
		}

		// WebElement for existingAddress1
		@FindBy(xpath = "(//label[contains(text(),'Shipping To')])[1]")
		 List<WebElement> existingAddress1;

		public  List<WebElement> getExistingAddress1() {
		    return existingAddress1;
		}
		// WebElement for addNewAddress
		@FindBy(xpath = "(//button[contains(@class,'btn-add-new')])[1]")
		 WebElement addNewAddress;

		public WebElement getAddNewAddress() {
		    return addNewAddress;
		}

		// WebElement for addressDropDownSelect
		@FindBy(xpath = "//select[@id='shipmentSelector-default']")
		WebElement addressDropDownSelect;

		public WebElement getAddressDropDownSelect() {
		    return addressDropDownSelect;
		}
		// WebElement for addressDropDownSelect
		@FindBy(xpath = "//select[@id='shipmentSelector-default']//option[contains(@value,'ab_')]")
		List<WebElement> savedShippingAddressList;

		public List<WebElement> getsavedShippingAddressList() {
		    return savedShippingAddressList;
		}
		// WebElement for addressDropDownSelect
		@FindBy(xpath = "//select[@id='shipmentSelector-default']//option[contains(@value,'ab_')]")
		WebElement savedShippingAddress;

		public WebElement getsavedShippingAddress() {
		    return savedShippingAddress;
		}
		

		// List of WebElements for savedAddress
		@FindBy(xpath = "//select[@id='shipmentSelector-default']/option")
		List<WebElement> savedAddress;

		public List<WebElement> getSavedAddress() {
		    return savedAddress;
		}

		// WebElement for saveShippingAddress
		@FindBy(xpath = "(//input[@id='addShippingAddressToMyAccount'])[1]")
		 WebElement saveShippingAddress;

		public  WebElement getSaveShippingAddress() {
		    return saveShippingAddress;
		}

		// List of WebElements for saveShippingAddressList
		@FindBy(xpath = "(//input[@id='addShippingAddressToMyAccount'])[1]")
		 List<WebElement> saveShippingAddressList;

		public  List<WebElement> getSaveShippingAddressList() {
		    return saveShippingAddressList;
		}

		// WebElement for shippingToDisplay
		@FindBy(xpath = "(//label[contains(text(),'Shipping To')])[1]")
		 WebElement shippingToDisplay;

		public  WebElement getShippingToDisplay() {
		    return shippingToDisplay;
		}
		
		//FirstName
		@FindBy(xpath="//input[@id='shippingFirstNamedefault']")
		WebElement firstName;
		
		public WebElement getFirstName() {
			return firstName;
		}
		
		//LastName
		@FindBy(xpath="//input[@id='shippingLastNamedefault']")
		WebElement lastName;
		
		public WebElement getLastName() {
			return lastName;
		}
		
		//Phone
		@FindBy(css="#shippingPhoneNumberdefault")
		WebElement phoneNumber;
		public WebElement getPhoneNumber() {
			return phoneNumber;
		}
		
		// WebElements for firstNameList
		@FindBy(xpath = "(//input[@class='form-control shippingFirstName'])[2]")
		static List<WebElement> firstNameList;

		public static List<WebElement> getFirstNameList() {
		    return firstNameList;
		}

		// WebElement for firstName1
		@FindBy(xpath = "(//input[@class='form-control shippingFirstName'])[2]")
		static WebElement firstName1;

		public static WebElement getFirstName1() {
		    return firstName1;
		}

		// WebElement for lastName1
		@FindBy(xpath = "(//input[@class='form-control shippingLastName'])[2]")
		static WebElement lastName1;

		public static WebElement getLastName1() {
		    return lastName1;
		}

		// WebElement for addressAtEnterAddress
		@FindBy(xpath = "(//input[@class='form-control shippingAddressOne pac-target-input'])[2]")
		static WebElement addressAtEnterAddress;

		public static WebElement getAddressAtEnterAddress() {
		    return addressAtEnterAddress;
		}
		
		// WebElement for shippingAddress
		@FindBy(xpath = "//input[@id='shippingAddressOnedefault']")
		 WebElement shippingAddress;

		public  WebElement getShippingAddress() {
		    return shippingAddress;
		}
		
		// WebElements for paymentButton
		@FindBy(css = ".submit-shipping")
		List<WebElement> paymentButtonList;

		public List<WebElement> getPaymentButtonList() {
		    return paymentButtonList;
		}
		
	// WebElements for paymentButton
		@FindBy(css = ".submit-shipping")
		WebElement paymentButton;

		public WebElement getPaymentButton() {
		    return paymentButton;
		}

	    @FindBy(xpath = "((//div[contains(@class,'multi-shipping')])[1]//form[@id='dwfrm_shipping'])[1]")
	    private WebElement enterAddress;

	    public WebElement getEnterAddress() {
	        return enterAddress;
	    }

	    @FindBy(xpath = "(//button[contains(@class,'save-shipment')])[2]")
	    private WebElement saveTheAddressButton;

	    public WebElement getSaveTheAddressButton() {
	        return saveTheAddressButton;
	    }
	  
	    
	    @FindBy(xpath = "(//button[@class='text-center btn-show-details btn mx-2'])[1]")
	    private WebElement updateAddress;

	    public WebElement getUpdateAddress() {
	        return  updateAddress;
	    }
}
