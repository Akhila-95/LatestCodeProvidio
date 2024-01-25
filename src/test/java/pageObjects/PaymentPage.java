package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class PaymentPage extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public PaymentPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath = "//label[contains(text(), 'Payment Method')]")
    private WebElement paymentPage;		
	public WebElement getPaymentPage() {
		return paymentPage;
	}

	@FindBy(xpath = "//div[@class='js-payment-options ']")
    private List<WebElement> creditCardDiv;		
	public List<WebElement> getPaymentPagecreditCardDivList() {
		return creditCardDiv;
	}
	
	@FindBy(css= "input.sfpp-payment-method-radio-card")
    private WebElement salesforceCreditcardRadioBtn;

    public WebElement getSalesforceCreditcardRadioBtn() {
        return salesforceCreditcardRadioBtn;
    }
    
    @FindBy(xpath = "//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']")
    private List<WebElement> creditcardsSalesForce;

    public List<WebElement> getCreditcardsSalesForce() {
        return creditcardsSalesForce;
    }
    
    @FindBy(xpath = "(//div[contains(@class,'StripeElement')])[1]")
    private List<WebElement> stripePayment;

    public List<WebElement> getStripePayment() {
        return stripePayment;
    }

    @FindBy(xpath = "//li[@data-method-id='CREDIT_CARD']")
    private List<WebElement> cyberSourcePayment;   

    public List<WebElement> getCyberSourcePayment() {
        return cyberSourcePayment;
    }
    @FindBy(xpath = "//button[contains(text(),'Guest Checkout')]")
    private List<WebElement> continueAsAGuest;
    
    public List<WebElement> getContinueAsAGuest() {
        return continueAsAGuest;
    }


    
    //brain tree paymnet 
    
    @FindBy(css = "option.js_stored_card")
    private List<WebElement> savedCardsBrainTree;

    public List<WebElement> getSavedCardsBrainTree() {
        return savedCardsBrainTree;
    }
    @FindBy(xpath = "//input[@id = 'cardholder-name']")
    private WebElement entercname;

    public WebElement getBrainTreeHoldername() {
        return entercname;
    }
    @FindBy(xpath = "//input[@id = 'credit-card-number']")
    private WebElement entercnumber;

    public WebElement getBrainTreeCardNum() {
        return entercnumber;
    }
    @FindBy(xpath = "//input[@id = 'cvv']")
    private WebElement entercvv;

    public WebElement getBrainTreeCvv() {
        return entercvv;
    }
    @FindBy(xpath = "//input[@id = 'expiration']")
    private WebElement enterexp;

    public WebElement getBrainTreeExp() {
        return enterexp;
    }

    @FindBy(xpath = "//input[@id='braintreeSaveCreditCard']")
    private WebElement savebutton;

    public WebElement getBrainTreeSavebutton() {
        return savebutton;
    }
    @FindBy(xpath ="//select[@id='braintreeCreditCardList']")
    WebElement newCardDropdown;
    
    // Method to get the Braintree credit card list dropdown WebElement
    public WebElement getBrainTreeNewCardDropdown() {
        return newCardDropdown;
    }
    
    @FindBy(xpath = "//a[@class ='nav-link creditcard-tab active']")
    private List<WebElement> brainTree;

    public List<WebElement> getBrainTree() {
        return brainTree;
    }
    
    @FindBy(xpath = "//p[contains(text(),'Please enter valid credit card details.')]")
    WebElement errorMessageInBrainTree;
    
    public WebElement getErrorMsgInBrainTree() {
    	return errorMessageInBrainTree;
    }
  //Cybersource credit card Xpaths, actionMethods and passing the card details
    
    //CyberSource cardNumber
    @FindBy(xpath ="//input[@id ='cardNumber']")
    WebElement newCreditcard;
    
    public WebElement getCyberSourceCreditcard() {
        return newCreditcard;
    }

    //CyberSource exp month
    @FindBy(xpath ="//select[@id ='expirationMonth']")
    WebElement newExpmonth;

    public WebElement getCyberSourceExpmonth() {
        return newExpmonth;
    }
    @FindBy(xpath = "//select[@id ='expirationYear']")
    private WebElement newExpYear;

    public WebElement getCyberSourceExpYear() {
        return newExpYear;
    }
    @FindBy(xpath = "//input[@id ='securityCode']")
    private WebElement newSceuritycode;

    public WebElement getCyberSourceSceuritycode() {
        return newSceuritycode;
    }
    @FindBy(xpath = "//button[contains(@class,'add-payment')]")
    private WebElement addPaymentBtn;

    public WebElement getCyberSourceAddPaymentBtn() {
        return addPaymentBtn;
    }
    @FindBy(css = "div.saved-payment-instrument")
    private List<WebElement> savedCardsCyberSource;
    
    public List<WebElement> getSavedCardsCyberSource() {
        return savedCardsCyberSource;
    }    
    @FindBy(xpath = "//div[@class='row saved-payment-instrument selected-payment']")
    private WebElement selectedCardCyberSource;

    public WebElement getSelectedCardCyberSource() {
        return selectedCardCyberSource;
    }
    
    @FindBy(css = "button.add-payment")
    private List<WebElement> addNewCardListCyberSource;

    public List<WebElement> getAddNewCardListCyberSource() {
        return addNewCardListCyberSource;
    }
    
    @FindBy(css = "button.add-payment")
    private WebElement addPaymentCybersource;
    public WebElement getAddPaymentCybersource() {
        return addPaymentCybersource;
    }
    
    @FindBy(xpath = "//input[@name='dwfrm_billing_creditCardFields_email']")
    private WebElement emailInReg;
    public WebElement getEmailInRegInCybersource() {
        return emailInReg;
    }
    
    // errros msg in cybersource
    @FindBy(xpath = "//div[contains(text(),'This field is required.')]")
    private List<WebElement> errorMsgsInCybersource;
    public List<WebElement> getErrorMsgsInCybersource() {
        return errorMsgsInCybersource;
    }
    // errros msg in cybersource
    @FindBy(xpath = "//div[contains(text(),'This field is required.')]")
    private WebElement errorMsgInCybersource;
    public WebElement getErrorMsgInCybersource() {
        return errorMsgInCybersource;
    }
    
    // error msg for sec code
    @FindBy(xpath = "//div[contains(text(),'A security code is required.')]")
    private WebElement errorMsgForSecurityCodeInCybersource;
    public WebElement getErrorMsgForSecurityCodeInCybersource() {
        return errorMsgForSecurityCodeInCybersource;
    }
    
    
    // error msg for card num
    @FindBy(xpath = "//div[contains(text(),'Invalid Credit Card Number')]")
    private WebElement errorMsgForInvalidCreditCardInCybersource;
    public WebElement getErrorMsgForInvalidCreditCardInCybersource() {
        return errorMsgForInvalidCreditCardInCybersource;
    }
    
    // error msg for sec code
    @FindBy(xpath = "//div[contains(text(),'Invalid Security Code')]")
    private WebElement errorMsgForInvalidSecurityCodeInCybersource;
    public WebElement getErrorMsgForInvalidSecurityCodeInCybersource() {
        return errorMsgForInvalidSecurityCodeInCybersource;
    }
    
    
    //salesforce payment
    @FindBy(xpath = "//input[@autocomplete='cc-number' and @inputmode='numeric']")
    private WebElement cardNumber;

    public WebElement getSalesforceCardNumber() {
        return cardNumber;
    }
    //salesforce payment
    @FindBy(css = "iframe[title='Secure expiration date input frame']")
    private WebElement cardNumberIframe;

    public WebElement getcardNumberIframe() {
        return cardNumberIframe;
    }
    
    @FindBy(xpath = "//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    private WebElement expiryDate;

    public WebElement getSalesforceExpiryDate() {
        return expiryDate;
    }
    @FindBy(xpath = "iframe[title='Secure CVC input frame']")
    private WebElement expiryDateIframe;

    public WebElement getSalesforceexpiryDateIframe() {
        return expiryDateIframe;
    }
    
    @FindBy(xpath = "//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    private WebElement cvv;

    public WebElement getSalesforceCvv() {
        return cvv;
    }
    @FindBy(xpath = "iframe[title='Secure CVC input frame']")
    private WebElement cvviframe;

    public WebElement getSalesforcecvviframeIframe() {
        return cvviframe;
    }
    @FindBy(css = "div.sfpp-payment-method-header-saved")
    private List<WebElement> savedCardsSalesforce;

    public List<WebElement> getSavedCardsSalesforce() {
        return savedCardsSalesforce;
    }
    @FindBy(css = "input.sfpp-save-payment-method-input")
    private WebElement saveToaccountInSalesforce;

    public WebElement getSaveToaccountInSalesforce() {
        return saveToaccountInSalesforce;
    }
    
    @FindBy(xpath = "//div[contains(text(),'Credit Card')]")
    private List<WebElement> clickOnSalesforceCreditCardButton;

    public List<WebElement> getClickOnSalesforceCreditCard() {
        return clickOnSalesforceCreditCardButton;
    }
    @FindBy(xpath = "//div[contains(text(),'Credit Card')]")
    private WebElement clickOnSalesforceButton;

    public WebElement getSalesforceCreditCard() {
        return clickOnSalesforceButton;
    }
    
    @FindBy(xpath = "//div[contains(text(),'Your card number is invalid.')]")
    WebElement salesforceCardInvalidError;
    
    public WebElement getSalesforceCardInvalidError() {
    	return salesforceCardInvalidError;
    }
    @FindBy(css = "div.sfpp-payment-method-card-expiry-error")
    WebElement salesforceExpInvalidError;
    
    public WebElement getSalesforceExpInvalidError() {
    	return salesforceExpInvalidError;
    }
    
    
    
    //stripe
    @FindBy(xpath = "//input[@autocomplete='cc-number' and @inputmode='numeric']")
    private WebElement newCardNumber;

    public WebElement getStripeCardNumber() {
        return newCardNumber;
    }
    @FindBy(css = "iframe[title='Secure card payment input frame']")
    private WebElement iframeStripeCardNum;

    public WebElement getIframeStripeCardNum() {
        return newCardNumber;
    }
    @FindBy(xpath = "//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    private WebElement expDate;

    public WebElement getStripeExpDate() {
        return expDate;
    }
    @FindBy(xpath = "iframe[title='Secure card payment input frame']")
    private WebElement iframeExpDate;

    public WebElement getStripeIframeExpDate() {
        return iframeExpDate;
    }
    @FindBy(xpath = "//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    private WebElement cvvStripe;

    public WebElement getStripeCvv() {
        return cvvStripe;
    }
    //stripe postal code
    @FindBy(name="postal")
    WebElement postalCode;
    public WebElement getPostalCodeInStripe() {
    	return postalCode;
    }
    @FindBy(id = "saved-cards-container")
    private List<WebElement> stripeSavedCardsContainers;
    
    public List<WebElement> getStripeSavedCards() {
        return stripeSavedCardsContainers;
    }

    @FindBy(xpath = "//input[@name='saved_card_id']")
    private List<WebElement> countOfSavedCards;

    public List<WebElement> getCountOfSavedCards() {
        return countOfSavedCards;
    }
    @FindBy(id = "stripe_save_card")
    private WebElement checkButtonToSaveCards;

    public WebElement getStripeSaveCardsButtons() {
        return checkButtonToSaveCards;
    }
    @FindBy(id = "switch-to-add-card")
    private List<WebElement> addNewCardListStripe;

    public List<WebElement> getAddNewCardListStripe() {
        return addNewCardListStripe;
    }
    @FindBy(id = "switch-to-add-card")
    private WebElement addNewCardStripe;

    public WebElement getAddNewCardStripe() {
        return addNewCardStripe;
    }
    @FindBy(xpath = "//li[@data-method-id='CREDIT_CARD']")
    private List<WebElement> stripeCreditCardList;

    public List<WebElement> getStripeCreditCardList() {
        return stripeCreditCardList;
    }
    @FindBy(xpath = "//li[@data-method-id='CREDIT_CARD']")
    private WebElement stripeCreditCard;

    public WebElement getStripeCreditCard() {
        return stripeCreditCard;
    }
    @FindBy(id = "switch-to-saved-cards")
    private WebElement switchToSavedCardsStripe;

    public WebElement getswitchToSavedCardsStripe() {
        return  switchToSavedCardsStripe;
    }
    
   
    
    
    //errors meassage in paymnet 
    @FindBy(xpath = "//div[contains(text(),'Your card number is incomplete.')]")
    private WebElement salesforceCreditCardIncompleteError;

    public WebElement getSalesforceCreditCardIncompleteError() {
        return salesforceCreditCardIncompleteError;
    }
    //errors meassage in paymnet 
    @FindBy(xpath = "//div[contains(@class,'sfpp-payment-method-card-expiry-error')]")
    private WebElement salesforceCreditCardExpDateError;

    public WebElement getsalesforceCreditCardExpDateError() {
        return salesforceCreditCardExpDateError;
    }
  //errors meassage in paymnet 
    @FindBy(xpath = "//div[contains(@class,'sfpp-payment-method-card-cvc-error')]")
    private WebElement salesforceCreditCardCvvError;

    public WebElement getsalesforceCreditCvvError() {
        return  salesforceCreditCardCvvError;
    }
	
    //STRIPE
    //error messages in stripecarrd invalid card num
    @FindBy(id="card-errors")
    WebElement stripeCardInvalidCardError;
    
    public WebElement getStripeCardInvalidCardError() {
    	return stripeCardInvalidCardError;
    }
    //error msg for incomplete EXP DATE details
    @FindBy(id="card-errors")
    WebElement stripeCardExpDateInvalid;
    
    public WebElement getStripeCardExpDateInvalid() {
    	return stripeCardExpDateInvalid;
    }  
    
   
 
    //error msg for incomplete details
    @FindBy(xpath="//div[@id='card-errors']")
    WebElement stripeCardCardNumInComplete;
    
    public WebElement getStripeCardCardNumInComplete() {
    	return stripeCardCardNumInComplete;
    }
    
    //error msg for exp year
    @FindBy(xpath="//div[@id='card-errors']")
    WebElement stripeCardExpYearIncompleteError;
    
    public WebElement getStripeCardExpYearIncompleteError() {
    	return stripeCardExpYearIncompleteError;
    }
    
    //Error msg for incomplete details
    @FindBy(id="card-errors")
    WebElement stripeCardSecurityCodeIncomplete;
    
    public WebElement getStripeCardSecurityCodeIncompleteError() {
    	return stripeCardSecurityCodeIncomplete;
    } 
    
    //error msg for incomplete details
    @FindBy(xpath="//div[contains(text(),'Your postal code is incomplete.')]")
    WebElement stripeCardPostalCodeInComplete;
    
    public WebElement getStripeCardPostalCodeInComplete() {
    	return stripeCardPostalCodeInComplete;
    }
    
    
    @FindBy(xpath="(//div[@id='new-card-form-container'])[2]")
    WebElement clickOnStripeContainer;
    
    public WebElement getClickOnStripeContainer() {
    	return clickOnStripeContainer;
    }
    
    @FindBy(css="div.CardField-input-wrapper")
    WebElement stripeContainer;
    
    public WebElement getstripeContainer() {
    	return stripeContainer;
    }
    @FindBy(xpath ="//button[contains(text(),'Place Order')]")
  	List<WebElement> PlaceOrderBtnList;    
  	public List<WebElement> getSelectPlaceOrderBtnList(){
  		return PlaceOrderBtnList;
  	} 
	
    @FindBy(xpath ="//button[contains(text(),'Place Order')]")
  	WebElement PlaceOrderBtn;    
  	public WebElement getSelectPlaceOrderBtn(){
  		return PlaceOrderBtn;
  	} 
    // WebElement for Review Order button
    @FindBy(xpath = "//button[contains(text(), 'Next: Review Order')]")
    private WebElement reviewOrderBtn;
    public WebElement getReviewOrderBtn() {
        return reviewOrderBtn;
    }
    
    // WebElement for Review Order button
    @FindBy(xpath = "//button[contains(text(), 'Next: Review Order')]")
    private List<WebElement> reviewOrderBtnList;
    public List<WebElement> getReviewOrderBtnList() {
        return reviewOrderBtnList;
    }
   
   
    
    //adyen payment
    @FindBy(xpath = "//li[@data-method-id='AdyenComponent']")
    List<WebElement> adyenPayment;
    
    public List<WebElement> getAdyenPayment() {
		return adyenPayment;
	}
    @FindBy(xpath = "//iframe[@title='Iframe for card number']")
    WebElement adyenCardNumIframe;
	public WebElement getAdyenCardNumIframe() {
		return adyenCardNumIframe;
	}
	
	@FindBy(xpath = "//input[@data-fieldtype='encryptedCardNumber']")
    WebElement adyenCardNumInput;
	public WebElement getAdyenCardNumInput() {
		return adyenCardNumInput;
	}
	
	@FindBy(xpath = "//iframe[@title='Iframe for expiry date']")
    WebElement adyenExpDateIframe;
	public WebElement getAdyenExpDateIframe() {
		return adyenExpDateIframe;
	}
	
	
	@FindBy(xpath = "//input[@data-fieldtype='encryptedExpiryDate']")
    WebElement adyenExpDateInput;
	public WebElement getAdyenExpDateInput() {
		return adyenExpDateInput;
	}
	
	@FindBy(xpath = "//iframe[@title='Iframe for security code']")
    WebElement adyenSecCodeIframe;
	public WebElement getAdyenSecCodeIframe() {
		return adyenSecCodeIframe;
	}
	
	@FindBy(xpath = "//input[@data-fieldtype='encryptedSecurityCode']")
    WebElement adyenSecCodeInput;
	public WebElement getAdyenSecCodeInput() {
		return adyenSecCodeInput;
	}
	
	@FindBy(css= "input.adyen-checkout__card__holderName__input ")
    WebElement adyenHolderNameInput;
	public WebElement getAdyenHolderNameInput() {
		return adyenHolderNameInput;
	}
	
	//error msgs
	@FindBy(xpath= "//span[contains(text(),'Enter the expiry date')]")
    WebElement adyenExpiryDateError;
	public WebElement getAdyenExpiryDateError() {
		return adyenExpiryDateError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter the security code')]")
    WebElement adyenSecurityCodeError;
	public WebElement getAdyenSecurityCodeError() {
		return adyenSecurityCodeError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter name as shown on card')]")
    WebElement adyenHolderNameError;
	public WebElement getAdyenHolderNameError() {
		return adyenHolderNameError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter a valid card number')]")
    WebElement adyenInvalidCardNumError;
	public WebElement getAdyenInvalidCardNumError() {
		return adyenInvalidCardNumError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter a valid expiry date')]")
    WebElement adyenInvalidExpiryDateError;
	public WebElement getAdyenInvalidExpiryDateError() {
		return adyenInvalidExpiryDateError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter the complete card number')]")
    WebElement adyenIncompleteCardNumberError;
	public WebElement getAdyenIncompleteCardNumberError() {
		return adyenIncompleteCardNumberError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter the complete expiry date')]")
    WebElement adyenIncompleteExpYearError;
	public WebElement getAdyenIncompleteExpYearError() {
		return adyenIncompleteExpYearError;
	}
	
	@FindBy(xpath= "//span[contains(text(),'Enter the complete security code')]")
    WebElement adyenIncompleteSecurityCodeError;
	public WebElement getAdyenIncompleteSecurityCodeError() {
		return adyenIncompleteSecurityCodeError;
	}
	
	//GIFT CODES
	@FindBy(xpath="//input[@id='giftCert']")
 	WebElement giftcertificate;
 	public WebElement getGiftcertificateInput() {
 		return giftcertificate;
 	}
 	//to apply gift card
 	@FindBy(xpath = "//button[@value='submit-gifrcert']")
 	WebElement applyGiftCard;
 	public WebElement getApplyGiftCardButton() {
 		return applyGiftCard;
 	}
 	
 	//check gift card bal 
 	@FindBy(xpath = "//button[@value='gift-cert-balance']")
 	WebElement giftcardCheckButtonBal;
 	public WebElement getGiftcardCheckButtonBal() {
 		return giftcardCheckButtonBal;
 	}
 	
	//check gift card bal 
 	@FindBy(xpath = "//div[contains(@class,'balance success')]")
 	List<WebElement> giftCardBalMsgList;
 	public List<WebElement> getGiftCardBalMsgList() {
 		return giftCardBalMsgList;
 	}
 	
	@FindBy(xpath = "//button[@value='gift-cert-balance']")
 	WebElement checkBalanceButton;
 	public WebElement getCheckBalanceButton() {
 		return checkBalanceButton;
 	}
    
 	@FindBy(xpath = "//a[@class='remove']")
 	List<WebElement> removeGc;
 	public List<WebElement> getRemoveGc() {
 		return removeGc;
 	}
//check gift card bal 
 	@FindBy(xpath = "//div[contains(@class,'balance success')]")
 	WebElement giftCardBalMsg;
 	public WebElement getGiftCardBalMsg() {
 		return giftCardBalMsg;
 	}
 	
 	@FindBy(xpath = "//div[contains(text(),'Insufficient Gift Certificate balance')]")
 	List<WebElement> insufficientGiftCodeBalError;
 	public List<WebElement> getInsufficientGiftCodeBalError() {
 		return insufficientGiftCodeBalError;
 	}
 	
 	@FindBy(xpath = "//div[contains(text(),'Gift card belongs to a different customer')]")
 	List<WebElement> gcBelongsToDifferentCustomerError;
 	public List<WebElement> getGcBelongsToDifferentCustomerError() {
 		return gcBelongsToDifferentCustomerError;
 	}
 	
 	@FindBy(xpath = "//div[contains(text(),'Invalid Gift Certificate Code.')]")
 	List<WebElement> invalidGcError;
 	public List<WebElement> getInvalidGcError() {
 		return invalidGcError;
 	}
 	
 	@FindBy(xpath = "//div[contains(text(),'Your order has been paid using gift certificates.')]")
 	List<WebElement> redemptionWithGcMsg;
 	public List<WebElement> getRedemptionWithGcMsg() {
 		return redemptionWithGcMsg;
 	}
 	
	
 	@FindBy(xpath = "//div[@class='success giftcert-pi']")
 	List<WebElement> successGiftCodeRedemptionMsg;
 	public List<WebElement> getsuccessGiftCodeRedemptionMsg() {
 		return successGiftCodeRedemptionMsg;
 	}

 	@FindBy(xpath = "//label[@for='giftCert']")
 	List<WebElement> giftCertificateLabel;
 	public List<WebElement> getGiftCertificateLabel() {
 		return giftCertificateLabel;
 	}
 	

 	@FindBy(xpath = "//div[contains(text(),'Please enter a gift certificate code.')]")
 	List<WebElement> enterGiftCodeErrorMsg;
 	public List<WebElement> getEnterGiftCodeErrorMsg() {
 		return enterGiftCodeErrorMsg;
 	}
 	

 	@FindBy(xpath = "//div[contains(text(),'Please enter a Phone Number.')]")
 	List<WebElement> billingPhoneNumberError;
 	public List<WebElement> getBillingPhoneNumberError() {
 		return billingPhoneNumberError;
 	}
 	
 	//paypal

 	@FindBy(xpath = "img[title='PayPal Credit']")
 	List<WebElement> brainPaypalAcc;
 	public List<WebElement> getBrainPaypalAcc() {
 		return brainPaypalAcc;
 	}
 	
	@FindBy(xpath = "(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]")
 	List<WebElement> salesforcePaypalList;
 	public List<WebElement> getSalesforcePaypalList() {
 		return salesforcePaypalList;
 	}
 	
	@FindBy(xpath = "(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]")
 	WebElement salesforcePaypal;
 	public WebElement getSalesforcePaypalButton() {
 		return salesforcePaypal;
 	}
 	@FindBy(xpath = "//img[@alt='PayPal Credit']")
    WebElement brainTreePaypalButton;
 	public WebElement getBrainTreePaypalButton() {
 		return brainTreePaypalButton;
 	}
 	
 	 @FindBy(xpath = "//input[@name='login_email']")
     List<WebElement> emailLoginList;
 	public List<WebElement> getEmailLoginList() {
  		return emailLoginList;
  	}
 	
 	@FindBy(xpath = "//input[@name='login_email']")
     WebElement emailLogin;
 	public WebElement getEmailLogin() {
  		return emailLogin;
  	}

     @FindBy(css = "#btnNext")
     List<WebElement> nextButtonList;
 	public List<WebElement> getNextButtonList() {
  		return nextButtonList;
  	}

 	@FindBy(css = "#btnNext")
     WebElement nextButton;
 	public WebElement getNextButton() {
  		return nextButton;
  	}
 		
     @FindBy(xpath = "//input[@id='password']")
     List<WebElement> passwordList;
 	public List<WebElement> getPasswordList() {
  		return passwordList;
  	}

 	@FindBy(xpath = "//input[@id='password']")
     WebElement password;
 	public WebElement getPassword() {
  		return password;
  	}
     @FindBy(xpath = "//button[contains(text(), 'Log In')]")
     List<WebElement> loginbuttonList;
 	public List<WebElement> getloginbuttonList() {
  		return loginbuttonList;
  	}
 	
 	@FindBy(xpath = "//button[contains(text(), 'Log In')]")
     WebElement loginbutton;
 	public WebElement getloginbutton() {
  		return loginbutton;
  	}
     @FindBy(xpath = "(//div[@class='FundingInstrument_item_3lQ2z'])[3]")
     WebElement cardParentDiv;
     
     @FindBy(xpath = "changeShippingAddress")
     List<WebElement> changeTheAddressList;

     @FindBy(id = "payment-submit-btn")
     List<WebElement> reviewOrderButtonList;
 	public List<WebElement> getReviewOrderButtonList() {
  		return reviewOrderButtonList;
  	}
     
 	@FindBy(id = "payment-submit-btn")
     WebElement reviewOrderButton;
 	public WebElement getReviewOrderButton() {
  		return reviewOrderButton;
  	}
 	
 	@FindBy(xpath= "//button[contains(text(), 'Complete Purchase')]")
     WebElement completePurcharseButton;
 	public WebElement getCompletePurcharseButton() {
  		return completePurcharseButton;
  	}
 	
     @FindBy(xpath = "//button[contains(text(), 'Save and Continue')]")
     List<WebElement> saveAndContinueList;
 	public List<WebElement> getSaveAndContinueList() {
  		return saveAndContinueList;
  	}
     
 	@FindBy(xpath = "//button[contains(text(), 'Save and Continue')]")
     WebElement saveAndContinue;
 	public WebElement getSaveAndContinue() {
  		return saveAndContinue;
  	}
 	
}


