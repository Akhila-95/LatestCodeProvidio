package Paypal;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class PaypalMethod extends baseClass {
	
	static final PaymentPage pp= new PaymentPage(driver);
	
    
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
    public static void salesforcePaypalCheckout() throws InterruptedException {
        WebElement parentDiv= driver.findElement(By.xpath("//div[contains(@class,'sfpp-payment-method-header-paypal')]"));
        Thread.sleep(4000);
        WebElement paypalCheckout=parentDiv.findElement(By.xpath("//div[contains(text(),'Pay with PayPal')]"));
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,700)", "");
     //   js.executeScript("arguments[0].click();", paypalCheckout);
       
       // Thread.sleep(3000);
        paypalCheckout.click();
      //  Actionsss.CombinedClick(paypalCheckout);
       // Thread.sleep(10000);
        List<WebElement> salesforcePaypalCheckout=parentDiv.findElements(By.xpath("//div[contains(@class,'paypal-buttons-context-iframe paypal-buttons-label-paypal')]"));  
        if(salesforcePaypalCheckout.size()>0) {
            WebElement salesforcePaypalCheckout1=parentDiv.findElement(By.xpath("(//iframe[@title='PayPal'])[2]"));
          if(salesforcePaypalCheckout1.isDisplayed()) {
        	  	 Thread.sleep(3000);
            	 salesforcePaypalCheckout1.click();
            	 System.out.println("First click");
          }if(salesforcePaypalCheckout1.isDisplayed()) {    
              js.executeScript("arguments[0].click();", salesforcePaypalCheckout1);
             
          }            	
        }
    }
	
	 public static void paypalPopup() throws Exception {
	    	
	        String mainWindowHandle = driver.getWindowHandle();
	        // Switch to the new window by iterating over all available window handles
	        for (String handle : driver.getWindowHandles()) {
	            if (!handle.equals(mainWindowHandle)) {
	                driver.switchTo().window(handle);
	                break;
	            }
	        }
	        // test.info("Entered into paypal window");
	        //	List<WebElement> paypalPage = driver.findElements(By.id("headerText"));
	        //	System.out.println("The url for payapal is " + paypalPage.size());
	         Thread.sleep(2000);
	         if(Actionsss.elementSize(pp.getEmailLoginList())) {
	        	Actionsss.sendKeys( pp.getEmailLogin(),"rahulnaik@etisbew.com", "User email");       	 
	        	 test.info("Entered username");
	        	 WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
	        	 getTextOfPaypalInPaymentPage=email.getAttribute("value");
	         }
	         //Thread.sleep(3000);
	         if(Actionsss.elementSize(pp.getNextButtonList())) {
	        	Actionsss.click(pp.getNextButton());         
	             //Thread.sleep(1000);
	         }
	         if(Actionsss.elementSize(pp.getPasswordList())) {
	        	 Actionsss.sendKeys(pp.getPassword(),"Etgsfcc245@", "password");               
	             test.info("Entered password");
	             Thread.sleep(1000);
	         }
	         if(Actionsss.elementSize(pp.getloginbuttonList())) {
	        	 Actionsss.click(pp.getloginbutton());           
	             Thread.sleep(1000);
	         }
	        

	         Thread.sleep(2000);
	         if(Actionsss.elementSize(pp.getReviewOrderButtonList())) {
	        	
	         	try {
	         		Actionsss.click(pp.getReviewOrderButton());      		
	 	            Thread.sleep(1000);
	 	          //  Thread.sleep(4000);
	 	        } catch (Exception e) {
	 	        	Actionsss.javascriptClick(pp.getReviewOrderButton());
	 	            System.err.println("Exception while clicking the element: " + pp.getReviewOrderButton());
	 	        }
	         	
	         	logger.info("complete order");
	         	Thread.sleep(4000);
	   	
	            	try {
	            		Actionsss.click(pp.getCompletePurcharseButton());
	 	           		Thread.sleep(4000);
	            	} catch (Exception e) {
		 	        	Actionsss.javascriptClick(pp.getCompletePurcharseButton());
		 	            System.err.println("Exception while clicking the element: " +pp.getCompletePurcharseButton());
	            	}         	
	        	                	
	         }else {
	        	 if(Actionsss.elementSize(pp.getSaveAndContinueList())) {
	        		 Actionsss.click(pp.getSaveAndContinue());
	        	 }
	         }                 
	         driver.switchTo().window(mainWindowHandle);
	         Thread.sleep(1000);
	         
	      }    
}
