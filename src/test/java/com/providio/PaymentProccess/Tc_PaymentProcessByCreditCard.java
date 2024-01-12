package com.providio.PaymentProccess;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.pageObjects.PaymentPage;
import com.providio.testcases.baseClass;


public class Tc_PaymentProcessByCreditCard extends baseClass{

	public void paymentByCreditCard() throws InterruptedException {
		
		
		//payment page
		
		List<WebElement> continueasAGuest = driver.findElements(By.xpath("//button[contains(text(),'Guest Checkout')]"));

        logger.info(" Logged in as guest :  "  +continueasAGuest.size());
        
		PaymentPage pp = new PaymentPage(driver);
	
		List<WebElement> creditcardscheck = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
		
	    System.out.println(creditcardscheck.size());
	    
	    if(creditcardscheck.size()>0) {
	    	
	    	List<WebElement> savedCardsBrainTree = driver.findElements(By.xpath("//option[@class ='js_stored_card']"));
	    	
	    	System.out.println(savedCardsBrainTree.size());
	    	
	    	if(savedCardsBrainTree.size()>0) {
	    		
	    		logger.info("Saved cards are there selected one of them");
	    		
	    	}else {
	    		
	    		Thread.sleep(5000);
	    		
	    		if(continueasAGuest.size()>0) {

	    			pp.setcardholdername(driver);
					logger.info("entered card name");
					
					pp.setcardnumber(driver);
					logger.info("entered card number");
					
					pp.setcardcvv(driver);
					logger.info("entered cvv");
					
					pp.setcardexp(driver);
					logger.info("entered exp");

                }else {
                	
                	pp.selectnewcardindropdown();  
					logger.info("Selectd the new card");
					
					pp.setcardholdername(driver);
					logger.info("entered card name");
					
					pp.setcardnumber(driver);
					logger.info("entered card number");
					
					pp.setcardcvv(driver);
					logger.info("entered cvv");
					
					pp.setcardexp(driver);
					logger.info("entered exp");
                }
	    	
	    		
	    	}
	
	    	
	    } else {

	    	List<WebElement> savedCardsCyberSourece = driver.findElements(By.xpath("//option[@class ='js_stored_card']"));
	    	
	    	System.out.println(savedCardsCyberSourece.size());
	    	
	    	
	    	if(savedCardsCyberSourece.size()>0) {
	    		//select one and send the cvv number of that card
	    		
	    		
	    	 }else {
	
	        	pp.addPaymentButton(driver);
	        	logger.info("click on the add payment button");
	        	
		        pp.latestcardnumber(driver);
		        logger.info("entered card number");
		        pp.latestExpDate(driver);
		        logger.info("entered exp month");
		        pp.latestExpYear(driver);
		        logger.info("entered exp year");
		        pp.latestSceuritycode(driver);
		        logger.info("entered scecode");
	    		
	    	}
	
	    }
	
		
		//validate the payment page
	    WebElement paymentPage = driver.findElement(By.xpath("//label[contains(text(), 'Payment Method')]"));
	    String ActualTitleofpaymentPage = paymentPage.getText();
	    String ExpectedTitlepaymentPage = "Payment Method";
	    logger.info(paymentPage.getText());
	    if (ActualTitleofpaymentPage.equals(ExpectedTitlepaymentPage)) {
	        test.pass("Successfully clicked on the  " + ActualTitleofpaymentPage + " ");
	        logger.info("click Success New arrival mens");
	    } else {
	        test.fail( "The page Title does not match expected " + ExpectedTitlepaymentPage + " " + "  but found" + " " + ActualTitleofpaymentPage + " ");
	        logger.info("Click failed");
	    }
	    
	    
	//  //soft assertions payment page
	//  
	//  softAssert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
	//  
	//  //Hard assertions payment page
	//  
	//  Assert.assertEquals(ActualTitleofpaymentPage, ExpectedTitlepaymentPage, "Page title does not match expected value");
	
	    Thread.sleep(5000);
	    
		
		//pp.clickonrevieworder(driver);
		//logger.info("ckicked on the review oreder");
		
	}
}
