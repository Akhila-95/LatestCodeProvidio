package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage {

	WebDriver lDriver;
    //pageFactory constructor for this page
	public PlaceOrderPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//div[@class='summary-details billing']")
	WebElement  summaryOfBillingAddress;
	public WebElement getgsummaryOfBillingAddress() {
		return summaryOfBillingAddress;
	}
	
	@FindBy(xpath="//div[@class='summary-details billing']")
	List<WebElement>  summaryOfBillingAddressList;
	public List<WebElement> getgsummaryOfBillingAddressList() {
		return summaryOfBillingAddressList;
	}
	
	@FindBy(xpath="(//div[@class='address1'])[2]")
	WebElement  billingAddress;
	public WebElement getBillingAddress() {
		return billingAddress;
	}
}
