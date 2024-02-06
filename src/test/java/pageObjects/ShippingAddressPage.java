package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class ShippingAddressPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public ShippingAddressPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
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
	
	@FindBy(xpath = "//select[@id='billingAddressSelector']//option[@value!='new']")
	WebElement savedBillingAddress;
	public WebElement getsavedBillingAddress() {
	    return savedBillingAddress;
	}
	
	@FindBy(xpath = "//select[@id='billingAddressSelector']//option[@value!='new']")
	List<WebElement> savedBillingAddressList;
	public List<WebElement> getsavedBillingAddressList() {
	    return savedBillingAddressList;
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
    @FindBy(xpath = "//label[contains(text(),'Billing Address')]")
    private List<WebElement> billingAddress;

    public List<WebElement> getBillingAddressDisplayList() {
        return billingAddress;
    }
    @FindBy(xpath = "//label[contains(text(),'Billing Address')]")
    private WebElement billingAddressDisplay;

    public WebElement getBillingAddressDisplay() {
        return billingAddressDisplay;
    }
    @FindBy(xpath = "//label[contains(text(),'Billing Address')]")
    private List<WebElement> billingAddressDisplayList;

    public List<WebElement> getBillingAddressList() {
        return billingAddressDisplayList;
    }
    
    @FindBy(id = "billingFirstName")
    private WebElement billingFName;

    public WebElement getBillingFName() {
        return billingFName;
    }
    @FindBy(id = "billingLastName")
    private WebElement billingLName;

    public WebElement getBillingLName() {
        return billingLName;
    }

    @FindBy(id = "phoneNumber")
    private WebElement billingPhoneNumber;
    public WebElement getBillingPhoneNumber() {
        return billingPhoneNumber;
    }
    
    @FindBy(xpath = "//input[@id='billingAddressOne']")
    private WebElement address1;

    public WebElement getBillingAddress() {
        return address1;
    }
    @FindBy(id = "defaultFirstName")
    private WebElement firstNameError;

    public WebElement getFirstNameErrorMsg() {
        return firstNameError;
    }
    @FindBy(id = "defaultLastName")
    private WebElement lastNameError;

    public WebElement getlastNameErrorMsg() {
        return lastNameError;
    }
    @FindBy(id = "defaultAddressLine1")
    private WebElement address1Error;

    public WebElement getAddress1ErrorMsg() {
        return address1Error;
    }
    @FindBy(id = "defaultCity")
    private WebElement cityError;

    public WebElement getCityErrorMsg() {
        return cityError;
    }
    
    @FindBy(id = "defaultState")
    private WebElement stateError;

    public WebElement getStateErrorMsg() {
        return stateError;
    }
    @FindBy(id = "defaultZipCode")
    private WebElement zipCodeError;

    public WebElement getZipCodeErrorMsg() {
        return zipCodeError;
    }
    @FindBy(id = "defaultTelephoneNumber")
    private WebElement phoneNumberError;

    public WebElement getphoneNumberErrorMsg() {
        return  phoneNumberError;
    }
    
    @FindBy(xpath = "(//button[@class='text-center btn-show-details btn mx-2'])[1]")
    private WebElement updateAddress;
    public WebElement getUpdateAddress() {
        return  updateAddress;
    }
    
    @FindBy(xpath = "//div[@class='summary-details shipping']//div[@class='address1']")
    private WebElement shipingAdrressInPaymentPage;
    public WebElement getshipingAdrressInPaymentPage() {
        return  shipingAdrressInPaymentPage;
    }
}
