package com.providio.Scenarios;

import com.providio.pageObjects.VariationProductFromExcel;
import com.providio.testcases.baseClass;

public class VariationProduct extends baseClass{

	public void variationProduct() throws InterruptedException {
		  
		 //searched for variation product
		 VariationProductFromExcel fromExcel = new VariationProductFromExcel();
		 fromExcel.performRandomOperations(driver);
		 logger.info("searched for Variation product");

 		//validating the product is add to the cart
  	    //addtoCartValidation.validatingProductisAddtoCart(driver);

	}

}
