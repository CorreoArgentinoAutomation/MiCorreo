package tests;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class loginWithExcel {

    private WebDriver driver;
    private ReadExcelFile readFile;
    private By enterBtn = By.xpath("//body/div[@id='div-barra-principal']/div[1]/div[1]/ul[1]/span[1]/li[1]/a[1]");
    private By emailBtnLocator = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/input[1]");
    private By passwordBtnLocator = By.xpath("/html[1]/body[1]/div[4]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/div[1]/input[1]");
    private By enterBtn2 = By.xpath("//body/div[4]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/div[2]/button[1]");
    

    @Before
    public void setUp() throws Exception {
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        driver = new ChromeDriver();
        readFile = new ReadExcelFile();

        driver.get("https://twsec01.correoargentino.com.ar/MiCorreo/public/");

    }

    @After
    public void tearDown() throws Exception {
        //driver.close();
    }

   @Test
   public void loginWithXLSX() throws IOException{  
        String filepath = "C:/Users/ZEXTCGoicochea/Downloads/eclipse-workspace/MiCorreoPageObjectBy/excel/usuarios.xlsx";

        String emailText = readFile.getCellValue(filepath, "Hoja1", 4, 0);
        
        driver.findElement(enterBtn).click();

        driver.findElement(emailBtnLocator).sendKeys(emailText);

        String passwordText = readFile.getCellValue(filepath, "Hoja1", 4, 1);

        driver.findElement(passwordBtnLocator).sendKeys(passwordText);

        driver.findElement(enterBtn2).click();
        
   }
}

