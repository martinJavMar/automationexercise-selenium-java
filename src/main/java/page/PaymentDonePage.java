package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;


public class PaymentDonePage extends BasePage {
	
	public PaymentDonePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	By mesaageCongratulations=By.xpath("//p[text()='Congratulations! Your order has been confirmed!']");
	By btnInvoice=By.cssSelector("a[href*='download_invoice']");
	By btnContinue=By.cssSelector("a[data-qa='continue-button']");
	
	
	
	public String getConfirmationMessage() {
		return getText(mesaageCongratulations);
	}
	
	public void downloadInvoice() {
		click(btnInvoice);
	}
	
	public void clickContinue() {
		click(btnContinue);
		
	}
}
