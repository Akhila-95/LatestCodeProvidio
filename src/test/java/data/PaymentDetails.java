package data;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.paymentmethods.allPaymentMethods;
import com.providio.testcases.baseClass;
import functionality.Actionsss;
import pageObjects.PaymentPage;


public class PaymentDetails extends baseClass{
	
	public static void payment() throws Exception {
		
		/*
		// Brain Tree
		List<WebElement> creditcardscheck = driver.findElements(By.xpath("//a[@class ='nav-link creditcard-tab active']"));
	    // Credit Card Salesforce
		List<WebElement> creditcardsSalesForce = driver.findElements(By.xpath("//div[@class='sfpp-payment-method-header sfpp-payment-method-header-card']"));
	    // Stripe
	    List<WebElement> stripePayment = driver.findElements(By.xpath("(//div[contains(@class,'StripeElement')])[1]"));
	    // CyberSource
	    List<WebElement> cyberSourcePayment = driver.findElements(By.xpath("//li[@data-method-id='CREDIT_CARD']"));

	    // Determine the payment method and proceed accordingly
	    if(creditcardscheck.size()>0) {
	    	PDGR.BrainTreeMethod();
	    	
	    } else if(creditcardsSalesForce.size()>0) {
	    	PDGR.salesFroce();
	    	
	    } else if(stripePayment.size()>0) {
	    	PDGR.stripe();
	    	
	    } else if(cyberSourcePayment.size()>0){
	    	PDGR.cyberSource();	
	    }*/
	    
		Actionsss.scrollWindowsByPixel(900);
		
		// negative validation for credit card 
		//PaymentDetailsofGuestandReg. allErrorsInCreditCard();
		
	}
	public static void positiveCreditCardDetails() throws InterruptedException, Exception {
		
		PaymentPage pp = new PaymentPage(driver);
		
		if(Actionsss.elementSize(pp.getBrainTree())) {
			
			PaymentDetailsofGuestandReg.brainTreeMethod();
			 
		}else if (Actionsss.elementSize(pp.getCreditcardsSalesForce())) {
			
			PaymentDetailsofGuestandReg.salesForce();
			
		}else if (Actionsss.elementSize(pp.getStripePayment())) {
			
			PaymentDetailsofGuestandReg.stripe();
			 
		}else if (Actionsss.elementSize(pp.getCyberSourcePayment())) {
			
			PaymentDetailsofGuestandReg.cyberSource();
		}
	}
	}

