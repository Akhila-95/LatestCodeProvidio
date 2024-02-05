package tasks;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;
import pageObjects.GiftCertificatePage;
import validations.FooterValidation;

public class GiftCertificatePageTasks extends baseClass{
	
	private static final GiftCertificatePage gc = new GiftCertificatePage(driver);
	private static final FooterPage fp = new FooterPage(driver);
	
	private static final String frndsName="friends name";
	private static final String fromName="Gift certificate from name";
	private static final String friendsMail="mail ";
	public static void giftCertificatePage() throws Exception {
		if(Actionsss.elementSize(gc.getGiftCertificatePageList())) {
			logger.info("Gift certificate page loaded");
		}else {
			Actionsss.javascriptClick(fp.getGiftRegistry());
		}
	}
	
	public static void getAllErrorMsgsInGiftCard() throws Exception {
		 giftCertificatePage();
		 Actionsss.javascriptClick(fp.getAddToCart());		 		 
		 FooterValidation.allErrorMsgsInGiftCard();
	}
	
	public static void gettheErrorsFromName_Recipients_confirmRecipientEMail() throws Exception {
		giftCertificatePage();
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(),fakeFirstName,fname);
        Actionsss.javascriptClick(fp.getAddToCart());        
        FooterValidation.errorsFromName_Recipients_confirmRecipientEMail();
	}
	
	public static void getErrorsRecipientEmailAndConfirmEmail() throws Exception {
		giftCertificatePage();
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(),fakeFirstName,fname);		
		Actionsss.sendKeys(fp.getGiftCardFromName(), fakelastName, fromName);
        Actionsss.javascriptClick(fp.getAddToCart());
        Thread.sleep(1000);
        FooterValidation.errorsRecipientEmailAndConfirmEmail();
	}
	
	public static void getErrorOfConfirmMail() throws Exception {
		giftCertificatePage();
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(),fakeEmail,fname);		
		Actionsss.sendKeys(fp.getGiftCardFromName(), fakelastName, fromName);		
		Actionsss.sendKeys(fp.getGiftCardfriendsMail(), fakeEmail, friendsMail);
        Actionsss.javascriptClick(fp.getAddToCart());
        
        FooterValidation.errorsForConfirmMail();
	}
	

	public static void giftCertificateForm() throws Exception {
		giftCertificatePage();
		Actionsss.click(fp.getGiftCertificateAmount());
		
		Actionsss.selectByOptions(fp.getgiftCertificateAmountDropDown());		
		Actionsss.sendKeys(fp.getGiftCardFriendsNameElement(), fakeFirstName,frndsName);		
		Actionsss.sendKeys(fp.getGiftCardFromName(), fakelastName, fromName);		
		Actionsss.sendKeys(fp.getGiftCardfriendsMail(), fakeEmail, friendsMail);		
		Actionsss.sendKeys(fp.getgiftCardConfirmFriendsMail(), fakeEmail, friendsMail);
		
		Actionsss.javascriptClick(fp.getAddToCart());
			
		//FooterValidation.validatingGiftCardAddtoCart();
		Thread.sleep(3000);
	}
}
