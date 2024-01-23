package validations;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.loginPage;

public class LogoutValidation extends baseClass{
	private static final loginPage lp = new loginPage(driver);
	
	public static void verifyingLogout() {
		
		test.info("Verifying the logout");
		if(Actionsss.displayElement(lp.clickSign())) {
			test.pass("Successfully user logged out");
			logger.info("Successfully user logged out");
		}else {
			test.fail("User not logged out");
			logger.info("User not logged out");
		}
	}
}
