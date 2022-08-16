package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import helpers.Helpers;

public class PageWelcome {
	private WebDriver driver;
	//NUEVO ENVIO
	private By accessButton;
	private By sendPackageOption;
	private By newSendOption;
	//private By profileButton;
	/*private By logOutButton;*/
	//SALDO
	private By balanceLabel;
	private By balanceChargeOption; //SELEC. RECARGA DE SALDO
	//MOVIMIENTOS
	private By movementsOption;  //SELEC. VER MOVIMIENTOS
	
	//----DESDE ACA EL CODIGO DE EZEQUIEL PARA MAPEO DE ELEMENTOS	
	
	private By nextBtnn = By.xpath("//button[@id='btn-siguiente-envios']");
	private By nameBtnn = By.xpath("//input[@id='envio-destino-nombre']");
	private By provinciaBtnn = By.xpath("//select[@id='envio-destino-provincia']");
	private By optionB = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[2]/div[1]/select[1]/option[3]");
	private By localidad = By.xpath("//input[@id='envio-destino-localidad']");
	private By calle = By.xpath("//input[@id='envio-destino-calle']");
	private By altura = By.xpath("//input[@id='envio-destino-altura']");
	private By postalCode = By.xpath("//input[@id='envio-destino-cp']");
	private By mailBox = By.xpath("//input[@id='envio-destino-mail']");
	private By nextBtnn2 = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[4]/div[1]/button[2]");
	private By productType = By.xpath("//select[@id='tipo_producto']");
	private By optionClasic = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[2]/div[1]/div[2]/form[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/select[1]/option[2]");
	private By weight = By.xpath("//input[@id='envio-peso']"); 
	private By large = By.xpath("//input[@id='envio-largo']");
	private By width = By.xpath("//input[@id='envio-ancho']");
	private By height = By.xpath("//input[@id='envio-espesor']");
	private By price = By.xpath("//input[@id='envio-valor']");
	private By addBtn = By.xpath("//button[@id='btnagregar']");
	private By panel = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[1]/a[1]");
	//COTIZADO
	private By labelBtn = By.xpath("//thead/tr[1]/td[1]/div[1]/label[1]");
	private By quoteBtn = By.xpath("//button[@id='btnpedido']");
	private By balance = By.xpath("//input[@id='radioSaldo']"); 
	private By payBtn = By.xpath("//body/div[@id='page-wrapper']/div[2]/form[1]/div[1]/div[3]/div[1]/div[2]/button[3]"); 
	private By payBtn2 = By.xpath("//button[@id='pagar']"); 
	//ROTULADO
	private By myShipmentsBtns = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[3]/a[1]0"); 
	private By shipingManagementBtn = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[3]/ul[1]/li[2]/a[1]/font[1]/font[1]");
	private By labelBtn2 = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]/label[1]"); 
	private By generateLabelBtn = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/button[1]");
	//CREACION CUENTA HIJA
	private By userBtn = By.xpath("//li[@id='liusuariolink']"); 
	private By addUserBtn = By.xpath("/html[1]/body[1]/div[1]/nav[1]/div[2]/div[2]/ul[1]/li[6]/ul[1]/li[2]"); 
	private Select rolBtn;
	private By nombreBtn2 = By.xpath("//input[@id='nombre']");
	private By apellidoBtn2 = By.xpath("//input[@id='apellido']");
	private By emailBtn2 = By.xpath("//input[@id='email']");
	private By saveUser = By.xpath("//body/div[@id='page-wrapper']/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[4]/div[1]/button[1]"); 
	//TOMA DE CONTROL DE ENVIOS EN CUENTA PADRE 
	private By sendUsersBtn = By.xpath("//a[contains(text(),'Envíos de usuarios')]");
	private By labelBtn3 = By.xpath("//thead/tr[1]/th[1]/label[1]"); 
	private By takeControlBtn = By.xpath("//button[contains(text(),'Tomar control de los seleccionados')]");
	private By aceptarBtn = By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/button");
	private By myShipmentsBtns2 = By.xpath("//body/div[@id='wrapper']/nav[1]/div[2]/div[2]/ul[1]/li[3]/a[1]"); 

// HASTA ACA EL CODIGO DE EZEQUIEL PARA MAPEO DE ELEMENTOS


	
	public PageWelcome(WebDriver driver) {
		this.driver = driver;
		//NUEVO ENVIO
		accessButton = By.id("lidashboardlink");
		sendPackageOption = By.className("dropdown-toggle");
		newSendOption = By.linkText("Nuevo envío");
		//SALDO
		balanceLabel = By.xpath("//a[@class='dropdown-toggle altolinea-30']");
		balanceChargeOption = By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[5]/ul/li[2]/a/span");
		//MOVIMIENTOS
		movementsOption= By.xpath("//*[@id=\"lisaldolink\"]/ul/li[3]/a/span");
		//LOGOUT
		/*profileButton=By.id("liusuariolink");*/
		//profileButton=By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[6]/a");
		//SE DESACTIVA EL BOTON LOGOFF PARA REDIRECCIONAR A UNA URL QUE DESLOGUEA
		/*logOutButton = By.xpath("//*[@id=\"ul-menu-usuario\"]/li[8]/a");*/
	}
	

