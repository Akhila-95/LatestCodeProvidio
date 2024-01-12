package com.providio.Validations;

import com.providio.pageObjects.miniCartPage;
import com.providio.pageObjects.viewCartPage;
import com.providio.testcases.baseClass;

public class ViewCartValidation extends baseClass{

	public static void viewCartValidations() throws InterruptedException {
		
		viewCartPage vcp = new viewCartPage(driver);
		Thread.sleep(3000);
		PdpValidation.QuantityofallpagesPlusinviewcart(driver);
		vcp.removeBtn();
		Thread.sleep(3000);
//		vcp.editBtn();
//		Thread.sleep(2000);
		vcp.selectPaymentMethod();
		Thread.sleep(2000);
		vcp.moveToWishListBtn();
		Thread.sleep(3000);
		 miniCartPage mc = new miniCartPage(driver);
         Thread.sleep(5000);
         // Click on the cart button in the minicart
         mc.clickcartbutton(driver);
         Thread.sleep(1000);
         // Click on the "View Cart" button in the mini cart page
         mc.clickviewCartButton(driver);
         logger.info("Clicked the view cart button in the minicart");
		vcp.clickcontinueShiping(driver);
	}
}
