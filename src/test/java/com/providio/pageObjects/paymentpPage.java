package com.providio.pageObjects;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.providio.testcases.baseClass;

import functionality.Actionsss;

public class paymentpPage extends baseClass {
	
WebDriver lDriver;
	
	public paymentpPage(WebDriver rDriver ){

		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	
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
    
    
    //edit the customer details in the payament page
	@FindBy(xpath = "//div[@class='card customer-summary']//button[contains(@class,'edit-button')]")
	WebElement editCustomerElement;
	@FindBy(xpath = "//input[@id='email-guest']")
	WebElement guestEmailElement;
	@FindBy(xpath = "//button[contains(text(),'Continue as guest')]")
	WebElement continueAsGuest;
	@FindBy(xpath = "//button[contains(@class ,'submit-shipping')]")
	WebElement nextPaymentButton;

	//Excuting method of the edit customer details in the payment page
	public void editCustomer(String guestEmail) throws InterruptedException {
		editCustomerElement.click();
		guestEmailElement.clear();
		guestEmailElement.sendKeys(guestEmail);
		continueAsGuest.click();
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", nextPaymentButton);
		
	}
	
	//editShipping Method
	public void editShippingMethod(  ) throws InterruptedException {
		Thread.sleep(5000);
		editShippingElement.click();
		List <WebElement> editShippingMethod=driver.findElements(By.xpath("(//div[@class='row leading-lines shipping-method-list'])[1]//input[@class='form-check-input']"));
		int  countShippingMethod = editShippingMethod.size();
		

		
		int randomRadioButton = random.nextInt(countShippingMethod) + 1;
		WebElement selectShippingMethod =driver.findElement(By.xpath("((//div[@class='row leading-lines shipping-method-list'])[1]//input[@class='form-check-input'])["+randomRadioButton+"]"));
		selectShippingMethod.click();
	}
    
    
    //editing the shipping details form the payment page
	@FindBy(xpath = "//div[@class='card shipping-summary']//button[contains(@class,'edit-button')]")
	WebElement editShippingElement;
	
	//Change the shipping address
	public void shippingDetailsChange() throws InterruptedException {
		//click on the edit button of shipping details in the payment page
		editShippingElement.click();
		
		//change the address of the customer
 	
        WebElement Address1 = driver.findElement(By.xpath("//input[@id='shippingAddressOnedefault']"));	
        //Random random = new Random();	
        int randomNumber = 4334; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);

	}
	
	
	//updating the billing address
	//to upadate the billing address
    @FindBy(xpath="//button[@class='text-center btn-show-details btn mr-2']")
    WebElement updateAddress;
    
