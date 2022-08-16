package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageHome;
import pages.PageLogin;
import pages.PageNewSendDestinyHome;
import pages.PageNewSendOrigin;
import pages.PageNewSendPackage;
import pages.PagePaySend;
import pages.PageWelcome;

public class E2E {
	private WebDriver driver;
	Helpers helper = new Helpers();

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		helper.sleepSeconds(3);
		driver.manage().window().maximize();
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
		helper.sleepSeconds(2);
					}	
		
	@Test
	public void testE2E() { //GESTION DE NUEVO ENVIO A DOMIC Y PAGO TARJ CRED.

		System.out.println("Ingresando a la Login Page."); // INGRESO
		PageHome pageHome = new PageHome(driver);
		pageHome.signin();

		System.out.println("Ingresando credenciales e iniciando sesión."); // LOGIN
		PageLogin pageLogin = new PageLogin(driver);
		pageLogin.Login("cgoicochea@correoargentino.com.ar", "Pepino23");

		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
		PageWelcome nuevoEnvio = new PageWelcome(driver);
		nuevoEnvio.newSend();

		System.out.println("Rellenando el formulario de ORIGEN."); // ORIGEN
		PageNewSendOrigin datosDeOrigen = new PageNewSendOrigin(driver);
		datosDeOrigen.loadOriginData("JUJUY", "PERICO");

		System.out.println("Rellenando el formulario de DESTINO: Domicilio."); // DESTINO
		PageNewSendDestinyHome datosDeDestino = new PageNewSendDestinyHome(driver);
		datosDeDestino.loadDestinyData("Juan Carlos", "BUENOS AIRES", "LOMAS DE ZAMORA", "Molina Arrotea", "1234", "1", "A", "Puerta Verde", "1832", "11", "424242", "11", "33333333", "cdgtesting@yopmail.com");

		System.out.println("Rellenando el formulario de PAQUETE."); // PAQUETE Y AGREGAR ENVÍO
		PageNewSendPackage datosDePaquete = new PageNewSendPackage(driver);
		datosDePaquete.loadPackageData("PAQ.AR CLASICO", "10", "9", "8", "11", "3000");
		System.out.println("Envío agregado exitosamente.");
		
		System.out.println("Ingresando a las opciones ENVIO DE PAQUETE - NUEVO ENVIO"); // ENVIO DE PAQUETE
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

}
