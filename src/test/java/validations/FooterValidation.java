package validations;


import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;

public class FooterValidation extends baseClass{

	private static final FooterPage fp = new FooterPage(driver);
	
	public static void validatingGiftCardAddtoCart() {
		   
		   test.info("Validating gift card is add to the cart");

	       // Get the text of the alert
	       String actualAddToCart = Actionsss.waitAndVisibleGetText(fp.getAddToCartSuccessMsg());
	       // Expected alert text
	       String expectedAddToCart = "Gift Certificate added to cart";
	       if (actualAddToCart.equals(expectedAddToCart)) {
	           // Success message is displayed
	       	   test.pass("Succesfully Gift Certificate added to cart");
	           logger.info("Succesfully Gift Certificate added to cart");	         
	       }else {
	           // Success message is not as expected
	       	   test.fail("Gift Certificate not added to cart");
	           logger.info("Gift Certificate not added to cart");	        
	         }
	   }
	   
	public static void validatingSubscriptionSignUpError() {
		   
		   test.info("Validating error message pop up for subscription sign up");

	       // Get the text of the alert
	       String actualAddToCart = Actionsss.getTextOfElement(fp.getsubscribeSignUpError());
	       // Expected alert text
	       String expectedErrorMsgForSubscribe= "Please provide a valid email Id";
	       if (actualAddToCart.equals(expectedErrorMsgForSubscribe)) {
	           // Success message is displayed
	       	   test.pass("Succesfully error message pop up displayed for subscription sign up");
	           logger.info("Succesfully error message pop up for subscription sign up");         
	       }else {
	           // Success message is not as expected
	       	   test.fail("No error message pop up for subscription sign up");
	           logger.info("No error message pop up for subscription sign up");     
	         }
	   }
	
	public static void validatingSubscriptionSuccessPoPuP() {
		   
		   test.info("Validating error message pop up for subscription sign up");

	       // Get the text of the alert
	       String actualAddToCart = Actionsss.waitAndVisibleGetText(fp.getSubscribeMessage());
	       // Expected alert text
	       String expectedErrorMsgForSubscribe= "You have been successfully subscribed.";
	       if (actualAddToCart.equals(expectedErrorMsgForSubscribe)) {
	           // Success message is displayed
	       	   test.pass("Succesfully error message pop up displayed for subscription sign up");
	           logger.info("Succesfully error message pop up for subscription sign up");         
	       }else {
	           // Success message is not as expected
	       	   test.fail("No error message pop up for subscription sign up");
	           logger.info("No error message pop up for subscription sign up");     
	         }
	   }
	
	
	public static void allErrorMsgsInGiftCard() throws Exception {
		Thread.sleep(2000);
		if(Actionsss.displayElement(fp.getErrorForRecipientName()) || (Actionsss.displayElement(fp.getFromNameError())) || (Actionsss.displayElement(fp.getRecipientConfirmEmailError()) ||
				(Actionsss.displayElement(fp.getRecipientEmailError())))) {
			test.pass("All the  error are displayed when no text is entered");
			logger.info("All the  error are displayed when no text is entered");
		}else {
			test.fail("All the error are not  displayed when no text is entered");
			logger.info("All the error are not  displayed when no text is entered");
		}					 
	}
	
	
	public static void errorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		Thread.sleep(2000);
		logger.info(Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));
        if(Actionsss.displayElement(fp.getFromNameError()) || Actionsss.displayElement(fp.getRecipientEmailError()) || Actionsss.displayElement(fp.getRecipientConfirmEmailError())) {
        	test.pass("Error message is displayed as " +Actionsss.getTextOfElement(fp.getFromNameError()) + "and" +Actionsss.getTextOfElement(fp.getRecipientEmailError()) + "and " +Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));       	
        	logger.info("Error message is displayed as " +Actionsss.getTextOfElement(fp.getFromNameError()) + "and" +Actionsss.getTextOfElement(fp.getRecipientEmailError()) + "and " +Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));       	
        }else {
        	test.fail("Error message are not  displayed ");
        	logger.info("Error message are not  displayed  ");
        }
	}
	
	public static void errorsRecipientEmailAndConfirmEmail() {
		
		if(Actionsss.displayElement(fp.getRecipientEmailError()) &&Actionsss.displayElement(fp.getRecipientConfirmEmailError())) {
			test.pass("Error message is displayed as " +Actionsss.getTextOfElement(fp.getRecipientEmailError() )+ " and" +Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));       	
        	logger.info("Error message is displayed as " +Actionsss.getTextOfElement(fp.getRecipientEmailError() )+ " and" +Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));
        }else {
        	test.fail("Error message are not  displayed  ");
        	logger.info("Error message are not  displayed  " );
        }
	}
	
	public static void errorsForConfirmMail() throws InterruptedException {
		Thread.sleep(1000);
		if(Actionsss.displayElement(fp.getRecipientConfirmEmailError())) {
			test.pass("Error message is displayed as " +Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));  
			logger.info("Error message is displayed as " +Actionsss.getTextOfElement(fp.getRecipientConfirmEmailError()));  
		}else {
			test.fail("Error message is not  displayed  ");
        	logger.info("Error message is not  displayed  " );
		}
	}
}
