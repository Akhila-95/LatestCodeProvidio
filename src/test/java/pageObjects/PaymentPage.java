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
    private List<WebElement> clickOnSalesforceCreditCard;

    public List<WebElement> getClickOnSalesforceCreditCard() {
        return clickOnSalesforceCreditCard;
    }
    @FindBy(xpath = "//div[contains(text(),'Credit Card')]")
    private WebElement clickOnSalesforce;

    public WebElement getSalesforceCreditCard() {
        return clickOnSalesforce;
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
	
    @FindBy(xpath ="//button[contains(text(),'Place Order')]")
  	WebElement PlaceOrderBtn; 
  	public WebElement getSelectPlaceOrderBtn(){
  		return PlaceOrderBtn;
  	} 
	
    // WebElement for Review Order button
    @FindBy(xpath = "//button[contains(text(), 'Next: Review Order')]")
    private WebElement reviewOrderBtn;

    // Method to get the Review Order WebElement
    public WebElement getReviewOrderBtn() {
        return reviewOrderBtn;
    }
   
	/*
	//BrainTree credit card  of xpaths, actionMethods and passing card details
	//braintree newcarddropdown 
	@FindBy(xpath ="//select[@id='braintreeCreditCardList']")
    WebElement newcard;
	public void selectnewcardindropdown() throws InterruptedException {
    Select newcardselect = new Select(newcard);
    newcardselect.selectByIndex(0);
    Thread.sleep(3000);
    
	}
	
	//Braintree cardname
	@FindBy(xpath ="//input[@id = 'cardholder-name']")
	WebElement entercname;
    public void setcardholdername() throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-cardholderName");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercname);
    	entercname.sendKeys("Test123");
    	driver.switchTo().defaultContent();
    }
    //Braintree cardnumber 
	@FindBy(xpath ="//input[@id = 'credit-card-number']")
	WebElement entercnumber;
    public void setcardnumber(  ) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-number");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", entercnumber);
    	String[] cardNumbers = {

                "378282246310005",
     	       "371449635398431",
     	       "36259600000004",
     	       "6011000991300009",
     	       "3530111333300000",
     	       "6304000000000000",
     	       "5555555555554444",	        
     	      "2223000048400011",
     	       "4111111111111111",
     	       "4005519200000004",
     	       "4009348888881881",
     	       "4012000033330026",
     	       "4012000077777777",
     	       "4012888888881881",	        
     	       "4217651111111119",
     	       "4500600000000061",
     	       "6243030000000001",
     	       "6221261111117766",
     	       "6223164991230014"
                // Add more card numbers here
            };

    	// Generate a random index to select a card number
       
        int randomIndex = random.nextInt(cardNumbers.length);
        // Send the randomly selected card number
        entercnumber.sendKeys(cardNumbers[randomIndex]);
    	
    	driver.switchTo().defaultContent();
    }
    //Braintree cvv
	@FindBy(xpath ="//input[@id = 'cvv']")
	WebElement entercvv;
    public void setcardcvv(  ) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-cvv");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  entercvv);
    	entercvv.sendKeys("123");
    	driver.switchTo().defaultContent();
    }
    //Braintree exp
	@FindBy(xpath ="//input[@id = 'expiration']")
	WebElement enterexp;
    public void setcardexp(  ) throws InterruptedException {	    	
    	driver.switchTo().frame("braintree-hosted-field-expirationDate");
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",enterexp);
    	enterexp.sendKeys("1230");
    	driver.switchTo().defaultContent();
    }
    
    //Braintree savecardbutton
	@FindBy(xpath ="//input[@id='braintreeSaveCreditCard']")
	WebElement savebutton;
    public void unchecksavecard(  ) throws InterruptedException {	    	
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", savebutton);	
    }
    
    
    //Cybersource credit card Xpaths, actionMethods and passing the card details
    
    //CyberSource cardNumber
    @FindBy(xpath ="//input[@id ='cardNumber']")
    WebElement newCreditcard;
    public void latestcardnumber() throws InterruptedException {	    	
    	String[] cardNumbers = {
   			 "4111 1111 1111 1111",
		         "4242 4242 4242 4242",
		         "5555 5555 5555 4444",
		         "5200 8282 8282 8210",
		         "3714 4963 539 8431"
               // Add more card numbers here
           };

   	// Generate a random index to select a card number
       
       int randomIndex = random.nextInt(cardNumbers.length);
       // Send the randomly selected card number
       newCreditcard.sendKeys(cardNumbers[randomIndex]);
        Thread.sleep(2000);
    }
    //CyberSource exp month
    @FindBy(xpath ="//select[@id ='expirationMonth']")
    WebElement newExpmonth;
    public void latestExpDate(  ) throws InterruptedException {
    	Select newcardselect = new Select(newExpmonth);
        newcardselect.selectByIndex(9);
        Thread.sleep(3000);

    }
    //CyberSource exp year
    @FindBy(xpath ="//select[@id ='expirationYear']")
    WebElement newExpYear;
    public void latestExpYear(  ) throws InterruptedException {	
    	Select newcardselect = new Select(newExpYear);
        newcardselect.selectByIndex(7);
        Thread.sleep(3000);
    }
    //CyberSource cvv
    @FindBy(xpath ="//input[@id ='securityCode']")
    WebElement newSceuritycode;
    public void latestSceuritycode(  ) throws InterruptedException {	  
    	newSceuritycode.sendKeys("789");
        Thread.sleep(2000);
    }
    
    //cybersource 
  //CyberSource cvv
    @FindBy(xpath ="//button[contains(@class,'add-payment')]")
    WebElement AddpaymentBtn;
    public void cyberAddpaymentBtn(  ) throws InterruptedException {	 
    	js.executeScript("arguments[0].click();", AddpaymentBtn);
    	//AddpaymentBtn.click();
        Thread.sleep(2000);
    }
	
    
   //salesForce CreditCard xpaths, actionMethods and passing the details of the card
    
    //SalesForce credit cardName
    @FindBy(xpath ="//input[@autocomplete='cc-number' and @inputmode='numeric']")
    WebElement cardNumber;
    public void cardNumber() throws InterruptedException {	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card number input frame']")));
        Thread.sleep(2000);
        String[] cardNumbers = {

        		"4111 1111 1111 1111",
 		        "4242 4242 4242 4242",
 		        "2223 0031 2200 3222",
 		        "4000 0566 5566 5556",
 		        "5555 5555 5555 4444",
 		        "5200 8282 8282 8210",
 		        "3714 4963 539 8431"

                // Add more card numbers here
            };

    	// Generate a random index to select a card number
        
        int randomIndex = random.nextInt(cardNumbers.length);

        // Send the randomly selected card number
        cardNumber.sendKeys(cardNumbers[randomIndex]);
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    
    //SalesForce Exp Date
    @FindBy(xpath ="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    WebElement expiryDate;
    public void expiryDate() throws InterruptedException {		    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure expiration date input frame']")));
    	expiryDate.sendKeys("1225");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    //SalesFroce cvv
    @FindBy(xpath ="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    WebElement cvc;
    public void cvc(  ) throws InterruptedException {	  
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure CVC input frame']")));
    	 cvc.sendKeys("123");
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
    }
    
    //Salesforce reg credit card button
    @FindBy(xpath="//div[text()='Credit Card']")
    WebElement creditCardBtn;
    public void creditCard(  ) {

		js.executeScript("arguments[0].click();", creditCardBtn);
    	//creditCardBtn.click();
    }
    
    
    //Stripe credit card of xpaths, actionMethods and passing the card details
    JavascriptExecutor js = (JavascriptExecutor) driver;
    //add new card button for register 
    @FindBy(xpath="//a[text()='Add a new card']")
    WebElement addNewCardBtn;
    public void newCardbtn(  ) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", addNewCardBtn);
    	//addNewCardBtn.click();
    }
    
    
    //stripe  CardNumber
    @FindBy(xpath="//input[@autocomplete='cc-number' and @inputmode='numeric']")
    WebElement newCardNumber;
    public void cardNum() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
        String[] cardNumbers = {

        		"4111 1111 1111 1111",
 		        "4242 4242 4242 4242",
 		        "2223 0031 2200 3222",
 		        "4000 0566 5566 5556",
 		        "5555 5555 5555 4444",
 		        "5200 8282 8282 8210",
 		        "3714 4963 539 8431"

                // Add more card numbers here
            };
    	// Generate a random index to select a card number
        int randomIndex = random.nextInt(cardNumbers.length);
        // Send the randomly selected card number
        newCardNumber.sendKeys(cardNumbers[randomIndex]);
    	 driver.switchTo().defaultContent();
    }
    //stripe exp date
    @FindBy(xpath="//input[@autocomplete='cc-exp' and @inputmode='numeric']")
    WebElement expDate;
    public void expDate(  ) {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("iframe[title='Secure card payment input frame']")));
    	newCardNumber.sendKeys("11 33");
    }
    //stripe cvv
    @FindBy(xpath="//input[@autocomplete='cc-csc' and @inputmode='numeric']")
    WebElement cvv;
    public void cvv() {
    	cvv.sendKeys("987");
    }
    //stripe postal code
    @FindBy(name="postal")
    WebElement postalCode;
    public void postalCode() {
    	postalCode.sendKeys("958475");
    	driver.switchTo().defaultContent();
    }
    
    
    //stripe save my card
    @FindBy(xpath="//span[text()='Save Card to Account']")
    WebElement stripeSaveCard;
    public void stripeSaveCreditCard(  ) {
    	js.executeScript("arguments[0].click();", stripeSaveCard);	
    	//stripeSaveCard.click();
    }
    
    //use save cards for stripe payment method
    @FindBy(xpath="//a[text()='Add a new card']")
    WebElement useSaveCardsLink;
    public void useSaveCardsLinksStripe(  ) {
    	useSaveCardsLink.click();
    }
    
  //Phone
  	*/
}
