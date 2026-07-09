package page;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class CartPage extends BasePage {

	public CartPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By labelShoppingCart= By.xpath("//div//li[@class='active']");
	By inputMail= By.id("susbscribe_email");
	By btnSuscription= By.id("subscribe");
	By textSuscription=By.id("success-subscribe");
	By btncheckOut =By.xpath("//a[contains(@class,'check_out')]");
	By btnRegisterLogin=By.xpath("//a[@href='/login' and normalize-space()='Register / Login']");
	By btnContinueOnCart= By.xpath("//button[contains(@class,'btn') and normalize-space()='Continue On Cart']");
	
	
	
	public By btnDeleteItem(int id) {
		return By.cssSelector("a[data-product-id='" + id + "']");
	}
	
	
	
	public By priceItem(int id) {
		return By.xpath("(//td[@class='cart_price']/p)[" + id + "]");
	}
	
	public By quantyItem (int id) {
		return By.xpath("(//td[@class='cart_quantity']/button)[" + id + "]");
		
	}
	
	public By totalPrice (int id) {
		return By.xpath("(//td[@class='cart_total']/p)[" + id + "]");
	}
	
	
	

	public By nameItem(String name) {
		return By.xpath("//table//a[normalize-space()='"+ name + "']");
	}
	
	
	
	public boolean textoCartVisible() {
		 return wait.until(
			        ExpectedConditions.visibilityOfElementLocated(labelShoppingCart)
			    ).isDisplayed();
		
	}
	
	public String obtenerTextoLabelCart() {
		return getText(labelShoppingCart);
	}
	
	public void suscription(String email) {
		scrollHastaElemento(inputMail);
		clearInput(inputMail);
		type(email, inputMail);
		click(btnSuscription);
	}
	
	public boolean validateMessageSuscription() {
		return isDisplayed(textSuscription);
	}
	
	public String getTextMessageSuscription() {
		return getText(textSuscription);
	}
	
	 public boolean validateProductsCart(String name) {
		    try {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(nameItem(name)));
		        return true;
		    } catch (TimeoutException e) {
		        return false;
		    }
		}
	
	 public String getPrice (int id) {
		 return findElement(priceItem(id)).getText();
	 }
	 
	 public String getQuanty(int id) {
		 return findElement(quantyItem(id)).getText();
	 }
	
	 public String getTotal(int id) {
		 return findElement(totalPrice(id)).getText();
	 }
	 
	 public void goToCheckout() {
		 click(btncheckOut);
	 }
	 
	 public void clickContinueOnCart() {
		 click(btnContinueOnCart);
	 }
	 
	 public void clickToRegisterLogin() {
		 click(btnRegisterLogin);
	 }
	 
	 
	 public void deleteItem(int item) {
		 click(btnDeleteItem(item));
	 }
	 
	 public boolean isProductVisible(int item) {
		 return isDisplayed(btnDeleteItem(item));
	 }
	 
	 public boolean waitProductNotVisible(int item) {
		    return wait.until(
		        ExpectedConditions.invisibilityOfElementLocated(btnDeleteItem(item))
		    );
		}
	 
	 public boolean isProductRecommendationVisible(int id) {
		 return isDisplayed(quantyItem(id));
	 }
	 
	 
	

}
