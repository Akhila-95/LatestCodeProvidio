package com.GuestUserWith_Minicart_Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.providio.commonfunctionality.size;
import com.providio.pageObjects.navigationPage;
import com.providio.pageObjects.productListingPage;
import com.providio.paymentProccess.MinicartViewCartProcessByPayPal;
import com.providio.testcases.baseClass;

public class tc__PaypalFromPDPpage_GuestUser  extends baseClass{
	 
	@Test
	public void paypalFromPDPpage() throws InterruptedException {
		
		
		//enter  into url
			driver.get(baseURL);
			test.info("Entered into url");
			logger.info("Enterd into url");
			
		//naviagated into random menu
			navigationPage navPage= new navigationPage(driver);
			navPage.selectRandomMenu(driver);
			logger.info("Entered into menu");
		
		//plp page	
			productListingPage plp = new productListingPage(driver);
			plp.selectProductRandom(driver);
			logger.info("Entered into plp page");
			
		
	  //paypal buy now button
	        
	    		 List<WebElement> paypalbuyNowPdp =driver.findElements(By.xpath("//div[contains(@class,'salesforce-buynow-element ')]"));
	    		 if( paypalbuyNowPdp.size()>0) {
	    			 
	    			    size s = new size();	    			    
	    				s.paypalBuyNowFromPDP(driver);
	    				

    				//paypal checkout procces
    					MinicartViewCartProcessByPayPal paypal= new MinicartViewCartProcessByPayPal();
    			        Thread.sleep(5000);
    			        paypal.paypalCheckoutFromPDP();
		    		 }
	    		 else {
	    			 test.pass("Paypal buy now is only in salsforce payment not in cybersource and brain tree");
	    		 }
	       
		
	      

		
	}
}
