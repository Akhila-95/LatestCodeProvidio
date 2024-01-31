package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;
import tasks. PlaceOrderPageTask;


public class PlaceOrderTest extends baseClass{
	
	@Test
	public  void verifyingTheEditPaymentToPaypalFromReviewOrderPage() throws InterruptedException, Exception {
		 PlaceOrderPageTask.editPaymentToPaypal();
	}
	
	@Test
	public static void  verifyingPlaceOrderButtonInReviewOrderPage() throws Exception {
		PlaceOrderPageTask.getPlaceOrder() ;
	}
	
	@Test
	public  void verifyingTheCustomerInfoInReviewOrderPage() throws InterruptedException, Exception {
		 PlaceOrderPageTask.getCutomerInfoInPaymentPage();
	}
	
	@Test
	public void verifyingPaginationOfProductsInReviewOrderPage() throws Exception {
		// PlaceOrderPageTask.paginationOfProductsInPaymentPage();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInReviewOrderPage() throws Exception {
		 PlaceOrderPageTask.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingPaymentInfoDisplayInReviewOrderPage() throws Exception {
		 PlaceOrderPageTask.getPaymentInfo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInReviewOrderPage() throws Exception {
		 PlaceOrderPageTask.getEtgLogo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingBackToCartInReviewOrderPage() throws Exception {
		// PlaceOrderPageTask.getBackToCart();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEditPayment() throws Exception {
		// PlaceOrderPageTask.getBackToCart();
	}
	
}
