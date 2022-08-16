package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helpers.Helpers;

public class PageNewSendDestinySucursal {
	private WebDriver driver;
	private By sucursalDeliveryOption;
	private By destinyNameField;
	private By destinyProvinciaCombo;
	private By destinyPhoneCodeField;
	private By destinyPhoneField;
	private By destinyCellCodeField;
	private By destinyCellField;
	private By destinyMailField;
	private By destinyNextButton;
	private By destinySucursalCombo;

	public PageNewSendDestinySucursal(WebDriver driver) {
		this.driver = driver;
		sucursalDeliveryOption = By.id("sucursal");
		destinyNameField = By.id("envio-destino-nombre");
		destinyProvinciaCombo = By.id("envio-destino-provincia");
		destinyPhoneCodeField = By.id("envio-destino-cod_area");
		destinyPhoneField = By.id("envio-destino-telefono");
		destinyCellCodeField = By.id("envio-destino-cod_area_celular");
		destinyCellField = By.id("envio-destino-celular");
		destinyMailField = By.id("envio-destino-mail");
		destinySucursalCombo = By.id("envio-destino-sucursal");
		destinyNextButton = By.xpath("//button[@onclick='clicksiguiente(\"#liproducto\")']");
	}

	public void loadDestinyDataSucursal(String nombreDestino, String nameProvinciaDestino, String nameSucursalDestino,
			String codTelDestino, String telDestino, String codMovilDestino, String movilDestino, String mailDestino) {
		Helpers helper = new Helpers();
		driver.findElement(sucursalDeliveryOption).click();
		driver.findElement(destinyNameField).sendKeys(nombreDestino);
		Select selectProvDestino = new Select(driver.findElement(destinyProvinciaCombo));
		selectProvDestino.selectByVisibleText(nameProvinciaDestino);
		helper.sleepSeconds(1);
		Select selectSucursalDestino = new Select(driver.findElement(destinySucursalCombo));
		selectSucursalDestino.selectByVisibleText(nameSucursalDestino);
		helper.sleepSeconds(1);
		driver.findElement(destinyPhoneCodeField).sendKeys(codTelDestino);
		driver.findElement(destinyPhoneField).sendKeys(telDestino);
		driver.findElement(destinyCellCodeField).sendKeys(codMovilDestino);
		driver.findElement(destinyCellField).sendKeys(movilDestino);
		driver.findElement(destinyMailField).sendKeys(mailDestino);
		driver.findElement(destinyNextButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}