package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class AccountCreatedPage extends BasePage{

	public AccountCreatedPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By accountCreated= By.cssSelector("h2[data-qa='account-created']");
	By btnContinue=By.cssSelector("a[data-qa='continue-button']");
	
	
	public boolean isPresentAccountCreated() {
		return isDisplayed(accountCreated);
	}
	
	public void continuar() {
		click(btnContinue);
	}
}
