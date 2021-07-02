import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//  This driver helper class is used for reusable driver methods which are customized as per requirement .
// this also reduce the code width in the classes which are using these methods by short names 
//Example- Below code has been converted into this < half line method name -->  <getElementbyxpath_onwait()>
//            WebElement we=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getOrderProperty(locator))));
// ** chrome driver used is version 91 and 
//     same version of chrome browser is expected to be installed
public class DriverHelper {
	static By by;
	public static WebDriver driver;
	public static WebDriverWait wait;
    public static List<WebElement> wes;
public static String getOrderProperty(String property){
		
		String value="";
		try{
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream("OrderData.properties");
		pro.load(fis);
		value=	pro.getProperty(property);
		fis.close();
		}
		catch(FileNotFoundException e){
		}
		catch(IOException e){
			
		}
		return value;
	}
public static WebElement getElementXpath(String locator){

	WebElement we = null;
    
	by=	elementByXpath(getOrderProperty(locator));

	try{
		we=driver.findElement(by);
	}
	catch(InvalidSelectorException e){

	}
	catch(NoSuchElementException e){

	}

	catch(WebDriverException e){

	}
	finally{

	}

	return we;
}

public static List<WebElement> getGridElements_fromXpath(String locator){

	wes = null;
    
	by=	elementByXpath(getOrderProperty(locator));

	try{
		wes=driver.findElements(by);
	}
	catch(InvalidSelectorException e){

	}
	catch(NoSuchElementException e){

	}

	catch(WebDriverException e){

	}
	finally{

	}

	return wes;
}

public static By elementByXpath(String xpath){

	By by=By.xpath(xpath);

	return by;

}
public static WebElement getElementbyxpath_onwait(String locator)
	{
     	WebDriverWait wait = new WebDriverWait(driver, 10); 
     	WebElement we=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(getOrderProperty(locator))));
	    return we;
	}
public static void CallDriver() throws InterruptedException
	{
	  System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe"); 
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.navigate().to(getOrderProperty("loginPageUrl"));
	}
public static void scrollToptoBottom(String displacement)
	{
	  JavascriptExecutor jse = (JavascriptExecutor)driver;
	  jse.executeScript("window.scrollBy(0,"+displacement+")", "");
	}

}





