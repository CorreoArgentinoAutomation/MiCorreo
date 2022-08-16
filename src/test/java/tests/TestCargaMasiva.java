package tests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.chrome.ChromeDriver;

import helpers.Helpers;
import pages.PageHome;
import pages.PageLogin;
import pages.PageWelcome;


public class TestCargaMasiva {
    
    private WebDriver driver; 
    Helpers helper = new Helpers(); 
	PageLogin pageLogin; 
	PageHome pageHome; 
	PageWelcome pageWelcome;



    @BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver(); 
		driver.manage().window().maximize(); 
		driver.get("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
		} 
                    
    @Test
	public void creacionEnvios() throws InterruptedException{
		pageHome = new PageHome(driver);
		pageHome.signin();
		pageLogin = new PageLogin(driver);
		pageLogin.Login("ezequiel_emp@yopmail.com", "123123");
		pageWelcome = new PageWelcome(driver);
		System.out.println("Agregando envío 1.");
		pageWelcome.newShipment();  //(esta comentado porque el BTN de 'Nuevo Envio' me lleva a 'Rotulado Masivo')
		System.out.println("Envío agregado correctamente.");
		System.out.println("Agregando envío 2.");
		pageWelcome.newShipment2(); 
		System.out.println("Envío agregado correctamente.");
		System.out.println("Agregando envío 3.");
		pageWelcome.newShipment3();
		System.out.println("Envío agregado correctamente.");
		System.out.println("Agregando envío 4.");
		pageWelcome.newShipment4();
		System.out.println("Envío agregado correctamente.");
		System.out.println("Realizando cotización masiva y pago de los envíos agregados.");
		pageWelcome.clickNuevoEnvio();
		pageWelcome.cotizacionMasiva(); //(comentado)
		System.out.println("Envíos pagados exitosamente.");
		System.out.println("Iniciando rotulado masivo.");
		pageWelcome.rotuladoMasivo(); //(comentado)
		System.out.println("Rotulado masivo exitoso.");

	}
} 