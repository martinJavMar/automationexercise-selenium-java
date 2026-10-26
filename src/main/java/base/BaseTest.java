package base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import page.AccountCreatedPage;
import page.BrandPage;
import page.CartPage;
import page.CheckoutPage;
import page.ContacUsPage;
import page.DeleteAccountPage;
import page.HomePage;
import page.LoginPage;
import page.PaymentDonePage;
import page.PaymentPage;
import page.ProductDetailsPage;
import page.ProductsPage;
import page.SingUpPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.qameta.allure.testng.AllureTestNg;
import org.testng.annotations.Listeners;
import org.testng.ITestResult;
import utils.ScreenshotUtils;

@Listeners(AllureTestNg.class)

public class BaseTest {

    protected WebDriver driver;
    protected HomePage homePage;
    protected LoginPage loginPage;
    protected ContacUsPage contacUsPage;
    protected ProductsPage productsPage;
    protected CartPage cartPage;
    protected ProductDetailsPage productDetailsPage;
    protected SingUpPage singUpPage;
    protected AccountCreatedPage accountCreatedPage;
    protected PaymentPage paymentPage;
    protected PaymentDonePage paymentDonePage;
    protected DeleteAccountPage deleteAccountPage;
    protected BrandPage brandPage;
    protected CheckoutPage checkoutPage;
    protected static final Logger logger =
            LogManager.getLogger(BaseTest.class);

    @BeforeMethod
    public void setUp() {
    	

        logger.info("Iniciando navegador");

        ChromeOptions options = new ChromeOptions();

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        // Permite que Chrome se ejecute en el entorno de CI. 
        options.addArguments("--disable-gpu");

        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver(options);



        driver.manage().window().maximize();

        driver.get("https://automationexercise.com/");

        logger.info("Página abierta correctamente");
        
        homePage = new HomePage(driver);
        loginPage = new LoginPage(driver);
        contacUsPage= new ContacUsPage(driver);
        productsPage= new ProductsPage(driver);
        cartPage= new CartPage(driver);
        productDetailsPage= new ProductDetailsPage(driver);
        singUpPage= new SingUpPage(driver);
        accountCreatedPage= new AccountCreatedPage(driver);
        paymentPage=new PaymentPage(driver);
        paymentDonePage= new PaymentDonePage(driver);
        deleteAccountPage= new DeleteAccountPage(driver);
        brandPage=new BrandPage(driver);
        checkoutPage= new CheckoutPage(driver);
        
        
    }

    
    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtils.attachScreenshot(driver);
        }

        logger.info("Cerrando navegador");

        if (driver != null) {
            driver.quit();
        }
    }
    
    
    
    
}