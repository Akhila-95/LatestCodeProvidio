package com.providio.Scenarios;

import com.providio.testcases.baseClass;

public class SimpleProductAndGc extends baseClass{

	public  void simpleProductAndGc() throws InterruptedException {

		//simple product
	    SimpleProduct sp = new SimpleProduct();
	    sp.simpleProdcut();
		 
		 //adding GC into cart
	    GiftCard gc = new GiftCard();
	    gc.giftCards();

	}

}
