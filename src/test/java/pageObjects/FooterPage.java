package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FooterPage {

	WebDriver lDriver;
	//pageFactory constructor for this page
	public FooterPage(WebDriver rDriver ){
			lDriver=rDriver;
			PageFactory.initElements(rDriver, this);
	}
	
	@FindBy(xpath="//div[@id='resources']//a")
	List<WebElement> resourceFooterList;
	
	public List<WebElement> getResourceFooterList() {
		return resourceFooterList;
	}
	
	@FindBy(xpath="//div[@id='resources']//a")
	WebElement resourceFooter;
	
	public WebElement getResourceFooter() {
		return resourceFooter;
	}
	@FindBy(css="h2.track-order-header")
	WebElement checkOrder;
	
	public WebElement getCheckOrder() {
		return checkOrder;
	}
	@FindBy(css="h1.page-title")
	WebElement wishListPage;
	
	public WebElement getWishListPage() {
		return wishListPage;
	}
	
	@FindBy(xpath="//p[contains(text(),'This list is empty.')]")
	WebElement wishListPageEmpty;
	
	public WebElement getWishListPageEmpty() {
		return wishListPageEmpty;
	}
	
	@FindBy(xpath="//h2[contains(text(),'A - Z Brands')]")
	WebElement azBrands;
	
	public WebElement getAzBrands() {
		return azBrands;
	}
	
	//gift registry link
	@FindBy(xpath  = "//a[contains(text(),'Gift Registry')]")
	WebElement giftCardElement;
	public WebElement getGiftRegistry() {
		return giftCardElement;
	}
	
	//amount
	@FindBy(xpath = "//div[@class='amountdropdown-list']")
	WebElement giftCertificateAmount;
	
	public WebElement getGiftCertificateAmount() {
		return giftCertificateAmount;
	}
	//amount
		@FindBy(xpath = "//div[@class='amountdropdown-list']//li")
		List<WebElement> giftCertificateAmountDropDown;
		
		public List<WebElement> getgiftCertificateAmountDropDown() {
			return giftCertificateAmountDropDown;
		}
		//friends name
		@FindBy(xpath = "//input[@id='giftcert_purchase_recipient']")
		WebElement giftCardfriendsNameElement;
		
		public WebElement getGiftCardFriendsNameElement() {
			return giftCardfriendsNameElement;
		}
		
		//yoursname
		@FindBy(xpath = "//input[@id='giftcert_purchase_from']")
		WebElement giftCardfromName;
		
		public WebElement getGiftCardFromName() {
			return giftCardfromName;
		}
		//Friend Name
		@FindBy(xpath = "//input[@id='giftcert_purchase_recipientEmail']")
		WebElement giftCardfriendsMail;
		
		public WebElement getGiftCardfriendsMail() {
			return giftCardfriendsMail;
		}
		
		//confirm friend mail
		@FindBy(xpath = "//input[@id='giftcert_purchase_confirmRecipientEmail']")
		WebElement giftCardConfirmFriendsMail;
		
		public WebElement getgiftCardConfirmFriendsMail() {
			return giftCardConfirmFriendsMail;
		}
		
		@FindBy(css = "button.addto-cartbtn")
		WebElement addToCart;
		
		public WebElement getAddToCart() {
		return addToCart;
		}
		
		// error messages
		
		@FindBy(id="form-recipient-error")
		WebElement RecipientNameError;
		
		public WebElement getErrorForRecipientName() {
			return RecipientNameError;
		}
		
		@FindBy(id = "form-from-error")
		WebElement fromNameError;
		
		public WebElement  getFromNameError() {
			return fromNameError;
		}
		
		@FindBy(xpath = "//div[@id='form-recipientEmail-error']")
		WebElement recipientEmailError;
		
		public WebElement  getRecipientEmailError() {
			return recipientEmailError;
		}
		
		@FindBy(xpath = "//div[@id='form-email-confirm-error']")
		WebElement recipientConfirmEmailError;
		
		public WebElement  getRecipientConfirmEmailError() {
			return recipientConfirmEmailError;
		}
				

		@FindBy(xpath = "//div[@class='alert alert-success add-to-basket-alert text-center']")
		WebElement addToCartSuccessMsg;
		
		public WebElement getAddToCartSuccessMsg() {
		return addToCartSuccessMsg;
		}
		
		@FindBy(css = "button.subscribe-email")
		WebElement subscribeButton;
		
		public WebElement getSubscribeButton() {
		return subscribeButton;
		}
		
		@FindBy(xpath = "//div[@class='email-signup-alert text-center alert-danger']")
		WebElement subscribeSignUpError;
		
		public WebElement getsubscribeSignUpError() {
		return subscribeSignUpError;
		}
		
		@FindBy(id = "dwfrm_mcsubscribe_email")
		WebElement subscribeSignUpInput;
		
		public WebElement getSubscribeSignUpInput() {
		return subscribeSignUpInput;
		}
		
		@FindBy(xpath = "//div[@class='email-signup-alert text-center alert-success']")
		WebElement subscribeMessage;
		
		public WebElement getSubscribeMessage() {
		return subscribeMessage;
		}
}
