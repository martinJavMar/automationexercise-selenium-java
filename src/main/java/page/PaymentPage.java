package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class PaymentPage extends BasePage {

	public PaymentPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By headingPayment=By.xpath("//h2[@class='heading' and normalize-space(.)='Payment']");
	By inputNameCart=By.cssSelector("input[data-qa='name-on-card']");
	By inputCartNumber=By.cssSelector("input[data-qa='card-number']");
	By inputCvc=By.cssSelector("input[data-qa='cvc']");
	By inputExpirationMonth=By.cssSelector("input[data-qa='expiry-month']");
	By inputExpirationYear=By.cssSelector("input[data-qa='expiry-year']");
	By btnPayConfirm=By.id("submit");
	
	public boolean  validatePage() {
		return isDisplayed(headingPayment);
	}
	
	public void enterNameCard(String name) {
		type(name, inputNameCart);
	}
	
	public void enterCardNumber(String number) {
		type(number, inputCartNumber);
	}
	
	public void enterCvc(String cvc) {
		type(cvc, inputCvc);
	}
	
	public void enterMonthExpiration(String month) {
		type(month, inputExpirationMonth);
	}
	
	public void enterYearExpiration(String year) {
		type(year, inputExpirationYear);
	}
	
	public void clickConfirmOrder() {
		click(btnPayConfirm);
	}
	
	public void payment(String name,String cardNumber,String cvc,String monthExpiration, String yearExpiration) {
		enterNameCard(name);
		enterCardNumber(cardNumber);
		enterCvc(cvc);
		enterMonthExpiration(monthExpiration);
		enterYearExpiration(yearExpiration);
		clickConfirmOrder();
	
	}
}
