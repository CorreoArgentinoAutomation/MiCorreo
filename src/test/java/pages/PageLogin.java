package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PageLogin {
	private WebDriver driver;
	private By userField;
	private By passwordField;
	private By loginButton;
	public PageLogin(WebDriver driver){
		this.driver=driver;
		userField = By.xpath("//input[@id=\"email\"]");
		//userField = By.id("email");
		passwordField = By.xpath("//input[@id=\"password\"]");
		loginButton = By.xpath("//button[@type=\"submit\"]");
		}
	
	public void Login(String user, String pass) {
	driver.findElement(userField).sendKeys(user);
	driver.findElement(passwordField).sendKeys(pass);
	driver.findElement(loginButton).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	/*Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-wrapper\"]/div[2]/div[2]/div[1]/i/b")).getText().contains("¡Novedades!"));
	*/} 

}
