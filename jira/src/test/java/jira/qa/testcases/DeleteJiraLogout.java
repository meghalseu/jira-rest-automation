package jira.qa.testcases;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import jira.qa.framework.GlobalConstant;
import jira.qa.framework.JiraLoginPostMethods;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;
public class DeleteJiraLogout extends TestCaseBase{
	
	@Test
	  public void logoutJira() {
			
				
JiraLoginPostMethods jiralogin = new JiraLoginPostMethods("mpatelmnl@gmail.com", "P@ssw0rd");
		
		List<String> headerlist =	
		given()
			.contentType(ContentType.JSON)
			.body(jiralogin)
		.when()
			.post(GlobalConstant.SESSION_ENDPOINT)
		.then()
			.statusCode(200)
			.body("session.name", is("JSESSIONID"))
		.extract()
			.headers()
			.getValues("Set-Cookie");
		
		 String cookie1 = headerlist.get(0);
		 String cookie2 = headerlist.get(1);
		 
		 String headercookie = cookie1+";"+cookie2;
		
		 //System.out.println(headercookie);
		
		 int logoutstatuscode =
		given()
			.header("Cookie", headercookie)
		.when()
			.delete(GlobalConstant.SESSION_ENDPOINT)
		.then()
			.statusCode(204)
		.extract()
				 .statusCode();
		 Reporter.log("Logout Statuscode : " +logoutstatuscode);
			
	}
}
