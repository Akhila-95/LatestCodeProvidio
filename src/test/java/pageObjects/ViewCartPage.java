package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class ViewCartPage extends baseClass{

	WebDriver lDriver;
    //pageFactory constructor for this page
	public ViewCartPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//mini cart check out btn
	@FindBy(xpath ="//a[contains(text(), 'Checkout')]")
	WebElement checkOutBtn; 
	public WebElement getSelectcheckOutBtn(){
		return checkOutBtn;
	}
	
	//mini cart check out btn
	@FindBy(xpath ="(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]")
	List<WebElement> salesforcePaypalInCartPageList; 
	public List<WebElement> getSalesforcePaypalInCartPageList() {
		return  salesforcePaypalInCartPageList;
	}
	
	//mini cart check out btn
	@FindBy(xpath ="(//div[contains(@class, 'salesforce-paymentrequest-element')])[1]")
	WebElement salesforcePaypalInCartPage; 
	public WebElement getSalesforcePaypalInCartPage() {
		return  salesforcePaypalInCartPage;
	}
	
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	List<WebElement> brainTreePaypalInCartPageList;
	public List<WebElement> getBrainTreePaypalInCartList() {
		return brainTreePaypalInCartPageList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	WebElement brainTreePaypalInCartPage;
	public WebElement getBrainTreePaypalInCartPage() {
		return brainTreePaypalInCartPage;
	}
}
