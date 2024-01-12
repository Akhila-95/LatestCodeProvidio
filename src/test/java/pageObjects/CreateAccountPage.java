package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage {

	WebDriver lDriver;
	//pageFactory constructor for this page
	public CreateAccountPage(WebDriver rDriver ){
			lDriver=rDriver;
			PageFactory.initElements(rDriver, this);
	}
	
	// Element for Create Account link
		@FindBy(xpath = "//a[contains(text(),'Create Account')]")
			
		WebElement createAccountLink;

		// Method to click on the Create Account link
		public  WebElement getCreateAccountLink() {
		    return createAccountLink;
		}

		// Element for First Name input field
		@FindBy(id = "registration-form-fname")
		
		WebElement firstNameInput;

		// Method to enter first name
		public  WebElement getFirstName() {	 
		    return firstNameInput;
		}

		// Element for Last Name input field
		@FindBy(id = "registration-form-lname")		
		WebElement lastNameInput;

		// Method to enter last name
		public  WebElement getLastName() {	   
		    return lastNameInput;
		}

		// Element for Phone Number input field
		@FindBy(id = "registration-form-phone")
		
		WebElement phoneInput;

		// Method to enter phone number
		public  WebElement getPhone() {
		    return phoneInput;
		}

		// Element for Email input field
		@FindBy(id = "registration-form-email")
		
		WebElement emailInput;

		// Method to enter email
		public  WebElement getEmail() {	  
		    return emailInput;
		}

		// Element for Confirm Email input field
		@FindBy(id = "registration-form-email-confirm")
		
		WebElement confirmEmailInput;

		// Method to enter confirm email
		public  WebElement getConfirmEmail() {
		   
		    return confirmEmailInput;
		}

		// Element for Password input field
		@FindBy(id = "registration-form-password")
		
		WebElement passwordInput;

		// Method to enter password
		public  WebElement getPassword() {	   
		    return passwordInput;
		}

		// Element for Confirm Password input field
		@FindBy(id = "registration-form-password-confirm")
		
		WebElement confirmPasswordInput;

		// Method to enter confirm password
		public  WebElement getConfirmPassword() {    
		    return confirmPasswordInput;
		}

		// Element for Create Account button
		@FindBy(xpath = "//button[contains(text(), 'Create Account')]")
		
		WebElement createAccountButton;

		// Method to click on the Create Account button
		public  WebElement getCreateAccountButton() {
		    return createAccountButton;
		}
		@FindBy(xpath = "//div[contains(text(),'Please enter the same value again.')]")
		WebElement sameMailError;
		
		public WebElement getSameMailError() {
			return sameMailError;
		}
		@FindBy(xpath = "//div[contains(text(),'Does not match password')]")
		WebElement passwordMismatchError;
		
		public WebElement getPasswordMismatchError() {
			return passwordMismatchError;
		}
		@FindBy(xpath = "(//div[contains(text(),'This field is required.')])")
		List<WebElement> allFieldsErrorList;
		
		public List<WebElement> getAllFieldsErrorList() {
			return allFieldsErrorList;
		}
	
		@FindBy(xpath = "(//div[contains(text(),'This field is required.')])")
		WebElement allFieldsError;
		
		public WebElement getAllFieldsError() {
			return allFieldsError;
		}
		
		@FindBy(xpath = "//div[contains(text(),'This field needs at least 8 characters, 1 number, 1 lowercase letter, 1 uppercase letter, & 1 special character.')]")
		WebElement passwordFieldStrength;
		
		public WebElement getpasswordFieldStrength() {
			return passwordFieldStrength;
		}
		
		
		@FindBy(xpath = "//div[contains(text(),'Already exists, Please enter another value.')]")
		WebElement alreadyEmailExists;
		
		public WebElement getalreadyEmailExists() {
			return alreadyEmailExists;
		}
		
		@FindBy(xpath = "//div[contains(text(),'Please enter a valid phone number')]")
		WebElement phoneNumberError;
		
		public WebElement getphoneNumberError() {
			return phoneNumberError;
		}		

		@FindBy(xpath = "(//div[@id='form-email-error'])[2]")
		WebElement emailFormatError;
		
		public WebElement getemailFormatError() {
			return emailFormatError;
		}
		@FindBy(xpath = "//h1[@class='account-page-title']")
		WebElement accountPageTitle;
		
		public WebElement getAccountPageTitle() {
			return accountPageTitle;
		}
		
}
