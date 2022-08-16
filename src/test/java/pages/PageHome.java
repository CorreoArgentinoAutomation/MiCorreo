package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class PageHome {
	private WebDriver driver;
	private By signInButton;
	private By rotuloButton;
	public PageHome (WebDriver driver){
		this.driver = driver;
		//signInButton = By.xpath("//button[@id=\"btnUsuario\"]");
		signInButton = By.xpath("/html/body/div[2]/div/div/ul/span[1]/li[1]/a");
		rotuloButton = By.xpath("//button[contains(text(),'Generar')]");
	}
	
	public void signin() {
	driver.findElement(signInButton).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	public void selectRotulo() {
		driver.findElement(rotuloButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		}
	
}