package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;
import tasks. ReviewOrderPageTask;


public class ReviewOrderTest extends baseClass{

	
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
	public  void verifyingTheEditPaymentToPaypalFromReviewOrderPage() throws InterruptedException, Exception {
		 ReviewOrderPageTask.editPaymentToPaypal();
	}
	
}
