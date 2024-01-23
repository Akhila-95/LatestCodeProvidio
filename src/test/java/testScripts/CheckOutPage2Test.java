package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.CheckOutPage2Tasks;

public class CheckOutPage2Test extends baseClass {

	@Test
	public  void verifyingTheCustomerInfoInCheckoutPage2() throws InterruptedException, Exception {
		CheckOutPage2Tasks.getCutomerInfo();
	}
	
	@Test
	public void verifyingEditEmailInCheckoutPage2() throws Exception {
		CheckOutPage2Tasks.editEmailInCheckoutPage2();
	}
	
	@Test
	public void verifyingPaginationOfProductsInCheckOutPage2() throws Exception {
		CheckOutPage2Tasks.paginationOfProductsInCheckOutPage2();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInCheckOutPage2Tasks_Page() throws Exception {
		CheckOutPage2Tasks.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingNextPaymentButtonDisplayInCheckOutPage2Tasks_Page() throws Exception {
		CheckOutPage2Tasks.getNextPaymentButton();
	}
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInCheckOutPage2Tasks_Page() throws Exception {
		CheckOutPage2Tasks.getEtgLogo();
	}

	@Test(groups = {"smoke", "regression"})
    public void verifyingAllErrorsInShippingForm() throws Exception {
		CheckOutPage2Tasks.allErrorsInShippingForm();
    }	

	@Test(groups = {"smoke", "regression"})
    public void verifyingTheErrorsInFirstName() throws Exception {
		CheckOutPage2Tasks.firstNameError();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifyingTheErrorsInLastName() throws Exception {
		CheckOutPage2Tasks.lastNameError();
    }
	@Test(groups = {"smoke", "regression"})
    public void verifyingTheAddressError() throws Exception {
		CheckOutPage2Tasks.addressError();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifyingphoneNumberError() throws Exception {
		CheckOutPage2Tasks.phoneNumberError();
    }
	@Test(groups = {"smoke", "regression"})
    public void verifyingWithValidShippingAddress() throws Exception {
		CheckOutPage2Tasks.enterValidAddress();
    }
	
	
}
