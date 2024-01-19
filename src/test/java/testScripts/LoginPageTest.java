package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;
import tasks.LoginPageTasks;

public class LoginPageTest extends baseClass {

	  @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	    public void VerifyingLoginFailureWithIncorrectCredentials()throws Exception {
		  LoginPageTasks.loginFailureWithIncorrectCredentials();
	    }
	  
	  @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	    public void VerifyingLoginFailureWithEmptyEmailAndPassword()throws Exception {
		  LoginPageTasks.loginFailureWithEmptyEmailAndPassword();
	    }

	  @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	    public void VerifyingLoginFailureWithInvalidEmailFormat()throws Exception {
		  LoginPageTasks.loginFailureWithInvalidEmailFormat();
	    }
	  @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	    public void VerifyingLoginFailureWithEmptyEmail()throws Exception {
		  LoginPageTasks.verifyLoginFailureWithEmptyEmail();
	    }
	  
	  @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	    public void VerifyingLoginFailureWithEmptyPassword()throws Exception {
		  LoginPageTasks.loginFailureWithEmptyPassword();
	    }

	  @Test(dependsOnMethods = "browser.launchBrowsering.verifyHomePageLaunching")
	    public void VerifyingLoginWithValidCredentials()throws Exception {
		  LoginPageTasks.verifyThatuserLogin();
	    }
	  
}
