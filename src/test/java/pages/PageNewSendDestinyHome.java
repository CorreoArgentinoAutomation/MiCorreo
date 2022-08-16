package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import helpers.Helpers;

public class PageNewSendDestinyHome {
	private WebDriver driver;
	/* private By homeDeliveryOption; */ // NO SE ESTA USA, ESTA SELECCIONADO POR DEFECTO
	private By destinyNameField;
	private By destinyProvinciaCombo;
	private By destinyLocationField;
	private By destinyStreetField;
	private By destinyNumerationField;
	private By destinyFloorField;
	private By destinyDepartmentField;
	private By destinyObservationField;
	private By destinyPostalCodeField;
	private By destinyPhoneCodeField;
	private By destinyPhoneField;
	private By destinyCellCodeField;
	private By destinyCellField;
	private By destinyMailField;
	private By destinyNextButton;

	public PageNewSendDestinyHome(WebDriver driver) {
		this.driver = driver;
		/* homeDeliveryOption = By.xpath("//input[@id='domicilio']"); */
		destinyNameField = By.id("envio-destino-nombre");
		destinyProvinciaCombo = By.id("envio-destino-provincia");
		destinyLocationField = By.id("envio-destino-localidad");
		destinyStreetField = By.id("envio-destino-calle");
		destinyNumerationField = By.id("envio-destino-altura");
		destinyFloorField = By.id("envio-destino-piso");
		destinyDepartmentField = By.id("envio-destino-departamento");
		destinyObservationField = By.id("envio-destino-observaciones");
		destinyPostalCodeField = By.id("envio-destino-cp");
		destinyPhoneCodeField = By.id("envio-destino-cod_area");
		destinyPhoneField = By.id("envio-destino-telefono");
		destinyCellCodeField = By.id("envio-destino-cod_area_celular");
		destinyCellField = By.id("envio-destino-celular");
		destinyMailField = By.id("envio-destino-mail");
		destinyNextButton = By.xpath("//button[@onclick='clicksiguiente(\"#liproducto\")']");
	}

	public void loadDestinyData(String nombreDestino, String nameProvinciaDestino, String localidadDestino,
			String calleDestino, String alturaDestino, String pisoDestino, String deptoDestino, String obsDestino,
			String cpDestino, String codTelDestino, String telDestino, String codMovilDestino, String movilDestino,
			String mailDestino) {
		Helpers helper = new Helpers();
		/* driver.findElement(homeDeliveryOption).click; */ // POR DEFECTO
		driver.findElement(destinyNameField).sendKeys(nombreDestino);
		helper.sleepSeconds(1);
		Select selectProvDestino = new Select(driver.findElement(destinyProvinciaCombo));
		selectProvDestino.selectByVisibleText(nameProvinciaDestino);
		helper.sleepSeconds(1);
		driver.findElement(destinyLocationField).sendKeys(localidadDestino);
		driver.findElement(destinyStreetField).sendKeys(calleDestino);
		driver.findElement(destinyNumerationField).sendKeys(alturaDestino);
		driver.findElement(destinyFloorField).sendKeys(pisoDestino);
		driver.findElement(destinyDepartmentField).sendKeys(deptoDestino);
		driver.findElement(destinyObservationField).sendKeys(obsDestino);
		driver.findElement(destinyPostalCodeField).sendKeys(cpDestino);
		driver.findElement(destinyPhoneCodeField).sendKeys(codTelDestino);
		driver.findElement(destinyPhoneField).sendKeys(telDestino);
		driver.findElement(destinyCellCodeField).sendKeys(codMovilDestino);
		driver.findElement(destinyCellField).sendKeys(movilDestino);
		driver.findElement(destinyMailField).sendKeys(mailDestino);
		driver.findElement(destinyNextButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

}