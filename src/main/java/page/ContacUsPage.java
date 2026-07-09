package page;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BasePage;

public class ContacUsPage extends BasePage {

	public ContacUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	By txtGetInTouch= By.xpath("((//h2[@class='title text-center']))[2]");
	By inputName= By.cssSelector("[data-qa='name']");
	By inputMail= By.cssSelector("[data-qa='email']");
	By inputSubject= By.cssSelector("[data-qa='subject']");
	By inputMessage= By.cssSelector("[data-qa='message']");
	By btnFile= By.xpath("//input[@name='upload_file']");
	By btnSubmit= By.cssSelector("[data-qa='submit-button']");
	By textSubmitted= By.xpath("(//div[contains(@class,'alert-success')])[1]");
	By btnHome= By.xpath("//a[@class='btn btn-success']");
	
	
	
	public boolean validateHeader() {
		return isDisplayed(txtGetInTouch);
	}
	
	
	public void  writeName(String name) {
		type(name, inputName);
	}
	
	public void writeMail(String mail) {
		type(mail, inputMail);
	}
	
	public void writeSubject(String subject) {
		type(subject, inputSubject);
	}
	
	public void writeMessage(String message) {
		type(message, inputMessage);
	}
	
	public void uploadFile(String file) {
		type(file, btnFile);
	}
	
	public void clickSubmit() {
		click(btnSubmit);
	}
	
	public Alert waitAlert() {
	    return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public boolean messageSubmitted() {
		return isDisplayed(textSubmitted);
	}
	
	public String getMessageSubmitted() {
		return getText(textSubmitted);
	}
	
	public void goHome() {
		click(btnHome);
	}
	
	

}
