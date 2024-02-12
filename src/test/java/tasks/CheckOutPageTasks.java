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

public class CheckOutPageTasks extends baseClass{
	
	private static final String Email = "GuestEmail";
	private static ViewCartPage VCP = new ViewCartPage(driver);
	private static CheckOutPage CP = new CheckOutPage(driver);

	

	public static void CheckOutPageLoaded() throws Exception {
     	List<WebElement> guestCheckout = driver.findElements(By.xpath("//div[@data-customer-type='guest']"));
     	List<WebElement> CheckoutPage = driver.findElements(By.xpath("//div[@class='col-sm-7']"));
     
     	if (guestCheckout.size()>0 &&CheckoutPage.size()>0) {
     	    logger.info("Guest checkout page is already loaded");
     	}else {
     		ViewCartPageTasks.viewCartpage();
    		Actionsss.CombinedClick(VCP.getSelectcheckOutBtn());
     	}
	}
	
	public static void GuestMailCheckOut() throws Exception {
		CheckOutPageLoaded();
		guestCheckout();
	
	}
	
	public static void guestCheckout() throws InterruptedException {
		if(Actionsss.elementSize(CP. getSelectGuestCheckoutBtnList())) {	
			test.info("User logged in as guest");
			Actionsss.CombinedClick(CP.getSelectGuestCheckoutBtn());		
			Actionsss.sendKeys(CP.getSelectGuestEmailInput(), guestmail, Email);		
			Actionsss.CombinedClick(CP.getSelectContinueasGuesttBtn());
			CheckOutPageValidation.VerifiedThatGuestLogin();
		}else {
			test.info("User logged in as registered");
		}
	}
}
