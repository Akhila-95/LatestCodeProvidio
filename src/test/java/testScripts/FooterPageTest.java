package testScripts;

import org.testng.annotations.Test;

import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.FooterPage;
import tasks.FooterPageTasks;

public class FooterPageTest extends baseClass{
	
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyingResourceFooterLinks() throws Exception {
		FooterPageTasks.resourceFooterLinks();
	}
	
	//@Test(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyingValidEmailInSighUpBoxInFooter() throws Exception {
		
		 FooterPageTasks.validEmailInSignUpBoxInFooter();
	}
	
	//@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyingWithoutEnteringEmailInSignupBoxInFooter() throws Exception {
		
		 FooterPageTasks.withoutEnteringEmailInSignupBoxInFooter();
	}
	
	@Test//(dependsOnMethods ="browser.launchBrowsering.verifyHomePageLaunching" )	
	public static void verifyinginvalidEmailInEmailSignUpBox()  throws Exception {
		 
		 FooterPageTasks.invalidEmailInEmailSignUpBox();
	}
	
	
}
