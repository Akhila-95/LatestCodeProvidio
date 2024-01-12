package com.providio.Scenarios;

import com.providio.Validations.postValidationAfterTheClick;
import com.providio.pageObjects.productDescriptionPage;
import com.providio.testcases.baseClass;

public class ReviewProduct extends baseClass{

	public void writeReviewForProduct() throws InterruptedException {
	    productDescriptionPage pdp = new productDescriptionPage(driver);
	    Thread.sleep(2000);
	    pdp.clickOnWriteAReviewAtTop(driver);
	    logger.info("Clicked on Write a Review at the top");
	    pdp.clickOnRating(driver);
	    logger.info("Clicked on Rating");
	    pdp.clickOnReviewHeadline(driver, headline);
	    logger.info("Entered Review Headline");
	    pdp.clickOnComments(comment);
	    logger.info("Entered Comments");
	    pdp.clickOnYes();
	    logger.info("Clicked on Yes");
	    pdp.clicknickName(nickName);
	    logger.info("Entered Nickname");
	    pdp.clickOnLoc(location);
	    logger.info("Entered Location");
	    pdp.clickOnSubmitReview(driver);
	    logger.info("Clicked on Submit Review");
	    Thread.sleep(2000);
	    // Add any additional steps for writing a review
	    postValidationAfterTheClick.validateReviewProduct();
	    
	    pdp.clickOncontinueShoping(driver);
	    logger.info("clicked on the clickOncontinueShoping button");
	}
	

	public static void reviewYepto() throws InterruptedException {
		
		test.info("Yopto review are activated");
		productDescriptionPage pdp = new productDescriptionPage(driver);
		pdp.yoptpoReviews();

	}

}
