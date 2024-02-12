package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.homepage;
import tasks.PaymentPageTasks;
import tasks. ReviewOrderPageTask;


public class ReviewOrderTest extends baseClass{
	private static homepage homePage = new homepage(driver);
	
	@Test
	public static void  verifyingPlaceOrderButtonDisplayInReviewOrderPage() throws Exception {
		ReviewOrderPageTask.getPlaceOrder() ;
	}
	
	@Test
	public  void verifyingTheDisplayOfCustomerInfoInReviewOrderPage() throws InterruptedException, Exception {
		 ReviewOrderPageTask.getCutomerInfoInReviewOrderPage();
	}
	
	@Test
	public void verifyingPaginationOfProductsInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.paginationOfProductsInReviewOrderPage();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingPaymentInfoDisplayInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getPaymentInfo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getEtgLogo();
	}
	
	
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingBackToCartInReviewOrderPage() throws Exception {
		 ReviewOrderPageTask.getBackToCart();
	}
	

	
	@Test
	public  void verifyingTheEditShippingAddressFromReviewOrderPageAndPlaceOrder() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editShippingAddressFromReviewOrderPage();
	}
	
	@Test
	public  void verifyingTheEditPhoneNumInShippingAddressFromReviewOrderPageAndPlaceOrder() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editPhoneNumInShippingAddressFromReviewOrderPage();
		 Actionsss.javascriptClick(homePage.clickOnLogo());
	}
	

	@Test
	public  void verifyingTheEditBillingAddressFromReviewOrderPageAndPlaceOrder() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editBillingAddressFromReviewOrderPage();
	}
	
	@Test
	public static void verifyingEditPhoneNumberInBillingAddressFromReviewOrderPageAndPlaceOrder() throws Exception {
		ReviewOrderPageTask.editPhoneNumberInBillingAddress();
	}
	
}
