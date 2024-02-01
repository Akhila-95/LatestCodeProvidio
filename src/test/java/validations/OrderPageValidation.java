package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.OrderPageDetails;

public class OrderPageValidation extends baseClass{
	
	private static OrderPageDetails  orderPage = new OrderPageDetails(driver);
	static String lastFourDigits="";
	static String paymentText="";
	static String lastFourDigitsInGc="";
	static String gcPaymentText ="";
	public static void paymentInOrderConfirmationPage() throws InterruptedException {
		
		if(Actionsss.elementSize(orderPage.getPaymentInOrderConfirmationPageList())) {
			if(Actionsss.displayElement(orderPage.getPaymentInOrderConfirmationPage())){
				 paymentText = Actionsss.getTextOfElement(orderPage.getPaymentInOrderConfirmationPage());
				logger.info("Paypal " +paymentText);
				lastFourDigits =paymentText.substring(paymentText.length() - 4);
				logger.info("credit card "+lastFourDigits);
			}
		}
		if(Actionsss.elementSize(orderPage.getGiftCodeInOrderConfirmationPageList())) {
			gcPaymentText = Actionsss.getTextOfElement(orderPage.getGiftCodeInOrderConfirmationPage());
			logger.info(gcPaymentText);
			lastFourDigitsInGc =gcPaymentText.substring(gcPaymentText .length() - 4);
			logger.info("Gc last 4 digits "+lastFourDigitsInGc);
		}
		logger.info(creditCardNumber +"and" +lastFourDigits);
		logger.info(gcCodeRedeemed + "and " +lastFourDigitsInGc);
		logger.info(getTextOfPaypalInPaymentPage + "and " + paymentText);
		
		
		if((getTextOfPaypalInPaymentPage.equals(paymentText))&&((gcCodeRedeemed.equals(lastFourDigitsInGc))))  {
			logger.info("gc and paypal");
		    test.info("Verifying the provided paypal and Gc payment display in order confirmation page ");
		    test.pass("Successfully order is placed with provided paypal and gc code, the provided paypal and gc code is " + getTextOfPaypalInPaymentPage + " and " + gcCodeRedeemed + " and displayed card number is " + paymentText + " and " + lastFourDigitsInGc);
		} else if((creditCardNumber.equals(lastFourDigits))&& ((gcCodeRedeemed.equals(lastFourDigitsInGc)))) {
			logger.info("gc and credit");
		    test.info("Verifying the provided credit card and Gc payment display in order confirmation page ");
		    test.pass("Successfully order is placed with provided card number and gc code, the provided card number and gc code is " + creditCardNumber + " and " + gcCodeRedeemed + " and displayed card number is " + lastFourDigits + " and " + lastFourDigits);
		}else if (creditCardNumber.equals(lastFourDigits)) {
			logger.info("cc");
		    test.info("Verifying the provided card number  display in order confirmation page ");
		    test.pass("Successfully order is placed with provided card number, the provided card number is " + creditCardNumber + " and displayed card number is " + paymentText);		    
		} else  if(gcCodeRedeemed.equals(lastFourDigitsInGc))  {
			logger.info("gc");
		    test.info("Verifying the provided Gc code display in order confirmation page");
		    test.pass("Successfully order is placed with gift certificate, the provided gift certificate is " + gcCodeRedeemed + " and displayed gift certificate is " + lastFourDigitsInGc);
		    
		}else if (getTextOfPaypalInPaymentPage.equals(paymentText)) {
			logger.info("paypal");
		    test.info("Verifying the provided paypal payment display in order confirmation page  ");
		    test.pass("Successfully order is placed with provided PayPal, the PayPal is " + getTextOfPaypalInPaymentPage + " and displayed PayPal is " + getTextOfPaypalInPaymentPage);
		    
		} 
	}
	
	public static void validatePlacetheOrderPage() throws InterruptedException {
		if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {
	    	 String ActualTitleofPlacetheOrder = Actionsss.getTextOfElement(orderPage.getOrderThankMessage());
	    	 logger.info(ActualTitleofPlacetheOrder);
		     String ExpectedTitlePlacetheOrder = "Thank you for your order.";
	    	 test.info("verifying  the order is placed");
	
		    if (ActualTitleofPlacetheOrder.equals(ExpectedTitlePlacetheOrder)) {
		        test.pass("Successfully Order is Placed and Thank you for your order message is displayed");
		        logger.info("Successfully Order is Placed and Thank you for your order message is displayed");
		    } else {
		        test.fail( "The page Title does not match expected " + ExpectedTitlePlacetheOrder + " " + "  but found" + " " + ActualTitleofPlacetheOrder + " ");
		        logger.info("Click failed");
		    }		    
		}
	}    
	
	//validate the order number and date of order
		public static void orderNumberAndOrderDate() throws InterruptedException {
			if(Actionsss.elementSize(orderPage.getOrderThankMessageList())) {
			   String orderNumber = Actionsss.getTextOfElement(orderPage.getOrderNumber());
			  
		        test.pass("The Order number is "+ orderNumber);
		        logger.info("The Order number is "+ orderNumber);
			    
			    //order date
			    String OrderDate = Actionsss.getTextOfElement(orderPage.getOrderDate());
		        test.pass("The Ordered date is "+  OrderDate);
		        
		        //paymnet details
			    String paymentDetails = Actionsss.getTextOfElement(orderPage.getPaymentDetailsInOrderConfirmationPage());
		      
		        test.pass("Payment is done with "+ paymentDetails);
		        logger.info("Payment is done with"+ paymentDetails);
			}
					
		}
		
}
