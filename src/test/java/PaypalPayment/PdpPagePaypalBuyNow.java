package PaypalPayment;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.ProductDetailPage;
import pageObjects.homepage;
import tasks.OrderDetailPageTasks;
import tasks.ProductListingPageTasks;
import tasks.ReviewOrderPageTask;
import validations.OrderPageValidation;


public class PdpPagePaypalBuyNow extends baseClass{

	private static final ProductDetailPage pdp = new ProductDetailPage(driver);
	private static homepage homePage = new homepage(driver);
	
	public static void pdpPage() throws Exception {
		if(Actionsss.elementSize(pdp.getPdpPagination())) {
			logger.info("Pdp page is loaded");
		}else {
			ProductListingPageTasks.productclick();
		}
	}
	
	public static void pdpPagePaypal() throws Exception {
		pdpPage();
		allAttributesSelection.selectTheAttributesInPdp();
		Actionsss.scrollWindowsByPixel(150);
		Thread.sleep(1000);
		test.info("Verifying payment with paypal buy Now in PDP page");
		if(Actionsss.elementSize(pdp.getSalesforcePaypalBuyNowList())){
			Actionsss.click(pdp.getSalesforcePaypalBuyNow());
			PaypalMethod.paypalPopup();
			ReviewOrderPageTask.placeOrder();
			OrderPageValidation.paymentInOrderConfirmationPage();			
			OrderDetailPageTasks.getOrderConfirmationPage();
			Actionsss.click(homePage.clickOnLogo());
		}else {
			logger.info("No paypal buy now configuration in PDP in this payment");
			test.info("No paypal buy now configuration in PDP in this payment");
			test.pass("No paypal buy now configuration in PDP in this payment");
			Actionsss.click(homePage.clickOnLogo());
		}
	}
}
