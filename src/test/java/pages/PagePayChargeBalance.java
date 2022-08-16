package pages;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import helpers.Helpers;

public class PagePayChargeBalance {

	private WebDriver driver;
	// OPCIONES DE RECARGA: TARJETA Y MERCADOPAGO
	private By balanceChargeCardOption;
	private By balanceChargeMercadoPagoOption;
	/* private By cargarSaldoAFavor; */ // PREDETERMINADO, NO MAPEAR AHORA
	private By balanceChargeValueField;
	private By balanceChargePayButton;
	// ELEMENTOS DE TARJETA ABAJO
	private By balanceVisaButton;
	private By cardNumberField;
	private By securityCardNumberField;
	private By expirationMonthField;
	private By expirationYearField;
	private By titularNameField;
	/* private By documentTypeField; */ // COMBO NO MAPEAR, POR DEFECTO DNI
	private By documentNumberField;
	private By confirmPayWithCardButton;
	// ELEMENTOS DE MERCADOPAGO ABAJO
	private By acceptTermsOfCookies; //ACEPTA TERMINOS DE COOKIES DEL SITIO
	private By mpUser;
	private By newCard;
	private By mpGuest;
	private By mpCardNumber;
	private By mpExpirationDate;
	private By mpTitularName;
	private By mpSecurityNumber;
	private By mpContinue;
	// ELEMENTOS DE USUARIO MERCADOPAGO ABAJO
	private By mpUserField;
	private By mpUserConfirmationButton;
	private By mpPasswordField;
	private By mpPasswordConfirmationButton;
	//private By mpDisclaimerButton;
	private By mpPay;

	// private By idType //POR DEFECTO DNI
	private By mpIdNumber;
	private By mpEmail;
	// private By mpPaymentConfirmation; // NO ACCESIBLE YA QUE SE SUPERPONE UN
	// POP-UP - SOLUCIONADO: SIMULAR UN "ENTER"
	private By mpReturnButton;

	public PagePayChargeBalance(WebDriver driver) {
		this.driver = driver;
		balanceChargeCardOption = By.xpath(
				"//body/div[@id='wrapper']/div[@id='myModalGenerico']/div[1]/div[1]/div[2]/div[4]/div[1]/label[1]");
		balanceChargeMercadoPagoOption = By.xpath(
				"//body/div[@id='wrapper']/div[@id='myModalGenerico']/div[1]/div[1]/div[2]/div[4]/div[1]/label[2]");
		/* cargarSaldoAFavor = By.id(""); */ // NO MAPEAR
		balanceChargeValueField = By.id("valorcargaModal");
		balanceChargePayButton = By
				.xpath("/html/body/div[1]/div[2]/div/div/div[2]/div[5]/form/div[3]/div[2]/div/button[2]");
		acceptTermsOfCookies = By.xpath("//button[@data-testid=\"action:understood-button\"]");
		// MAPEO DE TARJETA ABAJO (COLOCAR DESP EN METODO APARTE PARA REUTILIZAR)*/
		balanceVisaButton = By.className("tarjeta-ima");
		cardNumberField = By.id("card_number");
		securityCardNumberField = By.id("security_code");
		expirationMonthField = By.id("card_expiration_month");
		expirationYearField = By.id("card_expiration_year");
		titularNameField = By.id("card_holder_name");
		/* documentTypeField = By.id(""); */ // COMBO POR DEFAUL, NO MAPEAR AHORA
		documentNumberField = By.id("card_holder_doc_number");
		confirmPayWithCardButton = By.id("pagar");
		// MAPEO DE MERCADO PAGO ABAJO
		mpUser = By.xpath("//*[@id='group_form_scroller']/ul[1]/li/label/div");

		mpUserField = By.name("user_id");
		mpUserConfirmationButton = By.xpath("//*[@id=\"login_user_form\"]/div[2]/button");

		mpPasswordField = By.xpath("//input[@type=\"password\"]");
		mpPasswordConfirmationButton = By.xpath("//*[@id=\"action-complete\"]/span");
		
		newCard = By.xpath("/html/body/div[1]/main/div/div/div[2]/div[1]/form/ul/li/label/div");
		mpGuest = By.xpath("//*[@id='group_form_scroller']/ul[2]/li/label/div");
		mpCardNumber = By.id("card_number");
		mpExpirationDate = By.id("input_expiration_date");
		mpTitularName = By.id("fullname");
		mpSecurityNumber = By.id("cvv");
		mpContinue = By.id("submit");
		// idType=By.id("type"); //POR DEFAULT: DNI
		mpIdNumber = By.id("number");
		mpEmail = By.id("email");

		//mpDisclaimerButton = By.id("newCookieDisclaimerButton");
		mpPay = By.xpath("//*[@id=\"pay\"]");
		mpReturnButton = By.id("continue_button");
	}

