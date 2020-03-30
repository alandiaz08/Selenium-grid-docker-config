package driver;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class WebDriverManager {
	protected WebDriver driver;
	public String URL, Node;
	protected ThreadLocal<RemoteWebDriver> threadDriver = null;

	@Parameters("browser")
	@BeforeMethod
	public void launchbrowser(String browser) throws MalformedURLException {
		String URL = "http://newtours.demoaut.com/";

		if (browser.equalsIgnoreCase("firefox")) {
			System.out.println(" Executing on FireFox");
			//String Node = "http://192.168.1.37:5569/wd/hub";
			String Node = "http://172.18.0.3:5555/wd/hub";
			DesiredCapabilities cap = DesiredCapabilities.firefox();
			cap.setBrowserName("firefox");

			driver = new RemoteWebDriver(new URL(Node), cap);
			// Puts an Implicit wait, Will wait for 10 seconds before throwing
			// exception
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.manage().window().maximize();
			driver.navigate().to(URL);
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.out.println(" Executing on CHROME");
			DesiredCapabilities cap = DesiredCapabilities.chrome();
			cap.setBrowserName("chrome");
			//String Node = "http://192.168.1.37:5566/wd/hub";
			String Node = "http://172.18.0.4:5555/wd/hub";
			driver = new RemoteWebDriver(new URL(Node), cap);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			// Launch website
			driver.manage().window().maximize();
			driver.navigate().to(URL);
		} else {
			throw new IllegalArgumentException("The Browser Type is Undefined");
		}
	}
	
	
	
	@AfterMethod
	 public void tearDown(ITestResult result) {
		 System.out.println("El test "+result.getMethod().getDescription()+"(1= Paso satisfactoriamente - 2= No paso satisfactoriamente) resultó: "+result.getStatus());
		 driver.close();
		 driver.quit();
	 }
}
