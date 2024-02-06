package tasks;


import com.providio.testcases.baseClass;

import functionality.Actionsss;
import pageObjects.LogoutPage;
import pageObjects.homepage;
import pageObjects.loginPage;
import validations.LoginValidation;

public class LoginPageTasks extends baseClass {

	private static final loginPage lp = new loginPage(driver);
	private static final String invalidMail="Invalid Email";
	private static final String password="password";
	private static final String emptyEmail="Empty email";
	private static final String emptyPassword="Empty password";
	private static final String invalidEmail="invalid mail";
	private static final String  mail = " user Email";
	private static final  LoginValidation lv = new LoginValidation();
	private static final  LogoutPage lop = new LogoutPage(driver);
	private static homepage homePage = new homepage(driver);
	
	
	
	public static void loginPageView() throws InterruptedException {
			
			if(Actionsss.elementSize(lp.getLoginPageList())) {
				logger.info("Login page already loaded");
			}else {
			//	Actionsss.hover(lop.getHoverMyAccount());
				if(Actionsss.elementSize(lop.getHoverMyAccountList())) {
					
					logger.info("user logged in");
					LogOutTasks.verifyLogout();
					
					if(Actionsss.displayElement(lp.clickSign())) {
						 Actionsss.click(lp.clickSign());
						 // login page pagination 
					        lv.loginPageValidation();
					}
       
				}else {
					logger.info("Login page not loaded");
					 Actionsss.click(lp.clickSign());
					 // login page pagination 
				        lv.loginPageValidation();
				}
			}
		}
    public static void loginFailureWithIncorrectCredentials() throws InterruptedException {
    	loginPageView();
    	
    	 test.info("Verify with invalid credentials");
         // Enter invalid email and valid password
          Actionsss.sendKeys(lp.getEmail(), "invalid@etg.digital",invalidMail);        
          Actionsss.sendKeys(lp.getPassword(), "Akhireddy@07", password);
        
         // Click the login button
          Actionsss.click(lp.btnLogin);

         // Validate invalid login scenario       
          lv.invalidLoginError();
        
    }
  
    
    public static void loginFailureWithEmptyEmailAndPassword() throws Exception {
    	loginPageView();
    	 test.info("Verify login failure with empty email and password");
         
        
         Actionsss.clearText(lp.getEmail());
         Actionsss.clearText(lp.getPassword());
         
         // Click the login button
         Actionsss.click(lp.btnLogin);
         // Validate empty email and password login scenario   
         lv.emptyMailAndPwd();
    }

  
    public static void loginFailureWithInvalidEmailFormat() throws InterruptedException {
    	loginPageView();
    	test.info("Verify login failure with invalid email format");

        
        // Enter an email with an invalid format
        Actionsss.sendKeys(lp.getEmail(), "akhila.metg.digital",invalidEmail);        
        // Provide a valid password
        Actionsss.sendKeys(lp.getPassword(), "Akhireddy@07",password);
        
        // Click the login button
        Actionsss.click(lp.btnLogin);

        // Validate invalid email format login scenario  
        lv.invalidEmailFormat();
    }
    
   
    public static void verifyLoginFailureWithEmptyEmail() throws InterruptedException {
    	
    	 loginPageView();     
    	 test.info("Verify login failure with empty email");

	        // Provide an empty email
	        Actionsss.sendKeys(lp.getEmail(), "",emptyEmail);	      
	        // Enter a valid password
	        Actionsss.sendKeys(lp.getPassword(), "Akhireddy@07",emptyPassword);
	      
	        // Click the login button
	        Actionsss.click(lp.btnLogin);

	        // Validate login failure with empty email scenario       
	        lv.loginFailureWithEmptyEmail();
    }

	
    public static void loginFailureWithEmptyPassword() throws InterruptedException {
    	loginPageView();
    	test.info("Verify login failure with empty password");
        
        // Enter a valid email
        Actionsss.sendKeys(lp.getEmail(), "akhila.m@etg.digital","valid email");        
        // Provide an empty password
        Actionsss.sendKeys(lp.getPassword(), "",emptyPassword);
       
        // Click the login button
        Actionsss.click(lp.btnLogin);

        // Validate login failure with empty password scenario   
        lv.loginFailureWithEmptyPassword();
    }
    
   
    public static void verifyThatuserLogin() throws Exception {
    	loginPageView();
    	test.info("Verify with valid credentials");
    	   // use for brain treee =akhila.m+5@etg.digital
    	//for cybersource= akhila.m+6@etg.digital
        // Enter valid email and password
        Actionsss.sendKeys(lp.getEmail(), "akhila.m+6@etg.digital",mail);      
        Actionsss.sendKeys(lp.getPassword(), "Testing@123",password);      
        Thread.sleep(4000);     // Click the login button
        Actionsss.click(lp.btnLogin);

	    // Verify the result of clicking on the "Gift Card" link
        lv.positiveValidation();
        
        isLoggedIn=true;
    }

}
