package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import tasks.CreateAccountPageTasks;

public class CreateAccountPageTest extends baseClass{

	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyCreateAccountWithValidCredentials() throws Exception {
		CreateAccountPageTasks.createAccountWithValidCredientials() ;
	}
	

	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyEmailAndConfirmEmail() throws Exception {
		CreateAccountPageTasks.validateEmailAndConfirmEmail();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyPasswordMismatch() throws Exception {
		CreateAccountPageTasks.validatePasswordMismatch();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyemptyText() throws Exception {
		CreateAccountPageTasks.validateEmptyText();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyPasswordStrength() throws Exception {
		CreateAccountPageTasks.validatePasswordStrength();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyWithExistingAccount() throws Exception {
		CreateAccountPageTasks.validatingWithExistingAccount();
	}
	

	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyPhoneNumError() throws Exception {
		CreateAccountPageTasks.validatingPhoneNumError();
	}
	
	@Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	public static void verifyEmailformatError() throws Exception {
		CreateAccountPageTasks.ValidatingEmailformatError();
	}
}
