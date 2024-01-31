package PaymentProccess;

import com.providio.testcases.baseClass;

import data.AddressSelection;
import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.CheckOutPage2;
import pageObjects.CheckOutPage3;
import pageObjects.MiniCartPage;
import pageObjects.PaymentPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import tasks.CheckOutPageTasks;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;
import validations.ShippingPageValidation;

public class CommonProccessUptoCheckout extends baseClass {
	
	private static homepage homePage = new homepage(driver);
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	private static final CheckOutPage2 cop2 = new CheckOutPage2(driver);
	private static final 	PaymentPage pp = new PaymentPage(driver);
	private static final CheckOutPage3 cop3 = new CheckOutPage3(driver);
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
		
		AddressSelection.billingAddress();
	}
}
