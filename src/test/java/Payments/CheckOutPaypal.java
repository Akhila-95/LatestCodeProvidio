package Payments;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import Paypal.PaypalMethod;
import functionality.Actionsss;
import pageObjects.PaymentPage;

public class CheckOutPaypal extends baseClass{

	private static final PaymentPage pp =new PaymentPage(driver);
	
	public static void paypalFromCheckout() throws InterruptedException, Exception {
		
		Actionsss.scrollWindowsByPixel(500);
		
		if(Actionsss.elementSize(pp.getBrainPaypalAcc())) {	    		
    		test.info("Brain tree payment integration is activated");
    		   
    		Thread.sleep(2000);
    		Actionsss.javascriptClick(pp.getBrainTreePaypalButton());
    		Thread.sleep(2000);
    		
    		if (Actionsss.displayElement(pp.getReviewOrderBtn())) {
    			Actionsss.javascriptClick(pp.getReviewOrderBtn());
			}else  {
				brainTreeAfterClick();
				logger.info("A click to Enter into paypal");				
				PaypalMethod.paypalPopup();
		    	logger.info("Clicked on paypal button");

		    	/*
		    	// review order page		    		
		    		Thread.sleep(4000);			    		

		    		if(Actionsss.displayElement(pp.getReviewOrderBtn())) {
			    		Actionsss.click(pp.getReviewOrderBtn());
			    		logger.info("Clicked on review order button");
			    		Thread.sleep(2000);
			    	
		    		}
		    		if(Actionsss.displayElement(pp.getSelectPlaceOrderBtn())) {
		    			Actionsss.scrollWindowsByPixel(300);
		    			 Thread.sleep(3000);
		    			 Actionsss.javascriptClick(pp.getSelectPlaceOrderBtn());		    			
		    			 Thread.sleep(5000);
			    		 logger.info("successfully click on the place order button by normal click");
			    		
			    		}	*/				
			}
    	}else if(Actionsss.elementSize(pp.getSalesforcePaypalList())) {	 
    	
    		test.info("salesoforce payment integration is activated");  
		    Thread.sleep(1000);
		    PaypalMethod.salesforcePaypalCheckout();
		    logger.info("Clicked on paypal button after clicking on paypal icon");
		    Thread.sleep(2000);
		    PaypalMethod.paypalPopup();
	    	logger.info("Clicked on paypal button");
    	}else {
    		test.info("Cybersouce payment OR stripe payment integration  is activated so, No paypal for cybersouce and stripe");
        	test.pass("No paypal integration for cybersource and stripe , choose another integration to do the payment with payment");
    	}
	  }
    	  /*
    	  if(driver.findElements(By.cssSelector("button.place-order")).size()>0) {
    			//placeorder
	    		WebElement placeOrder= driver.findElement(By.cssSelector("button.place-order"));	
	    		List<WebElement> placeOrderList= driver.findElements(By.cssSelector("button.place-order"));
	    		if (placeOrder.isDisplayed()) { 
	    			 js.executeScript("window.scrollBy(0,350)", "");
	    			 Thread.sleep(3000);
	    			 WebElement placeOrderButton= driver.findElement(By.cssSelector("button.place-order"));		    		
	    				
	    			 js.executeScript("arguments[0].click();", placeOrderButton);
	    			 Thread.sleep(5000);
		    		 logger.info("successfully click on the place order button by normal click");
		    		
		    		}	
    	  }
    		  
    	  
		Thread.sleep(10000);
		if(driver.getTitle().endsWith("Order Confirmation | Providio")) {
			
			 Checkout_Validation checkout= new Checkout_Validation();
		 //validate the final place the order page
			 checkout.validatePlacetheOrderPage();
		
	     //ordernumberandOrderdate
			 checkout.ordernumberandOrderdate();
			 Thread.sleep(3000);
			}
	}*/


//After the paypal button click
public static void brainTreeAfterClick() throws InterruptedException {
    WebElement parentDiv= driver.findElement(By.xpath("//a[contains(@class, 'paypal-tab active')]"));               
    WebElement regPaypalCheckoutText=parentDiv.findElement(By.xpath("//label[contains(text(),'Select a PayPal account')]"));
    if(regPaypalCheckoutText.isDisplayed()) {                	 
   	  
   	 
    }else { 
        JavascriptExecutor js = (JavascriptExecutor) driver;  
        WebElement paypalCheckout=driver.findElement(By.xpath("//div[@class='js_braintree_paypal_billing_button']")); 
        if(paypalCheckout.isDisplayed()) {
       	   js.executeScript("arguments[0].click();", paypalCheckout);                	
           Thread.sleep(1000);
        	if(paypalCheckout.isDisplayed()) {
        		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",  paypalCheckout);
        		paypalCheckout.click();
            }
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
