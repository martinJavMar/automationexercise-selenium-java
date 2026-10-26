package base;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class BasePage {
	protected static final Logger logger =
	        LogManager.getLogger(BasePage.class);
	protected WebDriver driver;
	protected WebDriverWait wait; 
	public BasePage(WebDriver driver){
		this.driver= driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10)); }
	

	public WebElement findElement (By locator) {
		logger.info("Buscando : " + locator);
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator ){
		logger.info("Buscando locators " + locator);
		return driver.findElements(locator);
	}
	
	public String getText (WebElement element) {
		logger.info("Obteniendo el texto de: " + element);
		return element.getText();
	}
	
	public String getText (By locator) {
		logger.info("Obteniendo el texto de: " + locator);
		 return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
		           
	}
	
	public void type(String inputText, By locator) {

	    logger.info("Escribiendo en: " + locator);

	    WebElement element = wait.until(
	        ExpectedConditions.elementToBeClickable(locator)
	    );

	    element.clear();
	    element.sendKeys(inputText);
	}
	
	public void clearInput(By locator) {
		logger.info("limpiando input: " + locator);
		wait.until(ExpectedConditions.elementToBeClickable(locator)).clear();
	}
	
	
	
	
	public void click (By locator){
		logger.info("Click en: " + locator);
		
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}
	
	public void click (WebElement element) {
		logger.info("Click en: " + element);
		element.click();
	}
	
	
	public boolean isDisplayed(By locator) {
	    logger.info("Verificando visibilidad del elemento: " + locator);

	    try {
	        return wait.until(
	                ExpectedConditions.visibilityOfElementLocated(locator)
	        ).isDisplayed();
	    } catch (TimeoutException | NoSuchElementException e) {
	        return false;
	    }
	}
	
	
	
	
	public void visit(String url) {
		logger.info("Visitando: " + url);
		driver.get(url);
	}
	
	public boolean isEnabled(By locator) {
		logger.info("Esperando a que se habilite: " + locator);
	    try {
	    	return wait.until(ExpectedConditions.presenceOfElementLocated(locator)).isEnabled();
	    } catch (NoSuchElementException e) {
	        return false; //  está habilitado
	    }
	}
	
	public boolean isDisabled(By locator) {
		logger.info("Vali: " + locator);
		  return !isEnabled(locator);
	}
	
	// esperar que sea visible
    public void waitVisible(By locator) {
    	logger.info("Esperando a que se habilite: " + locator);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
    //validar si un elemento existe en el dom
    public boolean isPresent(By locator) {
    	logger.info("Verificando que este presente: " + locator);
    	return driver.findElements(locator).size()>0;
    }
    
    public String getCurrentUrl() {
	    return driver.getCurrentUrl();
	}
    
    
    public void scrollToElement(WebElement element){  //Scroll a un elemto 
    	logger.info("Haciendo scroll hacia: " + element);
        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView({block:'center'});", element);
    }
    
    public void scrollHastaElemento(By locator) {
    	logger.info("Haciendo scroll hacia: " + locator);
        WebElement element = wait.until(
            ExpectedConditions.visibilityOfElementLocated(locator)
        );

        ((JavascriptExecutor) driver)
            .executeScript("arguments[0].scrollIntoView(true);", element);
    }
    
 // Scroll infinito: hace scroll hasta el final, con espera para que cargue contenido
    public void scrollToBottomInfinite(int times, long waitMillis){
    	logger.info("Haciendo scroll infinito ");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < times; i++) {
            js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
            try { Thread.sleep(waitMillis); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }
    
    public void selectByVisibleText(By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }
    
    public void setCheckbox(By locator, boolean value) {

        WebElement checkbox = driver.findElement(locator);

        if (checkbox.isSelected() != value) {
            checkbox.click();
        }
    }
    

public void click2(By locator) {
    logger.info("Click en: " + locator);

    WebElement element = wait.until(
        ExpectedConditions.elementToBeClickable(locator)
    );

    try {
        element.click();
    } catch (org.openqa.selenium.ElementClickInterceptedException e) {
        logger.warn("Clic interceptado. Se intentará con JavaScript: " + locator);

        WebElement visibleElement = wait.until(
            ExpectedConditions.presenceOfElementLocated(locator)
        );

        ((JavascriptExecutor) driver).executeScript(
            "arguments[0].click();",
            visibleElement
        );
    }
}


	
}
