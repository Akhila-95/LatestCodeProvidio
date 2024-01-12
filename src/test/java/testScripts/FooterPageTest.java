package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;
import tasks.FooterPageTasks;

public class FooterPageTest extends baseClass{
	private static final FooterPage fp = new FooterPage(driver);
	@Test
	public static void verifyingResourceFooterLinks() throws Exception {
		FooterPageTasks.resourceFooterLinks();
	}
	
	@Test
	public static void verifyingSubscriptionInFooter() throws Exception {
		
		 FooterPageTasks.getSubscriptionMail();
	}
	
	@Test
	public static void  verifyErrorMsgsInGiftCard() throws Exception {
		
		 FooterPageTasks.getAllErrorMsgsInGiftCard();
	}
	
	@Test
	public static void verifytheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		
		FooterPageTasks.gettheErrorsFromName_Recipients_confirmRecipientEMail();
	}
	
	@Test
	public static void verifyTheErrorsRecipientEmailAndConfirmEmail() throws Exception {
		
		FooterPageTasks.getErrorsRecipientEmailAndConfirmEmail();
	}
	
	@Test
	public static void verifyErrorsForConfirmMail() throws Exception {
		
		FooterPageTasks.getErrorOfConfirmMail();
	}
	
	@Test
	public static void verifyGiftCardToCart() throws Exception {
		
		Actionsss.javascriptClick(fp.getGiftRegistry());
		
		FooterPageTasks.giftCertificateForm();
	}
}
