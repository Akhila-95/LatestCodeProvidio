package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GiftCertificatePage {

	WebDriver lDriver;
    //pageFactory constructor for this page
	public GiftCertificatePage(WebDriver rDriver){
		lDriver =rDriver;
		PageFactory.initElements(rDriver, this);
	}
	@FindBy(xpath="(//div[contains(text(),'Gift Certificates')][1]")
	List<WebElement> giftCertificatePage;
	public List<WebElement> getGiftCertificatePageList() {
		return giftCertificatePage;
	}
}
