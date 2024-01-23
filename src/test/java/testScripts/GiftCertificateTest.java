package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.GiftCertificatePageTasks;

public class GiftCertificateTest  extends baseClass{

	@Test//s(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void  verifyErrorMsgsInGiftCard() throws Exception {
		
		 GiftCertificatePageTasks.getAllErrorMsgsInGiftCard();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void verifytheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		
		GiftCertificatePageTasks.gettheErrorsFromName_Recipients_confirmRecipientEMail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void verifyTheErrorsRecipientEmailAndConfirmEmail() throws Exception {
		
		GiftCertificatePageTasks.getErrorsRecipientEmailAndConfirmEmail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void verifyErrorsForConfirmMail() throws Exception {
		
		GiftCertificatePageTasks.getErrorOfConfirmMail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyGiftCardToCart() throws Exception {
	
		
		GiftCertificatePageTasks.giftCertificateForm();
	}
}
