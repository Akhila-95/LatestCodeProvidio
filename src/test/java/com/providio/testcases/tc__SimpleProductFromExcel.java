package com.providio.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.PaymentProccess.Tc_PaymentProcessByCreditCard;
import com.providio.pageObjects.simpleProductFromExcel;


public class tc__SimpleProductFromExcel extends baseClass{
	SoftAssert softAssert = new SoftAssert();

	 @Test( dependsOnMethods = {"com.providio.testcases.tc__Login.loginTest"} )
	public void simpleProduct() throws InterruptedException {
		 
		 
	if(isLoggedIn) {
		
		
		simpleProductFromExcel  simpleProduct = new simpleProductFromExcel ();	
		
		simpleProduct.performRandomOperations(driver);

       
        
        //checkoutProcess
        
        tc__CheckOutProcess cp = new tc__CheckOutProcess();
        
        cp.checkoutprocess();

	    // payment by cc
        
	    Tc_PaymentProcessByCreditCard paymentByCC= new Tc_PaymentProcessByCreditCard();
	    
	    paymentByCC.paymentByCreditCard();
	    
	
	    // review order page
	    
	    Tc_ReviewOrderPage reviewOP= new Tc_ReviewOrderPage();
	    
	     reviewOP.reviewOrderPage();
	
	        }

	  else {
	        Assert.fail("User not logged in");
	    }
	 }
}

