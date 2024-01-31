package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class ProductDetailPage extends baseClass{

	WebDriver lDriver;
    //pageFactory constructor for this page
	public ProductDetailPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//wishList on Pdp page
	@FindBy(xpath ="//button[contains(@class, 'add-to-wish-list')]")
	WebElement wishListBtn; 
	public WebElement getSelectWishListBtn(){
		return wishListBtn;
	}
	
	//addtoCart on Pdp page
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	WebElement addtoCartBtn; 
	public WebElement getSelectAddtoCartBtn(){
		return addtoCartBtn;
	}
	
    // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//div[contains(@class,'salesforce-buynow-element ')]")
    WebElement salesforcePaypalBuyNow;
    public WebElement getSalesforcePaypalBuyNow() {
    	return salesforcePaypalBuyNow;
    }
    
 // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//div[contains(@class,'salesforce-buynow-element ')]")
    List<WebElement> salesforcePaypalBuyNowList;
    public  List<WebElement> getSalesforcePaypalBuyNowList() {
    	return salesforcePaypalBuyNowList;
    }
    // WebElement for the "Paypal Buy Now" button
    @FindBy(css = "div.product-detail")
    List<WebElement> pdpPagination;
    public  List<WebElement> getPdpPagination() {
    	return pdpPagination;
    }

    // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "//button[contains(@class,'buy-now')]")
    WebElement buyNowButton;
    public  WebElement getBuyNowButton() {
    	return buyNowButton;
    }
    
    // WebElement for the "Paypal Buy Now" button
    @FindBy(xpath = "(//button[contains(text(),'Place Order')])[1]")
    WebElement placeOrderInBuyNow;
    public  WebElement getplaceOrderInBuyNow() {
    	return placeOrderInBuyNow;
    }
}
