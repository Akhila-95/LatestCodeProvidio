package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;
import tasks. PlaceOrderPageTask;


public class PlaceOrderTest extends baseClass{
	
	@Test
	public  void verifyingTheEditPaymentToPaypalFromPlaceOrderPage() throws InterruptedException, Exception {
		 PlaceOrderPageTask.editPaymentToPaypal();
	}
	
	@Test
	public static void  verifyingPlaceOrderButton() throws Exception {
		PlaceOrderPageTask.placeOrder();
	}
	
	@Test
	public  void verifyingTheCustomerInfoInPaymntPage() throws InterruptedException, Exception {
		 PlaceOrderPageTask.getCutomerInfoInPaymentPage();
	}
	
	@Test
	public void verifyingPaginationOfProductsInPaymentPage() throws Exception {
		// PlaceOrderPageTask.paginationOfProductsInPaymentPage();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInPaymentPage() throws Exception {
		 PlaceOrderPageTask.getOrderSummary();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingPaymentInfoDisplayInPaymentPage() throws Exception {
		 PlaceOrderPageTask.getPaymentInfo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInPaymentPage() throws Exception {
		 PlaceOrderPageTask.getEtgLogo();
	}
	
	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingBackToCartInPaymentPage() throws Exception {
		// PlaceOrderPageTask.getBackToCart();
	}
	

	@Test//(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEditPayment() throws Exception {
		// PlaceOrderPageTask.getBackToCart();
	}
	
}