	public void cargarSaldoConTarjeta(String valorDeCarga, String numeroTarjeta, String numeroSeguridadTarjeta,
			String mesVencimiento, String anioVencimiento, String nombreTitulartarjeta, String numeroDocumento) {
		Helpers helper = new Helpers();
		driver.findElement(balanceChargeCardOption).click();
		helper.sleepSeconds(1);
		// ACA IRIA LA ACCION SOBRE EL COMBO NO MAPEADO
		driver.findElement(balanceChargeValueField).sendKeys(valorDeCarga);
		driver.findElement(balanceChargePayButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(balanceVisaButton).click();
		driver.findElement(cardNumberField).sendKeys(numeroTarjeta);
		driver.findElement(securityCardNumberField).sendKeys(numeroSeguridadTarjeta);
		driver.findElement(expirationMonthField).sendKeys(mesVencimiento);
		driver.findElement(expirationYearField).sendKeys(anioVencimiento);
		driver.findElement(titularNameField).sendKeys(nombreTitulartarjeta);
		// ACA IRIA FINDELEMENT DEL COMBO TIPO DE DOCUMENTO ELEGIDO POR DEFAULT
		driver.findElement(documentNumberField).sendKeys(numeroDocumento);
		driver.findElement(confirmPayWithCardButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public void cargarSaldoConMercadoPagoComoInvitado(String valorDeCarga, String numeroTarjeta,
			String numeroSeguridadTarjeta, String vencimientoTarjeta, String nombreTitulartarjeta,
			String numeroDocumento, String email) {
		Helpers helper = new Helpers();
		driver.findElement(balanceChargeMercadoPagoOption).click();
		helper.sleepSeconds(1);
		driver.findElement(balanceChargeValueField).sendKeys(valorDeCarga);
		driver.findElement(balanceChargePayButton).click();
		/*driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);*/
		helper.sleepSeconds(3);
		/* ACCIONES SOBRE ELEMENTOS DE MERCADOPAGO */
		driver.switchTo().frame(0); //CAMBIA A IFRAME MP, MUESTRA AVISO COOKIES
		driver.findElement(acceptTermsOfCookies).click(); //CLICK ENTENDIDO EN COOKIES
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(mpGuest).click();
		driver.findElement(mpCardNumber).sendKeys(numeroTarjeta);
		driver.findElement(mpExpirationDate).sendKeys(vencimientoTarjeta);
		driver.findElement(mpTitularName).sendKeys(nombreTitulartarjeta);
		driver.findElement(mpSecurityNumber).sendKeys(numeroSeguridadTarjeta);
		driver.findElement(mpContinue).click();
		helper.sleepSeconds(1);
		driver.findElement(mpIdNumber).sendKeys(numeroDocumento);
		driver.findElement(mpContinue).click();
		helper.sleepSeconds(1);
		driver.findElement(mpEmail).sendKeys(email);
		helper.sleepSeconds(1);
		driver.findElement(mpEmail).sendKeys(Keys.ENTER); // PARA CONFIRMAR SE SIMULA UN "ENTER"
		// driver.findElement(mpPaymentConfirmation).click(); //NO SE PUEDE CLICKEAR YA
		// QUE SE SUPERPONE UN AVISO
		helper.sleepSeconds(1);
		driver.findElement(mpReturnButton).click();
		helper.sleepSeconds(3);
	}

	public void cargarSaldoConMercadoPagoComoUsuario(String valorDeCarga, String usuario, String password,
			String numeroTarjeta, String numeroSeguridadTarjeta, String vencimientoTarjeta, String nombreTitulartarjeta,
			String numeroDocumento) {
		Helpers helper = new Helpers();
		driver.findElement(balanceChargeMercadoPagoOption).click();
		helper.sleepSeconds(1);
		driver.findElement(balanceChargeValueField).sendKeys(valorDeCarga);
		driver.findElement(balanceChargePayButton).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		/* ACCIONES SOBRE ELEMENTOS DE MERCADOPAGO */
		driver.switchTo().frame(0); // PARA ACCEDER AL FRAME GENERADO Y PODER CONTINUAR
		//CAMBIA A IFRAME MP, MUESTRA AVISO COOKIES
		driver.findElement(acceptTermsOfCookies).click(); //CLICK ENTENDIDO EN COOKIES
		helper.sleepSeconds(3);
				
		driver.findElement(mpUser).click();
		helper.sleepSeconds(2);
		
		 Set<String> handlesSet = driver.getWindowHandles(); //SE OBTIENEN VENTANAS Y SE HACE LISTA
	        List<String> handlesList = new ArrayList<String>(handlesSet);
	        driver.switchTo().window(handlesList.get(1)); //SE CAMBIA A LA POSICION 1, QUE ES LA VENTANA DE MP, PARA LOGUEAR
	        
		driver.findElement(mpUserField).click();
		driver.findElement(mpUserField).sendKeys(usuario);
		driver.findElement(mpUserConfirmationButton).click();
		helper.sleepSeconds(4);
		driver.findElement(mpPasswordField).sendKeys(password);
		helper.sleepSeconds(4);
		driver.findElement(mpPasswordConfirmationButton).click();
		helper.sleepSeconds(10);
		
		//TERMINA LOGUEO Y DESAPARECE VENTANA DE COMUNICACIÓN CON MP
		
		 Set<String> handlesSet1 = driver.getWindowHandles(); //SE OBTIENEN VENTANAS Y SE HACE OTRA LISTA
	        List<String> handlesList1 = new ArrayList<String>(handlesSet1);
	        driver.switchTo().window(handlesList1.get(0)); //SE CAMBIA A LA POSICION 0, QUE ES LA VENTANA DE CORREO

		driver.switchTo().frame(0); //ACCEDE NUEVAMENTE AL IFRAME DE CORREO PARA CONTINUAR
		driver.findElement(newCard).click();
		helper.sleepSeconds(2);

		driver.findElement(mpCardNumber).sendKeys(numeroTarjeta);
		driver.findElement(mpExpirationDate).sendKeys(vencimientoTarjeta);
		driver.findElement(mpTitularName).sendKeys(nombreTitulartarjeta);
		driver.findElement(mpSecurityNumber).sendKeys(numeroSeguridadTarjeta);
		driver.findElement(mpSecurityNumber).sendKeys(Keys.ENTER);

		helper.sleepSeconds(1);
		driver.findElement(mpIdNumber).sendKeys(numeroDocumento);
		driver.findElement(mpIdNumber).sendKeys(Keys.ENTER);
		helper.sleepSeconds(1);
		driver.findElement(mpPay).click();
		helper.sleepSeconds(1);
		driver.findElement(mpReturnButton).click();
		helper.sleepSeconds(3);

	}

}