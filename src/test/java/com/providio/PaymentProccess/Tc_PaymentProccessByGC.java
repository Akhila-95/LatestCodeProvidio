package com.providio.PaymentProccess;

import com.providio.pageObjects.GiftCardCodes;
import com.providio.testcases.baseClass;

public class Tc_PaymentProccessByGC extends baseClass {

	public void paymentByGC() throws InterruptedException {
		
		
		
		GiftCardCodes code= new GiftCardCodes();
		
		//code.performRandomOperations(driver);			
		code.performSequentialOperations(driver);
		logger.info("applied gift card code");
	}
}
