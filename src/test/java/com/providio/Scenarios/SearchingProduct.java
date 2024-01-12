package com.providio.Scenarios;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.homePage;
import com.providio.testcases.baseClass;

import functionality.allAttributesinOneFile;

public class SearchingProduct extends baseClass{

	public  void searchingProduct() throws InterruptedException {

		
   	  //searching a product
       homePage homepage = new homePage(driver);
       homepage.clickOnSearchBar(this.searchBar);
       test.info("searched a product " + this.searchBar);
       
       //clicked on searched product
       homepage.clickOnSearchedProduct();
       test.info("clicked on searched product");
   
        //Selecting the attributes
		allAttributesinOneFile.allAttributes();
		
		//validate the in stock element
		validatingInstock.inStockValidation();
		  
		//validating the product is add to the cart
	    validationpopupMessages.validatingProductisAddtoCart(driver);

	}

}
