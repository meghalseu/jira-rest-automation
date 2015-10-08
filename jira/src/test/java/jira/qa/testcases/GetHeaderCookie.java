package jira.qa.testcases;

import jira.qa.framework.JiraLoginPostMethods;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class GetHeaderCookie extends TestCaseBase {
  @Test
  public void header() {
	  
	  JiraLoginPostMethods jiralogin = new JiraLoginPostMethods();
	  
	  String headercookie = jiralogin.getHeader("mpatelmnl@gmail.com", "P@ssw0rd");
	  Reporter.log("Header cookie : " +headercookie);
  }
}
