package com.providio.Scenarios;

import com.providio.Validations.preValidationCheck;
import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.SimpleProductFromExcel;
import com.providio.testcases.baseClass;

import functionality.allAttributesinOneFile;

public class SimpleProduct extends baseClass{

	public void simpleProdcut() throws InterruptedException { 
		
		//all promtions applied to a simple product
		 SimpleProductFromExcel  simpleProduct = new SimpleProductFromExcel();	
		 simpleProduct.performRandomOperations(driver);
		 test.info("Searched for  simple product");
		 
		 //validating the pdp page 
		 preValidationCheck.preValidationPDP();
	    
	  //Selecting the attributes
		allAttributesinOneFile.allAttributes();
		
		//validate the in stock element
		validatingInstock.inStockValidation();
		 
		  
		//validating the product is add to the cart
	    validationpopupMessages.validatingProductisAddtoCart(driver);
	}
		
}
