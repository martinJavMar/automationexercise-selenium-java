package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;




public class LoginTests extends BaseTest  {
	
	
	@BeforeMethod
	
	public void goToLogin() {
		    homePage.irLogin();
		   
	}
	
	 
	
	
  @Test (enabled = false)
  public void validarPaginaLogin() {
	 goToLogin();
	 
	 assertTrue(loginPage.loginYourAccountVisible(),
	            "No es visible el formulario de login");
	 
  }
  
  
 
  
  @Test(enabled = false)
  public void loginExitoso() {
	  
	     goToLogin();
		 
		 loginPage.login("correo76@yopmail.com", "pruebas123");
		 
		 assertTrue(
				 loginPage.getLoggedInText().contains("Logged in as"),
				 "No se encontro el mensaje ");
	  
  }
  
  @Test (enabled = false)
  public void loginUsuarioIncorrecto() {
	  goToLogin();
	  
	 loginPage.login("usuario2@gmail.com","contraseña123");
	 
	 assertEquals(loginPage.getLoginErrorMessage(),"Your email or password is incorrect!",
			 "texto no coincide");
  }
  
  
  @Test (enabled = false)
  public void logOut() {
	  goToLogin();
	  
	  loginPage.login("correo76@yopmail.com", "pruebas123");

	  loginPage.logout();
	  
	  assertTrue(loginPage.loginYourAccountVisible(),"No es visible");
  }
  
  
  @Test
  public void registerUserExisting() {
	  goToLogin();
	  
	  loginPage.registerNewUser("prueba", "correo76@yopmail.com");
	  
	  assertEquals(loginPage.getMessageExistMail(),"Email Address already exist!",
			  "el mensaje no coincide");
  }
  
}

