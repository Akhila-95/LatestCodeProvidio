package Payments;

import com.providio.testcases.baseClass;

import Paypal.PaypalMethod;
import functionality.Actionsss;
import functionality.allAttributesSelection;
import pageObjects.ProductDetailPage;
import pageObjects.ProductListingPage;
import tasks.OrderDetailPageTasks;
import tasks.PlaceOrderPageTask;
import tasks.ProductListingPageTasks;
import validations.ProductListingPageValidations;

public class PdpPagePaypalBuyNow extends baseClass{

	private static final ProductDetailPage pdp = new ProductDetailPage(driver);
	
	public static void pdpPage() throws Exception {
		if(Actionsss.elementSize(pdp.getPdpPagination())) {
			logger.info("Pdp page is loaded");
		}else {
			ProductListingPageTasks.productclick();
		}
	}
	
	public static void pdpPagePaypal() throws Exception {
		pdpPage();
		allAttributesSelection.selectTheAttributesInPdpPage();
		Actionsss.scrollWindowsByPixel(150);
		Thread.sleep(1000);
		test.info("Verifying payment with paypal buy Now in PDP page");
		if(Actionsss.elementSize(pdp.getSalesforcePaypalBuyNowList())){
			Actionsss.click(pdp.getSalesforcePaypalBuyNow());
			PaypalMethod.paypalPopup();
			PlaceOrderPageTask.placeOrder();
			OrderDetailPageTasks.getOrderConfirmationPage();	
		}else {
			logger.info("No paypal buy now configuration in PDP in this payment");
			test.info("No paypal buy now configuration in PDP in this payment");
			test.pass("No paypal buy now configuration in PDP in this payment");
		}
	}
}
