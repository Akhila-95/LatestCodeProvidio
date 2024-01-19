package browser;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import data.User;
import validations.browserValidation;


public class launchBrowsering extends baseClass{
	
	@Test(groups = {"smoke", "regression"})
	public void verifyHomePageLaunching() throws InterruptedException {
		
		logger.info("this is lauching page");
		//launching the browser and passing the url into it
		 driver.get(baseURL);
		 //test.pass("Entered into url");
		 logger.info("Placing the order as guest user");
		 //validation
		 browserValidation.validateBroweserlaunches(); 
		 
		 User user = new User();
		 user.allFakeData();
	}
	
}
