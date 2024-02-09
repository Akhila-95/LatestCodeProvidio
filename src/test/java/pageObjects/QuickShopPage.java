package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class QuickShopPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public QuickShopPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//pdp link
	@FindBy(xpath ="//a[@class='full-pdp-link']")
	WebElement PDPLink; 
	public WebElement getSelectPDPLink(){
		return PDPLink;
	}
	
	//close button
	@FindBy(xpath ="//button[@class='close pull-right']")
	WebElement QuickShopCloseBtn; 
	public WebElement getSelectQuickShopCloseBtn(){
		return QuickShopCloseBtn;
	}
	
	@FindBy(xpath ="//button[contains(@class, 'add-to-cart')]")
	WebElement addToCartBtn; 
	public WebElement getSelectaddToCartBtn(){
		return addToCartBtn;
	}
	
	//custom input
	@FindBy(xpath ="//input[@class='quantity-select']")
	WebElement CustomInput; 
	public WebElement getSelectCustomInput(){
		return CustomInput;
	}
	
	
	
	

}
