package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPageDetails {

	WebDriver lDriver;
    //pageFactory constructor for this page
	public OrderPageDetails(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	

	@FindBy(xpath="//h2[@class ='order-thank-you-msg']")
	List<WebElement>  orderThankMessageList;
	public List<WebElement> getOrderThankMessageList() {
		return orderThankMessageList;
	}
	
	@FindBy(xpath="//h2[@class ='order-thank-you-msg']")
	WebElement  orderThankMessage;
	public WebElement getOrderThankMessage() {
		return orderThankMessage;
	}
	
	@FindBy(xpath="//span[@class ='summary-details order-number']")
	WebElement  orderNumber;
	public WebElement getOrderNumber() {
		return orderNumber;
	}
	
	@FindBy(xpath="//span[@class ='summary-details order-date']")
	WebElement  orderDate;
	public WebElement getOrderDate() {
		return orderDate;
	}
	
	@FindBy(xpath="//div[@class='payment-details']")
	WebElement  paymentDetailsInOrderConfirmationPage;
	public WebElement getPaymentDetailsInOrderConfirmationPage() {
		return paymentDetailsInOrderConfirmationPage;
	}
	
	@FindBy(css="div.payment-credential")
	List<WebElement>  paymentInOrderConfirmationPageList;
	public List<WebElement> getPaymentInOrderConfirmationPageList() {
		return paymentInOrderConfirmationPageList;
	}
	
	@FindBy(css="div.payment-credential")
	WebElement  paymentInOrderConfirmationPage;
	public WebElement getPaymentInOrderConfirmationPage() {
		return paymentInOrderConfirmationPage;
	}
	
	@FindBy(css="div.gift-cert-code")
	WebElement  giftCodeInOrderConfirmationPage;
	public WebElement getGiftCodeInOrderConfirmationPage() {
		return giftCodeInOrderConfirmationPage;
	}
	
	@FindBy(css="div.gift-cert-code")
	List<WebElement>  giftCodeInOrderConfirmationPageList;
	public List<WebElement> getGiftCodeInOrderConfirmationPageList() {
		return giftCodeInOrderConfirmationPageList;
	}
}
