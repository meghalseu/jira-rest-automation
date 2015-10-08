package jira.qa.testcases;

import jira.qa.framework.GlobalConstant;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.jayway.restassured.RestAssured;



public abstract class TestCaseBase {
	
	
	@BeforeMethod
	public void beforeMethod() {
		
	
		
	RestAssured.baseURI = GlobalConstant.BASE_URI;
	//RestAssured.baseURI = "http://localhost:8080";

	}

	@AfterMethod
	public void afterMethod() {
	
	

	}


}
