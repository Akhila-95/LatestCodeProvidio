package com.RegUserWith_ViewCart_Paypal;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

import functionality.attributesSelection;


public class tc__VariationProductReg_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	  
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {

			 //searched for variation product
			 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			 fromExcel.performRandomOperations(driver);
			 logger.info("searched for Variation product");

			    attributesSelection.colorSelection();
	   	    	Thread.sleep(3000);
	   	    	//select the size
	   	    	attributesSelection.sizeSelction();
	   	    	Thread.sleep(3000);
	   	        //validate the product is instock or not
	   	    	validatingInstock.inStockValidation();

	  		  
	  		//validating the product is add to the cart
	   	    validationpopupMessages.validatingProductisAddtoCart(driver);
		
			//paypal checkout form view cart page
             MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
             paypal.checkoutprocessFromViewCart();   
		 }else {
		        Assert.fail("User not logged in");
		    }
	 }
}

