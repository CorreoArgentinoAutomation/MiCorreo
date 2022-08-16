package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import helpers.Helpers;
import pages.PageHome;
import pages.PageNewRotulo;


public class TestGenerarRotuloIndividual {
	private WebDriver driver;
	Helpers helper = new Helpers();

	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://twsec01.correoargentino.com.ar/MiCorreo/public/");
		helper.sleepSeconds(2);
					}	

		@Test

		public void nuevoRotuloEnvioDomicilio() {
			System.out.println("Ingresando a RÓTULO"); // ENVIO DE PAQUETE
			PageHome nuevoRotulo = new PageHome(driver);
			nuevoRotulo.selectRotulo();
			
			System.out.println("Generando rotulo Envio Domicilio - Pantalla origen."); // INGRESO
			PageNewRotulo pageNewRotulo = new PageNewRotulo(driver);
			pageNewRotulo.addRotuloDomicilioOrigen("Daniel Goicochea", "BUENOS AIRES", "Lomas de Zamora", "Arrotea", "1200", "2", "B", "1832", "9 DE JULIO");
			
			System.out.println("Generando rotulo Envio Domicilio - Pantalla destino.");
			pageNewRotulo.addRotuloDomicilioDestino("Nuevo Destino", "BUENOS AIRES", "Lanús Este", "Chivito", "2090", "2", "D", "1832", "Pasillo portón Rojo");
		
			System.out.println("Generando rotulo Envio Domicilio - Pantalla paquete.");
			pageNewRotulo.addRotuloDomicilioPaquete("3");
		}
		
	
		@Test

		public void nuevoRotuloEnvioSucursal() {
			System.out.println("Ingresando a RÓTULO"); // ENVIO DE PAQUETE
			PageHome nuevoRotulo = new PageHome(driver);
			nuevoRotulo.selectRotulo();
			
			System.out.println("Generando rotulo Envio Sucursal - Pantalla origen."); // INGRESO
			PageNewRotulo pageNewRotulo = new PageNewRotulo(driver);
			pageNewRotulo.addRotuloDomicilioOrigen("Christian Goicochea", "BUENOS AIRES", "Lomas de Zamora", "Arrotea", "1200", "2", "B", "1832", "9 DE JULIO");
			
			System.out.println("Generando rotulo Envio Sucursal - Pantalla destino.");
			pageNewRotulo.addRotuloSucursalDestino("Sucursal Destino", "CHACO", "AVIA TERAI");
			
			System.out.println("Generando rotulo Envio Sucursal - Pantalla paquete.");
			pageNewRotulo.addRotuloDomicilioPaquete("3");
		}
		


}
		

