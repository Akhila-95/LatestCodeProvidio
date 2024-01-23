package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;
import validations.FooterValidation;
import validations.HomePageValidations;

public class FooterPageTasks extends baseClass {

	private static final FooterPage fp = new FooterPage(driver);
	
	public static void resourceFooterLinks() throws Exception {

		Actionsss.scrollIntoViewCenter(fp.getResourceFooter() );
		
		Thread.sleep(1000);
		
		Actionsss.scrollWindowsByPixel(1000);
			
		getResourcesLinksFromFooter();
	}
	
	public static void validEmailInSignUpBoxInFooter() throws Exception {
	
		test.info("Entered valid email id in email sign up in footer");
		
		Actionsss.sendKeys(fp.getSubscribeSignUpInput(), fakeEmail, "friend email ");		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		//Thread.sleep(3000);
		FooterValidation.validatingSubscriptionSuccessPoPuP();
	}
	
	public static void withoutEnteringEmailInSignupBoxInFooter() throws Exception {
		
		test.info("Verifying the error message Without entering the email in email sign up in footer");
		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		FooterValidation.validatingSubscriptionSignUpError();
	}
	
	public static void invalidEmailInEmailSignUpBox() throws Exception {
		
		test.info("Enter invalid email in sign up box in footer");
		
		Actionsss.sendKeys(fp.getSubscribeSignUpInput(), "akhilagmail", "invalid email ");		
		Actionsss.javascriptClick(fp.getSubscribeButton());
		
		FooterValidation.validatingSubscriptionSignUpError();
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
	  
			GiftCertificatePageTasks.giftCertificateForm();
			
		}else if(selectedLinkText.equals("Brands Test")) {
			
			test.info("Verify the Navigation to A-Z brand page from footer link");
			
			Thread.sleep(1000);
			
			if(Actionsss.displayElement(fp.getAzBrands())) {
			
				test.info(" Navigated to A-Z brand page from footer link");
			}			
		}
	}
}
