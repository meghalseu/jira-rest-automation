package jira.qa.testcases;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

import java.util.List;

import jira.qa.framework.GlobalConstant;
import jira.qa.framework.JiraLoginPostMethods;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;



public class GetSessionIngo extends TestCaseBase {
 
	@Test	
	public void sessionInfo(){
				
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
			
		//System.out.println(headerlist);
		//System.out.println(headerlist.size());
		
		
		 String cookie1 = headerlist.get(0);
		 String cookie2 = headerlist.get(1);
		 
		 String headercookie = cookie1+";"+cookie2;
		 
		 //System.out.println("Cookie1: " +cookie1);
		 //System.out.println("Cookie1: " +cookie2);
		 
		 Reporter.log("Header cookie : "+ headercookie);
		 //System.out.println(headercookie);
		
		 String responsebody = 
		given()
			.header("Cookie", headercookie)
		.when()
			.get(GlobalConstant.SESSION_ENDPOINT)
		.then()
			.statusCode(200)
			.body("name", is(jiralogin.getUsername()))
		.extract()
			//.path("loginInfo.loginCount")
		.response().getBody().asString();
		 
		 Reporter.log("Session info body contents : "+responsebody);
		
			
	}
	
}