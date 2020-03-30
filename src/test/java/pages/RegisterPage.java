package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driver.WebDriverManager;

public class RegisterPage{
	
	private WebDriver driver;
	private By firstNameField ;
	private By lastNameField ;
	private By phoneField;
	private By emailField ;
	private By addressField ;
	private By cityField ;
	private By stateProvinceField ;
	private By postalCodeField ;
	private By countrySelector ;
	private By userNameField ;
	private By passwordField ;
	private By confirmPasswordField ;
	private By submitButton ;
	
	public RegisterPage (WebDriver driver) {
		
		this.driver = driver;
		firstNameField =By.name("firstName");
		lastNameField = By.name("lastName");
		phoneField=By.name("phone");
		emailField=By.name("userName");
		addressField=By.name("address1");
		cityField=By.name("city");
		stateProvinceField=By.name("state");
		postalCodeField=By.name("postalCode");
		countrySelector=By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select");
		userNameField=By.name("email");
		passwordField=By.name("password");
		confirmPasswordField=By.name("confirmPassword");
		submitButton=By.name("register");
		
		
		
	}
	
	public void Register (String firstName,String lastName,String phone,String email,String adrress,String city,String state,String postalCode,String userName,String password,String confirmPassword, String country) {
		WebDriverWait wait = new WebDriverWait(driver,10);// una espera explcita de 10 segundos 
		wait.until(ExpectedConditions.presenceOfElementLocated(submitButton));
		
		driver.findElement(firstNameField).sendKeys(firstName);
		driver.findElement(lastNameField).sendKeys(lastName);
		driver.findElement(phoneField).sendKeys(phone);
		driver.findElement(emailField).sendKeys(email);
		driver.findElement(addressField).sendKeys(adrress);
		driver.findElement(cityField).sendKeys(city);
		driver.findElement(stateProvinceField).sendKeys(state);
		driver.findElement(postalCodeField).sendKeys(postalCode);
		driver.findElement(countrySelector).click();
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[12]/td[2]/select/option["+country+"]")).click();
		
		driver.findElement(userNameField).sendKeys(userName);
		driver.findElement(passwordField).sendKeys(password);
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
		
		//driver.findElement(submitButton).click();
	
	}
}

