package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class CheckOutPage extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public CheckOutPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//Guest login btn
	@FindBy(xpath ="//button[contains(text(), 'Guest Checkout')]")
	WebElement GuestCheckoutBtn; 
	public WebElement getSelectGuestCheckoutBtn(){
		return GuestCheckoutBtn;
	}
	
	//Guest login btn
		@FindBy(xpath ="//button[contains(text(), 'Guest Checkout')]")
		List<WebElement> GuestCheckoutBtnList; 
		public List<WebElement> getSelectGuestCheckoutBtnList(){
			return GuestCheckoutBtnList;
		}
	
	//Guest login email input
	@FindBy(xpath ="//input[@id='email-guest']")
	WebElement GuestEmailInput; 
	public WebElement getSelectGuestEmailInput(){
		return GuestEmailInput;
	}
	
	//continue Guest login btn
	@FindBy(xpath ="//button[contains(text(), 'Continue as guest')]")
	WebElement ContinueasGuesttBtn; 
	public WebElement getSelectContinueasGuesttBtn(){
		return ContinueasGuesttBtn;
	}
	
	
	
	
	

}
