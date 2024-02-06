package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.ShippingPageTasks;

public class ShippingPageTest extends baseClass {

	@Test
	public  void verifyingTheCustomerInfoInCheckoutPage2() throws InterruptedException, Exception {
		ShippingPageTasks.getCutomerInfo();
	}
	
	@Test
	public void verifyingBackToCartFromShippingPage() throws Exception {
		ShippingPageTasks.getBackToCart();
	}
	
	@Test
	public void verifyingPaginationOfProductsInCheckOutPage2() throws Exception {
		ShippingPageTasks.paginationOfProductsInCheckOutPage2();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInShippingPageTasks_Page() throws Exception {
		ShippingPageTasks.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingNextPaymentButtonDisplayInShippingPageTasks_Page() throws Exception {
		ShippingPageTasks.getNextPaymentButton();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInShippingPageTasks_Page() throws Exception {
		ShippingPageTasks.getEtgLogo();
	}

	@Test(groups = {"smoke", "regression"})
    public void verifyingAllErrorsInShippingForm() throws Exception {
		ShippingPageTasks.allErrorsInShippingForm();
    }	

	@Test(groups = {"smoke", "regression"})
    public void verifyingTheErrorsInFirstName() throws Exception {
		ShippingPageTasks.firstNameError();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifyingTheErrorsInLastName() throws Exception {
		ShippingPageTasks.lastNameError();
    }
	@Test(groups = {"smoke", "regression"})
    public void verifyingTheAddressError() throws Exception {
		ShippingPageTasks.addressError();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifyingphoneNumberError() throws Exception {
		ShippingPageTasks.phoneNumberError();
    }
	@Test(groups = {"smoke", "regression"})
    public void verifyingWithValidShippingAddress() throws Exception {
		ShippingPageTasks.enterValidAddress();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifyingAddNewShippingAddressAndPlaceOrder() throws Exception {
		ShippingPageTasks.addNewAddress();
    }
	
	@Test(groups = {"smoke", "regression"})
    public void verifyingUpdateShippingAddressAndPlaceOrder() throws Exception {
		ShippingPageTasks.updateNewShippingAddress();

	}

	@Test
	public void verifyingEditEmailFromShippingPageAndPlaceOrder() throws Exception {
		ShippingPageTasks.editEmailInCheckoutPage2();
	}
	
	
}
