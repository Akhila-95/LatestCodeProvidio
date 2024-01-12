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
	
    public static void loginFailureWithIncorrectCredentials() throws InterruptedException {
        test.info("Verify with invalid credentials");
        Actionsss.click(homePage.clickOnLogo());
        if(isLoggedIn && isLogOut) {
        	LogOutTasks.verifyLogout();	
        	
        	incorrectCredentials();
        	      	
        }else {
        	incorrectCredentials();
        }
    }
    public static void incorrectCredentials() throws InterruptedException {
    	  // Click the sign-in button
        Actionsss.click(lp.clickSign());
        
        // login page pagination 
        lv.loginPageValidation();
        
        // Enter invalid email and valid password
        Actionsss.sendKeys(lp.getEmail(), "invalid@etg.digital",invalidMail);
        
        Actionsss.sendKeys(lp.getPassword(), "Akhireddy@07", password);
       
        // Click the login button
        Actionsss.click(lp.btnLogin);

        // Validate invalid login scenario       
        lv.invalidLoginError();
    }
    
    public static void loginFailureWithEmptyEmailAndPassword() throws InterruptedException {
    	Thread.sleep(2000);
    	 Actionsss.click(homePage.clickOnLogo());
    	if(isLoggedIn && isLogOut) {
    		LogOutTasks.verifyLogout();
               	
        	emptyEmailAndPassword();
        	
    	}else {
    		emptyEmailAndPassword();
    	}
    }

    public static  void emptyEmailAndPassword() throws InterruptedException{
    	 test.info("Verify login failure with empty email and password");

         // Click the sign-in button
         Actionsss.click(lp.clickSign());

         // login page pagination 
         lv.loginPageValidation();

         // Leave both email and password fields empty
         Actionsss.sendKeys(lp.getEmail(), "",emptyEmail);
        
         Actionsss.sendKeys(lp.getPassword(), "",emptyPassword);
        
         // Click the login button
         Actionsss.click(lp.btnLogin);
         
         // Validate empty email and password login scenario   
         lv.emptyMailAndPwd();
    }
    public static void loginFailureWithInvalidEmailFormat() throws InterruptedException {
    	 Actionsss.click(homePage.clickOnLogo());
    	if(isLoggedIn && isLogOut) {
    		LogOutTasks.verifyLogout();
        	
        	
        	invalidEmailFormat();
    	}else {
    		invalidEmailFormat();
    	}
    }
    
    public static void invalidEmailFormat() throws InterruptedException {
    	 test.info("Verify login failure with invalid email format");

         // Click the sign-in button
         Actionsss.click(lp.clickSign());

         // login page pagination 
         lv.loginPageValidation();
         
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
    	 Actionsss.click(homePage.clickOnLogo());
    	if(isLoggedIn && isLogOut) {
    		LogOutTasks.verifyLogout();
        	
        	
        	emptyEmail();
    	}else {
    		emptyEmail();
    	}      
    }

    	public static void emptyEmail() throws InterruptedException{
    		 test.info("Verify login failure with empty email");

    	        // Click the sign-in button
    	        Actionsss.click(lp.clickSign());

    	        // login page pagination 
    	        lv.loginPageValidation();
    	        
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
    	 Actionsss.click(homePage.clickOnLogo());
    	if(isLoggedIn && isLogOut) {
    		LogOutTasks.verifyLogout();
        	
        	emptyPassword();
    	}else {
    		emptyPassword();
    	}
     
    }
    
    public static void emptyPassword() throws InterruptedException{
    	 test.info("Verify login failure with empty password");
         // Click the sign-in button
         Actionsss.click(lp.clickSign());

         // login page pagination 
         lv.loginPageValidation();

         // Enter a valid email
         Actionsss.sendKeys(lp.getEmail(), "akhila.m@etg.digital",email);
         
         // Provide an empty password
         Actionsss.sendKeys(lp.getPassword(), "",emptyPassword);
        
         // Click the login button
         Actionsss.click(lp.btnLogin);

         // Validate login failure with empty password scenario   
         lv.loginFailureWithEmptyPassword();
    }
    
    //login
    public static void verifyThatuserLogin() throws Exception {
    	 Actionsss.click(homePage.clickOnLogo());
    	test.info("Verify with valid credentials");
    	 
	    // Click on the "Gift Card" link
    	  Actionsss.click(lp.clickSign());
	   
    	 // login page pagination 
          lv.loginPageValidation();

        // Enter valid email and password
        Actionsss.sendKeys(lp.getEmail(), "akhila.m+4@etg.digital",mail);
      
        Actionsss.sendKeys(lp.getPassword(), "Akhireddy@07",password);
       

        // Click the login button
        Actionsss.click(lp.btnLogin);

	    // Verify the result of clicking on the "Gift Card" link
        lv.positiveValidation();
        
       isLoggedIn=true;
	}
    
}
