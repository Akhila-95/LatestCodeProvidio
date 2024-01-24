package Payments;


import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.PaymentPage;

public class GiftCertificateForGc extends baseClass {

	private static final PaymentPage pp = new PaymentPage(driver);
	
	 public static void giftCodeForGc() throws Exception{
		 
		 if(Actionsss.elementSize(pp.getGiftCertificateLabel())) {
	        // Provided data
	        String data =GiftCerificateCodeforGc;

	        // Split the data using commas as a delimiter and store it in an array
	        String[] dataArray = data.split(",");
	        Actionsss.scrollWindowsByPixel(500);
        	Actionsss.javascriptClick(pp.getGiftcertificateInput());
	        // Iterate over the array and print each data
	        for (String gcCodes : dataArray) {
	        	logger.info(gcCodes);
	        	//Thread.sleep(2000);	        	
	        	Actionsss.sendKeys(pp.getGiftcertificateInput(),gcCodes, gcCodes+"gift code");				
	            Thread.sleep(1000);

                Actionsss.javascriptClick(pp.getApplyGiftCardButton());
                	    logger.info("Apply button is selected");
              
                	    	Thread.sleep(2000);
							if(Actionsss.elementSize(pp.getInsufficientGiftCodeBalError())) {
								logger.info("Insufficent funds in this " +gcCodes + " gift card" );
								Actionsss.clearText(pp.getGiftcertificateInput());
							}else if(Actionsss.elementSize(pp.getGcBelongsToDifferentCustomerError())){
								logger.info("This " + gcCodes + "Gift Card belongs to different customer ");
								Actionsss.clearText(pp.getGiftcertificateInput());
							}else if (Actionsss.elementSize(pp.getInvalidGcError())){
								logger.info("This " + gcCodes + "is invalid gift code");
								Actionsss.clearText(pp.getGiftcertificateInput());
							}else if(Actionsss.elementSize(pp.getRedemptionWithGcMsg())) {
								 logger.info("Your order has been paid using gift certificates message is displayed.");						    
						    	 break;
							}					
	             }
	    }else {
	    	test.info("Gift certificate is in cart");
	    	test.pass("No element to redeem the Gift code");
	    }
	 }
}
