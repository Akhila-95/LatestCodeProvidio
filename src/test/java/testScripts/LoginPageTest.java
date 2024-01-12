package testScripts;

import org.testng.annotations.Test;
import com.providio.testcases.baseClass;
import tasks.LoginPageTasks;

public class LoginPageTest extends baseClass {

	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithIncorrectCredentials()throws Exception {
		  LoginPageTasks.loginFailureWithIncorrectCredentials();
	    }
	  
	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithEmptyEmailAndPassword()throws Exception {
		  LoginPageTasks.loginFailureWithEmptyEmailAndPassword();
	    }

	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithInvalidEmailFormat()throws Exception {
		  LoginPageTasks.loginFailureWithInvalidEmailFormat();
	    }
	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithEmptyEmail()throws Exception {
		  LoginPageTasks.verifyLoginFailureWithEmptyEmail();
	    }
	  
	  @Test(groups = {"regression"})
	    public void VerifyingLoginFailureWithEmptyPassword()throws Exception {
		  LoginPageTasks.loginFailureWithEmptyPassword();
	    }

	  @Test(groups = {"regression"})
	    public void VerifyingLoginWithValidCredentials()throws Exception {
		  LoginPageTasks.verifyThatuserLogin();
	    }
	  
}
