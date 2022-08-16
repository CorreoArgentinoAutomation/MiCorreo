package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageHome;
import pages.PageLogin;
import pages.PageWelcome;

public class TestCuentasPadreHijo {

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

   @Test // (cuentasPadreHijo)
    public void creacionCuenta() throws InterruptedException{
        pageHome = new PageHome(driver);
        pageHome.signin();
        pageLogin = new PageLogin(driver);                         //NECESITA ACTIVACION LA CUENTA, NO ENCUENTRO MANERA DE HACERLO AUTOMATIZADO. 
        pageLogin.Login("ezequiel_cf@yopmail.com", "123123");
        pageWelcome = new PageWelcome(driver);   
        pageWelcome.creacionCuentaHija();
}

@Test //(nuevoEnvioCuentaHijo)
    public void cuentaHijo() throws InterruptedException{
		System.out.println("Login con cuenta hijo.");
        pageHome = new PageHome(driver);
        pageHome.signin();
        pageLogin = new PageLogin(driver);                     
        pageLogin.Login("cuentahijouno@yopmail.com", "123123");
        pageWelcome = new PageWelcome(driver);
        System.out.println("Creando envío con cuenta hijo.");
        pageWelcome.newShipment();
        System.out.println("Envío creado correctamente.");
        System.out.println("Cerrando sesión.");
		driver.get("https://twsec01.correoargentino.com.ar/MiCorreo/public/logout");
		Thread.sleep(3000);
		System.out.println("Cerrando browser.");
		driver.quit();
		System.out.println("-----------------");
}

@Test //(tomaDeControlCuentaPadre)
    public void cuentaPadreTakeControl() throws InterruptedException{
        pageHome = new PageHome(driver);
        pageHome.signin();
        pageLogin = new PageLogin(driver);                        
        pageLogin.Login("ezequiel_cf@yopmail.com", "123123");
        pageWelcome = new PageWelcome(driver);
        pageWelcome.cuentaPadreTakeControl(); 
        pageWelcome.cotizacionMasiva2();


}
    }
