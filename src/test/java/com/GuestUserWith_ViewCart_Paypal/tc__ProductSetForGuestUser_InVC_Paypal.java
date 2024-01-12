package com.GuestUserWith_ViewCart_Paypal;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.providio.Scenarios.ProductSet;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;
public class tc__ProductSetForGuestUser_InVC_Paypal extends baseClass{
	SoftAssert softAssert = new SoftAssert();
	 
	 @Test
	public void productSet() throws InterruptedException {
			//product set
			ProductSet ps = new ProductSet();
			ps.productSet();
			 	
	 	    
           //paypal checkout form view cart page
 	         MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();	         
 	         paypal.checkoutprocessFromViewCart();

	        } 
}

