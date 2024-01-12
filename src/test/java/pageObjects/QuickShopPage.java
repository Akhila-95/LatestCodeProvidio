package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.providio.testcases.baseClass;

public class QuickShopPage extends baseClass{
	
	WebDriver lDriver;
    //pageFactory constructor for this page
	public QuickShopPage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	
	//sizeElementsSelection
	

}
