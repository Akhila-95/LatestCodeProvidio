package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.CreateAccountPage;
import pageObjects.loginPage;

public class CreateAccountValidation  extends baseClass{

	
	private static final  CreateAccountPage cap = new CreateAccountPage(driver);
	private static final  loginPage lp = new loginPage(driver);
	
	public static void createAccountPageValidation() {
		test.info("Verify the create account pagination");
		if(Actionsss.displayElement(lp.getLoginPage())) {
			test.pass("Successfully navigated to Create Account page");
			logger.info("Successfully navigated to Create Account page");
		}else {
			test.pass("Not navigated to Create Account page");
			logger.info("Not navigated to Create Account page");
		}
	}
	
	
	public static void accountPageTitle() {
		
	    String expectedTitle = "Dashboard";

	    // Check if the actual page title matches the expected title
	    if (Actionsss.getTextOfElement(cap.getAccountPageTitle()).equals(expectedTitle)) {
	        test.pass("Account created successfully");
	        logger.info("Account created successfully");
	        isLoggedIn = true;
	    } else {
	        test.fail("The page Title does not match expected Dashboard but found " + Actionsss.getTextOfElement(cap.getAccountPageTitle()));
	        logger.info("Click failed, and account not created");
	    }
	}
	
	public static void validateEmailAndConfirmEmail() {
	   
	    // Check if the "Please enter the same value again" error message is displayed
	    if (Actionsss.displayElement(cap.getSameMailError())) {
	        test.pass("Test case passed. Error message displayed when the same email is not entered: "
	                + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Error message is displayed");
	    } else {
	        test.fail("Test case failed. No error message displayed when the same email is not entered: "
	                + Actionsss.getTextOfElement(cap.getSameMailError()));
	        logger.info("Error message is not displayed");
	    }
	}
	
	public static void validatePasswordMismatch() {	  

	    // Check if the "Does not match password" error message is displayed
	    if (Actionsss.displayElement(cap.getPasswordMismatchError())) {
	        test.pass("Test case passed. Error message displayed as: "
	                + Actionsss.getTextOfElement(cap.getPasswordMismatchError()));
	        logger.info("Showing error message: Does not match password");
	    } else {
	        test.fail("Test case failed. Error message not displayed as: "
	                + Actionsss.getTextOfElement(cap.getPasswordMismatchError()));
	        logger.info("Not showing error message: Does not match password");
	    }
	}


	public static void validateAllErrors() throws InterruptedException {
	   
	    Thread.sleep(2000);
	    // Check if the number of errors matches the expected count (7 errors)
	    if (Actionsss.getSizeOfList(cap.getAllFieldsErrorList()) == 7) {
	        test.pass(Actionsss.getTextOfElement(cap.getAllFieldsError()) + " These errors are displayed when empty text is sent");
	        logger.info("These errors are displayed as " + Actionsss.getTextOfElement(cap.getAllFieldsError()));
	    } else {
	        test.fail(Actionsss.getTextOfElement(cap.getAllFieldsError()) + " These errors are not displayed when empty text is sent");
	        logger.info("These errors are not displayed as " + Actionsss.getTextOfElement(cap.getAllFieldsError()));
	    }
	}
	
	public static void passwordStrengthError() throws InterruptedException {
	   
	    Thread.sleep(2000);

	    // Check if the password strength error is displayed
	    if (Actionsss.displayElement(cap.getpasswordFieldStrength())) {
	        test.pass(Actionsss.getTextOfElement(cap.getpasswordFieldStrength()) + " This error is displayed");
	        logger.info("This error is displayed as " + Actionsss.getTextOfElement(cap.getpasswordFieldStrength()));
	    } else {
	        test.fail(Actionsss.getTextOfElement(cap.getpasswordFieldStrength()) + " This error is not displayed");
	        logger.info("This error is not displayed as " + Actionsss.getTextOfElement(cap.getpasswordFieldStrength()));
	    }
	}
	
	public static void phoneNumber() {
	   

	    // Check if the phone number error is displayed
	    if (Actionsss.displayElement(cap.getphoneNumberError())) {
	        test.pass("Test case passed and Error message is displayed as " + Actionsss.getTextOfElement(cap.getphoneNumberError()));
	        logger.info("Test case passed");
	    } else {
	        test.pass("Test case failed and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getphoneNumberError()));
	        logger.info("Test case failed");
	    }
	}

	public static void alreadyExistsMail() {
	   

	    // Check if the already exists email error is displayed
	    if (Actionsss.displayElement(cap.getalreadyEmailExists())) {
	        test.pass("Test case passed and Error message is displayed as " + Actionsss.getTextOfElement(cap.getalreadyEmailExists()));
	        logger.info("Test case passed");
	    } else {
	        test.pass("Test case failed and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getalreadyEmailExists()));
	        logger.info("Test case failed");
	    }
	}
	public static void emailFormat() {	    
	    logger.info(Actionsss.getTextOfElement(cap.getemailFormatError()));

	    // Check if the email format error is displayed
	    if (Actionsss.displayElement(cap.getemailFormatError())) {
	        test.pass("Test case passed, and Error message is displayed as " + Actionsss.getTextOfElement(cap.getemailFormatError()));
	        logger.info("Test case passed");
	    } else {
	        test.fail("Test case failed, and Error message is not displayed as " + Actionsss.getTextOfElement(cap.getemailFormatError()));
	        logger.info("Test case failed");
	    }
	}

}
