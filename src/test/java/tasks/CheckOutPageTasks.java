package tasks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CheckOutPage;
import pageObjects.MiniCartPage;
import pageObjects.ViewCartPage;
import pageObjects.homepage;
import validations.CheckOutPageValidation;
import validations.MiniCartValidation;

public class CheckOutPageTasks extends baseClass{
	
	private static final String Email = "GuestEmail";
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);
	private static homepage homePage = new homepage(driver);
	private static MiniCartPage MCP = new MiniCartPage(driver);
	
	
	
/*	public static void GuestMailCheckOut() throws Exception {
		HomePageTasks.miniCartBtnClick();
		Actionsss.CombinedClick(MCP.getSelectviewCartBtn());
		MiniCartValidation.VerifiedThatViewcartBtnClick();
		Actionsss.click(VCP.getSelectcheckOutBtn());
		MiniCartValidation.VerifiedThatCheckOutBtnClick();
		//Actionsss.CombinedClick(VCP.getSelectcheckOutBtn());
		//MiniCartValidation.VerifiedThatCheckOutBtnClick();
		guestCheckout();
		//Actionsss.click(homePage.clickOnLogo());		
	}
*/
	public static void CheckOutPageLoaded() throws Exception {
     	List<WebElement> guestCheckout = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
     	List<WebElement> CheckoutPage = driver.findElements(By.xpath("//div[@class='col-sm-7']"));
     
     	if (guestCheckout.size()>0 &&CheckoutPage.size()>0) {
     	    logger.info("Guest checkout page is already loaded");
     	}else {
     		
     		ViewCartPageTasks.viewCartpage();
    		//Actionsss.CombinedClick(VCP.getSelectcheckOutBtn());
     		WebElement checkoutBtn= driver.findElement(By.xpath("//a[contains(text(), 'Checkout')]"));
     		checkoutBtn.click();
     	}
	}
	
	public static void GuestMailCheckOut() throws Exception {
		CheckOutPageLoaded();
		Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
		Thread.sleep(1000);
		Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);
		Thread.sleep(1000);
		Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
		CheckOutPageValidation.VerifiedThatGuestLogin();
	//	Actionsss.CombinedClick(homePage.clickOnLogo());
		Thread.sleep(2000);
	}
	public static void guestCheckout() throws InterruptedException {
	//	if(Actionsss.elementSize(CP.getSelectGuestCheckoutBtnList())) {
			test.info("User is guest");
			Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());
			Thread.sleep(1000);
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);
			Thread.sleep(1000);
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			CheckOutPageValidation.VerifiedThatGuestLogin();
		
	}
}