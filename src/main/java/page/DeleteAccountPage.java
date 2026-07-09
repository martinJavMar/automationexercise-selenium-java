package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;

public class DeleteAccountPage extends BasePage {

	public DeleteAccountPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By messageAccountDelete=By.cssSelector("h2[data-qa='account-deleted']");
	By btnContinue=By.cssSelector("a[data-qa='continue-button']");
	
	
	public void waitForAccountDeletedMessage() {
		waitVisible(messageAccountDelete);
	}
	
	public void clickConinue() {
		click(btnContinue);
	}

}
