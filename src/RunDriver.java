
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

// Main class to run code written , need to check console for verification 
public class RunDriver extends DriverHelper
{
  public static List<WebElement> list;
  public static List<String> homePageElements = new ArrayList<String>();
  public static List<String> linkscheck = new ArrayList<String>();
  public static List<String> pageurls = new ArrayList<String>();
  public static List<String> Expectedpageurls = new ArrayList<String>();
  
  public RunDriver() throws InterruptedException 
  {

	System.out.println(System.getProperty("user.dir"));
	DriverHelper.CallDriver();
  }
   public static void main(String args[]) throws InterruptedException {
	

	// TODO Auto-generated method stub
    RunDriver r =new RunDriver();
    homePageElements.add("searchPositionTextBox");
    homePageElements.add("searchLocationTextBox");
    homePageElements.add("searchdistanceDrpDwn");
    homePageElements.add("searchButton");

    linkscheck.add(getOrderProperty("homelink"));
    linkscheck.add(getOrderProperty("findJobLink"));
    linkscheck.add(getOrderProperty("JobAlertLink"));
    linkscheck.add(getOrderProperty("SearchLink"));
    linkscheck.add(getOrderProperty("JobBlogLink"));
    
    Expectedpageurls.add(getOrderProperty("homelinkURL"));
    Expectedpageurls.add(getOrderProperty("findJobLinkURL"));
    Expectedpageurls.add(getOrderProperty("JobAlertLinkURL"));
    Expectedpageurls.add(getOrderProperty("SearchLinkURL"));
    Expectedpageurls.add(getOrderProperty("JobBlogLinkURL"));
   try { 
    for(int i=0; i<homePageElements.size();i++)
    {
    	getElementbyxpath_onwait(homePageElements.get(i));
    	System.out.println("Element Verified: " + homePageElements.get(i) );
    }
    for(int j=0; j<linkscheck.size();j++)
    { 
    	System.out.println(j);
    	Thread.sleep(1000);
        driver.findElement(By.linkText(linkscheck.get(j))).click();
        Thread.sleep(1000);
        pageurls.add(driver.getCurrentUrl());
        System.out.println(driver.getCurrentUrl());
    }
    for(int link =0; link<pageurls.size(); link++) 
    {
    	if(pageurls.get(link).contentEquals(Expectedpageurls.get(link))) 
    	{
    		System.out.println("PageURL: " + pageurls.get(link) + "verified successfully");
    	}
    }
    System.out.println("Getting The Job Tittle search by Keyword >> Analyst");
    driver.findElement(By.linkText(linkscheck.get(0))).click();
    getElementXpath("searchPositionTextBox").sendKeys("Analyst");
    getElementXpath("searchButton").click();
    list = getGridElements_fromXpath("jobListheader");
    for(int ele=0; ele<list.size();ele++)
    {
    	System.out.println("Job Tittle found is : " + list.get(ele).getText());
    }
    
    driver.close();
   }
   catch(Exception e){ 
	   driver.close();
   }
    
   }
   
}