//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.providio.testcases;

import com.providio.pageObjects.navigationProcess;
import com.providio.paymentProccess.CreditCardPaymentProcess;
import com.providio.paymentProccess.MinicartViewCartProcess;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class tc__NavigationAllMenusWithGuestUser extends baseClass {

	SoftAssert softAssert = new SoftAssert();

    @Test
    public void NavigationAllMenusWithGuestUser() throws InterruptedException {
        
        driver.get(this.baseURL);
        logger.info("enterd into url");
        
        navigationProcess np = new navigationProcess(driver);
        np.navigateeachmainmenuandselectoneproductformthesubmenu();
            
        

		//checkoutProcess
		
		MinicartViewCartProcess cp = new MinicartViewCartProcess();
		
		cp.checkoutprocess();
		
		//payment process
		
		CreditCardPaymentProcess cc = new CreditCardPaymentProcess();
		
		cc.paymentByCreditCard(); 


    }
}