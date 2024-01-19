package tasks;

import com.providio.testcases.baseClass;


import functionality.Actionsss;
import pageObjects.CreateAccountPage;
import pageObjects.LogoutPage;
import pageObjects.loginPage;
import validations.CreateAccountValidation;

public class CreateAccountPageTasks extends baseClass{

	private static final CreateAccountPage cap = new CreateAccountPage(driver);
	private static final loginPage lp = new loginPage(driver);
	
	private static final String firstName="First Name";
	private static final String lastName="Last Name";
	private static final String phonenumber="Phone Number";
	private static final String CreateAccEmail="Email";
	private static final String CreateAccConfirmEmail="Confirm Email";
	private static final String CreateAccPassword="Password";
	private static final String CreateAccConfirmPassword="Confirm Password";
	
	private static final String firstNameEmpty="First Name empty";
	private static final String lastNameEmpty="Last Name empty";
	private static final String phonenumberEmpty="Phone Numberempty";
	private static final String CreateAccEmailEmpty="Emailempty";
	private static final String CreateAccConfirmEmailEmpty="Confirm Emailempty";
	private static final String CreateAccPasswordEmpty="Password";
	private static final String CreateAccConfirmPasswordEmpty="Confirm Password";
	
	private static boolean isCreateAccount = false;
	private static final  LogoutPage lop = new LogoutPage(driver);
	
	public static void createAccPage() throws InterruptedException {
		
		if(Actionsss.elementSize(lp.getLoginPageList())) {
			logger.info("Create account already loaded");		
		}else {
			if(Actionsss.elementSize(lp.getSignInList())) {
				
				logger.info("Create account  page not loaded");
				 Actionsss.click(lp.clickSign());
				// Navigate to the Create Account page
			       Actionsss.click(cap.getCreateAccountLink());
			 
			       CreateAccountValidation.createAccountPageValidation();  
			        
			}else {
				logger.info("user logged in");
				LogOutTasks.verifyLogout();
				
				if(Actionsss.displayElement(lp.clickSign())) {
					
					 Actionsss.click(lp.clickSign());					 
					 Actionsss.click(cap.getCreateAccountLink());
					 
					 CreateAccountValidation.createAccountPageValidation();  
				}
			}
		}
	}
	
	public static void validateEmailAndConfirmEmail() throws Exception {
		createAccPage();
	    
	    test.info("Validating the Email And ConfirmEmail in create account");

	    // Scroll the window by 300 pixels
	    //Actionsss.scrollWindowsByPixel(300);

	    // Enter user details
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "6789765567",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), fakeEmail,CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), "akhila.m@etg.digital",CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy@07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy@07",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate the Email and Confirm Email fields
	    CreateAccountValidation.validateEmailAndConfirmEmail();
	    Thread.sleep(2000);

	}

	public static void validatePasswordMismatch() throws Exception {

		createAccPage();
	    test.info("Validating the password mismatch error in create account");

	    // Enter user details
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "6789765567",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), fakeEmail,CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), fakeEmail,CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy@07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy@017",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate the password mismatch error
	    CreateAccountValidation.validatePasswordMismatch();
	    Thread.sleep(2000);	
	}
	
	
	public static void validateEmptyText() throws Exception {
		
		createAccPage();
	    test.info("Validating the error if empty text is passed in create account");

	    // Enter empty text for user details
	    Actionsss.sendKeys(cap.getFirstName(), "",firstNameEmpty);
	    Actionsss.sendKeys(cap.getLastName(), "",lastNameEmpty);
	    Actionsss.sendKeys(cap.getPhone(), "",phonenumberEmpty);
	    Actionsss.sendKeys(cap.getEmail(), "",CreateAccEmailEmpty);
	    Actionsss.sendKeys(cap.getConfirmEmail(), "",CreateAccConfirmEmailEmpty);
	    Actionsss.sendKeys(cap.getPassword(), "",CreateAccPasswordEmpty);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "",CreateAccConfirmPasswordEmpty);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate all errors for empty text fields
	    CreateAccountValidation.validateAllErrors();
	    Thread.sleep(2000);
		
	}
	
	
	public static void validatePasswordStrength() throws Exception {

		createAccPage();
	    test.info("Validating password strength in create account");

	    // Enter user details with a password that doesn't meet strength criteria
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "6789765567",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), fakeEmail,CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), fakeEmail,CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy07",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate the password strength error
	    CreateAccountValidation.passwordStrengthError();
	    Thread.sleep(2000);
		
		
	}


	public static void validatingWithExistingAccount() throws Exception {
		createAccPage();
	    test.info("Verifying the error with an already created account");

	    // Enter user details with an email address that already exists
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "6789765567",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), "akhila.m@etg.digital",CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), "akhila.m@etg.digital",CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy@07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy@07",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate the error indicating an existing account with the provided email address
	    CreateAccountValidation.alreadyExistsMail();
	    Thread.sleep(2000);
	
		
	}
	

	public static void validatingPhoneNumError() throws Exception {
		createAccPage();
	    test.info("Verifying phone number error in create account");

	    // Enter user details with an invalid phone number
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "678977",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), fakeEmail,CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), fakeEmail,CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy@07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy@07",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate the error indicating an invalid phone number
	    CreateAccountValidation.phoneNumber();
	    Thread.sleep(2000);		
		
	}
	

	public static void ValidatingEmailformatError() throws Exception {
		
		createAccPage();
	    test.info("Verifying email format error in create account");

	    // Enter user details with an invalid email format
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "6784567977",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), "akhila.metg.digital",CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), "akhila.metg.digital",CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy@07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy@07",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);

	    // Validate the error indicating an invalid email format
	    CreateAccountValidation.emailFormat();
	    Thread.sleep(2000);
		
	}

	public static void createAccountWithValidCredientials() throws Exception {
		
		createAccPage();
	    test.info("Verifying the account creation with valid details ");

	    // Enter valid user details
	    Actionsss.sendKeys(cap.getFirstName(), fakeFirstName,firstName);
	    Actionsss.sendKeys(cap.getLastName(), fakelastName,lastName);
	    Actionsss.sendKeys(cap.getPhone(), "6789723457",phonenumber);
	    Actionsss.sendKeys(cap.getEmail(), fakeEmail,CreateAccEmail);
	    Actionsss.sendKeys(cap.getConfirmEmail(), fakeEmail,CreateAccConfirmEmail);
	    Actionsss.sendKeys(cap.getPassword(), "Akhireddy@07",CreateAccPassword);
	    Actionsss.sendKeys(cap.getConfirmPassword(), "Akhireddy@07",CreateAccConfirmPassword);

	    // Trigger the Create Account action using JavaScript click
	    Actionsss.javascriptClick(cap.getCreateAccountButton());

	    // Pause for 3 seconds to allow the validation to complete
	    Thread.sleep(3000);
	    Actionsss.scrollWindowsByPixel(-300);
	    // Validate the successful creation by checking the account page title
	    CreateAccountValidation.accountPageTitle();
	    Thread.sleep(2000);
	    
	    isCreateAccount=true;
	}
}
