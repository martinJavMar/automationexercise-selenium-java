package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTest;




public class HomeTests extends BaseTest{
 
	@BeforeMethod
	public void validandoIconoHome() {
		Assert.assertTrue(
				homePage.carruselHome(),"El logo no es visible");
	}
	
	
	
	
	@Test (enabled=false)
	public void suscripcion() {
		homePage.subscription("pruebas123@yopmail.com");
		assertTrue(homePage.validatealertSuscription(),"No es visible la alerta");
		assertEquals(homePage.validateTextSuscription(),"You have been successfully subscribed!");
		
		
	}
	
	@Test (enabled= false)
	
	public void verifyScrollUpUsingArrowButton() {
		logger.info("Haciendo scroll al final de la pagina");
		
		assertTrue(homePage.scrollToSubscriptionAndVerify(), "No se visualiza texto Suscription");
		
		logger.info("Dando click al boton que nos dirigina al inicio de la pagina");
		
		homePage.scrollUp();
		
		logger.info("Validando que estamos al inicio de la pagina");
		
		assertTrue(homePage.carruselHome(), "No es visible el carrusel");
		
		
		
	}
	
	@Test
	public void verifyScrollUpFunctionalityWithoutArrowButton() {
       logger.info("Haciendo scroll al final de la pagina");
		
		assertTrue(homePage.scrollToSubscriptionAndVerify(), "No se visualiza texto Suscription");
		
		logger.info("Haciendo scroll al inicio de la pagina");
		
		homePage.scrollInicio();
		
        logger.info("Validando que estamos al inicio de la pagina");
		
		assertTrue(homePage.carruselHome(), "No es visible el carrusel");
		
		
	}
	
  

}
