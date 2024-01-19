package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PaymentPageTasks;


public class PaymentPageTests extends baseClass{
	
	// Test method to verify sortby
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingThatPaymentDetailsEnteredInPayMentPage() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	PaymentPageTasks.EnteringPaymentDetails();
    }

    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingPaymentDetails() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	PaymentPageTasks.paymentDetails();
    }

    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingAllTheErrorsInCreditCard() throws Exception {
        
    	PaymentPageTasks.allErrorsInCreditCard();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCvvAndExpErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvAndExpErrorMessage();
    }
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCvvErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvErrorMessage();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCreditcardNumberInValidError() throws Exception {
        
    	PaymentPageTasks.creditcardNumberInValidError() ;
    }
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCreditCardExpDateInValid() throws Exception {
        
    	PaymentPageTasks.creditCardExpDateInValid();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCreditCardNumberInCompleteError() throws Exception {
        
    	PaymentPageTasks.creditCardNumberInCompleteError();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCreditCardInCompleteExpYearError() throws Exception {
        
    	PaymentPageTasks.creditCardInCompleteExpYearError();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCreditCardInCompleteCvvError() throws Exception {
        
    	PaymentPageTasks.creditCardInCompleteCvvError();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCreditcardWithValidDetails() throws Exception {
        
    	PaymentPageTasks.creditCardWithValidDetails();
    }
    
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingAddnewCreditCard() throws Exception {
        
    	PaymentPageTasks.addNewCreditCard();
    }
}
