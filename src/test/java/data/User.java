package data;


import java.util.Random;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.providio.testcases.baseClass;

public class User extends baseClass {
	
	Faker faker = new Faker();
	 String randomFirstName="";
	 String randomLastName="";
	 String randomFullName="";
	 String randomFakeEmail="";
	
	 String randomEditedFirstName="";
	 String randomEditedLastName="";
	 String randomEditedFullName="";
	 
	String editedEmail="";
	
	
	//@Test
	public void userFakeFirstName() {		
		 // Generate a fake first name 	
		randomFirstName = faker.name().firstName();      
		fakeFirstName=randomFirstName;
		logger.info(fakeFirstName);
	}
	
	
	public void userFakeLastName() {		
		 // Generate a fake last name 	
		   randomLastName = faker.name().lastName();  
		   fakelastName=randomLastName;
	}
	
	public void userFakeFullName() {		
		 // Generate a fake first name 	
		randomFullName = faker.name().fullName();
		fakeFullName=randomFullName;
		logger.info(fakeFullName);
	}
	
	public void userFakeGmail() {
	
		 // Generate a fake email address		
		randomFakeEmail = faker.name().firstName();
        String email = randomFirstName + "@etg.digital";        
        fakeEmail=email;

	}

	public void allFakeData() {
		userFakeFirstName();
		userFakeLastName() ;
		userFakeGmail() ;		
		userFakeFullName();
		editedEmail();
		
	}
	//@Test
	public void userEditedFirstName() {		
		 // Generate a fake first name 	
		randomEditedFirstName = faker.name().firstName();      
		editedFirstName=randomEditedFirstName;
		logger.info(fakeFirstName);
	}
	
	
	public void userEDitedLastName() {		
		 // Generate a fake last name 	
		randomEditedLastName = faker.name().lastName();  
		editedlastName=randomEditedLastName;
	}
	
	public void userEditedFullName() {		
		 // Generate a fake first name 	
		randomEditedFullName = faker.name().fullName();
		editedFullName=randomEditedFullName;
		logger.info(fakeFullName);
	}
	 
	
	 public  void editedEmail() {
		 // Generate a fake email address				
	        String email = randomFirstName + "Edited@etg.digital";        
	        editedEmail=email;
	        logger.info(editedEmail);
	 }
}
