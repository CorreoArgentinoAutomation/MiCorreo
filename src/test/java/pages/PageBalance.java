package pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PageBalance {private WebDriver driver;
private By balanceLabel;
private By balanceChargeOption;
private By balanceChargeCardOption;
/*private By cargarSaldoAFavor;*/ //PREDETERMINADO, NO MAPEAR AHORA
private By balanceChargeCardValueField;
private By balanceChargeCardPayButton;
private By balanceVisaButton;
private By cardNumberField;
private By securityCardNumberField;
private By expirationMonthField;
private By expirationYearField;
private By titularNameField;
/*private By documentTypeField;*/ //COMBO NO MAPEAR, POR DEFECTO DNI
private By documentNumberField;
private By confirmPayWithCardButton;

public PageBalance (WebDriver driver){
	this.driver = driver;
	balanceLabel = By.xpath("//a[@class='dropdown-toggle altolinea-30']");
	/*balanceChargeOption = By.xpath("//span[@class='blink_me']");*/
	balanceChargeOption = By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[5]/ul/li[2]/a/span");
	/*balanceChargeCardOption = By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[4]/div/label[1]");*/
	balanceChargeCardOption = By.xpath("//body/div[@id='wrapper']/div[@id='myModalGenerico']/div[1]/div[1]/div[2]/div[4]/div[1]/label[1]");
	/*cargarSaldoAFavor = By.id("");*/ //NO MAPEAR
	/*A PARTIR DE ACA, MAPEO DE TARJETA (COLOCAR DESP EN METODO APARTE PARA REUTILIZAR)*/
	balanceChargeCardValueField = By.xpath("//input[@id=\"valorcargaModal\"]");
	/*balanceChargeCardPayButton = By.xpath("/html/body/div[2]/div[2]/div/div/div[2]/div[5]/form/div[3]/div[2]/div/button[2]");*/
	balanceChargeCardPayButton = By.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[5]/form/div[3]/div[2]/div/button[2]");
	balanceVisaButton = By.className("tarjeta-ima");
	cardNumberField = By.id("card_number");
	securityCardNumberField = By.id("security_code");
	expirationMonthField = By.id("card_expiration_month");
	expirationYearField = By.id("card_expiration_year");
	titularNameField = By.id("card_holder_name");
	/*documentTypeField = By.id("");*/ //COMBO POR DEFAUL, NO MAPEAR AHORA
	documentNumberField = By.id("card_holder_doc_number");
	confirmPayWithCardButton = By.id("pagar");
		}
public void cargarSaldo(String valorDeCarga, String numeroTarjeta, String numeroSeguridadTarjeta, String mesVencimiento, String anioVencimiento, String nombreTitulartarjeta, String numeroDocumento) {
	driver.findElement(balanceLabel).click();
	Helpers helper0 = new Helpers();
	helper0.sleepSeconds(1);
	driver.findElement(balanceChargeOption).click();
	Helpers helper1 = new Helpers();
	helper1.sleepSeconds(1);
	driver.findElement(balanceChargeCardOption).click();
	Helpers helper2 = new Helpers();
	helper2.sleepSeconds(1);
	//ACA IRIA LA ACCION SOBRE EL COMBO NO MAPEADO
	driver.findElement(balanceChargeCardValueField).sendKeys(valorDeCarga);
	driver.findElement(balanceChargeCardPayButton).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.findElement(balanceVisaButton).click();
	driver.findElement(cardNumberField).sendKeys(numeroTarjeta);
	driver.findElement(securityCardNumberField).sendKeys(numeroSeguridadTarjeta);		
	driver.findElement(expirationMonthField).sendKeys(mesVencimiento);
	driver.findElement(expirationYearField).sendKeys(anioVencimiento);
	driver.findElement(titularNameField).sendKeys(nombreTitulartarjeta);
	//ACA IRIA FINDELEMENT DEL COMBO TIPO DE DOCUMENTO ELEGIDO POR DEFAULT
	driver.findElement(documentNumberField).sendKeys(numeroDocumento);
	driver.findElement(confirmPayWithCardButton).click();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
}
}


