package com.GuestUserWith_Minicart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
  
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InMC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	// @Test
	public void productSet() throws InterruptedException {

        //launching the browser and passing the url into it
	 	driver.get(baseURL);
	 	logger.info("Entered into url");
	 	
	 	//searching the product set from excel sheet
		ProductSetFromExcel fromExcel= new ProductSetFromExcel();
		fromExcel.performRandomOperations(driver);	
		logger.info("Searched for a productset");
		
		
		//selecting size for product
		//                SizeSelectionForProductSet set =new SizeSelectionForProductSet();
		//  set.sizeSelection(driver);
		logger.info("Selected size and added to cart");
		
		//validating the product is instock and adding to the cart
		  validatingInstock.inStockValidation();
		  
		//validating the product is add to the cart
 	    validationpopupMessages.validatingProductisAddtoCart(driver);	
		  
	     //checkout from mini cart by paypal	        
	        MinicartViewCartProcessByPayPal checkOutProcessByPayPal= new MinicartViewCartProcessByPayPal();
	        checkOutProcessByPayPal. checkoutprocessFromMiniCart();
			   

	        } 
}

