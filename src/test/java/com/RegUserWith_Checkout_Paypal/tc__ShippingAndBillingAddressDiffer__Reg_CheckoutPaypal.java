package com.RegUserWith_Checkout_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.pageObjects.GiftCertificate;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.testcases.baseClass;

public class tc__ShippingAndBillingAddressDiffer__Reg_CheckoutPaypal extends baseClass{
	 
	@Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void shippingAndBillingAddressDiffer_Guest() throws InterruptedException {
		
		if(isLoggedIn) {     
			
			//searching the bundle product from excel sheet
			 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
			 bundleProduct.performRandomOperations(driver);
			 logger.info("Searched bundle  product");
			 
			 //validating the product is instock and adding to the cart
			  validatingInstock.inStockValidation();
			  
			//validating the product is add to the cart
	 	    validationpopupMessages.validatingProductisAddtoCart(driver);
			  
			 
			 //adding GC into cart
			 for(int i=1; i<=1;i++) {
				 GiftCertificate gc= new  GiftCertificate(driver);
				 gc.clickOnGiftCard(driver);
				 test.info("Gift card added to cart");
			 }
			 Thread.sleep(2000);
			 
			 
			 //all promtions applied to a simple product
			 SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel();	
			 simpleProduct.performRandomOperations(driver);
			 test.info("Searched for  simple product");
			 
			//validating the product is instock and adding to the cart
			  validatingInstock.inStockValidation();
			  
			//validating the product is add to the cart
		    validationpopupMessages.validatingProductisAddtoCart(driver);
		    
		}else {
		   	 Assert.fail("User not logged in");
		   }
		
	}
}
