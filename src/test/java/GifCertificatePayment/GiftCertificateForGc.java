package GifCertificatePayment;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPageObjects;
import tasks.PaymentPageTasks;

public class GiftCertificateForGc extends baseClass {

	private static final PaymentPageObjects paymentPage = new PaymentPageObjects(driver);
	
	 public static void giftCodeForGc() throws Exception{
		 
		 Actionsss.scrollWindowsByPixel(500);
		 if(Actionsss.elementSize(paymentPage.getGiftCertificateLabel())) {
	        // Provided data
	        String data =GiftCerificateCodeforGc;

	        // Split the data using commas as a delimiter and store it in an array
	        String[] dataArray = data.split(",");

	     // Count the number of elements in the array
	        int arrayLength = dataArray.length;
	        logger.info(arrayLength);
        	Actionsss.javascriptClick(paymentPage.getGiftcertificateInput());
	        // Iterate over the array and print each data
	        for (String gcCodes : dataArray) {
	        	logger.info(gcCodes);
	        	//Thread.sleep(2000);	        	
	        	Actionsss.sendKeys(paymentPage.getGiftcertificateInput(),gcCodes, gcCodes+"gift code");				
	            Thread.sleep(1000);

                Actionsss.javascriptClick(paymentPage.getApplyGiftCardButton());
                logger.info("Apply button is selected");
              
                	    	Thread.sleep(2000);
							if(Actionsss.elementSize(paymentPage.getInsufficientGiftCodeBalError())) {
								logger.info("Insufficent funds in this " +gcCodes + " gift card" );
								Actionsss.clearText(paymentPage.getGiftcertificateInput());
							}else if(Actionsss.elementSize(paymentPage.getGcBelongsToDifferentCustomerError())){
								logger.info("This " + gcCodes + "Gift Card belongs to different customer ");
								Actionsss.clearText(paymentPage.getGiftcertificateInput());
							}else if (Actionsss.elementSize(paymentPage.getInvalidGcError())){
								logger.info("This " + gcCodes + "is invalid gift code");
								Actionsss.clearText(paymentPage.getGiftcertificateInput());
							}else if(Actionsss.elementSize(paymentPage.getRedemptionWithGcMsg())) {
								 logger.info("Your order has been paid using gift certificates message is displayed.");
								 String gcRedeemedMsg= Actionsss.getTextOfElement(paymentPage.getsuccessGiftCodeRedemptionMsg());																	
								// Define a regular expression pattern to match uppercase letters
							        Pattern pattern = Pattern.compile("[A-Z]+");
							        // Create a matcher with the input text
							        Matcher matcher = pattern.matcher(gcRedeemedMsg);
							        // Find the first match
							        if (matcher.find()) {
							            // Extract the matched uppercase letters
							            String uppercaseLetters = matcher.group();
							            // Print the result
							            System.out.println("Uppercase letters: " + uppercaseLetters);
							            gcCodeRedeemed=uppercaseLetters;
							        } 
							        
								 logger.info(gcCodeRedeemed);
								 PaymentPageTasks.clickReviewOrderButton();
						    	 break;
						    	 
							}// Check if it's the last iteration
						    if (gcCodes.equals(dataArray[dataArray.length - 1])) {
						        logger.info("Last iteration completed");
						        test.info("No balance in Gift certicates ,so payment is doing with credit card");
						        PaymentPageTasks.creditCardWithValidDetails();
						    }
						      
	             }
	        
	        // if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
		    //	getSuccessMsg(); 
		   // }
	    }else {
	    	test.info("Gift certificate is in cart");
	    	test.pass("No element to redeem the Gift code");
	    }
	 }
	 
	 public static void getSuccessMsg() throws InterruptedException {
		 float extractedAmount =(float) 0;
		 if(Actionsss.elementSize(paymentPage.getsuccessGiftCodeRedemptionMsgList())) {
			String gcRedeemedMsg= Actionsss.getTextOfElement(paymentPage.getsuccessGiftCodeRedemptionMsg());
			
			 String lastFourDigits = gcRedeemedMsg.substring(gcRedeemedMsg.length() - 4);
			 gcCodeRedeemed =lastFourDigits;
		        // Define a regular expression pattern to match the amount pattern
		        Pattern amountPattern = Pattern.compile("\\$([0-9]+\\.[0-9]{2})");

		        // Create a matcher object
		        Matcher matcher = amountPattern.matcher(gcRedeemedMsg);

		        // Check if the pattern is found
		        if (matcher.find()) {
		            // Extract the matched amount
		            String extractedAmountStr = matcher.group(1);
		            extractedAmount = Float.parseFloat(extractedAmountStr);
		            logger.info("Extracted Amount: " + extractedAmount);
		            totalGcDetechedAmount= totalGcDetechedAmount+extractedAmount;
		            logger.info(totalGcDetechedAmount);
		            String gcAmountDetechedStr =Actionsss.getTextOfElement(paymentPage.getGiftCertificateBalDetected());
		          
		         // Remove "-" and "$" symbols
		            String result =gcAmountDetechedStr.replace("-", "").replace("$", "");
		            logger.info(result);
		            float  expectedAmountDeteched = Float.parseFloat(result);
		            if(totalGcDetechedAmount.equals(expectedAmountDeteched)) {
		            	logger.info("Gc got redeemed and the amount is " +totalGcDetechedAmount + "and the total amount is "+Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())+" amount detected from total is " +expectedAmountDeteched);
		            	test.pass("Gc got redeemed and the amount is " +totalGcDetechedAmount + "and the total amount is "+Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())+" amount detected from total is " +expectedAmountDeteched);
		            }else {
		            	logger.info("No Gc got redeemed and the amount is " +totalGcDetechedAmount + "and the total amount is "+Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())+" amount detected from total is " +expectedAmountDeteched);
		            	test.fail("No Gc got redeemed and the amount is " +totalGcDetechedAmount + "and the total amount is "+Actionsss.getTextOfElement(paymentPage.getTotalPriceInPaymentPage())+" amount detected from total is " +expectedAmountDeteched);
		            }
		        } else {
		            System.out.println("No amount found in the input string.");

		        }
		 }
	 }
}
