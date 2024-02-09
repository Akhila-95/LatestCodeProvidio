package PaypalPayment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.OrderPageDetails;
import pageObjects.PaymentPageObjects;
import pageObjects.homepage;
import validations.OrderPageValidation;
import validations.PaymentPageValidation;

public class CheckOutPaypal extends baseClass{

	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	
	public static void paypalFromCheckout() throws InterruptedException, Exception {
		
		Actionsss.scrollWindowsByPixel(500);
		 test.info("Verifying payment with checkout paypal");
		if(Actionsss.elementSize(paymentPage.getBrainPaypalAcc())) {	 
			
    		test.info("Brain tree payment integration is activated");    		   
    		//
    		Actionsss.javascriptClick(paymentPage.getBrainTreePaypalButton());
    		Thread.sleep(10000);
    		
    		if (Actionsss.displayElement(paymentPage.getReviewOrderBtn())) {
    			Actionsss.javascriptClick(paymentPage.getReviewOrderBtn());
			}else  {
				brainTreeAfterClick();
				Thread.sleep(2000);
				logger.info("A click to Enter into paypal");				
				PaypalMethod.paypalPopup();
		    	logger.info("Clicked on paypal button");	
		    	Thread.sleep(1000);
		    /*	if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
					if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
					logger.info("Salesforce payment activated");			
					Thread.sleep(8000);		
					//OrderPageValidation.paymentInOrderConfirmationPage();
					OrderPageValidation.validatePlacetheOrderPage();
					OrderPageValidation.orderNumberAndOrderDate();
					Actionsss.click(homePage.clickOnLogo());
					}
				}
				else if(Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList())) {	
					logger.info("Other paymnet activated");
					logger.info("Place order page is loaded");
					Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
					Thread.sleep(8000);
					PaymentPageValidation.VerifiedThatPlaceOrderClick();
					Thread.sleep(1000);					
					OrderPageValidation.validatePlacetheOrderPage();
					OrderPageValidation.orderNumberAndOrderDate();
					Actionsss.click(homePage.clickOnLogo());
				}*/
			}
    		
    	}else if(Actionsss.elementSize(paymentPage.getSalesforcePaypalList())) {	 
    	
    		test.info("salesoforce payment integration is activated");  
		    Thread.sleep(1000);
		    PaypalMethod.salesforcePaypalCheckout();
		    logger.info("Clicked on paypal button after clicking on paypal icon");
		    Thread.sleep(2000);
		    PaypalMethod.paypalPopup();
	    	logger.info("Clicked on paypal button");
	    	Thread.sleep(1000);
	    /*	if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {	
				if(Actionsss.displayElement(orderPage.getOrderThankMessage())) {	
				logger.info("Salesforce payment activated");			
				Thread.sleep(8000);		
				OrderPageValidation.paymentInOrderConfirmationPage();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				Actionsss.click(homePage.clickOnLogo());
				}
			}
			else if(Actionsss.elementSize(paymentPage.getSelectPlaceOrderBtnList())) {	
				logger.info("Other paymnet activated");
				logger.info("Place order page is loaded");
				Actionsss.CombinedClick(paymentPage.getSelectPlaceOrderBtn());
				Thread.sleep(8000);
				PaymentPageValidation.VerifiedThatPlaceOrderClick();
				Thread.sleep(1000);
				OrderPageValidation.paymentInOrderConfirmationPage();
				OrderPageValidation.validatePlacetheOrderPage();
				OrderPageValidation.orderNumberAndOrderDate();
				Actionsss.click(homePage.clickOnLogo());
			}*/ 
	
    	} 
	else {
    		test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
        	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");    	
	  }
	}



//After the paypal button click
public static void brainTreeAfterClick() throws InterruptedException {
    WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
    WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
    if(regPaypalCheckoutText.isDisplayed()) {                	 
   	  
   	 
    }else { 
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
        if(paypalCheckout.isDisplayed()) {
        	Actionsss.CombinedClick(paypalCheckout);
        	/*
       	   js.executeScript("arguments[0].click();", paypalCheckout);                	
           Thread.sleep(1000);
        	if(paypalCheckout.isDisplayed()) {
        		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  paypalCheckout);
        		js.executeScript("arguments[0].click();", paypalCheckout);   
        		
            }*/
        }	                 
     }    
}

//SalesForce paypal payment page
	public static void salesforcePaypalCheckout() throws Exception {
	    WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
	    Thread.sleep(4000);
	    WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));
	    
	    Actionsss.javascriptClick(paypalCheckout);
	   
	    Thread.sleep(3000);
	   // paypalCheckout.click();
	   // Thread.sleep(10000);
	    List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
	    if(salesforcePaypalCheckout.size()>0) {
	        WebElement salesforcePaypalCheckout1=parentDiv.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
	      if(salesforcePaypalCheckout1.isDisplayed()) {
	    	  	 Thread.sleep(3000);
	        	 Actionsss.click(salesforcePaypalCheckout1);
	        	 System.out.println("First click");
	      }if(salesforcePaypalCheckout1.isDisplayed()) {    
	    	  	Actionsss.javascriptClick(salesforcePaypalCheckout1);        
	      }        	
    }
  }
}
