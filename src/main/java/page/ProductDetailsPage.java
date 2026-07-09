package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;

public class ProductDetailsPage extends BasePage{

	public ProductDetailsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By details= By.cssSelector(".product-information");
	By quantity=By.id("quantity");
	By btnAddToCart = By.cssSelector(".btn.btn-default.cart");
	By viewCart=By.xpath("(//a[@href='/view_cart'])[2]");
	By continueShopping=By.cssSelector(".btn btn-success close-modal btn-block");
	By reviews=By.cssSelector("a[href='#reviews']");
	By inputName=By.id("name");
	By inputEmailAddress=By.id("email");
	By inputReview=By.id("review");
	By btnSubmit=By.id("button-review");
	By confirmationReviews=By.xpath("//div[contains(@class,'alert-success')]//span[normalize-space()='Thank you for your review.']");
	
	
	
	
	
	
	
	public boolean  informationProductVisible() {
		return isDisplayed(details);
	}
	
	public void enterAmount(int num) {
		clearInput(quantity);
		type(String.valueOf(num),quantity);
	}
	
	public void addToCartContinueShopping() {
		click(btnAddToCart);
		click(continueShopping);
	}
	
	public void addToCartViewCart() {
		click(btnAddToCart);
		click(viewCart);
		
	}
	
	public void enterReview(String name, String email, String review) {
		scrollHastaElemento(reviews);
		type(name, inputName);
		type(email, inputEmailAddress);
		type(review, inputReview);
		click(btnSubmit);
		
	}
	
	public String validateMessageReview() {
		return getText(confirmationReviews);
	}
	
	
	
	

}
