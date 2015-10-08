package jira.qa.framework;

import static com.jayway.restassured.RestAssured.given;
import java.util.List;
import com.jayway.restassured.http.ContentType;

public class JiraLoginPostMethods {
	
	private String username ;
	private String password ;
	

//getters and setters methods
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
// Constructor 	
	public JiraLoginPostMethods(String username, String password){
		this.username = username;
		this.password = password;
			
	}
	
	public JiraLoginPostMethods(){
		
			
	}
	
//login	
	public void setLogin(String username, String password){
			
			JiraLoginPostMethods jiralogin = new JiraLoginPostMethods(username, password);
		
				
		given()
			.contentType(ContentType.JSON)
			.body(jiralogin)
		.when()
			.post("/rest/auth/1/session")
		.then()
			.statusCode(200);
	}
	
	

//Header cookie method
	public String getHeader(String username, String password){
		
		JiraLoginPostMethods jiralogin = new JiraLoginPostMethods(username, password);
	
	List <String >headerlist =	
			
	given()
		.contentType(ContentType.JSON)
		.body(jiralogin)
	.when()
		.post("/rest/auth/1/session")
	.then()
		.statusCode(200)
	.extract()
		.headers()
		.getValues("Set-Cookie");
	
	 String cookie1 = headerlist.get(0);
	 String cookie2 = headerlist.get(1);
	 
	 String headercookie = cookie1+";"+cookie2;
	return headercookie;
	 
	
	}
	


}
