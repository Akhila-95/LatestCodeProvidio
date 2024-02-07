package PaymentProccess;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.MiniCartPage;
import pageObjects.PaymentPageObjects;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;

public class CommonProccessUptoCheckout extends baseClass {
	
	private static homepage homePage = new homepage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	
	public static void commonProccess() throws Exception {
		
		Actionsss.click(homePage.getMiniCartLink());
    	MiniCartValidation.VerifiedThatMinicartBtnClick();
    	Actionsss.click(MCP.getSelectviewCartBtn());
    	MiniCartValidation.VerifiedThatViewcartBtnClick();
    	
    	Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		
		if(Actionsss.elementSize(CP. getSelectGuestCheckoutBtnList())) {	
			test.info("User is guest");
			Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
			Thread.sleep(1000);
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, "email");
			Thread.sleep(1000);
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			 CheckOutPageValidation.verifyingThatGuestLoginForGc();
			
		}else {
			test.info("User is registered");
		}
		
	//	AddressSelection.billingAddress();
	}
}
