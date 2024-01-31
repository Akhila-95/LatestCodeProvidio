package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class MiniCartPage extends baseClass{
	WebDriver lDriver;
    //pageFactory constructor for this page
	public MiniCartPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//mini cart view cart btn
	@FindBy(xpath ="//a[contains(text(), 'View Cart')]")
	WebElement viewCartBtn; 
	public WebElement getSelectviewCartBtn(){
		return viewCartBtn;
	}
	
	//mini cart check out btn
	@FindBy(xpath ="//a[contains(text(), 'Checkout')]")
	WebElement checkOutBtn; 
	public WebElement getSelectcheckOutBtn(){
		return checkOutBtn;
	}

	@FindBy(xpath = "//div[contains(@class,'salesforce')]")
	List<WebElement> salesforcePaypalInMiniCartList;
	public List<WebElement> getSalesforcePaypalInMiniCartList() {
		return salesforcePaypalInMiniCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	List<WebElement> brainTreePaypalInMiniCartList;
	public List<WebElement> getBrainTreePaypalInMiniCartList() {
		return brainTreePaypalInMiniCartList;
	}
	
	@FindBy(xpath = "//div[contains(@class,'salesforce')]")
	WebElement salesforcePaypalInMiniCart;
	public WebElement getSalesforcePaypalInMiniCart() {
		return salesforcePaypalInMiniCart;
	}
	
	@FindBy(xpath = "//div[contains(@class,'js_braintree_paypal_cart_button')]")
	WebElement brainTreePaypalInMiniCart;
	public WebElement getBrainTreePaypalInMiniCart() {
		return brainTreePaypalInMiniCart;
	}
}
