package pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import helpers.Helpers;

public class PageNewRotulo {
	private WebDriver driver;
	/*FORMULARIO ORIGEN*/
	private By originNameRotulo;
	private By originProvinciaComboRotulo;
	private By originLocalidadRotulo;
	private By originCalleRotulo;
	private By originAlturaRotulo;
	private By originPisoRotulo;
	private By originDeptoRotulo;
	private By originCPRotulo;
	private By originSucursalComboRotulo;
	private By originSiguienteBtnRotulo;
	/*FORMULARIO DESTINO - ENTREGA EN DOMICILIO*/
	private By destinyNameRotulo;
	private By destinyProvinciaComboRotulo;
	private By destinyLocalidadRotulo;
	private By destinyCalleRotulo;
	private By destinyAlturaRotulo;
	private By destinyPisoRotulo;
	private By destinyDeptoRotulo;
	private By destinyCPRotulo;
	private By destinyObsRotulo;
	//private By destintySiguienteBtnRotulo;
	/*FORMULARIO DESTINO - ENTREGA EN SUCURSAL*/
	private By destinySucursalOption; /*RADIO BTN OPCION SUCURSAL*/
	/*---REPETIDOS ANTERIORMENTE
	 * private By destinyNameRotulo;
	private By destinyProvinciaComboRotulo;*/
	private By destinySucursalComboRotulo;
	/*FORMULARIO PAQUETE*/
	private By packagePesoRotulo;
	private By addRotulo;
	private By downloadRotulo;
	 

public PageNewRotulo (WebDriver driver){
	this.driver = driver;
	/*FORMULARIO ORIGEN*/
	originNameRotulo = By.id("nombre_origen");
	originProvinciaComboRotulo = By.id("provincia_origen");
	originLocalidadRotulo = By.id("localidad_origen");
	originCalleRotulo = By.id("calle_origen");
	originAlturaRotulo = By.id("altura_origen");
	originPisoRotulo = By.id("piso_origen");
	originDeptoRotulo = By.id("departamento_origen");
	originCPRotulo = By.id("cp_origen");
	originSucursalComboRotulo = By.id("sucursal_origen");
	originSiguienteBtnRotulo = By.id("btn-siguiente-envios");
	 /*FORMULARIO DESTINO - ENTREGA EN DOMICILIO*/
	destinyNameRotulo = By.id("nombre_destino");
	destinyProvinciaComboRotulo = By.id("provincia_destino");
	destinyLocalidadRotulo = By.id("localidad_destino");
	destinyCalleRotulo = By.id("calle_destino");
	destinyAlturaRotulo = By.id("altura_destino");
	destinyPisoRotulo = By.id("piso_destino");
	destinyDeptoRotulo = By.id("departamento_destino");
	destinyCPRotulo	 = By.id("cp_destino");
	destinyObsRotulo = By.id("observaciones_destino");
	//destintySiguienteBtnRotulo = By.xpath("//textarea[@id='observaciones_destino']//following::button[2]");
	 /*FORMULARIO DESTINO - ENTREGA EN SUCURSAL*/	 
	destinySucursalOption = By.id("sucursal"); /*RADIO BTN OPCION SUCURSAL*/
	destinyNameRotulo = By.id("nombre_destino");
	destinyProvinciaComboRotulo = By.id("provincia_destino");
	destinySucursalComboRotulo = By.id("sucursal_destino");
	//destintySiguienteBtnRotulo = By.id("//*[@id=\"panel2\"]/div/div/div/div[4]/div/button[2]");
	/*FORMULARIO PAQUETE*/	
	packagePesoRotulo = By.id("envio-peso");
	addRotulo = By.id("btnagregar");
	/*--SE VISUALIZA RÓTULO, AGREGAR ESPERA--*/
	downloadRotulo = By.xpath("//button[@title='Puede descargar el rotulo creado']");
	 
	}

public void addRotuloDomicilioOrigen(String nombreApellidoRazonOrigen, String nameProvinciaOrigenRotulo, String localidadOrigenRotulo, String calleOrigenRotulo, String alturaOrigenRotulo, String pisoOrigenRotulo, String deptoOrigenRotulo, String cpOrigenRotulo, String sucursalOrigenRotulo)
{
	Helpers helper = new Helpers();
	driver.findElement(originNameRotulo).sendKeys(nombreApellidoRazonOrigen);
	
	/*COMBO PROVINCIA - ORIGEN*/
	Select selectProvOrigenRotulo = new Select(driver.findElement(originProvinciaComboRotulo));
	selectProvOrigenRotulo.selectByVisibleText(nameProvinciaOrigenRotulo);
	helper.sleepSeconds(1);
	
	driver.findElement(originLocalidadRotulo).sendKeys(localidadOrigenRotulo);
	driver.findElement(originCalleRotulo).sendKeys(calleOrigenRotulo);
	driver.findElement(originAlturaRotulo).sendKeys(alturaOrigenRotulo);
	driver.findElement(originPisoRotulo).sendKeys(pisoOrigenRotulo);
	driver.findElement(originDeptoRotulo).sendKeys(deptoOrigenRotulo);
	driver.findElement(originCPRotulo).sendKeys(cpOrigenRotulo);
	
	/*COMBO SUCURSAL*/
	Select selectSucOrigenRotulo = new Select(driver.findElement(originSucursalComboRotulo));
	selectSucOrigenRotulo.selectByVisibleText(sucursalOrigenRotulo);
	helper.sleepSeconds(1);
	
	driver.findElement(originSiguienteBtnRotulo).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

public void addRotuloDomicilioDestino(String nombreApellidoRazonDestino, String nameProvinciaDestinoRotulo, String localidadDestinoRotulo, String calleDestinoRotulo , String alturaDestinoRotulo, String pisoDestinoRotulo, String deptoDestinoRotulo, String cpDestinoRotulo, String obsDestinoRotulo)
{
	Helpers helper = new Helpers();
	driver.findElement(destinyNameRotulo).sendKeys(nombreApellidoRazonDestino);
	
	/*COMBO PROVINCIA - DESTINO*/
	Select selectProvDestinoRotulo = new Select(driver.findElement(destinyProvinciaComboRotulo));
	selectProvDestinoRotulo.selectByVisibleText(nameProvinciaDestinoRotulo);
	helper.sleepSeconds(1);
	
	driver.findElement(destinyLocalidadRotulo).sendKeys(localidadDestinoRotulo);
	driver.findElement(destinyCalleRotulo).sendKeys(calleDestinoRotulo);
	driver.findElement(destinyAlturaRotulo).sendKeys(alturaDestinoRotulo);
	driver.findElement(destinyPisoRotulo).sendKeys(pisoDestinoRotulo);
	driver.findElement(destinyDeptoRotulo).sendKeys(deptoDestinoRotulo);
	driver.findElement(destinyCPRotulo).sendKeys(cpDestinoRotulo);
	driver.findElement(destinyObsRotulo).sendKeys(obsDestinoRotulo);
	helper.sleepSeconds(1);
	
	List<WebElement> buttons = driver.findElements(By.xpath("//button[@class=\"btn btn-primary boton-siguiente btn-siguiente-envios\"]"));
	buttons.get(1).click(); //LISTA BOTONES Y LE DA AL POSICIÓN 2
	/*driver.findElement(destintySiguienteBtnRotulo).click();*/
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
	
	public void addRotuloDomicilioPaquete(String pesoPaquete) {
	driver.findElement(packagePesoRotulo).sendKeys(pesoPaquete);
	driver.findElement(addRotulo).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(downloadRotulo).click();
	
	}

	public void addRotuloSucursalDestino(String nombreApellidoRazonDestinoSucursal, String nameProvinciaDestinoSucRotulo, String sucursalDestinoRotulo) {
	Helpers helper = new Helpers();
	driver.findElement(destinySucursalOption).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(destinyNameRotulo).sendKeys(nombreApellidoRazonDestinoSucursal);
	/*COMBO PROVINCIA - DESTINO SUCURSAL*/
	Select selectProvDestinoRotulo = new Select(driver.findElement(destinyProvinciaComboRotulo));
	selectProvDestinoRotulo.selectByVisibleText(nameProvinciaDestinoSucRotulo);
	helper.sleepSeconds(3);
	/*COMBO SUCURSAL - DESTINO SUCURSAL*/
	Select selectSucDestinoRotulo = new Select(driver.findElement(destinySucursalComboRotulo));
	selectSucDestinoRotulo.selectByVisibleText(sucursalDestinoRotulo);
	helper.sleepSeconds(3);
	
	List<WebElement> buttons = driver.findElements(By.xpath("//button[@class=\"btn btn-primary boton-siguiente btn-siguiente-envios\"]"));
	buttons.get(1).click(); //LISTA BOTONES Y LE DA AL POSICIÓN 2
	/*driver.findElement(destintySiguienteBtnRotulo).click();*/
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}	
	
	public void addRotuloSPaquete(String pesoPaquete) {
	driver.findElement(packagePesoRotulo).sendKeys(pesoPaquete);
	driver.findElement(addRotulo).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	
	driver.findElement(downloadRotulo).click();
	
	
	}
	
	}


