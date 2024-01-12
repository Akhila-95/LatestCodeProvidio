package com.RegUserWith_CreditCard;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Validations.validationpopupMessages;
import com.providio.commonfunctionality.validatingInstock;
import com.providio.pageObjects.ProductSetFromExcel;
  
import com.providio.paymentProccess.MinicartViewCartProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.testcases.baseClass;
public class tc__ProductSetForRegUser_InCC extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test(dependsOnMethods = {"com.providio.testcases.tc__LoginSc.verifySuccessfulLogin"}, alwaysRun = true)
	public void productSet() throws InterruptedException {

			if(isLoggedIn) {

			 	
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
		 	    
		    //checkoutProcess		        
				MinicartViewCartProcess cp = new MinicartViewCartProcess();	         
	            cp.checkoutprocess();
	            
            //payment process             
		     CreditCardPaymentProcess cc = new CreditCardPaymentProcess();		     
		     cc.paymentByCreditCard();

	        }   else {
		        Assert.fail("User not logged in");
		    }
		 }
}

