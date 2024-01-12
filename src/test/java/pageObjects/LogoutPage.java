package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {

WebDriver lDriver;
	
	public LogoutPage(WebDriver rDriver ){
		
		lDriver=rDriver;
		PageFactory.initElements(rDriver, this);
	}
	 //hower
	@FindBy(xpath="(//a[@id='myaccount' and @aria-label ='My Account'])[1]")
	WebElement myAccount;
	public WebElement getHoverMyAccount() {
		return myAccount;
	}
	 // Element for Logout link
    @FindBy(xpath = "(//a[contains(text(), 'Logout')])[1]")
    WebElement logout;
    
    public WebElement getLogOut() {
    	return logout;
    }
}
