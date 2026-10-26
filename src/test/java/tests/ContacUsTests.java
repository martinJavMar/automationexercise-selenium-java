package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import base.BaseTest;



public class ContacUsTests extends BaseTest{
  @Test (groups = {"regression"})
  public void validarFormularioContacto() {
	  logger.info("Navegando a contato");
	  
	  homePage.isContacUs();
	  
	  logger.info("Validando pagina de contacto");
	  
	  assertTrue(contacUsPage.validateHeader(),"no es visible");
	  
	  logger.info("Registrando contacto");
	  
	  contacUsPage.writeName("marcos");
	  contacUsPage.writeMail("marin@yopmail.com");
	  contacUsPage.writeSubject("prueba");
	  contacUsPage.writeMessage("Mensaje de prueba .");
	  
	  
	  contacUsPage.uploadFile("C:\\Users\\XMF8742\\Desktop\\textfile.txt");
	  
	  contacUsPage.clickSubmit();
	  
	  Alert alert = contacUsPage.waitAlert();
	  alert.accept();
	  
	  assertTrue(contacUsPage.messageSubmitted(),"no es visible el mensaje");
	  
	  assertEquals(contacUsPage.getMessageSubmitted(),"Success! Your details have been submitted successfully."
			  , "mensaje no coincide");
	    
	 contacUsPage.goHome();
	 
	 
	 assertTrue(homePage.carruselHome(), "No es visible el carrusel");
	 
	
	  
  }
	  
  }
