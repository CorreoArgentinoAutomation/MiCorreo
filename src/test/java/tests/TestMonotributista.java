package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageHome;
import pages.PageLogin;
import pages.PageNewSendDestinyHome;
import pages.PageNewSendDestinySucursal;
import pages.PageNewSendOrigin;
import pages.PageNewSendPackage;
import pages.PagePayChargeBalance;
import pages.PagePaySend;
import pages.PageWelcome;

public class TestMonotributista {
	private WebDriver driver;
	Helpers helper = new Helpers();

	@BeforeMethod
	public void setUp() {
		/*System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
		helper.sleepSeconds(2);*/
		
		System.setProperty("webdriver.gecko.driver", "Drivers/geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
		helper.sleepSeconds(2);
		
//		System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver.exe");
//		driver = new EdgeDriver();
//		driver.manage().window().maximize();
//		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
//		helper.sleepSeconds(2);
					}	
	@Test

	public void monotribAgregaEnvioDomicilio() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("zextpquiros@correoargentino.com.ar", "pruebita123");
	
		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Rellenando el formulario de ORIGEN."); // ORIGEN
		PageNewSendOrigin datosDeOrigen = new PageNewSendOrigin(driver);
		datosDeOrigen.loadOriginData("CHUBUT", "CHOLILA");

		System.out.println("Rellenando el formulario de DESTINO: Domicilio."); // DESTINO
		PageNewSendDestinyHome datosDeDestino = new PageNewSendDestinyHome(driver);
		datosDeDestino.loadDestinyData("Juan Carlos", "BUENOS AIRES", "LOMAS DE ZAMORA", "Molina Arrotea", "1234", "1", "A", "Puerta Verde", "1832", "11", "424242", "11", "33333333", "cdgtesting@yopmail.com");

		System.out.println("Rellenando el formulario de PAQUETE."); // PAQUETE Y AGREGAR ENVÍO
		PageNewSendPackage datosDePaquete = new PageNewSendPackage(driver);
		datosDePaquete.loadPackageData("PAQ.AR CLASICO", "10", "9", "8", "11", "3000");
		System.out.println("Envío agregado exitosamente.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}

	@Test
	public void monotribAgregaEnvioSucursal() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		helper.sleepSeconds(3);
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Rellenando el formulario de ORIGEN."); // ORIGEN
		PageNewSendOrigin datosDeOrigen = new PageNewSendOrigin(driver);
		datosDeOrigen.loadOriginData("JUJUY", "PERICO");

		System.out.println("Rellenando el formulario de DESTINO: Sucursal."); // DESTINO: SUCURSAL
		PageNewSendDestinySucursal datosDeDestino = new PageNewSendDestinySucursal(driver);
		datosDeDestino.loadDestinyDataSucursal("Juan Pedro", "BUENOS AIRES", "TIGRE", "11", "424242", "11", "33333333",
				"cdgtesting@yopmail.com");

		System.out.println("Rellenando el formulario de PAQUETE."); // PAQUETE Y AGREGAR ENVÍO
		PageNewSendPackage datosDePaquete = new PageNewSendPackage(driver);
		datosDePaquete.loadPackageData("PAQ.AR CLASICO", "10", "9", "8", "11", "3000");
		System.out.println("Envío agregado exitosamente.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}

	/*@Test

	public void monotribAgregaEnvioLocker() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		helper.sleepSeconds(3);
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Rellenando el formulario de ORIGEN."); // ORIGEN
		PageNewSendOrigin datosDeOrigen = new PageNewSendOrigin(driver);
		datosDeOrigen.loadOriginData("JUJUY", "PERICO");

		System.out.println("Rellenando el formulario de DESTINO: Locker."); // DESTINO: LOCKER
		PageNewSendDestinyLocker datosDeDestino = new PageNewSendDestinyLocker(driver);
		datosDeDestino.loadDestinyDataLocker("Juan Pedro", "BUENOS AIRES", "MIBOX TIGRE", "11", "424242", "11",
				"33333333", "cdgtesting@yopmail.com");

		System.out.println("Rellenando el formulario de PAQUETE."); // PAQUETE Y AGREGAR ENVÍO
		helper.sleepSeconds(2);
		PageNewSendPackage datosDePaquete = new PageNewSendPackage(driver);
		datosDePaquete.loadPackageData("PAQ.AR CLASICO", "10", "9", "8", "11", "3000");
		System.out.println("Envío agregado exitosamente.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();

	}*/

	@Test

	public void monotribPagoEnvioTarjeta() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Seleccionando envío a cotizar."); // SELECCIONA Y COTIZA ENVIO
		PageNewSendOrigin cotizar = new PageNewSendOrigin(driver);
		cotizar.quoteSend();
		System.out.println("Envío cotizado. Alternativas de pago.");

		System.out.println("Pagando el envío con tarjeta de crédito"); // PAGO ENVIO TARJETA CREDITO
		PagePaySend pagoEnvioConTarjeta = new PagePaySend(driver);
		pagoEnvioConTarjeta.paySendWithCard("4507990000004905", "775", "08", "25", "TARJETA VISA", "27859328");
		System.out.println("Pago con tarjeta exitoso.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}

	@Test

	public void monotribPagoEnvioSaldo() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Seleccionando envío a cotizar."); // SELECCIONA Y COTIZA ENVIO
		PageNewSendOrigin cotizar = new PageNewSendOrigin(driver);
		cotizar.quoteSend();
		System.out.println("Envío cotizado. Alternativas de pago.");

		System.out.println("Pagando el envío con saldo."); // PAGO ENVIO SALDO
		PagePaySend pagoEnvioConSaldo = new PagePaySend(driver);
		pagoEnvioConSaldo.paySendWithBalance();
		System.out.println("Pago con saldo exitoso.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}

	@Test

	public void monotribPagoEnvioCtaCte() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("zextanlopez@correoargentino.com.ar", "Password2020");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Seleccionando envío a cotizar."); // SELECCIONA Y COTIZA ENVIO
		PageNewSendOrigin cotizar = new PageNewSendOrigin(driver);
		cotizar.quoteSend();
		System.out.println("Envío cotizado. Alternativas de pago.");

		System.out.println("Pagando el envío con cuenta corriente."); // PAGO ENVIO CTA CTE
		PagePaySend pagoEnvioConCtaCte = new PagePaySend(driver);
		pagoEnvioConCtaCte.paySendWithCurrentAccount();
		System.out.println("Pago con Cta cte. exitoso.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}

	@Test

	public void monotribRecargaSaldoTarjeta() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando al panel de recarga de saldo.");
		PageWelcome pageWelcome = new PageWelcome(driver);
		pageWelcome.balanceChargePanel();
		
		System.out.println("Recargando saldo con tarjeta."); // RECARGA DE SALDO CON TARJETA
		PagePayChargeBalance recargaDeSaldo = new PagePayChargeBalance(driver);
		recargaDeSaldo.cargarSaldoConTarjeta("1000", "4507990000004905", "775", "08", "25", "TARJETA VISA", "27859328");
		System.out.println("Saldo cargado exitosamente.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}

	@Test

	public void monotribRecargaSaldoMercadoPagoComoInvitado() { // LOS LOCATORS CAMBIAN DE XPATH DEPENDIENDO EL MÓDULO EN EL QUE ESTÉS

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando al panel de recarga de saldo.");
		PageWelcome pageWelcome = new PageWelcome(driver);
		pageWelcome.balanceChargePanel();
		


		System.out.println("Seleccionando forma de carga: MercagoPago."); // SELECCION MERCADOPAGO COMO INVITADO - CON TARJ. VISA
		PagePayChargeBalance recargaDeSaldo = new PagePayChargeBalance(driver);
		recargaDeSaldo.cargarSaldoConMercadoPagoComoInvitado("1000","5031755734530604", "123", "1125", "APRO", "11111111", "pepe@correoargentino.com.ar");
		
		System.out.println("Saldo cargado exitosamente.");
		
		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
	}
	
	
	@Test

	public void monotribRecargaSaldoMercadoPagoComoUsuario() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando al panel de recarga de saldo.");
		PageWelcome pageWelcome = new PageWelcome(driver);
		pageWelcome.balanceChargePanel();

		System.out.println("Seleccionando forma de carga: MercagoPago."); // SELECCION MERCADOPAGO
		PagePayChargeBalance recargaDeSaldo = new PagePayChargeBalance(driver);
		recargaDeSaldo.cargarSaldoConMercadoPagoComoUsuario("1000", "TETE3841369", "qatest3972","5031755734530604", "123", "1125", "APRO","11111111");
		

		System.out.println("Saldo cargado exitosamente.");

		
		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
		
		 } 
				
	@Test

	public void monotribPagoEnvioMercadoPagoComoInvitado() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Seleccionando envío a cotizar."); // SELECCIONA Y COTIZA ENVIO
		PageNewSendOrigin cotizar = new PageNewSendOrigin(driver);
		cotizar.quoteSend();
		System.out.println("Envío cotizado. Alternativas de pago.");

		System.out.println("Pagando el envío con Mercago Pago."); //PAGO ENVIO MERCADOPAGO COMO INVITADO - CON TARJ. VISA
		PagePaySend pagoEnvioConMercadoPago = new PagePaySend(driver);
		pagoEnvioConMercadoPago.paySendWithMercadoPagoAsGuest("5031755734530604", "123", "1125", "APRO", " 11111111",
				"pepe@correoargentino.com.ar");

		System.out.println("Pago con MercadoPago exitoso.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();

	}

	
	@Test

	public void monotribPagoEnvioMercadoPagoComoUsuario() {

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Seleccionando envío a cotizar."); // SELECCIONA Y COTIZA ENVIO
		PageNewSendOrigin cotizar = new PageNewSendOrigin(driver);
		cotizar.quoteSend();
		System.out.println("Envío cotizado. Alternativas de pago.");

		System.out.println("Pagando el envío con Mercago Pago"); // PAGO ENVIO MERCADOPAGO COMO USUARIO
		PagePaySend pagoEnvioConMercadoPago = new PagePaySend(driver);
		
		pagoEnvioConMercadoPago.paySendWithMercadoPagoAsUser("TETE3841369", "qatest3972","5031755734530604", "123", "1125", "APRO","11111111");
		
		System.out.println("Pago con MercadoPago exitoso.");

		System.out.println("Cerrando sesión."); //CIERRE DE SESION
		PageWelcome cerrarSesion = new PageWelcome(driver);
		cerrarSesion.logOut();
		
	} 
	
	//CONSULTA DE MOVIMIENTOS DESACTIVADA PORQUE AGREGARON CALENDARIO
	/*@Test

	public void monotribVerMovimientos() { // LOS LOCATORS CAMBIAN DE XPATH DEPENDIENDO EL MÓDULO EN EL QUE ESTÉS

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando al panel de movimientos."); 
		PageWelcome pageWelcome = new PageWelcome(driver);
		pageWelcome.selectUserMovements();

}*/
}
