package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By carrusel= By.id("slider-carousel");
	By singupLoginBtn= By.cssSelector("a[href='/login']");
	By contacUsBtn= By.xpath("//a[@href='/contact_us']");
	By btnProducts= By.xpath("//a[@href='/products']");
	By inputEmail=By.id("susbscribe_email");
	By btnSuscribe= By.id("subscribe");
	By alertSuscribe=By.id("success-subscribe");
	By btnCart=By.xpath("(//a[@href='/view_cart'])[1]");
	By btnModalAddToCart=By.xpath("//button[contains(@class,'close-modal') and normalize-space()='Continue Shopping']");
	By btnViewCart=By.xpath("(//a[@href='/view_cart'])[2]");
	By listaProductos=By.xpath("//h2[contains(@class,'title') and normalize-space()='Features Items']");
	By btnDeleteAccount=By.cssSelector("a[href='/delete_account']");
	By btnLogout=By.cssSelector("a[href='/logout']");
	By recommendedItems=By.cssSelector(".recommended_items");
	By addRecommendedItems=By.cssSelector("#recommended-item-carousel .item.active a.add-to-cart");
	By textSubscription=By.xpath("//h2[text()='Subscription']");
	By btScrollUp=By.id("scrollUp");
	
	
	
	
	
	
	
	public By addToCartProductId(int id) {
	    return By.xpath("(//a[@data-product-id=" + id + "])[1]");
	}
	
	 public void addToCartContinueShopping(int id) {
		 click2(addToCartProductId(id));
		 click2(btnModalAddToCart);
			 
	 }
	 
	 public void addToCartViewCart(int id) {
		 click2(addToCartProductId(id));
		 click2(btnViewCart);		 
		 }

	
	public boolean carruselHome() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(carrusel));
		return isDisplayed(carrusel);
	}
	

	
	public void irLogin() {
		click(singupLoginBtn);
	}
	
	public void isContacUs() {
		click(contacUsBtn);
	}
	
	public void irProducts() {
		click(btnProducts);
	}
	
	
	public void goToCart() {
		click(btnCart);
	}
	
	
	
	
	public void subscription(String email) {
		scrollHastaElemento(inputEmail);
		type(email,inputEmail);
		click(btnSuscribe);
	}
	
	public boolean validatealertSuscription() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertSuscribe));
		return isDisplayed(alertSuscribe);
	}
	
	
	public String validateTextSuscription() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(alertSuscribe));
		return getText(alertSuscribe);
		
	}
	
	public void scrollProducts() {
		scrollHastaElemento(listaProductos);
	}
	
	public void deleteAccount() {
		click(btnDeleteAccount);
	}
	public boolean isLogoutVisible() {
	    return findElements(btnLogout).size() > 0 &&
	           findElement(btnLogout).isDisplayed();
	}
	
	public void scrollRecommendedItems() {
		
		scrollHastaElemento(recommendedItems);
	}
	
	
	public boolean isVisibleRecommendedItems() {
		return isDisplayed(recommendedItems);
	}
	
	public void addFirtsRecommendedItem() {
		click(addRecommendedItems);
		click(btnViewCart);
	}
	
	public boolean scrollToSubscriptionAndVerify() {
		scrollHastaElemento(textSubscription);
		return isDisplayed(textSubscription);
	}
	
	public void scrollUp() {
		click(btScrollUp);
	}
	
	public void scrollInicio() {
		scrollHastaElemento(carrusel);
	}
	

	

	
	

}
