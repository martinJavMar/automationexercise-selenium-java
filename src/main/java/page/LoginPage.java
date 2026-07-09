package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import base.BasePage;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By textoLogin= By.xpath("//h2[text()='Login to your account']");
	By inputEmail= By.cssSelector("input[data-qa='login-email']");
	By inputPass= By.cssSelector("input[data-qa='login-password']");
	By btnLogin= By.xpath("//button[text()='Login']");
	By btnLogged= By.xpath("//a[contains(.,'Logged in as')]");
	By txtUsuarioIncorrecto =By.xpath("//p[text()='Your email or password is incorrect!']");
	By btnLogout= By.xpath("//a[text()=' Logout']");
	By inputUsuario= By.cssSelector("input[data-qa='signup-name']");
	By inputEmailAddress= By.cssSelector("input[data-qa='signup-email']");
	By btnSingUp= By.xpath("//button[text()='Signup']");
	By messageExistUser= By.xpath("//p[text()='Email Address already exist!']");
	By inputName=By.cssSelector("input[data-qa='signup-name']");
	By inputEmailNewUser=By.cssSelector("input[data-qa='signup-email']");
	By btnSingnup=By.cssSelector("button[data-qa='signup-button']");
	
	
	
	
	
	public boolean loginYourAccountVisible() {
		return isDisplayed(textoLogin);
	}
	
	public void login(String email, String pass) {
		type(email, inputEmail);
		type(pass,inputPass);
		click(btnLogin);
	}
	
	public String getLoggedInText() {
    return getText(btnLogged);
	}
	
	public String getLoginErrorMessage() {
		return getText(txtUsuarioIncorrecto);
	}
	
	public void logout() {
		click(btnLogout);
	}
	
	public void registerNewUser(String user, String email ) {
		
		type(user, inputUsuario);
		type(email, inputEmailAddress);
		click(btnSingUp);
		
	}
	
	public String getMessageExistMail() {
	return getText(messageExistUser);
	}
	
	public void singUp(String name, String email) {
		type(name, inputName);
		type(email, inputEmailNewUser);
		click(btnSingnup);
		
	}
	
	
	
	
	
	
	
	
	

}