    //change the billing address
    public void billingAddressChnge() throws InterruptedException {
   	 //click on the update address
   	 updateAddress.click();
   	 
   	 //change the billing adddress 
        WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));	
        //Random random = new Random();	
        int randomNumber = 4334; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);
   	 
    }
    
    //addNew address in the payment page
    //add new address
    @FindBy(xpath = "//div[@class='d-flex mt-2']//button[contains(@class,'add-new')]")
    WebElement newAddress;
    //billing first name
    @FindBy(xpath = "//input[@id='billingFirstName']")
    WebElement billingFirstName;
    //billing last name
    @FindBy(xpath = "//input[@id='billingLastName']")
    WebElement billingLastName;
    //adding the new address
    public void newAddress(String fName,String lName) throws InterruptedException {
   	 //click on new address in billing
   	 newAddress.click();
   	 billingFirstName.sendKeys(fName);
   	 billingLastName.sendKeys(lName);
   	 WebElement Address1 = driver.findElement(By.xpath("//input[@id='billingAddressOne']"));	
        //Random random = new Random();	
        int randomNumber = 658; // Generates a random number between 100 and 999	
        address = String.valueOf(randomNumber);	
        Address1.clear();	
        Address1.sendKeys(address);	
        WebElement Address11 = driver.switchTo().activeElement();
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Thread.sleep(1000);	
        Address11.sendKeys(Keys.ARROW_DOWN);	
        Address11.sendKeys(Keys.ENTER);	
        Thread.sleep(2000);

   	 JavascriptExecutor js = (JavascriptExecutor) driver;
   	 js.executeScript("window.scrollBy(0, 500)");
	}
    
    
  //gift card 
 	@FindBy(xpath="//input[@id='giftCert']")
 	WebElement giftcertificate;
 	//to apply gift card
 	@FindBy(xpath = "//button[@value='submit-gifrcert']")
 	WebElement applyGiftCard;
 	//check gift card bal 
 	@FindBy(xpath = "//button[@value='gift-cert-balance']")
 	WebElement checkGiftcardbal;
 	//applying the gift cart
 	public void applyGiftCertifiate(String giftcard) {
		giftcertificate.sendKeys(giftcard);
		applyGiftCard.click();
	}
 	
 	
 	//paypal Braintree payment process
    public void braintreePaypal(  ) throws InterruptedException {
        // Create an instance of Actions class
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
                      
        js.executeScript("arguments[0].click();", paypal);
        System.out.println("Clicked on paypal icon");
    }
    
    //After the paypal button click
    public void brainTreeAfterClick(  ) throws InterruptedException {
        WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
        WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
        if(regPaypalCheckoutText.isDisplayed()) {                	 
       	  
       	 
        }else { 
            JavascriptExecutor js = (JavascriptExecutor) driver;  
            WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
            if(paypalCheckout.isDisplayed()) {
           	   js.executeScript("arguments[0].click();", paypalCheckout);                	
               Thread.sleep(1000);
	        	if(paypalCheckout.isDisplayed()) {
	        		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  paypalCheckout);
	        		paypalCheckout.click();
	            }
            }	                 
         }                 
   }
    
   //SalesForce paypal payment page
    public void salesforcePaypalCheckout(  ) throws InterruptedException {
        WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
        Thread.sleep(4000);
        WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
        js.executeScript("arguments[0].click();", paypalCheckout);
       
        Thread.sleep(3000);
       // paypalCheckout.click();
       // Thread.sleep(10000);
        List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
        if(salesforcePaypalCheckout.size()>0) {
            WebElement salesforcePaypalCheckout1=parentDiv.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
          if(salesforcePaypalCheckout1.isDisplayed()) {
        	  	 Thread.sleep(3000);
            	 salesforcePaypalCheckout1.click();
            	 System.out.println("First click");
          }if(salesforcePaypalCheckout1.isDisplayed()) {    
              js.executeScript("arguments[0].click();", salesforcePaypalCheckout1);
             
          }
            	
        }
    }
    
    //addpaymentbutton
    @FindBy(xpath ="//button[@class ='btn btn-block add-payment btn-outline-primary']")
    WebElement addPayment;
    public void addPaymentButton(  ) throws InterruptedException {	  
    JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("arguments[0].click();", addPayment);
    	//addPayment.click
        Thread.sleep(2000);
    }
    
  //click on review order
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']")
	WebElement revieworder;
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block submit-payment'  and @value='submit-payment']")
	List<WebElement> revieworderList;
    public void clickonrevieworder(  ) throws InterruptedException {	
    	if(revieworderList.size()>0) {
	    	//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", revieworder);			    	
	    	Thread.sleep(5000);
	    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    	js.executeScript("arguments[0].click();", revieworder);
	    	Thread.sleep(3000);
	    	if(revieworder.isDisplayed()) {
	    		 Thread.sleep(3000);
		    	revieworder.click();	
		       
	        }
    	}
    }
    
    
    //Place the order for salesforce payment process
    @FindBy(xpath ="//button[@class='btn btn-primary btn-block place-order' and @name='submit' and contains(text(), 'Place Order')]")
    WebElement placetheOrder;
    public void placetheOrder(  ) throws InterruptedException {	  
    	JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", placetheOrder);
    	//placetheOrder.click();
        Thread.sleep(2000);
    }
    
    //paypal payment details
    
    @FindBy(xpath = "//img[@alt='PayPal Credit']")
    WebElement paypal;

    @FindBy(xpath = "//div[@aria-label='PayPal Checkout']")
    WebElement  paypalCheckout;

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
    public void paypalPopup() throws Exception {
    	
        String mainWindowHandle = driver.getWindowHandle();
        // Switch to the new window by iterating over all available window handles
        for (String handle : driver.getWindowHandles()) {
            if (!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        // test.info("Entered into paypal window");
        //	List<WebElement> paypalPage = driver.findElements(By.id("headerText"));
        //	System.out.println("The url for payapal is " + paypalPage.size());
         Thread.sleep(3000);
         if(Actionsss.elementSize(getEmailLoginList())) {
        	Actionsss.sendKeys( getEmailLogin(),"rahulnaik@etisbew.com", "User email");       	 
        	 test.info("Entered username");
         }
         Thread.sleep(3000);
         if(Actionsss.elementSize(getNextButtonList())) {
        	Actionsss.click(getNextButton());         
             Thread.sleep(1000);
         }
         if(Actionsss.elementSize(getPasswordList())) {
        	 Actionsss.sendKeys(getPassword(),"Etgsfcc245@", "password");               
             test.info("Entered password");
             Thread.sleep(1000);
         }
         if(Actionsss.elementSize(getloginbuttonList())) {
        	 Actionsss.click(getloginbutton());           
             Thread.sleep(1000);
         }
        

         Thread.sleep(2000);
         if(Actionsss.elementSize(getReviewOrderButtonList())) {
        	
         	try {
         		Actionsss.click(getReviewOrderButton());      		
 	            Thread.sleep(1000);
 	          //  Thread.sleep(4000);
 	        } catch (Exception e) {
 	        	Actionsss.javascriptClick(getReviewOrderButton());
 	            System.err.println("Exception while clicking the element: " + getReviewOrderButton());
 	        }
         	
         	logger.info("complete order");
         	Thread.sleep(4000);
   	
            	try {
            		Actionsss.click(getCompletePurcharseButton());
 	           		Thread.sleep(4000);
            	} catch (Exception e) {
	 	        	Actionsss.javascriptClick(getCompletePurcharseButton());
	 	            System.err.println("Exception while clicking the element: " +getCompletePurcharseButton());
            	}         	
        	                	
         }else {
        	 if(Actionsss.elementSize(getSaveAndContinueList())) {
        		 Actionsss.click(getSaveAndContinue());
        	 }
         }                 
         driver.switchTo().window(mainWindowHandle);
         Thread.sleep(1000);
         
      }          
		    
}
