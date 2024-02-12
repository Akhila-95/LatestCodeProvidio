package OrderRegression;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import functionality.allAttributesSelection;
import tasks.ProductListingPageTasks;

public class PlaceOrderWithBuyNowPopUp extends baseClass{
	

	@Test
	public static void verifyingPlacingOrderWithBuyNowPopUp() throws Exception {
		// LoginPageTasks.verifyThatuserLogin();
		 ProductListingPageTasks.gpsProducts();
		 allAttributesSelection.selectTheAttributesInPdpForBuyNow();
		
		 Thread.sleep(3000);
		 /*
		 if(!Actionsss.elementSize(lp.getSignInList())) {
			 logger.info("guest user");			 
			// Actionsss.scrollWindowsByPixel(150);
			// WebElement buyNow= driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
			// Actionsss.javascriptClick(buyNow);
			// Thread.sleep(2000);
				// Actionsss.javascriptClick(pdp.getBuyNowButton());
				 CheckOutPageTasks.GuestMailCheckOut();
				 ShippingPageTasks.enterValidAddress();
				 PaymentPageTasks.creditCardWithValidDetails();
				 ReviewOrderPageTask.placeOrder();
				 OrderPageValidation.paymentInOrderConfirmationPage();
				 OrderDetailPageTasks.getOrderConfirmationPage();
		 }else {
			 Actionsss.scrollWindowsByPixel(150);
			 WebElement buyNow= driver.findElement(By.xpath("//button[contains(@class,'buy-now')]"));
			 Actionsss.javascriptClick(buyNow);
			 Thread.sleep(2000);
			 WebElement placeOrderbuyNowStripe= driver.findElement(By.xpath("(//button[contains(text(),'Place Order')])[1]"));
			 WebElement placeOrderbuyNowBrainTree= driver.findElement(By.xpath("(//button[contains(text(),'Place Order')])[1]"));
			 if(placeOrderbuyNowBrainTree.isDisplayed()) {
				 placeOrderbuyNowBrainTree.click();
			 }else {
				 placeOrderbuyNowStripe.click();
			 }
			// Actionsss.click(pdpPage.getplaceOrderInBuyNow());
		 }
		 
		*/
}
}
