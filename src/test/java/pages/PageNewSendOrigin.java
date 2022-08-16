package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helpers.Helpers;


public class PageNewSendOrigin {
	private WebDriver driver;
	private By originProvinciaCombo;
	private By originSucursalCombo;
	private By originNextButton;
	private By selectSend;
	private By quoteButton;
		public PageNewSendOrigin (WebDriver driver){
		this.driver = driver;
		originProvinciaCombo = By.id("envio-origen-provincia");
		originSucursalCombo = By.id("envio-origen-sucursal");
		originNextButton = By.id("btn-siguiente-envios");
		selectSend = By.xpath("/html[1]/body[1]/div[2]/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/label[1]");
		quoteButton = By.id("btnpedido");
		}
		/*SOLO SE COMPLETO EL CAMPO DESPLEGABLE PROVINCIA*/
public void loadOriginData(String nameProvincia, String nameSucursal) {
	Select selectProv = new Select(driver.findElement(originProvinciaCombo));
	selectProv.selectByVisibleText(nameProvincia);
	Helpers helper = new Helpers();
	helper.sleepSeconds(1);
	Select selectSuc = new Select(driver.findElement(originSucursalCombo));
	selectSuc.selectByVisibleText(nameSucursal);
	Helpers helper2 = new Helpers();
	helper2.sleepSeconds(1);
	driver.findElement(originNextButton).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}

public void quoteSend() {
	driver.findElement(selectSend).click();
	Helpers helper = new Helpers();
	helper.sleepSeconds(1);
	driver.findElement(quoteButton).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}


}
