package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helpers.Helpers;

public class PageNewSendPackage {
	
	private WebDriver driver;
	private By packageProductTypeCombo;	
	private By packageWeight;
	private By packageLarge;	
	private By packageWidth; 
	private By packageHeight;
	private By packageContentValue;
	private By packageAddButton; 
	
	public PageNewSendPackage(WebDriver driver) {
		this.driver = driver;
		packageProductTypeCombo = By.id("tipo_producto");
		packageWeight = By.id("envio-peso");
		packageLarge = By.id("envio-largo");		
		packageWidth = By.id("envio-ancho");
		packageHeight = By.id("envio-espesor");
		packageContentValue = By.id("envio-valor");
		packageAddButton = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[4]/div[1]/div[9]/div[1]/button[2]");
	}
	

public void loadPackageData(String tipoProducto, String peso, String largo, String ancho, String altura, String valorContenido){
				
		Select selectProvDestino = new Select(driver.findElement(packageProductTypeCombo));
		selectProvDestino.selectByVisibleText(tipoProducto);
		Helpers helper = new Helpers();
		helper.sleepSeconds(1);
		driver.findElement(packageWeight).sendKeys(peso);
		driver.findElement(packageLarge).sendKeys(largo);
		driver.findElement(packageWidth).sendKeys(ancho);
		driver.findElement(packageHeight).sendKeys(altura);
		driver.findElement(packageContentValue).sendKeys(valorContenido);
		helper.sleepSeconds(3);
		driver.findElement(packageAddButton).click();
		helper.sleepSeconds(5);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
	

}
