package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.CheckOutPageTask2;

public class CheckOutPage2Test  extends baseClass{

private static final CheckOutPageTask2 cot2= new CheckOutPageTask2();
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEditEmailInCheckoutPage2() throws Exception {
		
		CheckOutPageTask2.editEmailInCheckoutPage2();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyinggetCutomerInfoDisplayInCOP2_Page() throws Exception {
		cot2.getshippingInfo();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingOrderSummaryDisplayInCOP2_Page() throws Exception {
		cot2.getOrderSummary();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingNextPaymentButtonDisplayInCOP2_Page() throws Exception {
		cot2.getNextPaymentButton();
	}
	//@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public void verifyingEtgLogoDisplayInCOP2_Page() throws Exception {
		cot2.getEtgLogo();
	}

}
