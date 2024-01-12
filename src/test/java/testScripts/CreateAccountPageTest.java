package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.CreateAccountPageTasks;

public class CreateAccountPageTest extends baseClass{

	

	@Test
	public static void verifyCreateAccountPage() throws Exception {
		CreateAccountPageTasks.createAccPage();
	}
	
	@Test
	public static void verifyCreateAccountWithValidCredentials() throws Exception {
		CreateAccountPageTasks.createAccountWithValidCredientials() ;
	}
	

	@Test
	public static void verifyEmailAndConfirmEmail() throws Exception {
		CreateAccountPageTasks.validateEmailAndConfirmEmail();
	}
	
	@Test
	public static void verifyPasswordMismatch() throws Exception {
		CreateAccountPageTasks.validatePasswordMismatch();
	}
	
	@Test
	public static void verifyemptyText() throws Exception {
		CreateAccountPageTasks.validateEmptyText();
	}
	
	@Test
	public static void verifyPasswordStrength() throws Exception {
		CreateAccountPageTasks.validatePasswordStrength();
	}
	
	@Test
	public static void verifyWithExistingAccount() throws Exception {
		CreateAccountPageTasks.validatingWithExistingAccount();
	}
	

	@Test
	public static void verifyPhoneNumError() throws Exception {
		CreateAccountPageTasks.validatingPhoneNumError();
	}
	
	@Test
	public static void verifyEmailformatError() throws Exception {
		CreateAccountPageTasks.ValidatingEmailformatError();
	}
}
