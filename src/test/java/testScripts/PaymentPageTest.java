package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.PaymentPageTasks;
import tasks.ShippingPageTasks;

public class PaymentPageTest extends baseClass{

	@Test
	public  void verifyingTheCustomerInfoInPaymntPage() throws InterruptedException, Exception {
		PaymentPageTasks.getCutomerInfoInPaymentPage();
	}
	
	@Test
	public void verifyingPaginationOfProductsInPaymentPage() throws Exception {
		PaymentPageTasks.paginationOfProductsInPaymentPage();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingPaymentInfoDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getPaymentForm();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getEtgLogo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingBackToCartInPaymentPage() throws Exception {
		PaymentPageTasks.getBackToCart();
	}
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
	public static void verifyingBillingPhoneNumberError() throws Exception {
		PaymentPageTasks. billingPhoneNumber();
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
    public void verifyingEnterGiftCodeErrorMsg() throws Exception {       
    	PaymentPageTasks.getEnterGiftCodeErrorMsg();
    }
    
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingInvalidGcErrorMsg() throws Exception {       
    	PaymentPageTasks.getInvalidGcCode();
    }
    
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCheckBalanceOfValidGc() throws Exception {       
    	PaymentPageTasks.getCheckBalOfValidGc();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingCheckBalanceOfInvalidGcErrorMsg() throws Exception {       
    	PaymentPageTasks.getCheckBalOfInvalidGc();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingSuccesMessageForValidGcApplied() throws Exception {       
    	PaymentPageTasks.applyValidGc();
    }
    
    @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
    public void verifyingRemovalOfAppliedGc() throws Exception {       
    	PaymentPageTasks.removeAppliedGc();
    }
        
    
}
