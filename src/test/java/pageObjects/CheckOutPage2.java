package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOutPage2 {

		WebDriver lDriver;
	    //pageFactory constructor for this page
		public CheckOutPage2(WebDriver rDriver){
			lDriver =rDriver;
			PageFactory.initElements(rDriver, this);
		}
		
		@FindBy(xpath="//div[@class='card shipping-section']")
		List<WebElement> shippingPage;
		public List<WebElement> getshippingPage() {
			return shippingPage;
		}
		
		@FindBy(css="div.customer-summary")
		WebElement customerInfo;
		public WebElement getCustomerInfo() {
			return customerInfo;
		}
		
		@FindBy(xpath = "//button[@aria-label='action.edit.step.msg.customer']")
		WebElement editCutomerInfo;
		public WebElement getEditCustomerInfo() {
			return editCutomerInfo;
		}
		@FindBy(css="div.shipping-section")
		WebElement shippingInfo;
		public WebElement getshippingInfo() {
			return shippingInfo;
		}
		
		@FindBy(xpath="//h2[contains(text(),'Order Summary')]")
		WebElement orderSummaryDiv;
		public WebElement getOrderSummaryDiv() {
			return orderSummaryDiv;
		}
		
		@FindBy(css="a.back-to-cart")
		WebElement backToCart;
		public WebElement getBackToCart() {
			return backToCart;
		}
		
		@FindBy(css="button.submit-shipping")
		WebElement  nextPaymentButton;
		public WebElement getNextPaymentButton() {
			return nextPaymentButton;
		}
		
		@FindBy(css="img.logo")
		WebElement  etgLogo;
		public WebElement getEtgLogo() {
			return  etgLogo;
		}
}
