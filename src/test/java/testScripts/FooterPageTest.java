package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;
import tasks.FooterPageTasks;

public class FooterPageTest extends baseClass{
	
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyingResourceFooterLinks() throws Exception {
		FooterPageTasks.resourceFooterLinks();
	}
	
	//@Test(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyingValidEmailInSighUpBoxInFooter() throws Exception {
		
		 FooterPageTasks.validEmailInSignUpBoxInFooter();
	}
	
	//@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyingWithoutEnteringEmailInSignupBoxInFooter() throws Exception {
		
		 FooterPageTasks.withoutEnteringEmailInSignupBoxInFooter();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyinginvalidEmailInEmailSignUpBox()  throws Exception {
		 
		 FooterPageTasks.invalidEmailInEmailSignUpBox();
	}
	
	@Test//s(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void  verifyErrorMsgsInGiftCard() throws Exception {
		
		 FooterPageTasks.getAllErrorMsgsInGiftCard();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void verifytheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		
		FooterPageTasks.gettheErrorsFromName_Recipients_confirmRecipientEMail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void verifyTheErrorsRecipientEmailAndConfirmEmail() throws Exception {
		
		FooterPageTasks.getErrorsRecipientEmailAndConfirmEmail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching")	
	public static void verifyErrorsForConfirmMail() throws Exception {
		
		FooterPageTasks.getErrorOfConfirmMail();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyGiftCardToCart() throws Exception {
		
		FooterPage fp = new FooterPage(driver);
		Actionsss.CombinedClick(fp.getGiftRegistry());
		
		FooterPageTasks.giftCertificateForm();
	}
}
