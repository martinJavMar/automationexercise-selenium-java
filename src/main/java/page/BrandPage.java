package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class BrandPage extends BasePage {

	public BrandPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
    By brands=By.cssSelector(".brands-name");
    By pageProduct=By.cssSelector("li[class='active']");
	
	public By selectProduct(String product) {
		return By.cssSelector("a[href='/brand_products/" + product + "']");
	}
	
	 public boolean isVisibleBrands() {
		 return isDisplayed(brands);
	 }
	 
	 public void selectNameProduct(String product) {
		 click(selectProduct(product));
	 }
	 
	 public void getTextProduct() {
		 getText(pageProduct);
	 }
	 
	 public String getURL() {
		return getCurrentUrl();
	 }


}
