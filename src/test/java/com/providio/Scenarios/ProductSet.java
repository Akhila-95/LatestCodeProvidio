package com.providio.Scenarios;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
import com.providio.testcases.baseClass;

import functionality.allAttributesinOneFile;

public class ProductSet extends baseClass{

	public void productSet() throws InterruptedException {
	 	
	 	//searching the product set from excel sheet
		ProductSetFromExcel fromExcel= new ProductSetFromExcel();
		fromExcel.performRandomOperations(driver);	
		logger.info("Searched for a productset");
		
		
		//selecting size for product
		allAttributesinOneFile.selectTheAttributesInPdp(driver);
//		//                SizeSelectionForProductSet set =new SizeSelectionForProductSet();
//		//  set.sizeSelection(driver);
//		logger.info("Selected size and added to cart");
		
		//validating the product is instock and adding to the cart
		  validatingInstock.inStockValidation();
		  
		//validating the product is add to the cart
 	    validationpopupMessages.validatingProductisAddtoCart(driver);

	}

}
