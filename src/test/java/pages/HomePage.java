package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import driver.WebDriverManager;

public class HomePage{ 
	private WebDriver driver;
	private By userNameField;
	private By passworddield;
	private By signInButton;
	private By regiterButton;
	
	public HomePage(WebDriver driver){
		this.driver =driver;
		userNameField = By.name("userName");
		passworddield = By.name("password");
		signInButton = By.name("login");
		regiterButton = By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]");
	}
	
	public void login(String user,String pass) {
		String username, password;
		username = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[2]/td[1]/font")).getText();
		password = driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[1]/font")).getText();
		//Assert.assertEquals("User Name:", username, "Aca deberia decir = User Name:");
		//Assert.assertEquals("Password:", password, "Aca deberia decir = Password:");
		SoftAssert softAssert= new SoftAssert();
		softAssert.assertEquals("User Name", username, "Aca deberia decir = User Name:");
		softAssert.assertEquals("Password:", password, "Aca deberia decir = Password:");
		driver.findElement(userNameField).sendKeys(user);
		driver.findElement(passworddield).sendKeys(pass);
		driver.findElement(signInButton).click();
	}
	
	public void register() {
		driver.findElement(regiterButton).click();
	}
	
	
}
