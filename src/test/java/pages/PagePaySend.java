package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import helpers.Helpers;

public class PagePaySend {
	private WebDriver driver;
	private By balanceOptionPayLabel;
	private By cardOptionPayLabel;
	private By currentAccountOptionPayLabel;
	private By mercadoPagoOptionPayLabel;
	private By optionPayButton;
	private By confirmPayWithBalanceButton;
	/* ELEMENTOS DE LA TARJETA ABAJO */
	private By balanceVisaButton;
	private By cardNumberField;
	private By securityCardNumberField;
	private By expirationMonthField;
	private By expirationYearField;
	private By titularNameField;
	/* private By documentTypeField; */ // COMBO NO MAPEAR, POR DEFECTO DNI
	private By documentNumberField;
	private By confirmPayWithCardButton;
	/* ELEMENTOS DE MERCADOPAGO ABAJO */
	private By acceptTermsOfCookies; //ACEPTA TERMINOS DE COOKIES DEL SITIO
	private By mpUser;
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

	public PagePaySend(WebDriver driver) {
		this.driver = driver;
		balanceOptionPayLabel = By.xpath("//label[@id='saldo']");
		cardOptionPayLabel = By.xpath("//input[@checked=\"checked\"]");
		currentAccountOptionPayLabel = By.id("radioCuentaCorriente");
		mercadoPagoOptionPayLabel = By.xpath("//div[@id='radios_checked']//label[@id='mercadopago']");
		optionPayButton = By.xpath("//button[@onclick=\"enviarForm()\"]");
		confirmPayWithBalanceButton = By.xpath("//button[@id='pagar']");

		// MAPEO DE TARJETA ABAJO*/
		balanceVisaButton = By.className("tarjeta-ima");
		cardNumberField = By.id("card_number");
		securityCardNumberField = By.id("security_code");
		expirationMonthField = By.id("card_expiration_month");
		expirationYearField = By.id("card_expiration_year");
		titularNameField = By.id("card_holder_name");
		/* documentTypeField = By.id(""); */ // COMBO POR DEFAUL, NO MAPEAR AHORA
		documentNumberField = By.id("card_holder_doc_number");
		confirmPayWithCardButton = By.id("pagar"); /* //button[@id='pagar'] */

		// MAPEO DE MERCADO PAGO ABAJO*/
		acceptTermsOfCookies = By.xpath("//button[@data-testid=\"action:understood-button\"]");
		mpUser = By.xpath("//*[@id='group_form_scroller']/ul[1]/li/label/div");
		mpUserField = By.xpath("//*[@id=\"user_id\"]");
		mpUserConfirmationButton = By.xpath("//*[@id=\"login_user_form\"]/div[2]/button");

		mpPasswordField = By.id("password");
		mpPasswordConfirmationButton = By.xpath("//*[@id=\"action-complete\"]/span");
		
		
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

	public void paySendWithCard(String numeroTarjeta, String numeroSeguridadTarjeta, String mesVencimiento,
			String anioVencimiento, String nombreTitulartarjeta, String numeroDocumento) {
		Helpers helper = new Helpers();
		driver.findElement(cardOptionPayLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(optionPayButton).click();
		helper.sleepSeconds(1);
		/* ACCIONES SOBRE ELEMENTOS DE TARJETA */
		driver.findElement(balanceVisaButton).click();
		driver.findElement(cardNumberField).sendKeys(numeroTarjeta);
		driver.findElement(securityCardNumberField).sendKeys(numeroSeguridadTarjeta);
		driver.findElement(expirationMonthField).sendKeys(mesVencimiento);
		driver.findElement(expirationYearField).sendKeys(anioVencimiento);
		driver.findElement(titularNameField).sendKeys(nombreTitulartarjeta);
		// ACA IRIA FINDELEMENT DEL COMBO TIPO DE DOCUMENTO ELEGIDO POR DEFAULT
		driver.findElement(documentNumberField).sendKeys(numeroDocumento);
		helper.sleepSeconds(1);
		driver.findElement(confirmPayWithCardButton).click();

	}

	public void paySendWithBalance() {
		Helpers helper = new Helpers();
		driver.findElement(balanceOptionPayLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(optionPayButton).click();
		helper.sleepSeconds(1);
		driver.findElement(confirmPayWithBalanceButton).click();

	}

	public void paySendWithCurrentAccount() {
		Helpers helper = new Helpers();
		driver.findElement(currentAccountOptionPayLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(optionPayButton).click();
	}

	public void paySendWithMercadoPagoAsGuest(String numeroTarjeta, String numeroSeguridadTarjeta,
			String vencimientoTarjeta, String nombreTitulartarjeta, String numeroDocumento, String email) {
		Helpers helper = new Helpers();
		driver.findElement(mercadoPagoOptionPayLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(optionPayButton).click();
		/* ACCIONES SOBRE ELEMENTOS DE MERCADOPAGO */
		helper.sleepSeconds(3);
		driver.switchTo().frame(0); // PARA ACCEDER AL FRAME GENERADO Y PODER CONTINUAR
		driver.findElement(acceptTermsOfCookies).click(); //CLICK ENTENDIDO EN COOKIES
		helper.sleepSeconds(3);
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
		// driver.findElement(mpPaymentConfirmation).click(); //NO SE PUEDE CLICKEAR YA QUE SE SUPERPONE UN AVISO
		helper.sleepSeconds(1);
		driver.findElement(mpReturnButton).click();
	}

	public void paySendWithMercadoPagoAsUser(String usuario, String password,
			String numeroTarjeta, String numeroSeguridadTarjeta, String vencimientoTarjeta, String nombreTitulartarjeta,
			String numeroDocumento) {
		Helpers helper = new Helpers();
		driver.findElement(mercadoPagoOptionPayLabel).click();
		helper.sleepSeconds(1);
		driver.findElement(optionPayButton).click();
		/* ACCIONES SOBRE ELEMENTOS DE MERCADOPAGO */
		helper.sleepSeconds(3);
		
		driver.switchTo().frame(0); // PARA ACCEDER AL FRAME GENERADO Y PODER CONTINUAR
		
		String winHandleBefore = driver.getWindowHandle();
		driver.findElement(acceptTermsOfCookies).click(); //CLICK ENTENDIDO EN COOKIES
		helper.sleepSeconds(3);
		driver.findElement(mpUser).click();
		helper.sleepSeconds(3);

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		driver.findElement(mpUserField).sendKeys(usuario);
		driver.findElement(mpUserConfirmationButton).click();
		driver.findElement(mpPasswordField).sendKeys(password);
		driver.findElement(mpPasswordConfirmationButton).click();

		driver.switchTo().window(winHandleBefore);

		helper.sleepSeconds(10);

		driver.switchTo().frame(0);

		driver.findElement(mpUser).click();

		driver.findElement(mpCardNumber).sendKeys(numeroTarjeta);
		driver.findElement(mpExpirationDate).sendKeys(vencimientoTarjeta);
		driver.findElement(mpTitularName).sendKeys(nombreTitulartarjeta);
		driver.findElement(mpSecurityNumber).sendKeys(numeroSeguridadTarjeta);
		driver.findElement(mpSecurityNumber).sendKeys(Keys.ENTER);

		helper.sleepSeconds(1);
		driver.findElement(mpIdNumber).sendKeys(numeroDocumento);
		driver.findElement(mpIdNumber).sendKeys(Keys.ENTER);
		/*driver.findElement(mpDisclaimerButton).click();*/ //EL ACEPTAR COOKIES YA SE MAPEÓ
		helper.sleepSeconds(1);
		driver.findElement(mpPay).click();
		helper.sleepSeconds(1);
		driver.findElement(mpReturnButton).click();

		
		
		
	}
}
