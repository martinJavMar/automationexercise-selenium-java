package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ProductsPage extends BasePage{

	public ProductsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By headingProducts=By.xpath("//h2[normalize-space()='All Products']");
	By listProducts= By.xpath("//div[@class='col-sm-9 padding-right']");
	By infoProduct1=By.xpath("//h2[contains(.,'Blue Top')]");
	By imgSaleProducts= By.id("sale_image");
	By inputSearchProducts= By.id("search_product");
	By btnSubmint=By.id("submit_search");
	By searchedProductsTitle=By.xpath("//h2[contains(text(),'Searched Products')]");
	By productResults= By.cssSelector(".productinfo p");
	By btnModalAddToCart=By.xpath("//button[contains(@class,'close-modal') and normalize-space()='Continue Shopping']");
	By btnViewCart=By.xpath("(//a[@href='/view_cart'])[2]");
	By brands=By.cssSelector(".brands-name");
	By textSearchedProducts=By.xpath("//h2[normalize-space(.)='Searched Products']");
	
	public By selectProduct(String product) {
		return By.cssSelector("a[href='/brand_products/" + product + "']");
	}
	
	
	public By producDetailId(int id) {
		return By.xpath("//a[@href='/product_details/" + id + "']");
	}
	
	public By addToCartProductId(int id) {
	    return By.xpath("(//a[@data-product-id=" + id + "])[1]");
	}
	

	public boolean imagenVisibleProducs() {
		return isDisplayed(imgSaleProducts);
	}
	
	
	public By productoPorId(int id) {
	    return By.xpath("//a[@href='/product_details/" + id + "']");
	}

	public WebElement getProducto(int id) {
	    return driver.findElement(productoPorId(id));
	}
	
	public void scroollToHeading() {
	scrollHastaElemento(headingProducts);	
	}
	
	
	public boolean headingIsVisible() {
	    return wait.until(
	        ExpectedConditions.visibilityOfElementLocated(headingProducts)
	    ).isDisplayed();
	}
	
	public String getTextHeading() {
		return getText(headingProducts);
	}
	
	public boolean visibleListProducts() {
		return isDisplayed(listProducts);
	}
	
	public boolean textProduct() {
		 return wait.until(
			        ExpectedConditions.visibilityOfElementLocated(infoProduct1)
			    ).isDisplayed();
	}
	
	public String getTextProduct1() {
		return getText(infoProduct1);
	}
	
	public void searchProduct(String product) {
		type(product,inputSearchProducts);
	}
	
	public void clickBtnSearch() {
		click2(btnSubmint);
	}
	
	 public boolean isSearchResultDisplayed() {
	        return isDisplayed(searchedProductsTitle);
    }
	 
	 public List<String> getProductNames() {
	        return findElements(productResults)
	        		.stream()
	                .map(WebElement::getText)
	                .toList();
	    }
	 
	 public void addToCartContinueShopping(int id) {
		 click2(addToCartProductId(id));
		 click2(btnModalAddToCart);
			 
	 }
	 
	 public void addToCartViewCart(int id) {
		 click2(addToCartProductId(id));
		 click2(btnViewCart);		 
		 }
	 
	 public void viewProduct(int id) {
		 click2(producDetailId(id));
	 }
	 
	
	 
	 public boolean areVisibleBrands() {
		 scrollHastaElemento(brands);	
		 return isDisplayed(brands);
	 }
	 
	 public void selectBrand(String product) {
		 click2(selectProduct(product));
	 }
	 
	 public void scrollProdusctsSearch() {
		 scrollHastaElemento(textSearchedProducts);
	 }
	 
	
	 
	

}
