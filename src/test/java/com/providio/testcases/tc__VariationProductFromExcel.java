package com.providio.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.pageObjects.SizeSelectioForVariation;
import com.providio.pageObjects.VariationProductFromExcel;


public class tc__VariationProductFromExcel extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test(dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"} )
	public void variationProduct() throws InterruptedException {
		 
		 if(isLoggedIn) {
		 

			 //serached for variation product
			VariationProductFromExcel fromExcel = new VariationProductFromExcel();
			fromExcel.performRandomOperations(driver);
			logger.info("searched for Variation product");
	
	
			SizeSelectioForVariation ss= new SizeSelectioForVariation();
			ss.sizeSelection(driver);
			logger.info("Product added to cart");
			
			
         //checkoutProcess
	        
            tc__CheckOutProcess cp = new tc__CheckOutProcess();
            
            cp.checkoutprocess();

		 }
	        
		  else {
		        Assert.fail("User not logged in");
		    }
	 }
}

