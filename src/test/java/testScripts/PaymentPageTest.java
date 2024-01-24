package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PaymentPageTasks;

public class PaymentPageTest extends baseClass{

	@Test
	public static void verifyingEditShippingAddress() throws Exception {
		PaymentPageTasks.editShippindAddressAndUpdate();
	}
	
	@Test
	public static void verifyingGiftMessage() throws Exception {
		PaymentPageTasks.editGiftMessageInCop2();
	}
	@Test
	public static void verifyingEditCustomerInfoFromCop3() throws Exception {
		PaymentPageTasks.editCustomerInfoFromCop3();
	}
	
	@Test
	public static void verifyingUpdateBillingAddress() throws Exception {
		PaymentPageTasks.updateBillingAddress();
	}
	
	@Test
	public static void verifyingAddNewBillingAddress() throws Exception {
		PaymentPageTasks.addNewBillingAddress();
	}
	
	@Test
	public static void verifyingEditPhoneNumberInBillingAddress() throws Exception {
		PaymentPageTasks.editPhoneNumber();
	}
	
	@Test
	public static void verifyingPaginationOfProductsFromPaymentPage() throws Exception {
		PaymentPageTasks.paginationOfProductsFromPaymentPage();
	}
	//payment
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
    
    //gc
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingGcRedemption() throws Exception {       
    	PaymentPageTasks.gcRedemption();
    	
    }
    
    
    
}
