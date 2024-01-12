package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;
import validations.FooterValidation;
import validations.HomePageValidations;

public class FooterPageTasks extends baseClass {

	private static final FooterPage fp = new FooterPage(driver);
	private static final String frndsName="friends name";
	private static final String fromName="Gift certificate from name";
	private static final String friendsMail="mail ";
	public static void resourceFooterLinks() throws Exception {

		Actionsss.scrollIntoViewCenter(fp.getResourceFooter() );
		
		Thread.sleep(1000);
		
		Actionsss.scrollWindowsByPixel(1000);
			
		getResourcesLinksFromFooter();
	}
	
	public static void getSubscriptionMail() throws Exception {
		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		FooterValidation.validatingSubscriptionSignUpError();
		
		Actionsss.sendKeys(fp.getSubscribeSignUpInput(), fakeEmail, friendsMail);
		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		//Thread.sleep(3000);
		FooterValidation.validatingSubscriptionSuccessPoPuP();
	}
	
	
	public static void getAllErrorMsgsInGiftCard() throws Exception {
		
		Actionsss.javascriptClick(fp.getGiftRegistry());
		
		test.info("Verify the all the errors in gift card page");
		
		 Actionsss.javascriptClick(fp.getAddToCart());		 
		 
		 FooterValidation.allErrorMsgsInGiftCard();
	}
	
	public static void gettheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		test.info("Verify the error for Errors FromName ,Recipients mail, confirm Recipient EMail in gift card");
		
		Actionsss.javascriptClick(fp.getGiftRegistry());
	      
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(),fakeFirstName,fname);
		
	   // Click on "Add to Cart" button
        Actionsss.javascriptClick(fp.getAddToCart());
        
        FooterValidation.errorsFromName_Recipients_confirmRecipientEMail();
	}
	
	public static void getErrorsRecipientEmailAndConfirmEmail() throws Exception {
		test.info("Verify the error for Recipients mail, confirm Recipient EMail in gift card"); 
		
		Actionsss.javascriptClick(fp.getGiftRegistry());
	      
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(),fakeFirstName,fname);
		
		Actionsss.sendKeys(fp.getGiftCardFromName(), fakelastName, fromName);
	 // Click on "Add to Cart" button
        Actionsss.javascriptClick(fp.getAddToCart());
        Thread.sleep(1000);
        FooterValidation.errorsRecipientEmailAndConfirmEmail();
	}
	
	public static void getErrorOfConfirmMail() throws Exception {
		test.info("Verify the error for confirm Recipient EMail in gift card"); 
		
		Actionsss.javascriptClick(fp.getGiftRegistry());
	      
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(),fakeEmail,fname);
		
		Actionsss.sendKeys(fp.getGiftCardFromName(), fakelastName, fromName);
		
		Actionsss.sendKeys(fp.getGiftCardfriendsMail(), fakeEmail, friendsMail);
		
	 // Click on "Add to Cart" button
        Actionsss.javascriptClick(fp.getAddToCart());
        
        FooterValidation.errorsForConfirmMail();
	}
	

	public static void giftCertificateForm() throws Exception {
		
		HomePageValidations.verifyHomePageGiftCardLink();
		
		Actionsss.click(fp.getGiftCertificateAmount());
		
		Actionsss.selectByOptions(fp.getgiftCertificateAmountDropDown());
		
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(), fakeFirstName,frndsName);
		
		Actionsss.sendKeys(fp.getGiftCardFromName(), fakelastName, fromName);
		
		Actionsss.sendKeys(fp.getGiftCardfriendsMail(), fakeEmail, friendsMail);
		
		Actionsss.sendKeys(fp.getgiftCardConfirmFriendsMail(), fakeEmail, friendsMail);
		
		Actionsss.javascriptClick(fp.getAddToCart());
			
		FooterValidation.validatingGiftCardAddtoCart();
	}
	
	public static void getResourcesLinksFromFooter() throws Exception {
		
		Actionsss.selectByOptions(fp.getResourceFooterList());
		
		if(selectedLinkText.equals("Check Order")) {
			
			test.info("Verify the Navigation to check Order page from footer link");
			
			if(Actionsss.displayElement(fp.getCheckOrder())) {
				
				test.pass("Navigated to check Order page ");
			}

			
		}else if (selectedLinkText.equals("Account")) {
			
			test.info("Verify the navigation of login page from footer link");
			
			 LoginPageTasks.verifyThatuserLogin();
			 
		}else if(selectedLinkText.equals("Wishlist")) {
			
			test.info("Verify the navigation of wishlist from footer links ");
			
			Actionsss.displayElement(fp.getWishListPage());
						
			Thread.sleep(1000);
			
			if(Actionsss.displayElement(fp.getWishListPageEmpty())) {
				
				test.info("No products in wishlist");
				
			}else {
				
				test.info("Have Products in wishlist");
				
			}
			
		}else if(selectedLinkText.equals("Gift Registry")) {
			
			test.info("Verify the navigation of gift certificate page ");
	  
			  
			  giftCertificateForm();
			
		}else if(selectedLinkText.equals("Brands Test")) {
			
			test.info("Verify the Navigation to A-Z brand page from footer link");
			
			Thread.sleep(1000);
			
			if(Actionsss.displayElement(fp.getAzBrands())) {
			
				test.info(" Navigated to A-Z brand page from footer link");
			}			
		}
	}
}
