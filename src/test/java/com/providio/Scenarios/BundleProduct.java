package com.providio.Scenarios;

import com.providio.Validations.preValidationCheck;
import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.BundleProductFromEXcel;
import com.providio.testcases.baseClass;

public class BundleProduct extends baseClass{
	
	public void bundleproduct() throws InterruptedException {
		
		// Validation for the Home page before proceeding.
        preValidationCheck.prevalidationHome();
		 
		 //searching the bundle product from excel sheet
		 BundleProductFromEXcel bundleProduct = new  BundleProductFromEXcel();
		 bundleProduct.performRandomOperations(driver);
		 logger.info("Searched a product");

        //validate the product is instock or not
    	validatingInstock.inStockValidation();
    	
    	//validating the product is add to the cart
    	validationpopupMessages.validatingProductisAddtoCart(driver);
	
	}

}
