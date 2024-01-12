package pageObjects;

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
}
