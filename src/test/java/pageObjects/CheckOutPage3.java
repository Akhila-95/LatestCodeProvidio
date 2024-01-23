package pageObjects;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage3 {

	WebDriver lDriver;
    //pageFactory constructor for this page
	public CheckOutPage3(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="(//div[contains(@class,'gift-summary')])[3]")
	WebElement  giftMessageInCop3;
	public WebElement getgiftMessageInCop3() {
		return giftMessageInCop3;
	}
	@FindBy(xpath="//button[@aria-label='Edit Shipping']")
	WebElement  editShipping;
	public WebElement getEditShipping() {
		return editShipping;
	}

	// update billing addres
	@FindBy(css = "select#billingAddressSelector")
	WebElement updateAddressBtnForBillingAddress;
	public WebElement getUpdateAddressBtnForBillingAddress() {
		return updateAddressBtnForBillingAddress;
	}
	
	
	@FindBy(css="button.submit-payment")
	WebElement  nextReviewOrderBtn;
	public WebElement getNextReviewOrderBtn() {
		return nextReviewOrderBtn;
	}
	
	@FindBy(css="button.submit-payment")
	List<WebElement>  nextReviewOrderBtnList;
	public List<WebElement> getNextReviewOrderBtnList() {
		return nextReviewOrderBtnList;
	}
	
	@FindBy(xpath="//label[contains(text(),'Payment Method')]")
	List<WebElement>  paymentPageList;
	public List<WebElement> getpaymentPageList() {
		return paymentPageList;
	}
	
	@FindBy(xpath="//label[contains(text(),'Payment Method')]")
	WebElement  paymentPage;
	public WebElement getpaymentPage() {
		return paymentPage;
	}
	@FindBy(xpath="//button[@aria-label='action.edit.step.msg.customer']")
	WebElement  customerInfoFromCop3;
	public WebElement getCustomerInfoFromCop3() {
		return customerInfoFromCop3;
	}
	
	@FindBy(css="span.customer-summary-email")
	WebElement  editCustomerInfo;
	public WebElement getEditCustomerInfo() {
		return editCustomerInfo;
	}
	
	@FindBy(xpath="(//div[@class='address-summary'])[1]//div[@class='address1']")
	WebElement   shippingAddress;
	public WebElement getShippingAddress() {
		return shippingAddress;
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
}
