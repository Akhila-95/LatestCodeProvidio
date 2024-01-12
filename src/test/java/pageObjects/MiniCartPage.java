package pageObjects;

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

}
