package test;

import org.testng.annotations.Test;
import driver.WebDriverManager;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterTest extends WebDriverManager  {

    @Test(testName ="Test_Register", description="Caso de prueba de Registrar usuario")
    public void test() {
    	HomePage home = new HomePage(driver);
    	home.register();
        RegisterPage register = new RegisterPage(driver); 
        register.Register("Alan", "Diaz", "123123123", "alan@mail.com", "Formosa 30", "Buenos Aires", "Buenos Aires", "1424", "alanred", "12345", "12345", "8");

    }
    
}