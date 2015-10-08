package jira.qa.testcases;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import jira.qa.framework.GlobalConstant;
import jira.qa.framework.JiraLoginPostMethods;

import org.testng.annotations.Test;

import com.jayway.restassured.http.ContentType;


public class PostJiraLogin extends TestCaseBase {

	@Test
	public void validLogin() {

		JiraLoginPostMethods jiralogin = new JiraLoginPostMethods("mpatelmnl@gmail.com", "P@ssw0rd");

		List cookielist = 
			given()
				.contentType(ContentType.JSON)
				.body(jiralogin)
			.when()
				.post(GlobalConstant.SESSION_ENDPOINT)
			.then().statusCode(200)
				.body("session.name", is("JSESSIONID"))
			.extract()
				.headers()
				.getList("Set-Cookie");

		//System.out.println(cookielist.get(0));

		//System.out.println(cookielist.get(1));

	}
}