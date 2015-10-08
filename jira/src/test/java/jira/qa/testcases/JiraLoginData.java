package jira.qa.testcases;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import jira.qa.data.Data;
import jira.qa.framework.GlobalConstant;
import jira.qa.framework.JiraLoginPostMethods;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;

public class JiraLoginData extends TestCaseBase {
	
	// test with valid login
	@Test(dataProvider = "validlogindata", dataProviderClass = Data.class, priority=1 )
	public void valid_LoginTest(String username, String password) {
		
			JiraLoginPostMethods login = new JiraLoginPostMethods(username, password);
				
		int statuscode = 
			given()
			.contentType(ContentType.JSON)
			.body(login)
		.when()
			.post(GlobalConstant.SESSION_ENDPOINT)
		.then()
		.extract()
			.statusCode();
		
		//System.out.println("statuscode : " +statuscode);
		Reporter.log("Valid Login data test Statuscode : " +statuscode);	
		
		Assert.assertEquals(statuscode, 200 );
			
		
	  }
 
	// Test with Invalid login
	@Test(dataProvider = "invalidlogindata", dataProviderClass = Data.class, priority=2)
  public void invalid_LoginTest(String username, String password) {
	
		JiraLoginPostMethods login = new JiraLoginPostMethods(username, password);
			
	int statuscode = 
		given()
		.contentType(ContentType.JSON)
		.body(login)
	.when()
		.post(GlobalConstant.SESSION_ENDPOINT)
	.then()
	.extract()
		.statusCode();
	
	//System.out.println("statuscode : " +statuscode);
	Reporter.log("Invalid Login data test Statuscode : " +statuscode);	
	
	Assert.assertNotEquals(statuscode, 200 );
	
		
  }



  
}
