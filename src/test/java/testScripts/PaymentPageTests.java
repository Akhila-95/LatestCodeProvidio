package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PaymentPageTasks;


public class PaymentPageTests extends baseClass{
	
	// Test method to verify sortby
    @Test(groups = {"regression"})
    public void VerifedThatPaymentDetailsEnteredInPayMentPage() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	PaymentPageTasks.EnteringPaymentDetails();
    }

    @Test(groups = {"regression"})
    public void VerifedThatPaymentDetails() throws Exception {
        // Call the verifythatButtonClick method from homePageTasks class
    	PaymentPageTasks.paymentDetails();
    }

    @Test(groups = {"regression"})
    public void VerifedThatAllTheErrorsInCreditCard() throws Exception {
        
    	PaymentPageTasks.allErrorsInCreditCard();
    }
    
    @Test(groups = {"regression"})
    public void VerifedThatThecardCvvAndExpErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvAndExpErrorMessage();
    }
    @Test(groups = {"regression"})
    public void VerifedThatThecardCvvErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvErrorMessage();
    }
    
    @Test(groups = {"regression"})
    public void VerifedThatTheCreditcardWithValidDetails() throws Exception {
        
    	PaymentPageTasks.creditCardWithValidDetails();
    }
}
