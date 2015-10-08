package jira.qa.data;

import org.testng.annotations.DataProvider;

public class Data {
 
	
//Valid Login data	
  @DataProvider (name = "validlogindata")
  public static Object[][] dp() {
    return new Object[][] {
    		
      new Object[] { "mpatelmnl@gmail.com", "P@ssw0rd" },
      new Object[] { "MPATELMNL@gmail.com", "P@ssw0rd" },
      new Object[] { "mpatelmnl@gmail.com", "P@ssw0rd" },
    };
  }
  
  
  // Invalid Login data
	@DataProvider (name = "invalidlogindata")
	  public static Object[][] invalid() {
	    return new Object[][] {
	    		
  			new Object [] { "mpatel.mnl@gmail.com", "P@ssw0rd"},
  			new Object [] { "mpatelmnl@gmail.com", "invalidpass"},
  			new Object [] { "mpatelmnl", "P@ssw0rd" },
  			//new Object [] {"invalidemail.com", "invalidpass" }, Jira locks and sends capacha if trying to login many times with wrong pass
  			//new Object [] {"", "P@ssw0rd" },
  			//new Object [] {"", "" },
  			//new Object [] {"mpatelmnl@gmail.com", "" },
  			//new Object [] {"mpatelmnl@gmail.com", "p@ssw0rd" },
	    	
	    };
	    
	  }
}