	public void selectUserPanel() {
		driver.findElement(accessButton).click();
		Helpers helper = new Helpers();
		helper.sleepSeconds(1);
	}

	public void newSend() {
		Helpers helper = new Helpers();
		driver.findElement(sendPackageOption).click();
		helper.sleepSeconds(2);
		driver.findElement(newSendOption).click();
	}
	
	public void balanceChargePanel() {
		Helpers helper = new Helpers();
		driver.findElement(balanceLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(balanceChargeOption).click();
		helper.sleepSeconds(1);
	}
	
	public void selectUserMovements() {
		Helpers helper = new Helpers();
		driver.findElement(balanceLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(movementsOption).click();
		helper.sleepSeconds(1);	
	}
		
	
	public void logOut() {
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);
		/*driver.findElement(profileButton).click();
		helper.sleepSeconds(3);*/ //DESACTIVO EL MENU ASI CIERRA REDIRIGIENDO NOMÁS
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/logout");
		helper.sleepSeconds(2);
		driver.close();
	}
	
	//DESDE ACA EL CODIGO DE EZEQUIEL PARA METODOS
	
public void newShipment() throws InterruptedException { 
		
		//NUEVO ENVIO 1 
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		Thread.sleep(5000);
	}
	public void newShipment2() throws InterruptedException {
		//NUEVO ENVIO 2 
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
		Thread.sleep(5000);
	}
	public void newShipment3() throws InterruptedException {
		//NUEVO ENVIO 3 
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
		Thread.sleep(5000);
	}
	public void newShipment4() throws InterruptedException {
		//NUEVO ENVIO 4
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
		Thread.sleep(5000);
	}
	public void newShipment5() throws InterruptedException {
		//NUEVO ENVIO 5
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
		driver.findElement(nextBtnn).click();
		driver.findElement(nameBtnn).sendKeys("envio2");
		driver.findElement(provinciaBtnn).click();
		driver.findElement(optionB).click();
		driver.findElement(localidad).sendKeys("Flores");
		driver.findElement(calle).sendKeys("Av Rivadavia");
		driver.findElement(altura).sendKeys("6200");
		driver.findElement(postalCode).sendKeys("1406");
		driver.findElement(mailBox).sendKeys("ezequiel_emp@yopmail.com");
		driver.findElement(nextBtnn2).click();
		driver.findElement(productType).click();
		driver.findElement(optionClasic).click();
		driver.findElement(weight).sendKeys("10");
		driver.findElement(large).sendKeys("10");
		driver.findElement(width).sendKeys("10");
		driver.findElement(height).sendKeys("10");
		driver.findElement(price).sendKeys("100");
		driver.findElement(addBtn).click();
		driver.findElement(panel).click();
	}

	public void cotizacionMasiva() throws InterruptedException { 
		driver.findElement(labelBtn).click();
		driver.findElement(quoteBtn).click();
		driver.findElement(balance).click(); 
		driver.findElement(payBtn).click();
		driver.findElement(payBtn2).click();
		Thread.sleep(5000);
	}

	public void rotuladoMasivo() throws InterruptedException { 
		//driver.findElement(myShipmentsBtns).click();
		driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[3]/a")).click();
		//driver.findElement(shipingManagementBtn).click();
		Thread.sleep(2000);
		//CLICK EN MIS ENVIOS
		driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[3]/ul/li[2]/a")).click();
		Thread.sleep(5000);
		//CLICK EN GESTION DE ENVIOS
		driver.findElement(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/button")).click();
		Thread.sleep(5000);
		//CLICK PARA SELECCIONAR ENVIOS A ROTULAR
		driver.findElement(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div[1]/div/div/div[2]/label")).click();
		//driver.findElement(labelBtn2).click();
		Thread.sleep(5000);
//		ESPERA A QUE EL BOTÓN DE ROTULADO ESTÉ CLICKEABLE:
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[1]/div[4]/div[1]/div[1]/div/div/div[2]/button"))); 
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", element);
		Thread.sleep(5000);
	}
	public void creacionCuentaHija() throws InterruptedException {
		System.out.println("Login con cuenta padre.");
		driver.findElement(userBtn).click();
		driver.findElement(addUserBtn).click();
		System.out.println("Agregando usuario a la cuenta.");
		rolBtn = new Select(driver.findElement(By.xpath("//select[@id='rol']")));
		Thread.sleep(5000);
		rolBtn.selectByValue("5");
		driver.findElement(nombreBtn2).sendKeys("Usuario");
		driver.findElement(apellidoBtn2).sendKeys("Uno");
		driver.findElement(emailBtn2).sendKeys("cuentahijouno@yopmail.com");
		driver.findElement(saveUser).click();
		System.out.println("Usuario agregado exitosamente.");
		System.out.println("Cerrando sesión cuenta padre.");
		//METO UN LOGOUT
		Helpers helper = new Helpers();
		helper.sleepSeconds(3);
		/*driver.findElement(profileButton).click();
		helper.sleepSeconds(3);*/ //DESACTIVO EL MENU ASI CIERRA REDIRIGIENDO NOMÁS
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/logout");
		helper.sleepSeconds(2);
		driver.close();
		System.out.println("Cerrando browser.");
		System.out.println("----------");
	}
	public void cuentaPadreTakeControl() throws InterruptedException { 
		//driver.findElement(myShipmentsBtns2).click();
		//driver.findElement(sendUsersBtn).click();
		System.out.println("Login con cuenta padre.");
		System.out.println("Toma de control de envío de cuenta hija.");
		driver.get("https://twsec01.correoargentino.com.ar/MiCorreo/public/listadochilds");
		driver.findElement(labelBtn3).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(takeControlBtn)).click();
		//driver.findElement(takeControlBtn).click();
		Thread.sleep(5000);
//		ESPERA A QUE EL BOTÓN DE ACEPTAR ESTÉ CLICKEABLE:
		WebDriverWait wait1 = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/button"))).click();
		Thread.sleep(5000);
		System.out.println("Se tomó control de envío de cuenta hija exitosamente.");
		WebDriverWait wait2 = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[2]/div[2]/div/div/div[3]/button"))).click();
		Thread.sleep(5000);
		System.out.println("Se hizo click en ACEPTAR de 'El envío se reasignó correctamente'.");	
	}

	public void cotizacionMasiva2() throws InterruptedException { 
		System.out.println("Cotizando envíos controlados.");
		//CLICK EN ENVIO DE PAQUETE
		driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[2]/a")).click();
		Thread.sleep(3000);
		//driver.findElement(sendPackageOption).click();
		//CLICK EN NUEVO ENVIO
		driver.findElement(By.xpath("/html/body/div[1]/nav/div[2]/div[2]/ul/li[2]/ul/li[1]/a")).click();
		//driver.findElement(newSendOption).click();
		Thread.sleep(3000);
		System.out.println("Grilla de envíos.");
		driver.findElement(labelBtn).click();
		driver.findElement(quoteBtn).click();
		driver.findElement(balance).click(); 
		driver.findElement(payBtn).click();
		driver.findElement(payBtn2).click();
		System.out.println("Envíos pagados exitosamente.");
		Thread.sleep(3000);
		System.out.println("Cerrando sesión.");
		driver.get("https://twsec01.correoargentino.com.ar/MiCorreo/public/logout");
		Thread.sleep(3000);
		System.out.println("Cerrando browser.");
		driver.quit();
		System.out.println("-----------------");
	}
	public void clickNuevoEnvio() {
		driver.findElement(sendPackageOption).click();
		driver.findElement(newSendOption).click();
	}
	
	//HASTA ACA EL CODIGO DE EZEQUIEL PARA METODOS

}