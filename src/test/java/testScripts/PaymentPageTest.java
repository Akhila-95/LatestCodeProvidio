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
	

	@Test// 
	public void verifyingOrderSummaryDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getOrderSummary();
	}
	
	@Test// 
	public void verifyingPaymentInfoDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getPaymentForm();
	}
	
	@Test// 
	public void verifyingEtgLogoDisplayInPaymentPage() throws Exception {
		PaymentPageTasks.getEtgLogo();
	}
	
	@Test// 
	public void verifyingBackToCartInPaymentPage() throws Exception {
		PaymentPageTasks.getBackToCart();
	}
	
	@Test
	public static void verifyingGiftMessage() throws Exception {
		PaymentPageTasks.editGiftMessageInCop2();
	}
	@Test
	public static void verifyingEditCustomerInfoFromPaymentPageAndPlaceOrder() throws Exception {
		PaymentPageTasks.editCustomerInfoFromCop3();
	}
	
	@Test
	public static void verifyingEditShippingAddressFromPaymentPageAndPlaceOrder() throws Exception {
		PaymentPageTasks.editShippindAddressFromPaymentPage();
	}
	
	
	@Test
	public static void verifyingUpdateBillingAddressAndPlaceOrder() throws Exception {
		PaymentPageTasks.updateBillingAddress();
	}
	
	@Test
	public static void verifyingAddNewBillingAddressFromPaymentPageAndPlaceOrder() throws Exception {
		PaymentPageTasks.addNewBillingAddress();
	}
	
	
	@Test
	public static void verifyingBillingPhoneNumberError() throws Exception {
		PaymentPageTasks.billingPhoneNumber();
	}
	
	//payment
    @Test
    public void verifyingAllTheErrorsInCreditCard() throws Exception {
        
    	PaymentPageTasks.allErrorsInCreditCard();
    }
    
    @Test
    public void verifyingCvvAndExpErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvAndExpErrorMessage();
    }
    
    @Test
    public void verifyingCvvErrorInCreditCard() throws Exception {
        
    	PaymentPageTasks.CreditCardCvvErrorMessage();
    }
    
    @Test
    public void verifyingCreditcardNumberInValidError() throws Exception {
        
    	PaymentPageTasks.creditcardNumberInValidError() ;
    }
    
    @Test
    public void verifyingCreditCardExpDateInValid() throws Exception {
        
    	PaymentPageTasks.creditCardExpDateInValid();
    }
    
    @Test
    public void verifyingCreditCardNumberInCompleteError() throws Exception {
        
    	PaymentPageTasks.creditCardNumberInCompleteError();
    }
    
    @Test
    public void verifyingCreditCardInCompleteExpYearError() throws Exception {
        
    	PaymentPageTasks.creditCardInCompleteExpYearError();
    }
    
    @Test
    public void verifyingCreditCardInCompleteCvvError() throws Exception {
        
    	PaymentPageTasks.creditCardInCompleteCvvError();
    }
    
    @Test
    public void verifyingCreditcardWithValidDetails() throws Exception {
        
    	PaymentPageTasks.creditCardWithValidDetails();
    }
    
    
    @Test
    public void verifyingAddnewCreditCard() throws Exception {       
    	PaymentPageTasks.addNewCreditCard();
    }
    
    //gc
    
    @Test
    public void verifyingEnterGiftCodeErrorMsg() throws Exception {       
    	PaymentPageTasks.getEnterGiftCodeErrorMsg();
    }
    
    
    @Test 
    public void verifyingInvalidGcErrorMsg() throws Exception {       
    	PaymentPageTasks.getInvalidGcCode();
    }
    
    
    @Test 
    public void verifyingCheckBalanceOfValidGc() throws Exception {       
    	PaymentPageTasks.getCheckBalOfValidGc();
    }
    
    @Test 
    public void verifyingCheckBalanceOfInvalidGcErrorMsg() throws Exception {       
    	PaymentPageTasks.getCheckBalOfInvalidGc();
    }
    
    @Test 
    public void verifyingSuccesMessageForValidGcApplied() throws Exception {       
    	PaymentPageTasks.applyValidGc();
    }
    
    @Test 
    public void verifyingRemovalOfAppliedGc() throws Exception {       
    	PaymentPageTasks.removeAppliedGc();
    }
        
    
}
